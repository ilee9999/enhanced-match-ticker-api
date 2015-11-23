package com.hkesports.matchticker.exception;

import com.hkesports.matchticker.enums.StatusCodeEnum;

public class ApiException extends Exception {
	private static final long serialVersionUID = 1L;
	
	protected StatusCodeEnum statusCode;

	public ApiException(){}
	
	public ApiException(String msessage) {
		super(msessage);
	}

	public ApiException(StatusCodeEnum statusCode){
		this.statusCode = statusCode;
	}
	
	public StatusCodeEnum getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCodeEnum statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage(){
		if(statusCode == null)
			return super.getMessage();
		else
			return statusCode.getDescription();	
	}
}
