package com.hkesports.matchticker.test.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.hkesports.matchticker.enums.UserActivityTypeEnum;
import com.hkesports.matchticker.repository.UserActivityRecordDao;
import com.hkesports.matchticker.test.AbstractTest;
import com.hkesports.matchticker.utils.DateUtil;

public class UserActivityRecordDaoTest extends AbstractTest {

	@Resource(name = "userActivityRecordDao")
	private UserActivityRecordDao userActivityRecordDao;
	
	@Test
	public void testCountActivityRecordSended() {
		Date today = new Date();
		Integer count = userActivityRecordDao.countActivityRecordSended(970L, UserActivityTypeEnum.GIFT_FRIEND_HA, DateUtil.toDateInt(today), 80L);
		Assert.assertNotNull("count is null", count);
	}
	
	@Test
	public void testCountActivityRecordSendedNumber() {
		Date today = new Date();
		Integer activityRecordSendedNumber = userActivityRecordDao.countActivityRecordSendedNumber(970L, UserActivityTypeEnum.GIFT_FRIEND_HA, DateUtil.toDateInt(today));
		logger.info("activityRecordSendedNumber : {}", activityRecordSendedNumber);
	}
}
