# RealTimeServicesApi

All URIs are relative to *https://capture.ot2.opentext.com/cp-rest/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sessionServicesClassifyPost**](RealTimeServicesApi.md#sessionServicesClassifyPost) | **POST** /session/services/classify | Classify Service. |
| [**sessionServicesClassifyextractdocumentPost**](RealTimeServicesApi.md#sessionServicesClassifyextractdocumentPost) | **POST** /session/services/classifyextractdocument | Classify Extract Document Service. |
| [**sessionServicesClassifyextractpagePost**](RealTimeServicesApi.md#sessionServicesClassifyextractpagePost) | **POST** /session/services/classifyextractpage | Classify Extract Page Service. |
| [**sessionServicesConvertimagesPost**](RealTimeServicesApi.md#sessionServicesConvertimagesPost) | **POST** /session/services/convertimages | Convert Images Service. |
| [**sessionServicesExtractdocumentPost**](RealTimeServicesApi.md#sessionServicesExtractdocumentPost) | **POST** /session/services/extractdocument | Extract Document Service. |
| [**sessionServicesExtractpagePost**](RealTimeServicesApi.md#sessionServicesExtractpagePost) | **POST** /session/services/extractpage | Extract Page Service. |
| [**sessionServicesFullpageocrPost**](RealTimeServicesApi.md#sessionServicesFullpageocrPost) | **POST** /session/services/fullpageocr | Full Page OCR Service. |
| [**sessionServicesGet**](RealTimeServicesApi.md#sessionServicesGet) | **GET** /session/services | Retrieves a list of the Real-Time Services that are available. |
| [**sessionServicesLearningPost**](RealTimeServicesApi.md#sessionServicesLearningPost) | **POST** /session/services/learning | Learning Service |
| [**sessionServicesProcessimagePost**](RealTimeServicesApi.md#sessionServicesProcessimagePost) | **POST** /session/services/processimage | Process Image Service. |
| [**sessionServicesProcessimagepipelinePost**](RealTimeServicesApi.md#sessionServicesProcessimagepipelinePost) | **POST** /session/services/processimagepipeline | Process Image Pipeline Service. |
| [**sessionServicesReadbarcodesPost**](RealTimeServicesApi.md#sessionServicesReadbarcodesPost) | **POST** /session/services/readbarcodes | Read BarCodes Service |
| [**sessionServicesUimdataPost**](RealTimeServicesApi.md#sessionServicesUimdataPost) | **POST** /session/services/uimdata | UIMData Service. |


<a id="sessionServicesClassifyPost"></a>
# **sessionServicesClassifyPost**
> SessionServicesConvertimagesPost200Response sessionServicesClassifyPost(servicesRequestBody)

Classify Service.

The Classify Service will perform Classification on the images submitted and return available Document Type and Template information if successful. In addition to template information, fields extracted as part of pre-index extraction will be retuned as fields in UimData.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **Project** - Optional string. The recognition project to use to classify the document. Valid values are \&quot;Default\&quot; for the Advanced Recognition and \&quot;InformationExtraction\&quot; for the Information Extraction. If omitted, \&quot;Default\&quot; is used.  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  - **OcrLocale** - Optional string. The locale that is used for reading text from the image when the request uses the \&quot;InformationExtraction\&quot; project. If omitted, text is read using the project&#39;s classification locale.  **Files Per Request Item**  This service supports JPEG, PNG, and TIFF files. There can only be one file per request item object. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource. The File Type property for the file is ignored for this service.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesConvertimagesPost200Response result = apiInstance.sessionServicesClassifyPost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesClassifyPost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesConvertimagesPost200Response**](SessionServicesConvertimagesPost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted. This can be correlated using the nodeId property if needed.  - **Values Per Result Item**    - **DocumentTypeName** - String. This is the Document Type name. e.g. \&quot;Form1040EZ\&quot;. Empty if no match was found.    - **TemplateId** - String. This is the image template ID provided by the Classify Real-Time Service. This will be \&quot;-1\&quot; if no match was found.    - **DocBoundary** - Number. Indicates whether this page defines a document boundary. Valid values are the following integers - 0 - means no document boundary. 1 - means natural separator. 2 - means artificial separator.    - **PaperOrientation** - Number. Indicates where image is rotated by classify service. Valid values are as followings - 0 means no rotation. 1 means 90 degrees rotation. 2 means 180 degrees rotation. 3 means 270 degrees rotation.    - **ClassificationId** - String. A server-generated ID that is used when learning to classify documents with the \&quot;InformationExtraction\&quot; project.    - **UimData** - Object. This is a UIM data information object. Returned if pre-index field extraction was performed.  - **Files Per Result Item**    Image only if input image was rotated in classification. File data is returned inline if “ReturnFileDataInline” request parameter is true, else file is returned by file reference id. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesClassifyextractdocumentPost"></a>
# **sessionServicesClassifyextractdocumentPost**
> SessionServicesClassifyextractpagePost200Response sessionServicesClassifyextractdocumentPost(servicesRequestBody)

Classify Extract Document Service.

The Classify Extract Document Service will perform classification and extraction on each item submitted and return an UIM object containing information from the result of classification and extraction. Optionally, the service will perform document separation as configured in the recognition project.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **IncludeOcrData** - Boolean. If true then the returned UIM data object will contain extracted characters information. Otherwise it won&#39;t.  - **EnableDocumentSeparation** - Optional string. Whether to perform auto document separation as per Dpp project folder management settings. Default value is “false”.  - **Project** - Optional string. The recognition project to use to classify the document. Valid values are \&quot;Default\&quot; for the Advanced Recognition and \&quot;InformationExtraction\&quot; for the Information Extraction. If omitted, \&quot;Default\&quot; is used.  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  - **OcrLocale** - Optional string. The locale that is used for reading text from the image when the request uses the \&quot;InformationExtraction\&quot; project. If omitted, text is read using the project&#39;s classification locale.  **Files Per Request Item**  This service supports JPEG, PNG, and TIFF files. Each item can have one or more files. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource. The File Type property for the file is ignored for this service.  If the request item contains more than one image, then the document type associated with the first classified page is used for the document. The extraction results for all pages belonging to the document type are merged into a single document. If a given field has conflicting values from different pages, then the value is set according to the \&quot;Extract Page\&quot; visual property for that field in the document type definition.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesClassifyextractpagePost200Response result = apiInstance.sessionServicesClassifyextractdocumentPost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesClassifyextractdocumentPost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesClassifyextractpagePost200Response**](SessionServicesClassifyextractpagePost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted. This can be correlated using the nodeId property if needed.  - **Values Per Result Item**    - **UimData** - Object. This is a UIM data information object, which contains the result of the classification and extraction operations. This value is present if document separation is not enabled (i.e. “EnableDocumentSeparation” service property is “false”).)    - **UimDataArray** - Array of UimData objects. This value is present if document separation is enabled (i.e. “EnableDocumentSeparation” service property is “true”). Array contains a UimData object for each auto separated document in the order of separated documents. If document separation generated one only one document, then array contains only one UimData for that document.)    - **DocumentFieldArray** - Array of strings. Array of comma separated list of document file Id references strings. This value is present if document separation is enabled (i.e. “EnableDocumentSeparation” service property is “true”). Array contains a string for each auto separated document in the order of separated documents. If document separation generated one only one document, then array contain only one string of comma separated list of document file Id references for that document only.)    - **ClassificationPageIds** - Array of strings. An array of server-generated IDs, one per page, that is used when learning to classify documents with the \&quot;InformationExtraction\&quot; project.  - **Files Per Result Item**    No files are returned by this Real-Time Service. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesClassifyextractpagePost"></a>
# **sessionServicesClassifyextractpagePost**
> SessionServicesClassifyextractpagePost200Response sessionServicesClassifyextractpagePost(servicesRequestBody)

Classify Extract Page Service.

The Classify Extract Page Service will perform classification and extraction on each item submitted and return a UIM object containing information from the result of classification and extraction.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **IncludeOcrData** - Boolean. If true then the returned UIM data object will contain extracted characters information. Otherwise by default, it won&#39;t.  - **Project** - Optional string. The recognition project to use to classify the document. Valid values are \&quot;Default\&quot; for the Advanced Recognition and \&quot;InformationExtraction\&quot; for the Information Extraction. If omitted, \&quot;Default\&quot; is used.  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  - **OcrLocale** - Optional string. The locale that is used for reading text from the image when the request uses the \&quot;InformationExtraction\&quot; project. If omitted, text is read using the project&#39;s classification locale.  **Files Per Request Item**  This service supports JPEG, PNG, and TIFF files. There can only be one file per request item object. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource. The File Type property for the file is ignored for this service.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesClassifyextractpagePost200Response result = apiInstance.sessionServicesClassifyextractpagePost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesClassifyextractpagePost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesClassifyextractpagePost200Response**](SessionServicesClassifyextractpagePost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted. This can be correlated using the nodeId property if needed.  - **Values Per Result Item**    - **DocumentTypeName** - String. This is the Document Type name. e.g. \&quot;Form1040EZ\&quot;. Empty if no match was found.    - **TemplateId** - String. This is the image template ID provided by the Classify Real-Time Service. This will be \&quot;-1\&quot; if no match was found.    - **DocBoundary** - Number. Indicates whether this page defines a document boundary. Valid values are the following integers - 0 - means no document boundary. 1 - means natural separator. 2 - means artificial separator.    - **ClassificationId** - String. A server-generated ID that is used when learning to classify documents with the \&quot;InformationExtraction\&quot; project.    - **UimData** - Object. This is a UIM data information object, which contains the result of the classification and extraction operations.  - **Files Per Result Item**    No files are returned by this Real-Time Service. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesConvertimagesPost"></a>
# **sessionServicesConvertimagesPost**
> SessionServicesConvertimagesPost200Response sessionServicesConvertimagesPost(servicesRequestBody)

Convert Images Service.

The Convert Images Real-Time Service provides image conversion capability as defined by an image conversion profile.  Capture Services currently only supports using system provided image conversion profiles named:  - SplitPDFProfile, - SplitPDFtoPDFs, - ConvertToJPEG and - CombineSearchablePDFs. \&quot;SplitPDFProfile\&quot; profile supports splitting PDF documents including colored documents resulting into tiff images of 300 DPI resolution. \&quot;SplitPDFtoPDFs\&quot; profile supports splitting multipage PDF document into single page PDF documents. \&quot;ConvertToJPEG\&quot; profile supports converting and splitting any type of document including colored document into multiple single page JPEG images. “CombineSearchablePDFs” profile supports merging multipage PDF documents into a single mutltipage PDF document. \&quot;SplitPDFtoPDFsCompress\&quot; and \&quot;CombineSearchablePDFsCompress\&quot; provide same functionality as \&quot;SplitPDFtoPDFs\&quot; and \&quot;CombineSearchablePDFs\&quot; respectively but with optimized (Compressed) output PDFs.  **Service Properties**  - **Env** - Metadata environment identifier. Value must be \&quot;S\&quot; since these profiles are system provided profile.  - **Profile** - Required String. The Image conversion profile name to use for the conversion. Currently only system provided profiles name are “SplitPDFProfile”, “SplitPDFtoPDFs”, “CombineSearchablePDFs”, \&quot;SplitPDFtoPDFsCompress\&quot; and “CombineSearchablePDFsCompress”.  - **ReturnFileDataInline** - Boolean. If true, then the resulting file is returned inline in the result item as a base64 encoded file. If omitted or false, then the resulting file is returned as a fileId and can be retrieved through the Files resource. File ID referncing the resulting file is returned as part of URI in \&quot;src\&quot; property of File object of Result Item.  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  No values are necessary or used.  **Files Per Request Item**  Each item can have one or more files. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource.  This service supports JPEG, PNG, TIFF, and PDF files. The File Type property for the file must specify the file extension for the file, such as \&quot;tif\&quot;, \&quot;png\&quot;, \&quot;jpg\&quot;, \&quot;pdf\&quot;. This is used by the Convert Images Real-Time Service for further typing of the file.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesConvertimagesPost200Response result = apiInstance.sessionServicesConvertimagesPost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesConvertimagesPost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesConvertimagesPost200Response**](SessionServicesConvertimagesPost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted.  **Values Per Result Item**  No values are returned in the result item objects.  **Files Per Result Item**  There will be one or more files returned based on what was submitted. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesExtractdocumentPost"></a>
# **sessionServicesExtractdocumentPost**
> SessionServicesClassifyextractpagePost200Response sessionServicesExtractdocumentPost(servicesRequestBody)

Extract Document Service.

The Extract Document Service will perform extraction on each item submitted and return a UIM object containing information from the result.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **IncludeOcrData** - Boolean. If true then the returned UIM data object will contain extracted characters information. Otherwise it won&#39;t.  - **Project** - Optional string. The recognition project to use to classify the document. Valid values are \&quot;Default\&quot; for the Advanced Recognition and \&quot;InformationExtraction\&quot; for the Information Extraction. If omitted, \&quot;Default\&quot; is used.  **Values Per Request Item**  - **DocumentTypeName** String. The Document Type name to be used for extraction. This is ignored if the TemplateIds property is passed. This value is case sensitive when the request uses the \&quot;InformationExtraction\&quot; project.  - **TemplateIds** - Array of Strings. The image template IDs assigned in the recognition project that are used for extraction. If not supplied, then the DocumentTypeName must be specified. Unused if the project is \&quot;InformationExtraction\&quot;. To skip a extraction from a page, set the template ID for that page to \&quot;-2\&quot;.  - **RepeatLastTemplate** - Boolean. If true and if the TemplateIds array has fewer entries than the request item has files, the last template ID is applied to the remaining files in the request item.  - **OcrLocale** - Optional string. The locale that is used for reading text from the image when the request uses the \&quot;InformationExtraction\&quot; project. If omitted, text is read using the extraction profile&#39;s locale.  **Files Per Request Item**  This service supports JPEG, PNG, and TIFF files. Each item can have one or more files. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource. The File Type property for the file is ignored for this service.  If the TemplateIds property is not included in the request, more than one image is sent, and the DocumentTypeName is specified, then the images are processed as follows. First, the templates in the specified document type are ordered by name (not ID). Then, the first template in the list is used for the first file in the request item, the second template in the list is used for the second file in the request item, and so forth. If the request item contains more images than there are templates in the document type, then the extra images are not processed for data extraction.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesClassifyextractpagePost200Response result = apiInstance.sessionServicesExtractdocumentPost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesExtractdocumentPost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesClassifyextractpagePost200Response**](SessionServicesClassifyextractpagePost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted. This can be correlated using the nodeId property if needed.  - **Values Per Result Item**    - **UimData** - Object. This is a UIM data information object, which contains the result of the extraction operation.    - **ClassificationPageIds** - Array of strings. An array of server-generated IDs, one per page, that is used when learning to classify documents with the \&quot;InformationExtraction\&quot; project.  - **Files Per Result Item**    No files are returned by this Real-Time Service. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesExtractpagePost"></a>
# **sessionServicesExtractpagePost**
> SessionServicesClassifyextractpagePost200Response sessionServicesExtractpagePost(servicesRequestBody)

Extract Page Service.

The Extract Page Service will perform extraction on each item submitted and return a UIM object containing information from the result.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **IncludeOcrData** - Boolean. If true then the returned UIM data object will contain extracted characters information. Otherwise it won&#39;t.  - **Project** - Optional string. The recognition project to use to classify the document. Valid values are \&quot;Default\&quot; for the Advanced Recognition and \&quot;InformationExtraction\&quot; for the Information Extraction. If omitted, \&quot;Default\&quot; is used.  **Values Per Request Item**  - **DocumentTypeName** - String. The Document Type name to be used for extraction. This is optional if the TemplateId property is passed. This value is case sensitive when the request uses the \&quot;InformationExtraction\&quot; project.  - **PageIndex** - Number. The zero-based page index within Document Type. If omitted, then it defaults to 0. This is optional if the TemplateId property is passed. Unused if the project is \&quot;InformationExtraction\&quot;.  - **TemplateId** - String. The image template ID assigned in the recognition project that should be used for extraction. If not supplied, then the DocumentTypeName should be specified. Unused if the project is \&quot;InformationExtraction\&quot;.  - **OcrLocale** - Optional string. The locale that is used for reading text from the image when the request uses the \&quot;InformationExtraction\&quot; project. If omitted, text is read using the extraction profile&#39;s locale.  **Files Per Request Item**  This service supports JPEG, PNG, and TIFF files. There can only be one file per request item object. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource. The File Type property for the file is ignored for this service.  If the DocumentTypeName and PageIndex are specified, then the data will be extracted based on the index of the template in the order of the template names (not IDs) in the specified document type. If the PageIndex is greater than the number of templates in the document type, then the image is not processed for data extraction.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesClassifyextractpagePost200Response result = apiInstance.sessionServicesExtractpagePost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesExtractpagePost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesClassifyextractpagePost200Response**](SessionServicesClassifyextractpagePost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted. This can be correlated using the nodeId property if needed.  - **Values Per Result Item**    - **UimData** - Object. This is a UIM data information object, which contains the result of the extraction operation.    - **ClassificationId** - String. A server-generated ID that is used when learning to classify documents with the \&quot;InformationExtraction\&quot; project.  - **Files Per Result Item**    No files are returned by this Real-Time Service. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesFullpageocrPost"></a>
# **sessionServicesFullpageocrPost**
> SessionServicesFullpageocrPost200Response sessionServicesFullpageocrPost(servicesRequestBody)

Full Page OCR Service.

The Full Page OCR Real-Time Service will provide full page OCR processing on submitted images or PDF documents and return the OCR content in the specified output type.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **OcrEngineName** - String. This specifies the OCR engine name to use. Currently supported engine is “Advanced”. \&quot;Advanced” OCR engine is currently assigned to the “OpenText Capture Recognition Engine” for this release. The default OCR engine is “Advanced”.  - **AutoRotate** - Boolean. This is an optional value specifying whether auto rotation should be enabled for the engine. The default is true.  - **Country** - String. This optional value specifies the country for the engine. The default is \&quot;USA\&quot;. When passing mutiple values in comma separated list, values must be within countries/languages groups given below:   - **Greek**: Greece, Greek   - **Latin and Cyrillic languages**: Afrikaans, Albanian, Andorra, Argentina, Australia, Austria, AzerbaijaniCyrillic, AzerbaijaniLatin, AzerbaijanCyrillic, AzerbaijanLatin, Baltic, Basque, Belarus, Belarusian, Belgium, BosnianLatin, BosniaLatin, Brazil, Bulgaria, Bulgarian, Canada, Catalan, CentralAmerica, CentralEurope, Chile, Colombia, Croatia, Croatian, Cyrillic, Czech, CzechLanguage, Danish, Denmark, Dutch, English, Estonia, Estonian, Faroese, Finland, Finnish, France, French, Frisian, German, Germany, GreatBritain, Greece, Greek, Guarani, Hani, Hungarian, Hungary, Iceland, Icelandic, Indonesian, Ireland, Irish, Italian, Italy, JapanLatin, KazakhCyrillic, KazakhLatin, KirghizCyrillic, Kirundi, Latin, Latvia, Latvian, Liechtenstein, Lithuania, Lithuanian, Luxembourg, Luxembourgish, Macedonian, Malay, Mexico, Netherlands, NewZealand, Norway, Norwegian, Poland, Polish, Portugal, Portuguese, Quechua, RhaetoRomanic, Romania, Romanian, Russia, Russian, Rwanda, Scandinavia, SerbianCyrillic, SerbianLatin, SerbiaCyrillic, SerbiaLatin, Shona, Slovak, Slovakia, Slovenia, Slovenian, Somali, Sorbian, SouthAfrica, SouthAmerica, SouthAmericaSpanish, Spain, Spanish, Swahili, Sweden, Swedish, Switzerland, TajikCyrillic, Turkey, Turkish, TurkmenCyrillic, TurkmenLatin, Ukraine, Ukrainian, USA, UzbekCyrillic, UzbekLatin, Venezuela, WesternEurope, Wolof, Xhosa, Zulu   - **Chinese**: ChineseSimplified, ChineseTraditional   - **Chinese Hong Kong**: ChineseTraditionalHongKong   - **Japanese**: Japan, Japanese (cannot both be selected.)   - **Korean**: Korean   - **Thai**: Thai, Thailand (English can be added explicitly) - **ProcessingMode** - String. This optional value specifies proessing mode value for the engine. The default is \&quot;VoteOcrAndEText\&quot;. This can be one of the following values:   - **VoteOcrAndEText** - Select this option if your input documents contain mixed content. The data from file is extracted by running the full page OCR reading. Where possible, electronic text is also extracted and the results are used to refine the OCR results.   - **OcrFromImage** - Select this option if your input documents are images / contain images only. The data from file is extracted by running the full page OCR reading   - **ExtractFromEText** - Select this option if your input files are PDF files that contain textual data only. Electronic text is extracted natively, as is  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  - **OutputType** - **Required** String. This setting specifies the OCR output type for the request item. It can be one of these values \&quot;Pdf\&quot;, \&quot;Text\&quot;. The additional values you can make on the request item are based on what is assigned to the OutputType.    - **Values for OutputType \&quot;Pdf\&quot;**      - **Version** - String. Can be one of these optional values \&quot;Pdf\&quot;, \&quot;Pdf14\&quot;, \&quot;Pdf15\&quot;, \&quot;Pdf16\&quot;, \&quot;Pdf17\&quot;, \&quot;PdfA1A\&quot;, \&quot;PdfA1B\&quot;, \&quot;PdfA2A\&quot;, \&quot;PdfA2B\&quot;, \&quot;PdfA2U\&quot;. If not provided, the default value is \&quot;Pdf\&quot;. Mapping to Acrobat version:\&quot;Pdf\&quot; -&gt; PDF 1.7, \&quot;Pdf14\&quot; -&gt; PDF 1.4, \&quot;Pdf15\&quot; -&gt; PDF 1.5, \&quot;Pdf16\&quot; -&gt; PDF 1.6, \&quot;Pdf17\&quot; -&gt; PDF 1.7, \&quot;PdfA1A\&quot; -&gt; PDF/A-1a, \&quot;PdfA1B\&quot; -&gt; PDF/A-1b, \&quot;PdfA2A\&quot; -&gt; PDF/A-2a and \&quot;PdfA2B\&quot; - &gt; PDF/A-2b, \&quot;PdfA2U\&quot; -&gt; PDF/A-2u     - **Compression** - String. Sets the compression level to apply to the text in the output PDF file.     Can be one of these optional values “None”, “Low, “Medium”, “High”. If not provided, the default value is “Medium”.      - **ImageSelection** - String. Can be one of these optional values. If not provided, the default value is “OriginalImage”.       - **NoImage** - Only extracted text will be included into the output file.       - **OriginalImage** - Extracted text will be included and the source image will be set as a background for the page in the output file.       - **ResultImage** - Extracted text will be included and the processed image will be set as a background for the page in the output file.     - **ImageResolutionLimit** - Number. Limits resolution of images (color, grey, binary) to provided value in DPI. If image resolution is lower than specified by this parameter, then image remains unchanged, otherwise it is scaled to this specified value.     Valid values are from 0 to 300. Default value is 150. When value is out of range (value outside 0 to 300), default is used.     - **JpegCompressionLevel** - Number. Controls the compression rate of the JPEG. Higher compression rates produce smaller files with lower image quality. The current version supports compression rates from 10, 15, 20, 25 an so on in increments of 5 until 90. Values other than 10, 15, 20, 25 etc in the range 10 to 90 are rounded to nearest valid value. E.g. 13 is rounded to 15.     The default value is 80. Default value is used when this parameter value is out of 10 to 90 range.     - **BinaryImage** - Boolean. Specifies whether to convert pdf file images to the binary format. When value is ‘true’ then pdf images are converted to the binary format. The default value is ‘false’.    - **Values for OutputType \&quot;Text\&quot;**      - None for output type “Text”. Encoding is “Unicode”.  **Files Per Request Item**  This service supports JPEG, PNG, TIFF, and PDF files. Each item can have one or more files. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource. The supported file input types for color and grayscale images are JPEG and PNG. The supported file input type for binary images is TIFF G4.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesFullpageocrPost200Response result = apiInstance.sessionServicesFullpageocrPost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesFullpageocrPost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesFullpageocrPost200Response**](SessionServicesFullpageocrPost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted.  **Values Per Result Item**  No values are returned in the result item objects.  **Files Per Result Item**  There will be one file returned per request item based on the OutputType specified in the request item. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesGet"></a>
# **sessionServicesGet**
> SessionServicesGet200Response sessionServicesGet(suppressResponseCodes)

Retrieves a list of the Real-Time Services that are available.

This operation returns a feed listing all of the Real-Time Services.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an assignment or you can use itself, suppress_response_codes=suppress_response_codes
    try {
      SessionServicesGet200Response result = apiInstance.sessionServicesGet(suppressResponseCodes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesGet");
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

[**SessionServicesGet200Response**](SessionServicesGet200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

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

<a id="sessionServicesLearningPost"></a>
# **sessionServicesLearningPost**
> SessionServicesConvertimagesPost200Response sessionServicesLearningPost(servicesRequestBody)

Learning Service

The Learning service is used to learn to classify and/or extract a document using the Information Extraction recognition project. The document must previously have been processed with one of the services that classify and/or extract the document in order to generate the needed server-side data for learning. Extraction IDs (extractionId) returned by the following services cannot be used for learning: Classify, ClassifyExtractPage, and ExtractPage. However, extraction IDs that are returned from the following services can be used: ClassifyExtractDocument, and ExtractDocument. In other words, only extraction IDs coming from document level classify or extract services are valid. Now, there are two situations where learning IDs will be invalid. First, if you change the structure of the batch such as rearranging pages, deleting pages, or adding new pages after you have called those APIs for classification and extraction, then you will need to clear the Extraction IDs (extractionId) in the UIMData as they will be invalid for learning. Second, if you modify a page such as rotating or cropping it, supply null for that page&#39;s classification ID instead of the ID returned by the classification APIs as the change to the image invalidates its classification.  For more efficient processing, if a document classified or extracted with the Information Extraction project will not be learned, the learning service should still be called with the learning mode set to \&quot;None\&quot;. This will delete any temporary server-side data that would otherwise be used for learning.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **Project** - String. Must be set to \&quot;InformationExtraction\&quot; for the Information Extraction project.  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  - **Mode** - String. Valid values:   - **Classify** - Learn to classify the supplied document.   - **Extract** - Learn to extract the supplied document.   - **ClassifyExtract** - Learn to both classify and extract the supplied document.   - **None** - Do not learn, but remove any temporary server-side data used for learning the supplied document.  - **UimData** - Object. This is a UIM data information object to be used for learning to extract. Learning works best if the field values have location rectangles. The page IDs for the field values are 0-based page numbers in this call.  - **DocumentType** String. The Document Type name to be used for learning to classify.  - **ClassificationPageIds** - Array of strings. The array of server-generated IDs, one per page, returned by classification functions. The service will use these values to learn to classify. If the entire document was extracted, this is the \&quot;ClassificationPageIds\&quot; returned by the extraction call. If the document was extracted page-by-page, it is an array of the per-page classification IDs. The values in the list must have the same order as the pages in the document.  **Files Per Request Item**  This service supports JPEG, PNG, and TIFF files. Each item can have one or more files. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource. The File Type property for the file is ignored for this service.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesConvertimagesPost200Response result = apiInstance.sessionServicesLearningPost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesLearningPost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesConvertimagesPost200Response**](SessionServicesConvertimagesPost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted. This can be correlated using the nodeId property if needed.  - **Values Per Result Item**    No values are returned in the result item objects.  - **Files Per Result Item**    No files are returned by this Real-Time Service. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesProcessimagePost"></a>
# **sessionServicesProcessimagePost**
> SessionServicesConvertimagesPost200Response sessionServicesProcessimagePost(servicesRequestBody)

Process Image Service.

The Process Image Real-Time Service provides image processing capability as defined by an image processor profile defined in the Designer.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **Profile** - Required String. The Image processor profile name to use.  - **ReturnFileDataInline** - Boolean. If true, then the resulting file is returned inline in the result item as a base64 encoded file. If omitted or false, then the resulting file is returned as a fileId and can be retrieved through the Files resource. File ID referncing the resulting file is returned as part of URI in \&quot;src\&quot; property of File object of Result Item.  - **Redact** - Boolean. Image will be redacted using “Rectangles” property passed in Request Item. Redaction will be done before profile filter processing if profile name is passed in. “Profile” property is optional when “Redact” property is “True”.  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  - **Rectangles** - **Optional** Object. Array of rectangles marking areas on image to be redacted. This parameter is used only when service property “Redact” is set to true. Rectangle identified by values in the order of Left, Top, Width, and Height. All values are Pixels with a resolution of 96 dpi in both X and Y direction. {   \&quot;left\&quot;:&lt;integer&gt;,   \&quot;top\&quot;:&lt;integer&gt;,   \&quot;width\&quot;:&lt;integer&gt;,   \&quot;height\&quot;:&lt;integer&gt; }  **Files Per Request Item**  This service supports JPEG, PNG, and TIFF files. There can only be one file per request item object. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource. The File Type property for the file is ignored for this service.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesConvertimagesPost200Response result = apiInstance.sessionServicesProcessimagePost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesProcessimagePost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesConvertimagesPost200Response**](SessionServicesConvertimagesPost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted.  **Values Per Result Item**  The values returned depend on the filters defined in the Image processor profile in the Designer. Each filter may return one or more values. Please see the Image Processor Guide help documentation for learning what return IA Values are specified for a particular filter.  **Files Per Result Item**  There will be one or more files returned based on what was submitted. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesProcessimagepipelinePost"></a>
# **sessionServicesProcessimagepipelinePost**
> SessionServicesProcessimagepipelinePost200Response sessionServicesProcessimagepipelinePost(servicesRequestBody)

Process Image Pipeline Service.

The Process Image Pipeline Real-Time services executes a series of image services on a single image based on service properties. The order of services execution is as follows::   - Image Enhancement   - Classify   - Extract  Outputs of all executed services are combined and returned in the response.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **ImageProfile** - If non empty, the incoming image is enhanced.  - **ReturnFileDataInline** - Boolean. If true, then the resulting file is returned inline in the result item as a base64 encoded file. If false, then the resulting file is returned as a fileId and can be retrieved through the Files resource. Default value is true. Applicable only if image enhancement is done. File ID referncing the resulting file is returned as part of URI in \&quot;src\&quot; property of File object of Result Item.  - **Classify** - Boolean. Classify the image.  - **Extract** - Boolean. Extract the image. If this is set then ClassifyAndExtract is performed on the image and “Classify” flag is ignored.  - **IncludeOcrData** - Boolean. If true then the returned UIM data object will contain extracted characters information. Otherwise it won&#39;t.  - **Project** - Optional string. The recognition project to use to classify the document. Valid values are \&quot;Default\&quot; for the Advanced Recognition and \&quot;InformationExtraction\&quot; for the Information Extraction. If omitted, \&quot;Default\&quot; is used.  - **OcrLocale** - Optional string. The locale that is used for reading text from the image when the request uses the \&quot;InformationExtraction\&quot; project. If omitted, text is read using the project&#39;s classification locale.  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  No values are necessary or used.  **Files Per Request Item**  This service supports JPEG, PNG, and TIFF files. There can only be one file in request item object. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesProcessimagepipelinePost200Response result = apiInstance.sessionServicesProcessimagepipelinePost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesProcessimagepipelinePost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesProcessimagepipelinePost200Response**](SessionServicesProcessimagepipelinePost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | **Values**  - The values returned by all services executed. Please refer to Real-Time services for the values returned.  **Files**  - Enhanced image file if image was enhanced. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesReadbarcodesPost"></a>
# **sessionServicesReadbarcodesPost**
> SessionServicesConvertimagesPost200Response sessionServicesReadbarcodesPost(servicesRequestBody)

Read BarCodes Service

The Read BarCodes Real-Time Service will provide barcode extraction processing.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  - **BarcodeTypes** - Required String. Comma separated list of available barcodes. List of barcodes types:   - Addon2, Addon5, AustralianPost, BCDMATRIX, Codabar, Code25_Datalogic, Code25_IATA, Code25_Industrial, Code25_Interleaved, Code25_Invert, Code25_Matrix, Code32, Code39, Code93, DataMatrix, EAN13, EAN8,IntelligentMail, PDF417, Postnet, QRCode, RoyalPost, Type128, UCC128, UPC_A, UPC_E  - **Characters** - Number. Exact number of characters to search for in the barcode text. Valid values range from 0 to 100.  - **Decode** - Boolean. If true, then it decodes the results into readable strings; otherwise, if false (the default), then it will not decode into readable strings.  - **MinHeight** - Number. Minimum height of barcode. Valid values range from 0 (default) to 1000.  - **Mode** - String. Barcode detection modes let you switch between normal and enhanced detection types. If omitted, defaults to **Normal**. Valid values:   - **Enhanced** - Provides better results by performing additional image preprocessing, but takes longer to complete,   - **Normal** - Enables quick barcodes detection.  - **Orientation** - String. Specifies the orientation of the barcodes detection. If omitted, then it **defaults** to **HorizontalVertical**. Valid values are:   - Horizontal,   - HorizontalVertical,   - HorizontalVerticalDiagonal,   - Vertical.  - **ScanDistance** - Number. Specifies the scan distance (in pixels) between line sweeps. Useful when searching for 1D type barcodes. Reducing the value improves detection of barcodes which are short relative to their height. Valid values are 1 to 10. If omitted, **defaults to 5**.  - **UseChecksum** - Boolean. A value that is an indication of whether the checksums are used. If omitted, then it **defaults to false**.  - **UseRegion** - String. A region to select for barcode detection in order to improve the barcode detection process. It **defaults to empty (not used)**.  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  No values are necessary or used.  **Files Per Request Item**  This service supports JPEG, PNG, and TIFF files. There can only be one file per request item object. It can either be an embedded file or a reference to a file ID previously posted to the Files Resource. The File Type property for the file is ignored for this service.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesConvertimagesPost200Response result = apiInstance.sessionServicesReadbarcodesPost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesReadbarcodesPost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesConvertimagesPost200Response**](SessionServicesConvertimagesPost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted.  - **Values Per Result Item**    Each result item object may have zero or more properties depending on the success of the Read BarCodes Real-Time Service to provide barcode information. The following possible values for each result item object may be returned:    - **Barcode{0}_Conf** - Number. The barcode value’s confidence as a percentage number. Valid confidence values are 0 to 100. {0} is the index for the detected barcodes. The index values run from 0 to 9 in order of detection.)    - **Barcode{0}_Height** - Number. The barcode&#39;s height in pixels. {0} is the index for the detected barcodes. The index values run from 0 to 9 in order of detection.    - **Barcode{0}_Text** - Number. The barcode&#39;s text value. {0} is the index for the detected barcodes. The index values run from 0 to 9 in order of detection.    - **Barcode{0}_Type** - String. The barcode&#39;s type name. {0} is the index for the detected barcodes. The index values run from 0 to 9 in order of detection.    - **Barcode{0}_Width** - Number. The barcode&#39;s width in pixels. {0} is the index for the detected barcodes. The index values run from 0 to 9 in order of detection.    - **Barcode{0}_X** - Number. The barcode’s X coordinate in pixels. {0} is the index for the detected barcodes. The index values run from 0 to 9 in order of detection.    - **Barcode{0}_Y** - The barcode’s Y coordinate in pixels. {0} is the index for the detected barcodes. The index values run from 0 to 9 in order of detection.    - **Barcodes_Count** - Number. The number of barcodes detected.  - **Files Per Result Item**    No files are returned by this Real-Time Service. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="sessionServicesUimdataPost"></a>
# **sessionServicesUimdataPost**
> SessionServicesUimdataPost200Response sessionServicesUimdataPost(servicesRequestBody)

UIMData Service.

The UimData Real-Time Service will provide either UIM (Unified Indexing Model) data population or validation or both population and validation. The population and validation rules referenced below are developed in the Designer when constructing a Document Type. Please see the Designer documentation for more information about rules and Document Types.  **Service Properties**  - **Env** - Metadata environment identifier. Value is one of \&quot;D\&quot;, \&quot;T\&quot; or \&quot;P\&quot;. Default value is \&quot;P\&quot;.  **Number of Request Items**  This Real-Time Service supports one or more items.  **Values Per Request Item**  - **Command** - String. Valid values:   - **Validate** - UimData is validated as per validation rules,   - **Populate** - UimData fields are populated using population rules, or   - **PopulateAndValidate** - UimData fields are populated using population rules and then the data is validated per data validation rules.  - **TriggerReference** - String. Name of the field that is used as a population trigger or population target. Used only for Populate or PopulateAndValidate commands. If this is empty or not provided, then the service will run all the rules on the supplied UimData. If it is populated, then it will only run rules that are not one-time rules.  - **TriggerKind** - String. One of the following values. Used only for Populate or PopulateAndValidate commands.   - **Calculate** - The first expression population rule where TriggerReference is used as the target field is run. This can also be an array field name with a valid row index specified in PopulateTriggerRow,   - **Lookup** - All population rules of type DatabaseLookup are run in the specified order, where the TriggerReference is one of the trigger fields. This can also be an array field name with a valid row index specified in PopulateTriggerRow, or   - **PopulateOptions** - The first DatebaseLookup rule is run where TriggerReference is one of the trigger fields and the Choice values are populated by the first two columns of the result set. This can also be an array field name with a valid row index specified in PopulateTriggerRow.  - **PopulateTriggerRow** - Integer. This is a zero based row index for array field based population. This property is ignored if no field name was supplied in the \&quot;triggerReference\&quot; property or if the field name supplied is not an array field. The operation will also fail if the index supplied for this property is invalid for the supplied array field name.  - **UimData** - Object. This is a UIM data information object that you want the service to use for performing the command.  **Files Per Request Item**  No files are necessary or used.

### Example
```java
// Import classes:
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.*;
import com.ot2.corecapture.invoker.models.*;
import com.ot2.corecapture.api.RealTimeServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://capture.ot2.opentext.com/cp-rest/v2");
    
    // Configure HTTP bearer authorization: na-1-dev.api.opentext.com
    HttpBearerAuth na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
    na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);
    ServicesRequestBody servicesRequestBody = new ServicesRequestBody(); // ServicesRequestBody | 
    try {
      SessionServicesUimdataPost200Response result = apiInstance.sessionServicesUimdataPost(servicesRequestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RealTimeServicesApi#sessionServicesUimdataPost");
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
| **servicesRequestBody** | [**ServicesRequestBody**](ServicesRequestBody.md)|  | [optional] |

### Return type

[**SessionServicesUimdataPost200Response**](SessionServicesUimdataPost200Response.md)

### Authorization

[na-1-dev.api.opentext.com](../README.md#na-1-dev.api.opentext.com)

### HTTP request headers

 - **Content-Type**: application/hal+json
 - **Accept**: application/hal+json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The result item objects will be put in the same order as the request items that were submitted. This can be correlated using the nodeId property if needed.  - **Values Per Result Item**    - **UimData** - Object. This is a UIM data information object, which contains the result of the service operation.  - **Files Per Result Item**    No files are returned by thie Real-Time Service. |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

