package com.rg.riskguardredactor.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ot2.corecapture.model.Get200Response;
import com.ot2.corecapture.model.SessionFilesPost201Response;
import com.ot2.corecapture.model.SessionServicesFullpageocrPost200Response;
import com.rg.riskguardredactor.controller.model.CoreCaptureSessionFilesPostModel;
import com.rg.riskguardredactor.service.ot2.OT2CoreCaptureService;
import com.rg.riskguardredactor.service.ot2.util.FIleUrlHelperService;

@RestController
@RequestMapping("/corecapture")
public class CoreCaptureController {

	@Autowired
	OT2CoreCaptureService capture;

	@Autowired
	FIleUrlHelperService fileUrlService;

	@GetMapping("/rootGet")
	public ResponseEntity<Get200Response> rootGet() {
		Get200Response versionData = capture.rootGet();
		if (versionData == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(versionData);
	}

	@PostMapping("/sessionFilesPost")
	public ResponseEntity<SessionFilesPost201Response> sessionFilesPost(
			@RequestBody CoreCaptureSessionFilesPostModel requestModel) {
		SessionFilesPost201Response postResponse = capture.sessionFilesPost(requestModel.getContentType(),
				requestModel.getBase64EncodedFileContent());
		if (postResponse == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(postResponse);
	}

	@GetMapping("/sessionServicesFullpageocrPost")
	public ResponseEntity<SessionServicesFullpageocrPost200Response> sessionServicesFullpageocrPost(
			@RequestParam("name") String name, @RequestParam("value") String value,
			@RequestParam("contentType") String contentType) {
		SessionServicesFullpageocrPost200Response versionData = capture.sessionServicesFullpageocrPost(name, value,
				contentType);
		if (versionData == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(versionData);
	}

	@PostMapping("/getOcrDoc")
	public ResponseEntity<byte[]> getOcrDoc(@RequestBody CoreCaptureSessionFilesPostModel requestModel)
			throws IOException {
		SessionFilesPost201Response postResponse = capture.sessionFilesPost(requestModel.getContentType(),
				requestModel.getBase64EncodedFileContent());
		if (postResponse != null) {
			// TODO: Remove this hardcoded value
			String name = "randomFile.pdf";
			String value = postResponse.getId();
			String contentType = postResponse.getContentType();
			SessionServicesFullpageocrPost200Response versionData = capture.sessionServicesFullpageocrPost(name, value,
					contentType);
			if (versionData != null) {
				String urlAsString = versionData.getResultItems().get(0).getFiles().get(0).getSrc();
				File file = fileUrlService.urlToTempFile(urlAsString);
				// TODO: Dynamically find contentType
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
						.body(fileUrlService.fileToByteArray(file));
			}
		}
		return ResponseEntity.internalServerError().body(null);
	}

}
