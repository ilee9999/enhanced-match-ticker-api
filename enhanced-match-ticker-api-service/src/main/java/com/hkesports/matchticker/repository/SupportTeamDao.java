package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.SupportTeam;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface SupportTeamDao extends GenericRepository<SupportTeam, Long> {
	
	@Query("from SupportTeam s where s.userId=:userId and s.matchId=:matchId")
	public SupportTeam findByUserIdAndMatchId(@Param("userId") String userId, @Param("matchId") Long matchId);
	
	@Query("select count(s.id) from SupportTeam s where s.matchId=:matchId and s.teamId=:teamId")
	public Long countByMatchIdAndTeamId(@Param("matchId") Long matchId, @Param("teamId") Long teamId);
}
