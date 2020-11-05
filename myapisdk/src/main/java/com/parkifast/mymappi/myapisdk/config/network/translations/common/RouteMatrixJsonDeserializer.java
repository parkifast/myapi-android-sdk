package com.parkifast.mymappi.myapisdk.config.network.translations.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.parkifast.mymappi.myapisdk.data.models.common.AddressDetails;
import com.parkifast.mymappi.myapisdk.data.models.common.RouteMatrix;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class RouteMatrixJsonDeserializer implements JsonDeserializer<RouteMatrix> {

    @Inject
    public RouteMatrixJsonDeserializer() {

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
    public RouteMatrix deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Extract base response parameters
        List<List<Double>> routeMatrix = new ArrayList<>();
        if(json.isJsonArray()) {
            // Loop through rows
            for(JsonElement row: json.getAsJsonArray()) {
                List<Double> matrixColumns = new ArrayList<>();
                // Loop through columns
                for(JsonElement col: row.getAsJsonArray()) {
                    matrixColumns.add(col.getAsDouble());
                }
                routeMatrix.add(matrixColumns);
            }
        }
        // Build and return response
        return new RouteMatrix(routeMatrix);
    }
}
