package com.parkifast.mymappi.myapisdk.config.dependencies.modules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.config.network.translations.common.AddressDetailsJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.common.BoundingBoxJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.common.CoordinateJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.common.GeometryJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.common.RouteMatrixJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.directions.MatrixDirectionsJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.directions.RouteDirectionsJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.geocoding.DirectGeocodingJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.geocoding.ReverseGeocodingJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.places.SearchPlacesJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.places.SearchPlacesResultJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.roads.NearestRoadsJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.roads.SnapRoadsJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.network.translations.roads.SpeedLimitJsonDeserializer;
import com.parkifast.mymappi.myapisdk.config.serialization_strategies.DeserializationExclusionStrategy;
import com.parkifast.mymappi.myapisdk.config.serialization_strategies.SerializationExclusionStrategy;
import com.parkifast.mymappi.myapisdk.data.models.common.AddressDetails;
import com.parkifast.mymappi.myapisdk.data.models.common.BoundingBox;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.common.Geometry;
import com.parkifast.mymappi.myapisdk.data.models.common.RouteMatrix;
import com.parkifast.mymappi.myapisdk.data.models.places.SearchPlacesResult;
import com.parkifast.mymappi.myapisdk.network.response_models.directions_api.MatrixDirectionsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.directions_api.RouteDirectionsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api.DirectGeocodingResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api.ReverseGeocodingResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.places_api.SearchPlacesResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.NearestRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.SnapRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.SpeedLimitRoadsResponse;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class TranslationModule {

    /**
     * Provides GSON converter factory to be used for serialization and deserialization
     * within the {@link Retrofit} instance.
     *
     * @return      A {@link GsonConverterFactory} instance for (de)serialization.
     */
    @AppScope
    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @AppScope
    @Provides
    public Gson gson(SerializationExclusionStrategy serializationExclusionStrategy,
                     DeserializationExclusionStrategy deserializationExclusionStrategy,
                     DirectGeocodingJsonDeserializer directGeocodingJsonDeserializer,
                     ReverseGeocodingJsonDeserializer reverseGeocodingResultJsonDeserializer,
                     SnapRoadsJsonDeserializer snapRoadsJsonDeserializer,
                     SpeedLimitJsonDeserializer speedLimitJsonDeserializer,
                     NearestRoadsJsonDeserializer nearestRoadsJsonDeserializer,
                     RouteDirectionsJsonDeserializer routeDirectionsJsonDeserializer,
                     MatrixDirectionsJsonDeserializer matrixDirectionsJsonDeserializer,
                     SearchPlacesJsonDeserializer searchPlacesJsonDeserializer,
                     SearchPlacesResultJsonDeserializer searchPlacesResultJsonDeserializer,
                     CoordinateJsonDeserializer coordinateJsonDeserializer,
                     RouteMatrixJsonDeserializer routeMatrixJsonDeserializer,
                     GeometryJsonDeserializer geometryJsonDeserializer,
                     BoundingBoxJsonDeserializer boundingBoxJsonDeserializer,
                     AddressDetailsJsonDeserializer addressDetailsJsonDeserializer) {
        return new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(RouteMatrix.class, routeMatrixJsonDeserializer)
                .registerTypeAdapter(Coordinate.class, coordinateJsonDeserializer)
                .registerTypeAdapter(Geometry.class, geometryJsonDeserializer)
                .registerTypeAdapter(BoundingBox.class, boundingBoxJsonDeserializer)
                .registerTypeAdapter(AddressDetails.class, addressDetailsJsonDeserializer)
                .registerTypeAdapter(DirectGeocodingResponse.class, directGeocodingJsonDeserializer)
                .registerTypeAdapter(ReverseGeocodingResponse.class, reverseGeocodingResultJsonDeserializer)
                .registerTypeAdapter(SnapRoadsResponse.class, snapRoadsJsonDeserializer)
                .registerTypeAdapter(SpeedLimitRoadsResponse.class, speedLimitJsonDeserializer)
                .registerTypeAdapter(NearestRoadsResponse.class, nearestRoadsJsonDeserializer)
                .registerTypeAdapter(RouteDirectionsResponse.class, routeDirectionsJsonDeserializer)
                .registerTypeAdapter(MatrixDirectionsResponse.class, matrixDirectionsJsonDeserializer)
                .registerTypeAdapter(SearchPlacesResponse.class, searchPlacesJsonDeserializer)
                .registerTypeAdapter(SearchPlacesResult.class, searchPlacesResultJsonDeserializer)
                .addSerializationExclusionStrategy(serializationExclusionStrategy)
                .addDeserializationExclusionStrategy(deserializationExclusionStrategy)
                .setPrettyPrinting()
                .setDateFormat("EEE MMM dd HH:mm:ss.SSS Z yyyy")
                .create();
    }
}
