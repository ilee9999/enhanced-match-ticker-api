package com.hkesports.matchticker.test.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.hkesports.matchticker.enums.HaUseTypeEnum;
import com.hkesports.matchticker.repository.HaRecordDao;
import com.hkesports.matchticker.test.AbstractTest;
import com.hkesports.matchticker.utils.DateUtil;

public class HaRecordDaoTest extends AbstractTest {

	@Resource(name = "haRecordDao")
	private HaRecordDao haRecordDao;
	
	@Test
	public void testCountHaRecordSended() {
		Date today = new Date();
		Integer count = haRecordDao.countHaRecordSended(80L, HaUseTypeEnum.RECEIVE_FRIEND_HA, DateUtil.toDateInt(today), 970L);
		Assert.assertNotNull("count is null", count);
	}
}
