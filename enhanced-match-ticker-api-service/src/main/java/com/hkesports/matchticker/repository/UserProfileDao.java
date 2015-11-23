package com.hkesports.matchticker.repository;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.UserProfile;
import com.hkesports.matchticker.repository.custom.UserProfileDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface UserProfileDao extends GenericRepository<UserProfile, Long>, UserProfileDaoCustom {
	
	@Modifying
	@Query(value="update user_profile set ha=ifnull(ha, 0) - :ha, update_date=:updateDate where id=:id", nativeQuery=true)
	public int updateHaForMakeGuess(@Param("id")Long id, @Param("ha")BigInteger ha, @Param("updateDate")Date updateDate);
	
	@Modifying
	@Query(value = "update user_profile set ha = ifnull(ha, 0) + :ha, total_ha = ifnull(total_ha, 0) + :ha, update_date=:updateDate where id = :id", nativeQuery = true)
	public void addHa(@Param("id") Long id, @Param("ha") BigInteger ha, @Param("updateDate")Date updateDate);
	
	@Modifying
	@Query(value = "update user_profile set ha = ifnull(ha, 0) + :ha, total_ha = ifnull(total_ha, 0) + :ha, update_date=:updateDate where user_id = :userId", nativeQuery = true)
	public void addHaByUserId(@Param("userId") Long userId, @Param("ha") BigInteger ha, @Param("updateDate")Date updateDate);

}
