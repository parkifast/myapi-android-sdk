package com.parkifast.mymappi.myapisdk.data.models.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Durations matrix. Computed travel time matrix from every source to every destination.
 */
public class RouteMatrix {

    //region Attributes
    /**
     * Calculated Matrix. Computed travel time / travel distance matrix from every source to
     * every destination.
     */
    private List<List<Double>> matrix;

    //endregion

    //region Getters and setters

    public List<List<Double>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Double>> matrix) {
        this.matrix = matrix;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor
     */
    public RouteMatrix() {
        this.matrix = new ArrayList<>(new ArrayList<>());
    }

    /**
     * Full constructor
     * @param matrix         Route matrix.
     */
    public RouteMatrix(List<List<Double>> matrix) {
        this.matrix = matrix;
    }

    //endregion

    //region Exposed API
    //endregion

    //region Public helpers

    /**
     * String representation
     * @return      String representation
     */
    @Override
    public String toString() {
        return "RouteMatrix{" +
                "matrix=" + matrix +
                '}';
    }

    /**
     * Compare two instances.
     * @param o         Another instance to compare to.
     * @return          {@code true} when all fields are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteMatrix)) return false;

        RouteMatrix that = (RouteMatrix) o;

        return getMatrix().equals(that.getMatrix());
    }

    /**
     * Hashing algorithm
     * @return      Uniquely identifies an instance.
     */
    @Override
    public int hashCode() {
        return getMatrix().hashCode();
    }

    //endregion

    //region Private helpers
    //endregion

}
