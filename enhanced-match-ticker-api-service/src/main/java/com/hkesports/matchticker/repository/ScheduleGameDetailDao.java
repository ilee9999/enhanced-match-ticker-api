package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.GameWinTypeEnum;
import com.hkesports.matchticker.model.ScheduleGameDetail;
import com.hkesports.matchticker.model.Team;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.getmatchstatistics.GameTeamVo;

public interface ScheduleGameDetailDao extends GenericRepository<ScheduleGameDetail, Long> {

	public Long countByTeamAndWin(Team team, GameWinTypeEnum win);
	
	public final static String JPQL_findVodsByGameId = "select new com.hkesports.matchticker.vo.getmatchstatistics.GameTeamVo ( "
			  + "s.team.id, s.id, s.towerKills, s.inhibitorKills, s.baronKills, s.dragonKills, s.vilemawKills, s.dominionVictoryScore, "
			  + "s.firstBaron, s.firstDragon"
			  + ") "
			  + "from ScheduleGameDetail as s "
			  + "where s.scheduleGame.id=:gameId ";

	@Query(JPQL_findVodsByGameId)
	public List<GameTeamVo> findGameTeamsByGameId(@Param("gameId") Long gameId);
}
