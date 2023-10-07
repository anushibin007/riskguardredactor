

# DocItemContentContentFieldsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the field |  [optional] |
|**isArray** | **Boolean** | Whether the field is an array field. |  [optional] |
|**indexFieldType** | [**IndexFieldTypeEnum**](#IndexFieldTypeEnum) | Type of field (Number, String, Boolean, DateTime) |  [optional] |
|**sectionName** | **String** | Form section name to which this field belongs. If field is an array type, then this is the table name. |  [optional] |
|**indexLevel** | **Integer** | Used only in the context of hierarchical collection of documents. The level must be between 1 and 7. If the level is higher than 1, then it is assumed that any changes must propagate to all siblings in the context of ancestor at that higher level. |  [optional] |
|**confirmKind** | [**ConfirmKindEnum**](#ConfirmKindEnum) | Confirmation kind. One of NeverConfirm, AlwaysConfirm, ConfirmOnEmpty. |  [optional] |
|**isReadOnly** | **Boolean** | Is the field read only? |  [optional] |
|**isRequried** | **Boolean** | Is this a required field? |  [optional] |
|**minValue** | **String** | Minimum value for the field. If null, no lower bound. In case of datetime, value is represented as double .NET OADate. In case of strings, min length. |  [optional] |
|**maxValue** | **String** | Maximum value for the field. If null, no upper bound. In case of datetime, value is represented as double .NET OADate. In case of strings, max length. |  [optional] |
|**restrictionMask** | **String** | The Restriction mask pattern for validating strings. Empty means no pattern check. This is a regex expression equivalent to restriction mask pattern. |  [optional] |
|**viewFormat** | **String** | Holds the format string for date and time fields. The format string utilizes Microsoft .NET Framework 4.5.2 custom date and time format specifiers. Standard format strings are not supported. Example \&quot;dd-MM-yyyy hh:mm:ss tt\&quot; should be rendered by the client as, \&quot;27-10-2009 10:47:50 AM\&quot;. |  [optional] |
|**checkDateFromNow** | **Boolean** | If true and the datatype for the field is DateTime and range check is enabled through Min, Max values, the Min and Max values are interpreted as time span and are validated with reference to Now(). If false and the datatype is DateTime then Min and Max are interpreted as absolute date time values. |  [optional] |
|**uiControlInfo** | [**DocItemContentContentFieldsInnerUiControlInfo**](DocItemContentContentFieldsInnerUiControlInfo.md) |  |  [optional] |
|**isPopulationTrigger** | **Boolean** | If true, specifies that this field is a dependent field for one or more population rules in the Document Type definition. This will be false for only one-time rules. |  [optional] |
|**optionsPopulatedBy** | **List&lt;String&gt;** | This is an array of string field names that when any of the fields specified changes, then it should cause the valid options for this field to change. This is not applicable for only one-time rules. |  [optional] |
|**extractFirstValue** | **Boolean** | If true, then document level extractions will use values from the first page where a non-empty value is found; otherwise, it will use the field from the last page where a non-empty value is found. |  [optional] |
|**isCalculationTarget** | **Boolean** | If true, specifies that this field is a data calculation target field. This will be false for only one-time rules. |  [optional] |
|**sampleRect** | **String** | Field Sample rectangle indicating field position in an image. A comma separated list of double values for left, top, width and height. All values are in units of 1/96 inch |  [optional] |
|**samplePageId** | **String** | Field sample page id. |  [optional] |



## Enum: IndexFieldTypeEnum

| Name | Value |
|---- | -----|
| NUMBER | &quot;Number&quot; |
| STRING | &quot;String&quot; |
| BOOLEAN | &quot;Boolean&quot; |
| DATETIME | &quot;DateTime&quot; |



## Enum: ConfirmKindEnum

| Name | Value |
|---- | -----|
| NEVERCONFIRM | &quot;NeverConfirm&quot; |
| ALWAYSCONFIRM | &quot;AlwaysConfirm&quot; |
| CONFIRMONEMPTY | &quot;ConfirmOnEmpty&quot; |



