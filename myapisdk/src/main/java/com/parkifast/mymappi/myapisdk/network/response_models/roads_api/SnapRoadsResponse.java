package com.parkifast.mymappi.myapisdk.network.response_models.roads_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.roads.SnapRoadsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

/**
 * Snap to roads response model. Snaps the queried {@link Coordinate} to the nearest road.
 */
public class SnapRoadsResponse extends BaseResponse {

    //region Attributes
    @SerializedName("data")
    private SnapRoadsResult result;
    //endregion

    //region Getters and setters

    public SnapRoadsResult getResult() {
        return result;
    }

    public void setResult(SnapRoadsResult result) {
        this.result = result;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public SnapRoadsResponse() {
        super("", "", 0L, "");
        this.result = new SnapRoadsResult();
    }

    /**
     * Basic constructor without base response data.
     * @param result        The snapped to road coordinate.
     */
    public SnapRoadsResponse(SnapRoadsResult result) {
        super("", "", 0L, "");
        this.result = result;
    }

    /**
     * Full constructor including base response data.
     */
    public SnapRoadsResponse(String version, String provider, long timestamp, String copyright,
                             String status, SnapRoadsResult result) {
        super(version, provider, timestamp, copyright, status);
        this.result = result;
    }

    //endregion

}
