package com.parkifast.mymappi.myapisdk.data.models.common;



import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class GeometryTest {

    @Test
    public void whenSettingGeoJsonGeometry_shouldCalculateAutomaticallyTheCoordinatesList() throws JSONException {
        // 1) Arrange
        JSONObject geoJsonData = new JSONObject(
                "{\"coordinates\":[[-0.474726,39.493301],[-0.474707,39.493296],[-0.474687,39.493295]" +
                        ",[-0.474668,39.493298],[-0.47465,39.493306]],\"type\":\"LineString\"}"
        );
        // 2) Act
        Geometry geoJsonGeometry = new Geometry();
        geoJsonGeometry.setGeojson(geoJsonData);
        // 3) Assert
        assertEquals(geoJsonGeometry.getCoordinates().size(), 5);
        assertEquals(geoJsonGeometry.getCoordinates().get(0), new Coordinate(39.493301, -0.474726));
        assertEquals(geoJsonGeometry.getCoordinates().get(1), new Coordinate(39.493296, -0.474707));
        assertEquals(geoJsonGeometry.getCoordinates().get(2), new Coordinate(39.493295, -0.474687));
        assertEquals(geoJsonGeometry.getCoordinates().get(3), new Coordinate(39.493298, -0.474668));
        assertEquals(geoJsonGeometry.getCoordinates().get(4), new Coordinate(39.493306, -0.47465));
    }

    @Test
    public void whenCreatingGeoJsonGeometry_shouldCalculateAutomaticallyTheCoordinatesList() throws JSONException {
        // 1) Arrange
        JSONObject geoJsonData = new JSONObject(
                "{\"coordinates\":[[-0.474726,39.493301],[-0.474707,39.493296],[-0.474687,39.493295]" +
                        ",[-0.474668,39.493298],[-0.47465,39.493306]],\"type\":\"LineString\"}"
        );
        // 2) Act
        Geometry geoJsonGeometry = new Geometry(geoJsonData);
        // 3) Assert
        assertEquals(geoJsonGeometry.getCoordinates().size(), 5);
        assertEquals(geoJsonGeometry.getCoordinates().get(0), new Coordinate(39.493301, -0.474726));
        assertEquals(geoJsonGeometry.getCoordinates().get(1), new Coordinate(39.493296, -0.474707));
        assertEquals(geoJsonGeometry.getCoordinates().get(2), new Coordinate(39.493295, -0.474687));
        assertEquals(geoJsonGeometry.getCoordinates().get(3), new Coordinate(39.493298, -0.474668));
        assertEquals(geoJsonGeometry.getCoordinates().get(4), new Coordinate(39.493306, -0.47465));
    }
}