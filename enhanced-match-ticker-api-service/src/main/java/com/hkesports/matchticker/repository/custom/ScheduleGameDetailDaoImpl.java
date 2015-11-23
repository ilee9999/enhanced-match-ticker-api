package com.hkesports.matchticker.repository.custom;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.vo.getmatchstatistics.GameTeamVo;
import com.hkesports.matchticker.vo.getpersonalrecord.GameContestantVo;

public class ScheduleGameDetailDaoImpl extends BasicDaoImpl implements ScheduleGameDetailDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	/*
	public final static String JPQL_findGameTeamsByGameId = "select new com.hkesports.matchticker.vo.getmatchstatistics.GameTeamVo ( "
			  + "s.team.id, s.id, s.towerKills, s.inhibitorKills, s.baronKills, s.dragonKills, s.vilemawKills, s.dominionVictoryScore, "
			  + "s.firstBaron, s.firstDragon"
			  + ") "
			  + "from ScheduleGameDetail as s "
			  + "where s.scheduleGame.id=:gameId ";
	*/
	private final static String SQL_findGameTeamsByGameId = 
			"select sgd.*, " + 
			"	round(sgd.guess_count / if(sgd.totalguesscount, sgd.totalguesscount, 1), 2) * 100 as teamGuessingRate " + 
			"from ( " + 
			"	select sgd1.team_id as id, sgd1.id as scheduleGameDetailId, sgd1.tower_kills as towerkills, " + 
			"		   sgd1.inhibitor_kills as inhibitorkills, sgd1.baron_kills as baronkills, " + 
			"		   sgd1.dragon_kills as dragonkills, sgd1.vilemaw_kills as vilemawkills, " + 
			"	       sgd1.dominion_victory_score as dominionvictoryscore, sgd1.first_baron as firstbaron, " + 
			"	       sgd1.first_dragon as firstdragon, if(sgd1.guess_count, sgd1.guess_count, 0) guess_count, " + 
			"	       (select sum(if(sgd2.guess_count is null, 0, sgd2.guess_count)) from schedule_game_detail sgd2 where sgd2.schedule_game_id = sgd1.schedule_game_id) as totalguesscount, " +
			"		   sgd1.tower_status as towerStatus, sgd1.barracks_status as barracksStatus " +
			"	from schedule_game_detail sgd1 " + 
			"	where sgd1.schedule_game_id = :scheduleGameId " + 
			") sgd ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameTeamVo> findGameTeamsByGameId(Long scheduleGameId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findGameTeamsByGameId);
		ResultTransformer transformer = Transformers.aliasToBean(GameTeamVo.class);
		addScalars(GameTeamVo.class, queryObj);
		queryObj.setResultTransformer(transformer);
		queryObj.setParameter("scheduleGameId", scheduleGameId);
		return queryObj.list();
	}

	private final static String SQL_updateGuessCount = "update schedule_game_detail sgd " + 
			"inner join schedule_game sg on sg.id = sgd.schedule_game_id and sg.schedule_id = :matchId and sg.game_number = :gameNumber " + 
			"set sgd.guess_count = ifnull(sgd.guess_count, 0) + 1, sgd.update_date=:updateDate " + 
			"where sgd.team_id = :contestantID ";
	
	@Override
	public int updateGuessCount(Long matchId, Integer gameNumber, Long contestantID, Date updateDate) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_updateGuessCount);
		queryObj.setParameter("matchId", matchId);
		queryObj.setParameter("gameNumber", gameNumber);
		queryObj.setParameter("contestantID", contestantID);
		queryObj.setParameter("updateDate", updateDate);
		return queryObj.executeUpdate();
	}

	private final static String SQL_insertForMakeGuess = "insert into schedule_game_detail(team_id, schedule_game_id, guess_count, create_date, create_by) " +
			"values(:teamId, :scheduleGameId, 1, :createDate, :createBy)";
	
	public int insertForMakeGuess(Long scheduleGameId, Long contestantID, Date createDate) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_insertForMakeGuess);
		queryObj.setParameter("scheduleGameId", scheduleGameId);
		queryObj.setParameter("teamId", contestantID);
		queryObj.setParameter("createDate", createDate);
//		queryObj.setParameter("createBy", "SYSTEM");
		return queryObj.executeUpdate();
	}
	
	private final static String SQL_findAllGuessGameDetailRecord = 
			"select s.contestantNumber, s.ha, " + 
			"	round(s.guess_count / if(s.totalguesscount, s.totalguesscount, 1), 2) * 100 as contestantGuessingRate " + 
			"from ( " + 
			"	select " + 
			"		ifnull(gl.ha, 0) ha, " + 
			"		sgd.guess_count, " + 
			"		case when s.team_a_id = sgd.team_id then 0 when s.team_b_id = sgd.team_id then 1 else null end as contestantNumber, " + 
			"		(select sum(ifnull(sgd2.guess_count, 0)) from schedule_game_detail sgd2 where sgd2.schedule_game_id = sgd.schedule_game_id) as totalguesscount " + 
			"	from schedule_game_detail sgd " + 
			"	inner join schedule_game sg on sg.id = sgd.schedule_game_id and sg.id = :gameId " + 
			"	inner join schedule s on s.id = sg.schedule_id " + 
			"	left join ( " + 
			"		select gl.match_id, gl.game_number, gl.contestant_id, sum(gl.ha) as ha " + 
			"		from guess_log gl " + 
			"		where  gl.user_type = :userType and gl.user_id = :userId " + 
			"		group by gl.match_id, gl.game_number, gl.contestant_id " + 
			"	) gl on gl.match_id = s.id and gl.game_number = sg.game_number " + 
			"		and gl.contestant_id = sgd.team_id " + 
			") s";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameContestantVo> findAllGuessGameDetailRecord(Long userId, UserTypeEnum userType, Long gameId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findAllGuessGameDetailRecord);
		queryObj.setResultTransformer(Transformers.aliasToBean(GameContestantVo.class));
		queryObj.setParameter("gameId", gameId);
		queryObj.setParameter("userId", userId);
		queryObj.setParameter("userType", userType.name());
		addScalars(GameContestantVo.class, queryObj);
		return queryObj.list();
	}
}
