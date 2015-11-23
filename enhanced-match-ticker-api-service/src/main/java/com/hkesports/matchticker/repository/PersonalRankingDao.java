package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.PersonalRanking;
import com.hkesports.matchticker.repository.custom.PersonalRankingDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

/**
 * @author manboyu
 *
 */
public interface PersonalRankingDao extends GenericRepository<PersonalRanking, Long>, PersonalRankingDaoCustom {

	@Query("select rank from PersonalRanking where user.id=:userId and rankDate=:today")
	public Integer findByUserId(@Param("userId") Long userId, @Param("today") Integer today); 
}
