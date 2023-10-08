# Use the official Python image as a base image
FROM python:3.8-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the contents of the local backend directory to the container's working directory
COPY requirements.txt redact-inator.py ./

# Install required packages
RUN apt-get update && \
    apt-get install -y --no-install-recommends gcc mupdf mupdf-tools libmupdf-dev && \
    rm -rf /var/lib/apt/lists/*

# Install Python dependencies
RUN pip install --upgrade pip && \
    pip install -r requirements.txt

# Expose the port that the Flask app will run on
EXPOSE 5000

# Command to run the application
CMD ["python", "./redact-inator.py"]
