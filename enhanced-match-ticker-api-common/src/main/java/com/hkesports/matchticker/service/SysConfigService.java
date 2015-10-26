package com.hkesports.matchticker.service;

import com.hkesports.matchticker.vo.VersionCheckVo;

public interface SysConfigService {
	
	public VersionCheckVo iosVersionCheck(String versionID);
	
	public VersionCheckVo androidVersioniCheck(String versionID);
	
}
