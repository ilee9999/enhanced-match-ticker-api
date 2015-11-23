package com.hkesports.matchticker.vo.getha;

import java.math.BigInteger;

import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.vo.BasicVo;

public class GethaVo extends BasicVo {
	
	private static final long serialVersionUID = 1L;
	
	private BigInteger ha;

	public GethaVo() {}
	
	public GethaVo(StatusCodeEnum statusCode) {
		super(statusCode);
	}
	
	public GethaVo(BigInteger ha) {
		this.ha = ha;
	}
	
	public BigInteger getHa() {
		return ha;
	}

	public void setHa(BigInteger ha) {
		this.ha = ha;
	}
}
