package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.enums.HaUseTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.Data;

public interface DataDaoCustom {

	public String findLevelByUserId(UserTypeEnum userType, Long userId);
	
	public List<Data> findAllDataByHaTypes(UserTypeEnum userType, Long userId, HaUseTypeEnum... haTypes);
	
	public Data findAllDataByHaType(UserTypeEnum userType, Long userId, HaUseTypeEnum haType);
}
