package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.model.GamePicksBans;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.getmatchstatistics.GameTeamBanVo;

public interface GamePicksBansDao extends GenericRepository<GamePicksBans, Long> {

	public final static String JPQL_findGameTeamBanByGameAndTeam = "select new com.hkesports.matchticker.vo.getmatchstatistics.GameTeamBanVo ( "
			  + "s.hero.id, s.order "
			  + ") "
			  + "from GamePicksBans as s "
			  + "where s.gameType=:gameType and s.scheduleGame.id=:gameId and s.teamId=:teamId";

	@Query(JPQL_findGameTeamBanByGameAndTeam)
	public List<GameTeamBanVo> findGameTeamBanByGameAndTeam(@Param("gameType") GameTypeEnum gameType, @Param("gameId") Long gameId, @Param("teamId") Long teamId);
}
