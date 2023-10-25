package com.rg.riskguardredactor.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
public class AliveController {

	@GetMapping("/alive")
	public Map<String, String> isAlive() {
		Map<String, String> aliveStatus = new HashMap<>();
		aliveStatus.put("alive", "true");
		aliveStatus.put("timestamp", String.valueOf(System.currentTimeMillis()));
		return aliveStatus;
	}

}
