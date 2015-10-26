package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.vo.RequestVo;

public class GameDaoImpl extends BasicDaoImpl implements GameDaoCustom {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.getmatchstatistics.GameVo> findGamesByMatchId(GameTypeEnum gameType, Long matchId) {
		String sql = "SELECT sg.game_number as gameNumber, sg.id as gameID, sg.winner_id as winnerID, " +
				"sg.game_creation as gameCreation, sg.game_length as gameLength, sg.tournament_round as tournamentRound, " +
				"sgp1.player_id as firstBloodPlayerID, " +
				"sgp2.player_id as firstTowerPlayerID, " +
				"sgp3.player_id as firstInhibitorPlayerID " +
				"FROM match_ticker.schedule_game sg " +
				"left join match_ticker.schedule_game_player_detail sgp1 on sgp1.schedule_game_id = sg.id and sgp1.first_blood_kill = 1 " +
				"left join match_ticker.schedule_game_player_detail sgp2 on sgp2.schedule_game_id = sg.id and sgp2.first_tower_kill = 1 " +
				"left join match_ticker.schedule_game_player_detail sgp3 on sgp3.schedule_game_id = sg.id and sgp2.first_inhibitor_kill = 1 " +
				"where sg.game_type = :gameType and sg.schedule_id = :matchId";
		
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql.toString());
		ResultTransformer transformer = Transformers.aliasToBean(com.hkesports.matchticker.vo.getmatchstatistics.GameVo.class);
		addScalars(com.hkesports.matchticker.vo.getmatchstatistics.GameVo.class, queryObj);
		queryObj.setResultTransformer(transformer);
		queryObj.setParameter("gameType", gameType.name());
		queryObj.setParameter("matchId", matchId);
		return queryObj.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.getranking.GameVo> getRankingGameVo(RequestVo requestVo) {
		String initJpql = "select new com.hkesports.matchticker.vo.getranking.GameVo ( "
					+ "	 s.id, g.id, g.enGameName, g.twGameName, g.gameUrl "
					+ ") "
					+ "from Schedule as s "
					+ "left outer join s.tourament as t "
					+ "join s.game as g ";
		StringBuilder _jpql = new StringBuilder(initJpql);
		if(requestVo.getGameID() != null) {
			_jpql.append(" and s.gameType=:gameType ");
		}
		if(requestVo.getTournamentID() != null) {
			_jpql.append(" and t.id=:tournamentID ");
		}
		_jpql.append("order by s.endTime desc, s.startTime desc ");
		String jpql = _jpql.toString();
		if(jpql.contains("and")) {
			jpql = jpql.replaceFirst("and", "where");
		}
		Query queryObj = entityManager.createQuery(jpql);
		if(requestVo.getGameID() != null) {
			queryObj.setParameter("gameType", requestVo.getGameID());
		}
		if(requestVo.getTournamentID() != null) {
			queryObj.setParameter("tournamentID", requestVo.getTournamentID());
		}
		
		if(requestVo.getPageNumber()!=null && requestVo.getPageNumber() > 0) {
			queryObj.setFirstResult(requestVo.getPageNumber());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			queryObj.setMaxResults(requestVo.getPageSize());
		}
		return queryObj.getResultList();
	}
}
