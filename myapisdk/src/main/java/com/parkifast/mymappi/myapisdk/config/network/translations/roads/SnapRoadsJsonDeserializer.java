package com.parkifast.mymappi.myapisdk.config.network.translations.roads;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.roads.SnapRoadsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.SnapRoadsResponse;

import java.lang.reflect.Type;

import javax.inject.Inject;

public class SnapRoadsJsonDeserializer implements JsonDeserializer<SnapRoadsResponse> {

    private static final String TAG = SnapRoadsJsonDeserializer.class.getSimpleName();

    @Inject
    public SnapRoadsJsonDeserializer() {

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
    public SnapRoadsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Extract base response parameters
        String version = json.getAsJsonObject().get("version") != null ? json.getAsJsonObject().get("version").getAsString() : "";
        String provider = json.getAsJsonObject().get("provider") != null ? json.getAsJsonObject().get("provider").getAsString() : "";
        String copyright = json.getAsJsonObject().get("copyright") != null ? json.getAsJsonObject().get("copyright").getAsString() : "";
        long timestamp = json.getAsJsonObject().get("timestamp") != null ? json.getAsJsonObject().get("timestamp").getAsLong() : 0L;
        String status = json.getAsJsonObject().get("status") != null ? json.getAsJsonObject().get("status").getAsString() : BaseResponse.NO_DATA_STATUS;

        SnapRoadsResult result = new SnapRoadsResult();
        try {
            JsonObject data = json.getAsJsonObject().get("data").getAsJsonObject();
            // Extract coordinate
            result.setCoordinate(context.deserialize(data, Coordinate.class));
        } catch (Exception e) {
            Log.e(TAG, "deserialize: Unable to deserialize, response model doesn't fit the model due to errors.", e);
        }
        // Build and return response
        return new SnapRoadsResponse(version, provider, timestamp, copyright, status, result);
    }
}
