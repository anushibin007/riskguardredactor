# ContentUsageApi

All URIs are relative to *https://css.na-1-dev.api.opentext.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**usageContentTenant**](ContentUsageApi.md#usageContentTenant) | **GET** /v2/tenant/{tenantId}/usage | Get total storage used by a tenant |


<a id="usageContentTenant"></a>
# **usageContentTenant**
> TenantUsageResponse usageContentTenant(tenantId, units)

Get total storage used by a tenant

Get total storage used by a tenant

### Example
```java
// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.ContentUsageApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    

    ContentUsageApi apiInstance = new ContentUsageApi(defaultClient);
    String tenantId = "tenantId_example"; // String | ID of tenant
    String units = "units_example"; // String | Units to use for storage display (possible values are B, KB, MB, GB, TB, default is MB)
    try {
      TenantUsageResponse result = apiInstance.usageContentTenant(tenantId, units);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentUsageApi#usageContentTenant");
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
| **units** | **String**| Units to use for storage display (possible values are B, KB, MB, GB, TB, default is MB) | [optional] |

### Return type

[**TenantUsageResponse**](TenantUsageResponse.md)

### Authorization

[tenant](../README.md#tenant)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Usage statistics retrieved successfully |  -  |
| **401** | The endpoint cannot be reached because the request is not authorized |  -  |
| **0** | Request failed |  -  |

