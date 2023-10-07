package com.rg.riskguardredactor.service.ot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot2.ApiClient;
import com.ot2.ApiException;
import com.ot2.Configuration;
import com.ot2.auth.OAuth;
import com.ot2.corecapture.Get200Response;
import com.ot2.corecapture.HomeApi;
import com.rg.riskguardredactor.util.Constant;

@Service
public class OT2CoreCaptureService implements Constant {

	private static Logger log = LoggerFactory.getLogger(OT2CoreCaptureService.class);

	@Autowired
	OT2AuthService authService;

	public Get200Response version() {

		String bearerToken = authService.getBearerToken();
		if (bearerToken == null) {
			log.error("Could not retrieve Bearer Token. Hence, could not create apiClient.");
			return null;
		}

		ApiClient defaultClient = Configuration.getDefaultApiClient();
		defaultClient.setBasePath(OT2_CORECAPTURE_BASE_URL);

		// Configure OAuth2 access token for authorization: capture.ot2.opentext.eu
		OAuth captureOt2Eu = (OAuth) defaultClient.getAuthentication("capture.ot2.opentext.eu");
		captureOt2Eu.setAccessToken("YOUR ACCESS TOKEN");

		// Configure OAuth2 access token for authorization: capture.ot2.opentext.com
		OAuth captureOt2Com = (OAuth) defaultClient.getAuthentication("capture.ot2.opentext.com");
		captureOt2Com.setAccessToken("YOUR ACCESS TOKEN");

		HomeApi apiInstance = new HomeApi(defaultClient);
		String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an
																		// assignment or you can use itself,
																		// suppress_response_codes=suppress_response_codes
		try {
			Get200Response result = apiInstance.rootGet(suppressResponseCodes);
			return result;
		} catch (ApiException e) {
			System.err.println("Exception when calling BatchApi#sessionBatchesPost");
			System.err.println("Status code: " + e.getCode());
			System.err.println("Reason: " + e.getResponseBody());
			System.err.println("Response headers: " + e.getResponseHeaders());
			e.printStackTrace();
		}

		return null;
	}

}
