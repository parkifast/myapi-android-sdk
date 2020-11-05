package com.parkifast.mymappi.myapisdk.network.request_models.directions;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.request_models.common.Geometry;
import com.parkifast.mymappi.myapisdk.network.request_models.common.Overview;
import com.parkifast.mymappi.myapisdk.network.request_models.common.Profile;

import java.util.ArrayList;
import java.util.List;

import static com.parkifast.mymappi.myapisdk.network.request_models.common.Geometry.polyline;
import static com.parkifast.mymappi.myapisdk.network.request_models.common.Overview.simplified;

public class RouteDirectionsRequest {

    //region Attributes
    /**
     * Profile used for route calculation.
     */
    private Profile profile;

    /**
     * Whether alternative routes should be offered or not. Default behaviour is set to {@code false}.
     */
    private boolean alternatives;

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
     * Possibilities for route overview. By default it will be simplified (according to highest
     * zoom level iit could be displayed on), but it can also be set to full (full intersections list
     * regardless of zoom level) or false (no overview at all)
     */
    private Overview overview;

    /**
     * Origin coordinate
     */
    private Coordinate origin;

    /**
     * Origin query. Used when route should be calculated with a full address as origin.
     */
    private String origQuery;

    /**
     * Destination coordinate
     */
    private Coordinate destination;

    /**
     * Destination query. Used when route should be calculated with a full address as destination.
     */
    private String destQuery;

    /**
     * List of waypoints along the route. These waypoints must be specified as {@link Coordinate}s.
     */
    private List<Coordinate> waypoints;

    /**
     * List of waypoints as queries along the route.
     */
    private List<String> waypointQueries;
    //endregion

    //region Getters and setters

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public boolean getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(boolean alternatives) {
        this.alternatives = alternatives;
    }

    public boolean getSteps() {
        return steps;
    }

    public void setSteps(boolean steps) {
        this.steps = steps;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public Coordinate getOrigin() {
        return origin;
    }

    public void setOrigin(Coordinate origin) {
        this.origin = origin;
    }

    public String getOrigQuery() {
        return origQuery;
    }

    public void setOrigQuery(String origQuery) {
        this.origQuery = origQuery;
    }

    public Coordinate getDestination() {
        return destination;
    }

    public void setDestination(Coordinate destination) {
        this.destination = destination;
    }

    public String getDestQuery() {
        return destQuery;
    }

    public void setDestQuery(String destQuery) {
        this.destQuery = destQuery;
    }

    public List<Coordinate> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Coordinate> waypoints) {
        this.waypoints = waypoints;
    }

    public List<String> getWaypointQueries() {
        return waypointQueries;
    }

    public void setWaypointQueries(List<String> waypointQueries) {
        this.waypointQueries = waypointQueries;
    }

    //endregion

    //region Constructors

    /**
     * Private constructor via {@link Builder}.
     * @param builder           Fully configured builder.
     */
    private RouteDirectionsRequest(Builder builder) {
        this.profile = builder.profile;
        this.alternatives = builder.alternatives;
        this.steps = builder.steps;
        this.geometry = builder.geometry;
        this.overview = builder.overview;
        this.origin = builder.origin;
        this.origQuery = builder.origQuery;
        this.destination = builder.destination;
        this.destQuery = builder.destQuery;
        this.waypoints = builder.waypoints;
        this.waypointQueries = builder.waypointQueries;
    }
    //endregion
    
    //region Inner static Builder class
    /**
     * Builder class for {@link RouteDirectionsRequest}.
     */
    public static class Builder {

        //region Attributes
        private Profile profile;
        private boolean alternatives = false;
        private boolean steps = true;
        private Geometry geometry = polyline;
        private Overview overview = simplified;
        private Coordinate origin;
        private String origQuery = "";
        private Coordinate destination;
        private String destQuery = "";
        private List<Coordinate> waypoints = new ArrayList<>();
        private List<String> waypointQueries = new ArrayList<>();
        //endregion

        //region Setters

        /**
         * [Required] Specify the {@link Profile} to be used for route calculation.
         * @param profile       The profile to use in route calculation.
         * @return              {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder setProfile(Profile profile) {
            this.profile = profile;
            return this;
        }

        /**
         * [Optional] Specify whether alternative routes should be included in the response (if possible).
         * [Default: false]
         * @param alternatives      {@code} true when alternatives should be retrieved as well.
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder includeAlternatives(boolean alternatives) {
            this.alternatives = alternatives;
            return this;
        }

        /**
         * [Optional] Specify whether the route should include step by step information or not.
         * [Default: true]
         * @param steps             {@code} true when steps should be retrieved as well.
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder includeSteps(boolean steps) {
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
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder setGeometry(Geometry geometry) {
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
         * @return                  {@link RouteDirectionsRequest.Builder } instance
         */
        public RouteDirectionsRequest.Builder setOverview(Overview overview) {
            this.overview = overview;
            return this;
        }

        /**
         * [Required] Origin for the route as a {@link Coordinate}.
         * [Optional] only if the origin is going to be set as a String query with setOrigQuery().
         *
         * @param origin            The origin of the route as a {@link Coordinate}
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder setOrigin(Coordinate origin) {
            this.origin = origin;
            return this;
        }

        /**
         * [Required] Origin for the route as a String query. This will involve an automatic Geocoding
         * request on our server and thus will be charged as an extra transaction accordingly.
         * [Optional] only if the origin is going to be set as a {@link Coordinate} with setOrigin().
         *
         * @param origQuery         The origin of the route as a String query.
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder setOrigQuery(String origQuery) {
            this.origQuery = origQuery;
            return this;
        }

        /**
         * [Required] Destination for the route as a {@link Coordinate}.
         * [Optional] only if the destination is going to be set as a String query with setDestQuery().
         *
         * @param destination       The destination of the route as a {@link Coordinate}
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder setDestination(Coordinate destination) {
            this.destination = destination;
            return this;
        }

        /**
         * [Required] Destination for the route as a String query. This will involve an automatic Geocoding
         * request on our server and thus will be charged as an extra transaction accordingly.
         * [Optional] only if the destination is going to be set as a {@link Coordinate} with setDestination().
         *
         * @param destQuery         The destination of the route as a String query.
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder setDestQuery(String destQuery) {
            this.destQuery = destQuery;
            return this;
        }

        /**
         * [Optional] A list of waypoints as {@link Coordinate}s along the route. Check the pricing FAQ
         * for further information on waypoints size limit, since depending on how many you input it
         * will be charged as a different number of transactions.
         *
         * Note: Waypoints might be set either via a list of Coordinates or via a list of String queries,
         * but both cannot be set, one must be empty.
         *
         * @param waypoints         An {@link ArrayList} of {@link Coordinate}s
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder setWaypoints(List<Coordinate> waypoints) {
            this.waypoints = waypoints;
            return this;
        }

        /**
         * [Optional] Adds a new{@link Coordinate} to the waypoints list. Check the pricing FAQ
         * for further information on waypoints size limit, since depending on how many you input it
         * will be charged as a different number of transactions.
         *
         * Note: Waypoints might be set either via a list of Coordinates or via a list of String queries,
         * but both cannot be set, one must be empty.
         *
         * @param waypoint          A new {@link Coordinate} to be added to the waypoints list.
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder addWaypoint(Coordinate waypoint) {
            this.waypoints.add(waypoint);
            return this;
        }

        /**
         * [Optional] A list of waypoints as String queries along the route. Check the pricing FAQ
         * for further information on waypoints size limit, since depending on how many you input it
         * will be charged as a different number of transactions. Please note that each item on this
         * list will have to be geocoded on our servers before attempting to calculate the route, so
         * additional transactions will be charged per each geocoding operation we must perform on your
         * behalf. Check pricing FAQ for further information on https://mymappi.com/pricing
         *
         * Note: Waypoints might be set either via a list of Coordinates or via a list of String queries,
         * but both cannot be set, one must be empty.
         *
         * @param waypointQueries   An {@link ArrayList} of String queries
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder setWaypointQueries(List<String> waypointQueries) {
            this.waypointQueries = waypointQueries;
            return this;
        }

        /**
         * [Optional] Adds a new waypoint to the list as a String query along the route. Check the
         * pricing FAQ for further information on waypoints size limit, since depending on how many you
         * input it will be charged as a different number of transactions. Please note that each item on
         * the waypoints list will have to be geocoded on our servers before attempting to calculate the
         * route, so additional transactions will be charged per each geocoding operation we must
         * perform on your behalf. Check pricing FAQ for further information
         * on https://mymappi.com/pricing
         *
         * Note: Waypoints might be set either via a list of Coordinates or via a list of String queries,
         * but both cannot be set, one must be empty.
         *
         * @param waypointQuery   An {@link ArrayList} of String queries
         * @return                  {@link RouteDirectionsRequest.Builder} instance
         */
        public RouteDirectionsRequest.Builder addWaypointQuery(String waypointQuery) {
            this.waypointQueries.add(waypointQuery);
            return this;
        }
        //endregion

        /**
         * Builds a valid instance of {@link RouteDirectionsRequest} once all fields have been properly
         * configured. It performs the following checkings before creating the instance:
         * <ol>
         *     <li>Profile must be set</li>
         *     <li>Origin must be set (either via coordinate or via query)</li>
         *     <li>Origin cannot be set as both via Coordinate and via query.</li>
         *     <li>Destination must be set (either via coordinate or via query)</li>
         *     <li>Destination cannot be set as both via Coordinate and via query.</li>
         *     <li>Waypoints list, if set, must be either via coordinates or via queries,
         *     but not both</li>
         *     <li>Optional params if unset, will take default values.</li>
         * </ol>
         * @return
         */
        public RouteDirectionsRequest build() throws IllegalStateException {
            // Perform verifications

            // 1) Profile must be set
            if(profile == null) {
                throw new IllegalStateException("You must choose a profile for the route calculation.");
            }

            // 2) Origin must be set
            if((origin == null || origin.isEmpty()) && (origQuery == null || origQuery.isEmpty())) {
                throw new IllegalStateException("You must set an origin either as a Coordinate or " +
                        "as a String query in order to calculate the route.");
            }

            // 3) If origin is set twice, as a query and as a Coordinate, throw exception
            if((origin != null && !origin.isEmpty()) && (origQuery != null && !origQuery.isEmpty())) {
                throw new IllegalStateException("You must set an origin either as a Coordinate or " +
                        "as a String query in order to calculate the route, but not both. " +
                        "Please remove one.");
            }

            // 4) A destination must be set
            if((destination == null || destination.isEmpty()) && (destQuery == null || destQuery.isEmpty())) {
                throw new IllegalStateException("You must set a destination either as a Coordinate or " +
                        "as a String query in order to calculate the route.");
            }

            // 5) If origin is set twice, as a query and as a Coordinate, throw exception
            if((destination != null && !destination.isEmpty()) && (destQuery != null && !destQuery.isEmpty())) {
                throw new IllegalStateException("You must set a destination either as a Coordinate or " +
                        "as a String query in order to calculate the route, but not both. " +
                        "Please remove one.");
            }

            // 6) Make sure all optional fields are set to default if they are null for a random reason
            this.geometry = this.geometry == null ? polyline : this.geometry;
            this.overview = this.overview == null ? simplified : this.overview;
            this.waypoints = this.waypoints == null ? new ArrayList<>() : this.waypoints;
            this.waypointQueries = this.waypointQueries == null ? new ArrayList<>() : this.waypointQueries;

            // 7) Make sure only one list of waypoints is set (either all Coordinates, or all queries)
            if(!waypoints.isEmpty() && !waypointQueries.isEmpty()) {
                throw new IllegalStateException("You can't populate waypoint list as both coordinates " +
                        "and String queries. Choose whether you want to provide a list of Coordinates " +
                        "or a list of String queries and leave the other one empty.");
            }

            // 8) Build instance
            return new RouteDirectionsRequest(this);
        }
    }
    //endregion
}
