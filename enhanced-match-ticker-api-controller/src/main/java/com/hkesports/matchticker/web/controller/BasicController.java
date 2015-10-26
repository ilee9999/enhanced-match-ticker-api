package com.hkesports.matchticker.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author manboyu
 *
 */
@ControllerAdvice(basePackages = "com.hkesports.matchticker.web.controller")
public class BasicController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	protected final int ONE_MINUTE = 60;
	
	protected final int TEN_MINUTE = 10 * ONE_MINUTE;
	
	protected final int ONE_HOUR = 60 * ONE_MINUTE;
}
