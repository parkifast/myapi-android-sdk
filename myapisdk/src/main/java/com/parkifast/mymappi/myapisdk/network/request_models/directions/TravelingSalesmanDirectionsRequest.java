package com.parkifast.mymappi.myapisdk.network.request_models.directions;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.request_models.common.Geometry;
import com.parkifast.mymappi.myapisdk.network.request_models.common.Overview;
import com.parkifast.mymappi.myapisdk.network.request_models.common.Profile;

import java.util.ArrayList;
import java.util.List;

import static com.parkifast.mymappi.myapisdk.network.request_models.common.Geometry.polyline;
import static com.parkifast.mymappi.myapisdk.network.request_models.common.Overview.simplified;

public class TravelingSalesmanDirectionsRequest {

    public enum Source {
        any,
        first
    }

    public enum Destination {
        any,
        last
    }

    //region Attributes
    /**
     * Profile used for route calculation.
     */
    private Profile profile;

    /**
     * The list of locations the route should pass by.
     */
    private List<Coordinate> coordinates;

    /**
     * Return route is a roundtrip (route returns to first location).
     */
    private boolean roundtrip;

    /**
     * Return route starts at "any" or "first" coordinate. Any is the default value.
     */
    private Source source;

    /**
     * Return route ends at "any" or "last" coordinate. Any is the default value.
     */
    private Destination destination;

    /**
     * Whether to include the full route steps or not in the response. Default behaviour is set to
     * {@code true}.
     */
    private boolean steps;

    /**
     * What type of format should be used to represent the full route. Three options supported:
     * encoded polyline (polyline), encoded polyline v6 (polyline6) or geoJson (geo_json).
     */
    private Geometry geometry;

    /**
     * How detailed the route geometry should be (full, simplified or none).
     */
    private Overview overview;

    //endregion

    //region Getters

    public Profile getProfile() {
        return profile;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public boolean isRoundtrip() {
        return roundtrip;
    }

    public Source getSource() {
        return source;
    }

    public Destination getDestination() {
        return destination;
    }

    public boolean includeSteps() {
        return steps;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public Overview getOverview() {
        return overview;
    }

    //endregion

    //region Constructors

    /**
     * Private constructor via {@link Builder}.
     * @param builder           Fully configured builder.
     */
    private TravelingSalesmanDirectionsRequest(Builder builder) {
        this.profile = builder.profile;
        this.coordinates = builder.coordinates;
        this.roundtrip = builder.roundtrip;
        this.source = builder.source;
        this.destination = builder.destination;
        this.steps = builder.steps;
        this.geometry = builder.geometry;
        this.overview = builder.overview;
    }
    //endregion

    //region Inner static Builder class
    /**
     * Builder class for {@link TravelingSalesmanDirectionsRequest}.
     */
    public static class Builder {

        //region Attributes
        private Profile profile;
        private List<Coordinate> coordinates = new ArrayList<>();
        private boolean roundtrip = true;
        private Source source = Source.any;
        private Destination destination = Destination.any;
        private boolean steps = true;
        private Geometry geometry = polyline;
        private Overview overview = simplified;
        //endregion

        //region Setters

        /**
         * [Required] Specify the {@link Profile} to be used for route calculation.
         * @param profile       The profile to use in route calculation.
         * @return              {@link TravelingSalesmanDirectionsRequest.Builder} instance
         */
        public TravelingSalesmanDirectionsRequest.Builder setProfile(Profile profile) {
            this.profile = profile;
            return this;
        }

        /**
         * [Required] A list of {@link Coordinate}s the route should pass by. Check the pricing FAQ
         * for further information on coordinates size limit, since depending on how many you input it
         * will be charged as a different number of transactions.
         *
         * @param coordinates         An {@link ArrayList} of {@link Coordinate}s
         * @return                  {@link TravelingSalesmanDirectionsRequest.Builder} instance
         */
        public TravelingSalesmanDirectionsRequest.Builder setCoordinates(List<Coordinate> coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        /**
         * [Optional] Convenience method to append a new {@link Coordinate} entry to the list.
         *
         * @param coordinate        A new {@link Coordinate} to add to the list.
         * @return                  {@link TravelingSalesmanDirectionsRequest.Builder} instance
         */
        public TravelingSalesmanDirectionsRequest.Builder addCoordinate(Coordinate coordinate) {
            this.coordinates.add(coordinate);
            return this;
        }

        /**
         * [Optional] Return route is a roundtrip (route returns to first location). Default value
         * is {@code true}.
         *
         * @param roundTrip         {@code true} when route should come back to source.
         * @return                  {@link TravelingSalesmanDirectionsRequest.Builder} instance
         */
        public TravelingSalesmanDirectionsRequest.Builder setRoundTrip(boolean roundTrip) {
            this.roundtrip = roundTrip;
            return this;
        }

        /**
         * [Optional] Whether the route should start wherever it's best or at the first
         *  {@link Coordinate} from the list. Default value is {@code any}
         *
         * @param source            The origin of the route as a {@link Coordinate}
         * @return                  {@link TravelingSalesmanDirectionsRequest.Builder} instance
         */
        public TravelingSalesmanDirectionsRequest.Builder setSource(Source source) {
            this.source = source;
            return this;
        }

        /**
         * [Optional] Whether the route should end wherever it's best or at the last
         * {@link Coordinate} from the list. Default value is {@code any}
         *
         * @param destination       The destination of the route as a {@link Coordinate}
         * @return                  {@link TravelingSalesmanDirectionsRequest.Builder} instance
         */
        public TravelingSalesmanDirectionsRequest.Builder setDestination(Destination destination) {
            this.destination = destination;
            return this;
        }

        /**
         * [Optional] Specify whether the route should include step by step information or not.
         * [Default: true]
         * @param steps             {@code} true when steps should be retrieved as well.
         * @return                  {@link TravelingSalesmanDirectionsRequest.Builder} instance
         */
        public TravelingSalesmanDirectionsRequest.Builder includeSteps(boolean steps) {
            this.steps = steps;
            return this;
        }

        /**
         * [Optional] Indicates how the overview of the route should be represented in the response.
         * Options include polyline (encoded polyline), polyline6 (encoded polyline v6) and
         * geojson (geoJSON).
         *
         * [Default: polyline]
         *
         * See {@link Geometry} for further information.
         *
         *
         * @param geometry          The selected {@link Geometry}
         * @return                  {@link TravelingSalesmanDirectionsRequest.Builder} instance
         */
        public TravelingSalesmanDirectionsRequest.Builder setGeometry(Geometry geometry) {
            this.geometry = geometry;
            return this;
        }

        /**
         * [Optional] Indicates how detailed the overview of the route should be.
         * Options include simplified (to represent it in the highest level of zoom possible), full
         * (without skipping any geometry detail) and none (no overview at all).
         *
         * [Default: simplified]
         *
         * See {@link Overview} for further information.
         *
         * @param overview          The selected {@link Overview)
         * @return                  {@link TravelingSalesmanDirectionsRequest.Builder } instance
         */
        public TravelingSalesmanDirectionsRequest.Builder setOverview(Overview overview) {
            this.overview = overview;
            return this;
        }
        //endregion

        /**
         * Builds a valid instance of {@link TravelingSalesmanDirectionsRequest} once all fields
         * have been properly configured. It performs the following checkings before creating
         * the instance:
         * <ol>
         *     <li>Profile must be set</li>
         *     <li>Coordinates list must have at least 2 entries</li>
         *     <li>Optional params if unset, will take default values.</li>
         * </ol>
         * @return          A fully configured {@link TravelingSalesmanDirectionsRequest}
         */
        public TravelingSalesmanDirectionsRequest build() throws IllegalStateException {
            // Perform verifications

            // 1) Profile must be set
            if(profile == null) {
                throw new IllegalStateException("You must choose a profile for the route calculation.");
            }

            // 2) Origin must be set
            if((coordinates == null || coordinates.size() < 2)) {
                throw new IllegalStateException("You must provide a list of coordinates of at least " +
                        "2 items.");
            }

            // 3) Build instance
            return new TravelingSalesmanDirectionsRequest(this);
        }
    }
    //endregion
}
