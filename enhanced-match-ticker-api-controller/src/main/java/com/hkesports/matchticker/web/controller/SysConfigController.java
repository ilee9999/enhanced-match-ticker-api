package com.hkesports.matchticker.web.controller;

import javax.annotation.Resource;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hkesports.matchticker.service.SysConfigService;
import com.hkesports.matchticker.vo.ResponseVo;
import com.hkesports.matchticker.vo.VersionCheckVo;
import com.hkesports.matchticker.vo.getcontestrule.GetcontestruleVo;
import com.hkesports.matchticker.vo.getprivacypolicy.GetprivacypolicyVo;
import com.hkesports.matchticker.vo.gettermsofservice.GettermsofserviceVo;

@RestController
@RequestMapping(value = "rest/emt/api/v1")
public class SysConfigController extends BasicController {
	
	@Resource(name = "sysConfigService")
	private SysConfigService sysConfigService;
	
	/**
	 * 依據cachename清除指定的cache
	 * 
	 * @param cacheName
	 */
	@CacheControl
	@RequestMapping(value = "cacheEvict", method = RequestMethod.GET)
	public void cacheEvict(@RequestParam(value = "cacheName") String cacheName) {
		sysConfigService.cacheEvict(cacheName);
	}
	
	/**
	 * 清除所有的cache
	 */
	@CacheControl
	@RequestMapping(value = "cacheEvictAll", method = RequestMethod.GET)
	public void cacheEvictAll() {
		sysConfigService.cacheEvictAll();
	}
	
	/**
	 * To obtain the latest version of the IOS App
	 * 
	 * @param versionID
	 * @return
	 * @throws Exception 
	 */
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "iosversioncheck", method = RequestMethod.GET)
	public ResponseVo<VersionCheckVo> iosVersionCheck() {
		return new ResponseVo<>(sysConfigService.iosVersionCheck());
	}
	
	/**
	  * To obtain the latest version of the Android App
	  * 
	  * @param versionID
	  * @return
	  * @throws Exception 
	  */
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "androidversioncheck", method = RequestMethod.GET)
	public ResponseVo<VersionCheckVo> androidVersionCheck() {
		return new ResponseVo<>(sysConfigService.androidVersionCheck());
	}
	
	/**
	 * 返回後台管理員用HTML格式輸入之contest rule，整個手機系統暫時只得一條contest rules
	 * 
	 * @return
	 */
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "getcontestrule", method = RequestMethod.GET)
	public ResponseVo<GetcontestruleVo> getcontestrule() {
		return new ResponseVo<>(sysConfigService.getContestRule());
	}
	
	/**
	 * 返回後台管理員用HTML格式輸入之privacy policy，整個手機系統暫時只得一條privacy policy
	 * 
	 * @return
	 */
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_DAY)
	@RequestMapping(value = "getprivacypolicy", method = RequestMethod.GET)
	public ResponseVo<GetprivacypolicyVo> getprivacypolicy() {
		return new ResponseVo<>(sysConfigService.getPrivacyPolicy());
	}
	
	/**
	 * 返回後台管理員用HTML格式輸入之terms of service，整個手機系統暫時只得一條terms of service
	 * 
	 * @return
	 */
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_DAY)
	@RequestMapping(value = "gettermsofservice", method = RequestMethod.GET)
	public ResponseVo<GettermsofserviceVo> gettermsofservice() {
		return new ResponseVo<>(sysConfigService.getTermsOfService());
	}
}
