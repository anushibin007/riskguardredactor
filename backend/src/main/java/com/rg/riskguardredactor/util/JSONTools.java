package com.rg.riskguardredactor.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTools {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static ObjectMapper getObjectMapper() {
		// Fix for add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310"
		// to enable handling
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.findAndRegisterModules();
		return objectMapper;
	}
}
