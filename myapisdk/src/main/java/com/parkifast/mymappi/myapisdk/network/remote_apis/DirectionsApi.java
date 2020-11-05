package com.parkifast.mymappi.myapisdk.network.remote_apis;

import com.parkifast.mymappi.myapisdk.network.response_models.directions_api.MatrixDirectionsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.directions_api.RouteDirectionsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.directions_api.TravelingSalesmanDirectionsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Directions API. This API allows route calculations on different profiles (car, pedestrian, bike...)
 */
public interface DirectionsApi {

    /**
     * Directions API - Route Calculation Service: Calculates a route between an origin and
     * a destination, possibly passing through many waypoints. It takes into consideration
     * several configuration options in order to customize the response.
     *
     * @param profile       The profile used to calculate the route, such as car, on_foot
     *                      or bicycle
     * @param orig          Origin of the route
     * @param dest          Destination of the route
     * @param waypoints     Intermediate stops along the route
     * @param alternatives  Request alternative routes, if possible
     * @param steps         Indicate steps along the route
     * @param geometry      Format in which to output the route representation
     * @param overview      How detailed the route representation should be
     * @return              An observable with the {@link RouteDirectionsResponse}.
     */
    @GET("directions/route/{profile}")
    Single<RouteDirectionsResponse> route(@Path("profile")          String profile,
                                          @Query("orig")            String orig,
                                          @Query("dest")            String dest,
                                          @Query("wps")             String waypoints,
                                          @Query("alternatives")    boolean alternatives,
                                          @Query("steps")           boolean steps,
                                          @Query("geometries")      String geometry,
                                          @Query("overview")        String overview
    );

    /**
     * Directions API: Time Matrix Service. This services takes as input a list of coordinates
     * and computes in a matrix format the fastest travel time among all possible pair combinations
     * among all the provided coordinates. If sources/destinations params are provided, those
     * indicate a semi-colon separated list of indices that specify which of the provided coordinates
     * should be included as sources or destinations.
     *
     * @param profile               The profile used to calculate the route, such as car, on_foot
     *                              or bicycle
     * @param coordinateList        Semi-colon separated values indicating all the coordinates to use
     * @param sourceIndices         Semi-colon separated values indicating the indices of those
     *                              coordinates from the list that should be used as sources. By
     *                              default, if not provided, all coordinates will be used as
     *                              sources.
     * @param destinationIndices    Semi-colon separated values indicating the indices of those
     *                              coordinates from the list that should be used as destinations.
     *                              By default, if not provided, all coordinates will be used as
     *                              destinations.
     * @param annotations           Possible values: 'duration', 'distance', 'duration,distance'
     * @return                      A {@link MatrixDirectionsResponse} including the list of sources
     *                              , destinations and the travel time matrix among all combinations.
     */
    @GET("directions/matrix/{profile}/{coordinates}")
    Single<MatrixDirectionsResponse> matrix(@Path("profile")             String profile,
                                           @Path("coordinates")          String coordinateList,
                                           @Query("sources")             String sourceIndices,
                                           @Query("destinations")        String destinationIndices,
                                           @Query("annotations")         String annotations
    );

    /**
     * Directions API - Traveling Salesman Problem Resolution Service: It solves the
     * Traveling Salesman Problem using a greedy heuristic (farthest-insertion algorithm) for 10 or
     * more waypoints and uses brute force for less than 10 waypoints. The returned path does not
     * have to be the fastest path. As TSP is NP-hard it only returns an approximation.
     * Note that all input coordinates have to be connected for this service to work.
     *
     * @param profile               The profile used to calculate the route, such as car,
     *                              on_foot or bicycle
     * @param roundtrip             Return route is a roundtrip (route returns to first location).
     *                              Possible values are: true (default) or false.
     * @param source                Return route starts at "any" or "first" coordinate.
     *                              Possible values are: "any" (default) or "first".
     * @param destination           Return route ends at "any" or "last" coordinate
     * @param coordinateList        Semi-colon separated values indicating all the coordinates to use
     * @param steps                 Indicate steps along the route
     * @param geometry              Format in which to output the route representation
     * @param overview              How detailed the route representation should be
     * @return                      An observable with the {@link TravelingSalesmanDirectionsResponse}.
     */
    @GET("directions/traveling-salesman/{profile}/{coordinates}")
    Single<TravelingSalesmanDirectionsResponse> travelingSalesman(
                                          @Path("profile")          String profile,
                                          @Path("coordinates")      String coordinateList,
                                          @Query("roundtrip")       boolean roundtrip,
                                          @Query("source")          String source,
                                          @Query("destination")     String destination,
                                          @Query("steps")           boolean steps,
                                          @Query("geometries")      String geometry,
                                          @Query("overview")        String overview
    );

}
