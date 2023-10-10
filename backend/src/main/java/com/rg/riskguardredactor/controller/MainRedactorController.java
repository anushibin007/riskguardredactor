package com.rg.riskguardredactor.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ot2.corecapture.model.SessionFilesPost201Response;
import com.ot2.corecapture.model.SessionServicesFullpageocrPost200Response;
import com.rg.riskguardredactor.service.ot2.OT2CoreCaptureService;
import com.rg.riskguardredactor.service.ot2.OT2RiskGuardService;
import com.rg.riskguardredactor.service.ot2.util.FIleUrlHelperService;

@RestController
@RequestMapping("/riskguardredactor")
public class MainRedactorController {

	@Autowired
	OT2CoreCaptureService capture;

	@Autowired
	OT2RiskGuardService riskGuard;

	@Autowired
	FIleUrlHelperService fileUrlService;

	@PostMapping("/redact")
	@ResponseBody
	public ResponseEntity<byte[]> redact(@RequestParam("file") MultipartFile multipartFile)
			throws IllegalStateException, IOException {
		File file = fileUrlService.multiPartToFile(multipartFile);
		// 1. Send the file for OCR
		// TODO: Remove hard-coded application type
		String contentType = "application/pdf";
		String base64EncodedFile = fileUrlService.encodeFileToBase64(file);
		SessionFilesPost201Response postResponse = capture.sessionFilesPost(contentType, base64EncodedFile);
		if (postResponse != null) {
			// TODO: Remove this hardcoded value
			String name = file.getName();
			String value = postResponse.getId();
			SessionServicesFullpageocrPost200Response versionData = capture.sessionServicesFullpageocrPost(name, value,
					contentType);
			File ocrFile = null;
			if (versionData != null) {
				String urlAsString = versionData.getResultItems().get(0).getFiles().get(0).getSrc();
				ocrFile = fileUrlService.urlToTempFile(urlAsString);
			}
			// 2. Send the file to RiskGuard
			List<String> processedContentResponse = riskGuard.processAndGetResults(file);
			String riskyData = String.join(",", processedContentResponse);

			// 3. Send the OCR-d file with RiskGuard data to Python Redactor
			if (ocrFile != null) {
				String redactServerUrl = "http://localhost:5000/redact";
				Map<String, String> formData = new HashMap<>();
				formData.put("keywords", riskyData);
				File redactedFile = fileUrlService.postRequestWithFileInBody(redactServerUrl, formData, ocrFile);

				// 4. Send redacted file to user
				if (redactedFile != null) {
					return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
							.body(fileUrlService.fileToByteArray(redactedFile));
				}
			}
		}
		return ResponseEntity.internalServerError().build();
	}

}