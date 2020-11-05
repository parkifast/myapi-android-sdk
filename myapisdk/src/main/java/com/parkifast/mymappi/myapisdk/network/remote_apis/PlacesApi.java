package com.parkifast.mymappi.myapisdk.network.remote_apis;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.response_models.places_api.SearchPlacesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Places API. This API allows querying for points of interest around a specific set of coordinates.
 */
public interface PlacesApi {

    /**
     * Places API - Search. Searches around a set of {@link Coordinate}s within a certain radius (in meters)
     * to retrieve a list of nearby points of interest of a specific type (optionally).
     *
     * @param lat           Latitude.
     * @param lon           Longitude.
     * @param radius        Radius of search in meters.
     * @param type          The specific type of point of interest (optional).
     * @param next          A next page results token (optional).
     * @param limit         The max number of results that should be retrieved (default 25, max 250)
     *                      (optional).
     * @return              A {@link Single<SearchPlacesResponse>} observable stream with the
     *                      response.
     */
    @GET("places/search")
    Single<SearchPlacesResponse> search(@Query("lat") Double lat,
                                        @Query("lon") Double lon,
                                        @Query("radius") Integer radius,
                                        @Query("type") String type,
                                        @Query("next") String next,
                                        @Query("limit") Integer limit
    );

}
