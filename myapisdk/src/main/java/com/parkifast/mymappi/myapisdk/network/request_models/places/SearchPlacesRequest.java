package com.parkifast.mymappi.myapisdk.network.request_models.places;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.request_models.common.BaseRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.common.PlaceType;

public class SearchPlacesRequest extends BaseRequest {

    //region Attributes
    /**
     * The {@link Coordinate} we want to translate into an address.
     */
    private Coordinate coordinate;
    /**
     * Search radius, in meters.
     */
    private int radius;

    /**
     * Place type to filter response.
     */
    private String type;

    /**
     * Next results page token.
     */
    private String next;

    /**
     * Effectively limits the amount of results that will be retrieved. When used, no pagination
     * will be used, and as many as this limit value number of results will be retrieved, if there
     * are as many.
     */
    private int limit;

    //endregion

    //region Getters and setters
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    //endregion

    //region Constructors

    /**
     * Private constructor to be used with a {@link Builder}
     */
    private SearchPlacesRequest(Builder builder) {
        this.coordinate = builder.coordinate;
        this.radius = builder.radius;
        this.type = builder.type;
        this.observeOnMainThread = builder.observeOnMainThread;
        this.next = builder.next;
        this.limit = builder.limit;
    }
    //endregion
    //region Exposed API
    /**
     * String representation of current instance.
     * @return          Readable String representing this instance.
     */
    @Override
    public String toString() {
        return "SearchPlacesRequest{" +
                "coordinate=" + coordinate +
                ", radius=" + radius +
                ", type='" + type + '\'' +
                ", next='" + next + '\'' +
                ", limit=" + limit +
                ", observeOnMainThread=" + observeOnMainThread +
                '}';
    }

    /**
     * Compares two instances.
     * @param o         Another instance to compare to.
     * @return          {@code true} when all values are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchPlacesRequest)) return false;

        SearchPlacesRequest that = (SearchPlacesRequest) o;

        if (getRadius() != that.getRadius()) return false;
        if (getLimit() != that.getLimit()) return false;
        if (!getCoordinate().equals(that.getCoordinate())) return false;
        if (!getType().equals(that.getType())) return false;
        return getNext().equals(that.getNext());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        int result = getCoordinate().hashCode();
        result = 31 * result + getRadius();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getNext().hashCode();
        result = 31 * result + getLimit();
        return result;
    }
    //endregion

    //region Inner static Builder class
    /**
     * Builder class for {@link SearchPlacesRequest}.
     */
    public static class Builder extends BaseRequest.Builder<Builder> {

        //region Attributes
        private Coordinate coordinate = new Coordinate();
        private int radius = 0;
        private String type = "";
        private String next = "";
        private Integer limit = 25;
        //endregion

        //region Setters
        /**
         * [Required] Specify the {@link Coordinate} to be used in the search.
         * @param coordinate        The {@link Coordinate} to be used in the places search.
         * @return                  {@link SearchPlacesRequest.Builder} instance
         */
        public SearchPlacesRequest.Builder setCoordinate(Coordinate coordinate) {
            this.coordinate = coordinate;
            return this;
        }

        /**
         * [Required] Specify the radius to be used in the search.
         * @param radius            The radius, in integer meters (higher than 0) to be used in
         *                          the places search.
         * @return                  {@link SearchPlacesRequest.Builder} instance
         */
        public SearchPlacesRequest.Builder setRadius(int radius) {
            this.radius = radius;
            return this;
        }

        /**
         * [Optional] Specify the token to retrieve the next set of results.
         * @param next              A token that allows access to the next set of results.
         * @return                  {@link SearchPlacesRequest.Builder} instance
         */
        public SearchPlacesRequest.Builder setNext(String next) {
            this.next = next;
            return this;
        }

        /**
         * [Optional] Specify a limit to the max number of results that will be retrieved at once.
         * The absolute maximum is set to 250 results. Keep in mind, that this request will be charged
         * according to our transaction scheme, which on the day of writing this documentation,
         * was set per sets of 25 results, so if you specify a limit of 250 results, it will be
         * charged as 10 times as many transactions as one without this parameter (which would
         * return 25 results by default, paginated). You will only be charged that amount if there
         * actually are 250 results, otherwise you will be charged by calculating the exact number of
         * results retrieved, regardless of the specified limit value.
         *
         * @param limit              The max number of results that should be retrieved.
         * @return                  {@link SearchPlacesRequest.Builder} instance
         */
        public SearchPlacesRequest.Builder setLimit(int limit) {
            this.limit = limit;
            return this;
        }
        /**
         * [Optional] Specify a {@link PlaceType} to filter out the results. Check the documentation
         * of {@link PlaceType} to see a list of all officially supported types.
         * @param placeType         A {@link PlaceType} to filter out the results.
         * @return                  {@link SearchPlacesRequest.Builder} instance
         */
        public SearchPlacesRequest.Builder setType(PlaceType placeType) {
            this.type = placeType.toString();
            return this;
        }

        /**
         * [Optional] Specify a place type to filter out the results.
         * [WARNING!] This method should not be used, use it at your own discretion. It's better to
         * use the {@code setType(PlaceType placeType)} method to ensure you are using a supported
         * place type. Please read the documentation of {@link PlaceType} to see all officially
         * supported types.
         *
         * However, we might implement new supported place types without a new version release,
         * so this method allows you to use types not included in the current version
         * {@link PlaceType} implementation. If you use an invalid type you will waste a request
         * that will have no results and the corresponding transactions will be subtracted from your
         * quota. Use this method at your own discretion. If you have doubts or any problem related
         * to this issue you can hit our support team through your dashboard.
         *
         * @param placeType         A {@link PlaceType} to filter out the results.
         * @return                  {@link SearchPlacesRequest.Builder} instance
         */
        public SearchPlacesRequest.Builder setType(String placeType) {
            this.type = placeType;
            return this;
        }
        //endregion
        //region Builder method
        /**
         * Builds a valid instance of {@link SearchPlacesRequest} once all fields have been properly
         * configured. It performs the following checkings before creating the instance:
         * <ol>
         *     <li>Coordinate must be set</li>
         *     <li>Radius must be a positive integer value</li>
         *     <li>If place type is not set, set it to null to avoid sending the parameter empty</li>
         *     <li>If next param is not set, set it to null to avoid sending the parameter empty</li>
         *     <li>
         *         If limit param is not set, set it to null to avoid sending the parameter empty.
         *         It will automatically take the default value on our server.
         *     </li>
         *     <li>If limit param is over 250, raise an exception.</li>
         * </ol>
         * @return
         */
        public SearchPlacesRequest build() throws IllegalStateException {
            // Perform verifications
            // 1) Coordinate must be set
            if(coordinate == null || coordinate.isEmpty()) {
                throw new IllegalStateException("You must specify a valid coordinate to search " +
                        "around it.");
            }

            // 2) Radius must be set to a positive integer value
            if(radius <= 0) {
                throw new IllegalStateException("Please specify a valid radius value, in meters.");
            }

            // 3) If type is not specified, set it to null to avoid sending it empty as a url param
            if(type == null || type.isEmpty()) {
                type = null;
            }

            // 4) If next token is not specified, set it to null to avoid sending it empty as a
            // --> url param
            if(next == null || next.isEmpty()) {
                next = null;
            }

            // 4) If next token is not specified, set it to null to avoid sending it empty as a
            // --> url param
            if(next == null || next.isEmpty()) {
                next = null;
            }

            // 5) If limit value is not specified, set it to null to avoid sending it empty as param
            if(limit == null || limit == 0 ) {
                limit = null;
            }

            // 6) Raise exception if limit param is out of the permitted range of values (1-250)
            if(limit != null && (limit < 0 || limit > 250)) {
                throw new IllegalStateException("Limit parameter must be between 1-250.");
            }
            // 7) Build instance
            return new SearchPlacesRequest(this);
        }
        //endregion
    }
    //endregion

}
