package com.rg.riskguardredactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot2.riskguard.ContentResponse;
import com.ot2.riskguard.ProductVersion;
import com.rg.riskguardredactor.service.ot2.OT2RiskGuardService;

@RestController
@RequestMapping("/riskguard")
public class RiskGuardController {

	@Autowired
	OT2RiskGuardService riskGuard;

	@GetMapping("/version")
	public ResponseEntity<ProductVersion> getVersion() {
		ProductVersion versionData = riskGuard.getVersion();
		if (versionData == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(versionData);
	}

	@GetMapping("/processContent")
	public ResponseEntity<ContentResponse> processContent() {
		ContentResponse processedContentResponse = riskGuard.process();
		if (processedContentResponse == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(processedContentResponse);
	}

}
