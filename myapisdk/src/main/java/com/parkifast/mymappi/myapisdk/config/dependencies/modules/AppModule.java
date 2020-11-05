package com.parkifast.mymappi.myapisdk.config.dependencies.modules;

import android.content.Context;

import com.parkifast.mymappi.myapisdk.config.MyapiSDK;
import com.parkifast.mymappi.myapisdk.config.dependencies.qualifiers.AppContext;
import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;

import dagger.Module;
import dagger.Provides;

@Module( includes = { DataModule.class, NetworkModule.class } )
public class AppModule {

    private MyapiSDK myapiSDK;

    public AppModule(MyapiSDK myapiSDK) {
        this.myapiSDK = myapiSDK;
    }

    @Provides
    @AppScope
    MyapiSDK myapiSDK() {
        return myapiSDK;
    }

    @Provides
    @AppScope
    @AppContext
    Context applicationContext() {
        return myapiSDK.getApplicationContext();
    }

    //region Layers interface-implementation binding

    //endregion
}
