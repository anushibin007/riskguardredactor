/*
 * Core Capture Services
 * OpenText Core Capture Services are a set of RESTful web service interfaces that provides capture functionality. Being developed in a purely RESTful style, Core Capture Services are easier to consume for the purposes of writing custom clients.  Core Capture Services identifies resources by Uniform Resource Identifiers (URIs). It defines specific media types to represent resources and drives application state transfers by using link relations. It uses a limited number of HTTP standard methods (GET, POST, and DELETE) to manipulate these resources over the HTTP protocol.  Core Capture Services (hereafter simply called, \"service\") supports only the JSON format for resource representation. JavaScript Object Notation (JSON) is a lightweight data interchange format based on a subset of the JavaScript Programming Language standard.
 *
 * The version of the OpenAPI document: 23.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.ot2.corecapture.api;

import com.ot2.corecapture.invoker.ApiCallback;
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.ApiResponse;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.Pair;
import com.ot2.corecapture.invoker.ProgressRequestBody;
import com.ot2.corecapture.invoker.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.ot2.corecapture.model.Env;
import com.ot2.corecapture.model.Get415Response;
import com.ot2.corecapture.model.SessionDoctypesDocTypeGet200Response;
import com.ot2.corecapture.model.SessionDoctypesGet200Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentTypesApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public DocumentTypesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DocumentTypesApi(ApiClient apiClient) {
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
     * Build call for sessionDoctypesDocTypeGet
     * @param docType  (required)
     * @param env  (optional, default to P)
     * @param suppressResponseCodes This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sessionDoctypesDocTypeGetCall(String docType, Env env, String suppressResponseCodes, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/session/doctypes/{docType}"
            .replace("{" + "docType" + "}", localVarApiClient.escapeString(docType.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (env != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("Env", env));
        }

        if (suppressResponseCodes != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("suppress_response_codes", suppressResponseCodes));
        }

        final String[] localVarAccepts = {
            "application/hal+json",
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

        String[] localVarAuthNames = new String[] { "na-1-dev.api.opentext.com" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call sessionDoctypesDocTypeGetValidateBeforeCall(String docType, Env env, String suppressResponseCodes, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'docType' is set
        if (docType == null) {
            throw new ApiException("Missing the required parameter 'docType' when calling sessionDoctypesDocTypeGet(Async)");
        }

        return sessionDoctypesDocTypeGetCall(docType, env, suppressResponseCodes, _callback);

    }

    /**
     * Returns the Document Type identified by docType for the given environment.
     * This resource retrieves a specific Document Type. A Document Type is created using the Designer.
     * @param docType  (required)
     * @param env  (optional, default to P)
     * @param suppressResponseCodes This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes (optional)
     * @return SessionDoctypesDocTypeGet200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public SessionDoctypesDocTypeGet200Response sessionDoctypesDocTypeGet(String docType, Env env, String suppressResponseCodes) throws ApiException {
        ApiResponse<SessionDoctypesDocTypeGet200Response> localVarResp = sessionDoctypesDocTypeGetWithHttpInfo(docType, env, suppressResponseCodes);
        return localVarResp.getData();
    }

    /**
     * Returns the Document Type identified by docType for the given environment.
     * This resource retrieves a specific Document Type. A Document Type is created using the Designer.
     * @param docType  (required)
     * @param env  (optional, default to P)
     * @param suppressResponseCodes This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes (optional)
     * @return ApiResponse&lt;SessionDoctypesDocTypeGet200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<SessionDoctypesDocTypeGet200Response> sessionDoctypesDocTypeGetWithHttpInfo(String docType, Env env, String suppressResponseCodes) throws ApiException {
        okhttp3.Call localVarCall = sessionDoctypesDocTypeGetValidateBeforeCall(docType, env, suppressResponseCodes, null);
        Type localVarReturnType = new TypeToken<SessionDoctypesDocTypeGet200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Returns the Document Type identified by docType for the given environment. (asynchronously)
     * This resource retrieves a specific Document Type. A Document Type is created using the Designer.
     * @param docType  (required)
     * @param env  (optional, default to P)
     * @param suppressResponseCodes This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sessionDoctypesDocTypeGetAsync(String docType, Env env, String suppressResponseCodes, final ApiCallback<SessionDoctypesDocTypeGet200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = sessionDoctypesDocTypeGetValidateBeforeCall(docType, env, suppressResponseCodes, _callback);
        Type localVarReturnType = new TypeToken<SessionDoctypesDocTypeGet200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for sessionDoctypesGet
     * @param env  (optional, default to P)
     * @param suppressResponseCodes This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sessionDoctypesGetCall(Env env, String suppressResponseCodes, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/session/doctypes";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (env != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("Env", env));
        }

        if (suppressResponseCodes != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("suppress_response_codes", suppressResponseCodes));
        }

        final String[] localVarAccepts = {
            "application/hal+json",
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

        String[] localVarAuthNames = new String[] { "na-1-dev.api.opentext.com" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call sessionDoctypesGetValidateBeforeCall(Env env, String suppressResponseCodes, final ApiCallback _callback) throws ApiException {
        return sessionDoctypesGetCall(env, suppressResponseCodes, _callback);

    }

    /**
     * Returns the list of available Document Types for the given environment.
     * This operation returns a feed listing all of the Document Types. Document Types are created using the Designer.
     * @param env  (optional, default to P)
     * @param suppressResponseCodes This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes (optional)
     * @return SessionDoctypesGet200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public SessionDoctypesGet200Response sessionDoctypesGet(Env env, String suppressResponseCodes) throws ApiException {
        ApiResponse<SessionDoctypesGet200Response> localVarResp = sessionDoctypesGetWithHttpInfo(env, suppressResponseCodes);
        return localVarResp.getData();
    }

    /**
     * Returns the list of available Document Types for the given environment.
     * This operation returns a feed listing all of the Document Types. Document Types are created using the Designer.
     * @param env  (optional, default to P)
     * @param suppressResponseCodes This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes (optional)
     * @return ApiResponse&lt;SessionDoctypesGet200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<SessionDoctypesGet200Response> sessionDoctypesGetWithHttpInfo(Env env, String suppressResponseCodes) throws ApiException {
        okhttp3.Call localVarCall = sessionDoctypesGetValidateBeforeCall(env, suppressResponseCodes, null);
        Type localVarReturnType = new TypeToken<SessionDoctypesGet200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Returns the list of available Document Types for the given environment. (asynchronously)
     * This operation returns a feed listing all of the Document Types. Document Types are created using the Designer.
     * @param env  (optional, default to P)
     * @param suppressResponseCodes This can be left without an assignment or you can use itself, suppress_response_codes&#x3D;suppress_response_codes (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call sessionDoctypesGetAsync(Env env, String suppressResponseCodes, final ApiCallback<SessionDoctypesGet200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = sessionDoctypesGetValidateBeforeCall(env, suppressResponseCodes, _callback);
        Type localVarReturnType = new TypeToken<SessionDoctypesGet200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
