# SharableLinksApi

All URIs are relative to *https://css.na-1-dev.api.opentext.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSharableLink**](SharableLinksApi.md#createSharableLink) | **POST** /v2/content/{id}/publicShareUrl | Create a new sharable-link for download |
| [**deleteSharableLink**](SharableLinksApi.md#deleteSharableLink) | **DELETE** /v2/content/{id}/publicShareUrl/{urlId} | Delete a sharable link |
| [**getSharableLink**](SharableLinksApi.md#getSharableLink) | **GET** /v2/content/{id}/publicShareUrl/{urlId} | Retrieve sharable link object |
| [**updateSharableLink**](SharableLinksApi.md#updateSharableLink) | **PUT** /v2/content/{id}/publicShareUrl/{urlId} | Update a sharable link |


<a id="createSharableLink"></a>
# **createSharableLink**
> NewLinkResponse createSharableLink(id, objectId, newLinkRequest)

Create a new sharable-link for download

Create a new sharable-link for download

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.SharableLinksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    

    SharableLinksApi apiInstance = new SharableLinksApi(defaultClient);
    String id = "id_example"; // String | ID of upload
    String objectId = "objectId_example"; // String | The ID of the object attached with the content
    NewLinkRequest newLinkRequest = new NewLinkRequest(); // NewLinkRequest | Password and expiry
    try {
      NewLinkResponse result = apiInstance.createSharableLink(id, objectId, newLinkRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SharableLinksApi#createSharableLink");
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
| **objectId** | **String**| The ID of the object attached with the content | [optional] |
| **newLinkRequest** | [**NewLinkRequest**](NewLinkRequest.md)| Password and expiry | [optional] |

### Return type

[**NewLinkResponse**](NewLinkResponse.md)

### Authorization

[tenant](../README.md#tenant)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Download URL |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

<a id="deleteSharableLink"></a>
# **deleteSharableLink**
> deleteSharableLink(id, urlId)

Delete a sharable link

Delete a sharable link

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.SharableLinksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    

    SharableLinksApi apiInstance = new SharableLinksApi(defaultClient);
    String id = "id_example"; // String | ID of upload
    String urlId = "urlId_example"; // String | ID of download url
    try {
      apiInstance.deleteSharableLink(id, urlId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SharableLinksApi#deleteSharableLink");
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
| **urlId** | **String**| ID of download url | |

### Return type

null (empty response body)

### Authorization

[tenant](../README.md#tenant)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Deletion successfully, No content |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

<a id="getSharableLink"></a>
# **getSharableLink**
> NewLinkResponse getSharableLink(id, urlId)

Retrieve sharable link object

Retrieve sharable link object

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.SharableLinksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    

    SharableLinksApi apiInstance = new SharableLinksApi(defaultClient);
    String id = "id_example"; // String | ID of upload
    String urlId = "urlId_example"; // String | ID of download url
    try {
      NewLinkResponse result = apiInstance.getSharableLink(id, urlId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SharableLinksApi#getSharableLink");
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
| **urlId** | **String**| ID of download url | |

### Return type

[**NewLinkResponse**](NewLinkResponse.md)

### Authorization

[tenant](../README.md#tenant)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Updated successfully |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

<a id="updateSharableLink"></a>
# **updateSharableLink**
> NewLinkResponse updateSharableLink(id, urlId, updateLinkRequest)

Update a sharable link

Update a sharable link

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.SharableLinksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    

    SharableLinksApi apiInstance = new SharableLinksApi(defaultClient);
    String id = "id_example"; // String | ID of upload
    String urlId = "urlId_example"; // String | ID of download url
    UpdateLinkRequest updateLinkRequest = new UpdateLinkRequest(); // UpdateLinkRequest | Expiry
    try {
      NewLinkResponse result = apiInstance.updateSharableLink(id, urlId, updateLinkRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SharableLinksApi#updateSharableLink");
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
| **urlId** | **String**| ID of download url | |
| **updateLinkRequest** | [**UpdateLinkRequest**](UpdateLinkRequest.md)| Expiry | [optional] |

### Return type

[**NewLinkResponse**](NewLinkResponse.md)

### Authorization

[tenant](../README.md#tenant)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Update successfully |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

