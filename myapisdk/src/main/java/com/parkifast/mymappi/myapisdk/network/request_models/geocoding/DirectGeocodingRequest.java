package com.parkifast.mymappi.myapisdk.network.request_models.geocoding;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.request_models.common.BaseRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.directions.RouteDirectionsRequest;

public class DirectGeocodingRequest extends BaseRequest {

    //region Attributes
    /**
     * The address we want to translate into a {@link Coordinate}.
     */
    private String query;

    /**
     * Used to decide which result is better, by retrieving the one closest to the provided
     * source {@link Coordinate}
     */
    private Coordinate source;

    //endregion

    //region Getters and setters

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Coordinate getSource() {
        return source;
    }

    public void setSource(Coordinate source) {
        this.source = source;
    }
    //endregion

    //region Constructors

    /**
     * Private constructor to be used with a {@link Builder}
     */
    private DirectGeocodingRequest(Builder builder) {
        this.query = builder.query;
        this.source = builder.source;
        this.observeOnMainThread = builder.observeOnMainThread;
    }


    //endregion

    //region Exposed API

    @Override
    public String toString() {
        return "DirectGeocodingRequest{" +
                "query='" + query + '\'' +
                ", source=" + source +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectGeocodingRequest)) return false;

        DirectGeocodingRequest that = (DirectGeocodingRequest) o;

        if (!getQuery().equals(that.getQuery())) return false;
        return getSource() != null ? getSource().equals(that.getSource()) : that.getSource() == null;
    }

    @Override
    public int hashCode() {
        int result = getQuery().hashCode();
        result = 31 * result + (getSource() != null ? getSource().hashCode() : 0);
        return result;
    }

    //endregion

    //region Inner static Builder class
    /**
     * Builder class for {@link RouteDirectionsRequest}.
     */
    public static class Builder extends BaseRequest.Builder<Builder> {

        //region Attributes
        private String query = "";
        private Coordinate source = new Coordinate();
        //endregion

        //region Setters

        /**
         * [Required] The address we need to translate into a {@link Coordinate}
         * @param query         The profile to use in route calculation.
         * @return              {@link DirectGeocodingRequest.Builder} instance
         */
        public DirectGeocodingRequest.Builder setQuery(String query) {
            this.query = query;
            return this;
        }

        /**
         * [Optional] A source {@link Coordinate} to use as a filter, so that if multiple results
         * are available, they are ordered according to the distance to that source, from closer to
         * furthest.
         * @param source        A {@link Coordinate} to sort results by distance.
         * @return              {@link DirectGeocodingRequest.Builder} instance
         */
        public DirectGeocodingRequest.Builder setSource(Coordinate source) {
            this.source = source;
            return this;
        }
        //endregion
        //region Builder method

        /**
         * Builds a valid instance of {@link DirectGeocodingRequest} once all fields have been properly
         * configured. It performs the following checkings before creating the instance:
         * <ol>
         *     <li>Query must be set</li>
         * </ol>
         * @return          A fully configured {@link DirectGeocodingRequest} instance.
         */
        public DirectGeocodingRequest build() throws IllegalStateException {
            // Perform verifications
            // 1) Profile must be set
            if(query == null || query.isEmpty()) {
                throw new IllegalStateException("You must input a non-empty query in order to " +
                        "geocode it.");
            }

            // 2) Build instance
            return new DirectGeocodingRequest(this);
        }
        //endregion
    }
    //endregion

}
