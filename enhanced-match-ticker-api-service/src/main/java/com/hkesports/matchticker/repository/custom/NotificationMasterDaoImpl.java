package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.NotificationStatusEnum;
import com.hkesports.matchticker.vo.getnotification.NotificationVo;

public class NotificationMasterDaoImpl extends BasicDaoImpl implements NotificationMasterDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String SQL_findAllNotificationByRegId = 
			"select nm.id as notificationID, nm.type as notificationType, nm.title as notificationTitle, nm.content as notificationBody " + 
			"from notification_master nm " + 
			"where nm.status = :status_ready and (nm.time_to_live is null or nm.time_to_live >= now()) " + 
			"and exists ( " + 
			"	select nd.id " + 
			"	from notification_detail nd " + 
			"	where nd.notification_master_id = nm.id and nd.time_read is null and nd.registration_id = :registrationID " + 
			") " + 
			"order by nm.time_to_live ";
	
	@SuppressWarnings("unchecked")
	public List<NotificationVo> findAllNotificationByRegId(String registrationID) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findAllNotificationByRegId);
		queryObj.setResultTransformer(Transformers.aliasToBean(NotificationVo.class));
		queryObj.setParameter("status_ready", NotificationStatusEnum.Ready.name());
		queryObj.setParameter("registrationID", registrationID);
		addScalars(NotificationVo.class, queryObj);
		return queryObj.list();
	}

	private final static String SQL_updateNotificationTimeSent = 
			"update notification_detail nd " + 
			"inner join notification_master nm on nd.notification_master_id = nm.id and (nm.time_to_live is null or nm.time_to_live >= now()) and nm.status = :status_ready " + 
			"set nd.time_sent = now(), nd.retry_count = if(nd.retry_count is null or nd.time_sent is null, 0, nd.retry_count+1) " + 
			"where nd.registration_id = :registrationID and nd.time_read is null ";
	
	@Override
	public int updateNotificationTimeSent(String registrationID) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_updateNotificationTimeSent);
		queryObj.setParameter("status_ready", NotificationStatusEnum.Ready.name());
		queryObj.setParameter("registrationID", registrationID);
		return queryObj.executeUpdate();
	}
	
}
