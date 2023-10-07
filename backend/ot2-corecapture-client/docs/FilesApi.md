# FilesApi

All URIs are relative to *https://capture.ot2.opentext.com/cp-rest/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sessionFilesDelete**](FilesApi.md#sessionFilesDelete) | **DELETE** /session/files | Deletes all stage files. |
| [**sessionFilesFileIdDelete**](FilesApi.md#sessionFilesFileIdDelete) | **DELETE** /session/files/{fileId} | Deletes a stage file. |
| [**sessionFilesFileIdGet**](FilesApi.md#sessionFilesFileIdGet) | **GET** /session/files/{fileId} | Retrieves the file identified by the fileId. |
| [**sessionFilesFileIdPost**](FilesApi.md#sessionFilesFileIdPost) | **POST** /session/files/{fileId} | Appends or retries a stage file chunk. |
| [**sessionFilesPost**](FilesApi.md#sessionFilesPost) | **POST** /session/files | Creates a stage file. |


<a id="sessionFilesDelete"></a>
# **sessionFilesDelete**
> ReturnStatusBody sessionFilesDelete(filter, suppressResponseCodes)

Deletes all stage files.

This call deletes all stage files in the session including those returned by service calls. Once called, the deleted files will no longer be available.  Deleting files accepts a query string parameter, filter, as shown below. Currently, the only value this parameter supports is *, which means all files. This is the only filter value currently supported by the Services and provides for the deletion of all the files in the session.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.FilesApi;

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


    FilesApi apiInstance = new FilesApi(defaultClient);
    String filter = "*"; // String | 
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      ReturnStatusBody result = apiInstance.sessionFilesDelete(filter, suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#sessionFilesDelete");
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
| **filter** | **String**|  | [optional] |
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

[**ReturnStatusBody**](ReturnStatusBody.md)

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
| **500** | Internal Server Error |  -  |

<a id="sessionFilesFileIdDelete"></a>
# **sessionFilesFileIdDelete**
> ReturnStatusBody sessionFilesFileIdDelete(fileId, suppressResponseCodes)

Deletes a stage file.

An individual file can be deleted. Once deleted, the file can no longer be accessed.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.FilesApi;

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


    FilesApi apiInstance = new FilesApi(defaultClient);
    String fileId = "fileId_example"; // String | The id of the file
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      ReturnStatusBody result = apiInstance.sessionFilesFileIdDelete(fileId, suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#sessionFilesFileIdDelete");
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
| **fileId** | **String**| The id of the file | |
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

[**ReturnStatusBody**](ReturnStatusBody.md)

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
| **500** | Internal Server Error |  -  |

<a id="sessionFilesFileIdGet"></a>
# **sessionFilesFileIdGet**
> sessionFilesFileIdGet(fileId, suppressResponseCodes)

Retrieves the file identified by the fileId.

Retrieving an actual file that was previously POSTed is simply performed by executing a GET on the files URI with the fileId as shown below. This will return the actual file data.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.FilesApi;

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


    FilesApi apiInstance = new FilesApi(defaultClient);
    String fileId = "fileId_example"; // String | The id of the file
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      apiInstance.sessionFilesFileIdGet(fileId, suppressResponseCodes);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#sessionFilesFileIdGet");
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
| **fileId** | **String**| The id of the file | |
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

null (empty response body)

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

<a id="sessionFilesFileIdPost"></a>
# **sessionFilesFileIdPost**
> SessionFilesPost201Response sessionFilesFileIdPost(fileId, suppressResponseCodes, contentType, contentRange, inlineFileRequestBody)

Appends or retries a stage file chunk.

Chunking a file in pieces to the server requires that the POST be made to the URI represented by the src property or the URI provided by the Location header returned from the first chunk. Additional chunks append to the file and you can always retry/re-post the last chunk. Chunking requires the data for the file to be sent in base64 or binary encoding. The chunks need to be posted without gaps in order to be successful.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.FilesApi;

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


    FilesApi apiInstance = new FilesApi(defaultClient);
    String fileId = "fileId_example"; // String | The id of the file
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    String contentType = "application/msword"; // String | Supported response media types
    String contentRange = "contentRange_example"; // String | When using binary upload and chunking the upload, use this parameter to provide the range of bytes being uploaded. For e.g. \"bytes 0-19999/60200\", \"bytes 20000-60199/60200\"
    InlineFileRequestBody inlineFileRequestBody = new InlineFileRequestBody(); // InlineFileRequestBody | 
    try {
      SessionFilesPost201Response result = apiInstance.sessionFilesFileIdPost(fileId, suppressResponseCodes, contentType, contentRange, inlineFileRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#sessionFilesFileIdPost");
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
| **fileId** | **String**| The id of the file | |
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |
| **contentType** | **String**| Supported response media types | [optional] [enum: application/msword, application/octet-stream, application/rtf, application/pdf, image/jpeg, image/png, image/tiff, text/plain] |
| **contentRange** | **String**| When using binary upload and chunking the upload, use this parameter to provide the range of bytes being uploaded. For e.g. \&quot;bytes 0-19999/60200\&quot;, \&quot;bytes 20000-60199/60200\&quot; | [optional] |
| **inlineFileRequestBody** | [**InlineFileRequestBody**](InlineFileRequestBody.md)|  | [optional] |

### Return type

[**SessionFilesPost201Response**](SessionFilesPost201Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com), [capture.ot2.opentext.eu](../README.md#capture.ot2.opentext.eu), [eu-1.api.opentext.com](../README.md#eu-1.api.opentext.com), [capture.ot2.opentext.com](../README.md#capture.ot2.opentext.com), [na-1.api.opentext.com](../README.md#na-1.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json, application/msword, application/octet-stream, application/rtf, application/pdf, image/*, text/plain
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK or Created |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionFilesPost"></a>
# **sessionFilesPost**
> SessionFilesPost201Response sessionFilesPost(suppressResponseCodes, inlineFileRequestBody)

Creates a stage file.

You can only create one stage file at a time. Upon the first POST a unique fileId will be created by the server. File data can be posted either in base64 encoding as a JSON post or as a binary to the server.  If you need to chunk this in pieces to the server, then subsequent requests must be made to the URI represented by the src property or the URI provided by the Location header returned from the first chunk. Additional chunks append to the file and you can always retry/re-post the last chunk. The chunks need to be posted without gaps in order to be successful.  There are two ways to create a stage file:  - Create the stage file using a JSON post with base64 encoding.  - Post the file as binary using the appropriate Content-Type.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.FilesApi;

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


    FilesApi apiInstance = new FilesApi(defaultClient);
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    InlineFileRequestBody inlineFileRequestBody = new InlineFileRequestBody(); // InlineFileRequestBody | 
    try {
      SessionFilesPost201Response result = apiInstance.sessionFilesPost(suppressResponseCodes, inlineFileRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#sessionFilesPost");
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
| **inlineFileRequestBody** | [**InlineFileRequestBody**](InlineFileRequestBody.md)|  | [optional] |

### Return type

[**SessionFilesPost201Response**](SessionFilesPost201Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com), [capture.ot2.opentext.eu](../README.md#capture.ot2.opentext.eu), [eu-1.api.opentext.com](../README.md#eu-1.api.opentext.com), [capture.ot2.opentext.com](../README.md#capture.ot2.opentext.com), [na-1.api.opentext.com](../README.md#na-1.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json, application/msword, application/octet-stream, application/rtf, application/pdf, image/*, text/plain
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | OK or Created |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

