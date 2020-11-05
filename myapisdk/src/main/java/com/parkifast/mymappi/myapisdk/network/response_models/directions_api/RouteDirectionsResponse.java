package com.parkifast.mymappi.myapisdk.network.response_models.directions_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.directions.RouteDirectionsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

/**
 * Route Directions API Response model. The response includes a list of calculated routes
 * according to the specified parameters, with all necessary information for routing.
 */
public class RouteDirectionsResponse extends BaseResponse {
    //region Attributes
    /**
     * Contains all information about this request's response
     */
    @SerializedName("data")
    private RouteDirectionsResult result;
    //endregion

    //region Getters and setters

    public RouteDirectionsResult getResult() {
        return result;
    }

    public void setResult(RouteDirectionsResult result) {
        this.result = result;
    }


    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public RouteDirectionsResponse() {
        super("", "", 0L, "");
        this.result = new RouteDirectionsResult();
    }

    /**
     * Basic constructor without base response data.
     * @param result        The full {@link RouteDirectionsResult}.
     */
    public RouteDirectionsResponse(RouteDirectionsResult result) {
        super("", "", 0L, "");
        this.result = result;
    }

    /**
     * Full constructor including base response data.
     */
    public RouteDirectionsResponse(String version, String provider, long timestamp, String copyright,
                                   String status, RouteDirectionsResult result) {
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
        return "RouteDirectionsResponse{" +
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
        if (!(o instanceof RouteDirectionsResponse)) return false;

        RouteDirectionsResponse that = (RouteDirectionsResponse) o;

        return getResult().equals(that.getResult());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        return getResult().hashCode();
    }
    //endregion

    //region Private helpers
    //endregion



}
