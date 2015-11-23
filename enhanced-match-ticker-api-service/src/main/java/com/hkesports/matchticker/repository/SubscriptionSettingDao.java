package com.hkesports.matchticker.repository;

import com.hkesports.matchticker.model.SubscriptionSetting;
import com.hkesports.matchticker.repository.custom.SubscriptionSettingDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface SubscriptionSettingDao extends GenericRepository<SubscriptionSetting, Long>, SubscriptionSettingDaoCustom {

}
