from flask import Flask, request, send_file, jsonify
from flask_cors import CORS
import fitz
import io
import requests
import time

app = Flask(__name__)
# Enable CORS. Without this, we may see CORS releated errors. 
# No taime to figure out why
CORS(app)

ot2_css_spring_boot_end_point = 'https://riskguardredactor-backend-springboot-adxywvifka-el.a.run.app/contentstorage/uploadContent'


# Strictly POST request
@app.route('/redact', methods=['POST'])
def redact_keywords():
    # Check if we received the file in the request. Else we are not going to do anything.
    # Give it back that they didn't provide the PDF File.
    if 'file' not in request.files:
        return "No PDF file provided", 400

    # Get the given PDF file and keywords from the request.
    # We need to give the binary as pdf and keywords as space seperated words
    pdf_file = request.files['file']
    keywords = request.form['keywords'].split(',')

    # Let's trim the leading and tailing whitespace from keywords and remove empty ones, if any.
    keywords = [keyword.strip() for keyword in keywords if keyword.strip()]

    # Check if we have keywords in the request, if not give 400.
    if not keywords:
        return "No valid keywords provided", 400

    # Read the PDF content from the file, not saving anymore
    pdf_content = pdf_file.read()
    
    print("Length of incoming file = ", len(pdf_content))

    # Create a PDF document object, we'll be working directly on this object
    pdf_document = fitz.open('pdf', pdf_content)

    redaction_start_time = int(round(time.time()) * 1000)
    print("Redaction started at : ", redaction_start_time)

    # Iterate through pages and redact keywords
    for page_num in range(pdf_document.page_count):
        page = pdf_document[page_num]
        # On each page we are searching for each keyword
        for keyword in keywords:
            # We get the occurrences of each keyword
            occurrences = page.search_for(keyword)
            # No more wait, let's redact
            for rect in occurrences:
                # Set redaction color to black (yeah black love), if we don't give fill, it will be white by default.
                rc = fitz.Rect(rect)
                page.add_redact_annot(rc, fill=(0, 0, 0))
        page.apply_redactions(images = fitz.PDF_REDACT_IMAGE_NONE)
        page.clean_contents()

    redaction_end_time = int(round(time.time()) * 1000)
    print("Redaction ends at : ", redaction_end_time)

    print("Total time for Redactiont: ", redaction_end_time - redaction_start_time) 

    # Save the work. Redacted PDF will be saved as bytes
    pdf_bytes = pdf_document.write()
    
    print("Redacted PDF size = ", len(pdf_bytes))

    # No need of the pdf_document object anymore, so let's close it.
    pdf_document.close()

    # Prepare the body by adding the file to sending the POST request to Spring Boot backend.
    body = {'file': ('document.pdf', pdf_bytes)}

    css_upload_start_time = int(round(time.time()) * 1000)
    print("CSS Upload started at : ", css_upload_start_time)

    # Let's call the SpringBoot POST end point to upload file to CSS
    response = requests.post(ot2_css_spring_boot_end_point, files = body)

    css_upload_end_time = int(round(time.time()) * 1000)

    print("CSS Upload ends at : ", css_upload_end_time)
    
    print("Total time for CSS request: ", css_upload_end_time - css_upload_start_time) 

    # Return the response only if we get 200 from the End-point
    if response.status_code == 200:
        # Parsing the response toe JSON
        response_data = response.json()
        
        # Extract the id from the response
        id_value = response_data["entries"][0]["id"]
        
        # Just pass the ID in response.
        return jsonify({'id': id_value})
    
    else:
        print("CSS Endpoint didn't return 200. Expecting that the request failed, returning 500")
        return "Failed to upload the redacted PDF to the content storage API", 500

@app.route('/alive', methods=['GET'])
def alive_endpoint():
    return {
            "action": "alive",
            "result": {
                "state": "done",
                "message": "alive"
            },
            "timestamp": time.time()
        }


if __name__ == '__main__':
    app.run(host="0.0.0.0", debug=True)
