package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.model.Schedule;
import com.hkesports.matchticker.repository.custom.ScheduleDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.getmatchstatistics.GetmatchstatisticsVo;
import com.hkesports.matchticker.vo.gettournamentdetails.ScheduleVo;
import com.hkesports.matchticker.vo.matchsupport.MatchsupportVo;

public interface ScheduleDao extends GenericRepository<Schedule, Long>, ScheduleDaoCustom {

	public final static String JPQL_matchsupport = 
			"select new com.hkesports.matchticker.vo.matchsupport.MatchsupportVo (" + 
			 " 	s.dateTime, s.startTime, s.endTime, " +
			 "	t.id, t.tournamentName, t.tournamentShortName, " +
			 "	t.tournamentSiteUrl, s.matchLiveUrl, s.matchArchiveUrl," +
			 "	s.id, g.team" +
			 ")" +
			 "from Schedule as s " +
			 "join s.tournament as t " +
			 "join s.game as g " +
			 "where s.id=:matchID ";
	
	@Query(JPQL_matchsupport)
	public MatchsupportVo matchSupport(@Param("matchID") Long matchId);
	
	public final static String JPQL_findMatchStatistics = 
				"select new com.hkesports.matchticker.vo.getmatchstatistics.GetmatchstatisticsVo (" +
			    " 	s.tournament.id, s.tournament.tournamentName, " +
			    "	s.startTime, s.winnerId, s.maxGames, s.isLive, " +
			    "	s.isFinished" +
			    ")" +
			    "from Schedule as s " +
			    "where s.id=:matchID and s.game.gameCode=:gameCode ";
	
	@Query(JPQL_findMatchStatistics)
	public GetmatchstatisticsVo findMatchStatistics(@Param("gameCode") GameTypeEnum gameCode, @Param("matchID") Long matchId);
	
	public final static String JPQL_findAllScheduleVoByTournamentId = 
			"select new com.hkesports.matchticker.vo.gettournamentdetails.ScheduleVo (" +
		    " 	g.id, g.enGameName, g.twGameName, g.gameUrl, s.id, s.startTime, " +
			"(case when sysdate() < s.startTime then 'Feture' when sysdate() between s.startTime and s.endTime then 'Live' when sysdate() > s.endTime then 'Ended' else '' end) as matchStatus, " + 
			"	t.id, t.tournamentName, t.tournamentShortName, t.tournamentSiteUrl, s.matchLiveUrl, s.maxGames, " +
			"	s.status, g.team " +
		    ")" +
		    "from Schedule as s " +
		    "join s.tournament as t " +
		    "join s.game as g " +
		    "where t.id=:tournamentId ";
	@Query(JPQL_findAllScheduleVoByTournamentId)
	public List<ScheduleVo> findAllScheduleVoByTournamentId(@Param("tournamentId") Long tournamentId);
}
