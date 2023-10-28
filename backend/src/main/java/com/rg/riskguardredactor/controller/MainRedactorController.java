package com.rg.riskguardredactor.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.rg.riskguardredactor.controller.model.MainRedactionResponseModel;
import com.rg.riskguardredactor.controller.model.PythonRedactResponseModel;
import com.rg.riskguardredactor.service.ot2.OT2ContentStorageService;
import com.rg.riskguardredactor.service.ot2.OT2CoreCaptureService;
import com.rg.riskguardredactor.service.ot2.OT2RiskGuardService;
import com.rg.riskguardredactor.service.ot2.util.FIleUrlHelperService;
import com.rg.riskguardredactor.util.Constant;

@RestController
@RequestMapping("/riskguardredactor")
public class MainRedactorController extends Constant {

	private static Logger log = LoggerFactory.getLogger(MainRedactorController.class);

	@Autowired
	OT2CoreCaptureService capture;

	@Autowired
	OT2RiskGuardService riskGuard;

	@Autowired
	OT2ContentStorageService contentStorage;

	@Autowired
	FIleUrlHelperService fileUrlService;

	@PostMapping("/redact")
	@ResponseBody
	public ResponseEntity<MainRedactionResponseModel> redact(@RequestParam("file") MultipartFile multipartFile)
			throws IllegalStateException, IOException {
		File file = fileUrlService.multiPartToFile(multipartFile);
		if (file == null) {
			return buildErrorResponse("Sorry, I did not receive a file");
		}
		if (fileUrlService.isFileTooLarge(file)) {
			return buildErrorResponse("Sorry, file should not be larger than " + MAX_INPUT_FILE_SIZE_MB + "MB");
		}
		// 1.1 Send the file to Capture Service
		// TODO: Dynamically find contentType
		String contentType = MediaType.APPLICATION_PDF_VALUE;
		String base64EncodedFile = fileUrlService.encodeFileToBase64(file);
		SessionFilesPost201Response postResponse = capture.sessionFilesPost(contentType, base64EncodedFile);
		if (postResponse != null) {
			String name = file.getName();
			String value = postResponse.getId();
			// 1.2 Invoke OCR processing
			SessionServicesFullpageocrPost200Response versionData = capture.sessionServicesFullpageocrPost(name, value,
					contentType);
			File ocrFile = null;
			if (versionData != null) {
				String urlAsString = versionData.getResultItems().get(0).getFiles().get(0).getSrc();
				ocrFile = fileUrlService.urlToTempFile(urlAsString);
			} else {
				return buildErrorResponse("OT2 OCR Failed");
			}
			// 2. Send the file to RiskGuard
			List<String> processedContentResponse = riskGuard.processAndGetResults(file);
			if (processedContentResponse == null) {
				return buildErrorResponse("OT2 RiskGuard processing failed");
			}
			String riskyData = String.join(",", processedContentResponse);

			// 3. Send the OCR-d file with RiskGuard data to Python Redactor
			if (ocrFile != null) {
				Map<String, String> formData = new HashMap<>();
				formData.put("keywords", riskyData);
				long startTime = System.currentTimeMillis();
				log.debug("Redaction call started at: {}", startTime);
				String jsonResponseFromPython = fileUrlService.postRequestWithFileInBody(redactServerUrl, formData,
						ocrFile);
				long endTime = System.currentTimeMillis();
				log.debug("Redaction call ended at: {}", endTime);
				log.debug("Redaction took: {}ms", ((endTime - startTime) / 1000));
				if (jsonResponseFromPython == null) {
					return buildErrorResponse("Python redactor gave null response");
				}
				PythonRedactResponseModel pythonRedactResponseModel = fileUrlService
						.parseJsonToPythonRedactResponseModel(jsonResponseFromPython);

				MainRedactionResponseModel response = new MainRedactionResponseModel();
				response.setRedactedDocUrl(contentStorage.constructDownloadURL(pythonRedactResponseModel.getId()));
				return ResponseEntity.ok(response);
			} else {
				return buildErrorResponse("Couldn't work with the OCR file");
			}
		} else {
			return buildErrorResponse("Couldn't push file to OT2 Capture Service");
		}
	}

	private ResponseEntity<MainRedactionResponseModel> buildErrorResponse(String errorMessage) {
		return ResponseEntity.internalServerError()
				.body(MainRedactionResponseModel.buildFromErrorMessage(errorMessage));
	}

}
