package com.hkesports.matchticker.web.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.exception.SecurityCodeException;
import com.hkesports.matchticker.service.SecurityCodeService;
import com.hkesports.matchticker.vo.securityCode.SecurityCodeDecodeVo;

/**
 * @author manboyu
 *
 */
@ControllerAdvice(basePackages = "com.hkesports.matchticker.web.controller")
public class BasicController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	protected static final String HEADER_CACHE_CONTROL = "Cache-Control";
	
	protected final int ONE_MINUTE = 60;
	
	protected final int TEN_MINUTE = 10 * ONE_MINUTE;
	
	protected final int ONE_HOUR = 60 * ONE_MINUTE;
	
	protected final int ONE_DAY = 24 * ONE_HOUR;
	
	@Resource(name = "invokeSecurityCode")
	private SecurityCodeService invokeSecurityCode;
	
	protected String decode(String registrationID, String secretKey) throws SecurityCodeException {
		if(StringUtils.isNotBlank(secretKey)) {
			SecurityCodeDecodeVo vo = invokeSecurityCode.decodeForMQ(registrationID, secretKey);
			if(StringUtils.isBlank(vo.getDecodeString())) {
				// 如果沒有得到secretKey, 則拋出auth的exception code
				throw new SecurityCodeException(StatusCodeEnum.convertEnumFromCode(vo.getStatusCode()));
			}
			secretKey = vo.getDecodeString();
		}
		return secretKey;
	}
}
