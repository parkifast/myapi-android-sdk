package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * An intersection gives a full representation of any cross-way the path passes by. For every
 * {@link RouteStepManeuver}, the very first intersection (intersections[0]) corresponds to the
 * location of the {@link RouteStepManeuver}. Further intersections are listed for every cross-way
 * until the next turn instruction.
 */
public class RouteIntersection {

    //region Attributes
    /**
     * Location of the crossway
     */
    @SerializedName("location")
    private Coordinate location;

    /**
     * A list of bearing values (e.g. [0,90,180,270]) that are available at the intersections.
     * These bearings describe all available roads at the intersection.
     */
    @SerializedName("bearings")
    private List<Double> bearings;

    /**
     * A list of entry flags, corresponding in a 1:1 relationship to the bearings. A value of
     * {@code true} indicates that the respective road could be entered on a valid route.
     * {@code false} indicates that the turn onto the respective road would violate a restriction.
     */
    @SerializedName("entry")
    private List<Boolean> entries;

    /**
     * Index into bearings/entry array. Used to calculate the bearing just before the turn. Namely,
     * the clockwise angle from true north to the direction of travel immediately before the
     * {@link RouteStepManeuver} / passing the {@link RouteIntersection}. Bearings are given
     * relative to the {@link RouteIntersection}. To get the bearing in the direction of driving,
     * the bearing has to be rotated by a value of 180. The value is not supplied for depart
     *  {@link RouteStepManeuver}s.
     */
    @SerializedName("in")
    private double in;

    /**
     * Index into the bearings/entry array. Used to extract the bearing just after the turn. Namely,
     * the clockwise angle from true north to the direction of travel immediately after the
     * {@link RouteStepManeuver} / passing the {@link RouteIntersection}. The value is not supplied
     * for arrive maneuvers.
     */
    @SerializedName("out")
    private double out;

    /**
     * Array of Lane objects that denote the available turn lanes at the intersection.
     * If no lane information is available for an intersection, the lanes property will not
     * be present.
     */
    @SerializedName("lanes")
    private List<Lane> lanes;

    //endregion

    //region Getters and setters

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public List<Double> getBearings() {
        return bearings;
    }

    public void setBearings(List<Double> bearings) {
        this.bearings = bearings;
    }

    public List<Boolean> getEntries() {
        return entries;
    }

    public void setEntries(List<Boolean> entries) {
        this.entries = entries;
    }

    public double getIn() {
        return in;
    }

    public void setIn(double in) {
        this.in = in;
    }

    public double getOut() {
        return out;
    }

    public void setOut(double out) {
        this.out = out;
    }

    public List<Lane> getLanes() {
        return lanes;
    }

    public void setLanes(List<Lane> lanes) {
        this.lanes = lanes;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor.
     */
    public RouteIntersection() {
        this.location = new Coordinate();
        this.bearings = new ArrayList<>();
        this.entries = new ArrayList<>();
        this.in = 0.0;
        this.out = 0.0;
        this.lanes = new ArrayList<>();
    }

    /**
     * Full constructor.
     *
     * @param location
     * @param bearings
     * @param entries
     * @param in
     * @param out
     * @param lanes
     */
    public RouteIntersection(Coordinate location, List<Double> bearings, List<Boolean> entries, double in, double out, List<Lane> lanes) {
        this.location = location;
        this.bearings = bearings;
        this.entries = entries;
        this.in = in;
        this.out = out;
        this.lanes = lanes;
    }

    //endregion

    //region Exposed API
    //endregion

    //region Public helpers

    /**
     * String representation of current instance.
     * @return
     */
    @Override
    public String toString() {
        return "RouteIntersection{" +
                "location=" + location +
                ", bearings=" + bearings +
                ", entries=" + entries +
                ", in=" + in +
                ", out=" + out +
                ", lanes=" + lanes +
                '}';
    }

    /**
     * Compares two instances.
     * @param o     Another instance to compare to
     * @return      {@code true} when all fields are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteIntersection)) return false;

        RouteIntersection that = (RouteIntersection) o;

        if (Double.compare(that.getIn(), getIn()) != 0) return false;
        if (Double.compare(that.getOut(), getOut()) != 0) return false;
        if (!getLocation().equals(that.getLocation())) return false;
        if (!getBearings().equals(that.getBearings())) return false;
        if (!getEntries().equals(that.getEntries())) return false;
        return getLanes().equals(that.getLanes());
    }

    /**
     * Hashing algorithm.
     * @return      Uniquely identifies current instance.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getLocation().hashCode();
        result = 31 * result + getBearings().hashCode();
        result = 31 * result + getEntries().hashCode();
        temp = Double.doubleToLongBits(getIn());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getOut());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getLanes().hashCode();
        return result;
    }

    //endregion

    //region Private helpers
    //endregion

}
