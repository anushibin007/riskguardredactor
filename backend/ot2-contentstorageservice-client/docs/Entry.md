

# Entry


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Content id in the system |  [optional] |
|**objectId** | **String** | Id of the object in the metadata service that references content |  [optional] |
|**mimeType** | **String** | mime-type of the content declared on upload |  [optional] |
|**fileName** | **String** |  |  [optional] |
|**size** | **Long** |  |  [optional] |
|**createDate** | **OffsetDateTime** |  |  [optional] [readonly] |
|**lastUpdated** | **OffsetDateTime** |  |  [optional] |
|**providerId** | **String** | Id of the metadata service that governs this content |  [optional] |
|**tenantId** | **String** |  |  [optional] |
|**subscriptionId** | **String** |  |  [optional] |
|**blobId** | **String** |  |  [optional] |
|**properties** | **Object** |  |  [optional] |
|**renditions** | [**List&lt;Rendition&gt;**](Rendition.md) | renditions associated with this content |  [optional] |
|**links** | [**ContentLinks**](ContentLinks.md) |  |  [optional] |



