package com.parkifast.mymappi.myapisdk.config.network.translations.roads;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.parkifast.mymappi.myapisdk.data.models.roads.NearestRoadsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.NearestRoadsResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class NearestRoadsJsonDeserializer implements JsonDeserializer<NearestRoadsResponse> {

    private final String TAG = NearestRoadsJsonDeserializer.class.getSimpleName();

    @Inject
    public NearestRoadsJsonDeserializer() {

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
    public NearestRoadsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Extract base response parameters
        String version = json.getAsJsonObject().get("version") != null ? json.getAsJsonObject().get("version").getAsString() : "";
        String provider = json.getAsJsonObject().get("provider") != null ? json.getAsJsonObject().get("provider").getAsString() : "";
        String copyright = json.getAsJsonObject().get("copyright") != null ? json.getAsJsonObject().get("copyright").getAsString() : "";
        long timestamp = json.getAsJsonObject().get("timestamp") != null ? json.getAsJsonObject().get("timestamp").getAsLong() : 0L;
        String status = json.getAsJsonObject().get("status") != null ? json.getAsJsonObject().get("status").getAsString() : BaseResponse.NO_DATA_STATUS;

        List<NearestRoadsResult> results = new ArrayList<>();

        try {
            JsonArray data = json.getAsJsonObject().get("data").getAsJsonArray();
            for(int i = 0; i < data.size(); i++) {
                // Extract data as results array
                HashMap<String, Object> components = context.deserialize(
                        data.get(i),
                        HashMap.class
                );
                NearestRoadsResult result = new NearestRoadsResult(components);
                results.add(result);
            }
        } catch (Exception e) {
            Log.e(TAG, "deserialize: Unable to deserialize, response model doesn't fit the " +
                    "model due to errors.", e);
        }

        // Build and return response
        return new NearestRoadsResponse(version, provider, timestamp, copyright, status, results);
    }
}
