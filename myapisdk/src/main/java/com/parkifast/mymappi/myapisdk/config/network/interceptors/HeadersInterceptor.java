package com.parkifast.mymappi.myapisdk.config.network.interceptors;

import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.config.network.NetworkConfig;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@AppScope
public class HeadersInterceptor implements Interceptor {

    private HashMap<String, String> headers;

    @Inject
    public HeadersInterceptor(HashMap<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Intercepts request and adds the default headers provided in the {@link NetworkConfig}
     * instance.
     *
     * @param chain         The request chain
     * @return              The response
     * @throws IOException  When interception fails
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder();

        // Add all existing headers from original request
        requestBuilder.headers(original.headers());

        // Add all default headers
        for(HashMap.Entry<String, String> header: headers.entrySet()){
            requestBuilder.addHeader(header.getKey(), header.getValue());
        }

        // Build request
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
