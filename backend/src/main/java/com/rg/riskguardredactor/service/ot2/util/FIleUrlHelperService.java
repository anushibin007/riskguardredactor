package com.rg.riskguardredactor.service.ot2.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rg.riskguardredactor.controller.model.PythonRedactResponseModel;
import com.rg.riskguardredactor.service.ot2.OT2AuthService;
import com.rg.riskguardredactor.util.JSONTools;

@Service
public class FIleUrlHelperService {

	private static Logger log = LoggerFactory.getLogger(FIleUrlHelperService.class);

	@Autowired
	OT2AuthService authService;

	public File urlToTempFile(String sourceUrl) throws IOException {
		URL sourceUrlAsUrl = new URL(sourceUrl);
		return urlToTempFile(sourceUrlAsUrl);
	}

	public File urlToTempFile(URL sourceUrl) throws IOException {
		return urlToTempFile(sourceUrl, null);
	}

	public File urlToTempFile(String sourceUrl, String suffix) throws IOException {
		URL sourceUrlAsUrl = new URL(sourceUrl);
		return urlToTempFile(sourceUrlAsUrl, suffix);
	}

	public File urlToTempFile(URL sourceUrl, String suffix) throws IOException {

		// Authenticate
		URLConnection urlConnection = sourceUrl.openConnection();
		urlConnection.setRequestProperty("Authorization", "Bearer " + authService.getBearerToken());

		// Stage a temp file
		File destinationFile = getRandomTempFile(suffix);

		// Download
		FileUtils.copyToFile(urlConnection.getInputStream(), destinationFile);
		return destinationFile;
	}

	public File getRandomTempFile(String suffix) {
		return new File(getRandomTempFileName(suffix));
	}

	public String getRandomTempFileName(String suffix) {
		String tempDir = System.getProperty("java.io.tmpdir");
		long randomNumber = getRandomNumber();
		suffix = "-" + (suffix == null ? "file.pdf" : suffix);
		return tempDir + "/" + randomNumber + suffix;
	}

	public byte[] fileToByteArray(File file) throws IOException {
		return FileUtils.readFileToByteArray(file);
	}

	public File multiPartToFile(MultipartFile multipartFile) throws IllegalStateException, IOException {

		String fileName = multipartFile.getOriginalFilename();
		File tempFile = getRandomTempFile(fileName);
		multipartFile.transferTo(tempFile);

		return tempFile;
	}

	public String encodeFileToBase64(File file) throws IOException {
		byte[] fileContent = Files.readAllBytes(file.toPath());
		return Base64.getEncoder().encodeToString(fileContent);
	}

	public String postRequestWithFileInBody(String url, Map<String, String> formData, File fileToUpload) {
		// TODO: This was copied from ChatGPT. Check all stuff like error handling, etc
		// and make it work better
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		// Create a MultipartEntityBuilder to build the multipart/form-data request
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();

		if (formData != null) {
			// Add text fields
			for (Entry<String, String> entry : formData.entrySet()) {
				builder.addTextBody(entry.getKey(), entry.getValue(), ContentType.TEXT_PLAIN);
			}
		}

		// Add file
		builder.addBinaryBody("file", fileToUpload, ContentType.APPLICATION_OCTET_STREAM, fileToUpload.getName());
		log.debug("Attached file with size {}", fileToUpload.length());

		// Set the multipart entity as the request entity
		HttpEntity multipartEntity = builder.build();
		httpPost.setEntity(multipartEntity);
		httpPost.addHeader("Authorization", "Bearer " + authService.getBearerToken());

		HttpEntity responseEntity = null;
		try {
			HttpResponse response = httpClient.execute(httpPost);
			responseEntity = response.getEntity();

			// Check the response status code
			int statusCode = response.getStatusLine().getStatusCode();
			InputStream content = responseEntity.getContent();
			String jsonResponse = EntityUtils.toString(responseEntity, "UTF-8");
			log.debug("jsonResponse for URL [{}] = {}", url, jsonResponse);
			if (statusCode >= 200 && statusCode <= 299) {
				// Successfully received the content
				return jsonResponse;
			} else {
				log.error("Request to [{}] failed with status code: {}", url, statusCode);
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Ensure the response entity is fully consumed to release resources
				if (responseEntity != null) {
					EntityUtils.consume(responseEntity);
				}
			} catch (IOException e) {
				// ignore cleanup exceptions
			}
		}
		return null;
	}

	public PythonRedactResponseModel parseJsonToPythonRedactResponseModel(String jsonResponse)
			throws JsonMappingException, JsonProcessingException {
		if (jsonResponse == null) {
			throw new NullPointerException("jsonResponse was null");
		}
		// Parse the JSON response
		ObjectMapper objectMapper = JSONTools.getObjectMapper();
		PythonRedactResponseModel responseObj = objectMapper.readValue(jsonResponse, PythonRedactResponseModel.class);
		return responseObj;
	}

	private long getRandomNumber() {
		return System.currentTimeMillis();
	}
}
