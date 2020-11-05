package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a geographic coordinate.
 */
public class Coordinate {

    //region Attributes
    /**
     * Latitude component of the coordinate.
     */
    @SerializedName("lat")
    private double lat;

    /**
     * Longitude component of the coordinate.
     */
    @SerializedName("lon")
    private double lon;
    //endregion

    //region Getters and setters
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
    //endregion

    //region Constructors

    /**
     * Empty constructor for deserialization.
     */
    public Coordinate() {
        this.lat = 0.0;
        this.lon = 0.0;
    }
    /**
     * Basic constructor for a {@link Coordinate} object.
     * @param lat       The latitude component
     * @param lon       The longitude component
     */
    public Coordinate(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
    //endregion

    //region Exposed API

    /**
     * Determines whether the {@link Coordinate} is properly configured or not.
     * @return      {@code true} when both components are set to 0.0
     */
    public boolean isEmpty() {
        return this.lat == 0.0 && this.lon == 0;
    }
    //endregion

    //region Public helpers

    @Override
    public String toString() {
        return "Coordinate{" +
                "lat=" + this.lat +
                ", lon=" + this.lon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        if (Double.compare(that.getLat(), getLat()) != 0) return false;
        return Double.compare(that.getLon(), getLon()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getLat());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLon());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Serialization as of the {@link Coordinate} as a String.
     * @return
     */
    public String serialize() {
        return "" + this.lat + "," + this.lon;
    }

    //endregion

    //region Private helpers
    //endregion
}
