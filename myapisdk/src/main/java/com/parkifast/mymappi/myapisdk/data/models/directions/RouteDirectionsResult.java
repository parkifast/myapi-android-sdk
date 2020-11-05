package com.parkifast.mymappi.myapisdk.data.models.directions;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Route;
import com.parkifast.mymappi.myapisdk.data.models.common.RouteWaypoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single result of a Route Calculation Directions API response.
 */
public class RouteDirectionsResult {

    //region Attributes
    /**
     * Status message indicating if the route calculation was successful.
     */
    @SerializedName("code")
    private String code;
    /**
     * The list of waypoints that the route will cover, from origin to destination passing through
     * all specified intermediate waypoints.
     */
    @SerializedName("waypoints")
    private List<RouteWaypoint> waypoints;

    /**
     * The list of calculated routes that go through the specified list of waypoints.
     */
    @SerializedName("routes")
    private List<Route> routes;
    //endregion

    //region Getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<RouteWaypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<RouteWaypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public RouteDirectionsResult() {
        this.code = "";
        this.waypoints = new ArrayList<>();
        this.routes = new ArrayList<>();;
    }
    /**
     *
     * @param code          Status code for the route calculation.
     * @param waypoints     List of waypoints involved in the route (origin + destination + waypoints)
     * @param routes        List of alternative routes calculated.
     */
    public RouteDirectionsResult(String code, List<RouteWaypoint> waypoints, List<Route> routes) {
        this.code = code;
        this.waypoints = waypoints;
        this.routes = routes;
    }
    //endregion

    //region Exposed API
    //endregion

    //region Public helpers

    /**
     * String representation of current instance.
     * @return          Readable String representing this instance.
     */
    @Override
    public String toString() {
        return "RouteDirectionsResult{" +
                "code='" + code + '\'' +
                ", waypoints=" + waypoints.toString() +
                ", routes=" + routes.toString() +
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
        if (!(o instanceof RouteDirectionsResult)) return false;

        RouteDirectionsResult that = (RouteDirectionsResult) o;

        if (!getCode().equals(that.getCode())) return false;
        if (!getWaypoints().equals(that.getWaypoints())) return false;
        return getRoutes().equals(that.getRoutes());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        int result = getCode().hashCode();
        result = 31 * result + getWaypoints().hashCode();
        result = 31 * result + getRoutes().hashCode();
        return result;
    }
    //endregion

    //region Private helpers
    //endregion

}
