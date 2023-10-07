package com.rg.riskguardredactor.service.ot2;

import org.springframework.stereotype.Service;

import com.ot2.ApiClient;
import com.ot2.ApiException;
import com.ot2.Configuration;
import com.ot2.auth.HttpBasicAuth;
import com.ot2.riskguard.ContentAnalyzerApi;
import com.ot2.riskguard.ProductVersion;
import com.rg.riskguardredactor.util.Constant;

@Service
public class OT2RiskGuardService {
	public ProductVersion getVersion(String[] args) {
		ApiClient defaultClient = Configuration.getDefaultApiClient();
		defaultClient.setBasePath(Constant.OT2_RISKGUARD_BASE_URL);
		defaultClient.setUsername(Constant.OT2_USERNAME);
		defaultClient.setPassword(Constant.OT2_PASSWORD);

		// Configure HTTP bearer authorization: Bearer
//		HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
//		bearer.setBearerToken("BEARER TOKEN");

		HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
		basicAuth.setUsername(Constant.OT2_USERNAME);
		basicAuth.setPassword(Constant.OT2_PASSWORD);

		ContentAnalyzerApi apiInstance = new ContentAnalyzerApi(defaultClient);
		try {
			ProductVersion result = apiInstance.getProductVersion();
			System.out.println(result);
			return result;
		} catch (ApiException e) {
			System.err.println("Exception when calling ContentAnalyzerApi#getProductVersion");
			System.err.println("Status code: " + e.getCode());
			System.err.println("Reason: " + e.getResponseBody());
			System.err.println("Response headers: " + e.getResponseHeaders());
			e.printStackTrace();
		}
		return null;
	}
}
