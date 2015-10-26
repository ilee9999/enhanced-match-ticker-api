package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.GameTypeEnum;

public class TeamDaoImpl extends BasicDaoImpl implements TeamDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String sql_getAllTeamVoByMatchId = 
			"select t.id as ID, t.team_full_name as teamName, " +
			"t.team_name as teamAronym, t.country as teamCountry, t.team_url as teamURL, " +
			"t.logo_url as teamLogoURLThumbnail, t.logo_url as teamLogoURLLarge, t.logo_url as teamLogoURLOriginal, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Win') teamWins, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Fail') teamLosses, " +
			"case when s.team_a_id = t.id then 0 when s.team_b_id = t.id then 1 else null end as teamNumber, " +
			"case when s.team_a_id = t.id then s.a_side_support_count when s.team_b_id = t.id then s.b_side_support_count else 0 end as teamSupportCount " +
			"from schedule s "+
			"left join team t on s.team_a_id = t.id or s.team_b_id = t.id " +
			"where s.id = :matchId ";
	
	private final static String sql_getRankingTeamVo = 
			"select s.*, "+
            "    case when tgms.team_game_id is null or teamGlobalRank = tgms.rank then 0 when teamGlobalRank > tgms.rank then 1 else -1 end as teamGlobalTrend,  "+
            "    case when tcgms.team_contintent_game_id is null or teamContinentRank = tcgms.rank then 0 when teamContinentRank > tcgms.rank then 1 else -1 end as teamContinentTrend  "+
            "from ( "+
			"	select t.id as ID, t.team_full_name as teamName, s.game_id, s.game_type, "+
			"		t.team_name as teamAronym, t.country as teamCountry, t.team_url as teamURL,   "+
			"		t.logo_url as teamLogoURLThumbnail, t.logo_url as teamLogoURLLarge, t.logo_url as teamLogoURLOriginal,   "+
			"		(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Win') teamWins,   "+
			"		(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Fail') teamLosses,   "+
			"		FIND_IN_SET(tgs.score, (SELECT GROUP_CONCAT(tgs1.score ORDER BY tgs1.score DESC) FROM team_game_score tgs1 WHERE tgs1.game_id = s.game_id)) as teamGlobalRank,  "+
			"		FIND_IN_SET(tcgs.score, (SELECT GROUP_CONCAT(tcgs1.score ORDER BY tcgs1.score DESC) FROM team_continent_game_score tcgs1 where tcgs1.contintent_game_id = cg.id)) as teamContinentRank,  "+
			"		tgs.score as teamScore, tgs.id as tgs_id, tcgs.id as tcgs_id, "+
			"		c.en_continent_name as enContinentName,  "+
			"		c.tw_continent_name as twContinentName,   "+
			"		case when s.team_a_id = t.id then 0 when s.team_b_id = t.id then 1 else null end as teamNumber,   "+
			"		case when s.team_a_id = t.id then s.a_side_support_count when s.team_b_id = t.id then s.b_side_support_count else 0 end as teamSupportCount "+
            "    from schedule s  "+
			"	left join team t on s.team_a_id = t.id or s.team_b_id = t.id   "+
			"	left join team_game_score tgs on tgs.team_id = s.id and tgs.game_id = s.game_id "+
			"	left join continent_game cg on cg.game_id = s.game_id "+
			"	left join team_continent_game_score tcgs on tcgs.contintent_game_id = cg.id and tcgs.team_id = s.id "+
            "   left join continent c on c.id = cg.continent_id "+
            "    where s.id = :matchId "+
            ") s "+
			"left join team_game_monthly_score tgms on tgms.team_game_id = s.tgs_id  "+
			"	and tgms.year = date_format(DATE_SUB(now(), INTERVAL 1 MONTH),'%Y') "+
            "    and tgms.month = date_format(DATE_SUB(now(), INTERVAL 1 MONTH),'%c') "+
			"left join team_continent_game_monthly_score tcgms on tcgms.team_contintent_game_id = s.tcgs_id "+
            "    and tcgms.year = date_format(DATE_SUB(now(), INTERVAL 1 MONTH),'%Y') "+
            "    and tcgms.month = date_format(DATE_SUB(now(), INTERVAL 1 MONTH),'%c') ";
	
	private final static String sql_getLeaguetableTeamVo = 
			"select t.id as ID, t.team_full_name as teamName, " +
			"t.team_name as teamAronym, t.country as teamCountry, t.team_url as teamURL, " +
			"t.logo_url as teamLogoURLThumbnail, t.logo_url as teamLogoURLLarge, t.logo_url as teamLogoURLOriginal, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Win') teamWins, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Fail') teamLosses, " +
			"null as teamScore, null as position, null as trend, " + // column not sure
			"case when s.team_a_id = t.id then 0 when s.team_b_id = t.id then 1 else null end as teamNumber, " +
			"case when s.team_a_id = t.id then s.a_side_support_count when s.team_b_id = t.id then s.b_side_support_count else 0 end as teamSupportCount " +
			"from schedule s "+
			"left join team t on s.team_a_id = t.id or s.team_b_id = t.id " +
			"where s.id = :matchId ";
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getAllTeamVoByMatchId(Long matchId, Class<T> t) {
		String sql = sql_getAllTeamVoByMatchId;
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql);
		queryObj.setResultTransformer(Transformers.aliasToBean(t));
		queryObj.setParameter("matchId", matchId);
		addScalars(t, queryObj);
		return queryObj.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.getranking.TeamVo> getRankingTeamVo(GameTypeEnum gameType, Long matchId) {
		String sql = sql_getRankingTeamVo;
		if(gameType != null) sql += "and s.game_type = :gameType ";
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql);
		ResultTransformer transformer = Transformers.aliasToBean(com.hkesports.matchticker.vo.getranking.TeamVo.class);
		addScalars(com.hkesports.matchticker.vo.getranking.TeamVo.class, queryObj);
		queryObj.setResultTransformer(transformer);
		if(gameType != null) queryObj.setParameter("gameType", gameType.name());
		queryObj.setParameter("matchId", matchId);
		return queryObj.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.getleaguetable.TeamVo> getLeaguetableTeamVo(GameTypeEnum gameType, Long matchId) {
		String sql = sql_getLeaguetableTeamVo;
		if(gameType != null) sql += "and s.game_type = :gameType ";
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql);
		ResultTransformer transformer = Transformers.aliasToBean(com.hkesports.matchticker.vo.getleaguetable.TeamVo.class);
		addScalars(com.hkesports.matchticker.vo.getleaguetable.TeamVo.class, queryObj);
		queryObj.setResultTransformer(transformer);
		if(gameType != null) queryObj.setParameter("gameType", gameType.name());
		queryObj.setParameter("matchId", matchId);
		return queryObj.list();
	}

}
