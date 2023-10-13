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
import com.ot2.corecapture.model.LinkHref;
import com.ot2.corecapture.model.SessionGet200ResponseLinksUrnEimLinkrelLogoff;
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
 * SessionGet200ResponseLinks
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-13T23:29:40.322735800+05:30[Asia/Calcutta]")
public class SessionGet200ResponseLinks {
  public static final String SERIALIZED_NAME_SELF = "self";
  @SerializedName(SERIALIZED_NAME_SELF)
  private LinkHref self;

  public static final String SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_LOGOFF = "urn:eim:linkrel:logoff";
  @SerializedName(SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_LOGOFF)
  private SessionGet200ResponseLinksUrnEimLinkrelLogoff urnColonEimColonLinkrelColonLogoff;

  public SessionGet200ResponseLinks() {
  }

  public SessionGet200ResponseLinks self(LinkHref self) {
    
    this.self = self;
    return this;
  }

   /**
   * Get self
   * @return self
  **/
  @javax.annotation.Nullable
  public LinkHref getSelf() {
    return self;
  }


  public void setSelf(LinkHref self) {
    this.self = self;
  }


  public SessionGet200ResponseLinks urnColonEimColonLinkrelColonLogoff(SessionGet200ResponseLinksUrnEimLinkrelLogoff urnColonEimColonLinkrelColonLogoff) {
    
    this.urnColonEimColonLinkrelColonLogoff = urnColonEimColonLinkrelColonLogoff;
    return this;
  }

   /**
   * Get urnColonEimColonLinkrelColonLogoff
   * @return urnColonEimColonLinkrelColonLogoff
  **/
  @javax.annotation.Nullable
  public SessionGet200ResponseLinksUrnEimLinkrelLogoff getUrnColonEimColonLinkrelColonLogoff() {
    return urnColonEimColonLinkrelColonLogoff;
  }


  public void setUrnColonEimColonLinkrelColonLogoff(SessionGet200ResponseLinksUrnEimLinkrelLogoff urnColonEimColonLinkrelColonLogoff) {
    this.urnColonEimColonLinkrelColonLogoff = urnColonEimColonLinkrelColonLogoff;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionGet200ResponseLinks sessionGet200ResponseLinks = (SessionGet200ResponseLinks) o;
    return Objects.equals(this.self, sessionGet200ResponseLinks.self) &&
        Objects.equals(this.urnColonEimColonLinkrelColonLogoff, sessionGet200ResponseLinks.urnColonEimColonLinkrelColonLogoff);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, urnColonEimColonLinkrelColonLogoff);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionGet200ResponseLinks {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    urnColonEimColonLinkrelColonLogoff: ").append(toIndentedString(urnColonEimColonLinkrelColonLogoff)).append("\n");
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
    openapiFields.add("self");
    openapiFields.add("urn:eim:linkrel:logoff");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to SessionGet200ResponseLinks
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SessionGet200ResponseLinks.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SessionGet200ResponseLinks is not found in the empty JSON string", SessionGet200ResponseLinks.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SessionGet200ResponseLinks.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SessionGet200ResponseLinks` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `self`
      if (jsonObj.get("self") != null && !jsonObj.get("self").isJsonNull()) {
        LinkHref.validateJsonElement(jsonObj.get("self"));
      }
      // validate the optional field `urn:eim:linkrel:logoff`
      if (jsonObj.get("urn:eim:linkrel:logoff") != null && !jsonObj.get("urn:eim:linkrel:logoff").isJsonNull()) {
        SessionGet200ResponseLinksUrnEimLinkrelLogoff.validateJsonElement(jsonObj.get("urn:eim:linkrel:logoff"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SessionGet200ResponseLinks.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SessionGet200ResponseLinks' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SessionGet200ResponseLinks> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SessionGet200ResponseLinks.class));

       return (TypeAdapter<T>) new TypeAdapter<SessionGet200ResponseLinks>() {
           @Override
           public void write(JsonWriter out, SessionGet200ResponseLinks value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SessionGet200ResponseLinks read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SessionGet200ResponseLinks given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SessionGet200ResponseLinks
  * @throws IOException if the JSON string is invalid with respect to SessionGet200ResponseLinks
  */
  public static SessionGet200ResponseLinks fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SessionGet200ResponseLinks.class);
  }

 /**
  * Convert an instance of SessionGet200ResponseLinks to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

