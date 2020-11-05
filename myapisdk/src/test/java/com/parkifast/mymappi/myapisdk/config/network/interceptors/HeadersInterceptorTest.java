package com.parkifast.mymappi.myapisdk.config.network.interceptors;


import com.parkifast.mymappi.myapisdk.BuildConfig;
import com.parkifast.mymappi.myapisdk.config.network.NetworkConfig;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HeadersInterceptorTest {

    private final String API_KEY_VALUE = "valid api key";

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private Interceptor.Chain chain;

    @Mock
    private Request request;

    @Mock
    private Request.Builder requestBuilder;

    @Mock
    private Response response;

    @Captor
    private ArgumentCaptor<String> headerNameCaptor;

    @Captor
    private ArgumentCaptor<String> headerValueCaptor;

    private HeadersInterceptor headersInterceptor;

    /**
     * Simulate production environment and prepare an instance of {@link HeadersInterceptor} that
     * will apply the production headers, for example.
     *
     * @throws IOException
     */
    @Before
    public void setup() throws IOException {
        NetworkConfig networkConfig = new PreproductionNetworkConfig(API_KEY_VALUE);
        // Build the interceptor that will add those headers to each request
        headersInterceptor = new HeadersInterceptor(networkConfig.getDefaultHeaders());

        // Mock the request and response
        when(chain.request()).thenReturn(request);
        when(chain.proceed(any(Request.class))).thenReturn(response);

        // Mock the request builder flow
        when(request.newBuilder()).thenReturn(requestBuilder);
        when(requestBuilder.addHeader(anyString(), anyString())).thenReturn(requestBuilder);
        when(requestBuilder.build()).thenReturn(request);
    }

    /**
     * When intercepting the request, it should add all headers.
     */
    @Test
    public void whenInterceptingRequest_shouldAddAllHeaders() throws IOException {
        // 1) Arrange
        // 2) Act
        headersInterceptor.intercept(chain);
        // 3) Assert
        verify(requestBuilder, times(1)).headers(any());
    }

    /**
     * When intercepting the request, it should add Accept: application/json header.
     */
    @Test
    public void whenInterceptingRequest_shouldSetAcceptHeaderValueToApplicationJson() throws IOException {
        // 1) Arrange
        String expectedHeaderName = "Accept";
        String expectedHeaderValue = "application/json";
        // 2) Act
        headersInterceptor.intercept(chain);
        // 3) Assert
        verify(requestBuilder, times(1))
                .addHeader(eq(expectedHeaderName), headerValueCaptor.capture());
        assertEquals(
                expectedHeaderName + " value should be set to " + expectedHeaderValue,
                expectedHeaderValue,
                headerValueCaptor.getValue()
        );
    }

    /**
     * When intercepting the request, it should add Accept: application/json header.
     */
    @Test
    public void whenInterceptingRequest_shouldSetContentTypeHeaderValueToApplicationJson() throws IOException {
        // 1) Arrange
        String expectedHeaderName = "Content-Type";
        String expectedHeaderValue = "application/json";
        // 2) Act
        headersInterceptor.intercept(chain);
        // 3) Assert
        verify(requestBuilder, times(1))
                .addHeader(eq(expectedHeaderName), headerValueCaptor.capture());
        assertEquals(
                expectedHeaderName + " value should be set to " + expectedHeaderValue,
                expectedHeaderValue,
                headerValueCaptor.getValue()
        );
    }

    /**
     * When intercepting the request, it should add SdkSecKey header with the correct value defined
     * in the gradle project properties file.
     */
    @Test
    public void whenInterceptingRequest_shouldSetSdkSecurityKeyValueCorrectly() throws IOException {
        // 1) Arrange
        String expectedHeaderName = BuildConfig.SdkSecurityHeaderName;
        String expectedHeaderValue = BuildConfig.SdkSecurityHeaderValue;
        // 2) Act
        headersInterceptor.intercept(chain);
        // 3) Assert
        verify(requestBuilder, times(1))
                .addHeader(eq(expectedHeaderName), headerValueCaptor.capture());
        assertEquals(
                expectedHeaderName + " value should be set to " + expectedHeaderValue,
                expectedHeaderValue,
                headerValueCaptor.getValue()
        );
    }

    /**
     * When intercepting the request, it should add SdkSecKey header with the correct value defined
     * in the gradle project properties file.
     */
    @Test
    public void whenInterceptingRequest_shouldSetSdkApiKeyValueCorrectly() throws IOException {
        // 1) Arrange
        String expectedHeaderName = BuildConfig.SdkApiKeyHeaderName;
        String expectedHeaderValue = API_KEY_VALUE;
        // 2) Act
        headersInterceptor.intercept(chain);
        // 3) Assert
        verify(requestBuilder, times(1))
                .addHeader(eq(expectedHeaderName), headerValueCaptor.capture());
        assertEquals(
                expectedHeaderName + " value should be set to " + expectedHeaderValue,
                expectedHeaderValue,
                headerValueCaptor.getValue()
        );
    }
}