package com.hkesports.matchticker.vo.makeguess;

import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.vo.BasicVo;

public class MakeguessVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	public MakeguessVo() {}
	
	public MakeguessVo(StatusCodeEnum statusCode) {
		super(statusCode);
	}
}
