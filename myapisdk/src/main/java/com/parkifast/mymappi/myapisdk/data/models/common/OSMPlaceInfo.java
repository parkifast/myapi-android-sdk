package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

/**
 * Basic standard information about a specific OSM Place.
 */
public class OSMPlaceInfo {

    //region Attributes

    /**
     * Legal licence under which this data might be used.
     */
    @SerializedName("licence")
    private String licence;

    /**
     * Unique identifier for current place.
     */
    @SerializedName("place_id")
    private String placeId;

    /**
     * Type of OSM element (way, node or relation).
     */
    @SerializedName("osm_type")
    private String osmType;

    /**
     * Unique identifier for current OSM element.
     */
    @SerializedName("osm_id")
    private String osmId;
    //endregion

    //region Getters and setters

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getOsmType() {
        return osmType;
    }

    public void setOsmType(String osmType) {
        this.osmType = osmType;
    }

    public String getOsmId() {
        return osmId;
    }

    public void setOsmId(String osmId) {
        this.osmId = osmId;
    }

    //endregion

    //region Constructors
    /**
     * Basic constructor for deserialization. Initializes all fields to empty strings.
     */
    public OSMPlaceInfo() {
        this.licence =  "";
        this.placeId = "";
        this.osmType = "";
        this.osmId = "";
    }
    /**
     * Standard constructor.
     */
    public OSMPlaceInfo(String licence, String placeId, String osmType, String osmId) {
        this.licence = licence;
        this.placeId = placeId;
        this.osmType = osmType;
        this.osmId = osmId;
    }

    //endregion

    //region Exposed API
    //endregion

    //region Public helpers

    @Override
    public String toString() {
        return "OSMPlaceInfo{" +
                "licence='" + licence + '\'' +
                ", placeId='" + placeId + '\'' +
                ", osmType='" + osmType + '\'' +
                ", osmId='" + osmId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OSMPlaceInfo)) return false;

        OSMPlaceInfo that = (OSMPlaceInfo) o;

        if (!getLicence().equals(that.getLicence())) return false;
        if (!getPlaceId().equals(that.getPlaceId())) return false;
        if (!getOsmType().equals(that.getOsmType())) return false;
        return getOsmId().equals(that.getOsmId());
    }

    @Override
    public int hashCode() {
        int result = getLicence().hashCode();
        result = 31 * result + getPlaceId().hashCode();
        result = 31 * result + getOsmType().hashCode();
        result = 31 * result + getOsmId().hashCode();
        return result;
    }

    //endregion

    //region Private helpers
    //endregion

}
