package com.parkifast.mymappi.myapisdk.data.models.roads;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.OSMPlaceInfo;

/**
 * Represents a single result of a Speed Limit Roads API response.
 */
public class SpeedLimitRoadsResult {

    //region Attributes
    /**
     * Information about current place and element in OSM cartography.
     */
    private OSMPlaceInfo osmPlaceInfo;
    /**
     * The queried road max speed in kilometers per hour.
     */
    @SerializedName("maxspeed")
    private int maxSpeed;

    /**
     * The queried road highway type.
     */
    @SerializedName("highway")
    private String highwayType;

    /**
     * The queried road name.
     */
    @SerializedName("name")
    private String name;
    //endregion

    //region Getters and setters

    public OSMPlaceInfo getOsmPlaceInfo() {
        return osmPlaceInfo;
    }

    public void setOsmPlaceInfo(OSMPlaceInfo osmPlaceInfo) {
        this.osmPlaceInfo = osmPlaceInfo;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getHighwayType() {
        return highwayType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHighwayType(String highwayType) {
        this.highwayType = highwayType;
    }
    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public SpeedLimitRoadsResult() {
        this.osmPlaceInfo = new OSMPlaceInfo();
        this.maxSpeed = 0;
        this.highwayType = "";
        this.name = "";
    }
    /**
     * Full constructor.
     * @param osmPlaceInfo          OSM Cartography element information.
     * @param maxSpeed              Max allowed speed for road segment.
     * @param highwayType           The type of highway
     * @param name                  The road's name
     */
    public SpeedLimitRoadsResult(OSMPlaceInfo osmPlaceInfo, int maxSpeed, String highwayType,
                                 String name) {
        this.osmPlaceInfo = osmPlaceInfo;
        this.maxSpeed = maxSpeed;
        this.highwayType = highwayType;
        this.name = name;
    }

    /**
     * Full constructor.
     * @param osmPlaceInfo          OSM Cartography element information.
     * @param maxSpeed              Max allowed speed for road segment.
     * @param highwayType           The type of highway
     * @param name                  The road's name
     */
    public SpeedLimitRoadsResult(OSMPlaceInfo osmPlaceInfo, String maxSpeed, String highwayType,
                                 String name) {
        this.osmPlaceInfo = osmPlaceInfo;
        this.maxSpeed = Integer.parseInt(maxSpeed);
        this.highwayType = highwayType;
        this.name = name;
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
        return "SpeedLimitRoadsResult{" +
                "osmPlaceInfo=" + osmPlaceInfo +
                ", maxSpeed=" + maxSpeed +
                ", highwayType='" + highwayType + '\'' +
                ", name='" + name + '\'' +
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
        if (!(o instanceof SpeedLimitRoadsResult)) return false;

        SpeedLimitRoadsResult that = (SpeedLimitRoadsResult) o;

        if (getMaxSpeed() != that.getMaxSpeed()) return false;
        if (!getOsmPlaceInfo().equals(that.getOsmPlaceInfo())) return false;
        if (!getHighwayType().equals(that.getHighwayType())) return false;
        return getName().equals(that.getName());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        int result = getOsmPlaceInfo().hashCode();
        result = 31 * result + getMaxSpeed();
        result = 31 * result + getHighwayType().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
    //endregion

    //region Private helpers
    //endregion

}
