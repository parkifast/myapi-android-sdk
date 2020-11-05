package com.parkifast.mymappi.myapisdk.network.response_models.roads_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.roads.DistanceRoadsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

/**
 * Distance roads response model. Contains information about distance from the specified
 * {@link Coordinate} to the nearest road (straight line length perpendicular to its longitudinal axis).
 */
public class DistanceRoadsResponse extends BaseResponse {
    //region Attributes
    /**
     * Contains all information about this request's response
     */
    @SerializedName("data")
    private DistanceRoadsResult result;
    //endregion

    //region Getters and setters


    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public DistanceRoadsResponse() {
        super("", "", 0L, "");
        this.result = new DistanceRoadsResult();
    }

    /**
     * Basic constructor without base response data.
     * @param coordinate        The snapped to road coordinate.
     */
    public DistanceRoadsResponse(DistanceRoadsResult result) {
        super("", "", 0L, "");
        this.result = result;
    }

    /**
     * Full constructor including base response data.
     */
    public DistanceRoadsResponse(String version, String provider, long timestamp, String copyright,
                                 String status, DistanceRoadsResult result) {
        super(version, provider, timestamp, copyright, status);
        this.result = result;
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
        return "DistanceRoadsResponse{" +
                "result=" + result +
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
        if (!(o instanceof DistanceRoadsResponse)) return false;

        DistanceRoadsResponse that = (DistanceRoadsResponse) o;

        return result.equals(that.result);
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        return result.hashCode();
    }
    //endregion

    //region Private helpers
    //endregion



}
