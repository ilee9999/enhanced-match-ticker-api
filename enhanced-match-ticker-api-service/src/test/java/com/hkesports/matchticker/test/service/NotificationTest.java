package com.hkesports.matchticker.test.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.hkesports.matchticker.enums.NotificationSendTypeEnum;
import com.hkesports.matchticker.enums.NotificationStatusEnum;
import com.hkesports.matchticker.enums.NotificationTypeEnum;
import com.hkesports.matchticker.model.NotificationDetail;
import com.hkesports.matchticker.model.NotificationMaster;
import com.hkesports.matchticker.repository.NotificationDetailDao;
import com.hkesports.matchticker.repository.NotificationMasterDao;
import com.hkesports.matchticker.service.UserService;
import com.hkesports.matchticker.test.AbstractTest;
@Transactional
public class NotificationTest extends AbstractTest {

	@Resource
	private UserService userService;
	@Resource
	private NotificationMasterDao notificationMasterDao;
	@Resource
	private NotificationDetailDao notificationDetailDao;
	
	@Test
	@Ignore
	@Rollback(false)
	public void testSaveData() {
		for(int i=0;i<10;i++) {
			NotificationMaster nm = new NotificationMaster();
			nm.setNotificationType(NotificationTypeEnum.CONTEST);
			nm.setType(NotificationSendTypeEnum.POPUP);
			nm.setTitle("Title " + StringUtils.leftPad(String.valueOf(i), 3, '0'));
			nm.setContent("Content " + StringUtils.leftPad(String.valueOf(i), 3, '0'));
			nm.setStatus(NotificationStatusEnum.Ready);
			notificationMasterDao.saveAndFlush(nm);
				
			try {
				NotificationDetail nd = new NotificationDetail();
				nd.setNotificationMaster(nm);
				nd.setRegistrationId("1000");
				notificationDetailDao.saveAndFlush(nd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
