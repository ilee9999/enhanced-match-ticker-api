package com.hkesports.matchticker.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.camel.Produce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.config.routes.RouterConstant;
import com.hkesports.matchticker.model.NotificationReadHistory;
import com.hkesports.matchticker.repository.NotificationDao;
import com.hkesports.matchticker.repository.NotificationReadHistoryDao;
import com.hkesports.matchticker.service.EndUserService;
import com.hkesports.matchticker.service.KeepAliveService;
import com.hkesports.matchticker.vo.KeepaliveReqVo;
import com.hkesports.matchticker.vo.keepalive.KeepaliveVo;
import com.hkesports.matchticker.vo.keepalive.SystemNotificationVo;

/**
 * @author manboyu
 *
 */
@Service("keepAliveService")
public class KeepAliveServiceImpl implements KeepAliveService {

	@Produce(uri = RouterConstant.emt_updateEndUserInfo + RouterConstant.CAMEL_TO_URI_COMMON_PARAMETER)
	private EndUserService invokeUpdateEndUserInfo;
	@Produce(uri = RouterConstant.emt_addNotificationHist + RouterConstant.CAMEL_TO_URI_COMMON_PARAMETER)
	private KeepAliveService invokeAddNotificationHist;
	
	@Resource(name = "notificationDao")
	private NotificationDao notificationDao;
	@Resource(name = "notificationReadHistoryDao")
	private NotificationReadHistoryDao notificationReadHistoryDao;

	@Override
	public KeepaliveVo keepalive(KeepaliveReqVo vo) {
		KeepaliveVo result = new KeepaliveVo();
		List<SystemNotificationVo> notifications = notificationDao.getSystemNotifications(vo.getUserID(), vo.getMatchID());
		result.setSystemNotification(notifications);
		if(vo.getUserID() != null) {
			invokeUpdateEndUserInfo.updateEndUserInfo(vo, new Date());
			if(!CollectionUtils.isEmpty(notifications)) {
				for(SystemNotificationVo notification : notifications) {
					invokeAddNotificationHist.addNotificationHist(vo.getUserID(), notification.getNotificationID());
				}
			}
		}
		return result;
	}

	@Override
	@Transactional
	public void addNotificationHist(Long userId, Long notificationID) {
		List<NotificationReadHistory> hists = notificationReadHistoryDao.findByUserIdAndNotificationId(userId, notificationID);
		if(CollectionUtils.isEmpty(hists)) {
			NotificationReadHistory hist = new NotificationReadHistory();
			hist.setNotificationId(notificationID);
			hist.setUserId(userId);
			hist.setSendDate(new Date());
			hist.setReadDate(new Date());
			notificationReadHistoryDao.save(hist);
		}
	}
}
