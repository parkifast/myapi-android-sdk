package com.parkifast.mymappi.myapisdk.data.models.geocoding;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.AddressDetails;
import com.parkifast.mymappi.myapisdk.data.models.common.BoundingBox;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.common.OSMPlaceInfo;

/**
 * Represents a single result of a Reverse Geocoding API response.
 */
public class ReverseGeocodingResult {

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

    @SerializedName("address")
    private AddressDetails addressDetails;
    /**
     * Fully built address of found  {@link Coordinate}
     */
    @SerializedName("display_name")
    private String fullAddress;

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

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public ReverseGeocodingResult() {
        this.osmPlaceInfo = new OSMPlaceInfo();
        this.coordinate = new Coordinate();
        this.boundingBox = new BoundingBox();
        this.fullAddress = "";
        this.addressDetails = new AddressDetails();
    }
    /**
     * Full constructor.
     * @param osmPlaceInfo      OSM Place information.
     * @param coordinate        Coordinate that represents the queried address.
     * @param boundingBox       Bounding box containing the result.
     * @param addressDetails    Structure representing all address components.
     * @param fullAddress       Fully qualified address.
     */
    public ReverseGeocodingResult(OSMPlaceInfo osmPlaceInfo, Coordinate coordinate,
                                  BoundingBox boundingBox, AddressDetails addressDetails,
                                  String fullAddress) {
        this.osmPlaceInfo = osmPlaceInfo;
        this.coordinate = coordinate;
        this.boundingBox = boundingBox;
        this.fullAddress = fullAddress;
        this.addressDetails = addressDetails;
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
        return "ReverseGeocodingResult{" +
                "osmPlaceInfo=" + osmPlaceInfo.toString() +
                ", coordinate=" + coordinate.toString() +
                ", boundingBox=" + boundingBox.toString() +
                ", addressDetails=" + addressDetails.toString() +
                ", fullAddress='" + fullAddress + '\'' +
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
        if (!(o instanceof ReverseGeocodingResult)) return false;

        ReverseGeocodingResult that = (ReverseGeocodingResult) o;

        if (!getOsmPlaceInfo().equals(that.getOsmPlaceInfo())) return false;
        if (!getCoordinate().equals(that.getCoordinate())) return false;
        if (!getBoundingBox().equals(that.getBoundingBox())) return false;
        if (!getAddressDetails().equals(that.getAddressDetails())) return false;
        return getFullAddress().equals(that.getFullAddress());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return
     */
    @Override
    public int hashCode() {
        int result = getOsmPlaceInfo().hashCode();
        result = 31 * result + getCoordinate().hashCode();
        result = 31 * result + getBoundingBox().hashCode();
        result = 31 * result + getAddressDetails().hashCode();
        result = 31 * result + getFullAddress().hashCode();
        return result;
    }
    //endregion

    //region Private helpers
    //endregion

}
