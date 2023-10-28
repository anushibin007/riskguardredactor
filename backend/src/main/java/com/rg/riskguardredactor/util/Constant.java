package com.rg.riskguardredactor.util;

import org.springframework.beans.factory.annotation.Value;

public class Constant {

	@Value("${OT2_APP_ID}")
	public String OT2_APP_ID;

	@Value("${OT2_CLIENT_ID}")
	public String OT2_CLIENT_ID;

	@Value("${OT2_CLIENT_SECRET}")
	public String OT2_CLIENT_SECRET;

	@Value("${OT2_GRANT_TYPE}")
	public String OT2_GRANT_TYPE;

	@Value("${OT2_USERNAME}")
	public String OT2_USERNAME;

	@Value("${OT2_PASSWORD}")
	public String OT2_PASSWORD;

	@Value("${OT2_AUTH_URL}")
	public String OT2_AUTH_URL;

	@Value("${OT2_RISKGUARD_BASE_URL}")
	public String OT2_RISKGUARD_BASE_URL;

	@Value("${OT2_CORECAPTURE_BASE_URL}")
	public String OT2_CORECAPTURE_BASE_URL;

	@Value("${OT2_CONTENTSTORAGE_BASE_URL}")
	public String OT2_CONTENTSTORAGE_BASE_URL;

	@Value("${redactServerUrl}")
	public String redactServerUrl;

	@Value("${MAX_INPUT_FILE_SIZE_MB}")
	public String MAX_INPUT_FILE_SIZE_MB;

}
