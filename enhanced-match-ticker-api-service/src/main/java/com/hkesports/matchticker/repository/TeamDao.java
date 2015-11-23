package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.Team;
import com.hkesports.matchticker.repository.custom.TeamDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface TeamDao extends GenericRepository<Team, Long>, TeamDaoCustom {
	
	@Modifying
	@Query(value="update team set follower_number=ifnull(follower_number, 0) + :count where id=:id", nativeQuery=true)
	public int updateFollowerNumber(@Param("id")Long id, @Param("count")int count);
	
}
