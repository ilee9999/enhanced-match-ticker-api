package com.hkesports.matchticker.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hkesports.matchticker.service.SysConfigService;
import com.hkesports.matchticker.vo.ResponseVo;
import com.hkesports.matchticker.vo.VersionCheckVo;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

@RestController
@RequestMapping(value = "rest/emt/api/v1")
public class SysConfigController extends BasicController {
	
	@Resource(name = "sysConfigService")
	private SysConfigService sysConfigService;
	
	/**
	 * To obtain the latest version of the IOS App
	 * @param versionID
	 * @return
	 * @throws Exception 
	 */
	@CacheControl(policy = {CachePolicy.NO_CACHE}, maxAge = ONE_HOUR)
	@RequestMapping(value = "iosversioncheck", method = RequestMethod.GET)
	public ResponseVo<VersionCheckVo> iosVersionCheck(@RequestParam(value = "versionID") String versionID) {
		return new ResponseVo<>(sysConfigService.iosVersionCheck(versionID));
	}
	
	/**
	  * To obtain the latest version of the Android App
	  * @param versionID
	  * @return
	  * @throws Exception 
	  */
	@CacheControl(policy = {CachePolicy.NO_CACHE}, maxAge = ONE_HOUR)
	@RequestMapping(value = "androidversionicheck", method = RequestMethod.GET)
	public ResponseVo<VersionCheckVo> androidVersioniCheck(@RequestParam(value = "versionID") String versionID) {
		return new ResponseVo<>(sysConfigService.androidVersioniCheck(versionID));
	}
}
