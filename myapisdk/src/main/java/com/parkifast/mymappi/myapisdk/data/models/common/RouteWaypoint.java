package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a deserialized waypoint within a calculated route. A waypoint might represent
 * the origin, destination or any intermediate stop configured along the route.
 */
public class RouteWaypoint {

    //region Attributes
    /**
     * Distance from the specified waypoint to the exact {@link Coordinate} snapped to the road
     * through which the route actually goes through.
     */
    @SerializedName("distance")
    private double distance;

    /**
     * Name of the road the {@link RouteWaypoint} is in.
     */
    @SerializedName("name")
    private String name;

    /**
     * Snapped coordinate to the road network calculated from the input waypoint.
     */
    @SerializedName("location")
    private Coordinate coordinate;
    //endregion

    //region Getters and setters

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor
     */
    public RouteWaypoint() {
        this.distance = 0.0;
        this.name = "";
        this.coordinate = new Coordinate();
    }

    /**
     * Full constructor
     * @param distance      Distance from the specified waypoint to its equivalent coordinate matched
     *                      to the road network.
     * @param name          Name of the road segment the waypoint has been matched to.
     * @param coordinate    The matched coordinate to the road network.
     */
    public RouteWaypoint(double distance, String name, Coordinate coordinate) {
        this.distance = distance;
        this.name = name;
        this.coordinate = coordinate;
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
        return "RouteWaypoint{" +
                "distance=" + distance +
                ", name='" + name + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }

    /**
     * Compare two instances of {@link RouteWaypoint}
     * @param o     Another instance to compare to.
     * @return      {@code true} when both have the same values.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteWaypoint)) return false;

        RouteWaypoint that = (RouteWaypoint) o;

        if (Double.compare(that.getDistance(), getDistance()) != 0) return false;
        if (!getName().equals(that.getName())) return false;
        return getCoordinate().equals(that.getCoordinate());
    }

    /**
     * Uniquely identify an instance through a hashing algorithm.
     * @return          A hash that uniquely identifies this set of values.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getDistance());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCoordinate().hashCode();
        return result;
    }

    //endregion

    //region Private helpers
    //endregion

}
