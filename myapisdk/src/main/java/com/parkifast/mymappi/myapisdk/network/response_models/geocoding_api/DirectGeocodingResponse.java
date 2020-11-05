package com.parkifast.mymappi.myapisdk.network.response_models.geocoding_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.data.models.geocoding.DirectGeocodingResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Direct geocoding response model. Contains information about the {@link Coordinate} that the queried
 * address represents.
 */
public class DirectGeocodingResponse extends BaseResponse {

    //region Attributes
    @SerializedName("data")
    private List<DirectGeocodingResult> directGeocodingResults;
    //endregion

    //region Getters and setters

    public List<DirectGeocodingResult> getDirectGeocodingResults() {
        return directGeocodingResults;
    }

    public void setDirectGeocodingResults(List<DirectGeocodingResult> directGeocodingResults) {
        this.directGeocodingResults = directGeocodingResults;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public DirectGeocodingResponse() {
        super("", "", 0L, "");
        this.directGeocodingResults = new ArrayList<>();
    }

    /**
     * Basic constructor without base response data.
     * @param directGeocodingResults        List of direct geocoding results.
     */
    public DirectGeocodingResponse(List<DirectGeocodingResult> directGeocodingResults) {
        super("", "", 0L, "");
        this.directGeocodingResults = directGeocodingResults;
    }

    /**
     * Full constructor including base response data.
     */
    public DirectGeocodingResponse(String version, String provider, long timestamp, String copyright,
                                   String status, List<DirectGeocodingResult> directGeocodingResults) {
        super(version, provider, timestamp, copyright, status);
        this.directGeocodingResults = directGeocodingResults;
    }

    //endregion

}
