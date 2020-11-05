package com.parkifast.mymappi.myapisdk.network.wrappers;

import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.remote_apis.DirectionsApi;
import com.parkifast.mymappi.myapisdk.network.request_models.directions.RouteDirectionsRequest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static com.parkifast.mymappi.myapisdk.network.request_models.common.Profile.*;
import static org.junit.Assert.*;

public class DirectionsApiWrapperTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    DirectionsApi directionsApi;

    private RouteDirectionsRequest request;
    private DirectionsApiWrapper wrapper;

    @Before
    public void setUp() {
        wrapper = new DirectionsApiWrapper(directionsApi);
    }

    @Test
    public void whenExtractingWaypoints_givenWaypointQueriesListInRequest_shouldExtractStringConcatenatedBySemiColonWithNoTrailingSemicolon() {
        // 1) Arrange
        request = new RouteDirectionsRequest.Builder()
                .setOrigin(new Coordinate(40.4, -3.3))
                .setDestQuery("Calle electrodo 68, rivas vaciamadrid")
                .addWaypointQuery("wp1")
                .addWaypointQuery("wp2")
                .addWaypointQuery("wp3")
                .setProfile(car)
                .build();
        String expectedWpsExtracted = "wp1;wp2;wp3";
        // 2) Act
        String actualWpsExtracted = wrapper.extractWaypoints(request);
        // 3) Assert
        assertEquals(expectedWpsExtracted, actualWpsExtracted);
    }

    @Test
    public void whenExtractingWaypoints_givenWaypointCoordinatesListInRequest_shouldExtractStringConcatenatedBySemiColonWithNoTrailingSemicolon() {
        // 1) Arrange
        request = new RouteDirectionsRequest.Builder()
                .setOrigin(new Coordinate(40.4, -3.3))
                .setDestQuery("Calle electrodo 68, rivas vaciamadrid")
                .addWaypoint(new Coordinate(40.41, -3.31))
                .addWaypoint(new Coordinate(40.42, -3.32))
                .addWaypoint(new Coordinate(40.43, -3.33))
                .setProfile(on_foot)
                .build();
        String expectedWpsExtracted = "40.41,-3.31;40.42,-3.32;40.43,-3.33";
        // 2) Act
        String actualWpsExtracted = wrapper.extractWaypoints(request);
        // 3) Assert
        assertEquals(expectedWpsExtracted, actualWpsExtracted);
    }
}