package com.rg.riskguardredactor.service.ot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot2.ApiClient;
import com.ot2.ApiException;
import com.ot2.Configuration;
import com.ot2.auth.HttpBearerAuth;
import com.ot2.riskguard.ContentAnalyzerApi;
import com.ot2.riskguard.ProductVersion;
import com.rg.riskguardredactor.util.Constant;

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
