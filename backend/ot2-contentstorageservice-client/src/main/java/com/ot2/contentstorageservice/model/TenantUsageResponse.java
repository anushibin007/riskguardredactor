/*
 * Content Storage Service API
 * Content Storage Service provides storage and indexing for content and documents, which includes encryption/decryption of the content, anti-virus and authorization checks on upload and download. It is used by Content Metadata Service (CMS) when storing document objects, CMS will provide authorization management.  # Authentication  <!-- ReDoc-Inject: <security-definitions> -->
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.ot2.contentstorageservice.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Arrays;

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

import com.ot2.contentstorageservice.invoker.JSON;

/**
 * TenantUsageResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-13T23:29:43.283869900+05:30[Asia/Calcutta]")
public class TenantUsageResponse {
  public static final String SERIALIZED_NAME_TENANT_ID = "tenantId";
  @SerializedName(SERIALIZED_NAME_TENANT_ID)
  private String tenantId;

  public static final String SERIALIZED_NAME_TENANT_USAGE_SIZE = "tenantUsageSize";
  @SerializedName(SERIALIZED_NAME_TENANT_USAGE_SIZE)
  private Double tenantUsageSize;

  public static final String SERIALIZED_NAME_TENANT_USAGE_UNITS = "tenantUsageUnits";
  @SerializedName(SERIALIZED_NAME_TENANT_USAGE_UNITS)
  private String tenantUsageUnits;

  public static final String SERIALIZED_NAME_DATE_OF_LAST_UPLOAD = "dateOfLastUpload";
  @SerializedName(SERIALIZED_NAME_DATE_OF_LAST_UPLOAD)
  private OffsetDateTime dateOfLastUpload;

  public static final String SERIALIZED_NAME_CREATED_BY = "createdBy";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;

  public static final String SERIALIZED_NAME_CREATED_DATE = "createdDate";
  @SerializedName(SERIALIZED_NAME_CREATED_DATE)
  private OffsetDateTime createdDate;

  public static final String SERIALIZED_NAME_MODIFIED_BY = "modifiedBy";
  @SerializedName(SERIALIZED_NAME_MODIFIED_BY)
  private String modifiedBy;

  public static final String SERIALIZED_NAME_MODIFIED_DATE = "modifiedDate";
  @SerializedName(SERIALIZED_NAME_MODIFIED_DATE)
  private OffsetDateTime modifiedDate;

  public TenantUsageResponse() {
  }

  public TenantUsageResponse tenantId(String tenantId) {
    
    this.tenantId = tenantId;
    return this;
  }

   /**
   * Get tenantId
   * @return tenantId
  **/
  @javax.annotation.Nullable
  public String getTenantId() {
    return tenantId;
  }


  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }


  public TenantUsageResponse tenantUsageSize(Double tenantUsageSize) {
    
    this.tenantUsageSize = tenantUsageSize;
    return this;
  }

   /**
   * Get tenantUsageSize
   * @return tenantUsageSize
  **/
  @javax.annotation.Nullable
  public Double getTenantUsageSize() {
    return tenantUsageSize;
  }


  public void setTenantUsageSize(Double tenantUsageSize) {
    this.tenantUsageSize = tenantUsageSize;
  }


  public TenantUsageResponse tenantUsageUnits(String tenantUsageUnits) {
    
    this.tenantUsageUnits = tenantUsageUnits;
    return this;
  }

   /**
   * Get tenantUsageUnits
   * @return tenantUsageUnits
  **/
  @javax.annotation.Nullable
  public String getTenantUsageUnits() {
    return tenantUsageUnits;
  }


  public void setTenantUsageUnits(String tenantUsageUnits) {
    this.tenantUsageUnits = tenantUsageUnits;
  }


  public TenantUsageResponse dateOfLastUpload(OffsetDateTime dateOfLastUpload) {
    
    this.dateOfLastUpload = dateOfLastUpload;
    return this;
  }

   /**
   * Get dateOfLastUpload
   * @return dateOfLastUpload
  **/
  @javax.annotation.Nullable
  public OffsetDateTime getDateOfLastUpload() {
    return dateOfLastUpload;
  }


  public void setDateOfLastUpload(OffsetDateTime dateOfLastUpload) {
    this.dateOfLastUpload = dateOfLastUpload;
  }


  public TenantUsageResponse createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Get createdBy
   * @return createdBy
  **/
  @javax.annotation.Nullable
  public String getCreatedBy() {
    return createdBy;
  }


  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public TenantUsageResponse createdDate(OffsetDateTime createdDate) {
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * Get createdDate
   * @return createdDate
  **/
  @javax.annotation.Nullable
  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }


  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }


  public TenantUsageResponse modifiedBy(String modifiedBy) {
    
    this.modifiedBy = modifiedBy;
    return this;
  }

   /**
   * Get modifiedBy
   * @return modifiedBy
  **/
  @javax.annotation.Nullable
  public String getModifiedBy() {
    return modifiedBy;
  }


  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }


  public TenantUsageResponse modifiedDate(OffsetDateTime modifiedDate) {
    
    this.modifiedDate = modifiedDate;
    return this;
  }

   /**
   * Get modifiedDate
   * @return modifiedDate
  **/
  @javax.annotation.Nullable
  public OffsetDateTime getModifiedDate() {
    return modifiedDate;
  }


  public void setModifiedDate(OffsetDateTime modifiedDate) {
    this.modifiedDate = modifiedDate;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantUsageResponse tenantUsageResponse = (TenantUsageResponse) o;
    return Objects.equals(this.tenantId, tenantUsageResponse.tenantId) &&
        Objects.equals(this.tenantUsageSize, tenantUsageResponse.tenantUsageSize) &&
        Objects.equals(this.tenantUsageUnits, tenantUsageResponse.tenantUsageUnits) &&
        Objects.equals(this.dateOfLastUpload, tenantUsageResponse.dateOfLastUpload) &&
        Objects.equals(this.createdBy, tenantUsageResponse.createdBy) &&
        Objects.equals(this.createdDate, tenantUsageResponse.createdDate) &&
        Objects.equals(this.modifiedBy, tenantUsageResponse.modifiedBy) &&
        Objects.equals(this.modifiedDate, tenantUsageResponse.modifiedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, tenantUsageSize, tenantUsageUnits, dateOfLastUpload, createdBy, createdDate, modifiedBy, modifiedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantUsageResponse {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    tenantUsageSize: ").append(toIndentedString(tenantUsageSize)).append("\n");
    sb.append("    tenantUsageUnits: ").append(toIndentedString(tenantUsageUnits)).append("\n");
    sb.append("    dateOfLastUpload: ").append(toIndentedString(dateOfLastUpload)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
    sb.append("    modifiedDate: ").append(toIndentedString(modifiedDate)).append("\n");
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
    openapiFields.add("tenantId");
    openapiFields.add("tenantUsageSize");
    openapiFields.add("tenantUsageUnits");
    openapiFields.add("dateOfLastUpload");
    openapiFields.add("createdBy");
    openapiFields.add("createdDate");
    openapiFields.add("modifiedBy");
    openapiFields.add("modifiedDate");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to TenantUsageResponse
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TenantUsageResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TenantUsageResponse is not found in the empty JSON string", TenantUsageResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TenantUsageResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TenantUsageResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("tenantId") != null && !jsonObj.get("tenantId").isJsonNull()) && !jsonObj.get("tenantId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tenantId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tenantId").toString()));
      }
      if ((jsonObj.get("tenantUsageUnits") != null && !jsonObj.get("tenantUsageUnits").isJsonNull()) && !jsonObj.get("tenantUsageUnits").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tenantUsageUnits` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tenantUsageUnits").toString()));
      }
      if ((jsonObj.get("createdBy") != null && !jsonObj.get("createdBy").isJsonNull()) && !jsonObj.get("createdBy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `createdBy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("createdBy").toString()));
      }
      if ((jsonObj.get("modifiedBy") != null && !jsonObj.get("modifiedBy").isJsonNull()) && !jsonObj.get("modifiedBy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `modifiedBy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("modifiedBy").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TenantUsageResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TenantUsageResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TenantUsageResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TenantUsageResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<TenantUsageResponse>() {
           @Override
           public void write(JsonWriter out, TenantUsageResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TenantUsageResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TenantUsageResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TenantUsageResponse
  * @throws IOException if the JSON string is invalid with respect to TenantUsageResponse
  */
  public static TenantUsageResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TenantUsageResponse.class);
  }

 /**
  * Convert an instance of TenantUsageResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

