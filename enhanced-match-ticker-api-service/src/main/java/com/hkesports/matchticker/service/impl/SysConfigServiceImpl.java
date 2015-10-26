package com.hkesports.matchticker.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hkesports.matchticker.model.Data;
import com.hkesports.matchticker.repository.DataDao;
import com.hkesports.matchticker.service.SysConfigService;
import com.hkesports.matchticker.vo.VersionCheckVo;

@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {

//	private static final Logger logger = LoggerFactory.getLogger(SysConfigService.class);
	
	@Resource(name = "dataDao")
	private DataDao dataDao;
	
	@Override
	@Cacheable(value = "iosVersionCheck", key = "#versionID")
	public VersionCheckVo iosVersionCheck(String versionID) {
		VersionCheckVo vo = new VersionCheckVo();
		vo.setVersionID(versionID);
		Data data = dataDao.findByCodeData("iOSVersion", versionID);
		if(data != null) {
			vo.setURL(data.getDataValue());
			vo.setDescription(data.getDataDesc());
		}
		return vo;
	}

	@Override
	@Cacheable(value = "androidVersioniCheck", key = "#versionID")
	public VersionCheckVo androidVersioniCheck(String versionID) {
		VersionCheckVo vo = new VersionCheckVo();
		vo.setVersionID(versionID);
		Data data = dataDao.findByCodeData("AndroidVersion", versionID);
		if(data != null) {
			vo.setURL(data.getDataValue());
			vo.setDescription(data.getDataDesc());
		}
		return vo;
	}

}
