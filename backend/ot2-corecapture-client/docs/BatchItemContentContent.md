

# BatchItemContentContent

JSON object representing the content for this entry.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Batch handle ID only for the current session. |  [optional] |
|**batchName** | **String** | Not localized. Name of batch given by the creator. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | C - Batch created. Caller may add values. P - Pending Dispatch. No more changes may be made. S - Batch was sent to the server successfully. E - Final attempt failed. Batch will not be sent anymore |  [optional] |
|**serverBatchId** | **String** | ID created in InputAccel server. Empty if not sent to InputAccel server. |  [optional] |
|**captureFlow** | **String** | Name of the InputAccel CaptureFlow associated with the batch |  [optional] |
|**batchRootLevel** | **Integer** | Batch root level |  [optional] |
|**batchPriority** | **Integer** | batch priority between 1 and 100. default 50. |  [optional] |
|**lastUpdate** | **OffsetDateTime** | ISO 8601 date-time string of the last update. |  [optional] |
|**lastError** | **String** | Last error message. |  [optional] |
|**localExportFileId** | **String** | Local export (download to local machine) zip file Url. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| C | &quot;C&quot; |
| P | &quot;P&quot; |
| S | &quot;S&quot; |
| E | &quot;E&quot; |



