package com.parkifast.mymappi.myapisdk.network.response_models.directions_api;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.directions.MatrixDirectionsResult;
import com.parkifast.mymappi.myapisdk.network.response_models.BaseResponse;

/**
 * Matrix Directions API Response model. The response includes a list of the waypoints used
 * in the matrix, and a matrix with all the travel lengths from each source to each destination.
 */
public class MatrixDirectionsResponse extends BaseResponse {
    //region Attributes
    /**
     * Contains all information about this request's response
     */
    @SerializedName("data")
    private MatrixDirectionsResult result;
    //endregion

    //region Getters and setters

    public MatrixDirectionsResult getResult() {
        return result;
    }

    public void setResult(MatrixDirectionsResult result) {
        this.result = result;
    }


    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public MatrixDirectionsResponse() {
        super("", "", 0L, "");
        this.result = new MatrixDirectionsResult();
    }

    /**
     * Basic constructor without base response data.
     * @param result        The full {@link MatrixDirectionsResult}.
     */
    public MatrixDirectionsResponse(MatrixDirectionsResult result) {
        super("", "", 0L, "");
        this.result = result;
    }

    /**
     * Full constructor including base response data.
     */
    public MatrixDirectionsResponse(String version, String provider, long timestamp, String copyright,
                                    String status, MatrixDirectionsResult result) {
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
        return "MatrixDirectionsResponse{" +
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
        if (!(o instanceof MatrixDirectionsResponse)) return false;

        MatrixDirectionsResponse that = (MatrixDirectionsResponse) o;

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
