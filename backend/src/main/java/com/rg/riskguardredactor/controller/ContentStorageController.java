package com.rg.riskguardredactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ot2.contentstorageservice.model.Content;
import com.rg.riskguardredactor.service.ot2.OT2ContentStorageService;

@RestController
@RequestMapping("/contentstorage")
public class ContentStorageController {

	@Autowired
	OT2ContentStorageService storage;

	@GetMapping("/getContent")
	public ResponseEntity<Content> getContent(@RequestParam("id") String id) {
		Content content = storage.getContent(id);
		if (content == null) {
			return ResponseEntity.internalServerError().body(null);
		}
		return ResponseEntity.ok(content);
	}

}
