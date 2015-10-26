package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.RequestVo.OptionVo;
import com.hkesports.matchticker.vo.getleaguetable.TournamentVo;
import com.hkesports.matchticker.vo.getresult.ResultVo;
import com.hkesports.matchticker.vo.getschedule.ResultScheduleVo;

public class ScheduleDaoImpl extends BasicDaoImpl implements ScheduleDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	
	public final static String JPQL_GetSchedule = "select new com.hkesports.matchticker.vo.getschedule.ResultScheduleVo ("
			 + "    g.id, g.enGameName, g.twGameName, g.gameUrl, "
			 + "    s.matchLiveUrl, g.maxGames, "
			 + "    s.id, s.startTime, s.endTime, "
			 + " (case when sysdate() < s.startTime then 'Feture' when sysdate() between s.startTime and s.endTime then 'Live' when sysdate() > s.endTime then 'Ended' else '' end) as matchStatus, "
			 + " 	t.id, t.touramentName as tournamentName, "
			 + "	t.touramentShortName as tournamentShortName, t.touramentSiteUrl as tournamentSiteURL, "
			 + "    s.gameType "
			 + ")"
			 + "from Schedule as s "
			 + "left outer join s.tourament as t "
			 + "inner join s.game as g "
			 + "where s.results is null ";
	
	public final static String JPQL_GetResult = "select new com.hkesports.matchticker.vo.getresult.ResultVo ("
			 + "    g.id, g.enGameName, g.twGameName, g.gameUrl, "
			 + "    s.id, s.startTime, s.endTime, s.startTime as matchStartTime, "
			 + " 	t.id, t.touramentName as tournamentName, "
			 + "	t.touramentShortName as tournamentShortName, t.touramentSiteUrl as tournamentSiteURL, "
			 + "    s.results as matchResult, s.matchArchiveUrl as matchArchiveURL, s.gameType "
			 + ")"
			 + "from Schedule as s "
			 + "left outer join s.tourament as t "
			 + "inner join s.game as g "
			 + "where s.results is not null ";
	
	public final static String JPQL_GetLeaguetable = "select new com.hkesports.matchticker.vo.getleaguetable.TournamentVo ("
			+ "    t.id, t.touramentName as tournamentName, t.touramentShortName as tournamentShortName, "
			+ "    t.touramentSiteUrl as tournamentSiteURL, g.id, t.touramentFromDate as tournamentFromDate, "
			+ "    t.touramentToDate as tournamentToDate, g.enGameName, g.twGameName, g.gameUrl, s.id "
			 + ")"
			 + "from Schedule as s "
			 + "left outer join s.tourament as t "
			 + "inner join s.game as g ";
	
	
	public final static String SQL_updateSupportCount = "update schedule s set " +
			"s.a_side_support_count = (select count(st1.id) from support_team st1 where st1.match_id = s.id and st1.team_id = s.team_a_id) ," +
			"s.b_side_support_count = (select count(st2.id) from support_team st2 where st2.match_id = s.id and st2.team_id = s.team_b_id)" +
			"where s.id = :matchId";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ResultScheduleVo> getSchedule(RequestVo requestVo) {
		OptionVo queryVo = requestVo.getScheduleFilterVo();
		StringBuilder jpql = new StringBuilder(JPQL_GetSchedule);
		if(queryVo!=null) {
			if(queryVo.getHighlight()!=null) {
				jpql.append(" and s.highlight=:highlight ");
			}
			if(StringUtils.isNotBlank(queryVo.getGameName())) {
				jpql.append(" and s.gameType=:gameName ");
			}
			if(StringUtils.isNotBlank(queryVo.getTournamentShortName())) {
				jpql.append(" and t.touramentShortName=:touramentShortName ");
			}
		}
		jpql.append("order by s.endTime desc, s.startTime desc ");
		Query query = entityManager.createQuery(jpql.toString());
		if(queryVo!=null) {
			if(StringUtils.isNotBlank(queryVo.getGameName())) {
				query.setParameter("gameName", GameTypeEnum.valueOf(queryVo.getGameName()));
			}
			if(StringUtils.isNotBlank(queryVo.getTournamentShortName())) {
				query.setParameter("touramentShortName", queryVo.getTournamentShortName());
			}
			if(queryVo.getHighlight()!=null) {
				query.setParameter("highlight", queryVo.getHighlight());
			}
		}
		
		if(requestVo.getPageNumber()!=null && requestVo.getPageNumber() > 0) {
			query.setFirstResult(requestVo.getPageNumber());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			query.setMaxResults(requestVo.getPageSize());
		}
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ResultVo> getResult(RequestVo requestVo) {
		OptionVo queryVo = requestVo.getScheduleFilterVo();
		StringBuilder jpql = new StringBuilder(JPQL_GetResult);
		if(queryVo!=null) {
			if(queryVo.getHighlight()!=null) {
				jpql.append(" and s.highlight=:highlight ");
			}
			if(StringUtils.isNotBlank(queryVo.getGameName())) {
				jpql.append(" and s.gameType=:gameName ");
			}
			if(StringUtils.isNotBlank(queryVo.getTournamentShortName())) {
				jpql.append(" and t.touramentShortName=:touramentShortName ");
			}
		}
		jpql.append("order by s.endTime desc, s.startTime desc ");
		Query query = entityManager.createQuery(jpql.toString());
		if(queryVo!=null) {
			if(StringUtils.isNotBlank(queryVo.getGameName())) {
				query.setParameter("gameName", GameTypeEnum.valueOf(queryVo.getGameName()));
			}
			if(StringUtils.isNotBlank(queryVo.getTournamentShortName())) {
				query.setParameter("touramentShortName", queryVo.getTournamentShortName());
			}
			if(queryVo.getHighlight()!=null) {
				query.setParameter("highlight", queryVo.getHighlight());
			}
		}
		
		if(requestVo.getPageNumber()!=null && requestVo.getPageNumber() > 0) {
			query.setFirstResult(requestVo.getPageNumber());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			query.setMaxResults(requestVo.getPageSize());
		}
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TournamentVo> getLeaguetable(RequestVo requestVo) {
		String jpql = StringUtils.EMPTY;
		StringBuilder _jpql = new StringBuilder(JPQL_GetLeaguetable);
		if(requestVo.getGameID() != null) {
			_jpql.append(" and s.gameType=:gameType ");
		}
		if(requestVo.getTournamentID() != null) {
			_jpql.append(" and t.id=:tournamentID ");
		}
		_jpql.append("order by s.endTime desc, s.startTime desc ");
		jpql = _jpql.toString();
		if(jpql.contains("and")) {
			jpql = jpql.replaceFirst("and", "where");
		}
		Query query = entityManager.createQuery(StringUtils.isNotBlank(jpql) ? jpql : JPQL_GetLeaguetable);
		if(requestVo.getGameID() != null) {
			query.setParameter("gameType", requestVo.getGameID());
		}
		if(requestVo.getTournamentID() != null) {
			query.setParameter("tournamentID", requestVo.getTournamentID());
		}
		
		if(requestVo.getPageNumber()!=null && requestVo.getPageNumber() > 0) {
			query.setFirstResult(requestVo.getPageNumber());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			query.setMaxResults(requestVo.getPageSize());
		}
		return query.getResultList();
	}
	
	@Override
	public int updateSupportCount(Long matchId) {
		if(matchId==null) {
			return 0;
		}
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_updateSupportCount);
		queryObj.setParameter("matchId", matchId);
		return queryObj.executeUpdate();
	}
}
