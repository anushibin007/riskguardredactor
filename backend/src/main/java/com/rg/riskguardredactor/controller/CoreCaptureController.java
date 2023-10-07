package com.rg.riskguardredactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot2.corecapture.Get200Response;
import com.rg.riskguardredactor.service.ot2.OT2CoreCaptureService;

@RestController
@RequestMapping("/corecapture")
public class CoreCaptureController {

	@Autowired
	OT2CoreCaptureService capture;

	@GetMapping("/version")
	public ResponseEntity<Get200Response> getVersion() {
		Get200Response versionData = capture.version();
		if (versionData == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(versionData);
	}

}
