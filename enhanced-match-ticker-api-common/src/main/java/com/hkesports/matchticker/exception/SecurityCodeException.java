package com.hkesports.matchticker.exception;

import com.hkesports.matchticker.enums.StatusCodeEnum;

/**
 * Security Code 錯誤
 */
public class SecurityCodeException extends ApiException {
	private static final long serialVersionUID = 1L;

	public SecurityCodeException(String msessage) {
		super(msessage);
	}

	public SecurityCodeException(StatusCodeEnum statusCode){
		this.statusCode = statusCode;
	}

	public String getMessage(){
		if(statusCode == null)
			return super.getMessage();
		else
			return statusCode.getDescription();	
	}
}
