package com.hkesports.matchticker.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.hkesports.matchticker.enums.HaUseTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.Code;
import com.hkesports.matchticker.model.Data;
import com.hkesports.matchticker.repository.CodeDao;
import com.hkesports.matchticker.repository.DataDao;
import com.hkesports.matchticker.test.AbstractTest;
import com.hkesports.matchticker.utils.Const;

public class CodeDataDaoTest extends AbstractTest {

	@Resource(name = "codeDao")
	private CodeDao codeDao;
	@Resource(name = "dataDao")
	private DataDao dataDao;
	
	@Test
	@Ignore
	public void testFindLevelValueByDataName() {
		List<Data> levels = dataDao.findLevelValueByDataName(Const.USER_PROFILE_HA_LEVEL, HaUseTypeEnum.EVERY_LEVEL_NEEDED_HA.name(), "3500");
		Assert.assertTrue("levels is empty ! ", levels.size() > 0);
		Assert.assertNotNull("get level code is null", levels.get(0).getCode());
	}
	
	@Test
	@Ignore
	public void testFindByCodeAndDataNameIn() {
		Code userlevel = codeDao.findByCodeName("LEVEL_1");
		List<Data> datas = dataDao.findByCodeAndDataNameIn(userlevel, HaUseTypeEnum.convertEnumToList(HaUseTypeEnum.LOWER_CONTEST_LIMIT_HA, HaUseTypeEnum.UPPER_CONTEST_LIMIT_HA, HaUseTypeEnum.EACH_INCREMENT_HA, HaUseTypeEnum.EACH_DECREMENT_HA));
		Assert.assertTrue("datas is empty ! ", datas.size() > 0);
	}
	
	@Test
	@Transactional(readOnly = true)
	@Rollback(false)
	@Ignore
	public void testFindAllDataByHaType() {
		Data data = dataDao.findAllDataByHaType(UserTypeEnum.USER, 970L, HaUseTypeEnum.RECEIVE_FRIEND_HA);
		Assert.assertNotNull("get data is null", data);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void testCanSendFriendCount() {
		Data sendFriendCountData = dataDao.findAllDataByHaType(UserTypeEnum.USER, 970L, HaUseTypeEnum.SEND_FRIEND_COUNT);
		logger.info("sendFriendCount : {}", Integer.parseInt(sendFriendCountData.getDataValue()));
	}
}
