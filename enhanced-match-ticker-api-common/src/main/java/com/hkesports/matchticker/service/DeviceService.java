package com.hkesports.matchticker.service;

import com.hkesports.matchticker.vo.BasicVo;
import com.hkesports.matchticker.vo.MobileRegisterVo;

public interface DeviceService {

	public MobileRegisterVo setRegistrationId(String registrationId);
	public BasicVo updateDevice(String registrationId, String deviceKey, String newId);
}
