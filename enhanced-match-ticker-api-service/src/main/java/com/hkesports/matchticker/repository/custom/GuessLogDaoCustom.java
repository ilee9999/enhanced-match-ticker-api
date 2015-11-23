package com.hkesports.matchticker.repository.custom;

import java.math.BigInteger;

import com.hkesports.matchticker.enums.UserTypeEnum;

public interface GuessLogDaoCustom {
	
	public BigInteger findYearlyTotalSpending(Long userId, UserTypeEnum userType, Integer year);
	
	public BigInteger findMonthlyTotalSpending(Long userId, UserTypeEnum userType, Integer year, Integer month);
	
}
