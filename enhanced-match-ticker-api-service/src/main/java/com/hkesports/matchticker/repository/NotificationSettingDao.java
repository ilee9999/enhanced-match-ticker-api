package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.enums.NotificationTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.NotificationSetting;
import com.hkesports.matchticker.repository.custom.NotificationSettingDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface NotificationSettingDao extends GenericRepository<NotificationSetting, Long>, NotificationSettingDaoCustom {

	@Query("from NotificationSetting where notificationType=:notificationType and gameType=:gameType and userType=:userType and userId=:userId ")
	public List<NotificationSetting> findAll(@Param("notificationType")NotificationTypeEnum notificationType, 
			@Param("gameType")GameTypeEnum gameType, @Param("userType")UserTypeEnum userType, @Param("userId")Long userId);
	
	@Query("from NotificationSetting where notificationType=:notificationType and userType=:userType and userId=:userId ")
	public NotificationSetting findSendToFriendNotificationSetting(
			@Param("notificationType") NotificationTypeEnum notificationType,
			@Param("userType") UserTypeEnum userType, 
			@Param("userId") Long userId);
}
