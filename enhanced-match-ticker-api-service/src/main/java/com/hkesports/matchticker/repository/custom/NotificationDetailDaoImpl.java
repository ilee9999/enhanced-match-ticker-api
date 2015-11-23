package com.hkesports.matchticker.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class NotificationDetailDaoImpl implements NotificationDetailDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String SQL_updateNotificationTimeRead = 
			"update notification_detail nd " + 
			"set nd.time_read = now() " + 
			"where nd.notification_master_id = :notificationID and nd.registration_id = :registrationID ";
	
	@Override
	public int updateNotificationTimeRead(Long notificationID, String registrationID) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_updateNotificationTimeRead);
		queryObj.setParameter("notificationID", notificationID);
		queryObj.setParameter("registrationID", registrationID);
		return queryObj.executeUpdate();
	}
}
