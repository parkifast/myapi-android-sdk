package com.parkifast.mymappi.myapisdk.network.wrappers;

import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.network.remote_apis.DirectionsApi;
import com.parkifast.mymappi.myapisdk.network.remote_apis.GeocodingApi;
import com.parkifast.mymappi.myapisdk.network.request_models.geocoding.DirectGeocodingRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.geocoding.ReverseGeocodingRequest;
import com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api.DirectGeocodingResponse;
import com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api.ReverseGeocodingResponse;


import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Convenience wrapper for {@link DirectionsApi} to easily access the suite of APIs.
 */
@AppScope
public class GeocodingApiWrapper extends BaseApiWrapper {

    /**
     * {@link GeocodingApi} instance to easily access the whole Geocoding API suite.
     */
    private GeocodingApi geocodingApi;

    @Inject
    public GeocodingApiWrapper(GeocodingApi geocodingApi) {
        this.geocodingApi = geocodingApi;
    }

    //region Exposed API
    /**
     * Parses configuration fields extracted from {@link *Request} object
     * and performs the request.
     *
     * @param request       The fully configured {@link DirectGeocodingRequest} instance.
     * @return              An observable stream of {@link DirectGeocodingResponse}.
     */
    public Single<DirectGeocodingResponse> direct(DirectGeocodingRequest request) {
        Single<DirectGeocodingResponse> observable = geocodingApi
                .direct(
                        request.getQuery(),
                        request.getSource().isEmpty() ? null : request.getSource().getLat(),
                        request.getSource().isEmpty() ? null : request.getSource().getLon()
                );
        return assignObservableThread(observable, request.observeOnMainThread);
    }

    /**
     * Parses configuration fields extracted from {@link *Request} object
     * and performs the request.
     *
     * @param request       The fully configured {@link DirectGeocodingRequest} instance.
     * @return              An observable stream of {@link DirectGeocodingResponse}.
     */
    public Single<ReverseGeocodingResponse> reverse(ReverseGeocodingRequest request) {
        Single<ReverseGeocodingResponse> observable = geocodingApi
                .reverse(
                        request.getCoordinate().isEmpty() ? null : request.getCoordinate().getLat(),
                        request.getCoordinate().isEmpty() ? null : request.getCoordinate().getLon()
                );
        return assignObservableThread(observable, request.observeOnMainThread);
    }



    //endregion

    //region Private helpers

    //endregion
}
