package com.parkifast.mymappi.myapisdk.config.network.interceptors;

import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.config.network.NetworkConfig;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@AppScope
public class RequestParamsInterceptor implements Interceptor {

    private String apiKey;

    @Inject
    public RequestParamsInterceptor(String apiKey) {
        this.apiKey = apiKey;
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

        // Extract original url
        HttpUrl originalHttpUrl = original.url();

        // Attach api key
        HttpUrl url = originalHttpUrl.newBuilder()
//                .addQueryParameter("apikey", apiKey)
                .build();

        // Request customization: modify url with new added params
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        // Build request
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
