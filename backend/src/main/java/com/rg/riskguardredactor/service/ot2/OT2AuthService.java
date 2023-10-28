package com.rg.riskguardredactor.service.ot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.rg.riskguardredactor.controller.model.OT2AuthResponseModel;
import com.rg.riskguardredactor.util.Constant;
import com.rg.riskguardredactor.util.JSONTools;

@Service
public class OT2AuthService extends Constant {

	private static Logger log = LoggerFactory.getLogger(OT2AuthService.class);

	private OT2AuthResponseModel authResponse = null;

	public String getBearerToken() {
		if (authResponse == null || hasTokenExpired()) {
			log.debug("Fetching new token");
			try {
				authResponse = forceRefreshToken();
			} catch (JsonProcessingException e) {
				log.error("Couldn't parse token response", e);
				throw new IllegalStateException("Couldn't parse token response. Error: " + e.getMessage());
			}
		} else {
			log.debug("Using old token");
		}
		return authResponse.getAccess_token();
	}

	private OT2AuthResponseModel forceRefreshToken() throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JsonObject requestBody = new JsonObject();
		requestBody.addProperty("client_id", OT2_CLIENT_ID);
		requestBody.addProperty("client_secret", OT2_CLIENT_SECRET);
		requestBody.addProperty("grant_type", OT2_GRANT_TYPE);
		requestBody.addProperty("username", OT2_USERNAME);
		requestBody.addProperty("password", OT2_PASSWORD);

		HttpEntity<String> request = new HttpEntity<>(requestBody.toString(), headers);

		String responseAsString = restTemplate.postForObject(OT2_AUTH_URL, request, String.class);
		ObjectMapper objectMapper = JSONTools.getObjectMapper();
		OT2AuthResponseModel responseObj = objectMapper.readValue(responseAsString, OT2AuthResponseModel.class);

		return responseObj;
	}

	private boolean hasTokenExpired() {
		if (authResponse == null) {
			return true;
		}
		long issuedAtMillis = Long.parseLong(authResponse.getIssued_at());
		log.debug("issuedAtMillis = {}", issuedAtMillis);
		long expiresInMillis = issuedAtMillis + Long.parseLong(authResponse.getExpires_in()) * 1000;
		log.debug("expiresInMillis = {}", expiresInMillis);
		return System.currentTimeMillis() > expiresInMillis;
	}

}
