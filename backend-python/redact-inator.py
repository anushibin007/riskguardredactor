from flask import Flask, request, send_file
from flask_cors import CORS
import fitz
import io

app = Flask(__name__)
# Enable CORS. Without this, we may see CORS releated errors. 
# No taime to figure out why
CORS(app)


# Strictly POST request
@app.route('/redact', methods=['POST'])
def redact_keywords():
    # Check if we received the pdf in the request. Else we are not going to do anything.
    # Give it back that they didn't provide the PDF File.
    if 'pdf' not in request.files:
        return "No PDF file provided", 400

    # Get the given PDF file and keywords from the request.
    # We need to give the binary as pdf and keywords as space seperated words
    pdf_file = request.files['pdf']
    keywords = request.form['keywords'].split(',')

    # Let's trim the leading and tailing whitespace from keywords and remove empty ones, if any.
    keywords = [keyword.strip() for keyword in keywords if keyword.strip()]

    # Check if we have keywords in the request, if not give 400.
    if not keywords:
        return "No valid keywords provided", 400

    # Read the PDF content from the file, not saving anymore
    pdf_content = pdf_file.read()

    # Create a PDF document object, we'll be working directly on this object
    pdf_document = fitz.open('pdf', pdf_content)

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
                page.apply_redactions()

    # Save the work. Redacted PDF will be saved as bytes
    pdf_bytes = pdf_document.write()

    # No need of the pdf_document object, so let's close it.
    pdf_document.close()

    # Return the new PDF in the response response
    return send_file(io.BytesIO(pdf_bytes), as_attachment=True, download_name='redacted.pdf', mimetype='application/pdf')

if __name__ == '__main__':
    app.run(host="0.0.0.0", debug=True)
