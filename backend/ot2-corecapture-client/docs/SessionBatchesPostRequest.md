

# SessionBatchesPostRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**env** | **Env** |  |  |
|**captureFlow** | **String** | CaptureFlow name. Required only of exportType is \&quot;IAServer\&quot; |  [optional] |
|**batchName** | **String** | Required string. Batch name (schema available). Has to be unique. |  |
|**batchRootLevel** | **Integer** | Required Integer. 0 based, must be between 1 and 7. |  |
|**batchPriority** | **Integer** | Batch priority. It must be between 0 and 100. If not supplied, it will default to 50. This is only used when exporting to an Intelligent Capture Server |  [optional] |
|**exportType** | [**ExportTypeEnum**](#ExportTypeEnum) | One of \&quot;AutoFormatLocal\&quot;, \&quot;AutoFormatFtp\&quot;, \&quot;Custom\&quot;, \&quot;IAServer\&quot;. Default value is \&quot;AutoFormatLocal\&quot;. |  [optional] |
|**pdfGeneration** | [**PdfGenerationEnum**](#PdfGenerationEnum) | One of \&quot;None\&quot;, \&quot;OnePerDocument\&quot;, \&quot;OnePerFolder\&quot;. Default is \&quot;None\&quot;. |  [optional] |
|**ftpConnection** | **String** | Required only if exportType is \&quot;AutoFormatFtp\&quot;. |  [optional] |
|**autoFormatExcludeImages** | **Boolean** | Required if exportType is \&quot;AutoFormatLocal\&quot; or \&quot;AutoFormatFtp\&quot;. |  [optional] |
|**iAServerConnection** | **String** | Required only if exportType is \&quot;IAServer\&quot;. |  [optional] |
|**machineId** | **String** | Id of machine creating this batch. |  [optional] |
|**dispatch** | [**DispatchEnum**](#DispatchEnum) | One \&quot;S\&quot; or \&quot;A\&quot;, Default is \&quot;S\&quot;. S – Synchronous, A - Asynchronous |  [optional] |
|**nodes** | [**List&lt;SessionBatchesPostRequestNodesInner&gt;**](SessionBatchesPostRequestNodesInner.md) | Required. Nodes are processed in given order. |  |
|**values** | [**List&lt;SessionBatchesPostRequestValuesInner&gt;**](SessionBatchesPostRequestValuesInner.md) | Values are processed in the given order and the last writer wins. |  [optional] |



## Enum: ExportTypeEnum

| Name | Value |
|---- | -----|
| AUTOFORMATLOCAL | &quot;AutoFormatLocal&quot; |
| AUTOFORMATFTP | &quot;AutoFormatFtp&quot; |
| CUSTOM | &quot;Custom&quot; |
| IASERVER | &quot;IAServer&quot; |



## Enum: PdfGenerationEnum

| Name | Value |
|---- | -----|
| NONE | &quot;None&quot; |
| ONEPERDOCUMENT | &quot;OnePerDocument&quot; |
| ONEPERFOLDER | &quot;OnePerFolder&quot; |



## Enum: DispatchEnum

| Name | Value |
|---- | -----|
| S | &quot;S&quot; |
| A | &quot;A&quot; |



