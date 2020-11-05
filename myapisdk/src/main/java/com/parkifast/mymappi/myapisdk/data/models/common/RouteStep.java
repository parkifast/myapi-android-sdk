package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * A step consists of a maneuver such as a turn or merge, followed by a distance of travel
 * along a single way to the subsequent step.
 */
public class RouteStep {

    //region Attributes
    /**
     * Collection of {@link RouteIntersection}s that are passed along the segment, the very first
     * one belonging to the {@link RouteStepManeuver}.
     *
     */
    @SerializedName("intersections")
    private List<RouteIntersection> intersections;

    /**
     * Indicates the side of the road in which the driving takes place.
     */
    @SerializedName("driving_side")
    private String drivingSide;

    /**
     * The calculated weight of the {@link RouteStep}.
     */
    @SerializedName("weight")
    private double weight;

    /**
     * The unsimplified geometry of the route segment, depending on the geometries parameter.
     * Possible formats: polyline (precision 5), polyline6 (precision 6) or geoJson.
     */
    @SerializedName("geometry")
    private Geometry geometry;

    /**
     * The estimated travel time for this step, in seconds.
     */
    @SerializedName("duration")
    private double duration;

    /**
     * The distance of travel from the maneuver to the subsequent step, in meters.
     */
    @SerializedName("distance")
    private double distance;

    /**
     * The name of the way along which travel proceeds.
     */
    @SerializedName("name")
    private String name;

    /**
     * The reference number or code for the way. Optionally included, if ref data is available
     * for the given way.
     */
    @SerializedName("ref")
    private String ref;

    /**
     * The pronunciation hint of the way name. Will be undefined if there is no pronunciation hint.
     */
    @SerializedName("pronunciation")
    private String pronunciation;

    /**
     * The destinations of the way as a String. Will be undefined if there are no destinations.
     */
    @SerializedName("destinations")
    private String destinations;

    /**
     * A string signifying the mode of transportation.
     */
    @SerializedName("mode")
    private String mode;

    /**
     * A {@link RouteStepManeuver} object representing the maneuver.
     */
    @SerializedName("maneuver")
    private RouteStepManeuver maneuver;

    /**
     * The name for the rotary. Optionally included, if the step is a rotary and a rotary name is
     * available.
     */
    @SerializedName("rotary_name")
    private String rotaryName;

    /**
     * The pronunciation hint of the rotary name. Optionally included, if the step is a rotary and
     * a rotary pronunciation is available.
     */
    @SerializedName("rotary_pronunciation")
    private String rotaryPronunciation;


    //endregion

    //region Getters and setters

    public List<RouteIntersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(List<RouteIntersection> intersections) {
        this.intersections = intersections;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getDestinations() {
        return destinations;
    }

    public void setDestinations(String destinations) {
        this.destinations = destinations;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public RouteStepManeuver getManeuver() {
        return maneuver;
    }

    public void setManeuver(RouteStepManeuver maneuver) {
        this.maneuver = maneuver;
    }

    public String getRotaryName() {
        return rotaryName;
    }

    public void setRotaryName(String rotaryName) {
        this.rotaryName = rotaryName;
    }

    public String getRotaryPronunciation() {
        return rotaryPronunciation;
    }

    public void setRotaryPronunciation(String rotaryPronunciation) {
        this.rotaryPronunciation = rotaryPronunciation;
    }

    public String getDrivingSide() {
        return drivingSide;
    }

    public void setDrivingSide(String drivingSide) {
        this.drivingSide = drivingSide;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor
     */
    public RouteStep() {
        this.intersections = new ArrayList<>();
        this.weight = 0.0;
        this.geometry = new Geometry();
        this.duration = 0.0;
        this.distance = 0.0;
        this.drivingSide = "";
        this.name = "";
        this.ref = "";
        this.pronunciation = "";
        this.destinations = "";
        this.mode = "";
        this.maneuver = new RouteStepManeuver();
        this.rotaryName = "";
        this.rotaryPronunciation = "";
    }

    /**
     * Full constructor.
     * @param intersections
     * @param weight
     * @param geometry
     * @param duration
     * @param distance
     * @param drivingSide
     * @param name
     * @param ref
     * @param pronunciation
     * @param destinations
     * @param mode
     * @param maneuver
     * @param rotaryName
     * @param rotaryPronunciation
     */
    public RouteStep(List<RouteIntersection> intersections, double weight, Geometry geometry,
                     double duration, double distance, String name, String drivingSide, String ref,
                     String pronunciation, String destinations, String mode,
                     RouteStepManeuver maneuver, String rotaryName, String rotaryPronunciation) {
        this.intersections = intersections;
        this.weight = weight;
        this.geometry = geometry;
        this.duration = duration;
        this.distance = distance;
        this.drivingSide = drivingSide;
        this.name = name;
        this.ref = ref;
        this.pronunciation = pronunciation;
        this.destinations = destinations;
        this.mode = mode;
        this.maneuver = maneuver;
        this.rotaryName = rotaryName;
        this.rotaryPronunciation = rotaryPronunciation;
    }


    //endregion

    //region Exposed API
    //endregion

    //region Public helpers

    /**
     * String representation of the {@link RouteStep}
     * @return          String representation of the {@link RouteStep
     */
    @Override
    public String toString() {
        return "RouteStep{" +
                "intersections=" + intersections +
                ", drivingSide='" + drivingSide + '\'' +
                ", weight=" + weight +
                ", geometry=" + geometry +
                ", duration=" + duration +
                ", distance=" + distance +
                ", name='" + name + '\'' +
                ", ref='" + ref + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", destinations=" + destinations +
                ", mode='" + mode + '\'' +
                ", maneuver=" + maneuver +
                ", rotaryName='" + rotaryName + '\'' +
                ", rotaryPronunciation='" + rotaryPronunciation + '\'' +
                '}';
    }

    /**
     * Compares two instances.
     * @param o         Another instance to compare to.
     * @return          {@code true} when all fields are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteStep)) return false;

        RouteStep routeStep = (RouteStep) o;

        if (Double.compare(routeStep.getWeight(), getWeight()) != 0) return false;
        if (Double.compare(routeStep.getDuration(), getDuration()) != 0) return false;
        if (Double.compare(routeStep.getDistance(), getDistance()) != 0) return false;
        if (!getIntersections().equals(routeStep.getIntersections())) return false;
        if (!getDrivingSide().equals(routeStep.getDrivingSide())) return false;
        if (!getGeometry().equals(routeStep.getGeometry())) return false;
        if (!getName().equals(routeStep.getName())) return false;
        if (!getRef().equals(routeStep.getRef())) return false;
        if (!getPronunciation().equals(routeStep.getPronunciation())) return false;
        if (!getDestinations().equals(routeStep.getDestinations())) return false;
        if (!getMode().equals(routeStep.getMode())) return false;
        if (!getManeuver().equals(routeStep.getManeuver())) return false;
        if (!getRotaryName().equals(routeStep.getRotaryName())) return false;
        return getRotaryPronunciation().equals(routeStep.getRotaryPronunciation());
    }

    /**
     * Hashing algorithm.
     * @return          A hash representation of current instance.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getIntersections().hashCode();
        result = 31 * result + getDrivingSide().hashCode();
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getGeometry().hashCode();
        temp = Double.doubleToLongBits(getDuration());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getDistance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + getRef().hashCode();
        result = 31 * result + getPronunciation().hashCode();
        result = 31 * result + getDestinations().hashCode();
        result = 31 * result + getMode().hashCode();
        result = 31 * result + getManeuver().hashCode();
        result = 31 * result + getRotaryName().hashCode();
        result = 31 * result + getRotaryPronunciation().hashCode();
        return result;
    }
    //endregion

    //region Private helpers
    //endregion

}
