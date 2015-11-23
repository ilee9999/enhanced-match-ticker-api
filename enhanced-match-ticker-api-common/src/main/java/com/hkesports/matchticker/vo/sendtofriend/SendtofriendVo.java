package com.hkesports.matchticker.vo.sendtofriend;

import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class SendtofriendVo extends BasicVo {

	private static final long serialVersionUID = 1L;
	
	public SendtofriendVo() {
		
	}

	public SendtofriendVo(StatusCodeEnum statusCode) {
		super(statusCode);
	}
}
