package com.parkifast.mymappi.myapisdk.network.response_models.places_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.places.SearchPlacesResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Places API Search response model. Contains information about all nearby places that fit the
 * request criteria.
 */
public class SearchPlacesResponse extends BaseResponse {
    //region Attributes
    @SerializedName("data")
    private List<SearchPlacesResult> searchPlacesResults;

    /**
     * Next page results token. Specify this value in the next request as a parameter in order to
     * retrieve the next batch or results.
     */
    private String next;
    //endregion

    //region Getters and setters
    public List<SearchPlacesResult> getSearchPlacesResults() {
        return searchPlacesResults;
    }

    public void setSearchPlacesResults(List<SearchPlacesResult> searchPlacesResults) {
        this.searchPlacesResults = searchPlacesResults;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
    //endregion

    //region Constructors
    /**
     * Empty constructor for deserializing.
     */
    public SearchPlacesResponse() {
        super("", "", 0L, "");
        this.searchPlacesResults = new ArrayList<>();
        this.next = "";
    }

    /**
     * Basic constructor without base response data.
     * @param searchPlacesResults
     */
    public SearchPlacesResponse(List<SearchPlacesResult> searchPlacesResults, String next) {
        super("", "", 0L, "");
        this.searchPlacesResults = searchPlacesResults;
        this.next = next;
    }

    /**
     * Full constructor including base response data.
     */
    public SearchPlacesResponse(String version, String provider, long timestamp, String copyright,
                                String status, List<SearchPlacesResult> searchPlacesResults,
                                String next) {
        super(version, provider, timestamp, copyright, status);
        this.searchPlacesResults = searchPlacesResults;
        this.next = next;
    }

}
