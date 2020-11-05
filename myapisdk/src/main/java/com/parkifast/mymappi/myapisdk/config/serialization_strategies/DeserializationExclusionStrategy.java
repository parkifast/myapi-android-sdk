package com.parkifast.mymappi.myapisdk.config.serialization_strategies;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;

import javax.inject.Inject;

@AppScope
public class DeserializationExclusionStrategy implements ExclusionStrategy {

    @Inject
    public DeserializationExclusionStrategy() {

    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        Expose exposeAnnotation = f.getAnnotation(Expose.class);
        return exposeAnnotation != null && !exposeAnnotation.deserialize();
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
