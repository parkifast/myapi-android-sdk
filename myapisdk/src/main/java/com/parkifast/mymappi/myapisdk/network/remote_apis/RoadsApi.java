package com.parkifast.mymappi.myapisdk.network.remote_apis;

import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.DistanceRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.HighwayTypeRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.NearestRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.SnapRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.SpeedLimitRoadsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Roads API. This API allows querying information about the road network.
 */
public interface RoadsApi {

    /**
     * Roads API: Snap to road. Given a geographical coordinate, it retrieves the another coordinate
     * which is snapped to the nearest road. This means that the snapped coordinate is found by
     * calculating the intersection between the longitudinal axis of the nearest road segment and
     * the perpendicular line between the provided coordinate and this longitudinal axis.
     *
     * @param lat           Latitude component of the coordinate.
     * @param lon           Longitude component of the coordinate.
     * @return              A {@code Single} observable stream with the snap to road response.
     */
    @GET("roads/snap")
    Single<SnapRoadsResponse> snap(@Query("lat") double lat, @Query("lon") double lon);

    /**
     * Roads API: Retrieve highway type.  Given a coordinate, finds the nearest road and determines
     * what type of road it is (motorway, path, primary... etc.)
     * @param lat           Latitude component of the coordinate.
     * @param lon           Longitude component of the coordinate.
     * @return              A {@code Single} observable stream with information about the type of
     *                      highway the snapped coordinate is in.
     */
    @GET("roads/highway-type")
    Single<HighwayTypeRoadsResponse> highwayType(@Query("lat") double lat, @Query("lon") double lon);


    /**
     * Roads API: Retrieve speed limit for road.  Given a coordinate, it retrieves speed limit info
     * about the nearest road segment in kilometers per hour.
     * @param lat           Latitude component of the coordinate.
     * @param lon           Longitude component of the coordinate.
     * @return              A {@code Single} observable stream with the speed limit for the nearest
     *                      road segment.
     */
    @GET("roads/speed-limit")
    Single<SpeedLimitRoadsResponse> speedLimit(@Query("lat") double lat, @Query("lon") double lon);

    /**
     * Roads API: Retrieve distance to nearest road.  Given a coordinate, it calculates the distance
     * between it and the snapped coordinate to the nearest road in meters.
     *
     * @param lat           Latitude component of the coordinate.
     * @param lon           Longitude component of the coordinate.
     * @return              A {@code Single} observable stream with the distance to the nearest road
     *                      expressed in meters.
     */
    @GET("roads/distance")
    Single<DistanceRoadsResponse> distance(@Query("lat") double lat, @Query("lon") double lon);

    /**
     * Roads API: Retrieve nearest road information.  Given a coordinate, it determines the nearest
     * road and retrieves all possible information about it.
     *
     * @param lat           Latitude component of the coordinate.
     * @param lon           Longitude component of the coordinate.
     * @return              A {@code Single} observable stream with all the information available
     *                      for the nearest road.
     */
    @GET("roads/nearest")
    Single<NearestRoadsResponse> nearest(@Query("lat") double lat, @Query("lon") double lon);
}
