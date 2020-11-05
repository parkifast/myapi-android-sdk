package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a deserialized route calculated in myapi servers.
 */
public class Route {

    //region Attributes
    /**
     * Collection of {@link RouteLeg}s that conform the full {@link Route}. A {@link RouteLeg} is
     * the route segment between to waypoints (also origin and / or destination).
     */
    @SerializedName("legs")
    private List<RouteLeg> legs;

    /**
     * The calculated weight of the {@link Route}.
     */
    @SerializedName("weight")
    private double weight;

    /**
     * The name of the weight profile used during extraction phase.
     */
    @SerializedName("weight_name")
    private String weightName;

    /**
     * The total estimated travel time, in seconds.
     */
    @SerializedName("duration")
    private double duration;

    /**
     * The distance traveled by the route, in meters.
     */
    @SerializedName("distance")
    private double distance;

    /**
     * The whole geometry of the route value depending on overview parameter, format depending on
     * the parameter geometries.
     */
    @SerializedName("geometry")
    private Geometry geometry;
    //endregion

    //region Getters and setters

    public List<RouteLeg> getLegs() {
        return legs;
    }

    public void setLegs(List<RouteLeg> legs) {
        this.legs = legs;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeightName() {
        return weightName;
    }

    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor
     */
    public Route() {
        this.legs = new ArrayList<>();
        this.weight = 0.0;
        this.weightName = "";
        this.duration = 0.0;
        this.distance = 0.0;
        this.geometry = new Geometry();
    }

    /**
     * Full constructor
     * @param legs          Route legs.
     * @param weight        Calculated weight.
     * @param weightName    Name of weight profile used.
     * @param duration      Total estimated travel time.
     * @param distance      Total distance traveled by the route.
     * @param geometry      Geometry of the full route.
     */
    public Route(List<RouteLeg> legs, double weight, String weightName, double duration,
                 double distance, Geometry geometry) {
        this.legs = legs;
        this.weight = weight;
        this.weightName = weightName;
        this.duration = duration;
        this.distance = distance;
        this.geometry = geometry;
    }

    //endregion

    //region Exposed API
    //endregion

    //region Public helpers

    /**
     * String representation of the {@link Route}.
     * @return      String representation of the {@link Route}.
     */
    @Override
    public String toString() {
        return "Route{" +
                "legs=" + legs +
                ", weight=" + weight +
                ", weightName='" + weightName + '\'' +
                ", duration=" + duration +
                ", distance=" + distance +
                ", geometry=" + geometry +
                '}';
    }

    /**
     * Compare two instances of {@link Route}
     * @param o     Another instance to compare to.
     * @return      {@code true} when both have the same values.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;

        Route route = (Route) o;

        if (Double.compare(route.getWeight(), getWeight()) != 0) return false;
        if (Double.compare(route.getDuration(), getDuration()) != 0) return false;
        if (Double.compare(route.getDistance(), getDistance()) != 0) return false;
        if (!getLegs().equals(route.getLegs())) return false;
        if (!getWeightName().equals(route.getWeightName())) return false;
        return getGeometry().equals(route.getGeometry());
    }

    /**
     * Uniquely identify an instance through a hashing algorithm.
     * @return          A hash that uniquely identifies this set of values.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getLegs().hashCode();
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getWeightName().hashCode();
        temp = Double.doubleToLongBits(getDuration());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getDistance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getGeometry().hashCode();
        return result;
    }

    //endregion

    //region Private helpers
    //endregion

}
