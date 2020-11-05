package com.parkifast.mymappi.myapisdk.config.network.translations.common;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.common.RouteMatrix;

import java.lang.reflect.Type;

import javax.inject.Inject;

public class CoordinateJsonDeserializer implements JsonDeserializer<Coordinate> {

    private final String TAG = CoordinateJsonDeserializer.class.getSimpleName();

    @Inject
    public CoordinateJsonDeserializer() {

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
    public Coordinate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Extract base response parameters
        Coordinate coordinate = new Coordinate();
        try {
            if (json.isJsonObject()) {
                // Parse as model is configured (default behaviour)
                coordinate = new Coordinate(
                        json.getAsJsonObject().get("lat").getAsDouble(),
                        json.getAsJsonObject().get("lon").getAsDouble()
                );
            } else if (json.isJsonArray()) {
                // Parse as a reversed array of [lon, lat]
                coordinate = new Coordinate(
                        json.getAsJsonArray().get(1).getAsDouble(),
                        json.getAsJsonArray().get(0).getAsDouble()
                );
            }
        } catch (JsonParseException jpe) {
            Log.e(TAG, "deserialize: Unable to parse Coordinate", jpe);
            coordinate = new Coordinate();
        }
        // Return response
        return coordinate;
    }
}
