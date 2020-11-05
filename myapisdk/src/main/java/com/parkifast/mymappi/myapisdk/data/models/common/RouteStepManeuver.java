package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

/**
 * Contains all necessary information on what to do to progress from current {@link RouteStep} to
 * the next
 */
public class RouteStepManeuver {

    //region Attributes
    /**
     * The exact location in which the {@link RouteStepManeuver} needs to take place.
     */
    @SerializedName("location")
    private Coordinate location;

    /**
     * The clockwise angle from true north to the direction of travel immediately before
     * the maneuver.
     */
    @SerializedName("bearing_before")
    private double bearingBefore;

    /**
     * The clockwise angle from true north to the direction of travel immediately after the maneuver
     */
    @SerializedName("bearing_after")
    private double bearingAfter;

    /**
     * A string indicating the type of maneuver. New identifiers might be introduced without API
     * change Types unknown to the client should be handled like the turn type, the existence of
     * correct modifier values is guaranteed.
     * <table>
     * <thead>
     * <tr>
     * <th><code>type</code></th>
     * <th>Description</th>
     * </tr>
     * </thead>
     * <tbody>
     * <tr>
     * <td><code>turn</code></td>
     * <td>a basic turn into direction of the
     * <code>modifier</code></td>
     * </tr>
     * <tr>
     * <td><code>new name</code></td>
     * <td>no turn is taken/possible, but the road name changes. The road can take a turn itself, following
     * <code>modifier</code>
     * .</td>
     * </tr>
     * <tr>
     * <td><code>depart</code></td>
     * <td>indicates the departure of the leg</td>
     * </tr>
     * <tr>
     * <td><code>arrive</code></td>
     * <td>indicates the destination of the leg</td>
     * </tr>
     * <tr>
     * <td><code>merge</code></td>
     * <td>merge onto a street (e.g. getting on the highway from a ramp, the
     * <code>modifier specifies the direction of the merge</code>
     * )</td>
     * </tr>
     * <tr>
     * <td><code>ramp</code></td>
     * <td><strong>Deprecated</strong>
     * . Replaced by
     * <code>on_ramp</code>
     *  and
     * <code>off_ramp</code>
     * .</td>
     * </tr>
     * <tr>
     * <td><code>on ramp</code></td>
     * <td>take a ramp to enter a highway (direction given my
     * <code>modifier</code>
     * )</td>
     * </tr>
     * <tr>
     * <td><code>off ramp</code></td>
     * <td>take a ramp to exit a highway (direction given my
     * <code>modifier</code>
     * )</td>
     * </tr>
     * <tr>
     * <td><code>fork</code></td>
     * <td>take the left/right side at a fork depending on
     * <code>modifier</code></td>
     * </tr>
     * <tr>
     * <td><code>end of road</code></td>
     * <td>road ends in a T intersection turn in direction of
     * <code>modifier</code></td>
     * </tr>
     * <tr>
     * <td><code>use lane</code></td>
     * <td>going straight on a specific lane</td>
     * </tr>
     * <tr>
     * <td><code>continue</code></td>
     * <td>Turn in direction of
     * <code>modifier</code>
     *  to stay on the same road</td>
     * </tr>
     * <tr>
     * <td><code>roundabout</code></td>
     * <td>traverse roundabout, has additional field
     * <code>exit</code>
     *  with NR if the roundabout is left.
     * <code>the modifier specifies the direction of entering the roundabout</code></td>
     * </tr>
     * <tr>
     * <td><code>rotary</code></td>
     * <td>a traffic circle. While very similar to a larger version of a roundabout, it does not
     * necessarily follow roundabout rules for right of way. It can offer
     * <code>rotary_name/rotary_pronunciation</code>
     *  in addition to the
     * <code>exit</code>
     *  parameter.</td>
     * </tr>
     * <tr>
     * <td><code>roundabout turn</code></td>
     * <td>Describes a turn at a small roundabout that should be treated as normal turn. The
     * <code>modifier</code>
     *  indicates the turn direction. Example instruction:
     * <code>At the roundabout turn left</code>
     * .</td>
     * </tr>
     * <tr>
     * <td><code>notification</code></td>
     * <td>not an actual turn but a change in the driving conditions. For example the travel mode.  If the road takes a turn itself, the
     * <code>modifier</code>
     *  describes the direction</td>
     * </tr>
     * </tbody>
     * </table>
     */
    @SerializedName("type")
    private String type;

    /**
     *  An optional {@link String} indicating the direction change of the maneuver.
     *  <table>
     * <thead>
     * <tr>
     * <th><code>modifier</code></th>
     * <th>Description</th>
     * </tr>
     * </thead>
     * <tbody>
     * <tr>
     * <td><code>uturn</code></td>
     * <td>indicates  reversal of direction</td>
     * </tr>
     * <tr>
     * <td><code>sharp right</code></td>
     * <td>a sharp right turn</td>
     * </tr>
     * <tr>
     * <td><code>right</code></td>
     * <td>a normal turn to the right</td>
     * </tr>
     * <tr>
     * <td><code>slight right</code></td>
     * <td>a slight turn to the right</td>
     * </tr>
     * <tr>
     * <td><code>straight</code></td>
     * <td>no relevant change in direction</td>
     * </tr>
     * <tr>
     * <td><code>slight left</code></td>
     * <td>a slight turn to the left</td>
     * </tr>
     * <tr>
     * <td><code>left</code></td>
     * <td>a normal turn to the left</td>
     * </tr>
     * <tr>
     * <td><code>sharp left</code></td>
     * <td>a sharp turn to the left</td>
     * </tr>
     * </tbody>
     * </table>
     */
    @SerializedName("modifier")
    private String modifier;

    /**
     * Optional field. It indicates the nnumber of the exit to take. The field exists for the
     * following type fields:
     *
     * <table>
     * <thead>
     * <tr>
     * <th><code>type</code></th>
     * <th>Description</th>
     * </tr>
     * </thead>
     * <tbody>
     * <tr>
     * <td><code>roundabout</code>
     * /
     * <code>rotary</code></td>
     * <td>Number of the roundabout exit to take. If exit is
     * <code>undefined</code>
     *  the destination is on the roundabout.</td>
     * </tr>
     * <tr>
     * <td>else</td>
     * <td>Indicates the number of intersections passed until the turn. Example instruction:
     * <code>at the fourth intersection, turn left</code></td>
     * </tr>
     * </tbody>
     * </table>
     */
    @SerializedName("exit")
    private int exit;
    //endregion

    //region Getters and setters

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public double getBearingBefore() {
        return bearingBefore;
    }

    public void setBearingBefore(double bearingBefore) {
        this.bearingBefore = bearingBefore;
    }

    public double getBearingAfter() {
        return bearingAfter;
    }

    public void setBearingAfter(double bearingAfter) {
        this.bearingAfter = bearingAfter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public int getExit() {
        return exit;
    }

    public void setExit(int exit) {
        this.exit = exit;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor
     */
    public RouteStepManeuver() {
        this.location = new Coordinate();
        this.bearingBefore = 0.0;
        this.bearingAfter = 0.0;
        this.type = "";
        this.modifier = "";
        this.exit = 0;
    }

    /**
     * Full constructor.
     * @param location
     * @param bearingBefore
     * @param bearingAfter
     * @param type
     * @param modifier
     * @param exit
     */
    public RouteStepManeuver(Coordinate location, double bearingBefore, double bearingAfter,
                             String type, String modifier, int exit) {
        this.location = location;
        this.bearingBefore = bearingBefore;
        this.bearingAfter = bearingAfter;
        this.type = type;
        this.modifier = modifier;
        this.exit = exit;
    }

    //endregion

    //region Exposed API
    //endregion

    //region Public helpers

    /**
     * String representation of current instance.
     * @return          String representation of current instance.
     */
    @Override
    public String toString() {
        return "RouteStepManeuver{" +
                "location=" + location +
                ", bearingBefore=" + bearingBefore +
                ", bearingAfter=" + bearingAfter +
                ", type='" + type + '\'' +
                ", modifier='" + modifier + '\'' +
                ", exit=" + exit +
                '}';
    }

    /**
     * Compares two instances.
     * @param o     Another instance to compare to.
     * @return      {@code true} when all fields are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteStepManeuver)) return false;

        RouteStepManeuver that = (RouteStepManeuver) o;

        if (Double.compare(that.getBearingBefore(), getBearingBefore()) != 0) return false;
        if (Double.compare(that.getBearingAfter(), getBearingAfter()) != 0) return false;
        if (getExit() != that.getExit()) return false;
        if (!getLocation().equals(that.getLocation())) return false;
        if (!getType().equals(that.getType())) return false;
        return getModifier().equals(that.getModifier());
    }

    /**
     * Hashing algorithm.
     * @return          Uniquely identifies by a hash current instance.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getLocation().hashCode();
        temp = Double.doubleToLongBits(getBearingBefore());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getBearingAfter());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getType().hashCode();
        result = 31 * result + getModifier().hashCode();
        result = 31 * result + getExit();
        return result;
    }

    //endregion

    //region Private helpers
    //endregion

}
