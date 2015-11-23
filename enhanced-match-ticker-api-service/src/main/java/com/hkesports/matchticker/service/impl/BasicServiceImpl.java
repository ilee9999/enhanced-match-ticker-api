package com.hkesports.matchticker.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.exception.SecurityCodeException;
import com.hkesports.matchticker.model.Device;
import com.hkesports.matchticker.model.basic.UserHa;
import com.hkesports.matchticker.repository.DeviceDao;
import com.hkesports.matchticker.repository.UserDao;
import com.hkesports.matchticker.repository.UserProfileDao;
import com.hkesports.matchticker.repository.WaitVerifyUserDao;
import com.hkesports.matchticker.vo.UserProfileVo;

/**
 * @author manboyu
 *
 */
public class BasicServiceImpl {

	@Resource
	protected UserDao userDao;
	@Resource
	protected DeviceDao deviceDao;
	@Resource
	protected UserProfileDao userProfileDao;
	@Resource
	protected WaitVerifyUserDao waitVerifyUserDao;
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	protected UserHa getUserHa(String registrationID, String secretKey) throws SecurityCodeException {
		if(StringUtils.isBlank(secretKey)) {
			Device device = deviceDao.findByDeviceKey(registrationID);
			if(device!=null) {
				return device;
			}
		} else {
			UserProfileVo userProfile = userProfileDao.findByDeviceKeyAndSecretKey(registrationID, secretKey);
			if(userProfile != null) {
				return userProfile;
			}
			//確認wait_verify_user是否有 若有則撈device
			if(waitVerifyUserDao.countByDeviceKey(registrationID) > 0) {
				return getUserHa(registrationID, null);
			}
		}
		throw new SecurityCodeException(StatusCodeEnum.STATUS_303);
	}
}
