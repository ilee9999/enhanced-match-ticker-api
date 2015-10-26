package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hkesports.matchticker.enums.NotifyTypeEnum;
import com.hkesports.matchticker.vo.keepalive.SystemNotificationVo;

/**
 * @author manboyu
 *
 */
public class NotificationDaoImpl implements NotificationDaoCustom {
	
	@PersistenceContext
	EntityManager entityManager;
	
	private final static String jpql_getSystemNotifications = 
			"select new com.hkesports.matchticker.vo.keepalive.SystemNotificationVo ( " +
			"	notify.id, notify.message, notify.jumpToMatchId, notify.showToMatchId, " +
			" 	notify.startDate, notify.endDate " +
			") " +
			"from Notification as notify " +
			"where (notify.notifyType=:notifyType or notify.notifyType =:notifyTypeAll) " +
			"and now() between notify.startDate and notify.endDate ";

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemNotificationVo> getSystemNotifications(Long userId, Long matchId) {
		StringBuilder jpql = new StringBuilder(jpql_getSystemNotifications);
		if(userId != null) {
			jpql.append("and (notify.userId=:userId or notify.userId is null) ");
			jpql.append("and not exists ( ");
			jpql.append("	select id from NotificationReadHistory as hist ");
			jpql.append("	where hist.notificationId = notify.id ");
			jpql.append("	and hist.userId =:userId ");
			jpql.append(") ");
		} else {
			jpql.append("and notify.userId is null ");
		}
		if(matchId != null) {
			jpql.append("and (notify.showToMatchId=:matchId or notify.jumpToMatchId is not null) ");
		}
		Query queryObj = entityManager.createQuery(jpql.toString());
		
		if(userId != null) {
			queryObj.setParameter("notifyType", NotifyTypeEnum.LOGGED);
			queryObj.setParameter("userId", userId);
		} else {
			queryObj.setParameter("notifyType", NotifyTypeEnum.NON_LOGGED);
		}
		if(matchId != null) {
			queryObj.setParameter("matchId", matchId);
		}
		queryObj.setParameter("notifyTypeAll", NotifyTypeEnum.ALL);
		return queryObj.getResultList();
	}

}
