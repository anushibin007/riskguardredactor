package com.rg.riskguardredactor.service.ot2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.ot2.riskguard.api.ContentAnalyzerApi;
import com.ot2.riskguard.invoker.ApiClient;
import com.ot2.riskguard.invoker.ApiException;
import com.ot2.riskguard.invoker.Configuration;
import com.ot2.riskguard.invoker.auth.HttpBearerAuth;
import com.ot2.riskguard.model.ContentResponse;
import com.ot2.riskguard.model.ProductVersion;
import com.rg.riskguardredactor.util.Constant;
import com.rg.riskguardredactor.util.JSONTools;

@Service
public class OT2RiskGuardService {

	private static Logger log = LoggerFactory.getLogger(OT2RiskGuardService.class);

	@Autowired
	OT2AuthService authService;

	public ProductVersion getVersion() {
		ContentAnalyzerApi apiInstance = getClientApiInstance();
		if (apiInstance == null) {
			log.error("Could not retrieve apiClientInstance. Hence, could not invoke getVersion.");
			return null;
		}

		try {
			ProductVersion result = apiInstance.getProductVersion();
			return result;
		} catch (ApiException e) {
			log.error("Exception when calling ContentAnalyzerApi#getProductVersion");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}

		return null;

	}

	public List<String> processAndGetResults() {
		ContentResponse processResults = process();
		return processAndGetResults(processResults);
	}

	public List<String> processAndGetResults(ContentResponse processResults) {

		if (processResults == null) {
			log.error("Could not retrieve processResults. Hence, could not process the data further.");
			return null;
		}
		// TODO: Check processResults.getResults().getTme().getStatus() first before
		// obtaining the results
		String tmeString = processResults.getResults().getTme().toJson();

		try {
			JsonNode tmeRoot = JSONTools.getObjectMapper().readTree(tmeString);
			JsonNode extractedTermRoot = tmeRoot.findValue("ExtractedTerm");
			if (extractedTermRoot.isArray()) {
				List<String> extractedTerms = new ArrayList<>();
				for (JsonNode anExtractedTermNode : extractedTermRoot) {
					JsonNode subtermsNode = anExtractedTermNode.path("Subterms");
					JsonNode subtermNode = subtermsNode.path("Subterm");
					String anExtractedTerm = subtermNode.get(0).path("value").asText();
					extractedTerms.add(anExtractedTerm);
				}
				return extractedTerms;
			} else {
				log.warn("extractedTermRoot was not an array");
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ContentResponse process() {
		ContentAnalyzerApi apiInstance = getClientApiInstance();
		if (apiInstance == null) {
			log.error("Could not retrieve apiClientInstance. Hence, could not invoke getVersion.");
			return null;
		}

		try {
			// TODO: File should come dynamically
			File file = new File("C:/Users/anush/Downloads/lab-report-1pg.pdf");
			ContentResponse result = apiInstance.processContent(file);
			return result;
		} catch (ApiException e) {
			log.error("Exception when calling ContentAnalyzerApi#processContent");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}
		return null;
	}

	private ContentAnalyzerApi getClientApiInstance() {

		String bearerToken = authService.getBearerToken();
		if (bearerToken == null) {
			log.error("Could not retrieve Bearer Token. Hence, could not create apiClient.");
			return null;
		}

		ApiClient defaultClient = Configuration.getDefaultApiClient();
		defaultClient.setBasePath(Constant.OT2_RISKGUARD_BASE_URL);

		HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
		bearer.setBearerToken(bearerToken);

		ContentAnalyzerApi apiInstance = new ContentAnalyzerApi(defaultClient);
		return apiInstance;
	}
}
