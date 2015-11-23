package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.enums.HaUseTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.Data;

public class DataDaoImpl extends BasicDaoImpl implements DataDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	//Device 永遠只有等級1
	private final static String SQL_findLevelByDevice = "select c.code_name from code c join data d on c.id = d.code_id where d.data_name = :EVERY_LEVEL_NEEDED_HA " +
			"and data_value <= 0 order by data_value desc limit 1 ";
	
	private final static String SQL_findLevelByUser = "select c.code_name from code c join data d on c.id = d.code_id where d.data_name = :EVERY_LEVEL_NEEDED_HA " +
			"and data_value <= (select total_ha from user_profile u where u.user_id = :userId) order by data_value desc limit 1 ";

	@SuppressWarnings("unchecked")
	@Override
	public String findLevelByUserId(UserTypeEnum userType, Long userId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = null;
		switch (userType) {
		case DEVICE:
			queryObj = session.createSQLQuery(SQL_findLevelByDevice);
			break;
		case USER:
			queryObj = session.createSQLQuery(SQL_findLevelByUser);
			queryObj.setParameter("userId", userId);
			break;
		default:
			return null;
		}
		queryObj.setParameter("EVERY_LEVEL_NEEDED_HA", HaUseTypeEnum.EVERY_LEVEL_NEEDED_HA.name());
		List<String> list = queryObj.list();
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}
	
	private final static String SQL_findAllDeviceDataByHaTypes = 
			"SELECT d.id, d.data_desc as dataDesc, d.display_order as displayOrder, " + 
			"	d.data_name as dataName, d.data_value as dataValue " + 
			"FROM data d " + 
			"inner join ( " + 
			"	select d1.code_id from data d1 " + 
			"	where d1.data_name = :EVERY_LEVEL_NEEDED_HA and d1.published = :published " + 
			"	and d1.data_value <= 0 " + 
			"	order by d1.data_value desc limit 1 " + 
			") d1 on d1.code_id = d.code_id " + 
			"where d.published = :published {other_sql} order by d.display_order ";
	
	private final static String SQL_findAllUserDataByHaTypes = 
			"SELECT d.id, d.data_desc as dataDesc, d.display_order as displayOrder, " + 
			"	d.data_name as dataName, d.data_value as dataValue " + 
			"FROM data d " + 
			"inner join ( " + 
			"	select d1.code_id from data d1 " + 
			"	where d1.data_name = :EVERY_LEVEL_NEEDED_HA and d1.published = :published " + 
			"	and d1.data_value <= (select total_ha from user_profile u where u.user_id = :userId) " + 
			"	order by d1.data_value desc limit 1 " + 
			") d1 on d1.code_id = d.code_id " + 
			"where d.published = :published {other_sql} order by d.display_order ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Data> findAllDataByHaTypes(UserTypeEnum userType, Long userId, HaUseTypeEnum... haTypes) {
		Session session = entityManager.unwrap(Session.class);
		String other_sql = "";
		if(ArrayUtils.isNotEmpty(haTypes)) {
			if(haTypes.length==1) {
				other_sql = " and d.data_name = :haType ";
			} else {
				other_sql = " and d.data_name in (:haTypes) ";
			}
		}
		SQLQuery queryObj = null;
		switch (userType) {
		case DEVICE:
			queryObj = session.createSQLQuery(StringUtils.replace(SQL_findAllDeviceDataByHaTypes, "{other_sql}", other_sql));
			break;
		case USER:
			queryObj = session.createSQLQuery(StringUtils.replace(SQL_findAllUserDataByHaTypes, "{other_sql}", other_sql));
			queryObj.setParameter("userId", userId);
			break;
		default:
			return null;
		}
		if(ArrayUtils.isNotEmpty(haTypes)) {
			if(haTypes.length==1) {
				queryObj.setParameter("haType", haTypes[0].name());
			} else {
				queryObj.setParameterList("haTypes", HaUseTypeEnum.convertEnumToList(haTypes));
			}
		}
		queryObj.setParameter("published", "Y");
		queryObj.setParameter("EVERY_LEVEL_NEEDED_HA", HaUseTypeEnum.EVERY_LEVEL_NEEDED_HA.name());
		queryObj.setResultTransformer(Transformers.aliasToBean(Data.class));
		addScalarsExclude(Data.class, queryObj, "published", "createBy", "updateBy", "createDate", "updateDate");
		return queryObj.list();
	}

	@Override
	public Data findAllDataByHaType(UserTypeEnum userType, Long userId, HaUseTypeEnum haType) {
		List<Data> list = findAllDataByHaTypes(userType, userId, haType);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}
}
