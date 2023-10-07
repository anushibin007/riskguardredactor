

# SessionBatchesPostRequestValuesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**nodeId** | **Integer** | Required integer. The nodeId must exist. |  [optional] |
|**valueName** | **String** | Required string. The name of the value. |  [optional] |
|**value** | **String** | Required object. See valueType for valid types. |  [optional] |
|**valueType** | [**ValueTypeEnum**](#ValueTypeEnum) | Required string. Must be one of \&quot;int\&quot;, \&quot;double\&quot;, \&quot;string\&quot;, \&quot;bool\&quot;, \&quot;datetime\&quot;, \&quot;file\&quot;, or \&quot;uimdata\&quot;. \&quot;int\&quot; – value can be integer or string. \&quot;double\&quot; - value can be either number or literal invariant culture string. \&quot;bool\&quot; - value must be sent as literal \&quot;true\&quot; or \&quot;false\&quot;. \&quot;datetime\&quot; - value must be ISO 8601 string. \&quot;file\&quot; - value must be sent as a base64 encoded string or a valid fileId. \&quot;uimdata\&quot; – value must be the UimData JSON object. |  [optional] |
|**offset** | **Integer** | Optional integer. Used only if valueType is \&quot;file\&quot;. Offset is used to add or replace a chunk. Chunks must be added without gaps. First chunk must start at offset 0. |  [optional] |
|**fileExtension** | **String** | Optional string. Used if valueType&#x3D;\&quot;file\&quot; and offset is 0. Examples \&quot;doc\&quot;, \&quot;png\&quot;, \&quot;tif\&quot;, \&quot;tiff\&quot;, \&quot;jpg\&quot;. |  [optional] |



## Enum: ValueTypeEnum

| Name | Value |
|---- | -----|
| INT | &quot;int&quot; |
| DOUBLE | &quot;double&quot; |
| STRING | &quot;string&quot; |
| BOOL | &quot;bool&quot; |
| DATETIME | &quot;datetime&quot; |
| FILE | &quot;file&quot; |
| UIMDATA | &quot;uimdata&quot; |



