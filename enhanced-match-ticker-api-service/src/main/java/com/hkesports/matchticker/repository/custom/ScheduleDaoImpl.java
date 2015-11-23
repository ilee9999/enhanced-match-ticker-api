package com.hkesports.matchticker.repository.custom;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.CompetitionSystemEnum;
import com.hkesports.matchticker.enums.SubscriptionTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.basic.UserHa;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.getleaguetable.TournamentVo;
import com.hkesports.matchticker.vo.getmatchconteststatus.ContestantsVo;
import com.hkesports.matchticker.vo.getmatchstatistics.GameVo;
import com.hkesports.matchticker.vo.getpersonalrecord.RecordVo;
import com.hkesports.matchticker.vo.getresult.ResultVo;
import com.hkesports.matchticker.vo.getschedule.ResultScheduleVo;
import com.hkesports.matchticker.vo.gettournamentdetails.ScheduleVo;

public class ScheduleDaoImpl extends BasicDaoImpl implements ScheduleDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ResultScheduleVo> findAllSchedule(RequestVo requestVo, UserHa userHa) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select new com.hkesports.matchticker.vo.getschedule.ResultScheduleVo (");
		jpql.append("    g.id, g.enGameName, g.twGameName, g.gameUrl, g.team, ");
		jpql.append("    s.matchLiveUrl, s.maxGames, ");
		jpql.append("    s.id, s.startTime, s.endTime, ");
		jpql.append(" 	 (case when sysdate() < s.startTime then 'Feture' when sysdate() between s.startTime and s.endTime then 'Live' when sysdate() > s.endTime then 'Ended' else '' end) as matchStatus, ");
		jpql.append(" 	 t.id, t.tournamentName as tournamentName, ");
		jpql.append("	 t.tournamentShortName as tournamentShortName, t.tournamentSiteUrl as tournamentSiteURL, s.status");
		if(userHa != null) {
			jpql.append(", (case when(select count(id) from SubscriptionSetting where subscriptionKey = s.id and subscriptionType=:subscriptionType and userId=:userId and userType=:userType) > 0 then true else false end) as matchSubscriptionStatus");
		}
		jpql.append(")");
		jpql.append("from Schedule as s ");
		jpql.append("join s.tournament as t ");
		jpql.append("join s.game as g ");
		jpql.append("where s.results is null ");
		if(requestVo != null) {
			if(requestVo.getHighlight()!=null) {
				jpql.append(" and s.highlight=:highlight ");
			}
			if(StringUtils.isNotBlank(requestVo.getGameName())) {
				jpql.append(" and (s.game.enGameName=:gameName or s.game.twGameName=:gameName) ");
			}
			if(StringUtils.isNotBlank(requestVo.getTournamentShortName())) {
				jpql.append(" and t.tournamentShortName=:tournamentShortName ");
			}
			if(requestVo.getGameID() != null) {
				jpql.append(" and s.game.id=:gameId ");
			}
			if(requestVo.getTournamentID() != null) {
				jpql.append(" and s.tournament.id=:tournamentID ");
			}
		}
		jpql.append("order by s.startTime desc, s.endTime desc ");
		Query query = entityManager.createQuery(jpql.toString());
		if(userHa != null) {
			query.setParameter("subscriptionType", SubscriptionTypeEnum.MATCH);
			query.setParameter("userId", userHa.getUserId());
			query.setParameter("userType", userHa.getUserType());
		}
		if(requestVo != null) {
			if(StringUtils.isNotBlank(requestVo.getGameName())) {
				query.setParameter("gameName", requestVo.getGameName());
			}
			if(StringUtils.isNotBlank(requestVo.getTournamentShortName())) {
				query.setParameter("tournamentShortName", requestVo.getTournamentShortName());
			}
			if(requestVo.getHighlight() != null) {
				query.setParameter("highlight", requestVo.getHighlight());
			}
			if(requestVo.getGameID() != null) {
				query.setParameter("gameId", requestVo.getGameID());
			}
			if(requestVo.getTournamentID() != null) {
				query.setParameter("tournamentID", requestVo.getTournamentID());
			}
		}
		
		if(requestVo.getStartIndex()!=null) {
			query.setFirstResult(requestVo.getStartIndex());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			query.setMaxResults(requestVo.getPageSize());
		}
		
		return query.getResultList();
	}
	
	private final static String JPQL_findAllResult = 
			"select new com.hkesports.matchticker.vo.getresult.ResultVo (" + 
			 "    g.id, g.enGameName, g.twGameName, g.gameUrl, g.team, " + 
			 "    s.id, s.startTime, s.endTime, s.startTime as matchStartTime, " + 
			 " 	t.id, t.tournamentName as tournamentName, " + 
			 "	t.tournamentShortName as tournamentShortName, t.tournamentSiteUrl as tournamentSiteURL, " + 
			 "    s.results as matchResult, s.matchArchiveUrl as matchArchiveURL " + 
			 ")" + 
			 "from Schedule as s " + 
			 "join s.tournament as t " + 
			 "join s.game as g " + 
			 "where s.results is not null ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ResultVo> findAllResult(RequestVo requestVo) {
		StringBuilder jpql = new StringBuilder(JPQL_findAllResult);
		if(requestVo != null) {
			if(requestVo.getHighlight() != null) {
				jpql.append(" and s.highlight=:highlight ");
			}
			if(StringUtils.isNotBlank(requestVo.getGameName())) {
				jpql.append(" and (s.game.enGameName=:gameName or s.game.twGameName=:gameName) ");
			}
			if(StringUtils.isNotBlank(requestVo.getTournamentShortName())) {
				jpql.append(" and t.tournamentShortName=:tournamentShortName ");
			}
			if(requestVo.getGameID() != null) {
				jpql.append(" and s.game.id=:gameId ");
			}
			if(requestVo.getTournamentID() != null) {
				jpql.append(" and s.tournament.id=:tournamentID ");
			}
		}
		jpql.append("order by s.startTime desc, s.endTime desc ");
		Query query = entityManager.createQuery(jpql.toString());
		if(requestVo != null) {
			if(StringUtils.isNotBlank(requestVo.getGameName())) {
				query.setParameter("gameName", requestVo.getGameName());
			}
			if(StringUtils.isNotBlank(requestVo.getTournamentShortName())) {
				query.setParameter("tournamentShortName", requestVo.getTournamentShortName());
			}
			if(requestVo.getHighlight() != null) {
				query.setParameter("highlight", requestVo.getHighlight());
			}
			if(requestVo.getGameID() != null) {
				query.setParameter("gameId", requestVo.getGameID());
			}
			if(requestVo.getTournamentID() != null) {
				query.setParameter("tournamentID", requestVo.getTournamentID());
			}
		}
		
		if(requestVo.getStartIndex()!=null) {
			query.setFirstResult(requestVo.getStartIndex());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			query.setMaxResults(requestVo.getPageSize());
		}
		
		return query.getResultList();
	}

	private final static String JPQL_findAllLeaguetable = 
			"select new com.hkesports.matchticker.vo.getleaguetable.TournamentVo (" + 
			"    t.id, t.tournamentName as tournamentName, t.tournamentShortName as tournamentShortName, " + 
			"    t.tournamentSiteUrl as tournamentSiteURL, g.id, t.tournamentFromDate as tournamentFromDate, " + 
			"    t.tournamentToDate as tournamentToDate, g.enGameName, g.twGameName, g.gameUrl, g.team " + 
			")" + 
			"from Tournament as t " + 
			"join t.game as g ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TournamentVo> findAllLeaguetable(RequestVo requestVo) {
		StringBuilder _jpql = new StringBuilder(JPQL_findAllLeaguetable);
		if(requestVo.getGameID() != null) {
			_jpql.append(" and t.game.id=:gameID ");
		}
		if(requestVo.getTournamentID() != null) {
			_jpql.append(" and t.id=:tournamentID ");
		}
		_jpql.append("and t.tournamentCompetitionSystem not in :tournamentCompetitionSystem ");
		_jpql.append("order by t.tournamentToDate desc, t.tournamentFromDate desc ");
		
		String jpql =  _jpql.toString();
		if(jpql.contains("and")) {
			jpql = jpql.replaceFirst("and", "where");
		}
		Query query = entityManager.createQuery(StringUtils.isNotBlank(jpql) ? jpql : JPQL_findAllLeaguetable);
		if(requestVo.getGameID() != null) {
			query.setParameter("gameID", requestVo.getGameID());
		}
		if(requestVo.getTournamentID() != null) {
			query.setParameter("tournamentID", requestVo.getTournamentID());
		}
		query.setParameter("tournamentCompetitionSystem", Arrays.asList(CompetitionSystemEnum.GK.getValue(), CompetitionSystemEnum.RK.getValue(), CompetitionSystemEnum.DE.getValue()));
		if(requestVo.getStartIndex()!=null) {
			query.setFirstResult(requestVo.getStartIndex());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			query.setMaxResults(requestVo.getPageSize());
		}
		return query.getResultList();
	}
	
	private final static String SQL_updateSupportCount = "update schedule s set " +
			"s.a_side_support_count = s.a_side_support_count + :aTeamCount ," +
			"s.b_side_support_count = s.b_side_support_count + :bTeamCount " +
			"where s.id = :matchId";
	
	@Override
	public int updateSupportCount(Long matchId, int aTeamCount, int bTeamCount) {
		if(matchId==null) {
			return 0;
		}
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_updateSupportCount);
		queryObj.setParameter("matchId", matchId);
		queryObj.setParameter("aTeamCount", aTeamCount);
		queryObj.setParameter("bTeamCount", bTeamCount);
		return queryObj.executeUpdate();
	}
	
	private final static String SQL_findAllLastEncounter = 
			"select @encounternumber encounterNumber, " + 
			"case when s.team_a_id = :teamId then substring_index(s.results, ':', 1) " + 
			"when s.team_b_id = :teamId then substring_index(s.results, ':', -1) end score, " + 
			"@encounternumber\\:=@encounternumber+1 " + 
			"from schedule s, (select @encounternumber\\:=0) rc, schedule s1 " + 
			"where s1.end_time > s.end_time and s1.id = :matchId " + 
			"and s.team_a_id in (s1.team_a_id, s1.team_b_id) and s.team_b_id in (s1.team_a_id, s1.team_b_id) " + 
			"and s.results is not null " + 
			"order by s.end_time desc " + 
			"limit 3 ";
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T>  findAllLastEncounter(Class<T> clazz, Long matchId, Long teamId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findAllLastEncounter);
		queryObj.setResultTransformer(Transformers.aliasToBean(clazz));
		queryObj.setParameter("matchId", matchId);
		queryObj.setParameter("teamId", teamId);
		addScalars(clazz, queryObj);
		return queryObj.list();
	}
	
	private final static String SQL_findAllRecentPerformance = 
			"select s.id as matchid, " + 
			"s.results as matchresult, " + 
			"s.start_time matchstarttime, g.team " + 
			"from schedule s, schedule s1, game g " + 
			"where s1.end_time > s.end_time " + 
			"and s1.id = :matchId and :teamId in (s.team_a_id, s.team_b_id) " + 
			"and s.results is not null and s1.game_id = g.id " + 
			"order by s.end_time desc " + 
			"limit 3 ";
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAllRecentPerformance(Class<T> clazz, Long matchId, Long teamId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findAllRecentPerformance);
		queryObj.setResultTransformer(Transformers.aliasToBean(clazz));
		queryObj.setParameter("matchId", matchId);
		queryObj.setParameter("teamId", teamId);
		addScalars(clazz, queryObj);
		return queryObj.list();
	}
	
	private final static String Sql_findAllLOLGamesByMatchId = 
			"SELECT sg.game_number as gameNumber, sg.id as gameID, sg.winner_id as winnerID, " +
			"sg.game_creation as gameCreation, sg.game_length as gameLength, sg.tournament_round as tournamentRound, " +
			"sgp1.player_id as firstBloodPlayerID, " +
			"sgp2.player_id as firstTowerPlayerID, " +
			"sgp3.player_id as firstInhibitorPlayerID " +
			"FROM schedule_game sg " +
			"left join schedule_game_player_detail sgp1 on sgp1.schedule_game_id = sg.id and sgp1.first_blood_kill = :first " +
			"left join schedule_game_player_detail sgp2 on sgp2.schedule_game_id = sg.id and sgp2.first_tower_kill = :first " +
			"left join schedule_game_player_detail sgp3 on sgp3.schedule_game_id = sg.id and sgp2.first_inhibitor_kill = :first " +
			"where sg.schedule_id = :matchId";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.getmatchstatistics.GameVo> findAllLOLGamesByMatchId(Long matchId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(Sql_findAllLOLGamesByMatchId);
		ResultTransformer transformer = Transformers.aliasToBean(com.hkesports.matchticker.vo.getmatchstatistics.GameVo.class);
		String[] scalarColumns = {"gameNumber", "gameID", "winnerID", "gameCreation", "gameLength", "tournamentRound", "firstBloodPlayerID", "firstTowerPlayerID", "firstInhibitorPlayerID"};
		addScalars(com.hkesports.matchticker.vo.getmatchstatistics.GameVo.class, queryObj, scalarColumns);
		queryObj.setResultTransformer(transformer);
		queryObj.setParameter("matchId", matchId);
		queryObj.setParameter("first", 1);//true
		return queryObj.list();
	}

	private final static String JPQL_findAllDota2GamesByMatchId = 
			"select new com.hkesports.matchticker.vo.getmatchstatistics.GameVo (" + 
			"	   sg.gameNumber, sg.id, sg.gameLength, sg.lobbyType, sg.humanPlayers, " + 
			"	   sg.positiveVotes, sg.negativeVote, sg.gameMode, sg.firstBloodTime " + 
			")" + 
			"from ScheduleGame sg " + 
			"where sg.schedule.id =:matchId ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameVo> findAllDota2GamesByMatchId(Long matchId) {
		Query queryObj = entityManager.createQuery(JPQL_findAllDota2GamesByMatchId);
		queryObj.setParameter("matchId", matchId);
		return queryObj.getResultList();
	}
	
	private final static String SQL_findAllMatchConteststatus = 
			"select sgd.* , " + 
			"	round(sgd.guess_count / if(sgd.totalguesscount, sgd.totalguesscount, 1), 2) * 100 as contestantGuessingRate " + 
			"from ( " + 
			"	select sgd.team_id as id, sgd.guess_count, " + 
			"	(select sum(if(sgd2.guess_count is null, 0, sgd2.guess_count)) from schedule_game_detail sgd2 where sgd2.schedule_game_id = sgd.schedule_game_id) as totalguesscount, " + 
			"	case when s.team_a_id = sgd.team_id then 0 when s.team_b_id = sgd.team_id then 1 else null end as contestantnumber " + 
			"	from schedule_game_detail sgd " + 
			"	inner join schedule_game sg on sg.id = sgd.schedule_game_id " + 
			"	inner join schedule s on s.id = sg.schedule_id " + 
			"	where s.id = :matchId and sg.game_number = :gameNumber " + 
			") sgd ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ContestantsVo> findAllMatchConteststatus(Long matchId, Short gameNumber) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findAllMatchConteststatus);
		queryObj.setResultTransformer(Transformers.aliasToBean(ContestantsVo.class));
		queryObj.setParameter("matchId", matchId);
		queryObj.setParameter("gameNumber", gameNumber);
		addScalars(ContestantsVo.class, queryObj);
		return queryObj.list();
	}
	
	private final static String SQL_findAllGuessRecord = 
			"select year(s.start_time) year, month(s.start_time) month, day(s.start_time) day, " + 
			"	s.id as matchid, s.start_time as matchstarttime, " + 
			"	t.id as tournamentid, t.tournament_name as tournamentname, " + 
			"	t.tournament_short_name as tournamentshortname, t.tournament_site_url as tournamentsiteurl, " + 
			"	g.team " + 
			"from schedule s " + 
			"inner join tournament t on t.id = s.tournament_id " + 
			"inner join game g on g.id = s.game_id " + 
			"where exists ( " + 
			"	select gl.id from guess_log gl " + 
			"	where gl.user_type = :userType and user_id = :userId " + 
			"	and s.id = gl.match_id " + 
			") and year(s.start_time) = :year and month(s.start_time) = :month " + 
			"order by s.start_time, t.id, s.id ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RecordVo> findAllScheduleByGuessRecord(Long userId, UserTypeEnum userType, Integer year, Integer month) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findAllGuessRecord);
		queryObj.setResultTransformer(Transformers.aliasToBean(RecordVo.class));
		queryObj.setParameter("userId", userId);
		queryObj.setParameter("userType", userType.name());
		if(year==null || year==0) {
			queryObj.setParameter("year", Calendar.getInstance().get(Calendar.YEAR));
		} else {
			queryObj.setParameter("year", year);
		}
		if(month==null || month==0) {
			queryObj.setParameter("month", Calendar.getInstance().get(Calendar.MONTH));
		} else {
			queryObj.setParameter("month", month);
		}
		addScalarsExclude(RecordVo.class, queryObj);
		return queryObj.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleVo> findAllScheduleVoByTournamentId(Long tournamentId, UserHa userHa) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select new com.hkesports.matchticker.vo.gettournamentdetails.ScheduleVo (");
		jpql.append(" 	g.id, g.enGameName, g.twGameName, g.gameUrl, s.id, s.startTime, ");
		jpql.append("	(case when sysdate() < s.startTime then 'Feture' when sysdate() between s.startTime and s.endTime then 'Live' when sysdate() > s.endTime then 'Ended' else '' end) as matchStatus, ");
		jpql.append("	t.id, t.tournamentName, t.tournamentShortName, t.tournamentSiteUrl, s.matchLiveUrl, s.maxGames, ");
		jpql.append("	s.status, g.team ");
		if(userHa != null) {
			jpql.append(", (case when(select count(id) from SubscriptionSetting where subscriptionKey = s.id and subscriptionType=:subscriptionType and userId=:userId and userType=:userType) > 0 then true else false end) as matchSubscriptionStatus");
		}
		jpql.append(")");
		jpql.append("from Schedule as s ");
		jpql.append("join s.tournament as t ");
		jpql.append("join s.game as g ");
		jpql.append("where t.id=:tournamentId ");
		Query query = entityManager.createQuery(jpql.toString());
		if(userHa != null) {
			query.setParameter("subscriptionType", SubscriptionTypeEnum.MATCH);
			query.setParameter("userId", userHa.getUserId());
			query.setParameter("userType", userHa.getUserType());
		}
		query.setParameter("tournamentId", tournamentId);
		return query.getResultList();
	}
}
