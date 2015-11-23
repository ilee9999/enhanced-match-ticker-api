package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.enums.SubscriptionTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.SubscriptionSetting;
import com.hkesports.matchticker.vo.getsubscription.BasicSubscriptionVo;

public interface SubscriptionSettingDaoCustom {

	public int deleteByUserAndSubscription(SubscriptionSetting setting);
	
	public Long countByUserAndSubscription(SubscriptionSetting setting);
	
	public int countByUserAndSubscription(Long userId, UserTypeEnum userType, Long subscriptionKey, SubscriptionTypeEnum subscriptionType);
	
	public <T extends BasicSubscriptionVo> List<T> findAllByUser(Class<T> clazz, Long userId, UserTypeEnum userType, String... types);
}
