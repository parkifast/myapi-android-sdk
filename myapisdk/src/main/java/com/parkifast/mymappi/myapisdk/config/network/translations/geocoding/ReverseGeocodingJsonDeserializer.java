package com.parkifast.mymappi.myapisdk.config.network.translations.geocoding;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.common.OSMPlaceInfo;
import com.parkifast.mymappi.myapisdk.data.models.geocoding.ReverseGeocodingResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api.ReverseGeocodingResponse;

import java.lang.reflect.Type;

import javax.inject.Inject;

public class ReverseGeocodingJsonDeserializer implements JsonDeserializer<ReverseGeocodingResponse> {

    @Inject
    public ReverseGeocodingJsonDeserializer() {

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
    public ReverseGeocodingResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Extract base response parameters
        String version = json.getAsJsonObject().get("version") != null ? json.getAsJsonObject().get("version").getAsString() : "";
        String provider = json.getAsJsonObject().get("provider") != null ? json.getAsJsonObject().get("provider").getAsString() : "";
        String copyright = json.getAsJsonObject().get("copyright") != null ? json.getAsJsonObject().get("copyright").getAsString() : "";
        long timestamp = json.getAsJsonObject().get("timestamp") != null ? json.getAsJsonObject().get("timestamp").getAsLong() : 0L;
        String status = json.getAsJsonObject().get("status") != null ? json.getAsJsonObject().get("status").getAsString() : BaseResponse.NO_DATA_STATUS;

        // Build DirectGeocodingResult without complex attributes
        JsonElement data = json.getAsJsonObject().get("data");
        ReverseGeocodingResult result = context.deserialize(data, ReverseGeocodingResult.class);
        // Populate reverse geocoding result complex fields
        // Build OSMPlaceInfo and add it to result
        result.setOsmPlaceInfo(context.deserialize(data, OSMPlaceInfo.class));
        // Build Coordinate and add it to result
        result.setCoordinate(context.deserialize(data, Coordinate.class));

        // Build and return response
        return new ReverseGeocodingResponse(version, provider, timestamp, copyright, status, result);
    }
}
