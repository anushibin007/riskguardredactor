package com.rg.riskguardredactor.service.ot2.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rg.riskguardredactor.service.ot2.OT2AuthService;

@Service
public class FIleUrlHelperService {

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

	private long getRandomNumber() {
		return System.currentTimeMillis();
	}
}
