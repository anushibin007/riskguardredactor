package com.rg.riskguardredactor.util;

public interface Constant {

	// TODO: Move all of the below constants to a properties file

	// Should change when the environment changes
	public static final String LOCAL_SAMPLE_SEARCHABLE_PDF_FILE_PATH = "C:/Users/anush/Downloads/lab-report-1pg.pdf";

	// Credentials
	public static final String OT2_APP_ID = "1d429e1e-cf21-43c7-adb3-6c3838ae3e69";
	public static final String OT2_CLIENT_ID = "wNmm573Y4Ju6Ln7EMPw8ja22aOEo3NQI";
	public static final String OT2_CLIENT_SECRET = "a18fBeP1J66X1SPl";
	public static final String OT2_GRANT_TYPE = "password";
	public static final String OT2_USERNAME = "lehaxob800@viicard.com";
	public static final String OT2_PASSWORD = "Ec##149MJr";

	// URLs
	public static final String OT2_BASE_URL = "https://na-1-dev.api.opentext.com";
	public static final String OT2_AUTH_URL = OT2_BASE_URL + "/tenants/" + OT2_APP_ID + "/oauth2/token";
	public static final String OT2_RISKGUARD_BASE_URL = OT2_BASE_URL + "/mtm-riskguard";
	public static final String OT2_CORECAPTURE_BASE_URL = OT2_BASE_URL + "/capture/cp-rest/v2";

}
