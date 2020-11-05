package com.parkifast.mymappi.myapisdk.config.network.translations.places;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.parkifast.mymappi.myapisdk.data.models.common.OSMPlaceInfo;
import com.parkifast.mymappi.myapisdk.data.models.places.SearchPlacesResult;

import java.lang.reflect.Type;
import java.util.HashMap;

import javax.inject.Inject;

public class SearchPlacesResultJsonDeserializer implements JsonDeserializer<SearchPlacesResult> {

    private final String TAG = SearchPlacesResultJsonDeserializer.class.getSimpleName();

    @Inject
    public SearchPlacesResultJsonDeserializer() {

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
    public SearchPlacesResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Extract and build OSMPlaceInfo params
        OSMPlaceInfo info = new OSMPlaceInfo();
        String type = json.getAsJsonObject().get("type") != null ? json.getAsJsonObject().get("type").getAsString() : "";
        info.setOsmType(type);
        String osmId = json.getAsJsonObject().get("id") != null ? json.getAsJsonObject().get("id").getAsString() : "";
        info.setOsmId(osmId);
        // Extract place properties
        HashMap<String, String> components = new HashMap<>();
        if(json.getAsJsonObject().get("tags").isJsonObject()) {
            components = context.deserialize(json.getAsJsonObject(), HashMap.class);
        }
        // Build and return response
        return new SearchPlacesResult(info, components);
    }
}
