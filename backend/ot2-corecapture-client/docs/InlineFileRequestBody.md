

# InlineFileRequestBody


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**data** | **String** | The file data must be sent as a base64 encoded string. |  [optional] |
|**contentType** | [**ContentTypeEnum**](#ContentTypeEnum) | Optional. The acceptable Content-Type for the file. If not provided, then application/octet-stream will be assumed. |  [optional] |
|**offset** | **Integer** | Optional. Only used for chunking. The offset has to be counted in bytes and is used to add or retry a chunk. Chunks must be added without gaps. |  [optional] |



## Enum: ContentTypeEnum

| Name | Value |
|---- | -----|
| IMAGE_TIFF | &quot;image/tiff&quot; |
| APPLICATION_MSWORD | &quot;application/msword&quot; |
| APPLICATION_OCTET_STREAM | &quot;application/octet-stream&quot; |
| APPLICATION_RTF | &quot;application/rtf&quot; |
| APPLICATION_PDF | &quot;application/pdf&quot; |
| IMAGE_JPEG | &quot;image/jpeg&quot; |
| IMAGE_PNG | &quot;image/png&quot; |
| TEXT_PLAIN | &quot;text/plain&quot; |



