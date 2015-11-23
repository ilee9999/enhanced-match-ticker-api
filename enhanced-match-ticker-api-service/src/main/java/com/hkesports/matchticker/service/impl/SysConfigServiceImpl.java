package com.hkesports.matchticker.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.model.Data;
import com.hkesports.matchticker.repository.ContestRuleDao;
import com.hkesports.matchticker.repository.DataDao;
import com.hkesports.matchticker.repository.PrivacyPolicyDao;
import com.hkesports.matchticker.repository.TermsOfServiceDao;
import com.hkesports.matchticker.service.SysConfigService;
import com.hkesports.matchticker.utils.Const;
import com.hkesports.matchticker.vo.VersionCheckVo;
import com.hkesports.matchticker.vo.getcontestrule.GetcontestruleVo;
import com.hkesports.matchticker.vo.getprivacypolicy.GetprivacypolicyVo;
import com.hkesports.matchticker.vo.gettermsofservice.GettermsofserviceVo;

@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {

	@Resource(name = "cacheManager")
	private CacheManager cacheManager;
	
	@Resource(name = "dataDao")
	private DataDao dataDao;
	@Resource(name = "contestRuleDao")
	private ContestRuleDao contestRuleDao;
	@Resource(name = "privacyPolicyDao")
	private PrivacyPolicyDao privacyPolicyDao;
	@Resource(name = "termsOfServiceDao")
	private TermsOfServiceDao termsOfServiceDao;
	
	@Override
	@Cacheable(value = "iosVersionCheck", key = "{#root.methodName}")
	public VersionCheckVo iosVersionCheck() {
		List<Data> datas = dataDao.findByCodeName(Const.VERSION_KEY_IOS);
		if(CollectionUtils.isEmpty(datas) || datas.size() != 2) {
			return new VersionCheckVo();
		}
		Data data = datas.get(0);
		Data minimumVersion = datas.get(1);
		VersionCheckVo vo = new VersionCheckVo();
		vo.setVersionID(data.getDataName());
		vo.setMinimumVersionID(minimumVersion.getDataName());
		vo.setURL(data.getDataValue());
		vo.setDescription(data.getDataDesc());
		return vo;
	}

	@Override
	@Cacheable(value = "androidVersioniCheck", key = "{#root.methodName}")
	public VersionCheckVo androidVersionCheck() {
		List<Data> datas = dataDao.findByCodeName(Const.VERSION_KEY_ANDROID);
		if(CollectionUtils.isEmpty(datas) || datas.size() != 2) {
			return new VersionCheckVo();
		}
		Data data = datas.get(0);
		Data minimumVersion = datas.get(1);
		VersionCheckVo vo = new VersionCheckVo();
		vo.setVersionID(data.getDataName());
		vo.setMinimumVersionID(minimumVersion.getDataName());
		vo.setURL(data.getDataValue());
		vo.setDescription(data.getDataDesc());
		return vo;
	}

	@Override
	@Cacheable(value = "getContestRule", key = "{#root.methodName}")
	public GetcontestruleVo getContestRule() {
		return contestRuleDao.findContestRule();
	}

	@Override
	@Cacheable(value = "getPrivacyPolicy", key = "{#root.methodName}")
	public GetprivacypolicyVo getPrivacyPolicy() {
		return privacyPolicyDao.findPrivacypolicy();
	}

	@Override
	@Cacheable(value = "getTermsOfService", key = "{#root.methodName}")
	public GettermsofserviceVo getTermsOfService() {
		return termsOfServiceDao.findGettermsofservice();
	}

	@Override
	public void cacheEvictAll() {
		Collection<String> cacheNames = cacheManager.getCacheNames();
		for(String cacheName : cacheNames) {
			cacheClearByName(cacheName);
		}
	}

	@Override
	public Collection<String> getCacheNames() {
		return cacheManager.getCacheNames();
	}

	@Override
	public void cacheEvict(String cacheName) {
		Collection<String> allCacheNames = getCacheNames();
		if(StringUtils.isNotBlank(cacheName) && allCacheNames.contains(cacheName)) {
			cacheClearByName(cacheName);
		}
	}
	
	@Override
	public void cacheEvict(String... cacheNames) {
		Collection<String> allCacheNames = getCacheNames();
		for(String cacheName : cacheNames) {
			if(StringUtils.isNotBlank(cacheName) && allCacheNames.contains(cacheName)) {
				cacheClearByName(cacheName);
			}
		}
	}

	private void cacheClearByName(String cacheName) {
		Cache cache = cacheManager.getCache(cacheName);
		cache.clear();
	}
}
