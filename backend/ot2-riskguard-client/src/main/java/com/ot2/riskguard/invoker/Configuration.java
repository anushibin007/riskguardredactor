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


package com.ot2.riskguard.invoker;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-14T00:05:56.640873400+05:30[Asia/Calcutta]")
public class Configuration {
    public static final String VERSION = "1.0";

    private static ApiClient defaultApiClient = new ApiClient();

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     */
    public static ApiClient getDefaultApiClient() {
        return defaultApiClient;
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param apiClient API client
     */
    public static void setDefaultApiClient(ApiClient apiClient) {
        defaultApiClient = apiClient;
    }
}
