package com.hkesports.matchticker.vo;

import java.io.Serializable;

import com.hkesports.matchticker.enums.StatusCodeEnum;

/**
 * @author manboyu
 *
 */
public class BasicVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int statusCode = StatusCodeEnum.STATUS_0.getValue();
	
	public BasicVo() {}
	
	public BasicVo(int statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
