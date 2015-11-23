package com.hkesports.matchticker.model.basic;

import java.math.BigInteger;

import com.hkesports.matchticker.enums.UserTypeEnum;

public interface UserHa {
	
	public Long getId();
	
	public Long getUserId();
	
	public String getDeviceKey();
	
	public BigInteger getHa();
	
	public BigInteger getTotalHa();
	
	public UserTypeEnum getUserType();
	
	public String getAccount();
	
	public String getName();
}
