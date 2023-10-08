package com.rg.riskguardredactor.service.ot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot2.corecapture.api.FilesApi;
import com.ot2.corecapture.api.HomeApi;
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.HttpBearerAuth;
import com.ot2.corecapture.model.Get200Response;
import com.ot2.corecapture.model.InlineFileRequestBody;
import com.ot2.corecapture.model.InlineFileRequestBody.ContentTypeEnum;
import com.ot2.corecapture.model.SessionFilesPost201Response;
import com.rg.riskguardredactor.util.Constant;

@Service
public class OT2CoreCaptureService implements Constant {

	private static Logger log = LoggerFactory.getLogger(OT2CoreCaptureService.class);

	@Autowired
	OT2AuthService authService;

	public Get200Response rootGet() {
		ApiClient defaultClient = getApiClient();
		HomeApi apiInstance = new HomeApi(defaultClient);
		String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an
																		// assignment or you can use itself,
																		// suppress_response_codes=suppress_response_codes
		try {
			Get200Response result = apiInstance.rootGet(suppressResponseCodes);
			return result;
		} catch (ApiException e) {
			log.error("Exception when calling BatchApi#sessionBatchesPost");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}

		return null;
	}

	public SessionFilesPost201Response sessionFilesPost(String contentType, String base64EncodedFileContent) {
		ApiClient defaultClient = getApiClient();
		FilesApi apiInstance = new FilesApi(defaultClient);
		String suppressResponseCodes = "suppressResponseCodes_example"; // String | This can be left without an
																		// assignment or you can use itself,
																		// suppress_response_codes=suppress_response_codes
		try {
			InlineFileRequestBody inlineFileRequestBody = new InlineFileRequestBody();
			inlineFileRequestBody.setContentType(ContentTypeEnum.fromValue(contentType));
			inlineFileRequestBody.setData(base64EncodedFileContent);

			SessionFilesPost201Response result = apiInstance.sessionFilesPost(suppressResponseCodes,
					inlineFileRequestBody);
			return result;
		} catch (ApiException e) {
			log.error("Exception when calling BatchApi#sessionBatchesPost");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}

		return null;
	}

//	private ApiClient getApiClient() {
//		String bearerToken = authService.getBearerToken();
//		if (bearerToken == null) {
//			log.error("Could not retrieve Bearer Token. Hence, could not create apiClient.");
//			return null;
//		}
//
//		ApiClient defaultClient = Configuration.getDefaultApiClient();
//		defaultClient.setBasePath(OT2_CORECAPTURE_BASE_URL);
//		defaultClient.addDefaultHeader("Authentication", "Bearer " + bearerToken);
//
//		// Configure OAuth2 access token for authorization: capture.ot2.opentext.eu
//		OAuth captureOt2Eu = (OAuth) defaultClient.getAuthentication("capture.ot2.opentext.eu");
//		captureOt2Eu.setAccessToken(bearerToken);
//
//		// Configure OAuth2 access token for authorization: capture.ot2.opentext.com
//		OAuth captureOt2Com = (OAuth) defaultClient.getAuthentication("capture.ot2.opentext.com");
//		captureOt2Com.setAccessToken(bearerToken);
//
//		defaultClient.getAuthentications().put("na-1-dev.api.opentext.com", new OAuth());
//		OAuth captureNaDev = (OAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
//		captureNaDev.setAccessToken(bearerToken);
//
//		return defaultClient;
//	}

	private ApiClient getApiClient() {

		String bearerToken = authService.getBearerToken();
		if (bearerToken == null) {
			log.error("Could not retrieve Bearer Token. Hence, could not create apiClient.");
			return null;
		}

		ApiClient defaultClient = Configuration.getDefaultApiClient();
		defaultClient.setBasePath(OT2_CORECAPTURE_BASE_URL);

		HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("na-1-dev.api.opentext.com");
		bearer.setBearerToken(bearerToken);

		return defaultClient;

	}

}
