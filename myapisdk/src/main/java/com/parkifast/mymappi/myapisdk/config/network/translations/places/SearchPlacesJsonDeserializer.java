package com.parkifast.mymappi.myapisdk.config.network.translations.places;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.parkifast.mymappi.myapisdk.data.models.common.OSMPlaceInfo;
import com.parkifast.mymappi.myapisdk.data.models.places.SearchPlacesResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.places_api.SearchPlacesResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class SearchPlacesJsonDeserializer implements JsonDeserializer<SearchPlacesResponse> {

    private final String TAG = SearchPlacesJsonDeserializer.class.getSimpleName();

    @Inject
    public SearchPlacesJsonDeserializer() {

    }

    /**
     * Gson invokes this call-back method during deserialization when it encounters a field of the
     * specified type.
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonDeserializationContext#deserialize(JsonElement, Type)} method to create objects
     * for any non-trivial field of the returned object. However, you should never invoke it on the
     * the same type passing {@code json} since that will cause an infinite loop (Gson will call your
     * call-back method again).
     *
     * @param json    The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @param context
     * @return a deserialized object of the specified type typeOfT which is a subclass of {@code T}
     * @throws JsonParseException if json is not in the expected format of {@code typeofT}
     */
    @Override
    public SearchPlacesResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Extract base response parameters
        String version = json.getAsJsonObject().get("version") != null ? json.getAsJsonObject().get("version").getAsString() : "";
        String provider = json.getAsJsonObject().get("provider") != null ? json.getAsJsonObject().get("provider").getAsString() : "";
        String copyright = json.getAsJsonObject().get("copyright") != null ? json.getAsJsonObject().get("copyright").getAsString() : "";
        long timestamp = json.getAsJsonObject().get("timestamp") != null ? json.getAsJsonObject().get("timestamp").getAsLong() : 0L;
        String status = json.getAsJsonObject().get("status") != null ? json.getAsJsonObject().get("status").getAsString() : BaseResponse.NO_DATA_STATUS;
        String next = "";
        // Extract data as results array
        List<SearchPlacesResult> placesResults = new ArrayList<>();
        try {
            JsonArray results = json.getAsJsonObject().get("data").getAsJsonObject()
                    .get("results").getAsJsonArray();

            for (int i = 0; i < results.size(); i++) {
                SearchPlacesResult result = buildSearchPlacesResult(results.get(i).getAsJsonObject(), context);
                if(result != null) {
                    placesResults.add(result);
                }
            }
            // Retrieve next page results token
            next = json.getAsJsonObject().get("data").getAsJsonObject().get("next") == null
                    ? ""
                    : json.getAsJsonObject().get("data").getAsJsonObject().get("next").getAsString();
        } catch (IllegalStateException ise) {
            Log.e(TAG, "deserialize: Search Places API Response was not an array. " +
                    "Error while parsing. Please check your request parameters to ensure there " +
                    "are results and check the status code to make sure what caused the error.", ise);
        } catch (NullPointerException npe) {
            Log.e(TAG, "deserialize: There was a problem while deserializing. Exiting...", npe);
        }
        // Build and return response
        return new SearchPlacesResponse(version, provider, timestamp, copyright, status, placesResults, next);
    }

    private SearchPlacesResult buildSearchPlacesResult(JsonObject item, JsonDeserializationContext context) {
        JsonObject place = item.getAsJsonObject();
        if(!place.has("tags")) {
            // Ignore results without tags data
            return null;
        }
        OSMPlaceInfo placeInfo = new OSMPlaceInfo();
        placeInfo.setOsmType(item.getAsJsonObject().get("type").getAsString());
        placeInfo.setOsmId(item.getAsJsonObject().get("id").getAsString());
        HashMap<String, String> components = context.deserialize(item.getAsJsonObject().get("tags"), HashMap.class);
        return new SearchPlacesResult(placeInfo, components);
    }
}
