package com.rg.riskguardredactor.service.ot2;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot2.contentstorageservice.api.ContentApi;
import com.ot2.contentstorageservice.api.SharableLinksApi;
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.Configuration;
import com.ot2.contentstorageservice.invoker.auth.HttpBearerAuth;
import com.ot2.contentstorageservice.model.Content;
import com.ot2.contentstorageservice.model.NewLinkRequest;
import com.ot2.contentstorageservice.model.NewLinkResponse;
import com.ot2.contentstorageservice.model.UploadContentRequest;
import com.rg.riskguardredactor.util.Constant;

@Service
public class OT2ContentStorageService implements Constant {

	private static Logger log = LoggerFactory.getLogger(OT2ContentStorageService.class);

	@Autowired
	OT2AuthService authService;

	public Content getContent(String id) {

		try {
			ContentApi apiInstance = getContentApiInstance();
			Content result = apiInstance.getContent(id);
			log.debug("{}", result);
			return result;
		} catch (ApiException e) {
			log.error("Exception when calling ContentApi#getContent");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}
		return null;
	}

	public Content uploadContent(File file) {
		try {
			String tenantId = null;
			boolean antivirusScan = false;
			UploadContentRequest uploadReq = new UploadContentRequest();
			List<File> files = Arrays.asList(file);
			uploadReq.setName(files);

			ContentApi apiInstance = getContentApiInstance();

			Content result = apiInstance.uploadContentTenant(tenantId, antivirusScan, uploadReq);
			log.debug("{}", result);
			return result;
		} catch (ApiException e) {
			log.error("Exception when calling ContentApi#uploadContentTenant");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}
		return null;
	}

	public File downloadContent(String id) {

		try {
			ContentApi apiInstance = getContentApiInstance();
			String objectId = null; // String | The ID of the object attached with the content
			String fileName = null; // String | The name of the file in response
			String mimeType = null; // String | The mime type of the content. This has higher priority
									// than the Accept header
			String dispositionType = null; // String | Content disposition of the downloaded
											// content
			Boolean avsScan = false; // Boolean | Flag indicating whether or not to perform a virus scan. Reserved
										// for trusted clients,
			File result = apiInstance.downloadcontent(id, objectId, fileName, mimeType, dispositionType, avsScan);
			return result;
		} catch (ApiException e) {
			log.error("Exception when calling ContentApi#getContent");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}
		return null;
	}

	// TODO: This requires uploading the file to CMS also. I haven't figured out
	// that yet. Need to complete this after figuring that out.
	public NewLinkResponse createPublicUrl(String id, String objectId) {
		try {
			SharableLinksApi apiInstance = getSharableLinksApiInstance();
			// TODO: Figure out infinite expiry date and no password
			NewLinkRequest newLinkRequest = new NewLinkRequest(); // NewLinkRequest | Password and expiry set to none

			NewLinkResponse result = apiInstance.createSharableLink(id, objectId, null);
			log.debug("{}", result);
			return result;
		} catch (ApiException e) {
			log.error("Exception when calling SharableLinksApi#getSharableLink");
			log.error("Status code: {}", e.getCode());
			log.error("Reason: {}", e.getResponseBody());
			log.error("Response headers: {}", e.getResponseHeaders());
			e.printStackTrace();
		}
		return null;
	}

	private ContentApi getContentApiInstance() {
		return new ContentApi(getClient());
	}

	private SharableLinksApi getSharableLinksApiInstance() {
		return new SharableLinksApi(getClient());
	}

	private ApiClient getClient() {
		ApiClient defaultClient = Configuration.getDefaultApiClient();
		defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
		HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("css.na-1-dev.api.opentext.com");
		bearerAuth.setBearerToken(authService.getBearerToken());
		return defaultClient;
	}

}
