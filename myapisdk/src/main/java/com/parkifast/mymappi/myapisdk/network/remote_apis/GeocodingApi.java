package com.parkifast.mymappi.myapisdk.network.remote_apis;

import com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api.DirectGeocodingResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api.ReverseGeocodingResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Geocoding API. This API allows translation between addresses and geographical coordinates.
 */
public interface GeocodingApi {
    /**
     * Direct geocoding API. Translates an address as input into geographic coordinates.
     * @param address       The address we want to translate into geographic coordinates
     * @return              A {@code Single} observable stream with the direct geocoding response.
     */
    @GET("geocoding/direct")
    Single<DirectGeocodingResponse> direct(@Query("q") String address);

    /**
     * Direct geocoding API. Translates an address as input into geographic coordinates. If there
     * are multiple possible results, it retrieves the list of possible results ordered by the
     * distance to the provided source coordinate (if any), in ascending order.
     *
     * @param address       The address we want to translate into geographic coordinates
     * @param source_lat    Source coordinate latitude.
     * @param source_lon    Source coordinate longitude.
     * @return              A {@code Single} observable stream with the direct geocoding response.
     */
    @GET("geocoding/direct")
    Single<DirectGeocodingResponse> direct(@Query("q") String address,
                                           @Query("source_lat") Double source_lat,
                                           @Query("source_lon") Double source_lon);

    /**
     * Reverse geocoding API. Translates a coordinate as input into its postal address.
     * @param lat           The latitude component of the coordinate.
     * @param lon           The longitude component of the coordinate.
     * @return              A {@code Single} observable stream with the reverse geocoding response.
     */
    @GET("geocoding/reverse")
    Single<ReverseGeocodingResponse> reverse(@Query("lat") Double lat,
                                             @Query("lon") Double lon);
}
