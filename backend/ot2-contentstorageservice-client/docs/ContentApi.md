# ContentApi

All URIs are relative to *https://css.na-1-dev.api.opentext.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**downloadcontent**](ContentApi.md#downloadcontent) | **GET** /v2/content/{id}/download | Download content |
| [**getContent**](ContentApi.md#getContent) | **GET** /v2/content/{id} | Get content metadata for the content |
| [**uploadContent**](ContentApi.md#uploadContent) | **POST** /v2/content | Tenant user upload content |
| [**uploadContentTenant**](ContentApi.md#uploadContentTenant) | **POST** /v2/tenant/{tenantId}/content | Upload content for a tenant |
| [**uploadContentURL**](ContentApi.md#uploadContentURL) | **POST** /v2/upload/{id}/content | Upload content with upload URL |


<a id="downloadcontent"></a>
# **downloadcontent**
> File downloadcontent(id, objectId, fileName, mimeType, dispositionType, avsScan)

Download content

Download content

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.ContentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    
    // Configure HTTP bearer authorization: css.na-1-dev.api.opentext.com
    HttpBearerAuth css.na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("css.na-1-dev.api.opentext.com");
    css.na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    ContentApi apiInstance = new ContentApi(defaultClient);
    String id = "id_example"; // String | ID of the content
    String objectId = "objectId_example"; // String | The ID of the object attached with the content
    String fileName = "fileName_example"; // String | The name of the file in response
    String mimeType = "mimeType_example"; // String | The mime type of the content. This has higher priority than the Accept header
    String dispositionType = "dispositionType_example"; // String | Content disposition of the downloaded content
    Boolean avsScan = true; // Boolean | Flag indicating whether or not to perform a virus scan. Reserved for trusted clients, set false to skip avs (default is true)
    try {
      File result = apiInstance.downloadcontent(id, objectId, fileName, mimeType, dispositionType, avsScan);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#downloadcontent");
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
| **id** | **String**| ID of the content | |
| **objectId** | **String**| The ID of the object attached with the content | [optional] |
| **fileName** | **String**| The name of the file in response | [optional] |
| **mimeType** | **String**| The mime type of the content. This has higher priority than the Accept header | [optional] |
| **dispositionType** | **String**| Content disposition of the downloaded content | [optional] |
| **avsScan** | **Boolean**| Flag indicating whether or not to perform a virus scan. Reserved for trusted clients, set false to skip avs (default is true) | [optional] |

### Return type

[**File**](File.md)

### Authorization

[css.na-1-dev.api.opentext.com](../README.md#css.na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Content downloaded |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

<a id="getContent"></a>
# **getContent**
> Content getContent(id)

Get content metadata for the content

Get details of a specific content

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.ContentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    
    // Configure HTTP bearer authorization: css.na-1-dev.api.opentext.com
    HttpBearerAuth css.na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("css.na-1-dev.api.opentext.com");
    css.na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    ContentApi apiInstance = new ContentApi(defaultClient);
    String id = "id_example"; // String | ID of the content
    try {
      Content result = apiInstance.getContent(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#getContent");
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
| **id** | **String**| ID of the content | |

### Return type

[**Content**](Content.md)

### Authorization

[css.na-1-dev.api.opentext.com](../README.md#css.na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Content downloaded |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

<a id="uploadContent"></a>
# **uploadContent**
> Content uploadContent(uploadContentRequest)

Tenant user upload content

Tenant user upload content

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.ContentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    
    // Configure HTTP bearer authorization: css.na-1-dev.api.opentext.com
    HttpBearerAuth css.na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("css.na-1-dev.api.opentext.com");
    css.na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    ContentApi apiInstance = new ContentApi(defaultClient);
    UploadContentRequest uploadContentRequest = new UploadContentRequest(); // UploadContentRequest | Pass binary data via multipart/form-data or in plain body
    try {
      Content result = apiInstance.uploadContent(uploadContentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#uploadContent");
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
| **uploadContentRequest** | [**UploadContentRequest**](UploadContentRequest.md)| Pass binary data via multipart/form-data or in plain body | [optional] |

### Return type

[**Content**](Content.md)

### Authorization

[css.na-1-dev.api.opentext.com](../README.md#css.na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: multipart/form-data, application/octet-stream
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Content uploaded successfully |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

<a id="uploadContentTenant"></a>
# **uploadContentTenant**
> Content uploadContentTenant(tenantId, avsScan, uploadContentRequest)

Upload content for a tenant

Upload content for a tenant

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.ContentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    
    // Configure HTTP bearer authorization: css.na-1-dev.api.opentext.com
    HttpBearerAuth css.na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("css.na-1-dev.api.opentext.com");
    css.na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    ContentApi apiInstance = new ContentApi(defaultClient);
    String tenantId = "tenantId_example"; // String | ID of tenant
    Boolean avsScan = true; // Boolean | Flag indicating whether or not to perform a virus scan. Reserved for trusted clients, set false to skip avs (default is true)
    UploadContentRequest uploadContentRequest = new UploadContentRequest(); // UploadContentRequest | Pass binary data via multipart/form-data or in plain body
    try {
      Content result = apiInstance.uploadContentTenant(tenantId, avsScan, uploadContentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#uploadContentTenant");
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
| **tenantId** | **String**| ID of tenant | |
| **avsScan** | **Boolean**| Flag indicating whether or not to perform a virus scan. Reserved for trusted clients, set false to skip avs (default is true) | [optional] |
| **uploadContentRequest** | [**UploadContentRequest**](UploadContentRequest.md)| Pass binary data via multipart/form-data or in plain body | [optional] |

### Return type

[**Content**](Content.md)

### Authorization

[css.na-1-dev.api.opentext.com](../README.md#css.na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: multipart/form-data, application/octet-stream
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Content uploaded successfully |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

<a id="uploadContentURL"></a>
# **uploadContentURL**
> Content uploadContentURL(id, avsScan, uploadContentRequest)

Upload content with upload URL

Upload content with upload URL

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.ContentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    
    // Configure HTTP bearer authorization: css.na-1-dev.api.opentext.com
    HttpBearerAuth css.na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("css.na-1-dev.api.opentext.com");
    css.na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    ContentApi apiInstance = new ContentApi(defaultClient);
    String id = "id_example"; // String | ID of upload
    Boolean avsScan = true; // Boolean | Flag indicating whether or not to perform a virus scan. Reserved for trusted clients, set false to skip avs (default is true)
    UploadContentRequest uploadContentRequest = new UploadContentRequest(); // UploadContentRequest | Pass binary data via multipart/form-data or in plain body
    try {
      Content result = apiInstance.uploadContentURL(id, avsScan, uploadContentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#uploadContentURL");
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
| **id** | **String**| ID of upload | |
| **avsScan** | **Boolean**| Flag indicating whether or not to perform a virus scan. Reserved for trusted clients, set false to skip avs (default is true) | [optional] |
| **uploadContentRequest** | [**UploadContentRequest**](UploadContentRequest.md)| Pass binary data via multipart/form-data or in plain body | [optional] |

### Return type

[**Content**](Content.md)

### Authorization

[css.na-1-dev.api.opentext.com](../README.md#css.na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: multipart/form-data, application/octet-stream
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Content uploaded successfully |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

