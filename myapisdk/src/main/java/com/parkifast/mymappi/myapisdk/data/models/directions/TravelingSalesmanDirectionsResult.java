package com.parkifast.mymappi.myapisdk.data.models.directions;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Route;
import com.parkifast.mymappi.myapisdk.data.models.common.RouteWaypoint;
import com.parkifast.mymappi.myapisdk.data.models.common.TravelingSalesmanWaypoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single result of a Traveling Salesman Route Calculation Directions API response.
 */
public class TravelingSalesmanDirectionsResult {

    //region Attributes
    /**
     * Status message indicating if the traveling salesman route calculation was successful.
     */
    @SerializedName("code")
    private String code;
    /**
     * The list of waypoints that the route will cover, from origin to destination passing through
     * all specified intermediate waypoints.
     */
    @SerializedName("waypoints")
    private List<TravelingSalesmanWaypoint> waypoints;

    /**
     * The list of routes that will cover the whole list of specified waypoints.
     */
    @SerializedName("trips")
    private List<Route> trips;

    //endregion

    //region Getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<TravelingSalesmanWaypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<TravelingSalesmanWaypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public List<Route> getTrips() {
        return trips;
    }

    public void setTrips(List<Route> trips) {
        this.trips = trips;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public TravelingSalesmanDirectionsResult() {
        this.code = "";
        this.waypoints = new ArrayList<>();
        this.trips = new ArrayList<>();;
    }
    /**
     *
     * @param code          Status code for the route calculation.
     * @param waypoints     List of waypoints involved in the route (origin + destination + waypoints)
     * @param trips        List of alternative routes calculated.
     */
    public TravelingSalesmanDirectionsResult(String code, List<TravelingSalesmanWaypoint> waypoints,
                                             List<Route> trips) {
        this.code = code;
        this.waypoints = waypoints;
        this.trips = trips;
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
                ", routes=" + trips.toString() +
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
        if (!(o instanceof TravelingSalesmanDirectionsResult)) return false;

        TravelingSalesmanDirectionsResult that = (TravelingSalesmanDirectionsResult) o;

        if (!getCode().equals(that.getCode())) return false;
        if (!getWaypoints().equals(that.getWaypoints())) return false;
        return getTrips().equals(that.getTrips());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        int result = getCode().hashCode();
        result = 31 * result + getWaypoints().hashCode();
        result = 31 * result + getTrips().hashCode();
        return result;
    }
    //endregion

    //region Private helpers
    //endregion

}
