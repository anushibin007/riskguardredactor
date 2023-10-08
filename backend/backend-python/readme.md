# If testing using postman, follow the below steps.

1. Set the request method to POST.
1. Set the Request URL to your Flask endpoint (e.g., http://localhost:5000/redact).
1. Add the necessary headers: `Content-Type: multipart/form-data.`
1. Switch to the "Body" tab in Postman.
Select the "form-data" option.
1. Add key-value pair as Key: pdf, Value: ``<Select a PDF file>``
1. Add another key-value pair as Key: keywords, Value: ``<Enter comma-separated keywords>``
1. Send the Request by clicking on the "Send" button.

# If testing via React based fron-end, follow the below steps.
1. Make sure you have axios installed as npm dependency.
1. The below code expects that you are having a form declared, which can take a file as input and comma seperated keywords and having a onclick event handler calling the below method.

`Disclaimer`: The below attached script is purely for demo purpose and may not work exactly, so feel free to use this as base and build on your own.
```javascript
    try {
      const response = await axios.post('http://localhost:5000/redact', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
        responseType: 'blob', // Setting the response type to blob
      });

      // Create a new blob of type pdf from the response data
      const blob = new Blob([response.data], { type: 'application/pdf' });

      // You can use the above blob and can create a url and can use as download link
      const url = window.URL.createObjectURL(blob);

    } catch (error) {
      console.error('Error redacting PDF:', error);
    }
```
