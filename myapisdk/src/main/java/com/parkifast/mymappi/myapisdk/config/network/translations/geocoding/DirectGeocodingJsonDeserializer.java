package com.parkifast.mymappi.myapisdk.config.network.translations.geocoding;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.common.OSMPlaceInfo;
import com.parkifast.mymappi.myapisdk.data.models.geocoding.DirectGeocodingResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api.DirectGeocodingResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DirectGeocodingJsonDeserializer implements JsonDeserializer<DirectGeocodingResponse> {

    @Inject
    public DirectGeocodingJsonDeserializer() {

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
    public DirectGeocodingResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Extract base response parameters
        String version = json.getAsJsonObject().get("version") != null ? json.getAsJsonObject().get("version").getAsString() : "";
        String provider = json.getAsJsonObject().get("provider") != null ? json.getAsJsonObject().get("provider").getAsString() : "";
        String copyright = json.getAsJsonObject().get("copyright") != null ? json.getAsJsonObject().get("copyright").getAsString() : "";
        long timestamp = json.getAsJsonObject().get("timestamp") != null ? json.getAsJsonObject().get("timestamp").getAsLong() : 0L;
        String status = json.getAsJsonObject().get("status") != null ? json.getAsJsonObject().get("status").getAsString() : BaseResponse.NO_DATA_STATUS;

        // Extract data as results array
        JsonArray elements = json.getAsJsonObject().get("data").getAsJsonArray();
        // Init empty geocoding results list
        List<DirectGeocodingResult> results = new ArrayList<>();
        // Populate geocoding results
        for(JsonElement element: elements) {
            // Build DirectGeocodingResult without complex attributes
            DirectGeocodingResult result = context.deserialize(element, DirectGeocodingResult.class);
            // Build OSMPlaceInfo and add it to result
            result.setOsmPlaceInfo(context.deserialize(element, OSMPlaceInfo.class));
            // Build Coordinate and add it to result
            result.setCoordinate(context.deserialize(element, Coordinate.class));
            // Add current result to full results list
            results.add(result);
        }
        // Build and return response
        return new DirectGeocodingResponse(version, provider, timestamp, copyright, status, results);
    }
}
