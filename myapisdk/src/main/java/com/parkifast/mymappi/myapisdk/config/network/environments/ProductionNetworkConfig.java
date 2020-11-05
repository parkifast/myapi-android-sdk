package com.parkifast.mymappi.myapisdk.config.network.environments;

import com.parkifast.mymappi.myapisdk.BuildConfig;
import com.parkifast.mymappi.myapisdk.config.dependencies.scopes.AppScope;
import com.parkifast.mymappi.myapisdk.config.network.NetworkConfig;

import java.util.HashMap;

import javax.inject.Inject;

import static com.parkifast.mymappi.myapisdk.config.network.environments.Environments.production;

/**
 * Provides all the necessary configuration parameters for the network layer, customized for
 * the production environment.
 */
@AppScope
public class ProductionNetworkConfig implements NetworkConfig {

    //region URL fields
    private final String BASE_URL = "https://m.api.mymappi.com";
    private final String BASE_API_PATH = "/";
    private final String CURRENT_VERSION_PATH = "v1/";
    //endregion

    //region Connection timeouts
    private final int CONN_TIMEOUT = 300;
    private final int CONN_READ_TIMEOUT = 300;
    private final int CONN_WRITE_TIMEOUT = 300;
    //endregion

    //region Environment
    private final Environments currentEnvironment;
    private String sdkApiKey;

    @Inject
    public ProductionNetworkConfig(String sdkApiKey) {
        this.currentEnvironment = production;
        this.sdkApiKey = sdkApiKey;
    }

    /**
     * Retrieve current environment.
     *
     * @return Current {@link Environments} selection.
     */
    @Override
    public Environments getCurrentEnvironment() {
        return this.currentEnvironment;
    }

    /**
     * Retrieve connection timeout in seconds.
     *
     * @return Timeout before the connection attempts are aborted.
     */
    @Override
    public int getConnTimeout() {
        return CONN_TIMEOUT;
    }

    /**
     * Timeout before connection data read attempts are aborted.
     *
     * @return The timeout expressed in seconds.
     */
    @Override
    public int getConnReadTimeout() {
        return CONN_READ_TIMEOUT;
    }

    @Override
    public int getConnWriteTimeout() {
        return CONN_WRITE_TIMEOUT;
    }

    /**
     * The base url for the current environment.
     *
     * @return A {@link String} representing the current environment
     */
    @Override
    public String getBaseUrl() {
        return BASE_URL + BASE_API_PATH + CURRENT_VERSION_PATH;
    }

    /**
     * Retrieves a {@link HashMap <String,String>} with the list of default headers (key-value pairs)
     * that should be applied by default on this environment for every network request.
     *
     * @return A {@link HashMap<String,String>} representing the default headers to apply
     * on this environment.
     */
    @Override
    public HashMap<String, String> getDefaultHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put(BuildConfig.SdkSecurityHeaderName, BuildConfig.SdkSecurityHeaderValue);
        headers.put(BuildConfig.SdkApiKeyHeaderName, sdkApiKey);
        return headers;
    }
    //endregion
}