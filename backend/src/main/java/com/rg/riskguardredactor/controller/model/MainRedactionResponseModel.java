package com.rg.riskguardredactor.controller.model;

import java.util.List;

public class MainRedactionResponseModel {
	String redactedDocUrl;
	String errorMessage;
	List<String> riskyDataAsList;

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

	public List<String> getRiskyDataAsList() {
		return riskyDataAsList;
	}

	public void setRiskyDataAsList(List<String> riskyDataAsList) {
		this.riskyDataAsList = riskyDataAsList;
	}

	public static MainRedactionResponseModel buildFromErrorMessage(String errorMessage) {
		MainRedactionResponseModel response = new MainRedactionResponseModel();
		response.setErrorMessage(errorMessage);
		return response;
	}

}
