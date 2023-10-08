package com.rg.riskguardredactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot2.corecapture.model.Get200Response;
import com.ot2.corecapture.model.SessionFilesPost201Response;
import com.rg.riskguardredactor.controller.model.CoreCaptureSessionFilesPostModel;
import com.rg.riskguardredactor.service.ot2.OT2CoreCaptureService;

@RestController
@RequestMapping("/corecapture")
public class CoreCaptureController {

	@Autowired
	OT2CoreCaptureService capture;

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

}
