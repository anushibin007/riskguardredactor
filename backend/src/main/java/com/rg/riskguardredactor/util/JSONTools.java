package com.rg.riskguardredactor.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTools {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}
}
