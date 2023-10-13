package com.rg.riskguardredactor.service.ot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot2.contentstorageservice.api.ContentApi;
import com.ot2.contentstorageservice.invoker.ApiClient;
import com.ot2.contentstorageservice.invoker.ApiException;
import com.ot2.contentstorageservice.invoker.auth.HttpBearerAuth;
import com.ot2.contentstorageservice.model.Content;
import com.rg.riskguardredactor.util.Constant;

@Service
public class OT2ContentStorageService implements Constant {

	private static Logger log = LoggerFactory.getLogger(OT2ContentStorageService.class);

	@Autowired
	OT2AuthService authService;

	public Content getContent(String id) {

		try {
			ContentApi apiInstance = getApiInstance();
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

	private ContentApi getApiInstance() {
		ContentApi apiInstance = new ContentApi();
		ApiClient defaultClient = apiInstance.getApiClient();
		defaultClient.setBasePath("https://css.na-1-dev.api.opentext.com");
		HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("css.na-1-dev.api.opentext.com");
		bearerAuth.setBearerToken(authService.getBearerToken());
		return apiInstance;
	}

}
