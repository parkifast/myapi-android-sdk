package com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.geocoding.ReverseGeocodingResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

/**
 * Reverse geocoding response model. Contains information about the address that the queried
 * {@link Coordinate} represents.
 */
public class ReverseGeocodingResponse extends BaseResponse {
    //region Attributes
    @SerializedName("data")
    private ReverseGeocodingResult reverseGeocodingResult;
    //endregion

    //region Getters and setters

    public ReverseGeocodingResult getReverseGeocodingResult() {
        return reverseGeocodingResult;
    }

    public void setReverseGeocodingResult(ReverseGeocodingResult reverseGeocodingResult) {
        this.reverseGeocodingResult = reverseGeocodingResult;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public ReverseGeocodingResponse() {
        super("", "", 0L, "");
        this.reverseGeocodingResult = new ReverseGeocodingResult();
    }

    /**
     * Basic constructor without base response data.
     * @param reverseGeocodingResult        List of direct geocoding results.
     */
    public ReverseGeocodingResponse(ReverseGeocodingResult reverseGeocodingResult) {
        super("", "", 0L, "");
        this.reverseGeocodingResult = reverseGeocodingResult;
    }

    /**
     * Full constructor including base response data.
     */
    public ReverseGeocodingResponse(String version, String provider, long timestamp, String copyright,
                                    String status, ReverseGeocodingResult reverseGeocodingResult) {
        super(version, provider, timestamp, copyright, status);
        this.reverseGeocodingResult = reverseGeocodingResult;
    }

}
