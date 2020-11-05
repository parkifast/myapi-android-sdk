package com.parkifast.mymappi.myapisdk.config.dependencies.modules;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.parkifast.mymappi.myapisdk.config.dependencies.qualifiers.SdkApiKey;
import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.config.network.NetworkConfig;
import com.parkifast.mymappi.myapisdk.config.network.environments.Environments;
import com.parkifast.mymappi.myapisdk.config.network.environments.ProductionNetworkConfig;
import com.parkifast.mymappi.myapisdk.config.network.interceptors.HeadersInterceptor;
import com.parkifast.mymappi.myapisdk.config.network.interceptors.RequestParamsInterceptor;
import com.parkifast.mymappi.myapisdk.network.remote_apis.DirectionsApi;
import com.parkifast.mymappi.myapisdk.network.remote_apis.GeocodingApi;
import com.parkifast.mymappi.myapisdk.network.remote_apis.PlacesApi;
import com.parkifast.mymappi.myapisdk.network.remote_apis.RoadsApi;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Completable;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = { TranslationModule.class })
public class NetworkModule {

    private final Environments currentEnvironment;

    @SdkApiKey
    private final String apiKey;

    public NetworkModule(String apiKey, Environments currentEnvironment) {
        this.currentEnvironment = currentEnvironment;
        this.apiKey = apiKey;
    }

    @Provides
    @SdkApiKey
    public String sdkApiKey() {
        return this.apiKey;
    }

    /**
     * Provide the network configuration object for the current environment.
     *
     * @return A fully configured {@link NetworkConfig} object for the current {@link Environments}
     */
    @AppScope
    @Provides
    public NetworkConfig networkConfig(@SdkApiKey String sdkApiKey) {
        // By default, current environment will be set to preproduction
        NetworkConfig networkConfig = new ProductionNetworkConfig(sdkApiKey);
        switch (currentEnvironment) {
            case production:
                networkConfig = new ProductionNetworkConfig(sdkApiKey);
                break;
        }
        return networkConfig;
    }

    /**
     * Provides the implementation for the retrofit client, fully configured.
     *
     * @param okHttpClient                  HTTP Client of choice, fully configured.
     * @param rxJava2CallAdapterFactory     To use RxJava2 return types (Flowable, Single...)
     * @param gsonConverterFactory          To use Gson for (de)serialization
     * @return                              A ready to use Retrofit instance.
     */
    @AppScope
    @Provides
    public Retrofit retrofit(NetworkConfig networkConfig, OkHttpClient okHttpClient,
                             RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                             GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                // Determine base URL from current environment
                .baseUrl(networkConfig.getBaseUrl())
                // Use okHttpClient instance as the HTTP client for Retrofit
                .client(okHttpClient)
                // Use RxJava2CallAdapter factory to use RxJava2 Observables
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                // Use GsonConverterFactory to (de)serialize requests/responses
                .addConverterFactory(gsonConverterFactory)
                // Build the instance
                .build();
    }

    /**
     * Provides an instance of {@link RxJava2CallAdapterFactory} to be used within the
     * {@link Retrofit} instance. This factory provides {@link Retrofit} with capabilities
     * to return RxJava2 Observables such as {@link Completable} or {@link io.reactivex.Flowable}.
     *
     * @return      A {@link RxJava2CallAdapterFactory} that allows the use of RxJava2
     *              Observable return types.
     */
    @AppScope
    @Provides
    public RxJava2CallAdapterFactory rxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    /**
     * Provides a fully configured instance of {@link OkHttpClient}. It adds an interceptor
     * to provide http request/response logging capabilities for easier debugging.
     *
     * @param networkConfig             The whole network configuration information can be found here.
     * @param httpLoggingInterceptor    The logging interceptor.
     *
     * @return                          A fully configured built instance of {@link OkHttpClient}
     */
    @AppScope
    @Provides
    public OkHttpClient okHttpClient(NetworkConfig networkConfig,
                                     HttpLoggingInterceptor httpLoggingInterceptor,
                                     HeadersInterceptor headersInterceptor,
                                     RequestParamsInterceptor requestParamsInterceptor,
                                     ConnectionSpec spec) {
        // Configure timeouts for request connection, data read and data write.
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(networkConfig.getConnTimeout(), TimeUnit.SECONDS)
                .readTimeout(networkConfig.getConnReadTimeout(), TimeUnit.SECONDS)
                .writeTimeout(networkConfig.getConnWriteTimeout(), TimeUnit.SECONDS)
                .connectionSpecs(Collections.singletonList(spec));

        // Add headers interceptor
        httpClient.addInterceptor(headersInterceptor);

        // Add request params interceptor
        httpClient.addInterceptor(requestParamsInterceptor);

        // Add http logging interceptor
        httpClient.addInterceptor(httpLoggingInterceptor);

        // Build and return client instance
        return httpClient.build();
    }
    //region Interceptors
    /**
     * Provide builder for {@link HttpLoggingInterceptor} instance, which will help debug network
     * requests by capturing the request body and metadata as well as the responses.
     *
     * @return An {@link HttpLoggingInterceptor} instance configured to level Body.
     */
    @AppScope
    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    /**
     * Provide a {@link HeadersInterceptor} instance that will apply all default headers to each
     * network request by default, as defined in the environment specific {@link NetworkConfig}
     * instance provided to the constructor.
     *
     * @param networkConfig The environment specific {@link NetworkConfig} instance.
     * @return              A {@link HeadersInterceptor} instance for current environment.
     */
    @AppScope
    @Provides
    public HeadersInterceptor headersInterceptor(NetworkConfig networkConfig) {
        return new HeadersInterceptor(networkConfig.getDefaultHeaders());
    }

    /**
     * Provide a {@link RequestParamsInterceptor} instance that will apply extra default params to
     * all network request by default.
     *
     * @param apiKey        The client's api key to append as param.
     * @return              A {@link HeadersInterceptor} instance for current environment.
     */
    @AppScope
    @Provides
    public RequestParamsInterceptor requestParamsInterceptor(@SdkApiKey String apiKey) {
        return new RequestParamsInterceptor(apiKey);
    }
    //endregion

    /**
     * Provides a connection spec for OKHttpClient so that more ciphers are supported. This was
     * necessary to add since by default OkHttpClient supports a very restricted subset of ciphers
     * (since Android by default supports many that are outdated and possibly broken). More info
     * can be found on <a link="https://github.com/square/okhttp/issues/1582">Square OkHttp Github
     * issues</a> and on <a link="https://stackoverflow.com/questions/42982512/retrofit-2-2-0-android-api-24-javax-net-ssl-sslhandshakeexception-handshake-fai">
     *     on StackOverFlow</a>
     *
     * @return  A {@link ConnectionSpec} with more cipher suites.
     */
    @AppScope
    @Provides
    public ConnectionSpec spec() {
        return new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .cipherSuites(
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384
                )
                .build();
    }

    //region Exposed APIs
    @AppScope
    @Provides
    public GeocodingApi geocodingApi(Retrofit apiClient) {
        return apiClient.create(GeocodingApi.class);
    }

    @AppScope
    @Provides
    public RoadsApi roadsApi(Retrofit apiClient) {
        return apiClient.create(RoadsApi.class);
    }

    @AppScope
    @Provides
    public DirectionsApi directionsApi(Retrofit apiClient) {
        return apiClient.create(DirectionsApi.class);
    }

    @AppScope
    @Provides
    public PlacesApi placesApi(Retrofit apiClient) {
        return apiClient.create(PlacesApi.class);
    }
    //endregion
}
