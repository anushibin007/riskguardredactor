package com.rg.riskguardredactor.controller.model;

public class MainRedactionResponseModel {
	String redactedDocUrl;
	String errorMessage;

	public String getRedactedDocUrl() {
		return redactedDocUrl;
	}

	public void setRedactedDocUrl(String redactedDocUrl) {
		this.redactedDocUrl = redactedDocUrl;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static MainRedactionResponseModel buildFromErrorMessage(String errorMessage) {
		MainRedactionResponseModel response = new MainRedactionResponseModel();
		response.setErrorMessage(errorMessage);
		return response;
	}

}
