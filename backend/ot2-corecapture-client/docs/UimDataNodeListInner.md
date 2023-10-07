

# UimDataNodeListInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the field |  [optional] |
|**isArray** | **Boolean** | True if this is an array field; otherwise, false. |  [optional] |
|**indexFieldType** | [**IndexFieldTypeEnum**](#IndexFieldTypeEnum) | Specifies the type of field. Will be one of \&quot;number\&quot;, \&quot;string\&quot;, \&quot;boolean\&quot;, \&quot;datetime\&quot;. |  [optional] |
|**labelText** | **String** | The label for the field to show in the UI. |  [optional] |
|**isRequired** | **Boolean** | True if this is a required field; otherwise, false. |  [optional] |
|**controlType** | [**ControlTypeEnum**](#ControlTypeEnum) | This will be the type of UI control. Will be one of \&quot;TextBox\&quot;, \&quot;ChoiceText\&quot;, \&quot;ListBox\&quot;, \&quot;CheckBox\&quot;, \&quot;ComboBox\&quot;. |  [optional] |
|**data** | [**List&lt;UimDataNodeListInnerDataInner&gt;**](UimDataNodeListInnerDataInner.md) | Contains all the data for the field(s). |  [optional] |



## Enum: IndexFieldTypeEnum

| Name | Value |
|---- | -----|
| NUMBER | &quot;number&quot; |
| STRING | &quot;string&quot; |
| BOOLEAN | &quot;boolean&quot; |
| DATETIME | &quot;datetime&quot; |



## Enum: ControlTypeEnum

| Name | Value |
|---- | -----|
| TEXTBOX | &quot;TextBox&quot; |
| CHOICETEXT | &quot;ChoiceText&quot; |
| LISTBOX | &quot;ListBox&quot; |
| CHECKBOX | &quot;CheckBox&quot; |
| COMBOBOX | &quot;ComboBox&quot; |



