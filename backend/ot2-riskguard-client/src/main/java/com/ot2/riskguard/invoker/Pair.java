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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-13T23:29:38.127491300+05:30[Asia/Calcutta]")
public class Pair {
    private String name = "";
    private String value = "";

    public Pair (String name, String value) {
        setName(name);
        setValue(value);
    }

    private void setName(String name) {
        if (!isValidString(name)) {
            return;
        }

        this.name = name;
    }

    private void setValue(String value) {
        if (!isValidString(value)) {
            return;
        }

        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    private boolean isValidString(String arg) {
        if (arg == null) {
            return false;
        }

        return true;
    }
}
