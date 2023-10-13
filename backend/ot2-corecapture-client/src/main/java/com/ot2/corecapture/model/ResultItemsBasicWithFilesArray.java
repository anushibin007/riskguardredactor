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
import com.ot2.corecapture.model.BasicResultItemWithFiles;
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
 * ResultItemsBasicWithFilesArray
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-13T23:29:40.322735800+05:30[Asia/Calcutta]")
public class ResultItemsBasicWithFilesArray {
  public static final String SERIALIZED_NAME_RESULT_ITEMS = "resultItems";
  @SerializedName(SERIALIZED_NAME_RESULT_ITEMS)
  private List<BasicResultItemWithFiles> resultItems;

  public ResultItemsBasicWithFilesArray() {
  }

  public ResultItemsBasicWithFilesArray resultItems(List<BasicResultItemWithFiles> resultItems) {
    
    this.resultItems = resultItems;
    return this;
  }

  public ResultItemsBasicWithFilesArray addResultItemsItem(BasicResultItemWithFiles resultItemsItem) {
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
  public List<BasicResultItemWithFiles> getResultItems() {
    return resultItems;
  }


  public void setResultItems(List<BasicResultItemWithFiles> resultItems) {
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
    ResultItemsBasicWithFilesArray resultItemsBasicWithFilesArray = (ResultItemsBasicWithFilesArray) o;
    return Objects.equals(this.resultItems, resultItemsBasicWithFilesArray.resultItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resultItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultItemsBasicWithFilesArray {\n");
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
    openapiFields.add("resultItems");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ResultItemsBasicWithFilesArray
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ResultItemsBasicWithFilesArray.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ResultItemsBasicWithFilesArray is not found in the empty JSON string", ResultItemsBasicWithFilesArray.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ResultItemsBasicWithFilesArray.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ResultItemsBasicWithFilesArray` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (jsonObj.get("resultItems") != null && !jsonObj.get("resultItems").isJsonNull()) {
        JsonArray jsonArrayresultItems = jsonObj.getAsJsonArray("resultItems");
        if (jsonArrayresultItems != null) {
          // ensure the json data is an array
          if (!jsonObj.get("resultItems").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `resultItems` to be an array in the JSON string but got `%s`", jsonObj.get("resultItems").toString()));
          }

          // validate the optional field `resultItems` (array)
          for (int i = 0; i < jsonArrayresultItems.size(); i++) {
            BasicResultItemWithFiles.validateJsonElement(jsonArrayresultItems.get(i));
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ResultItemsBasicWithFilesArray.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ResultItemsBasicWithFilesArray' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ResultItemsBasicWithFilesArray> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ResultItemsBasicWithFilesArray.class));

       return (TypeAdapter<T>) new TypeAdapter<ResultItemsBasicWithFilesArray>() {
           @Override
           public void write(JsonWriter out, ResultItemsBasicWithFilesArray value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ResultItemsBasicWithFilesArray read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ResultItemsBasicWithFilesArray given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ResultItemsBasicWithFilesArray
  * @throws IOException if the JSON string is invalid with respect to ResultItemsBasicWithFilesArray
  */
  public static ResultItemsBasicWithFilesArray fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ResultItemsBasicWithFilesArray.class);
  }

 /**
  * Convert an instance of ResultItemsBasicWithFilesArray to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

