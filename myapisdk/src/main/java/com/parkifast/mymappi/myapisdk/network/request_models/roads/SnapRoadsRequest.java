package com.parkifast.mymappi.myapisdk.network.request_models.roads;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.request_models.common.BaseRequest;

public class SnapRoadsRequest extends BaseRequest {

    //region Attributes
    /**
     * The {@link Coordinate} we want to snap to nearest road.
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
    private SnapRoadsRequest(Builder builder) {
        this.coordinate = builder.coordinate;
        this.observeOnMainThread = builder.observeOnMainThread;
    }


    //endregion

    //region Exposed API


    /**
     * String representation of the request.
     * @return          String representation of the request.
     */
    @Override
    public String toString() {
        return "SnapRoadsRequest{" +
                "coordinate=" + coordinate +
                ", observeOnMainThread=" + observeOnMainThread +
                '}';
    }



    /**
     * Compares two instances.
     * @param o         Another instance to compare to.
     * @return          {@code true} when all values are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SnapRoadsRequest)) return false;

        SnapRoadsRequest that = (SnapRoadsRequest) o;

        return getCoordinate().equals(that.getCoordinate());
    }

    /**
     * Hashing algorithm
     * @return      Uniquely identify current instance with a hash.
     */
    @Override
    public int hashCode() {
        return getCoordinate().hashCode();
    }

    //endregion

    //region Inner static Builder class
    /**
     * Builder class for {@link SnapRoadsRequest}.
     */
    public static class Builder extends BaseRequest.Builder<Builder> {

        //region Attributes
        private Coordinate coordinate;
        //endregion

        //region Setters
        /**
         * [Required] Specify the {@link Coordinate} to be snapped to the road network.
         * @param coordinate        The {@link Coordinate} to be used for road snapping.
         * @return                  {@link SnapRoadsRequest.Builder} instance
         */
        public SnapRoadsRequest.Builder setCoordinate(Coordinate coordinate) {
            this.coordinate = coordinate;
            return this;
        }
        //endregion
        //region Builder method
        /**
         * Builds a valid instance of {@link SnapRoadsRequest} once all fields have been properly
         * configured. It performs the following checkings before creating the instance:
         * <ol>
         *     <li>Coordinate must be set</li>
         * </ol>
         * @return
         */
        public SnapRoadsRequest build() throws IllegalStateException {
            // Perform verifications
            // 1) Profile must be set
            if(coordinate == null || coordinate.isEmpty()) {
                throw new IllegalStateException("You must specify a valid coordinate.");
            }

            // 2) Build instance
            return new SnapRoadsRequest(this);
        }
        //endregion
    }
    //endregion

}
