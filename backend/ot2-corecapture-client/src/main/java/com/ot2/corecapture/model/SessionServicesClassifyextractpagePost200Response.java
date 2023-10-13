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


package com.ot2.corecapture.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ot2.corecapture.model.BasicResultItemWithValues;
import com.ot2.corecapture.model.ReturnStatusBody;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ot2.corecapture.invoker.JSON;

/**
 * SessionServicesClassifyextractpagePost200Response
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-13T23:29:40.322735800+05:30[Asia/Calcutta]")
public class SessionServicesClassifyextractpagePost200Response {
  public static final String SERIALIZED_NAME_RETURN_STATUS = "returnStatus";
  @SerializedName(SERIALIZED_NAME_RETURN_STATUS)
  private ReturnStatusBody returnStatus;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_SERVICE_NAME = "serviceName";
  @SerializedName(SERIALIZED_NAME_SERVICE_NAME)
  private String serviceName;

  public static final String SERIALIZED_NAME_EXECUTION_MILLI_SECONDS = "executionMilliSeconds";
  @SerializedName(SERIALIZED_NAME_EXECUTION_MILLI_SECONDS)
  private String executionMilliSeconds;

  public static final String SERIALIZED_NAME_LICENSE_USED_PERCENT = "licenseUsedPercent";
  @SerializedName(SERIALIZED_NAME_LICENSE_USED_PERCENT)
  private Integer licenseUsedPercent;

  public static final String SERIALIZED_NAME_LICENSE_PAGES_USED = "licensePagesUsed";
  @SerializedName(SERIALIZED_NAME_LICENSE_PAGES_USED)
  private Integer licensePagesUsed;

  public static final String SERIALIZED_NAME_LICENSE_PAGES_USED2 = "licensePagesUsed2";
  @SerializedName(SERIALIZED_NAME_LICENSE_PAGES_USED2)
  private Integer licensePagesUsed2;

  public static final String SERIALIZED_NAME_RESULT_ITEMS = "resultItems";
  @SerializedName(SERIALIZED_NAME_RESULT_ITEMS)
  private List<BasicResultItemWithValues> resultItems;

  public SessionServicesClassifyextractpagePost200Response() {
  }

  public SessionServicesClassifyextractpagePost200Response returnStatus(ReturnStatusBody returnStatus) {
    
    this.returnStatus = returnStatus;
    return this;
  }

   /**
   * Get returnStatus
   * @return returnStatus
  **/
  @javax.annotation.Nullable
  public ReturnStatusBody getReturnStatus() {
    return returnStatus;
  }


  public void setReturnStatus(ReturnStatusBody returnStatus) {
    this.returnStatus = returnStatus;
  }


  public SessionServicesClassifyextractpagePost200Response id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public SessionServicesClassifyextractpagePost200Response serviceName(String serviceName) {
    
    this.serviceName = serviceName;
    return this;
  }

   /**
   * Get serviceName
   * @return serviceName
  **/
  @javax.annotation.Nullable
  public String getServiceName() {
    return serviceName;
  }


  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }


  public SessionServicesClassifyextractpagePost200Response executionMilliSeconds(String executionMilliSeconds) {
    
    this.executionMilliSeconds = executionMilliSeconds;
    return this;
  }

   /**
   * Get executionMilliSeconds
   * @return executionMilliSeconds
  **/
  @javax.annotation.Nullable
  public String getExecutionMilliSeconds() {
    return executionMilliSeconds;
  }


  public void setExecutionMilliSeconds(String executionMilliSeconds) {
    this.executionMilliSeconds = executionMilliSeconds;
  }


  public SessionServicesClassifyextractpagePost200Response licenseUsedPercent(Integer licenseUsedPercent) {
    
    this.licenseUsedPercent = licenseUsedPercent;
    return this;
  }

   /**
   * Get licenseUsedPercent
   * @return licenseUsedPercent
  **/
  @javax.annotation.Nullable
  public Integer getLicenseUsedPercent() {
    return licenseUsedPercent;
  }


  public void setLicenseUsedPercent(Integer licenseUsedPercent) {
    this.licenseUsedPercent = licenseUsedPercent;
  }


  public SessionServicesClassifyextractpagePost200Response licensePagesUsed(Integer licensePagesUsed) {
    
    this.licensePagesUsed = licensePagesUsed;
    return this;
  }

   /**
   * Get licensePagesUsed
   * @return licensePagesUsed
  **/
  @javax.annotation.Nullable
  public Integer getLicensePagesUsed() {
    return licensePagesUsed;
  }


  public void setLicensePagesUsed(Integer licensePagesUsed) {
    this.licensePagesUsed = licensePagesUsed;
  }


  public SessionServicesClassifyextractpagePost200Response licensePagesUsed2(Integer licensePagesUsed2) {
    
    this.licensePagesUsed2 = licensePagesUsed2;
    return this;
  }

   /**
   * Get licensePagesUsed2
   * @return licensePagesUsed2
  **/
  @javax.annotation.Nullable
  public Integer getLicensePagesUsed2() {
    return licensePagesUsed2;
  }


  public void setLicensePagesUsed2(Integer licensePagesUsed2) {
    this.licensePagesUsed2 = licensePagesUsed2;
  }


  public SessionServicesClassifyextractpagePost200Response resultItems(List<BasicResultItemWithValues> resultItems) {
    
    this.resultItems = resultItems;
    return this;
  }

  public SessionServicesClassifyextractpagePost200Response addResultItemsItem(BasicResultItemWithValues resultItemsItem) {
    if (this.resultItems == null) {
      this.resultItems = new ArrayList<>();
    }
    this.resultItems.add(resultItemsItem);
    return this;
  }

   /**
   * Get resultItems
   * @return resultItems
  **/
  @javax.annotation.Nullable
  public List<BasicResultItemWithValues> getResultItems() {
    return resultItems;
  }


  public void setResultItems(List<BasicResultItemWithValues> resultItems) {
    this.resultItems = resultItems;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionServicesClassifyextractpagePost200Response sessionServicesClassifyextractpagePost200Response = (SessionServicesClassifyextractpagePost200Response) o;
    return Objects.equals(this.returnStatus, sessionServicesClassifyextractpagePost200Response.returnStatus) &&
        Objects.equals(this.id, sessionServicesClassifyextractpagePost200Response.id) &&
        Objects.equals(this.serviceName, sessionServicesClassifyextractpagePost200Response.serviceName) &&
        Objects.equals(this.executionMilliSeconds, sessionServicesClassifyextractpagePost200Response.executionMilliSeconds) &&
        Objects.equals(this.licenseUsedPercent, sessionServicesClassifyextractpagePost200Response.licenseUsedPercent) &&
        Objects.equals(this.licensePagesUsed, sessionServicesClassifyextractpagePost200Response.licensePagesUsed) &&
        Objects.equals(this.licensePagesUsed2, sessionServicesClassifyextractpagePost200Response.licensePagesUsed2) &&
        Objects.equals(this.resultItems, sessionServicesClassifyextractpagePost200Response.resultItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(returnStatus, id, serviceName, executionMilliSeconds, licenseUsedPercent, licensePagesUsed, licensePagesUsed2, resultItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionServicesClassifyextractpagePost200Response {\n");
    sb.append("    returnStatus: ").append(toIndentedString(returnStatus)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
    sb.append("    executionMilliSeconds: ").append(toIndentedString(executionMilliSeconds)).append("\n");
    sb.append("    licenseUsedPercent: ").append(toIndentedString(licenseUsedPercent)).append("\n");
    sb.append("    licensePagesUsed: ").append(toIndentedString(licensePagesUsed)).append("\n");
    sb.append("    licensePagesUsed2: ").append(toIndentedString(licensePagesUsed2)).append("\n");
    sb.append("    resultItems: ").append(toIndentedString(resultItems)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("returnStatus");
    openapiFields.add("id");
    openapiFields.add("serviceName");
    openapiFields.add("executionMilliSeconds");
    openapiFields.add("licenseUsedPercent");
    openapiFields.add("licensePagesUsed");
    openapiFields.add("licensePagesUsed2");
    openapiFields.add("resultItems");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to SessionServicesClassifyextractpagePost200Response
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SessionServicesClassifyextractpagePost200Response.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SessionServicesClassifyextractpagePost200Response is not found in the empty JSON string", SessionServicesClassifyextractpagePost200Response.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SessionServicesClassifyextractpagePost200Response.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SessionServicesClassifyextractpagePost200Response` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `returnStatus`
      if (jsonObj.get("returnStatus") != null && !jsonObj.get("returnStatus").isJsonNull()) {
        ReturnStatusBody.validateJsonElement(jsonObj.get("returnStatus"));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("serviceName") != null && !jsonObj.get("serviceName").isJsonNull()) && !jsonObj.get("serviceName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `serviceName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("serviceName").toString()));
      }
      if ((jsonObj.get("executionMilliSeconds") != null && !jsonObj.get("executionMilliSeconds").isJsonNull()) && !jsonObj.get("executionMilliSeconds").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `executionMilliSeconds` to be a primitive type in the JSON string but got `%s`", jsonObj.get("executionMilliSeconds").toString()));
      }
      if (jsonObj.get("resultItems") != null && !jsonObj.get("resultItems").isJsonNull()) {
        JsonArray jsonArrayresultItems = jsonObj.getAsJsonArray("resultItems");
        if (jsonArrayresultItems != null) {
          // ensure the json data is an array
          if (!jsonObj.get("resultItems").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `resultItems` to be an array in the JSON string but got `%s`", jsonObj.get("resultItems").toString()));
          }

          // validate the optional field `resultItems` (array)
          for (int i = 0; i < jsonArrayresultItems.size(); i++) {
            BasicResultItemWithValues.validateJsonElement(jsonArrayresultItems.get(i));
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SessionServicesClassifyextractpagePost200Response.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SessionServicesClassifyextractpagePost200Response' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SessionServicesClassifyextractpagePost200Response> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SessionServicesClassifyextractpagePost200Response.class));

       return (TypeAdapter<T>) new TypeAdapter<SessionServicesClassifyextractpagePost200Response>() {
           @Override
           public void write(JsonWriter out, SessionServicesClassifyextractpagePost200Response value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SessionServicesClassifyextractpagePost200Response read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SessionServicesClassifyextractpagePost200Response given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SessionServicesClassifyextractpagePost200Response
  * @throws IOException if the JSON string is invalid with respect to SessionServicesClassifyextractpagePost200Response
  */
  public static SessionServicesClassifyextractpagePost200Response fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SessionServicesClassifyextractpagePost200Response.class);
  }

 /**
  * Convert an instance of SessionServicesClassifyextractpagePost200Response to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

