package com.parkifast.mymappi.myapisdk.config.network.environments;

import com.parkifast.mymappi.myapisdk.BuildConfig;
import com.parkifast.mymappi.myapisdk.config.network.NetworkConfig;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

public class ProductionNetworkConfigTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private NetworkConfig networkConfig;

    @Before
    public void setup() {
        this.networkConfig = new ProductionNetworkConfig("");
    }
    /**
     * The base url should be https://m.api.mymappi.com/v1/
     */
    @Test
    public void whenGettingBaseUrl_shouldReturnProperValue() {
        // 1) Arrange
        String expectedBaseUrl = "https://m.api.mymappi.com/v1/";

        // 2) Act
        String baseUrl = networkConfig.getBaseUrl();

        // 3) Assert
        assertEquals(expectedBaseUrl, baseUrl);
    }

    /**
     * Connection timeout value should be correct.
     */
    @Test
    public void connTimeout_shouldBe_10Seconds() {
        assertEquals(300, networkConfig.getConnTimeout());
    }

    /**
     * Connection read timeout value should be correct.
     */
    @Test
    public void connReadTimeout_shouldBe_10Seconds() {
        assertEquals(300, networkConfig.getConnReadTimeout());
    }

    /**
     * Connection write timeout value should be correct.
     */
    @Test
    public void connWriteTimeout_shouldBe_10Seconds() {
        assertEquals(300, networkConfig.getConnWriteTimeout());
    }

    /**
     * Default headers should include: [Accept: application/json]
     */
    @Test
    public void defaultHeaders_shouldIncludeAcceptJsonFormatHeader() {
        // 1) Arrange
        String expectedHeaderValue = "application/json";
        // 2) Act
        String headerValue = networkConfig.getDefaultHeaders().get("Accept");
        // 3) Assert
        assertEquals(
                "Accept: application/json header should be present",
                expectedHeaderValue,
                headerValue
        );
    }

    /**
     * Default headers should include: [Content-Type: application/json]
     */
    @Test
    public void defaultHeaders_shouldIncludeContentTypeJsonFormatHeader() {
        // 1) Arrange
        String expectedHeaderValue = "application/json";
        // 2) Act
        String headerValue = networkConfig.getDefaultHeaders().get("Content-Type");
        // 3) Assert
        assertEquals(
                "Content-Type: application/json header should be present",
                expectedHeaderValue,
                headerValue
        );
    }

    /**
     * Default headers should include the SDK Security header
     */
    @Test
    public void defaultHeaders_shouldIncludeSdkSecurityHeader() {
        // 1) Arrange
        String expectedHeaderValue = BuildConfig.SdkSecurityHeaderValue;
        // 2) Act
        String headerValue = networkConfig.getDefaultHeaders().get(BuildConfig.SdkSecurityHeaderName);
        // 3) Assert
        assertEquals(
                "SDK Security header should be present",
                expectedHeaderValue,
                headerValue
        );
    }

    /**
     * Default headers should include the SDK Api Key Header
     */
    @Test
    public void defaultHeaders_shouldIncludeSdkApiKeyHeader() {
        // 1) Arrange
        String expectedHeaderName = BuildConfig.SdkApiKeyHeaderName;

        // 2) Act
        String headerValue = networkConfig.getDefaultHeaders().get(expectedHeaderName);
        // 3) Assert
        assertNotNull(
                "SDK Api Key header should be present",
                headerValue
        );
    }

    /**
     * When there is no sdk api key stored, the sdk api key header should still be included with
     * the value set to an empty String.
     */
    @Test
    public void whenNoSdkApiKeyIsStored_shouldIncludeSdkApiKeyHeaderWithEmptyValue() {
        // 1) Arrange
        this.networkConfig = new ProductionNetworkConfig("");
        String expectedHeaderName = BuildConfig.SdkApiKeyHeaderName;

        // 2) Act
        String headerValue = networkConfig.getDefaultHeaders().get(expectedHeaderName);
        // 3) Assert
        assertTrue(
                "SDK Api Key header should be present",
                headerValue.isEmpty()
        );
    }

    /**
     * When the sdk api key is correctly stored, the sdk api key header should be included with
     * the value set to the correct sdk api key value.
     */
    @Test
    public void whenSdkApiKeyIsStored_shouldIncludeSdkApiKeyHeaderWithCorrectValue() {
        // 1) Arrange
        String expectedSdkApiKey = "valid api key";
        this.networkConfig = new ProductionNetworkConfig(expectedSdkApiKey);
        // 2) Act
        String headerValue = networkConfig.getDefaultHeaders().get(BuildConfig.SdkApiKeyHeaderName);
        // 3) Assert
        assertEquals(
                "SDK Api Key header should be " + expectedSdkApiKey,
                expectedSdkApiKey,
                headerValue
        );
    }

}