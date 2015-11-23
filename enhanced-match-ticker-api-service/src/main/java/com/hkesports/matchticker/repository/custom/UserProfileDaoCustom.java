package com.hkesports.matchticker.repository.custom;

import com.hkesports.matchticker.vo.UserProfileVo;

public interface UserProfileDaoCustom {

	public UserProfileVo findByDeviceKeyAndSecretKey(String deviceKey, String secretKey);
	
}
