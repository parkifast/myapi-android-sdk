package com.parkifast.mymappi.myapisdk.network.response_models.roads_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.roads.SpeedLimitRoadsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Speed limit roads response model. Contains information about speed limit associated to the
 * nearest road segment to the queried {@link Coordinate}.
 */
public class SpeedLimitRoadsResponse extends BaseResponse {
    //region Attributes
    /**
     * Contains all information about this request's response
     */
    @SerializedName("data")
    private List<SpeedLimitRoadsResult> results;
    //endregion

    //region Getters and setters

    public List<SpeedLimitRoadsResult> getResults() {
        return results;
    }

    public void setResults(List<SpeedLimitRoadsResult> results) {
        this.results = results;
    }
    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public SpeedLimitRoadsResponse() {
        super("", "", 0L, "");
        this.results = new ArrayList<>();
    }

    /**
     * Basic constructor without base response data.
     * @param results        List of {@link SpeedLimitRoadsResult}s.
     */
    public SpeedLimitRoadsResponse(List<SpeedLimitRoadsResult> results) {
        super("", "", 0L, "");
        this.results = results;
    }

    /**
     * Full constructor including base response data.
     */
    public SpeedLimitRoadsResponse(String version, String provider, long timestamp, String copyright,
                                   String status, List<SpeedLimitRoadsResult> results) {
        super(version, provider, timestamp, copyright, status);
        this.results = results;
    }
    //endregion

    //region Public helpers

    /**
     * String representation of current instance.
     * @return          Readable String representing this instance.
     */
    @Override
    public String toString() {
        return "SpeedLimitRoadsResponse{" +
                "results=" + results +
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
        if (!(o instanceof SpeedLimitRoadsResponse)) return false;

        SpeedLimitRoadsResponse that = (SpeedLimitRoadsResponse) o;

        return getResults().equals(that.getResults());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        return getResults().hashCode();
    }

    //endregion

}
