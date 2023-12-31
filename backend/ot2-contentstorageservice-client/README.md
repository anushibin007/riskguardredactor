# ot2-contentstorageservice-client

Content Storage Service API
- API version: 1.0.0
  - Build date: 2023-10-14T01:23:49.967737400+05:30[Asia/Calcutta]

Content Storage Service provides storage and indexing for content and documents, which includes encryption/decryption of the content, anti-virus and authorization checks on upload and download. It is used by Content Metadata Service (CMS) when storing document objects, CMS will provide authorization management.

# Authentication

<!-- ReDoc-Inject: <security-definitions> -->


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.ot2.riskguard</groupId>
  <artifactId>ot2-contentstorageservice-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'ot2-contentstorageservice-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'ot2-contentstorageservice-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "com.ot2.riskguard:ot2-contentstorageservice-client:1.0.0"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/ot2-contentstorageservice-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.*;
import com.ot2.contentstorageservice.invoker.models.*;
import com.ot2.contentstorageservice.api.ContentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
    
    // Configure HTTP bearer authorization: css.na-1-dev.api.opentext.com
    HttpBearerAuth css.na-1-dev.api.opentext.com = (HttpBearerAuth) defaultClient.getAuthentication("css.na-1-dev.api.opentext.com");
    css.na-1-dev.api.opentext.com.setBearerToken("BEARER TOKEN");

    ContentApi apiInstance = new ContentApi(defaultClient);
    String id = "id_example"; // String | ID of the content
    String objectId = "objectId_example"; // String | The ID of the object attached with the content
    String fileName = "fileName_example"; // String | The name of the file in response
    String mimeType = "mimeType_example"; // String | The mime type of the content. This has higher priority than the Accept header
    String dispositionType = "dispositionType_example"; // String | Content disposition of the downloaded content
    Boolean avsScan = true; // Boolean | Flag indicating whether or not to perform a virus scan. Reserved for trusted clients, set false to skip avs (default is true)
    try {
      File result = apiInstance.downloadcontent(id, objectId, fileName, mimeType, dispositionType, avsScan);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#downloadcontent");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://css.na-1-dev.api.opentext.com*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ContentApi* | [**downloadcontent**](docs/ContentApi.md#downloadcontent) | **GET** /v2/content/{id}/download | Download content
*ContentApi* | [**getContent**](docs/ContentApi.md#getContent) | **GET** /v2/content/{id} | Get content metadata for the content
*ContentApi* | [**uploadContent**](docs/ContentApi.md#uploadContent) | **POST** /v2/content | Tenant user upload content
*ContentApi* | [**uploadContentTenant**](docs/ContentApi.md#uploadContentTenant) | **POST** /v2/tenant/{tenantId}/content | Upload content for a tenant
*ContentApi* | [**uploadContentURL**](docs/ContentApi.md#uploadContentURL) | **POST** /v2/upload/{id}/content | Upload content with upload URL
*ContentUsageApi* | [**usageContentTenant**](docs/ContentUsageApi.md#usageContentTenant) | **GET** /v2/tenant/{tenantId}/usage | Get total storage used by a tenant
*SharableLinksApi* | [**createSharableLink**](docs/SharableLinksApi.md#createSharableLink) | **POST** /v2/content/{id}/publicShareUrl | Create a new sharable-link for download
*SharableLinksApi* | [**deleteSharableLink**](docs/SharableLinksApi.md#deleteSharableLink) | **DELETE** /v2/content/{id}/publicShareUrl/{urlId} | Delete a sharable link
*SharableLinksApi* | [**getSharableLink**](docs/SharableLinksApi.md#getSharableLink) | **GET** /v2/content/{id}/publicShareUrl/{urlId} | Retrieve sharable link object
*SharableLinksApi* | [**updateSharableLink**](docs/SharableLinksApi.md#updateSharableLink) | **PUT** /v2/content/{id}/publicShareUrl/{urlId} | Update a sharable link


## Documentation for Models

 - [Content](docs/Content.md)
 - [ContentLinks](docs/ContentLinks.md)
 - [Entry](docs/Entry.md)
 - [Error](docs/Error.md)
 - [HttpProblem](docs/HttpProblem.md)
 - [Link](docs/Link.md)
 - [NewLinkRequest](docs/NewLinkRequest.md)
 - [NewLinkResponse](docs/NewLinkResponse.md)
 - [Rendition](docs/Rendition.md)
 - [SharableLinks](docs/SharableLinks.md)
 - [TenantUsageResponse](docs/TenantUsageResponse.md)
 - [UpdateLinkRequest](docs/UpdateLinkRequest.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="tenant"></a>
### tenant


<a id="css.na-1-dev.api.opentext.com"></a>
### css.na-1-dev.api.opentext.com

- **Type**: HTTP Bearer Token authentication (jwt)


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



