# SessionApi

All URIs are relative to *https://capture.ot2.opentext.com/cp-rest/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sessionDelete**](SessionApi.md#sessionDelete) | **DELETE** /session | Deletes your session data. |
| [**sessionGet**](SessionApi.md#sessionGet) | **GET** /session | Retrieves the Session resource. |


<a id="sessionDelete"></a>
# **sessionDelete**
> String sessionDelete(suppressResponseCodes)

Deletes your session data.

As long as the session is still active, deleting your session will return HTTP status code 200. If the session has expired, then a 401 Unauthorized response is sent by the server.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.SessionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    

    // Configure OAuth2 access token for authorization: capture.ot2.opentext.eu
    OAuth capture.ot2.opentext.eu = (OAuth) defaultClient.getAuthentication("capture.ot2.opentext.eu");
    capture.ot2.opentext.eu.setAccessToken("YOUR ACCESS TOKEN");


    // Configure OAuth2 access token for authorization: capture.ot2.opentext.com
    OAuth capture.ot2.opentext.com = (OAuth) defaultClient.getAuthentication("capture.ot2.opentext.com");
    capture.ot2.opentext.com.setAccessToken("YOUR ACCESS TOKEN");


    SessionApi apiInstance = new SessionApi(defaultClient);
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      String result = apiInstance.sessionDelete(suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SessionApi#sessionDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

**String**

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com), [capture.ot2.opentext.eu](../README.md#capture.ot2.opentext.eu), [eu-1.api.opentext.com](../README.md#eu-1.api.opentext.com), [capture.ot2.opentext.com](../README.md#capture.ot2.opentext.com), [na-1.api.opentext.com](../README.md#na-1.api.opentext.com)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/hal+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully logged off |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionGet"></a>
# **sessionGet**
> SessionGet200Response sessionGet(suppressResponseCodes)

Retrieves the Session resource.

The Session resource will provide the URI for ending the session. This clears all the files and metadata in your session and allows for more efficient processing for future sessions related to your subscription.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.SessionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");

    SessionApi apiInstance = new SessionApi(defaultClient);
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      SessionGet200Response result = apiInstance.sessionGet(suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SessionApi#sessionGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

[**SessionGet200Response**](SessionGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

