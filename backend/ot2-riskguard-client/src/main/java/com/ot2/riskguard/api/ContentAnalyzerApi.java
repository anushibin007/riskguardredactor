/*
 * Magellan Risk Guard
 * The Magellan Risk Guard REST service processes documents to help identify risks/threats. It is a completely stateless service that offers built-in accurate models. Leveraging the core components of Magellan Text Mining, the following information will be identified/extracted from documents  :  - PII(Personally Identifiable Information)  - Personal Secure Information (PSI)  - Hate Speech Classification  - Classification of images for threat/risk detection.  # Authentication  <!-- ReDoc-Inject: <security-definitions> -->
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.ot2.riskguard.api;

import com.ot2.riskguard.invoker.ApiCallback;
import com.ot2.riskguard.invoker.ApiClient;
import com.ot2.riskguard.invoker.ApiException;
import com.ot2.riskguard.invoker.ApiResponse;
import com.ot2.riskguard.invoker.Configuration;
import com.ot2.riskguard.invoker.Pair;
import com.ot2.riskguard.invoker.ProgressRequestBody;
import com.ot2.riskguard.invoker.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.ot2.riskguard.model.ContentResponse;
import java.io.File;
import com.ot2.riskguard.model.OT2ErrorMessage;
import com.ot2.riskguard.model.ProductVersion;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentAnalyzerApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ContentAnalyzerApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ContentAnalyzerApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for getProductVersion
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The version is retreived correctly </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> The internal processing error is occurred. Need to check the logs when this error is occurred. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getProductVersionCall(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/version";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "Bearer" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getProductVersionValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getProductVersionCall(_callback);

    }

    /**
     * Get version of Risk Guard Service
     * Get version of Risk Guard Service. This information includes service major and minor version details
     * @return ProductVersion
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The version is retreived correctly </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> The internal processing error is occurred. Need to check the logs when this error is occurred. </td><td>  -  </td></tr>
     </table>
     */
    public ProductVersion getProductVersion() throws ApiException {
        ApiResponse<ProductVersion> localVarResp = getProductVersionWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Get version of Risk Guard Service
     * Get version of Risk Guard Service. This information includes service major and minor version details
     * @return ApiResponse&lt;ProductVersion&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The version is retreived correctly </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> The internal processing error is occurred. Need to check the logs when this error is occurred. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ProductVersion> getProductVersionWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getProductVersionValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<ProductVersion>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get version of Risk Guard Service (asynchronously)
     * Get version of Risk Guard Service. This information includes service major and minor version details
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The version is retreived correctly </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> The internal processing error is occurred. Need to check the logs when this error is occurred. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getProductVersionAsync(final ApiCallback<ProductVersion> _callback) throws ApiException {

        okhttp3.Call localVarCall = getProductVersionValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<ProductVersion>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for processContent
     * @param _file  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The content is analyzed successfully </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> The internal processing error is occurred. Need to check the logs when this error is occurred. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call processContentCall(File _file, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/process";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (_file != null) {
            localVarFormParams.put("File", _file);
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "Bearer" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call processContentValidateBeforeCall(File _file, final ApiCallback _callback) throws ApiException {
        // verify the required parameter '_file' is set
        if (_file == null) {
            throw new ApiException("Missing the required parameter '_file' when calling processContent(Async)");
        }

        return processContentCall(_file, _callback);

    }

    /**
     * Process documents/images for extraction/identification of PII, PSI and threat/risk
     * This is the main end point of the service.  This takes the binary document with multi-part form data.  The parameter name should be &#39;File&#39; and the binary content should be attached to it.
     * @param _file  (required)
     * @return ContentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The content is analyzed successfully </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> The internal processing error is occurred. Need to check the logs when this error is occurred. </td><td>  -  </td></tr>
     </table>
     */
    public ContentResponse processContent(File _file) throws ApiException {
        ApiResponse<ContentResponse> localVarResp = processContentWithHttpInfo(_file);
        return localVarResp.getData();
    }

    /**
     * Process documents/images for extraction/identification of PII, PSI and threat/risk
     * This is the main end point of the service.  This takes the binary document with multi-part form data.  The parameter name should be &#39;File&#39; and the binary content should be attached to it.
     * @param _file  (required)
     * @return ApiResponse&lt;ContentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The content is analyzed successfully </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> The internal processing error is occurred. Need to check the logs when this error is occurred. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ContentResponse> processContentWithHttpInfo(File _file) throws ApiException {
        okhttp3.Call localVarCall = processContentValidateBeforeCall(_file, null);
        Type localVarReturnType = new TypeToken<ContentResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Process documents/images for extraction/identification of PII, PSI and threat/risk (asynchronously)
     * This is the main end point of the service.  This takes the binary document with multi-part form data.  The parameter name should be &#39;File&#39; and the binary content should be attached to it.
     * @param _file  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The content is analyzed successfully </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> The authorization error occurred. The bearer token either expired or invalid.  Please get the new bearer token from OTDS token URL. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> The internal processing error is occurred. Need to check the logs when this error is occurred. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call processContentAsync(File _file, final ApiCallback<ContentResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = processContentValidateBeforeCall(_file, _callback);
        Type localVarReturnType = new TypeToken<ContentResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
