package com.rg.riskguardredactor.service.ot2.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

@Service
public class FIleUrlHelperService {

	public File urlToTempFile(URL sourceUrl) throws IOException {
		return urlToTempFile(sourceUrl, null);
	}

	public File urlToTempFile(URL sourceUrl, String suffix) throws IOException {
		File destinationFile = getRandomTempFile(null);
		FileUtils.copyURLToFile(sourceUrl, destinationFile);
		return destinationFile;
	}

	public File getRandomTempFile(String suffix) {
		return new File(getRandomTempFileName(suffix));
	}

	public String getRandomTempFileName(String suffix) {
		String tempDir = System.getProperty("java.io.tmpdir");
		long randomNumber = getRandomNumber();
		String finalSuffix = "-" + (suffix == null ? "file.pdf" : suffix);
		return tempDir + "/" + randomNumber + finalSuffix;
	}

	public byte[] fileToByteArray(File file) throws IOException {
		return FileUtils.readFileToByteArray(file);
	}

	private long getRandomNumber() {
		return System.currentTimeMillis();
	}
}
