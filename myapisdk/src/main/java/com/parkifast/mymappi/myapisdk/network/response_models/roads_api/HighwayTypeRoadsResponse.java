package com.parkifast.mymappi.myapisdk.network.response_models.roads_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.roads.HighwayTypeRoadsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

/**
 * Highway type roads response model. Contains information about the type of highway the queried
 * {@link Coordinate} belongs to (or is nearest to).
 */
public class HighwayTypeRoadsResponse extends BaseResponse {

    //region Attributes
    /**
     * Contains all information about this request's response
     */
    @SerializedName("data")
    private HighwayTypeRoadsResult result;
    //endregion

    //region Getters and setters

    public HighwayTypeRoadsResult getResult() {
        return result;
    }

    public void setResult(HighwayTypeRoadsResult result) {
        this.result = result;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public HighwayTypeRoadsResponse() {
        super("", "", 0L, "");
        this.result = new HighwayTypeRoadsResult();
    }

    /**
     * Basic constructor without base response data.
     * @param coordinate        The snapped to road coordinate.
     */
    public HighwayTypeRoadsResponse(HighwayTypeRoadsResult result) {
        super("", "", 0L, "");
        this.result = result;
    }

    /**
     * Full constructor including base response data.
     */
    public HighwayTypeRoadsResponse(String version, String provider, long timestamp, String copyright,
                                    String status, HighwayTypeRoadsResult result) {
        super(version, provider, timestamp, copyright, status);
        this.result = result;
    }
    //endregion

}
