package com.parkifast.mymappi.myapisdk.data.models.common;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoundingBoxTest {
    private double NORTH_LAT = 40.4;
    private double SOUTH_LAT = 38.4;
    private double WEST_LON = -3.3;
    private double EAST_LON = -0.3;

    private BoundingBox bBox;

    @Before
    public void setUp() {
        bBox = new BoundingBox(SOUTH_LAT, NORTH_LAT, WEST_LON, EAST_LON);
    }

    @Test
    public void getTopLeft() {
        // 1) Arrange
        Coordinate expectedTopLeft = new Coordinate(NORTH_LAT, WEST_LON);
        // 2) Act
        Coordinate topLeft = bBox.getTopLeft();
        // 3) Assert
        assertEquals(topLeft, expectedTopLeft);
    }

    @Test
    public void getTopRight() {
        // 1) Arrange
        Coordinate expectedTopRight = new Coordinate(NORTH_LAT, EAST_LON);
        // 2) Act
        Coordinate topRight = bBox.getTopRight();
        // 3) Assert
        assertEquals(topRight, expectedTopRight);
    }

    @Test
    public void getBottomLeft() {
        // 1) Arrange
        Coordinate expectedBottomLeft = new Coordinate(SOUTH_LAT, WEST_LON);
        // 2) Act
        Coordinate bottomLeft = bBox.getBottomLeft();
        // 3) Assert
        assertEquals(bottomLeft, expectedBottomLeft);
    }

    @Test
    public void getBottomRight() {
        // 1) Arrange
        Coordinate expectedBottomRight = new Coordinate(SOUTH_LAT, EAST_LON);
        // 2) Act
        Coordinate bottomRight = bBox.getBottomRight();
        // 3) Assert
        assertEquals(bottomRight, expectedBottomRight);
    }
}