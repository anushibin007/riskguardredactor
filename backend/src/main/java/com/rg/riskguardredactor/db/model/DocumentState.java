package com.rg.riskguardredactor.db.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("DocumentStates")
public class DocumentState {

	String id;
	ProcessStatusModel coreCaptureStatus;
	ProcessStatusModel ocrStatus;
	ProcessStatusModel riskGuardStatus;
	ProcessStatusModel pythonRedactStatus;
	String redactedDocUrl;
	String userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProcessStatusModel getCoreCaptureStatus() {
		return coreCaptureStatus;
	}

	public void setCoreCaptureStatus(ProcessStatusModel coreCaptureStatus) {
		this.coreCaptureStatus = coreCaptureStatus;
	}

	public ProcessStatusModel getOcrStatus() {
		return ocrStatus;
	}

	public void setOcrStatus(ProcessStatusModel ocrStatus) {
		this.ocrStatus = ocrStatus;
	}

	public ProcessStatusModel getRiskGuardStatus() {
		return riskGuardStatus;
	}

	public void setRiskGuardStatus(ProcessStatusModel riskGuardStatus) {
		this.riskGuardStatus = riskGuardStatus;
	}

	public ProcessStatusModel getPythonRedactStatus() {
		return pythonRedactStatus;
	}

	public void setPythonRedactStatus(ProcessStatusModel pythonRedactStatus) {
		this.pythonRedactStatus = pythonRedactStatus;
	}

	public String getRedactedDocUrl() {
		return redactedDocUrl;
	}

	public void setRedactedDocUrl(String redactedDocUrl) {
		this.redactedDocUrl = redactedDocUrl;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
