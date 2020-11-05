package com.parkifast.mymappi.myapisdk.data.models.roads;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a single result of a Highway Type Roads API response.
 */
public class HighwayTypeRoadsResult {

    //region Attributes
    /**
     * Indicates whether the highway type retrieval was successful or not.
     */
    @SerializedName("success")
    private boolean success;
    /**
     * The queried road highway type.
     */
    @SerializedName("highway")
    private String highwayType;
    //endregion

    //region Getters and setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getHighwayType() {
        return highwayType;
    }

    public void setHighwayType(String highwayType) {
        this.highwayType = highwayType;
    }


    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public HighwayTypeRoadsResult() {
        this.success = false;
        this.highwayType = "";
    }
    /**
     * Full constructor.
     * @param success           Whether the highway type retrieval was successful or not
     * @param highwayType       The highway type associated to the queried road.
     */
    public HighwayTypeRoadsResult(boolean success, String highwayType) {
        this.success = success;
        this.highwayType = highwayType;
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
        return "HighwayTypeRoadsResult{" +
                "success=" + success +
                ", highwayType='" + highwayType + '\'' +
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
        if (!(o instanceof HighwayTypeRoadsResult)) return false;

        HighwayTypeRoadsResult that = (HighwayTypeRoadsResult) o;

        if (isSuccess() != that.isSuccess()) return false;
        return getHighwayType().equals(that.getHighwayType());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        int result = (isSuccess() ? 1 : 0);
        result = 31 * result + getHighwayType().hashCode();
        return result;
    }
    //endregion

    //region Private helpers
    //endregion

}
