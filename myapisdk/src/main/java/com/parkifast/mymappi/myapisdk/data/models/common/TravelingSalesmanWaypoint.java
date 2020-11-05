package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a deserialized waypoint within a calculated route. A waypoint might represent
 * the origin, destination or any intermediate stop configured along the route.
 */
public class TravelingSalesmanWaypoint extends RouteWaypoint {

    //region Attributes
    /**
     * Indicates the index of the current waypoint in the trip.
     */
    @SerializedName("waypoint_index")
    private int waypointIndex;

    /**
     * Index to trips of the sub-trip the current waypoint was matched to.
     */
    @SerializedName("trips_index")
    private int tripsIndex;
    //endregion

    //region Getters and setters

    public int getWaypointIndex() {
        return waypointIndex;
    }

    public void setWaypointIndex(int waypointIndex) {
        this.waypointIndex = waypointIndex;
    }

    public int getTripsIndex() {
        return tripsIndex;
    }

    public void setTripsIndex(int tripsIndex) {
        this.tripsIndex = tripsIndex;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor
     */
    public TravelingSalesmanWaypoint() {
        super();
        this.waypointIndex = 0;
        this.tripsIndex = 0;
    }

    /**
     * Full constructor
     *
     * @param distance          Distance from the specified waypoint to its equivalent coordinate
     *                          matched to the road network.
     * @param name              Name of the road segment the waypoint has been matched to.
     * @param coordinate        The matched coordinate to the road network.
     * @param waypointIndex     The current waypoint index.
     * @param tripsIndex        The trip index the current waypoint was matched to.
     */
    public TravelingSalesmanWaypoint(double distance, String name, Coordinate coordinate, int waypointIndex, int tripsIndex) {
        super(distance, name, coordinate);
        this.waypointIndex = waypointIndex;
        this.tripsIndex = tripsIndex;
    }


    //endregion

    //region Exposed API
    //endregion

    //region Public helpers

    /**
     * String representation of the waypoint.
     * @return      String representation of the waypoint.
     */
    @Override
    public String toString() {
        return "TravelingSalesmanWaypoint{" +
                "waypointIndex=" + waypointIndex +
                ", tripsIndex=" + tripsIndex +
                '}';
    }
    /**
     * Compare two instances of {@link TravelingSalesmanWaypoint}
     * @param o     Another instance to compare to.
     * @return      {@code true} when both have the same values.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelingSalesmanWaypoint)) return false;
        if (!super.equals(o)) return false;

        TravelingSalesmanWaypoint that = (TravelingSalesmanWaypoint) o;

        if (getWaypointIndex() != that.getWaypointIndex()) return false;
        return getTripsIndex() == that.getTripsIndex();
    }


    /**
     * Uniquely identify an instance through a hashing algorithm.
     * @return          A hash that uniquely identifies this set of values.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getWaypointIndex();
        result = 31 * result + getTripsIndex();
        return result;
    }
    //endregion

    //region Private helpers
    //endregion
}
