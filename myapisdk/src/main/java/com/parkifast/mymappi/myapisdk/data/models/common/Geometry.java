package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.JsonAdapter;
import com.parkifast.mymappi.myapisdk.config.network.translations.common.GeometryJsonDeserializer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The geometry of the route segment, it's format will depend on the geometries parameter.
 * Possibilities are:
 * <table>
 * <thead>
 * <tr>
 * <th><code>geometry</code></th>
 * <th></th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td>polyline</td>
 * <td><a href="https://www.npmjs.com/package/polyline">polyline</a>
 *  with precision 5 in
 * [
 * latitude,longitude
 * ]
 *  encoding</td>
 * </tr>
 * <tr>
 * <td>polyline6</td>
 * <td><a href="https://www.npmjs.com/package/polyline">polyline</a>
 *  with precision 6 in
 * [
 * latitude,longitude
 * ]
 *  encoding</td>
 * </tr>
 * <tr>
 * <td>geojson</td>
 * <td><a href="http://geojson.org/geojson-spec.html#linestring">GeoJSON <code>LineString</code></a></td>
 * </tr>
 * </tbody>
 * </table>
 */
@JsonAdapter(GeometryJsonDeserializer.class)
public class Geometry {

    //region Attributes
    /**
     * Encoded polyline with precision 5 or 6 in [latitude, longitude] depending on the
     * parameter {@code geometries} in the request
     */
    private String polyline;

    /**
     * Encoded in GeoJSON format, ready to use with maps such as Google Maps or Mapbox.
     */
    private JSONObject geojson;

    /**
     * List of coordinates that represent the route segment. Only available when original format
     * was GeoJSON.
     */
    private List<Coordinate> coordinates;

    //endregion

    //region Getters and setters

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    public JSONObject getGeojson() {
        return geojson;
    }

    public void setGeojson(JSONObject geojson) {
        this.geojson = geojson;
        this.coordinates = parseGeoJSON();
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor
     */
    public Geometry() {
        this.polyline = "";
        this.geojson = new JSONObject();
        this.coordinates = new ArrayList<>();
    }

    /**
     * Specific constructor for polyline formats.
     * @param polyline      The encoded polyline
     */
    public Geometry(String polyline) {
        this.polyline = polyline;
        this.geojson = new JSONObject();
        this.coordinates = new ArrayList<>();
    }

    /**
     * Specific constructor via GeoJSON
     * @param geojson       A {@link JSONObject} containing a GeoJSON format.
     */
    public Geometry(JSONObject geojson) {
        this.polyline = "";
        this.geojson = geojson;
        this.coordinates = parseGeoJSON();
    }

    /**
     * Full constructor
     * @param polyline
     * @param geojson
     * @param coordinates
     */
    public Geometry(String polyline, JSONObject geojson, List<Coordinate> coordinates) {
        this.polyline = polyline;
        this.geojson = geojson;
        this.coordinates = coordinates;
    }

    //endregion

    //region Exposed API

    //endregion

    //region Public helpers

    /**
     * String representation of the {@link Geometry}.
     * @return      String representation of the {@link Geometry}.
     */
    @Override
    public String toString() {
        return "Geometry{" +
                "polyline='" + polyline + '\'' +
                ", geojson=" + geojson +
                ", coordinates=" + coordinates +
                '}';
    }

    /**
     * Compare two instances of {@link Geometry}
     * @param o     Another instance to compare to.
     * @return      {@code true} when both have the same values.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geometry)) return false;

        Geometry geometry = (Geometry) o;

        if (!getPolyline().equals(geometry.getPolyline())) return false;
        if (!getGeojson().equals(geometry.getGeojson())) return false;
        return getCoordinates().equals(geometry.getCoordinates());
    }

    /**
     * Uniquely identify an instance through a hashing algorithm.
     * @return          A hash that uniquely identifies this set of values.
     */
    @Override
    public int hashCode() {
        int result = getPolyline().hashCode();
        result = 31 * result + getGeojson().hashCode();
        result = 31 * result + getCoordinates().hashCode();
        return result;
    }

    //endregion

    //region Private helpers

    /**
     * Extracts list of {@link Coordinate}s from GeoJSON format.
     * @return          A {@link List<Coordinate>}s.
     */
    private List<Coordinate> parseGeoJSON() {
        List<Coordinate> result = new ArrayList<>();
        try {
            if(this.geojson != null && this.geojson.has("coordinates")) {
                JSONArray coordinates = this.geojson.getJSONArray("coordinates");
                for(int i = 0; i < coordinates.length(); i++) {
                    JSONArray coordinate = coordinates.getJSONArray(i);
                    result.add(new Coordinate(
                            // Swap order since it comes in lon/lat format
                            coordinate.getDouble(1), coordinate.getDouble(0)
                    ));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
    //endregion

}
