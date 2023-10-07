# DocumentTypesApi

All URIs are relative to *https://capture.ot2.opentext.com/cp-rest/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sessionDoctypesDocTypeGet**](DocumentTypesApi.md#sessionDoctypesDocTypeGet) | **GET** /session/doctypes/{docType} | Returns the Document Type identified by docType for the given environment. |
| [**sessionDoctypesGet**](DocumentTypesApi.md#sessionDoctypesGet) | **GET** /session/doctypes | Returns the list of available Document Types for the given environment. |


<a id="sessionDoctypesDocTypeGet"></a>
# **sessionDoctypesDocTypeGet**
> SessionDoctypesDocTypeGet200Response sessionDoctypesDocTypeGet(docType, env, suppressResponseCodes)

Returns the Document Type identified by docType for the given environment.

This resource retrieves a specific Document Type. A Document Type is created using the Designer.

### Example
```java
// Import classes:
import com.ot2.ApiClient;
import com.ot2.ApiException;
import com.ot2.Configuration;
import com.ot2.auth.*;
import com.ot2.models.*;
import com.ot2.corecapture.DocumentTypesApi;

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


    DocumentTypesApi apiInstance = new DocumentTypesApi(defaultClient);
    String docType = "docType_example"; // String | 
    Env env = Env.fromValue("D"); // Env | 
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      SessionDoctypesDocTypeGet200Response result = apiInstance.sessionDoctypesDocTypeGet(docType, env, suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentTypesApi#sessionDoctypesDocTypeGet");
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
| **docType** | **String**|  | |
| **env** | [**Env**](.md)|  | [optional] [default to P] [enum: D, T, P] |
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

[**SessionDoctypesDocTypeGet200Response**](SessionDoctypesDocTypeGet200Response.md)

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

<a id="sessionDoctypesGet"></a>
# **sessionDoctypesGet**
> SessionDoctypesGet200Response sessionDoctypesGet(env, suppressResponseCodes)

Returns the list of available Document Types for the given environment.

This operation returns a feed listing all of the Document Types. Document Types are created using the Designer.

### Example
```java
// Import classes:
import com.ot2.ApiClient;
import com.ot2.ApiException;
import com.ot2.Configuration;
import com.ot2.auth.*;
import com.ot2.models.*;
import com.ot2.corecapture.DocumentTypesApi;

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


    DocumentTypesApi apiInstance = new DocumentTypesApi(defaultClient);
    Env env = Env.fromValue("D"); // Env | 
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      SessionDoctypesGet200Response result = apiInstance.sessionDoctypesGet(env, suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentTypesApi#sessionDoctypesGet");
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
| **env** | [**Env**](.md)|  | [optional] [default to P] [enum: D, T, P] |
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

[**SessionDoctypesGet200Response**](SessionDoctypesGet200Response.md)

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

