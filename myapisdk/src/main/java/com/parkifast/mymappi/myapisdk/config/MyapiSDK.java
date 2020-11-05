package com.parkifast.mymappi.myapisdk.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.parkifast.mymappi.myapisdk.config.dependencies.components.AppComponent;
import com.parkifast.mymappi.myapisdk.config.dependencies.components.DaggerAppComponent;
import com.parkifast.mymappi.myapisdk.config.dependencies.modules.AppModule;
import com.parkifast.mymappi.myapisdk.config.dependencies.modules.NetworkModule;
import com.parkifast.mymappi.myapisdk.config.network.environments.Environments;
import com.parkifast.mymappi.myapisdk.network.remote_apis.DirectionsApi;
import com.parkifast.mymappi.myapisdk.network.remote_apis.GeocodingApi;
import com.parkifast.mymappi.myapisdk.network.remote_apis.PlacesApi;
import com.parkifast.mymappi.myapisdk.network.remote_apis.RoadsApi;
import com.parkifast.mymappi.myapisdk.network.wrappers.DirectionsApiWrapper;
import com.parkifast.mymappi.myapisdk.network.wrappers.GeocodingApiWrapper;
import com.parkifast.mymappi.myapisdk.network.wrappers.PlacesApiWrapper;
import com.parkifast.mymappi.myapisdk.network.wrappers.RoadsApiWrapper;
import com.parkifast.mymappi.myapisdk.logger.Log;

public class MyapiSDK {
    private final String TAG = MyapiSDK.class.getSimpleName();

    private final Context mContext;
    private static AppComponent appComponent;

    private MyapiSDK(Context context) {
        this.mContext = context;
    }

    /**
     * Static method to retrieve app context by indicating the calling context.
     *
     * @param context The calling {@link Context}.
     *
     * @return The application {@link Context}.
     */
    public static MyapiSDK getInstance(Context context) {
        return new MyapiSDK(context);
    }

    public Context getApplicationContext() {
        return mContext.getApplicationContext();
    }

    //region DI
    /**
     * Retrieve the main {@link AppComponent} instance to get all primary app dependencies.
     * @return An {@link AppComponent} instance.
     */
    public static AppComponent getComponent() {
        return appComponent;
    }/**

    /**
     * Inject dependencies before doing anything.
     * @param sdkApiKey     The customer's API KEY.
     */
    private void injectDependencies(String sdkApiKey) {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(sdkApiKey, Environments.production))
                .build();
    }
    //endregion

    //region Exposed API
    /**
     * Initialize the SDK, inject dependencies and extract API Key from Manifest meta data.
     */
    public void init() {
        injectDependencies(getApiKey());
    }

    /**
     * Retrieves a handle to our Geocoding API for easy access.
     * @return      {@link GeocodingApi} instance.
     */
    public GeocodingApiWrapper geocodingApi() {
        return appComponent.geocodingApiWrapper();
    }

    /**
     * Retrieves a handle to our Roads API for easy access.
     * @return      {@link RoadsApi} instance.
     */
    public RoadsApiWrapper roadsApi() {
        return appComponent.roadsApiWrapper();
    }

    /**
     * Retrieves a handle to our Directions API through a convenience wrapper for easy access.
     * @return      {@link DirectionsApiWrapper} instance that abstracts the inner workings of
     *              the complex {@link DirectionsApi}.
     */
    public DirectionsApiWrapper directionsApi() {
        return appComponent.directionsApiWrapper();
    }

    /**
     * Retrieves a handle to our Places API through a convenience wrapper for easy access.
     * @return      {@link PlacesApiWrapper} instance that abstracts the inner workings of
     *              the complex {@link PlacesApi}.
     */
    public PlacesApiWrapper placesApi() {
        return appComponent.placesApiWrapper();
    }
    //endregion
    //region Private section
    private String getApiKey() {
        String apiKey = "";
        try {
            ApplicationInfo ai = mContext.getPackageManager().getApplicationInfo(
                    mContext.getPackageName(),
                    PackageManager.GET_META_DATA
            );
            Bundle bundle = ai.metaData;
            apiKey = bundle.getString("com.parkifast.mymappi.myapisdk.API_KEY");
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
            Log.e(TAG, "Failed to load meta-data, NullPointer: " + e.getMessage());
        }
        return apiKey;
    }
    //endregion
}
