package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.model.Schedule;
import com.hkesports.matchticker.repository.custom.ScheduleDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.getmatchstatistics.GetmatchstatisticsVo;
import com.hkesports.matchticker.vo.matchsupport.MatchsupportVo;

public interface ScheduleDao extends GenericRepository<Schedule, Long>, ScheduleDaoCustom {

	public final static String JPQL_matchsupport = "select new com.hkesports.matchticker.vo.matchsupport.MatchsupportVo ("
												 + " 	g.dateTime, s.startTime, s.endTime, "
												 + "	t.id, t.touramentName, t.touramentShortName, "
												 + "	t.touramentSiteUrl, s.matchLiveUrl, s.matchArchiveUrl,"
												 + "	s.id "
												 + ")"
												 + "from Schedule as s "
												 + "inner join s.game as g "
												 + "left outer join s.tourament as t "
												 + "where s.id=:matchID ";
	
	public final static String JPQL_GetMatchStatistics = "select new com.hkesports.matchticker.vo.getmatchstatistics.GetmatchstatisticsVo ("
			 + " 	s.tourament.id, s.tourament.touramentName, "
			 + "	s.startTime, s.winner, s.game.maxGames, s.game.isLive, "
			 + "	s.isFinished, s.name"
			 + ")"
			 + "from Schedule as s "
			 + "where s.id=:matchID and s.gameType=:gameType";
	
	@Query(JPQL_matchsupport)
	public MatchsupportVo matchSupport(@Param("matchID") Long matchId);
	
	
	@Query(JPQL_GetMatchStatistics)
	public GetmatchstatisticsVo getMatchStatistics(@Param("gameType") GameTypeEnum gameType, @Param("matchID") Long matchId);
}
