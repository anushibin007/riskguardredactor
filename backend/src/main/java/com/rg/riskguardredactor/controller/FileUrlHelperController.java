package com.rg.riskguardredactor.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rg.riskguardredactor.service.ot2.util.FIleUrlHelperService;

@RestController
@RequestMapping("/fileurlhelper")
public class FileUrlHelperController {

	@Autowired
	FIleUrlHelperService fileUrlService;

	@GetMapping(value = "/urlToTempFile")
	@ResponseBody
	public ResponseEntity<byte[]> urlToTempFile(@RequestParam("url") String urlAsString,
			@RequestParam("fileName") String fileName) throws IOException {
		URL url = new URL(urlAsString);
		File file = fileUrlService.urlToTempFile(url, fileName);
		// TODO: Dynamically find contentType
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(fileUrlService.fileToByteArray(file));
	}
}
