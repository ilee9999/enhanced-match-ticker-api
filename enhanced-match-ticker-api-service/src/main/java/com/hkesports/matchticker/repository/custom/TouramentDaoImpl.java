package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.gettournamentlist.TournamentVo;

/**
 * @author manboyu
 *
 */
public class TouramentDaoImpl extends BasicDaoImpl implements TouramentDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TournamentVo> getTournamentlistByPast(boolean past, RequestVo requestVo) {
		StringBuilder sql = new StringBuilder();
		sql.append("select t.id as tournamentID, t.tourament_name as tournamentName, t.tourament_short_name as tournamentShortName, ");
		sql.append("	   t.tourament_site_url as tournamentSiteURL, t.tourament_from_date as tournamentStartDate, t.tourament_to_date as tournamentEndDate, ");
		sql.append("	   t.tourament_description as tournamentDescription, t.tourament_channel_url as tournamentChannelURL ");
		sql.append("from tourament t ");
		sql.append("where exists ( ");
		sql.append("	select a.id from ( ");
		GameTypeEnum gameType = requestVo.getGameID();
		if(gameType.equals(GameTypeEnum.LOL)){
			sql.append("	select t1.id, ").append(past ? "max" : "min").append("(s.end_time) as sTime from tourament t1 ");
		} else {
			// Dota 2的後台管理員會選擇那一聯賽是有價值, need fixed
			sql.append("	select t1.id, ").append(past ? "max" : "min").append("(s.start_time) as sTime from tourament t1 ");
		}
		sql.append("		join schedule s on s.tourament_id = t1.id ");
		sql.append("		where t1.game_type =:gameType ");
		sql.append("		and s.start_time is not null ");
		sql.append("		and date_format(s.start_time,'%Y-%m-%d') <> '1970-01-01' ");
		if(gameType.equals(GameTypeEnum.LOL)){
			sql.append("	and s.end_time is not null ");
			sql.append("	and date_format(s.end_time,'%Y-%m-%d') <> '1970-01-01' ");
		}
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
		queryObj.setParameter("gameType", gameType.name());
		if(requestVo.getPageNumber()!=null && requestVo.getPageNumber() > 0) {
			queryObj.setFirstResult(requestVo.getPageNumber());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			queryObj.setMaxResults(requestVo.getPageSize());
		}
		return queryObj.list();
	}
}
