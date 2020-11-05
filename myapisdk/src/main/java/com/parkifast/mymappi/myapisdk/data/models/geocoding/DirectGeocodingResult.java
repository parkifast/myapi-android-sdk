package com.parkifast.mymappi.myapisdk.data.models.geocoding;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.AddressDetails;
import com.parkifast.mymappi.myapisdk.data.models.common.BoundingBox;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.common.OSMPlaceInfo;

/**
 * Represents a single result of a Direct Geocoding API response.
 */
public class DirectGeocodingResult {

    //region Attributes
    /**
     * Information about current place and element in OSM cartography.
     */
    private OSMPlaceInfo osmPlaceInfo;
    /**
     *  {@link Coordinate} associated to the address queried for direct geocoding.
     */
    private Coordinate coordinate;
    /**
     * {@link BoundingBox} containing the found {@link Coordinate}
     */
    @SerializedName("boundingbox")
    private BoundingBox boundingBox;
    /**
     * Fully built address of found  {@link Coordinate}
     */
    @SerializedName("display_name")
    private String fullAddress;
    /**
     * Type of place found.
     */
    @SerializedName("class")
    private String type;
    /**
     * Subtype of place found.
     */
    @SerializedName("type")
    private String subtype;
    /**
     * Importance / relevance of the place found related to the query.
     */
    @SerializedName("importance")
    private double importance;

    /**
     * Distance to source in kilometers. Only available when source_lat and source_lon are used in the request.
     */
    @SerializedName("distance_to_source")
    private double distToSource;
    //endregion

    //region Getters and setters

    public OSMPlaceInfo getOsmPlaceInfo() {
        return osmPlaceInfo;
    }

    public void setOsmPlaceInfo(OSMPlaceInfo osmPlaceInfo) {
        this.osmPlaceInfo = osmPlaceInfo;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public double getImportance() {
        return importance;
    }

    public void setImportance(double importance) {
        this.importance = importance;
    }

    public double getDistToSource() {
        return distToSource;
    }

    public void setDistToSource(double distToSource) {
        this.distToSource = distToSource;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public DirectGeocodingResult() {
        this.osmPlaceInfo = new OSMPlaceInfo();
        this.coordinate = new Coordinate();
        this.boundingBox = new BoundingBox();
        this.fullAddress = "";
        this.type = "";
        this.subtype = "";
        this.importance = 0.0;
        this.distToSource = 0.0;
    }
    /**
     * Full constructor.
     * @param osmPlaceInfo      OSM Place information.
     * @param coordinate        Coordinate that represents the queried address.
     * @param boundingBox       Bounding box containing the result.
     * @param fullAddress       Fully qualified address.
     * @param type              Type of place found.
     * @param subtype           Subtype of place found.
     * @param importance        Relevance / importance of current result.
     */
    public DirectGeocodingResult(OSMPlaceInfo osmPlaceInfo, Coordinate coordinate,
                                 BoundingBox boundingBox, String fullAddress, String type,
                                 String subtype, double importance, double distToSource) {
        this.osmPlaceInfo = osmPlaceInfo;
        this.coordinate = coordinate;
        this.boundingBox = boundingBox;
        this.fullAddress = fullAddress;
        this.type = type;
        this.subtype = subtype;
        this.importance = importance;
        this.distToSource = distToSource;
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
        return "DirectGeocodingResult{" +
                "osmPlaceInfo=" + osmPlaceInfo +
                ", coordinate=" + coordinate +
                ", boundingBox=" + boundingBox +
                ", fullAddress='" + fullAddress + '\'' +
                ", type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                ", importance=" + importance +
                ", distToSource=" + distToSource +
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
        if (!(o instanceof DirectGeocodingResult)) return false;

        DirectGeocodingResult that = (DirectGeocodingResult) o;

        if (Double.compare(that.getImportance(), getImportance()) != 0) return false;
        if (Double.compare(that.getDistToSource(), getDistToSource()) != 0) return false;
        if (!getOsmPlaceInfo().equals(that.getOsmPlaceInfo())) return false;
        if (!getCoordinate().equals(that.getCoordinate())) return false;
        if (!getBoundingBox().equals(that.getBoundingBox())) return false;
        if (!getFullAddress().equals(that.getFullAddress())) return false;
        if (!getType().equals(that.getType())) return false;
        return getSubtype().equals(that.getSubtype());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getOsmPlaceInfo().hashCode();
        result = 31 * result + getCoordinate().hashCode();
        result = 31 * result + getBoundingBox().hashCode();
        result = 31 * result + getFullAddress().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getSubtype().hashCode();
        temp = Double.doubleToLongBits(getImportance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getDistToSource());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //endregion

    //region Private helpers
    //endregion

}
