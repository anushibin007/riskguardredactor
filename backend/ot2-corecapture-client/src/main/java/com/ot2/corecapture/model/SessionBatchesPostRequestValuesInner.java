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
 * SessionBatchesPostRequestValuesInner
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-09T00:42:16.144688700+05:30[Asia/Calcutta]")
public class SessionBatchesPostRequestValuesInner {
  public static final String SERIALIZED_NAME_NODE_ID = "nodeId";
  @SerializedName(SERIALIZED_NAME_NODE_ID)
  private Integer nodeId;

  public static final String SERIALIZED_NAME_VALUE_NAME = "valueName";
  @SerializedName(SERIALIZED_NAME_VALUE_NAME)
  private String valueName;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;

  /**
   * Required string. Must be one of \&quot;int\&quot;, \&quot;double\&quot;, \&quot;string\&quot;, \&quot;bool\&quot;, \&quot;datetime\&quot;, \&quot;file\&quot;, or \&quot;uimdata\&quot;. \&quot;int\&quot; – value can be integer or string. \&quot;double\&quot; - value can be either number or literal invariant culture string. \&quot;bool\&quot; - value must be sent as literal \&quot;true\&quot; or \&quot;false\&quot;. \&quot;datetime\&quot; - value must be ISO 8601 string. \&quot;file\&quot; - value must be sent as a base64 encoded string or a valid fileId. \&quot;uimdata\&quot; – value must be the UimData JSON object.
   */
  @JsonAdapter(ValueTypeEnum.Adapter.class)
  public enum ValueTypeEnum {
    INT("int"),
    
    DOUBLE("double"),
    
    STRING("string"),
    
    BOOL("bool"),
    
    DATETIME("datetime"),
    
    FILE("file"),
    
    UIMDATA("uimdata");

    private String value;

    ValueTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ValueTypeEnum fromValue(String value) {
      for (ValueTypeEnum b : ValueTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ValueTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ValueTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ValueTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ValueTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_VALUE_TYPE = "valueType";
  @SerializedName(SERIALIZED_NAME_VALUE_TYPE)
  private ValueTypeEnum valueType;

  public static final String SERIALIZED_NAME_OFFSET = "offset";
  @SerializedName(SERIALIZED_NAME_OFFSET)
  private Integer offset;

  public static final String SERIALIZED_NAME_FILE_EXTENSION = "fileExtension";
  @SerializedName(SERIALIZED_NAME_FILE_EXTENSION)
  private String fileExtension;

  public SessionBatchesPostRequestValuesInner() {
  }

  public SessionBatchesPostRequestValuesInner nodeId(Integer nodeId) {
    
    this.nodeId = nodeId;
    return this;
  }

   /**
   * Required integer. The nodeId must exist.
   * @return nodeId
  **/
  @javax.annotation.Nullable
  public Integer getNodeId() {
    return nodeId;
  }


  public void setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
  }


  public SessionBatchesPostRequestValuesInner valueName(String valueName) {
    
    this.valueName = valueName;
    return this;
  }

   /**
   * Required string. The name of the value.
   * @return valueName
  **/
  @javax.annotation.Nullable
  public String getValueName() {
    return valueName;
  }


  public void setValueName(String valueName) {
    this.valueName = valueName;
  }


  public SessionBatchesPostRequestValuesInner value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * Required object. See valueType for valid types.
   * @return value
  **/
  @javax.annotation.Nullable
  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


  public SessionBatchesPostRequestValuesInner valueType(ValueTypeEnum valueType) {
    
    this.valueType = valueType;
    return this;
  }

   /**
   * Required string. Must be one of \&quot;int\&quot;, \&quot;double\&quot;, \&quot;string\&quot;, \&quot;bool\&quot;, \&quot;datetime\&quot;, \&quot;file\&quot;, or \&quot;uimdata\&quot;. \&quot;int\&quot; – value can be integer or string. \&quot;double\&quot; - value can be either number or literal invariant culture string. \&quot;bool\&quot; - value must be sent as literal \&quot;true\&quot; or \&quot;false\&quot;. \&quot;datetime\&quot; - value must be ISO 8601 string. \&quot;file\&quot; - value must be sent as a base64 encoded string or a valid fileId. \&quot;uimdata\&quot; – value must be the UimData JSON object.
   * @return valueType
  **/
  @javax.annotation.Nullable
  public ValueTypeEnum getValueType() {
    return valueType;
  }


  public void setValueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
  }


  public SessionBatchesPostRequestValuesInner offset(Integer offset) {
    
    this.offset = offset;
    return this;
  }

   /**
   * Optional integer. Used only if valueType is \&quot;file\&quot;. Offset is used to add or replace a chunk. Chunks must be added without gaps. First chunk must start at offset 0.
   * @return offset
  **/
  @javax.annotation.Nullable
  public Integer getOffset() {
    return offset;
  }


  public void setOffset(Integer offset) {
    this.offset = offset;
  }


  public SessionBatchesPostRequestValuesInner fileExtension(String fileExtension) {
    
    this.fileExtension = fileExtension;
    return this;
  }

   /**
   * Optional string. Used if valueType&#x3D;\&quot;file\&quot; and offset is 0. Examples \&quot;doc\&quot;, \&quot;png\&quot;, \&quot;tif\&quot;, \&quot;tiff\&quot;, \&quot;jpg\&quot;.
   * @return fileExtension
  **/
  @javax.annotation.Nullable
  public String getFileExtension() {
    return fileExtension;
  }


  public void setFileExtension(String fileExtension) {
    this.fileExtension = fileExtension;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionBatchesPostRequestValuesInner sessionBatchesPostRequestValuesInner = (SessionBatchesPostRequestValuesInner) o;
    return Objects.equals(this.nodeId, sessionBatchesPostRequestValuesInner.nodeId) &&
        Objects.equals(this.valueName, sessionBatchesPostRequestValuesInner.valueName) &&
        Objects.equals(this.value, sessionBatchesPostRequestValuesInner.value) &&
        Objects.equals(this.valueType, sessionBatchesPostRequestValuesInner.valueType) &&
        Objects.equals(this.offset, sessionBatchesPostRequestValuesInner.offset) &&
        Objects.equals(this.fileExtension, sessionBatchesPostRequestValuesInner.fileExtension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeId, valueName, value, valueType, offset, fileExtension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionBatchesPostRequestValuesInner {\n");
    sb.append("    nodeId: ").append(toIndentedString(nodeId)).append("\n");
    sb.append("    valueName: ").append(toIndentedString(valueName)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    fileExtension: ").append(toIndentedString(fileExtension)).append("\n");
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
    openapiFields.add("nodeId");
    openapiFields.add("valueName");
    openapiFields.add("value");
    openapiFields.add("valueType");
    openapiFields.add("offset");
    openapiFields.add("fileExtension");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to SessionBatchesPostRequestValuesInner
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SessionBatchesPostRequestValuesInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SessionBatchesPostRequestValuesInner is not found in the empty JSON string", SessionBatchesPostRequestValuesInner.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SessionBatchesPostRequestValuesInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SessionBatchesPostRequestValuesInner` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("valueName") != null && !jsonObj.get("valueName").isJsonNull()) && !jsonObj.get("valueName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `valueName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("valueName").toString()));
      }
      if ((jsonObj.get("value") != null && !jsonObj.get("value").isJsonNull()) && !jsonObj.get("value").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `value` to be a primitive type in the JSON string but got `%s`", jsonObj.get("value").toString()));
      }
      if ((jsonObj.get("valueType") != null && !jsonObj.get("valueType").isJsonNull()) && !jsonObj.get("valueType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `valueType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("valueType").toString()));
      }
      if ((jsonObj.get("fileExtension") != null && !jsonObj.get("fileExtension").isJsonNull()) && !jsonObj.get("fileExtension").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fileExtension` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fileExtension").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SessionBatchesPostRequestValuesInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SessionBatchesPostRequestValuesInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SessionBatchesPostRequestValuesInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SessionBatchesPostRequestValuesInner.class));

       return (TypeAdapter<T>) new TypeAdapter<SessionBatchesPostRequestValuesInner>() {
           @Override
           public void write(JsonWriter out, SessionBatchesPostRequestValuesInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SessionBatchesPostRequestValuesInner read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SessionBatchesPostRequestValuesInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SessionBatchesPostRequestValuesInner
  * @throws IOException if the JSON string is invalid with respect to SessionBatchesPostRequestValuesInner
  */
  public static SessionBatchesPostRequestValuesInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SessionBatchesPostRequestValuesInner.class);
  }

 /**
  * Convert an instance of SessionBatchesPostRequestValuesInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

