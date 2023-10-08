package com.rg.riskguardredactor.service.ot2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot2.corecapture.api.FilesApi;
import com.ot2.corecapture.api.HomeApi;
import com.ot2.corecapture.api.RealTimeServicesApi;
import com.ot2.corecapture.invoker.ApiClient;
import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.invoker.Configuration;
import com.ot2.corecapture.invoker.auth.HttpBearerAuth;
import com.ot2.corecapture.model.Get200Response;
import com.ot2.corecapture.model.InlineFileRequestBody;
import com.ot2.corecapture.model.InlineFileRequestBody.ContentTypeEnum;
import com.ot2.corecapture.model.ServicesRequestBody;
import com.ot2.corecapture.model.ServicesRequestBodyRequestItemsInner;
import com.ot2.corecapture.model.ServicesRequestBodyRequestItemsInnerFilesInner;
import com.ot2.corecapture.model.ServicesRequestBodyServicePropsInner;
import com.ot2.corecapture.model.ServicesRequestBodyServicePropsInnerValue;
import com.ot2.corecapture.model.SessionFilesPost201Response;
import com.ot2.corecapture.model.SessionServicesFullpageocrPost200Response;
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
			log.error("Exception when calling FilesApi#sessionFilesPost");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}

		return null;
	}

	public SessionServicesFullpageocrPost200Response sessionServicesFullpageocrPost(String name, String value,
			String contentType) {

		ApiClient defaultClient = getApiClient();
		RealTimeServicesApi apiInstance = new RealTimeServicesApi(defaultClient);

		try {
			ServicesRequestBody servicesRequestBody = getServiceRequestBodyForOCRRequest(name, value, contentType);

			SessionServicesFullpageocrPost200Response result = apiInstance
					.sessionServicesFullpageocrPost(servicesRequestBody);
			return result;
		} catch (ApiException e) {
			log.error("Exception when calling RealTimeServicesApi#sessionServicesFullpageocrPost");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}

		return null;
	}

	private ServicesRequestBody getServiceRequestBodyForOCRRequest(String name, String value, String contentType) {

		List<ServicesRequestBodyRequestItemsInner> requestItems = getRequestItems(name, value, contentType);
		List<ServicesRequestBodyServicePropsInner> serviceProps = getServiceProps();

		ServicesRequestBody servicesRequestBody = new ServicesRequestBody();
		servicesRequestBody.setRequestItems(requestItems);
		servicesRequestBody.setServiceProps(serviceProps);
		return servicesRequestBody;
	}

	private List<ServicesRequestBodyRequestItemsInner> getRequestItems(String name, String value, String contentType) {
		ServicesRequestBodyRequestItemsInnerFilesInner filesInner = new ServicesRequestBodyRequestItemsInnerFilesInner();
		filesInner.setName(name);
		filesInner.setValue(value);
		filesInner.setContentType(contentType);
		// TODO: Set file type dynamically
		filesInner.setFileType("pdf");
		List<ServicesRequestBodyRequestItemsInnerFilesInner> files = Arrays.asList(filesInner);

		ServicesRequestBodyRequestItemsInner itemsInner = new ServicesRequestBodyRequestItemsInner();
		itemsInner.setFiles(files);

		// TODO: Should we change this?
		itemsInner.setNodeId(1);
		itemsInner.setValues(getServicePropsForRequestItems());

		List<ServicesRequestBodyRequestItemsInner> requestItems = Arrays.asList(itemsInner);
		return requestItems;
	}

	private List<ServicesRequestBodyServicePropsInner> getServiceProps() {

		List<ServicesRequestBodyServicePropsInner> serviceProps = new ArrayList<>();
		serviceProps.add(buildServicesRequestBodyServicePropsInner("Env", "D"));
		serviceProps.add(buildServicesRequestBodyServicePropsInner("OcrEngineName", "Advanced"));
		serviceProps.add(buildServicesRequestBodyServicePropsInner("AutoRotate", "False"));
		// TODO: Country matters?
		serviceProps.add(buildServicesRequestBodyServicePropsInner("Country", "USA"));
		serviceProps.add(buildServicesRequestBodyServicePropsInner("ProcessingMode", "VoteOcrAndEText"));

		return serviceProps;
	}

	private List<ServicesRequestBodyServicePropsInner> getServicePropsForRequestItems() {

		List<ServicesRequestBodyServicePropsInner> serviceProps = new ArrayList<>();
		serviceProps.add(buildServicesRequestBodyServicePropsInner("OutputType", "Pdf"));
		serviceProps.add(buildServicesRequestBodyServicePropsInner("Version", "Pdf"));
		serviceProps.add(buildServicesRequestBodyServicePropsInner("Compression", "None"));
		serviceProps.add(buildServicesRequestBodyServicePropsInner("ImageSelection", "OriginalImage"));

		return serviceProps;
	}

	private ServicesRequestBodyServicePropsInner buildServicesRequestBodyServicePropsInner(String name, String value) {
		ServicesRequestBodyServicePropsInner aPropsInner = new ServicesRequestBodyServicePropsInner();
		aPropsInner.setName(name);
		aPropsInner.setValue(new ServicesRequestBodyServicePropsInnerValue(value));
		return aPropsInner;
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
