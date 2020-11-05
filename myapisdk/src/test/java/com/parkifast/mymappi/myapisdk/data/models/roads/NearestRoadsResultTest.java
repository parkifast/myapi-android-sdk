package com.parkifast.mymappi.myapisdk.data.models.roads;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class NearestRoadsResultTest {

    @Before
    public void setUp() {
    }

    @Test
    public void whenCreatingResult_givenFullyProperlyConfiguredComponentsHashmap_shouldCreateProperInstance() {
        // 1) Arrange
        HashMap<String, Object> components = new HashMap<String, Object>() {{
            put("distance", 29.4);
            put("lat", 40.4444);
            put("lon", -3.3);
            put("name", "Circunvalacion M-50");
            put("highway", "motorway");
            put("lanes", "2");
            put("maxspeed", "20");
            put("oneway", "yes");
            put("ref", "M-50");
            put("ref:colour", "blue");
            put("other", "random");
        }};
        // 2) Act
        NearestRoadsResult result = new NearestRoadsResult(components);
        // 3) Assert
        assertEquals(29.4, result.getDistance(), 0.0001);
        assertEquals(new Coordinate(40.4444, -3.3), result.getSnappedCoordinate());
        assertEquals("Circunvalacion M-50", result.getName());
        assertEquals("motorway", result.getHighwayType());
        assertEquals(2, result.getLanes());
        assertEquals(20, result.getMaxSpeed());
        assertEquals("M-50", result.getRef());
        assertEquals("blue", result.getRefColor());
        assertEquals(components, result.getComponents());
    }
}