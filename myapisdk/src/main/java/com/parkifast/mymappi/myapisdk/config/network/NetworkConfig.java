package com.parkifast.mymappi.myapisdk.config.network;

import com.parkifast.mymappi.myapisdk.config.network.environments.Environments;

import java.util.HashMap;

public interface NetworkConfig {

    //region Environment

    /**
     * Retrieve current environment.
     *
     * @return      Current {@link Environments} selection.
     */
    Environments getCurrentEnvironment();
    //endregion

    //region Timeouts

    /**
     * Retrieve connection timeout in seconds.
     *
     * @return  Timeout before the connection attempts are aborted.
     */
    int getConnTimeout();

    /**
     * Timeout before connection data read attempts are aborted.
     *
     * @return  The timeout expressed in seconds.
     */
    int getConnReadTimeout();
    int getConnWriteTimeout();
    //endregion

    //region URLs

    /**
     * The base url for the current environment.
     *
     * @return  A {@link String} representing the current environment
     */
    String getBaseUrl();
    //endregion

    //region Headers

    /**
     * Retrieves a {@link HashMap<String,String>} with the list of default headers (key-value pairs)
     * that should be applied by default on this environment for every network request.
     *
     * @return      A {@link HashMap<String,String>} representing the default headers to apply
     *              on this environment.
     */
    HashMap<String, String> getDefaultHeaders();
    //endregion

}
