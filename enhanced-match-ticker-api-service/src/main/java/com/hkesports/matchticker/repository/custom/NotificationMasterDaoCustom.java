package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.vo.getnotification.NotificationVo;

public interface NotificationMasterDaoCustom {

	public List<NotificationVo> findAllNotificationByRegId(String registrationID);
	
	public int updateNotificationTimeSent(String registrationID);
	
}
