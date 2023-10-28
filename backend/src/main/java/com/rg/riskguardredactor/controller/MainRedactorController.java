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

		// Record performance
		long startTime = 0;
		long endTime = 0;

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

		startTime = System.currentTimeMillis();
		SessionFilesPost201Response postResponse = capture.sessionFilesPost(contentType, base64EncodedFile);
		endTime = System.currentTimeMillis();
		log.debug("Core Capture upload took: {}s", ((endTime - startTime) / 1000));

		if (postResponse == null) {
			return buildErrorResponse("Sorry, we couldn't push the file to the OT2 Capture Service");
		}

		// 1.2 Invoke OCR processing
		String name = file.getName();
		String id = postResponse.getId();
		if (id == null) {
			return buildErrorResponse("Sorry, the response from the OT2 Capture Service did not have an ID");
		}

		startTime = System.currentTimeMillis();
		SessionServicesFullpageocrPost200Response versionData = capture.sessionServicesFullpageocrPost(name, id,
				contentType);
		endTime = System.currentTimeMillis();
		log.debug("OCR processing took: {}s", ((endTime - startTime) / 1000));

		if (versionData == null) {
			return buildErrorResponse("Sorry, OT2 OCR processing failed");
		}
		String urlAsString = null;
		try {
			urlAsString = versionData.getResultItems().get(0).getFiles().get(0).getSrc();
		} catch (NullPointerException npe) {
			// ignore them here. If something goes wrong, we will take care in the next
			// lines
			log.error("NPE when trying to get url from OCR service : {}", npe.getMessage());
		}
		if (urlAsString == null) {
			return buildErrorResponse("Sorry, we couldn't obtain an URL for the OCR file");
		}
		File ocrFile = fileUrlService.urlToTempFile(urlAsString);
		if (ocrFile == null) {
			return buildErrorResponse("Sorry, we couldn't work with the generated OCR file");
		}

		// 2. Send the file to RiskGuard
		startTime = System.currentTimeMillis();
		List<String> riskyDataAsStringArray = riskGuard.processAndGetResults(ocrFile);
		endTime = System.currentTimeMillis();
		log.debug("RiskGuard processing took: {}s", ((endTime - startTime) / 1000));

		if (riskyDataAsStringArray == null) {
			return buildErrorResponse("Sorry, OT2 RiskGuard processing failed");
		}

		// 3. Send the OCR-d file with RiskGuard data to Python Redactor
		String riskyData = String.join(",", riskyDataAsStringArray);
		Map<String, String> formData = new HashMap<>();
		formData.put("keywords", riskyData);

		startTime = System.currentTimeMillis();
		String jsonResponseFromPython = fileUrlService.postRequestWithFileInBody(redactServerUrl, formData, ocrFile);
		endTime = System.currentTimeMillis();
		log.debug("Redaction took: {}s", ((endTime - startTime) / 1000));

		if (jsonResponseFromPython == null) {
			return buildErrorResponse("Sorry, the Python redactor gave a null response");
		}
		PythonRedactResponseModel pythonRedactResponseModel = fileUrlService
				.parseJsonToPythonRedactResponseModel(jsonResponseFromPython);

		MainRedactionResponseModel response = new MainRedactionResponseModel();
		response.setRedactedDocUrl(contentStorage.constructDownloadURL(pythonRedactResponseModel.getId()));
		return ResponseEntity.ok(response);

	}

	private ResponseEntity<MainRedactionResponseModel> buildErrorResponse(String errorMessage) {
		return ResponseEntity.internalServerError()
				.body(MainRedactionResponseModel.buildFromErrorMessage(errorMessage));
	}

}
