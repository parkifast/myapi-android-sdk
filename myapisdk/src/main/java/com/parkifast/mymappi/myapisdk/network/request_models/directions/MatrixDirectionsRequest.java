package com.parkifast.mymappi.myapisdk.network.request_models.directions;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.request_models.common.Profile;

import java.util.ArrayList;
import java.util.List;

public class MatrixDirectionsRequest {

    public enum Annotations {
        duration("duration"),
        distance("distance"),
        all("duration,distance");

        private String value;

        Annotations(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    //region Attributes
    /**
     * Profile used for route calculation.
     */
    private Profile profile;

    /**
     * List of indices that represent which of the {@link Coordinate} list items should be used
     * as sources in the matrix computation.
     */
    private List<Integer> sourceIndices;

    /**
     * List of indices that represent which of the {@link Coordinate} list items should be used
     * as destinations in the matrix computation.
     */
    private List<Integer> destinationIndices;

    /**
     * List of {@link Coordinate}s we want to calculate the matrix of.
     */
    private List<Coordinate> coordinates;

    /**
     * Supported matrix annotations: duration, distance or all. Any of those values can be used for
     * matrix calculation.
     */
    private Annotations annotations;

    //endregion

    //region Getters and setters

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Integer> getSourceIndices() {
        return sourceIndices;
    }

    public void setSourceIndices(List<Integer> sourceIndices) {
        this.sourceIndices = sourceIndices;
    }

    public List<Integer> getDestinationIndices() {
        return destinationIndices;
    }

    public void setDestinationIndices(List<Integer> destinationIndices) {
        this.destinationIndices = destinationIndices;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }
    //endregion

    //region Constructors

    /**
     * Private constructor to be used with a {@link Builder}
     */
    private MatrixDirectionsRequest(Builder builder) {
        this.profile = builder.profile;
        this.sourceIndices = builder.sources;
        this.destinationIndices = builder.destinations;
        this.coordinates = builder.coordinates;
        this.annotations = builder.annotations;
    }


    //endregion

    //region Exposed API
    @Override
    public String toString() {
        return "MatrixDirectionsRequest{" +
                "profile=" + profile +
                ", annotations=" + annotations.getValue() +
                ", sourceIndices=" + sourceIndices +
                ", destinationIndices=" + destinationIndices +
                ", coordinates=" + coordinates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatrixDirectionsRequest)) return false;

        MatrixDirectionsRequest that = (MatrixDirectionsRequest) o;

        if (getProfile() != that.getProfile()) return false;
        if (!getSourceIndices().equals(that.getSourceIndices())) return false;
        if (!getDestinationIndices().equals(that.getDestinationIndices())) return false;
        if (!getAnnotations().equals(that.getAnnotations())) return false;
        return getCoordinates().equals(that.getCoordinates());
    }

    @Override
    public int hashCode() {
        int result = getProfile().hashCode();
        result = 31 * result + getSourceIndices().hashCode();
        result = 31 * result + getDestinationIndices().hashCode();
        result = 31 * result + getCoordinates().hashCode();
        result = 31 * result + getAnnotations().getValue().hashCode();
        return result;
    }

    //endregion

    //region Public Helpers
    //endregion

    //region Private helpers
    //endregion
    
    //region Inner static Builder class
    /**
     * Builder class for {@link RouteDirectionsRequest}.
     */
    public static class Builder {

        //region Attributes
        private Profile profile;
        private List<Coordinate> coordinates = new ArrayList<>();
        private List<Integer> sources = new ArrayList<>();
        private List<Integer> destinations = new ArrayList<>();
        private Annotations annotations = Annotations.all;
        //endregion

        //region Setters

        /**
         * [Required] Specify the {@link Profile} to be used for route calculation.
         * @param profile       The profile to use in route calculation.
         * @return              {@link MatrixDirectionsRequest.Builder} instance
         */
        public MatrixDirectionsRequest.Builder setProfile(Profile profile) {
            this.profile = profile;
            return this;
        }

        /**
         * [Required] List of {@link Coordinate}s to calculate the matrix.
         *
         * Note: If you set this list and there were previous coordinates added individually, they
         * are going to get overwritten!
         *
         * @param coordinates       The list of {@link Coordinate}s to calculate the matrix.
         * @return                  {@link MatrixDirectionsRequest.Builder} instance
         */
        public MatrixDirectionsRequest.Builder setCoordinates(List<Coordinate> coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        /**
         * [Optional] Convenience method to append a new {@link Coordinate} entry to the list.
         *
         * @param coordinate        A new {@link Coordinate} to add to the list.
         * @return                  {@link MatrixDirectionsRequest.Builder} instance
         */
        public MatrixDirectionsRequest.Builder addCoordinate(Coordinate coordinate) {
            this.coordinates.add(coordinate);
            return this;
        }

        /**
         * [Optional] A list of indices specifying which coordinates from the list should be used
         * as sources.
         *
         * @param sources          An {@link ArrayList} of source indices as {@link Integer}s
         * @return                 {@link MatrixDirectionsRequest.Builder} instance
         */
        public MatrixDirectionsRequest.Builder setSources(List<Integer> sources) {
            this.sources = sources;
            return this;
        }

        /**
         * [Optional] Append a new source index to the list of sources.
         *
         * @param sourceIndex       A new source index to add to the list
         * @return                 {@link MatrixDirectionsRequest.Builder} instance
         */
        public MatrixDirectionsRequest.Builder addSource(int sourceIndex) {
            this.sources.add(sourceIndex);
            return this;
        }

        /**
         * [Optional] A list of indices specifying which coordinates from the list should be used
         * as sources.
         *
         * @param destinations           An {@link ArrayList} of destination indices as {@link Integer}s
         * @return                       {@link MatrixDirectionsRequest.Builder} instance
         */
        public MatrixDirectionsRequest.Builder setDestinations(List<Integer> destinations) {
            this.destinations = destinations;
            return this;
        }

        /**
         * [Optional] Append a new source index to the list of sources.
         *
         * @param destinationIndex       A new destination index to add to the list
         * @return                      {@link MatrixDirectionsRequest.Builder} instance
         */
        public MatrixDirectionsRequest.Builder addDestination(int destinationIndex) {
            this.destinations.add(destinationIndex);
            return this;
        }

        /**
         * [Optional] Annotations on what parameters to include in the matrix calculation.
         *
         * Possible values are: duration, distance or all.
         *
         * @param annotations       The annotations on how to calculate te matrix
         * @return                  {@link MatrixDirectionsRequest.Builder} instance
         */
        public MatrixDirectionsRequest.Builder setAnnotations(Annotations annotations) {
            this.annotations = annotations;
            return this;
        }


        //endregion
        //region Builder method

        /**
         * Builds a valid instance of {@link MatrixDirectionsRequest} once all fields have been properly
         * configured. It performs the following checkings before creating the instance:
         * <ol>
         *     <li>Profile must be set</li>
         *     <li>Coordinate list must have at least 2 items.</li>
         *     <li>Optional source and destination indices will be empty if unset.</li>
         * </ol>
         * @return
         */
        public MatrixDirectionsRequest build() throws IllegalStateException {
            // Perform verifications
            // 1) Profile must be set
            if(profile == null) {
                throw new IllegalStateException("You must choose a profile for the route calculation.");
            }

            // 2) Coordinate list must have at least 2 items
            if((coordinates == null || coordinates.size() < 2)) {
                throw new IllegalStateException("Coordinate list must have at least two entries in " +
                        "order to perform a matrix calculation.");
            }

            // 3) Build instance
            return new MatrixDirectionsRequest(this);
        }
        //endregion
    }
    //endregion

}
