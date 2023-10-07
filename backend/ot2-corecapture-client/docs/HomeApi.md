# HomeApi

All URIs are relative to *https://capture.ot2.opentext.com/cp-rest/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**aboutGet**](HomeApi.md#aboutGet) | **GET** /about | Provides product version information. |
| [**rootGet**](HomeApi.md#rootGet) | **GET** / | The Home Document is an entry point to the Core Capture Services. |


<a id="aboutGet"></a>
# **aboutGet**
> AboutGet200Response aboutGet(suppressResponseCodes)

Provides product version information.

This resource provides product information about the Services installation to authenticated users.

### Example
```java
// Import classes:
import com.ot2.ApiClient;
import com.ot2.ApiException;
import com.ot2.Configuration;
import com.ot2.auth.*;
import com.ot2.models.*;
import com.ot2.corecapture.HomeApi;

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


    HomeApi apiInstance = new HomeApi(defaultClient);
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      AboutGet200Response result = apiInstance.aboutGet(suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HomeApi#aboutGet");
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

[**AboutGet200Response**](AboutGet200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com), [capture.ot2.opentext.eu](../README.md#capture.ot2.opentext.eu), [eu-1.api.opentext.com](../README.md#eu-1.api.opentext.com), [capture.ot2.opentext.com](../README.md#capture.ot2.opentext.com), [na-1.api.opentext.com](../README.md#na-1.api.opentext.com)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="rootGet"></a>
# **rootGet**
> Get200Response rootGet(suppressResponseCodes)

The Home Document is an entry point to the Core Capture Services.

The Home Document is an entry point to the Core Capture Services. It is available to any caller. Its main purposes it to provide discovery of the URIs necessary to interact with the service. It is retrieved by performing an HTTP GET on the base installation path. So for example if the REST service was installed into https://{host}/cp-rest/v2, then performing a GET on this URI would return the Home Document. Its main purposes is to provide discovery of the URIs necessary to interact with the service. All clients must start from the Home Document and follow the hrefs given in the link relations to the resources desired. This is important to ensure that your client applications will always work regardless of the URI changes that may take place under different deployment configurations of the service.

### Example
```java
// Import classes:
import com.ot2.ApiClient;
import com.ot2.ApiException;
import com.ot2.Configuration;
import com.ot2.models.*;
import com.ot2.corecapture.HomeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");

    HomeApi apiInstance = new HomeApi(defaultClient);
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      Get200Response result = apiInstance.rootGet(suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HomeApi#rootGet");
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

[**Get200Response**](Get200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **415** | Unsupported Media Type |  -  |
| **500** | Internal Server Error |  -  |

