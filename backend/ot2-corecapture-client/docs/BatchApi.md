# BatchApi

All URIs are relative to *https://capture.ot2.opentext.com/cp-rest/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sessionBatchesPost**](BatchApi.md#sessionBatchesPost) | **POST** /session/batches | Creates and exports a batch. |


<a id="sessionBatchesPost"></a>
# **sessionBatchesPost**
> SessionBatchesPost201Response sessionBatchesPost(sessionBatchesPostRequest, suppressResponseCodes)

Creates and exports a batch.

The Create and Export Batch operation is the last call required to create a batch and submit it to your backend server. First submit all image files to server, then you can use the returned file reference ids to reference files in the Batch nodal information. You can also use the same file reference ids returned by Real-Time service calls.  The batch name that you use to create a batch has to be unique when being imported into your backend server. To help you accomplish creating unique names you can supply for the \&quot;batchName\&quot; JSON property any Capture Services Format Expression function (see the Designer Documentation). There are also two additional format tokens you can use for providing unique names - {NextIndex} and {NextId}  **{NextIndex}** - This will provide a 64 bit integer number that is unique. Example: \&quot;batchName\&quot;:\&quot;MyBatch_{NextIndex}\&quot; produces on the server MyBatch_1026000000002  **{NextId}** - This will provide a valid Batch name string that is unique. Example: \&quot;batchName\&quot;:\&quot;MyBatch_{NextId}\&quot; produces on the server MyBatch_324_1  Any supported static function in the Capture Services Expression Language (see the Designer Documentation). [&lt;any text&gt;]{[&lt;Format Specification&gt;|]&lt;Expression&gt;}[&lt;any text&gt;] - Using the expression language functions can allow the user of a GUID or unique time string to be a part of the Batch Name. Example: \&quot;batchName\&quot;:\&quot;MyBatch_{Tddhhmmss|Now()}_{NextIndex}\&quot; produces on the server, MyBatch_09064934_1026000000003. Or \&quot;batchName\&quot;:\&quot;MyBatch_{S|CreateGuid(0)}\&quot; produces on the server, MyBatch_82fcd238-2fb7-44ac-9acc-a13ce406241d  **Document type and UimData values in batch:**  For composing export profile and exporting UimData values, Document type and UimData values must at batch level mentioned below with given names as below.  **Batch – Level 7:**  valueName &#x3D; \&quot;Profile \&quot;  valueType &#x3D; \&quot;string\&quot;  value &#x3D; // Name of the profile.  **Document – Level 1:**  valueName &#x3D; \&quot;UimDocumentType\&quot;  valueType &#x3D; \&quot;string\&quot;  value &#x3D; // This should be a string specifying the document type name.  valueName &#x3D; \&quot;UimData\&quot;  valueType &#x3D; \&quot;uimdata\&quot;  value &#x3D; // This should be a UIM Data JSON Object  valueName &#x3D; \&quot;OutputFile \&quot;  valueType &#x3D; \&quot; file\&quot;  value &#x3D; // File id for the original PDF to be available for export.  **Page – Level 0:**  valueName &#x3D; \&quot;OutputImage\&quot;  valueType &#x3D; \&quot;file\&quot;  value &#x3D; // file id for the image to be exported  valueName &#x3D; \&quot;Backside\&quot;  valueType &#x3D; \&quot;int\&quot;  value &#x3D; // 0 (front) or 1 (back) to indicate whether the image is a backside image.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.BatchApi;

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


    BatchApi apiInstance = new BatchApi(defaultClient);
    SessionBatchesPostRequest sessionBatchesPostRequest = new SessionBatchesPostRequest(); // SessionBatchesPostRequest | 
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      SessionBatchesPost201Response result = apiInstance.sessionBatchesPost(sessionBatchesPostRequest, suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BatchApi#sessionBatchesPost");
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
| **sessionBatchesPostRequest** | [**SessionBatchesPostRequest**](SessionBatchesPostRequest.md)|  | |
| **suppressResponseCodes** | **String**| This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes | [optional] |

### Return type

[**SessionBatchesPost201Response**](SessionBatchesPost201Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com), [capture.ot2.opentext.eu](../README.md#capture.ot2.opentext.eu), [eu-1.api.opentext.com](../README.md#eu-1.api.opentext.com), [capture.ot2.opentext.com](../README.md#capture.ot2.opentext.com), [na-1.api.opentext.com](../README.md#na-1.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

