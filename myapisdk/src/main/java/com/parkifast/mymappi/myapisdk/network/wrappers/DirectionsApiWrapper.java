package com.parkifast.mymappi.myapisdk.network.wrappers;

import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.remote_apis.DirectionsApi;
import com.parkifast.mymappi.myapisdk.network.request_models.directions.MatrixDirectionsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.directions.RouteDirectionsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.directions.TravelingSalesmanDirectionsRequest;
import com.parkifast.mymappi.myapisdk.network.response_models.directions_api.MatrixDirectionsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.directions_api.RouteDirectionsResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.directions_api.TravelingSalesmanDirectionsResponse;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Convenience wrapper for {@link DirectionsApi} to easily access the suite of APIs.
 */
@AppScope
public class DirectionsApiWrapper extends BaseApiWrapper {

    /**
     * {@link DirectionsApi} instance to easily access the whole Directions API suite.
     */
    private DirectionsApi directionsApi;

    @Inject
    public DirectionsApiWrapper(DirectionsApi directionsApi) {
        this.directionsApi = directionsApi;
    }

    //region Exposed API

    /**
     * Parses configuration fields extracted from {@link RouteDirectionsRequest} object
     * and performs the request.
     * @param request       The fully configured {@link RouteDirectionsRequest} instance.
     * @return              An observable stream of {@link RouteDirectionsResponse}.
     */
    public Single<RouteDirectionsResponse> calcRoute(RouteDirectionsRequest request) {
        return directionsApi.route(
                request.getProfile().toString(),
                extractOrigin(request),
                extractDestination(request),
                extractWaypoints(request),
                request.getAlternatives(),
                request.getSteps(),
                request.getGeometry().toString(),
                request.getOverview().toString()
        ).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Parses configuration fields extracted from {@link MatrixDirectionsRequest} object
     * and performs the request.
     *
     * @param request       The fully configured {@link MatrixDirectionsRequest} instance.
     * @return              An observable stream of {@link MatrixDirectionsResponse}.
     */
    public Single<MatrixDirectionsResponse> calcMatrix(MatrixDirectionsRequest request) {
        // Set to null any serializations if they are empty, so that they are not included
        // in the request as empty params.
        String sourceIndicesSerialized = request.getSourceIndices().isEmpty() ?
                null :
                serializeIndices(request.getSourceIndices());
        String destinationIndicesSerialized = request.getDestinationIndices().isEmpty() ?
                null :
                serializeIndices(request.getDestinationIndices());
        return directionsApi
                .matrix(
                        request.getProfile().toString(),
                        serializeCoordinates(request.getCoordinates()),
                        sourceIndicesSerialized,
                        destinationIndicesSerialized,
                        request.getAnnotations().getValue()
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Parses configuration fields extracted from {@link TravelingSalesmanDirectionsRequest} object
     * and performs the request.
     *
     * @param request           The fully configured {@link TravelingSalesmanDirectionsRequest}
     *                          instance.
     * @return                  An observable stream of {@link TravelingSalesmanDirectionsResponse}.
     */
    public Single<TravelingSalesmanDirectionsResponse> travelingSalesman(TravelingSalesmanDirectionsRequest request) {
        return directionsApi
                .travelingSalesman(
                        request.getProfile().toString(),
                        serializeCoordinates(request.getCoordinates()),
                        request.isRoundtrip(),
                        request.getSource().toString(),
                        request.getDestination().toString(),
                        request.includeSteps(),
                        request.getGeometry().toString(),
                        request.getOverview().toString()
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //endregion

    //region Private helpers

    /**
     * Parses the {@link RouteDirectionsRequest} object in order to retrieve the origin as a String,
     * whether it comes from a String query or from a {@link Coordinate}.
     * @param request       The fully configured {@link RouteDirectionsRequest}
     * @return              The origin formatted as a String.
     */
    private String extractOrigin(RouteDirectionsRequest request) {
        // Parse origin as query by default, unless it's empty
        String result = request.getOrigQuery();
        // If it's empty, use the Coordinate formatted as a String
        if(result.isEmpty()) {
           result = request.getOrigin().serialize();
        }
        return result;
    }

    /**
     * Parses the {@link RouteDirectionsRequest} object in order to retrieve the destination as a String,
     * whether it comes from a String query or from a {@link Coordinate}.
     * @param request       The fully configured {@link RouteDirectionsRequest}
     * @return              The destination formatted as a String.
     */
    private String extractDestination(RouteDirectionsRequest request) {
        // Parse destination as query by default, unless it's empty
        String result = request.getDestQuery();
        // If it's empty, use the Coordinate formatted as a String
        if(result.isEmpty()) {
            result = request.getDestination().serialize();
        }
        return result;
    }

    /**
     * Parses the {@link RouteDirectionsRequest} object in order to retrieve the waypoints list as a
     * String, formatted as the list of waypoints separated by semi-colons. Each waypoint might be
     * either String queries or {@link Coordinate}s.
     * @param request       The fully configured {@link RouteDirectionsRequest}
     * @return              The waypoints formatted as a semi-colon value separated String.
     */
    String extractWaypoints(RouteDirectionsRequest request) {
        StringBuilder result = new StringBuilder();
        List<String> wpQueries = request.getWaypointQueries();
        if(!wpQueries.isEmpty()) {
            // Add all first n-1 elements separated by semicolon
            for(int i = 0; i < wpQueries.size(); i++) {
                // Append query after query
                result.append(wpQueries.get(i));
                // Separate queries with semicolons, but don't add a trailing one after last item
                if(i < wpQueries.size() - 1) {
                    result.append(";");
                }
            }
        } else {
            List<Coordinate> wps = request.getWaypoints();
            if(!wps.isEmpty()) {
                // Add all first n-1 elements separated by semicolon
                for (int i = 0; i < wps.size(); i++) {
                    // Append query after query
                    result.append(wps.get(i).serialize());
                    // Separate queries with semicolons, but don't add a trailing one after last item
                    if (i < wps.size() - 1) {
                        result.append(";");
                    }
                }
            }
        }
        return result.toString();
    }

    /**
     * Given a list of {@link Coordinate}s, it outputs a String serializing each item and separating
     * them by semicolons.
     *
     * @param coordinates       The list of {@link Coordinate}s to serialize.
     * @return                  A serialized String representation of the list.
     */
    private String serializeCoordinates(List<Coordinate> coordinates) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < coordinates.size(); i++) {
            result.append(coordinates.get(i).serialize());
            // Append a semicolon separator after each item, except after the last one
            if(i < coordinates.size() - 1) {
                result.append(";");
            }
        }
        return result.toString();
    }

    /**
     * Given a list of Integer indices, it outputs a String serializing each item and separating
     * them by semicolons.
     *
     * @param indices           The list of integer indices to serialize.
     * @return                  A serialized String representation of the list.
     */
    private String serializeIndices(List<Integer> indices) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < indices.size(); i++) {
            result.append(indices.get(i));
            // Append a semicolon separator after each item, except after the last one
            if(i < indices.size() - 1) {
                result.append(";");
            }
        }
        return result.toString();
    }
    //endregion
}
