package com.parkifast.mymappi.myapisdk.network.wrappers;

import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.network.remote_apis.PlacesApi;
import com.parkifast.mymappi.myapisdk.network.request_models.places.SearchPlacesRequest;
import com.parkifast.mymappi.myapisdk.network.response_models.places_api.SearchPlacesResponse;

import javax.inject.Inject;

import io.reactivex.Single;


/**
 * Convenience wrapper for {@link PlacesApi} to easily access the suite of APIs.
 */
@AppScope
public class PlacesApiWrapper extends BaseApiWrapper {

    /**
     * {@link PlacesApi} instance to easily access the whole Places API suite.
     */
    private PlacesApi placesApi;

    @Inject
    public PlacesApiWrapper(PlacesApi placesApi) {
        this.placesApi = placesApi;
    }

    //region Exposed API
    /**
     * Parses configuration fields extracted from {@link SearchPlacesRequest} object
     * and performs the request.
     *
     * @param request       The fully configured {@link SearchPlacesRequest} instance.
     * @return              An observable stream of {@link SearchPlacesResponse}.
     */
    public Single<SearchPlacesResponse> search(SearchPlacesRequest request) {
        Single<SearchPlacesResponse> response = placesApi
                .search(
                        request.getCoordinate().getLat(),
                        request.getCoordinate().getLon(),
                        request.getRadius(),
                        request.getType(),
                        request.getNext(),
                        request.getLimit()
                );
        return assignObservableThread(response, request.observeOnMainThread);
    }
    //endregion
}
