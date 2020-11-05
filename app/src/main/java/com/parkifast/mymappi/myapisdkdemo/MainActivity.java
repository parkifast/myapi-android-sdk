package com.parkifast.mymappi.myapisdkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parkifast.mymappi.myapisdk.config.MyapiSDK;
import com.parkifast.mymappi.myapisdk.data.models.common.Coordinate;
import com.parkifast.mymappi.myapisdk.network.request_models.common.Profile;
import com.parkifast.mymappi.myapisdk.network.request_models.directions.MatrixDirectionsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.directions.RouteDirectionsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.directions.TravelingSalesmanDirectionsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.geocoding.DirectGeocodingRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.geocoding.ReverseGeocodingRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.places.SearchPlacesRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.DistanceRoadsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.HighwayTypeRoadsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.NearestRoadsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.SnapRoadsRequest;
import com.parkifast.mymappi.myapisdk.network.request_models.roads.SpeedLimitRoadsRequest;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

import static com.parkifast.mymappi.myapisdk.network.request_models.common.Geometry.polyline;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Init SDK
        MyapiSDK myapi = MyapiSDK.getInstance(this);
        myapi.init();
        // Test APIs
        testDirectGeocodingWithNoSource(myapi);
        testDirectGeocodingWithSource(myapi);
        testReverseGeocoding(myapi);
        testSnapToRoad(myapi);
        testRoadsGetHighwayType(myapi);
        testRoadsSpeedLimit(myapi);
        testRoadsDistance(myapi);
        testRoadsNearest(myapi);
        testDirections(myapi);
        testMatrixDirections(myapi);
        testTravelingSalesmanDirections(myapi);
        testSearchPlaces(myapi);
        testSearchPlacesWithNext(myapi);
        testSearchPlacesWithLimit(myapi);
    }

    private void testSearchPlacesWithLimit(MyapiSDK myapi) {
        SearchPlacesRequest request = new SearchPlacesRequest.Builder()
                .setCoordinate(new Coordinate(40.368704, -3.555749))
                .setRadius(5000)
                .setLimit(50)
                .build();
        Disposable d = myapi.placesApi().search(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testSearchPlacesWithNext(MyapiSDK myapi) {
        SearchPlacesRequest request = new SearchPlacesRequest.Builder()
                .setCoordinate(new Coordinate(40.368704, -3.555749))
                .setRadius(10000)
                .build();
        Disposable d = myapi.placesApi().search(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                            if(!response.getNext().isEmpty()) {
                                request.setNext(response.getNext());
                                Disposable innerDisp = myapi.placesApi().search(request)
                                        .subscribe(
                                                innerResponse -> {
                                                    Log.d(TAG, "onSuccess: Second batch of results received");
                                                    Log.d(TAG, "onSuccess: " + response.toString());
                                                },
                                                err -> {
                                                    Log.e(TAG, "onError: Error while performing inner request", err);
                                                }
                                        );

                            }
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testSearchPlaces(MyapiSDK myapi) {
        SearchPlacesRequest request = new SearchPlacesRequest.Builder()
                .setCoordinate(new Coordinate(40.368704, -3.555749))
                .setRadius(50)
                .build();
        Disposable d = myapi.placesApi().search(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testTravelingSalesmanDirections(MyapiSDK myapi) {
        List<Coordinate> coordinates = new ArrayList<Coordinate>() {{
            add(new Coordinate(40.352509,-3.524472));
            add(new Coordinate(40.356966,-3.540287));
            add(new Coordinate(40.348114,-3.536061));
        }};
        TravelingSalesmanDirectionsRequest request = new TravelingSalesmanDirectionsRequest.Builder()
                .setProfile(Profile.on_foot)
                .setCoordinates(coordinates)
                .addCoordinate(new Coordinate(40.360551,-3.533663))
                .setSource(TravelingSalesmanDirectionsRequest.Source.first)
                .setDestination(TravelingSalesmanDirectionsRequest.Destination.last)
                .build();
        Disposable d = myapi.directionsApi().travelingSalesman(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testMatrixDirections(MyapiSDK myapi) {
        List<Coordinate> coordinates = new ArrayList<Coordinate>() {{
            add(new Coordinate(40.352509,-3.524472));
            add(new Coordinate(40.356966,-3.540287));
            add(new Coordinate(40.348114,-3.536061));
        }};
        MatrixDirectionsRequest request = new MatrixDirectionsRequest.Builder()
                .setProfile(Profile.on_foot)
                .setCoordinates(coordinates)
                .addCoordinate(new Coordinate(40.360551,-3.533663))
                .setAnnotations(MatrixDirectionsRequest.Annotations.all)
//                .setSources(new ArrayList<Integer>() {{add(0); add(1);}})
//                .setDestinations(new ArrayList<Integer>() {{add(2); add(3);}})
                .build();
        Disposable d = myapi.directionsApi().calcMatrix(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testDirections(MyapiSDK myapi) {
        RouteDirectionsRequest request = new RouteDirectionsRequest.Builder()
                .setProfile(Profile.car)
                .setOrigQuery("Avda Doctor Esquerdo 187")
                .addWaypoint(new Coordinate(42.3, -4.3))
                .addWaypoint(new Coordinate(39.3, -4.3))
                .setDestination(new Coordinate(41.4, -3.3))
                .setGeometry(polyline)
                .build();
        Disposable d = myapi.directionsApi().calcRoute(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testRoadsNearest(MyapiSDK myapi) {
        NearestRoadsRequest request = new NearestRoadsRequest.Builder()
                .setCoordinate(new Coordinate(40.368704, -3.555749))
                .build();
        Disposable d = myapi.roadsApi().nearest(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testRoadsDistance(MyapiSDK myapi) {
        DistanceRoadsRequest request = new DistanceRoadsRequest.Builder()
                .setCoordinate(new Coordinate(40.368704, -3.555749))
                .build();
        Disposable d = myapi.roadsApi().distance(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testRoadsSpeedLimit(MyapiSDK myapi) {
        SpeedLimitRoadsRequest request = new SpeedLimitRoadsRequest.Builder()
                .setCoordinate(new Coordinate(40.4166314, -3.7038148))
                .build();
        Disposable d = myapi.roadsApi().speedLimit(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testRoadsGetHighwayType(MyapiSDK myapi) {
        HighwayTypeRoadsRequest request = new HighwayTypeRoadsRequest.Builder()
                .setCoordinate(new Coordinate(40.368704, -3.555749))
                .build();
        Disposable d = myapi.roadsApi().highwayType(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testSnapToRoad(MyapiSDK myapi) {
        SnapRoadsRequest request = new SnapRoadsRequest.Builder()
                .setCoordinate(new Coordinate(40.368704, -3.555749))
                .build();
        Disposable d = myapi.roadsApi().snap(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testReverseGeocoding(MyapiSDK myapi) {
        ReverseGeocodingRequest request = new ReverseGeocodingRequest.Builder()
                .setCoordinate(new Coordinate(40.355238, -3.541716))
                .build();
        Disposable d = myapi.geocodingApi().reverse(request)
                .subscribe(
                    response -> {
                        Log.d(TAG, "onSuccess: Response received");
                        Log.d(TAG, "onSuccess: " + response.toString());
                    },
                    err -> {
                        Log.e(TAG, "onError: Error while performing request", err);
                    }
        );
    }

    private void testDirectGeocodingWithSource(MyapiSDK myapi) {
        DirectGeocodingRequest request = new DirectGeocodingRequest.Builder()
                .setQuery("Avenida Pablo Iglesias 19")
                .setSource(new Coordinate(40.4, -3.3))
                .build();
        Disposable d = myapi.geocodingApi().direct(request)
                .subscribe(
                        response -> {
                            Log.d(TAG, "onSuccess: Response received");
                            Log.d(TAG, "onSuccess: " + response.toString());
                        },
                        err -> {
                            Log.e(TAG, "onError: Error while performing request", err);
                        }
                );
    }

    private void testDirectGeocodingWithNoSource(MyapiSDK myapi) {
        DirectGeocodingRequest request = new DirectGeocodingRequest.Builder()
                .setQuery("Avenida Pablo Iglesias 19")
                .build();
        Disposable d = myapi.geocodingApi().direct(request)
                .subscribe(
                    response -> {
                        Log.d(TAG, "onSuccess: Response received");
                        Log.d(TAG, "onSuccess: " + response.toString());
                    },
                    err -> {
                        Log.e(TAG, "onError: Error while performing request", err);
                    }
                );
    }
}
