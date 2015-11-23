package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.SubscriptionTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.SubscriptionSetting;
import com.hkesports.matchticker.vo.getsubscription.BasicSubscriptionVo;

public class SubscriptionSettingDaoImpl extends BasicDaoImpl implements SubscriptionSettingDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String JPQL_deleteByUserAndSubscription = 
			"delete from SubscriptionSetting " + 
			"where userType=:userType and userId=:userId and subscriptionType=:subscriptionType and subscriptionKey=:subscriptionKey";
	
	@Override
	public int deleteByUserAndSubscription(SubscriptionSetting setting) {
		Query query = entityManager.createQuery(JPQL_deleteByUserAndSubscription);
		query.setParameter("userType", setting.getUserType());
		query.setParameter("userId", setting.getUserId());
		query.setParameter("subscriptionType", setting.getSubscriptionType());
		query.setParameter("subscriptionKey", setting.getSubscriptionKey());
		return query.executeUpdate();
	}

	private final static String JPQL_countByUserAndSubscription = 
			"select count(id) from SubscriptionSetting " + 
			"where userType=:userType and userId=:userId and subscriptionType=:subscriptionType and subscriptionKey=:subscriptionKey";
	
	@Override
	public Long countByUserAndSubscription(SubscriptionSetting setting) {
		Query query = entityManager.createQuery(JPQL_countByUserAndSubscription);
		query.setParameter("userType", setting.getUserType());
		query.setParameter("userId", setting.getUserId());
		query.setParameter("subscriptionType", setting.getSubscriptionType());
		query.setParameter("subscriptionKey", setting.getSubscriptionKey());
		return (Long)query.getSingleResult();
	}

	@Override
	public int countByUserAndSubscription(Long userId, UserTypeEnum userType, Long subscriptionKey, SubscriptionTypeEnum subscriptionType) {
		Query query = entityManager.createQuery(JPQL_countByUserAndSubscription);
		query.setParameter("userId", userId);
		query.setParameter("userType", userType);
		query.setParameter("subscriptionKey", subscriptionKey);
		query.setParameter("subscriptionType", subscriptionType);
		return ((Number)query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public <T extends BasicSubscriptionVo> List<T> findAllByUser(Class<T> clazz, Long userId, UserTypeEnum userType, String... types) {
		Session session = entityManager.unwrap(Session.class);
		
		StringBuffer sql = new StringBuffer();
		sql.append("select subscription_type as subscriptionType, subscription_key as subscriptionKey ");
		sql.append("from subscription_setting ");
		sql.append("where user_type=:userType and user_id=:userId ");
		if(ArrayUtils.isNotEmpty(types)) {
			if(types.length==1) {
				sql.append("and subscription_type=:subscriptionType ");
			} else {
				sql.append("and subscription_type in (:subscriptionTypes) ");
			}
		}
		SQLQuery queryObj = session.createSQLQuery(sql.toString());
		queryObj.setResultTransformer(Transformers.aliasToBean(clazz));
		queryObj.setParameter("userId", userId);
		queryObj.setParameter("userType", userType.name());
		if(ArrayUtils.isNotEmpty(types)) {
			if(types.length==1) {
				queryObj.setParameter("subscriptionType", types[0]);
			} else {
				queryObj.setParameterList("subscriptionTypes", types);
			}
		}
		addScalars(clazz, queryObj);
		return queryObj.list();
	}
}
