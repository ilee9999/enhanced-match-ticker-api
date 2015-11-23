package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.WaitVerifyUser;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface WaitVerifyUserDao extends GenericRepository<WaitVerifyUser, Long> {

	@Query("select count(id) from WaitVerifyUser where deviceKey=:deviceKey")
	public Long countByDeviceKey(@Param("deviceKey")String deviceKey);
	
}
