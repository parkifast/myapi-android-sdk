package com.parkifast.mymappi.myapisdk.data.models.directions;

import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.RouteMatrix;
import com.parkifast.mymappi.myapisdk.data.models.common.RouteWaypoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single result of a Matrix Directions API response.
 */
public class MatrixDirectionsResult {

    //region Attributes
    /**
     * Status message indicating if the matrix calculation was successful.
     */
    @SerializedName("code")
    private String code;
    /**
     * The list of sources included in the route matrix calculation.
     */
    @SerializedName("sources")
    private List<RouteWaypoint> sources;

    /**
     * The list of destinations included in the route matrix calculation.
     */
    @SerializedName("destinations")
    private List<RouteWaypoint> destinations;

    /**
     * The matrix specifying all possible durations (travel time) from each source to each
     * destination through the fastest route possible.
     */
    @SerializedName("durations")
    private RouteMatrix durationsMatrix;

    /**
     * The matrix specifying all possible distances (travel distance) from each source to each
     * destination through the fastest route possible.
     */
    @SerializedName("distances")
    private RouteMatrix distanceMatrix;

    //endregion

    //region Getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<RouteWaypoint> getSources() {
        return sources;
    }

    public void setSources(List<RouteWaypoint> sources) {
        this.sources = sources;
    }

    public List<RouteWaypoint> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<RouteWaypoint> destinations) {
        this.destinations = destinations;
    }

    public RouteMatrix getDurationsMatrix() {
        return durationsMatrix;
    }

    public void setDurationsMatrix(RouteMatrix durationsMatrix) {
        this.durationsMatrix = durationsMatrix;
    }

    public RouteMatrix getDistanceMatrix() {
        return distanceMatrix;
    }

    public void setDistanceMatrix(RouteMatrix distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }
    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public MatrixDirectionsResult() {
        this.code = "";
        this.sources = new ArrayList<>();
        this.destinations = new ArrayList<>();
        this.durationsMatrix = new RouteMatrix();
        this.distanceMatrix = new RouteMatrix();
    }

    /**
     * Full constructor.
     *
     * @param code              Code status about the route calculation process.
     * @param sources           List of sources used.
     * @param destinations      List of destinations used.
     * @param durationsMatrix       The durations matrix.
     */
    public MatrixDirectionsResult(String code, List<RouteWaypoint> sources,
                                  List<RouteWaypoint> destinations,
                                  RouteMatrix durationsMatrix, RouteMatrix distanceMatrix) {
        this.code = code;
        this.sources = sources;
        this.destinations = destinations;
        this.durationsMatrix = durationsMatrix;
        this.durationsMatrix = distanceMatrix;
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
        return "MatrixDirectionsResult{" +
                "code='" + code + '\'' +
                ", sources=" + sources +
                ", destinations=" + destinations +
                ", durationsMatrix=" + durationsMatrix +
                ", distanceMatrix=" + distanceMatrix +
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
        if (!(o instanceof MatrixDirectionsResult)) return false;

        MatrixDirectionsResult that = (MatrixDirectionsResult) o;

        if (!getCode().equals(that.getCode())) return false;
        if (!getSources().equals(that.getSources())) return false;
        if (!getDestinations().equals(that.getDestinations())) return false;
        if (!getDurationsMatrix().equals(that.getDurationsMatrix())) return false;
        return getDistanceMatrix().equals(that.getDistanceMatrix());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        int result = getCode().hashCode();
        result = 31 * result + getSources().hashCode();
        result = 31 * result + getDestinations().hashCode();
        result = 31 * result + getDurationsMatrix().hashCode();
        result = 31 * result + getDistanceMatrix().hashCode();
        return result;
    }
    //endregion

    //region Private helpers
    //endregion

}
