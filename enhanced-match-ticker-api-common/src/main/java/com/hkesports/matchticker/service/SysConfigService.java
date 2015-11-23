package com.hkesports.matchticker.service;

import java.util.Collection;

import com.hkesports.matchticker.vo.VersionCheckVo;
import com.hkesports.matchticker.vo.getcontestrule.GetcontestruleVo;
import com.hkesports.matchticker.vo.getprivacypolicy.GetprivacypolicyVo;
import com.hkesports.matchticker.vo.gettermsofservice.GettermsofserviceVo;

public interface SysConfigService {
	
	public VersionCheckVo iosVersionCheck();
	
	public VersionCheckVo androidVersionCheck();
	
	public GetcontestruleVo getContestRule();
	
	public GetprivacypolicyVo getPrivacyPolicy();
	
	public GettermsofserviceVo getTermsOfService();
	
	public Collection<String> getCacheNames();
	
	public void cacheEvictAll();
	
	public void cacheEvict(String cacheName);
	
	public void cacheEvict(String... cacheNames);
}
