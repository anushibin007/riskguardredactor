# TablesApi

All URIs are relative to *https://capture.ot2.opentext.com/cp-rest/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sessionTablesGet**](TablesApi.md#sessionTablesGet) | **GET** /session/tables | Returns a list of available tables for the given environment. |
| [**sessionTablesTableIdGet**](TablesApi.md#sessionTablesTableIdGet) | **GET** /session/tables/{tableId} | Returns the table identified by tableId for the given environment. |


<a id="sessionTablesGet"></a>
# **sessionTablesGet**
> SessionTablesGet200Response sessionTablesGet(env, suppressResponseCodes)

Returns a list of available tables for the given environment.

The server maintains different tables that provide information about key pieces of data to authenticated users.

### Example
```java
// Import classes:
import com.ot2.ApiClient;
import com.ot2.ApiException;
import com.ot2.Configuration;
import com.ot2.auth.*;
import com.ot2.models.*;
import com.ot2.corecapture.TablesApi;

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


    TablesApi apiInstance = new TablesApi(defaultClient);
    Env env = Env.fromValue("D"); // Env | 
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      SessionTablesGet200Response result = apiInstance.sessionTablesGet(env, suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TablesApi#sessionTablesGet");
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
| **env** | [**Env**](.md)|  | [default to P] [enum: D, T, P] |
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

[**SessionTablesGet200Response**](SessionTablesGet200Response.md)

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

<a id="sessionTablesTableIdGet"></a>
# **sessionTablesTableIdGet**
> SessionTablesTableIdGet200Response sessionTablesTableIdGet(tableId, view, sort, env, suppressResponseCodes)

Returns the table identified by tableId for the given environment.

The Table Resource pertains to a specific table from the set of available tables on the server.

### Example
```java
// Import classes:
import com.ot2.ApiClient;
import com.ot2.ApiException;
import com.ot2.Configuration;
import com.ot2.auth.*;
import com.ot2.models.*;
import com.ot2.corecapture.TablesApi;

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


    TablesApi apiInstance = new TablesApi(defaultClient);
    String tableId = "exportProfiles"; // String | 
    String view = "name,createtime"; // String | Fields or properties to return.  **Syntax:** ?view=<:view-name | comma-delim-field-list>  **Note:** A view is followed by either a view name preceded by a colon or a list of fields. These are mutually exclusive. Two predefined views are provided - \":all\" and \":default\". Both of these are equivalent and will return all columns for the data. If this query parameter is not provided, then the result will include all column data.
    String sort = "createtime asc"; // String | Used to sort the result.  **Syntax:** ?sort=<field [desc | asc]>[,REPEATABLE]  **Note:** Sort is followed by a comma-separated list of fields and each field can have an optional sort order separated by a space. If the sort order is not specified, then the default sort order is ASC. If this query parameter is not provided at all, then the result will be sorted based on its first column in ascending order.
    Env env = Env.fromValue("D"); // Env | 
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      SessionTablesTableIdGet200Response result = apiInstance.sessionTablesTableIdGet(tableId, view, sort, env, suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TablesApi#sessionTablesTableIdGet");
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
| **tableId** | **String**|  | [enum: exportProfiles, imageProcessingProfiles] |
| **view** | **String**| Fields or properties to return.  **Syntax:** ?view&#x3D;&lt;:view-name | comma-delim-field-list&gt;  **Note:** A view is followed by either a view name preceded by a colon or a list of fields. These are mutually exclusive. Two predefined views are provided - \&quot;:all\&quot; and \&quot;:default\&quot;. Both of these are equivalent and will return all columns for the data. If this query parameter is not provided, then the result will include all column data. | [optional] |
| **sort** | **String**| Used to sort the result.  **Syntax:** ?sort&#x3D;&lt;field [desc | asc]&gt;[,REPEATABLE]  **Note:** Sort is followed by a comma-separated list of fields and each field can have an optional sort order separated by a space. If the sort order is not specified, then the default sort order is ASC. If this query parameter is not provided at all, then the result will be sorted based on its first column in ascending order. | [optional] |
| **env** | [**Env**](.md)|  | [optional] [default to P] [enum: D, T, P] |
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

[**SessionTablesTableIdGet200Response**](SessionTablesTableIdGet200Response.md)

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
| **404** | Not Found |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

