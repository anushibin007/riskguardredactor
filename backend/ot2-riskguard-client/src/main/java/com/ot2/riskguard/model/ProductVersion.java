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


package com.ot2.riskguard.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
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

import com.ot2.riskguard.invoker.JSON;

/**
 * ProductVersion
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-14T00:05:56.640873400+05:30[Asia/Calcutta]")
public class ProductVersion {
  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private String version;

  public static final String SERIALIZED_NAME_MAJOR = "major";
  @SerializedName(SERIALIZED_NAME_MAJOR)
  private Integer major;

  public static final String SERIALIZED_NAME_MINOR = "minor";
  @SerializedName(SERIALIZED_NAME_MINOR)
  private Integer minor;

  public static final String SERIALIZED_NAME_PATCH = "patch";
  @SerializedName(SERIALIZED_NAME_PATCH)
  private Integer patch;

  public static final String SERIALIZED_NAME_PRE_RELEASE = "preRelease";
  @SerializedName(SERIALIZED_NAME_PRE_RELEASE)
  private String preRelease;

  public static final String SERIALIZED_NAME_BUILD = "build";
  @SerializedName(SERIALIZED_NAME_BUILD)
  private String build;

  public ProductVersion() {
  }

  public ProductVersion version(String version) {
    
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @javax.annotation.Nullable
  public String getVersion() {
    return version;
  }


  public void setVersion(String version) {
    this.version = version;
  }


  public ProductVersion major(Integer major) {
    
    this.major = major;
    return this;
  }

   /**
   * Get major
   * @return major
  **/
  @javax.annotation.Nullable
  public Integer getMajor() {
    return major;
  }


  public void setMajor(Integer major) {
    this.major = major;
  }


  public ProductVersion minor(Integer minor) {
    
    this.minor = minor;
    return this;
  }

   /**
   * Get minor
   * @return minor
  **/
  @javax.annotation.Nullable
  public Integer getMinor() {
    return minor;
  }


  public void setMinor(Integer minor) {
    this.minor = minor;
  }


  public ProductVersion patch(Integer patch) {
    
    this.patch = patch;
    return this;
  }

   /**
   * Get patch
   * @return patch
  **/
  @javax.annotation.Nullable
  public Integer getPatch() {
    return patch;
  }


  public void setPatch(Integer patch) {
    this.patch = patch;
  }


  public ProductVersion preRelease(String preRelease) {
    
    this.preRelease = preRelease;
    return this;
  }

   /**
   * Get preRelease
   * @return preRelease
  **/
  @javax.annotation.Nullable
  public String getPreRelease() {
    return preRelease;
  }


  public void setPreRelease(String preRelease) {
    this.preRelease = preRelease;
  }


  public ProductVersion build(String build) {
    
    this.build = build;
    return this;
  }

   /**
   * Get build
   * @return build
  **/
  @javax.annotation.Nullable
  public String getBuild() {
    return build;
  }


  public void setBuild(String build) {
    this.build = build;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductVersion productVersion = (ProductVersion) o;
    return Objects.equals(this.version, productVersion.version) &&
        Objects.equals(this.major, productVersion.major) &&
        Objects.equals(this.minor, productVersion.minor) &&
        Objects.equals(this.patch, productVersion.patch) &&
        Objects.equals(this.preRelease, productVersion.preRelease) &&
        Objects.equals(this.build, productVersion.build);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, major, minor, patch, preRelease, build);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductVersion {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    major: ").append(toIndentedString(major)).append("\n");
    sb.append("    minor: ").append(toIndentedString(minor)).append("\n");
    sb.append("    patch: ").append(toIndentedString(patch)).append("\n");
    sb.append("    preRelease: ").append(toIndentedString(preRelease)).append("\n");
    sb.append("    build: ").append(toIndentedString(build)).append("\n");
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
    openapiFields.add("version");
    openapiFields.add("major");
    openapiFields.add("minor");
    openapiFields.add("patch");
    openapiFields.add("preRelease");
    openapiFields.add("build");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ProductVersion
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ProductVersion.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProductVersion is not found in the empty JSON string", ProductVersion.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ProductVersion.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ProductVersion` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("version") != null && !jsonObj.get("version").isJsonNull()) && !jsonObj.get("version").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `version` to be a primitive type in the JSON string but got `%s`", jsonObj.get("version").toString()));
      }
      if ((jsonObj.get("preRelease") != null && !jsonObj.get("preRelease").isJsonNull()) && !jsonObj.get("preRelease").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `preRelease` to be a primitive type in the JSON string but got `%s`", jsonObj.get("preRelease").toString()));
      }
      if ((jsonObj.get("build") != null && !jsonObj.get("build").isJsonNull()) && !jsonObj.get("build").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `build` to be a primitive type in the JSON string but got `%s`", jsonObj.get("build").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ProductVersion.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProductVersion' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProductVersion> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProductVersion.class));

       return (TypeAdapter<T>) new TypeAdapter<ProductVersion>() {
           @Override
           public void write(JsonWriter out, ProductVersion value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ProductVersion read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ProductVersion given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ProductVersion
  * @throws IOException if the JSON string is invalid with respect to ProductVersion
  */
  public static ProductVersion fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProductVersion.class);
  }

 /**
  * Convert an instance of ProductVersion to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

