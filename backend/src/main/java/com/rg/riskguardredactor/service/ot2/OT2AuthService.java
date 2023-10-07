package com.rg.riskguardredactor.service.ot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonObject;
import com.rg.riskguardredactor.util.Constant;
import com.rg.riskguardredactor.util.JSONTools;

@Service
public class OT2AuthService implements Constant {

	private static Logger log = LoggerFactory.getLogger(OT2AuthService.class);

	// TODO: Don't create a new token every time. Create one only if the current
	// token expires
	public String getBearerToken() {

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

//		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		params.set("object", objectMapper.writeValueAsString(new MyObject()));

//		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(OT2_AUTH_URL)
//				.queryParam("client_id", OT2_CLIENT_ID).queryParam("client_secret", OT2_CLIENT_SECRET)
//				.queryParam("grant_type", OT2_GRANT_TYPE).queryParam("username", OT2_USERNAME)
//				.queryParam("password", OT2_PASSWORD);

//		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, request,
//				String.class);

//		return response.getBody();

		try {
			JsonNode root = JSONTools.getObjectMapper().readTree(responseAsString);
			String authToken = root.path("access_token").asText();
			log.debug("authToken = {}", authToken);
			return authToken;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}

}
