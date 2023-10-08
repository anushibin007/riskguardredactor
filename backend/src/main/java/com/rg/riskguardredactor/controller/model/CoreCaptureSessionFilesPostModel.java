package com.rg.riskguardredactor.controller.model;

public class CoreCaptureSessionFilesPostModel {
	private String contentType;
	private String base64EncodedFileContent;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getBase64EncodedFileContent() {
		return base64EncodedFileContent;
	}

	public void setBase64EncodedFileContent(String base64EncodedFileContent) {
		this.base64EncodedFileContent = base64EncodedFileContent;
	}

	@Override
	public String toString() {
		return "CoreCaptureSessionFilesPostModel [contentType=" + contentType + ", base64EncodedFileContent="
				+ base64EncodedFileContent + "]";
	}

}
