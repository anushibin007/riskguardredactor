package com.rg.riskguardredactor.controller.model;

import java.util.List;

public class OT2AuthResponseModel {
	String refresh_token_expires_in;
	String refresh_token_status;
	String api_product_list;
	List<String> api_product_list_json;
	String organization_name;
	String token_type;
	String issued_at;
	String client_id;
	String access_token;
	String refresh_token;
	String application_name;
	String scope;
	String refresh_token_issued_at;
	String expires_in;
	String refresh_count;
	String status;

	public String getRefresh_token_expires_in() {
		return refresh_token_expires_in;
	}

	public void setRefresh_token_expires_in(String refresh_token_expires_in) {
		this.refresh_token_expires_in = refresh_token_expires_in;
	}

	public String getRefresh_token_status() {
		return refresh_token_status;
	}

	public void setRefresh_token_status(String refresh_token_status) {
		this.refresh_token_status = refresh_token_status;
	}

	public String getApi_product_list() {
		return api_product_list;
	}

	public void setApi_product_list(String api_product_list) {
		this.api_product_list = api_product_list;
	}

	public List<String> getApi_product_list_json() {
		return api_product_list_json;
	}

	public void setApi_product_list_json(List<String> api_product_list_json) {
		this.api_product_list_json = api_product_list_json;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getIssued_at() {
		return issued_at;
	}

	public void setIssued_at(String issued_at) {
		this.issued_at = issued_at;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getApplication_name() {
		return application_name;
	}

	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRefresh_token_issued_at() {
		return refresh_token_issued_at;
	}

	public void setRefresh_token_issued_at(String refresh_token_issued_at) {
		this.refresh_token_issued_at = refresh_token_issued_at;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_count() {
		return refresh_count;
	}

	public void setRefresh_count(String refresh_count) {
		this.refresh_count = refresh_count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
