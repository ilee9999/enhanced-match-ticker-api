package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.enums.NotificationTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.NotificationMaster;
import com.hkesports.matchticker.repository.custom.NotificationMasterDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface NotificationMasterDao extends GenericRepository<NotificationMaster, Long>, NotificationMasterDaoCustom {

	@Query("from NotificationMaster where notificationType=:notificationType and gameType=:gameType and userType=:userType and userId=:userId ")
	public List<NotificationMaster> findAll(@Param("notificationType")NotificationTypeEnum notificationType, @Param("gameType")GameTypeEnum gameType, @Param("userType")UserTypeEnum userType, @Param("userId")Long userId);

}
