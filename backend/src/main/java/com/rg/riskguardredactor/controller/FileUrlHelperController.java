package com.rg.riskguardredactor.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rg.riskguardredactor.service.ot2.util.FIleUrlHelperService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/fileurlhelper")
public class FileUrlHelperController {

	@Autowired
	FIleUrlHelperService fileUrlService;

	@GetMapping(value = "/riskguard-redactor-output", produces = MediaType.APPLICATION_PDF_VALUE)
	@ResponseBody
	public ResponseEntity<byte[]> urlToTempFile(@RequestParam("url") String urlAsString,
			@RequestParam(value = "fileName", required = false) String fileName, HttpServletResponse response)
			throws IOException {

		File file = fileUrlService.urlToTempFile(urlAsString, fileName);

		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-Disposition",
				"inline; filename=" + (fileName != null ? fileName : "riskguard-redactor-output.pdf"));

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(fileUrlService.fileToByteArray(file));
	}
}
