package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.UserDevices;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface UserDevicesDao extends GenericRepository<UserDevices, Long> {
	
	@Query("from UserDevices where user.id=:userId")
	public List<UserDevices> findByUserId(@Param("userId") Long userId);
}
