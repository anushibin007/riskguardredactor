package com.rg.riskguardredactor.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ot2.contentstorageservice.model.Content;
import com.rg.riskguardredactor.service.ot2.OT2ContentStorageService;
import com.rg.riskguardredactor.service.ot2.util.FIleUrlHelperService;

@RestController
@RequestMapping("/contentstorage")
public class ContentStorageController {

	@Autowired
	OT2ContentStorageService storage;

	@Autowired
	FIleUrlHelperService fileUrlService;

	@GetMapping("/getContent")
	public ResponseEntity<Content> getContent(@RequestParam("id") String id) {
		Content content = storage.getContent(id);
		if (content == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(content);
	}

	@PostMapping("/uploadContent")
	public ResponseEntity<Content> uploadContent(@RequestParam("file") MultipartFile multipartFile)
			throws IllegalStateException, IOException {
		File file = fileUrlService.multiPartToFile(multipartFile);
		Content content = storage.myUploadContentImplementation(file);
		if (content == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(content);
	}

}
