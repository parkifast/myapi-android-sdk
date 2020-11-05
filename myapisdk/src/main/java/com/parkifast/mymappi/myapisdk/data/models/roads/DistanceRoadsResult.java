package com.parkifast.mymappi.myapisdk.data.models.roads;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;

/**
 * Represents a single result of a Distance Roads API response.
 */
public class DistanceRoadsResult {

    //region Attributes
    /**
     * The distance in meters between the provided {@link Coordinate} and the snapped one to
     * the nearest road.
     */
    @SerializedName("distance")
    private double distance;

    //endregion

    //region Getters and setters

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public DistanceRoadsResult() {
        this.distance = 0.0;
    }
    /**
     * Full constructor.
     * @param distance          Distance in kilometers to nearest road
     */
    public DistanceRoadsResult(double distance) {
        this.distance = distance;
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
        return "DistanceRoadsResult{" +
                "distance=" + distance +
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
        if (!(o instanceof DistanceRoadsResult)) return false;

        DistanceRoadsResult that = (DistanceRoadsResult) o;

        return Double.compare(that.getDistance(), getDistance()) == 0;
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getDistance());
        return (int) (temp ^ (temp >>> 32));
    }
    //endregion

    //region Private helpers
    //endregion

}
