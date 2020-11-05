package com.parkifast.mymappi.myapisdk.config.dependencies.components;


import com.parkifast.mymappi.myapisdk.config.dependencies.modules.AppModule;
import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.network.wrappers.DirectionsApiWrapper;
import com.parkifast.mymappi.myapisdk.network.wrappers.GeocodingApiWrapper;
import com.parkifast.mymappi.myapisdk.network.wrappers.PlacesApiWrapper;
import com.parkifast.mymappi.myapisdk.network.wrappers.RoadsApiWrapper;

import dagger.Component;

@Component(modules = { AppModule.class })
@AppScope
public interface AppComponent {

    //region Exposed APIs and wrappers
    GeocodingApiWrapper geocodingApiWrapper();
    RoadsApiWrapper roadsApiWrapper();
    DirectionsApiWrapper directionsApiWrapper();
    PlacesApiWrapper placesApiWrapper();
    //endregion



}
