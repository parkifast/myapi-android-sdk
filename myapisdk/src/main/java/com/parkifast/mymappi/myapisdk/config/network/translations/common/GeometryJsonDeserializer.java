package com.parkifast.mymappi.myapisdk.config.network.translations.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.parkifast.mymappi.myapisdk.data.models.common.AddressDetails;
import com.parkifast.mymappi.myapisdk.data.models.common.Geometry;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;

import javax.inject.Inject;

public class GeometryJsonDeserializer implements JsonDeserializer<Geometry> {

    @Inject
    public GeometryJsonDeserializer() {

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
    public Geometry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Determine the Geometry format to use. It can either be a polyline or geoJson.
        // If it's a polyline, then the contents of json is just a string, otherwise it will be
        // a JSON Object
        Geometry geometry = new Geometry();
        if(json.isJsonObject()) {
            // Parse as geoJSON
            JsonObject object = json.getAsJsonObject();
            // Convert into JSONObject for compatibility
            try {
                JSONObject compatibleJsonObject = new JSONObject(object.toString());
                geometry.setGeojson(compatibleJsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            // Parse as polyline
            if(json.isJsonPrimitive()) {
                geometry.setPolyline(json.getAsString());
            }
        }
        // Build and return response
        return geometry;
    }
}
