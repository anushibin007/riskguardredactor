# ContentAnalyzerApi

All URIs are relative to *https://na-1-dev.api.opentext.com/mtm-riskguard*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getProductVersion**](ContentAnalyzerApi.md#getProductVersion) | **GET** /api/v1/version | Get version of Risk Guard Service |
| [**processContent**](ContentAnalyzerApi.md#processContent) | **POST** /api/v1/process | Process documents/images for extraction/identification of PII, PSI and threat/risk |


<a id="getProductVersion"></a>
# **getProductVersion**
> ProductVersion getProductVersion()

Get version of Risk Guard Service

Get version of Risk Guard Service. This information includes service major and minor version details

### Example
```java
// Import classes:
import com.ot2.riskguard.invoker.ApiClient;
import com.ot2.riskguard.invoker.ApiException;
import com.ot2.riskguard.invoker.Configuration;
import com.ot2.riskguard.invoker.auth.*;
import com.ot2.riskguard.invoker.models.*;
import com.ot2.riskguard.api.ContentAnalyzerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://na-1-dev.api.opentext.com/mtm-riskguard");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ContentAnalyzerApi apiInstance = new ContentAnalyzerApi(defaultClient);
    try {
      ProductVersion result = apiInstance.getProductVersion();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentAnalyzerApi#getProductVersion");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ProductVersion**](ProductVersion.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The version is retreived correctly |  -  |
| **401** | The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. |  -  |
| **500** | The internal processing error is occurred. Need to check the logs when this error is occurred. |  -  |

<a id="processContent"></a>
# **processContent**
> ContentResponse processContent(_file)

Process documents/images for extraction/identification of PII, PSI and threat/risk

This is the main end point of the service.  This takes the binary document with multi-part form data.  The parameter name should be &#39;File&#39; and the binary content should be attached to it.

### Example
```java
// Import classes:
import com.ot2.riskguard.invoker.ApiClient;
import com.ot2.riskguard.invoker.ApiException;
import com.ot2.riskguard.invoker.Configuration;
import com.ot2.riskguard.invoker.auth.*;
import com.ot2.riskguard.invoker.models.*;
import com.ot2.riskguard.api.ContentAnalyzerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://na-1-dev.api.opentext.com/mtm-riskguard");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ContentAnalyzerApi apiInstance = new ContentAnalyzerApi(defaultClient);
    File _file = new File("/path/to/file"); // File | 
    try {
      ContentResponse result = apiInstance.processContent(_file);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentAnalyzerApi#processContent");
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
| **_file** | **File**|  | |

### Return type

[**ContentResponse**](ContentResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The content is analyzed successfully |  -  |
| **401** | The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. |  -  |
| **500** | The internal processing error is occurred. Need to check the logs when this error is occurred. |  -  |

