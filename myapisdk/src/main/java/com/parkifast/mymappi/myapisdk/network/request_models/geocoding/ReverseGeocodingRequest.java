package com.parkifast.mymappi.myapisdk.network.request_models.geocoding;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.request_models.common.BaseRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.directions.RouteDirectionsRequest;

public class ReverseGeocodingRequest extends BaseRequest {

    //region Attributes
    /**
     * The {@link Coordinate} we want to translate into an address.
     */
    private Coordinate coordinate;

    //endregion

    //region Getters and setters

    public Coordinate getCoordinate() {
        return coordinate;
    }


    //endregion

    //region Constructors

    /**
     * Private constructor to be used with a {@link Builder}
     */
    private ReverseGeocodingRequest(Builder builder) {
        this.coordinate = builder.coordinate;
        this.observeOnMainThread = builder.observeOnMainThread;
    }


    //endregion

    //region Exposed API

    @Override
    public String toString() {
        return "ReverseGeocodingRequest{" +
                "coordinate=" + coordinate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReverseGeocodingRequest)) return false;

        ReverseGeocodingRequest request = (ReverseGeocodingRequest) o;

        return getCoordinate().equals(request.getCoordinate());
    }

    @Override
    public int hashCode() {
        return getCoordinate().hashCode();
    }

    //endregion

    //region Inner static Builder class
    /**
     * Builder class for {@link RouteDirectionsRequest}.
     */
    public static class Builder extends BaseRequest.Builder<Builder> {

        //region Attributes
        private Coordinate coordinate;
        //endregion

        //region Setters
        /**
         * [Required] Specify the {@link Coordinate} to be used for reverse geocoding.
         * @param coordinate        The {@link Coordinate} to be used for reverse geocoding.
         * @return                  {@link ReverseGeocodingRequest.Builder} instance
         */
        public ReverseGeocodingRequest.Builder setCoordinate(Coordinate coordinate) {
            this.coordinate = coordinate;
            return this;
        }
        //endregion
        //region Builder method
        /**
         * Builds a valid instance of {@link ReverseGeocodingRequest} once all fields have been properly
         * configured. It performs the following checkings before creating the instance:
         * <ol>
         *     <li>Coordinate must be set</li>
         * </ol>
         * @return
         */
        public ReverseGeocodingRequest build() throws IllegalStateException {
            // Perform verifications
            // 1) Profile must be set
            if(coordinate == null || coordinate.isEmpty()) {
                throw new IllegalStateException("You must specify a valid coordinate to reverse " +
                        "geocode it.");
            }

            // 2) Build instance
            return new ReverseGeocodingRequest(this);
        }
        //endregion
    }
    //endregion

}
