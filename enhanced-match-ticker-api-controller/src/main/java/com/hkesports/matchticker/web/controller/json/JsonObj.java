package com.hkesports.matchticker.web.controller.json;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.hkesports.matchticker.enums.StatusCodeEnum;

public class JsonObj<T> {

	private T data;
	private StatusCodeEnum statusCode;
	private String description;
	private boolean success = true;
	private String errMsg;
	
	public JsonObj(){
		
	}
	
	public JsonObj(T data) {
		this.data = data;
		this.success = data != null;
	}
	
	private JsonObj(boolean success) {
		this.success = success;
	}
	
	private JsonObj(boolean success, String errMsg) {
		this.success = success;
		this.errMsg = errMsg;
	}
	
	public static final <T> JsonObj<T> success() {
		return new JsonObj<T>(true);
	}

	public  static final <T> JsonObj<T> success(String errMsg) {
		return new JsonObj<T>(true, errMsg);
	}

	public static final <T> JsonObj<T> failure() {
		return new JsonObj<T>(false);
	}

	public static final <T> JsonObj<T> failure(String errMsg) {
		return new JsonObj<T>(false, errMsg);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public StatusCodeEnum getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCodeEnum statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
