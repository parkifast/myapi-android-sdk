package com.parkifast.mymappi.myapisdk.network.response_models;

import com.google.gson.annotations.SerializedName;

/**
 * Base response for myapi requests. It extracts metadata such as legal notice, version or timestamp.
 */
public class BaseResponse {

    //region Attributes
    public static final String NO_DATA_STATUS = "No data available";
    /**
     * Current API version.
     */
    @SerializedName("version")
    private String version;

    /**
     * API Provider
     */
    @SerializedName("provider")
    private String provider;

    /**
     * Timestamp when the request was made.
     */
    @SerializedName("timestamp")
    private long timestamp;

    /**
     * Copyright information
     */
    @SerializedName("copyright")
    private String copyright;

    /**
     * Copyright information
     */
    @SerializedName("status")
    private String status;
    //endregion

    //region Getters and setters
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor.
     */
    public BaseResponse() {
        this.version = "";
        this.provider = "";
        this.timestamp = 0L;
        this.copyright = "";
        this.status = NO_DATA_STATUS;
    }

    /**
     * Full constructor.
     * @param version           API Version.
     * @param provider          API Provider.
     * @param timestamp         Timestamp of the request.
     * @param copyright         Copyright message
     */
    public BaseResponse(String version, String provider, long timestamp, String copyright) {
        this.version = version;
        this.provider = provider;
        this.timestamp = timestamp;
        this.copyright = copyright;
        this.status = NO_DATA_STATUS;
    }

    /**
     * Full constructor.
     * @param version           API Version.
     * @param provider          API Provider.
     * @param timestamp         Timestamp of the request.
     * @param copyright         Copyright message
     * @param status            Status message for the result of current request.
     */
    public BaseResponse(String version, String provider, long timestamp, String copyright, String status) {
        this.version = version;
        this.provider = provider;
        this.timestamp = timestamp;
        this.copyright = copyright;
        this.status = status;
    }
    //endregion
}
