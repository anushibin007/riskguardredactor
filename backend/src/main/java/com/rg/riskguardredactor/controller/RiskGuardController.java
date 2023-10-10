package com.rg.riskguardredactor.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ot2.riskguard.model.ContentResponse;
import com.ot2.riskguard.model.ProductVersion;
import com.rg.riskguardredactor.service.ot2.OT2RiskGuardService;
import com.rg.riskguardredactor.service.ot2.util.FIleUrlHelperService;

@RestController
@RequestMapping("/riskguard")
public class RiskGuardController {

	@Autowired
	OT2RiskGuardService riskGuard;

	@Autowired
	FIleUrlHelperService fileUrlService;

	@GetMapping("/version")
	public ResponseEntity<ProductVersion> getVersion() {
		ProductVersion versionData = riskGuard.getVersion();
		if (versionData == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(versionData);
	}

	@PostMapping("/processContent")
	public ResponseEntity<ContentResponse> processContent(@RequestParam("file") MultipartFile multipartFile)
			throws IllegalStateException, IOException {

		File file = fileUrlService.multiPartToFile(multipartFile);
		ContentResponse processedContentResponse = riskGuard.process(file);

		if (processedContentResponse == null) {
			return ResponseEntity.internalServerError().body(null);
		}

		return ResponseEntity.ok(processedContentResponse);
	}

	@PostMapping("/processContentArrayResponse")
	public ResponseEntity<List<String>> processContentArrayResponse(@RequestParam("file") MultipartFile multipartFile)
			throws IllegalStateException, IOException {
		File file = fileUrlService.multiPartToFile(multipartFile);
		List<String> processedContentResponse = riskGuard.processAndGetResults(file);
		if (processedContentResponse == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(processedContentResponse);
	}

}
