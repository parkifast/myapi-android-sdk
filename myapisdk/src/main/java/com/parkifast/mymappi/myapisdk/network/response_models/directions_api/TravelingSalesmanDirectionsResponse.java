package com.parkifast.mymappi.myapisdk.network.response_models.directions_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.directions.RouteDirectionsResult;
import com.parkifast.mymappi.myapisdk.data.models.directions.TravelingSalesmanDirectionsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

/**
 * Traveling Salesman Directions API Response model. The response includes the optimal route
 * according to the input parameters in order to go through every waypoint in the least time
 * possible.
 */
public class TravelingSalesmanDirectionsResponse extends BaseResponse {
    //region Attributes
    /**
     * Contains all information about this request's response
     */
    @SerializedName("data")
    private TravelingSalesmanDirectionsResult result;
    //endregion

    //region Getters and setters

    public TravelingSalesmanDirectionsResult getResult() {
        return result;
    }

    public void setResult(TravelingSalesmanDirectionsResult result) {
        this.result = result;
    }


    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public TravelingSalesmanDirectionsResponse() {
        super("", "", 0L, "");
        this.result = new TravelingSalesmanDirectionsResult();
    }

    /**
     * Basic constructor without base response data.
     * @param result        The full {@link RouteDirectionsResult}.
     */
    public TravelingSalesmanDirectionsResponse(TravelingSalesmanDirectionsResult result) {
        super("", "", 0L, "");
        this.result = result;
    }

    /**
     * Full constructor including base response data.
     */
    public TravelingSalesmanDirectionsResponse(String version, String provider, long timestamp,
                                               String copyright, String status,
                                               TravelingSalesmanDirectionsResult result) {
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
        return "TravelingSalesmanDirectionsResponse{" +
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
        if (!(o instanceof TravelingSalesmanDirectionsResponse)) return false;

        TravelingSalesmanDirectionsResponse that = (TravelingSalesmanDirectionsResponse) o;

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
