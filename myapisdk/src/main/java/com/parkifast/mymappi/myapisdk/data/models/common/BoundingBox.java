package com.parkifast.mymappi.myapisdk.data.models.common;

import android.os.Build;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Represents a bounding box for a geographical area, expressed by its north-west coordinate
 * (top-left corner of the box) and its south-east coordinate (bottom-right corner).
 */
public class BoundingBox {

    //region Attributes
    /**
     * South latitude of the bounding box
     */
    @SerializedName("south_lat")
    @Expose(deserialize = false)
    private double southLat;

    /**
     * North latitude of the bounding box
     */
    @SerializedName("north_lat")
    @Expose(deserialize = false)
    private double northLat;

    /**
     * West longitude of the bounding box
     */
    @SerializedName("west_lon")
    @Expose(deserialize = false)
    private double westLon;

    /**
     * East longitude of the bounding box
     */
    @SerializedName("east_lon")
    @Expose(deserialize = false)
    private double eastLon;

    //endregion

    //region Getters and setters

    public double getSouthLat() {
        return southLat;
    }

    public void setSouthLat(double southLat) {
        this.southLat = southLat;
    }

    public double getNorthLat() {
        return northLat;
    }

    public void setNorthLat(double northLat) {
        this.northLat = northLat;
    }

    public double getWestLon() {
        return westLon;
    }

    public void setWestLon(double westLon) {
        this.westLon = westLon;
    }

    public double getEastLon() {
        return eastLon;
    }

    public void setEastLon(double eastLon) {
        this.eastLon = eastLon;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor.
     */
    public BoundingBox() {
        this.southLat = 0.0;
        this.northLat = 0.0;
        this.westLon = 0.0;
        this.eastLon = 0.0;
    }

    /**
     * Used when deserializing OSM responses, which are given as a list of coodinate components.
     * This list should have the following structure:
     * <ol>
     *     <li>
     *         Index 0: South latitude
     *     </li>
     *     <li>
     *          Index 1: North latitude
     *      </li>
     *     <li>
     *         Index 2: West longitude
     *     </li>
     *     <li>
     *          Index 3: East longitude
     *      </li>
     * </ol>
     * @param coordinateComponents      List of latitudes and longitudes defining the box.
     */
    public BoundingBox(List<String> components) {
        if (components.size() != 4) {
            throw new IllegalArgumentException("Input parameters are not sufficient to determine bounding box.");
        }
        try {
            this.southLat = Double.parseDouble(components.get(0));
            this.northLat = Double.parseDouble(components.get(1));
            this.westLon = Double.parseDouble(components.get(2));
            this.eastLon = Double.parseDouble(components.get(3));
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Input parameters are invalid to determine bounding box.");
        }
    }

    /**
     * Basic constructor to build {@link BoundingBox} item.
     * @param southLat      South latitude component.
     * @param northLat      North latitude component.
     * @param westLon       West longitude component.
     * @param eastLon       East longitudde component.
     */
    public BoundingBox(double southLat, double northLat, double westLon, double eastLon) {
        this.southLat = southLat;
        this.northLat = northLat;
        this.westLon = westLon;
        this.eastLon = eastLon;
    }

    //endregion

    //region Exposed API

    /**
     * Retrieves top left coordinate of the bounding box.
     * @return          Top left {@link Coordinate} of the bounding box.
     */
    public Coordinate getTopLeft() {
        return new Coordinate(this.northLat, this.westLon);
    }

    /**
     * Retrieves top right coordinate of the bounding box.
     * @return          Top right {@link Coordinate} of the bounding box.
     */
    public Coordinate getTopRight() {
        return new Coordinate(this.northLat, this.eastLon);
    }

    /**
     * Retrieves bottom left coordinate of the bounding box.
     * @return          Bottom left {@link Coordinate} of the bounding box.
     */
    public Coordinate getBottomLeft() {
        return new Coordinate(this.southLat, this.westLon);
    }

    /**
     * Retrieves bottom right coordinate of the bounding box.
     * @return          Bottom right {@link Coordinate} of the bounding box.
     */
    public Coordinate getBottomRight() {
        return new Coordinate(this.southLat, this.eastLon);
    }
    //endregion

    //region Public helpers

    /**
     * {@link String} representation of current object.
     * @return          A {@link String} representation of current object.
     */
    @Override
    public String toString() {
        return "BoundingBox{" +
                "southLat=" + southLat +
                ", northLat=" + northLat +
                ", westLon=" + westLon +
                ", eastLon=" + eastLon +
                '}';
    }

    /**
     * Compares two {@link BoundingBox} objects by checking each coordinate component.
     * @param o         Another {@link BoundingBox} object to compare to.
     * @return          {@code true} when all components are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoundingBox)) return false;
        BoundingBox that = (BoundingBox) o;
        return  Double.compare(that.southLat, southLat) == 0 &&
                Double.compare(that.northLat, northLat) == 0 &&
                Double.compare(that.westLon, westLon) == 0 &&
                Double.compare(that.eastLon, eastLon) == 0;
    }

    /**
     * Hashing algorithm to easily compare objects.
     * @return      A hash representing the object.
     */
    @Override
    public int hashCode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Objects.hash(southLat, northLat, westLon, eastLon);
        }
        return toString().hashCode();
    }

    //endregion

    //region Private helpers
    //endregion

}
