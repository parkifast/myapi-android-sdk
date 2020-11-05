package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a route between two {@link RouteWaypoint}s.
 */
public class RouteLeg {

    //region Attributes
    /**
     * Collection of {@link RouteStep}s that conform the full {@link RouteLeg}. A {@link RouteStep}
     * is the specific maneuver segments between two points in the road segment where the driver
     * needs to make a decision.
     */
    @SerializedName("steps")
    private List<RouteStep> steps;

    /**
     * The calculated weight of the {@link RouteLeg}.
     */
    @SerializedName("weight")
    private double weight;

    /**
     * Summary of the route taken as string. Depends on the summary parameter:
     * {@code true} Names of the two major roads used. Can be empty if route is too short.
     * {@code false} Empty string.
     */
    @SerializedName("summary")
    private String summary;

    /**
     * The total estimated travel time for this leg, in seconds.
     */
    @SerializedName("duration")
    private double duration;

    /**
     * The distance traveled by the leg, in meters.
     */
    @SerializedName("distance")
    private double distance;
    //endregion

    //region Getters and setters

    public List<RouteStep> getSteps() {
        return steps;
    }

    public void setSteps(List<RouteStep> steps) {
        this.steps = steps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    //endregion

    //region Constructors

    /**
     * Empty constructor.
     */
    public RouteLeg() {
        this.steps = new ArrayList<>();
        this.weight = 0.0;
        this.summary = "";
        this.duration = 0.0;
        this.distance = 0.0;
    }

    /**
     * Full constructor.
     * @param steps             List of {@link RouteStep}s.
     * @param weight            Calculated weight for the {@link RouteLeg}
     * @param summary           Summary of the route taken as string
     * @param duration          The estimated travel time, in seconds.
     * @param distance          The distance traveled by this route leg, in meters.
     */
    public RouteLeg(List<RouteStep> steps, double weight, String summary, double duration, double distance) {
        this.steps = steps;
        this.weight = weight;
        this.summary = summary;
        this.duration = duration;
        this.distance = distance;
    }

    //endregion

    //region Exposed API
    //endregion

    //region Public helpers


    @Override
    public String toString() {
        return "RouteLeg{" +
                "steps=" + steps +
                ", weight=" + weight +
                ", summary='" + summary + '\'' +
                ", duration=" + duration +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteLeg)) return false;

        RouteLeg routeLeg = (RouteLeg) o;

        if (Double.compare(routeLeg.getWeight(), getWeight()) != 0) return false;
        if (Double.compare(routeLeg.getDuration(), getDuration()) != 0) return false;
        if (Double.compare(routeLeg.getDistance(), getDistance()) != 0) return false;
        if (!getSteps().equals(routeLeg.getSteps())) return false;
        return getSummary().equals(routeLeg.getSummary());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getSteps().hashCode();
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getSummary().hashCode();
        temp = Double.doubleToLongBits(getDuration());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getDistance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //endregion

    //region Private helpers
    //endregion

}
