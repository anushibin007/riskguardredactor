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
import com.ot2.corecapture.model.Get200ResponseLinksAbout;
import com.ot2.corecapture.model.Get200ResponseLinksOauth2Authorize;
import com.ot2.corecapture.model.Get200ResponseLinksOauth2Token;
import com.ot2.corecapture.model.Get200ResponseLinksUrnEimLinkrelDataBatches;
import com.ot2.corecapture.model.Get200ResponseLinksUrnEimLinkrelDoctypes;
import com.ot2.corecapture.model.Get200ResponseLinksUrnEimLinkrelFiles;
import com.ot2.corecapture.model.Get200ResponseLinksUrnEimLinkrelServices;
import com.ot2.corecapture.model.Get200ResponseLinksUrnEimLinkrelSession;
import com.ot2.corecapture.model.Get200ResponseLinksUrnEimLinkrelTables;
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
 * Get200ResponseLinks
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-13T23:29:40.322735800+05:30[Asia/Calcutta]")
public class Get200ResponseLinks {
  public static final String SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_SESSION = "urn:eim:linkrel:session";
  @SerializedName(SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_SESSION)
  private Get200ResponseLinksUrnEimLinkrelSession urnColonEimColonLinkrelColonSession;

  public static final String SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_TABLES = "urn:eim:linkrel:tables";
  @SerializedName(SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_TABLES)
  private Get200ResponseLinksUrnEimLinkrelTables urnColonEimColonLinkrelColonTables;

  public static final String SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_DATA_BATCHES = "urn:eim:linkrel:data-batches";
  @SerializedName(SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_DATA_BATCHES)
  private Get200ResponseLinksUrnEimLinkrelDataBatches urnColonEimColonLinkrelColonDataBatches;

  public static final String SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_FILES = "urn:eim:linkrel:files";
  @SerializedName(SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_FILES)
  private Get200ResponseLinksUrnEimLinkrelFiles urnColonEimColonLinkrelColonFiles;

  public static final String SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_SERVICES = "urn:eim:linkrel:services";
  @SerializedName(SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_SERVICES)
  private Get200ResponseLinksUrnEimLinkrelServices urnColonEimColonLinkrelColonServices;

  public static final String SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_DOCTYPES = "urn:eim:linkrel:doctypes";
  @SerializedName(SERIALIZED_NAME_URN_COLON_EIM_COLON_LINKREL_COLON_DOCTYPES)
  private Get200ResponseLinksUrnEimLinkrelDoctypes urnColonEimColonLinkrelColonDoctypes;

  public static final String SERIALIZED_NAME_ABOUT = "about";
  @SerializedName(SERIALIZED_NAME_ABOUT)
  private Get200ResponseLinksAbout about;

  public static final String SERIALIZED_NAME_OAUTH2_TOKEN = "oauth2-token";
  @SerializedName(SERIALIZED_NAME_OAUTH2_TOKEN)
  private Get200ResponseLinksOauth2Token oauth2Token;

  public static final String SERIALIZED_NAME_OAUTH2_AUTHORIZE = "oauth2-authorize";
  @SerializedName(SERIALIZED_NAME_OAUTH2_AUTHORIZE)
  private Get200ResponseLinksOauth2Authorize oauth2Authorize;

  public Get200ResponseLinks() {
  }

  public Get200ResponseLinks urnColonEimColonLinkrelColonSession(Get200ResponseLinksUrnEimLinkrelSession urnColonEimColonLinkrelColonSession) {
    
    this.urnColonEimColonLinkrelColonSession = urnColonEimColonLinkrelColonSession;
    return this;
  }

   /**
   * Get urnColonEimColonLinkrelColonSession
   * @return urnColonEimColonLinkrelColonSession
  **/
  @javax.annotation.Nullable
  public Get200ResponseLinksUrnEimLinkrelSession getUrnColonEimColonLinkrelColonSession() {
    return urnColonEimColonLinkrelColonSession;
  }


  public void setUrnColonEimColonLinkrelColonSession(Get200ResponseLinksUrnEimLinkrelSession urnColonEimColonLinkrelColonSession) {
    this.urnColonEimColonLinkrelColonSession = urnColonEimColonLinkrelColonSession;
  }


  public Get200ResponseLinks urnColonEimColonLinkrelColonTables(Get200ResponseLinksUrnEimLinkrelTables urnColonEimColonLinkrelColonTables) {
    
    this.urnColonEimColonLinkrelColonTables = urnColonEimColonLinkrelColonTables;
    return this;
  }

   /**
   * Get urnColonEimColonLinkrelColonTables
   * @return urnColonEimColonLinkrelColonTables
  **/
  @javax.annotation.Nullable
  public Get200ResponseLinksUrnEimLinkrelTables getUrnColonEimColonLinkrelColonTables() {
    return urnColonEimColonLinkrelColonTables;
  }


  public void setUrnColonEimColonLinkrelColonTables(Get200ResponseLinksUrnEimLinkrelTables urnColonEimColonLinkrelColonTables) {
    this.urnColonEimColonLinkrelColonTables = urnColonEimColonLinkrelColonTables;
  }


  public Get200ResponseLinks urnColonEimColonLinkrelColonDataBatches(Get200ResponseLinksUrnEimLinkrelDataBatches urnColonEimColonLinkrelColonDataBatches) {
    
    this.urnColonEimColonLinkrelColonDataBatches = urnColonEimColonLinkrelColonDataBatches;
    return this;
  }

   /**
   * Get urnColonEimColonLinkrelColonDataBatches
   * @return urnColonEimColonLinkrelColonDataBatches
  **/
  @javax.annotation.Nullable
  public Get200ResponseLinksUrnEimLinkrelDataBatches getUrnColonEimColonLinkrelColonDataBatches() {
    return urnColonEimColonLinkrelColonDataBatches;
  }


  public void setUrnColonEimColonLinkrelColonDataBatches(Get200ResponseLinksUrnEimLinkrelDataBatches urnColonEimColonLinkrelColonDataBatches) {
    this.urnColonEimColonLinkrelColonDataBatches = urnColonEimColonLinkrelColonDataBatches;
  }


  public Get200ResponseLinks urnColonEimColonLinkrelColonFiles(Get200ResponseLinksUrnEimLinkrelFiles urnColonEimColonLinkrelColonFiles) {
    
    this.urnColonEimColonLinkrelColonFiles = urnColonEimColonLinkrelColonFiles;
    return this;
  }

   /**
   * Get urnColonEimColonLinkrelColonFiles
   * @return urnColonEimColonLinkrelColonFiles
  **/
  @javax.annotation.Nullable
  public Get200ResponseLinksUrnEimLinkrelFiles getUrnColonEimColonLinkrelColonFiles() {
    return urnColonEimColonLinkrelColonFiles;
  }


  public void setUrnColonEimColonLinkrelColonFiles(Get200ResponseLinksUrnEimLinkrelFiles urnColonEimColonLinkrelColonFiles) {
    this.urnColonEimColonLinkrelColonFiles = urnColonEimColonLinkrelColonFiles;
  }


  public Get200ResponseLinks urnColonEimColonLinkrelColonServices(Get200ResponseLinksUrnEimLinkrelServices urnColonEimColonLinkrelColonServices) {
    
    this.urnColonEimColonLinkrelColonServices = urnColonEimColonLinkrelColonServices;
    return this;
  }

   /**
   * Get urnColonEimColonLinkrelColonServices
   * @return urnColonEimColonLinkrelColonServices
  **/
  @javax.annotation.Nullable
  public Get200ResponseLinksUrnEimLinkrelServices getUrnColonEimColonLinkrelColonServices() {
    return urnColonEimColonLinkrelColonServices;
  }


  public void setUrnColonEimColonLinkrelColonServices(Get200ResponseLinksUrnEimLinkrelServices urnColonEimColonLinkrelColonServices) {
    this.urnColonEimColonLinkrelColonServices = urnColonEimColonLinkrelColonServices;
  }


  public Get200ResponseLinks urnColonEimColonLinkrelColonDoctypes(Get200ResponseLinksUrnEimLinkrelDoctypes urnColonEimColonLinkrelColonDoctypes) {
    
    this.urnColonEimColonLinkrelColonDoctypes = urnColonEimColonLinkrelColonDoctypes;
    return this;
  }

   /**
   * Get urnColonEimColonLinkrelColonDoctypes
   * @return urnColonEimColonLinkrelColonDoctypes
  **/
  @javax.annotation.Nullable
  public Get200ResponseLinksUrnEimLinkrelDoctypes getUrnColonEimColonLinkrelColonDoctypes() {
    return urnColonEimColonLinkrelColonDoctypes;
  }


  public void setUrnColonEimColonLinkrelColonDoctypes(Get200ResponseLinksUrnEimLinkrelDoctypes urnColonEimColonLinkrelColonDoctypes) {
    this.urnColonEimColonLinkrelColonDoctypes = urnColonEimColonLinkrelColonDoctypes;
  }


  public Get200ResponseLinks about(Get200ResponseLinksAbout about) {
    
    this.about = about;
    return this;
  }

   /**
   * Get about
   * @return about
  **/
  @javax.annotation.Nullable
  public Get200ResponseLinksAbout getAbout() {
    return about;
  }


  public void setAbout(Get200ResponseLinksAbout about) {
    this.about = about;
  }


  public Get200ResponseLinks oauth2Token(Get200ResponseLinksOauth2Token oauth2Token) {
    
    this.oauth2Token = oauth2Token;
    return this;
  }

   /**
   * Get oauth2Token
   * @return oauth2Token
  **/
  @javax.annotation.Nullable
  public Get200ResponseLinksOauth2Token getOauth2Token() {
    return oauth2Token;
  }


  public void setOauth2Token(Get200ResponseLinksOauth2Token oauth2Token) {
    this.oauth2Token = oauth2Token;
  }


  public Get200ResponseLinks oauth2Authorize(Get200ResponseLinksOauth2Authorize oauth2Authorize) {
    
    this.oauth2Authorize = oauth2Authorize;
    return this;
  }

   /**
   * Get oauth2Authorize
   * @return oauth2Authorize
  **/
  @javax.annotation.Nullable
  public Get200ResponseLinksOauth2Authorize getOauth2Authorize() {
    return oauth2Authorize;
  }


  public void setOauth2Authorize(Get200ResponseLinksOauth2Authorize oauth2Authorize) {
    this.oauth2Authorize = oauth2Authorize;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Get200ResponseLinks get200ResponseLinks = (Get200ResponseLinks) o;
    return Objects.equals(this.urnColonEimColonLinkrelColonSession, get200ResponseLinks.urnColonEimColonLinkrelColonSession) &&
        Objects.equals(this.urnColonEimColonLinkrelColonTables, get200ResponseLinks.urnColonEimColonLinkrelColonTables) &&
        Objects.equals(this.urnColonEimColonLinkrelColonDataBatches, get200ResponseLinks.urnColonEimColonLinkrelColonDataBatches) &&
        Objects.equals(this.urnColonEimColonLinkrelColonFiles, get200ResponseLinks.urnColonEimColonLinkrelColonFiles) &&
        Objects.equals(this.urnColonEimColonLinkrelColonServices, get200ResponseLinks.urnColonEimColonLinkrelColonServices) &&
        Objects.equals(this.urnColonEimColonLinkrelColonDoctypes, get200ResponseLinks.urnColonEimColonLinkrelColonDoctypes) &&
        Objects.equals(this.about, get200ResponseLinks.about) &&
        Objects.equals(this.oauth2Token, get200ResponseLinks.oauth2Token) &&
        Objects.equals(this.oauth2Authorize, get200ResponseLinks.oauth2Authorize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urnColonEimColonLinkrelColonSession, urnColonEimColonLinkrelColonTables, urnColonEimColonLinkrelColonDataBatches, urnColonEimColonLinkrelColonFiles, urnColonEimColonLinkrelColonServices, urnColonEimColonLinkrelColonDoctypes, about, oauth2Token, oauth2Authorize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Get200ResponseLinks {\n");
    sb.append("    urnColonEimColonLinkrelColonSession: ").append(toIndentedString(urnColonEimColonLinkrelColonSession)).append("\n");
    sb.append("    urnColonEimColonLinkrelColonTables: ").append(toIndentedString(urnColonEimColonLinkrelColonTables)).append("\n");
    sb.append("    urnColonEimColonLinkrelColonDataBatches: ").append(toIndentedString(urnColonEimColonLinkrelColonDataBatches)).append("\n");
    sb.append("    urnColonEimColonLinkrelColonFiles: ").append(toIndentedString(urnColonEimColonLinkrelColonFiles)).append("\n");
    sb.append("    urnColonEimColonLinkrelColonServices: ").append(toIndentedString(urnColonEimColonLinkrelColonServices)).append("\n");
    sb.append("    urnColonEimColonLinkrelColonDoctypes: ").append(toIndentedString(urnColonEimColonLinkrelColonDoctypes)).append("\n");
    sb.append("    about: ").append(toIndentedString(about)).append("\n");
    sb.append("    oauth2Token: ").append(toIndentedString(oauth2Token)).append("\n");
    sb.append("    oauth2Authorize: ").append(toIndentedString(oauth2Authorize)).append("\n");
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
    openapiFields.add("urn:eim:linkrel:session");
    openapiFields.add("urn:eim:linkrel:tables");
    openapiFields.add("urn:eim:linkrel:data-batches");
    openapiFields.add("urn:eim:linkrel:files");
    openapiFields.add("urn:eim:linkrel:services");
    openapiFields.add("urn:eim:linkrel:doctypes");
    openapiFields.add("about");
    openapiFields.add("oauth2-token");
    openapiFields.add("oauth2-authorize");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Get200ResponseLinks
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Get200ResponseLinks.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Get200ResponseLinks is not found in the empty JSON string", Get200ResponseLinks.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Get200ResponseLinks.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Get200ResponseLinks` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `urn:eim:linkrel:session`
      if (jsonObj.get("urn:eim:linkrel:session") != null && !jsonObj.get("urn:eim:linkrel:session").isJsonNull()) {
        Get200ResponseLinksUrnEimLinkrelSession.validateJsonElement(jsonObj.get("urn:eim:linkrel:session"));
      }
      // validate the optional field `urn:eim:linkrel:tables`
      if (jsonObj.get("urn:eim:linkrel:tables") != null && !jsonObj.get("urn:eim:linkrel:tables").isJsonNull()) {
        Get200ResponseLinksUrnEimLinkrelTables.validateJsonElement(jsonObj.get("urn:eim:linkrel:tables"));
      }
      // validate the optional field `urn:eim:linkrel:data-batches`
      if (jsonObj.get("urn:eim:linkrel:data-batches") != null && !jsonObj.get("urn:eim:linkrel:data-batches").isJsonNull()) {
        Get200ResponseLinksUrnEimLinkrelDataBatches.validateJsonElement(jsonObj.get("urn:eim:linkrel:data-batches"));
      }
      // validate the optional field `urn:eim:linkrel:files`
      if (jsonObj.get("urn:eim:linkrel:files") != null && !jsonObj.get("urn:eim:linkrel:files").isJsonNull()) {
        Get200ResponseLinksUrnEimLinkrelFiles.validateJsonElement(jsonObj.get("urn:eim:linkrel:files"));
      }
      // validate the optional field `urn:eim:linkrel:services`
      if (jsonObj.get("urn:eim:linkrel:services") != null && !jsonObj.get("urn:eim:linkrel:services").isJsonNull()) {
        Get200ResponseLinksUrnEimLinkrelServices.validateJsonElement(jsonObj.get("urn:eim:linkrel:services"));
      }
      // validate the optional field `urn:eim:linkrel:doctypes`
      if (jsonObj.get("urn:eim:linkrel:doctypes") != null && !jsonObj.get("urn:eim:linkrel:doctypes").isJsonNull()) {
        Get200ResponseLinksUrnEimLinkrelDoctypes.validateJsonElement(jsonObj.get("urn:eim:linkrel:doctypes"));
      }
      // validate the optional field `about`
      if (jsonObj.get("about") != null && !jsonObj.get("about").isJsonNull()) {
        Get200ResponseLinksAbout.validateJsonElement(jsonObj.get("about"));
      }
      // validate the optional field `oauth2-token`
      if (jsonObj.get("oauth2-token") != null && !jsonObj.get("oauth2-token").isJsonNull()) {
        Get200ResponseLinksOauth2Token.validateJsonElement(jsonObj.get("oauth2-token"));
      }
      // validate the optional field `oauth2-authorize`
      if (jsonObj.get("oauth2-authorize") != null && !jsonObj.get("oauth2-authorize").isJsonNull()) {
        Get200ResponseLinksOauth2Authorize.validateJsonElement(jsonObj.get("oauth2-authorize"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Get200ResponseLinks.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Get200ResponseLinks' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Get200ResponseLinks> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Get200ResponseLinks.class));

       return (TypeAdapter<T>) new TypeAdapter<Get200ResponseLinks>() {
           @Override
           public void write(JsonWriter out, Get200ResponseLinks value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Get200ResponseLinks read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Get200ResponseLinks given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Get200ResponseLinks
  * @throws IOException if the JSON string is invalid with respect to Get200ResponseLinks
  */
  public static Get200ResponseLinks fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Get200ResponseLinks.class);
  }

 /**
  * Convert an instance of Get200ResponseLinks to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

