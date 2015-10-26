package com.hkesports.matchticker.test.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hkesports.matchticker.enums.ClientTypeEnum;
import com.hkesports.matchticker.enums.NotifyTypeEnum;
import com.hkesports.matchticker.model.EndUser;
import com.hkesports.matchticker.model.Notification;
import com.hkesports.matchticker.repository.EndUserDao;
import com.hkesports.matchticker.repository.NotificationDao;
import com.hkesports.matchticker.service.KeepAliveService;
import com.hkesports.matchticker.vo.KeepaliveReqVo;

public class KeepAliveServiceTest extends AbstractTest {

	@Resource(name = "keepAliveService")
	private KeepAliveService keepAliveService;
	
	@Resource(name = "endUserDao")
	private EndUserDao endUserDao;
	@Resource(name = "notificationDao")
	private NotificationDao notificationDao;
	
	private KeepaliveReqVo keepaliveReqVo;
	
	@Before
	public void setUp() {
		keepaliveReqVo = new KeepaliveReqVo();
		keepaliveReqVo.setClientType(ClientTypeEnum.WEB);
		keepaliveReqVo.setTimestamp("1442289175889");
		keepaliveReqVo.setUserID(100L);
		keepaliveReqVo.setMatchID(100L);
	}
	
	@Test
	public void testSaveEndUser() {
		Assert.assertNotNull(endUserDao);
		EndUser user = new EndUser();
		user.setAuthUserId(100L);
		user.setUcUserId(100L);
		user.setClientType(ClientTypeEnum.WEB);
		user.setVisitDate(new Date());
		endUserDao.save(user);
	}
	
	@Test
	public void testSaveNotification() {
		Assert.assertNotNull(notificationDao);
		Notification notification = new Notification();
		notification.setStartDate(DateUtils.addDays(new Date(), -3));
		notification.setEndDate(DateUtils.addDays(new Date(), 3));
		notification.setUserId(100L);
		notification.setNotifyType(NotifyTypeEnum.LOGGED);
		notification.setMessage("Hello World !");
		notification.setCreateBy("test");
	}
	
	@Test
	public void testKeepAlive() {
		Assert.assertNotNull(keepaliveReqVo);
		keepAliveService.keepalive(keepaliveReqVo);
	}
}
