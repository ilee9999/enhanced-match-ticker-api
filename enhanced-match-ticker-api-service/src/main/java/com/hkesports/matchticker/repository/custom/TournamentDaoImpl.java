package com.hkesports.matchticker.repository.custom;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.CompetitionSystemEnum;
import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.gettournamentlist.TournamentVo;

/**
 * @author manboyu
 *
 */
public class TournamentDaoImpl extends BasicDaoImpl implements TournamentDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TournamentVo> getTournamentlistByPast(boolean past, RequestVo requestVo) {
		StringBuilder sql = new StringBuilder();
		sql.append("select t.id as tournamentID, t.tournament_name as tournamentName, t.tournament_short_name as tournamentShortName, ");
		sql.append("	   t.tournament_site_url as tournamentSiteURL, t.tournament_from_date as tournamentStartDate, t.tournament_to_date as tournamentEndDate, ");
		sql.append("	   t.tournament_description as tournamentDescription, t.tournament_channel_url as tournamentChannelUrl, ");
		sql.append("	   t.tournament_competition_system as tournamentCompetitionSystem ");
		sql.append("from tournament t ");
		sql.append("where exists ( ");
		sql.append("	select a.id from ( ");
		
		sql.append("	select t1.id, ").append(past ? "max" : "min").append("(case when t1.game_type = :dota2Type then s.start_time else s.end_time end) as sTime from tournament t1 ");
	
//		GameTypeEnum gameType = requestVo.getGameID();
//		if(gameType.equals(GameTypeEnum.LOL)){
//			sql.append("	select t1.id, ").append(past ? "max" : "min").append("(s.end_time) as sTime from tournament t1 ");
//		} else {
//			// Dota 2的後台管理員會選擇那一聯賽是有價值, need fixed
//			sql.append("	select t1.id, ").append(past ? "max" : "min").append("(s.start_time) as sTime from tournament t1 ");
//		}
		sql.append("	join schedule s on s.tournament_id = t1.id ");
		if(requestVo.getGameID()!=null) {
			sql.append("	and s.game_id = :gameID ");
		}
		sql.append("	where s.start_time is not null ");
		sql.append("	and date_format(s.start_time,'%Y-%m-%d') <> '1970-01-01' ");
		
		sql.append("	and (t1.game_type <> :dota2Type or (s.end_time is not null ");
		sql.append("	and date_format(s.end_time,'%Y-%m-%d') <> '1970-01-01')) ");
		
		sql.append("		group by t1.id ");
		sql.append("	) as a ");
		sql.append("	where NOW() ").append(past ? ">" : "<").append(" sTime ");
		sql.append("	and a.id = t.id ");
		sql.append(") ");
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql.toString());
		ResultTransformer transformer = Transformers.aliasToBean(TournamentVo.class);
		addScalars(TournamentVo.class, queryObj);
		queryObj.setResultTransformer(transformer);
		
		if(requestVo.getGameID()!=null) {
			queryObj.setParameter("gameID", requestVo.getGameID());
		}
		queryObj.setParameter("dota2Type", GameTypeEnum.DOTA2.name());
		
		if(requestVo.getStartIndex()!=null) {
			queryObj.setFirstResult(requestVo.getStartIndex());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			queryObj.setMaxResults(requestVo.getPageSize());
		}
		return queryObj.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.getknockoutrtournamenttable.TournamentVo> getTournamentlist(
			RequestVo requestVo) {
		StringBuilder sql = new StringBuilder();
		sql.append("select t.id as tournamentID, t.tournament_name as tournamentName, t.tournament_short_name as tournamentShortName, ");
		sql.append("	   t.tournament_site_url as tournamentSiteURL, t.tournament_from_date as tournamentFromDate, t.tournament_to_date as tournamentToDate, ");
		sql.append("	   t.tournament_competition_system as tournamentCompetitionSystem, ");
		sql.append("	   g.en_game_name as enGameName, g.tw_game_name as twGameName, g.id as gameID, g.game_url as gameUrl, g.team ");
		sql.append("from tournament t ");
		sql.append("inner join game g on g.id = t.game_id ");
		if(requestVo.getGameID()!=null) {
			sql.append("and g.id=:gameID ");
		}
		
		sql.append("where t.tournament_competition_system in (:tournamentCompetitionSystem) ");
		
		if(requestVo.getTournamentID()!=null) {
			sql.append("and t.id=:tournamentID ");
		}
		
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql.toString());
		ResultTransformer transformer = Transformers.aliasToBean(com.hkesports.matchticker.vo.getknockoutrtournamenttable.TournamentVo.class);
		addScalars(com.hkesports.matchticker.vo.getknockoutrtournamenttable.TournamentVo.class, queryObj);
		queryObj.setResultTransformer(transformer);
		queryObj.setParameterList("tournamentCompetitionSystem", Arrays.asList(CompetitionSystemEnum.GK.getValue(), CompetitionSystemEnum.RK.getValue(), CompetitionSystemEnum.DE.getValue()));
		if(requestVo.getGameID()!=null) {
			queryObj.setParameter("gameID", requestVo.getGameID());
		}
		if(requestVo.getTournamentID()!=null) {
			queryObj.setParameter("tournamentID", requestVo.getTournamentID());
		}
		
		if(requestVo.getStartIndex()!=null) {
			queryObj.setFirstResult(requestVo.getStartIndex());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			queryObj.setMaxResults(requestVo.getPageSize());
		}
		return queryObj.list();
	}
}
