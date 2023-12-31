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
import java.io.IOException;
import java.net.URI;
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

import com.ot2.corecapture.invoker.JSON;

/**
 * Provides an href to the Batches resource. This resource allows you access to create and export a batch.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-14T00:05:58.836985800+05:30[Asia/Calcutta]")
public class Get200ResponseLinksUrnEimLinkrelDataBatches {
  public static final String SERIALIZED_NAME_HREF = "href";
  @SerializedName(SERIALIZED_NAME_HREF)
  private URI href;

  public Get200ResponseLinksUrnEimLinkrelDataBatches() {
  }

  public Get200ResponseLinksUrnEimLinkrelDataBatches href(URI href) {
    
    this.href = href;
    return this;
  }

   /**
   * Get href
   * @return href
  **/
  @javax.annotation.Nullable
  public URI getHref() {
    return href;
  }


  public void setHref(URI href) {
    this.href = href;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Get200ResponseLinksUrnEimLinkrelDataBatches get200ResponseLinksUrnEimLinkrelDataBatches = (Get200ResponseLinksUrnEimLinkrelDataBatches) o;
    return Objects.equals(this.href, get200ResponseLinksUrnEimLinkrelDataBatches.href);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Get200ResponseLinksUrnEimLinkrelDataBatches {\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
    openapiFields.add("href");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Get200ResponseLinksUrnEimLinkrelDataBatches
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Get200ResponseLinksUrnEimLinkrelDataBatches.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Get200ResponseLinksUrnEimLinkrelDataBatches is not found in the empty JSON string", Get200ResponseLinksUrnEimLinkrelDataBatches.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Get200ResponseLinksUrnEimLinkrelDataBatches.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Get200ResponseLinksUrnEimLinkrelDataBatches` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("href") != null && !jsonObj.get("href").isJsonNull()) && !jsonObj.get("href").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `href` to be a primitive type in the JSON string but got `%s`", jsonObj.get("href").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Get200ResponseLinksUrnEimLinkrelDataBatches.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Get200ResponseLinksUrnEimLinkrelDataBatches' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Get200ResponseLinksUrnEimLinkrelDataBatches> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Get200ResponseLinksUrnEimLinkrelDataBatches.class));

       return (TypeAdapter<T>) new TypeAdapter<Get200ResponseLinksUrnEimLinkrelDataBatches>() {
           @Override
           public void write(JsonWriter out, Get200ResponseLinksUrnEimLinkrelDataBatches value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Get200ResponseLinksUrnEimLinkrelDataBatches read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Get200ResponseLinksUrnEimLinkrelDataBatches given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Get200ResponseLinksUrnEimLinkrelDataBatches
  * @throws IOException if the JSON string is invalid with respect to Get200ResponseLinksUrnEimLinkrelDataBatches
  */
  public static Get200ResponseLinksUrnEimLinkrelDataBatches fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Get200ResponseLinksUrnEimLinkrelDataBatches.class);
  }

 /**
  * Convert an instance of Get200ResponseLinksUrnEimLinkrelDataBatches to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

