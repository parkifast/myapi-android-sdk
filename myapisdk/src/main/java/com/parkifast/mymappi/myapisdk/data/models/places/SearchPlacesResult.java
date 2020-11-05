package com.parkifast.mymappi.myapisdk.data.models.places;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.OSMPlaceInfo;
import java.util.HashMap;

/**
 * Represents a single result of a Search Places API response.
 */
public class SearchPlacesResult {

    //region Attributes
    @Expose(deserialize = false)
    private OSMPlaceInfo osmPlaceInfo;
    /**
     * List of attributes describing the place.
     */
    @SerializedName("tags")
    private HashMap<String, String> components;

    //endregion

    //region Getters and setters

    public OSMPlaceInfo getOsmPlaceInfo() {
        return osmPlaceInfo;
    }

    public void setOsmPlaceInfo(OSMPlaceInfo osmPlaceInfo) {
        this.osmPlaceInfo = osmPlaceInfo;
    }

    public HashMap<String, String> getComponents() {
        return components;
    }

    public void setComponents(HashMap<String, String> components) {
        this.components = components;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor
     */
    public SearchPlacesResult() {
        this.osmPlaceInfo = new OSMPlaceInfo();
        this.components = new HashMap<>();
    }

    /**
     * Full constructor.
     *
     * @param osmPlaceInfo      A {@link OSMPlaceInfo} instance representing the OSM Place.
     * @param components        A set of String properties.
     */
    public SearchPlacesResult(OSMPlaceInfo osmPlaceInfo, HashMap<String, String> components) {
        this.osmPlaceInfo = osmPlaceInfo;
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
        return "SearchPlacesResult{" +
                "osmPlaceInfo=" + osmPlaceInfo +
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
        if (!(o instanceof SearchPlacesResult)) return false;

        SearchPlacesResult that = (SearchPlacesResult) o;

        if (!getOsmPlaceInfo().equals(that.getOsmPlaceInfo())) return false;
        return getComponents().equals(that.getComponents());
    }


    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        int result = getOsmPlaceInfo().hashCode();
        result = 31 * result + getComponents().hashCode();
        return result;
    }
    //endregion
}
