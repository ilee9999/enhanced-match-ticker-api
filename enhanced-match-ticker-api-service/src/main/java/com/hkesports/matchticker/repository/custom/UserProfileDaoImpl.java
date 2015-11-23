package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.vo.UserProfileVo;

public class UserProfileDaoImpl extends BasicDaoImpl implements UserProfileDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String SQL_findByDeviceKeyAndSecretKey = 
			"select up.id, up.user_id as userId, up.first_name as firstName, up.last_name as lastName, " + 
			"	up.gender, up.date_of_birth as dateOfBirth, " + 
			"	up.ha, up.total_ha as totalHa, up.online_times as onlineTimes, " + 
			"	up.language, up.time_zone as timeZone, " + 
			"	up.profile_picture_url as profilePictureUrl, " + 
			"	up.link, :deviceKey as deviceKey, " +
			"	u.account, u.name " + 
			"from user_profile up " + 
			"inner join user u on u.id = up.user_id and u.is_validate = :isValidate " + 
			"where exists ( " + 
			"	select ud.id " + 
			"	from user_devices ud " + 
			"	where ud.user_id = up.user_id " + 
			"		and ud.is_active = :isActive " + 
			"		and ud.device_key = :deviceKey " + 
			"		and ud.secret_key = :secretKey " + 
			"); ";
	
	@SuppressWarnings("unchecked")
	@Override
	public UserProfileVo findByDeviceKeyAndSecretKey(String deviceKey, String secretKey) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findByDeviceKeyAndSecretKey);
		queryObj.setResultTransformer(Transformers.aliasToBean(UserProfileVo.class));
		queryObj.setParameter("deviceKey", deviceKey);
		queryObj.setParameter("secretKey", secretKey);
		queryObj.setParameter("isActive", Boolean.TRUE);
		queryObj.setParameter("isValidate", Boolean.TRUE);
		addScalars(UserProfileVo.class, queryObj);
		
		List<UserProfileVo> list = queryObj.list();
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}
}
