package com.parkifast.mymappi.myapisdk.data.models.roads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;

/**
 * Represents a single result of a Snap Roads API response.
 */
public class SnapRoadsResult {

    //region Attributes
    /**
     * {@link Coordinate} snapped to the nearest road.
     */
    @Expose(serialize = false)
    private Coordinate coordinate;

    //endregion

    //region Getters and setters

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor for deserializing.
     */
    public SnapRoadsResult() {
        this.coordinate = new Coordinate();
    }
    /**
     * Full constructor.
     * @param coordinate
     */
    public SnapRoadsResult(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    //endregion

    //region Public helpers
    /**
     * String representation of current instance.
     * @return          Readable String representing this instance.
     */
    @Override
    public String toString() {
        return "SnapRoadsResult{" +
                "coordinate=" + coordinate +
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
        if (!(o instanceof SnapRoadsResult)) return false;

        SnapRoadsResult that = (SnapRoadsResult) o;

        return getCoordinate().equals(that.getCoordinate());
    }

    /**
     * Hashing algorithm that uniquely identifies this instance value.
     * @return          Hashed representation of current instance.
     */
    @Override
    public int hashCode() {
        return getCoordinate() != null ? getCoordinate().hashCode() : 0;
    }
    //endregion
}
