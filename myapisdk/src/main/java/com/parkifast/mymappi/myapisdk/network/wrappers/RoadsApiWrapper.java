package com.parkifast.mymappi.myapisdk.network.wrappers;

import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.network.remote_apis.RoadsApi;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.DistanceRoadsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.HighwayTypeRoadsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.NearestRoadsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.SnapRoadsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.SpeedLimitRoadsRequest;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.DistanceRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.HighwayTypeRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.NearestRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.SnapRoadsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.roads_api.SpeedLimitRoadsResponse;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Convenience wrapper for {@link RoadsApi} to easily access the suite of APIs.
 */
@AppScope
public class RoadsApiWrapper extends BaseApiWrapper {

    /**
     * {@link RoadsApi} instance to easily access the whole Roads API suite.
     */
    private RoadsApi roadsApi;

    @Inject
    public RoadsApiWrapper(RoadsApi roadsApi) {
        this.roadsApi = roadsApi;
    }

    //region Exposed API
    /**
     * Roads API: Snap to road. Given a geographical coordinate, it retrieves the another coordinate
     * which is snapped to the nearest road. This means that the snapped coordinate is found by
     * calculating the intersection between the longitudinal axis of the nearest road segment and
     * the perpendicular line between the provided coordinate and this longitudinal axis.
     *
     * @param request       The fully configured {@link SnapRoadsRequest} instance.
     * @return              An observable stream of {@link SnapRoadsResponse}.
     */
    public Single<SnapRoadsResponse> snap(SnapRoadsRequest request) {
        Single<SnapRoadsResponse> response = roadsApi
                .snap(
                        request.getCoordinate().getLat(),
                        request.getCoordinate().getLon()
                );
        return assignObservableThread(response, request.observeOnMainThread);
    }

    /**
     * Roads API: Retrieve highway type.  Given a coordinate, finds the nearest road and determines
     * what type of road it is (motorway, path, primary... etc.)
     *
     * @param request       The fully configured {@link HighwayTypeRoadsRequest} instance.
     * @return              An observable stream of {@link HighwayTypeRoadsResponse}.
     */
    public Single<HighwayTypeRoadsResponse> highwayType(HighwayTypeRoadsRequest request) {
        Single<HighwayTypeRoadsResponse> response = roadsApi
                .highwayType(
                        request.getCoordinate().getLat(),
                        request.getCoordinate().getLon()
                );
        return assignObservableThread(response, request.observeOnMainThread);
    }

    /**
     * Roads API: Retrieve speed limit for road.  Given a coordinate, it retrieves speed limit info
     * about the nearest road segment.
     *
     * @param request       The fully configured {@link SpeedLimitRoadsRequest} instance.
     * @return              An observable stream of {@link SpeedLimitRoadsResponse}.
     */
    public Single<SpeedLimitRoadsResponse> speedLimit(SpeedLimitRoadsRequest request) {
        Single<SpeedLimitRoadsResponse> response = roadsApi
                .speedLimit(
                        request.getCoordinate().getLat(),
                        request.getCoordinate().getLon()
                );
        return assignObservableThread(response, request.observeOnMainThread);
    }

    /**
     * Roads API: Retrieve distance to nearest road.  Given a coordinate, it calculates the distance
     * between it and the snapped coordinate to the nearest road in meters.
     *
     * @param request       The fully configured {@link DistanceRoadsResponse} instance.
     * @return              An observable stream of {@link DistanceRoadsResponse}.
     */
    public Single<DistanceRoadsResponse> distance(DistanceRoadsRequest request) {
        Single<DistanceRoadsResponse> response = roadsApi
                .distance(
                        request.getCoordinate().getLat(),
                        request.getCoordinate().getLon()
                );
        return assignObservableThread(response, request.observeOnMainThread);
    }

    /**
     * Roads API: Retrieve nearest road information.  Given a coordinate, it determines the nearest
     * road and retrieves all possible information about it.
     *
     * @param request       The fully configured {@link NearestRoadsResponse} instance.
     * @return              An observable stream of {@link NearestRoadsRequest}.
     */
    public Single<NearestRoadsResponse> nearest(NearestRoadsRequest request) {
        Single<NearestRoadsResponse> response = roadsApi
                .nearest(
                        request.getCoordinate().getLat(),
                        request.getCoordinate().getLon()
                );
        return assignObservableThread(response, request.observeOnMainThread);
    }
    //endregion
}
