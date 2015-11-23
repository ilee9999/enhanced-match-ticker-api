package com.hkesports.matchticker.repository.custom;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.BigIntegerType;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.enums.UserTypeEnum;

public class GuessLogDaoImpl extends BasicDaoImpl implements GuessLogDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String SQL_findYearlyTotalSpending = 
			"SELECT ifnull(sum(ha), 0) yearlyTotalSpending " + 
			"FROM match_ticker.guess_log " + 
			"where user_type = :userType and user_id = :userId and create_year = :year"; 
	
	@SuppressWarnings("unchecked")
	@Override
	public BigInteger findYearlyTotalSpending(Long userId, UserTypeEnum userType, Integer year) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findYearlyTotalSpending);
		queryObj.setParameter("userId", userId);
		queryObj.setParameter("userType", userType.name());
		queryObj.setParameter("year", year);
		queryObj.addScalar("yearlyTotalSpending", BigIntegerType.INSTANCE);
		List<BigInteger> list = queryObj.list();
		if(CollectionUtils.isEmpty(list)) {
			return BigInteger.ZERO;
		}
		
		return list.get(0);
	}

	private final static String SQL_findMonthlyTotalSpending = 
			"SELECT ifnull(sum(ha), 0) monthlyTotalSpending " + 
			"FROM match_ticker.guess_log " + 
			"where user_type = :userType and user_id = :userId and create_year = :year and create_month=:month"; 
	
	@SuppressWarnings("unchecked")
	@Override
	public BigInteger findMonthlyTotalSpending(Long userId, UserTypeEnum userType, Integer year, Integer month) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findMonthlyTotalSpending);
		queryObj.setParameter("userId", userId);
		queryObj.setParameter("userType", userType.name());
		queryObj.setParameter("year", year);
		queryObj.setParameter("month", month);
		queryObj.addScalar("monthlyTotalSpending", BigIntegerType.INSTANCE);
		List<BigInteger> list = queryObj.list();
		if(CollectionUtils.isEmpty(list)) {
			return BigInteger.ZERO;
		}
		return list.get(0);
	}

}
