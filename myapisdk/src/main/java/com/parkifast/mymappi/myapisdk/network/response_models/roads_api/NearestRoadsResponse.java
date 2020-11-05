package com.parkifast.mymappi.myapisdk.network.response_models.roads_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.roads.NearestRoadsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Nearest roads response model. Contains information about the nearest road to the queried
 * {@link Coordinate}.
 */
public class NearestRoadsResponse extends BaseResponse {

    //region Attributes
    /**
     * Contains all information about this request's response
     */
    @SerializedName("data")
    private List<NearestRoadsResult> results;
    //endregion

    //region Getters and setters

    public List<NearestRoadsResult> getResults() {
        return results;
    }

    public void setResults(List<NearestRoadsResult> results) {
        this.results = results;
    }


    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public NearestRoadsResponse() {
        super("", "", 0L, "");
        this.results = new ArrayList<>();
    }

    /**
     * Basic constructor without base response data.
     * @param results        The full results model.
     */
    public NearestRoadsResponse(List<NearestRoadsResult> results) {
        super("", "", 0L, "");
        this.results = results;
    }

    /**
     * Full constructor including base response data.
     */
    public NearestRoadsResponse(String version, String provider, long timestamp, String copyright,
                                String status, List<NearestRoadsResult> result) {
        super(version, provider, timestamp, copyright, status);
        this.results = result;
    }
    //endregion

    //region Public helpers

    /**
     * String representation of current instance.
     * @return          Readable String representing this instance.
     */
    @Override
    public String toString() {
        return "NearestRoadsResponse{" +
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
        if (!(o instanceof NearestRoadsResponse)) return false;

        NearestRoadsResponse that = (NearestRoadsResponse) o;

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
