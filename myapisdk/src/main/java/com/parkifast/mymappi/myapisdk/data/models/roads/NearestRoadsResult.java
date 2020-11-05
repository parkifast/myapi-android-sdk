package com.parkifast.mymappi.myapisdk.data.models.roads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;

import java.util.HashMap;

/**
 * Represents a single result of a Nearest Roads API response.
 */
public class NearestRoadsResult {

    //region Attributes
    /**
     * The distance in meters between the provided {@link Coordinate} and the snapped one to
     * the nearest road.
     */
    @SerializedName("distance")
    private double distance;
    /**
     * The coordinate snapped to nearest road.
     */
    @Expose(deserialize = false)
    private Coordinate snappedCoordinate;

    /**
     * The queried road highway type.
     */
    @SerializedName("highway")
    private String highwayType;

    /**
     * The number of lanes this road has.
     */
    @SerializedName("lanes")
    private int lanes;

    /**
     * The max speed for this road segment, if available.
     */
    @SerializedName("maxspeed")
    private int maxSpeed;

    /**
     * The road name.
     */
    @SerializedName("name")
    private String name;

    /**
     * Whether the road is one way or not.
     */
    @SerializedName("oneway")
    private boolean oneWay;

    /**
     * The road reference.
     */
    @SerializedName("ref")
    private String ref;

    /**
     * The road reference color.
     */
    @SerializedName("ref:colour")
    private String refColor;

    /**
     * NOTE: We may add additional descriptive fields to the response without issuing a new API
     * version. All those potentially different fields will be found under this key-value structure.
     */
    @Expose(deserialize = false)
    private HashMap<String, Object> components;
    //endregion

    //region Getters and setters

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Coordinate getSnappedCoordinate() {
        return snappedCoordinate;
    }

    public void setSnappedCoordinate(Coordinate snappedCoordinate) {
        this.snappedCoordinate = snappedCoordinate;
    }

    public String getHighwayType() {
        return highwayType;
    }

    public void setHighwayType(String highwayType) {
        this.highwayType = highwayType;
    }

    public int getLanes() {
        return lanes;
    }

    public void setLanes(int lanes) {
        this.lanes = lanes;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefColor() {
        return refColor;
    }

    public void setRefColor(String refColor) {
        this.refColor = refColor;
    }

    public HashMap<String, Object> getComponents() {
        return components;
    }

    public void setComponents(HashMap<String, Object> components) {
        this.components = components;
    }
    //endregion

    //region Constructors=
    /**
     * Empty constructor for deserializing.
     */
    public NearestRoadsResult() {
        this.distance = 0.0;
        this.snappedCoordinate = new Coordinate();
        this.highwayType = "";
        this.lanes = 0;
        this.maxSpeed = 0;
        this.name = "";
        this.oneWay = false;
        this.ref = "";
        this.refColor = "";
        this.components = new HashMap<>();
    }

    /**
     * Full constructor
     * @param distance              Distance to nearest road.
     * @param snappedCoordinate     Coordinate snapped to nearest road.
     * @param highwayType           Type of road.
     * @param lanes                 Number of lanes.
     * @param maxSpeed              Max speed for this road
     * @param name                  Road name.
     * @param oneWay                Whether the road is one way or not.
     * @param ref                   Road's reference.
     * @param refColor              Road's reference color (i.e. blue for spanish motorways)
     * @param components            All components associated with nearest road information
     */
    public NearestRoadsResult(double distance, Coordinate snappedCoordinate, String highwayType,
                              int lanes, int maxSpeed, String name, boolean oneWay, String ref,
                              String refColor, HashMap<String, Object> components) {
        this.distance = distance;
        this.snappedCoordinate = snappedCoordinate;
        this.highwayType = highwayType;
        this.lanes = lanes;
        this.maxSpeed = maxSpeed;
        this.name = name;
        this.oneWay = oneWay;
        this.ref = ref;
        this.refColor = refColor;
        this.components = components;
    }

    public NearestRoadsResult(HashMap<String, Object> components) {
        // Make sure components structure is not empty
        if(components == null) {
            this.components = new HashMap<>();
        } else {
            this.components = components;
        }
        this.distance = this.components.containsKey("distance") ? Double.parseDouble(this.components.get("distance").toString()) : 0.0;
        // Parse snapped coordinate
        this.snappedCoordinate = new Coordinate();
        if(this.components.containsKey("lat") && this.components.containsKey("lon") &&
                this.components.get("lat") != null && this.components.get("lon") != null) {
            this.snappedCoordinate.setLat(Double.parseDouble(this.components.get("lat").toString()));
            this.snappedCoordinate.setLon(Double.parseDouble(this.components.get("lon").toString()));
        }
        this.highwayType = this.components.containsKey("highway") ? this.components.get("highway").toString() : "";
        this.lanes = this.components.containsKey("lanes") ? Integer.parseInt(this.components.get("lanes").toString()) : 0;
        this.maxSpeed = this.components.containsKey("maxspeed") ? Integer.parseInt(this.components.get("maxspeed").toString()) : 0;
        this.name = this.components.containsKey("name") ? this.components.get("name").toString() : "";
        // Parse one way field
        this.oneWay = this.components.containsKey("oneway") && this.components.get("oneway").equals("yes");
        this.ref = this.components.containsKey("ref") ? this.components.get("ref").toString() : "";
        this.refColor = this.components.containsKey("ref:colour") ? this.components.get("ref:colour").toString() : "";
        this.components = components;
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
        return "NearestRoadsResult{" +
                "distance=" + distance +
                ", snappedCoordinate=" + snappedCoordinate +
                ", highwayType='" + highwayType + '\'' +
                ", lanes=" + lanes +
                ", maxSpeed=" + maxSpeed +
                ", name='" + name + '\'' +
                ", oneWay=" + oneWay +
                ", ref='" + ref + '\'' +
                ", refColor='" + refColor + '\'' +
                ", components=" + components +
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
        if (!(o instanceof NearestRoadsResult)) return false;

        NearestRoadsResult that = (NearestRoadsResult) o;

        if (Double.compare(that.getDistance(), getDistance()) != 0) return false;
        if (getLanes() != that.getLanes()) return false;
        if (getMaxSpeed() != that.getMaxSpeed()) return false;
        if (isOneWay() != that.isOneWay()) return false;
        if (!getSnappedCoordinate().equals(that.getSnappedCoordinate())) return false;
        if (!getHighwayType().equals(that.getHighwayType())) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getRef().equals(that.getRef())) return false;
        if (!getRefColor().equals(that.getRefColor())) return false;
        return getComponents().equals(that.getComponents());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getDistance());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getSnappedCoordinate().hashCode();
        result = 31 * result + getHighwayType().hashCode();
        result = 31 * result + getLanes();
        result = 31 * result + getMaxSpeed();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (isOneWay() ? 1 : 0);
        result = 31 * result + getRef().hashCode();
        result = 31 * result + getRefColor().hashCode();
        result = 31 * result + getComponents().hashCode();
        return result;
    }
    //endregion

    //region Private helpers
    //endregion

}
