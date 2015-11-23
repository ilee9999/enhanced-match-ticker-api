package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.SubscriptionTypeEnum;
import com.hkesports.matchticker.model.basic.UserHa;
import com.hkesports.matchticker.utils.Const;
import com.hkesports.matchticker.vo.BasicTeamVo;
import com.hkesports.matchticker.vo.getknockoutrtournamenttable.ContestantsVo;
import com.hkesports.matchticker.vo.gettournamentdetails.TournamentContestantsVo;

public class TeamDaoImpl extends BasicDaoImpl implements TeamDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String sql_findAllTeamVoByMatchId = 
			"select t.id as ID, t.team_full_name as contestantName, " +
			"t.team_name as contestantAronym, t.country as contestantCountry, t.team_url as contestantURL, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Win') contestantWins, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Draw') contestantDraws, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Fail') contestantLosses, " +
			"case when s.team_a_id = t.id then 0 when s.team_b_id = t.id then 1 else null end as contestantNumber, " +
			"case when s.team_a_id = t.id then s.a_side_support_count when s.team_b_id = t.id then s.b_side_support_count else 0 end as contestantSupportCount, " +
			"concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_LARGE + "', t.team_icon_large) as contestantLogoURLLarge, " +
			"concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_SMALL + "', t.team_icon_small) as contestantLogoURLThumbnail " +
			"from schedule s "+
			"left join team t on t.id in (s.team_a_id, s.team_b_id) " +
			"left join admin a1 on a1.key =:key1 " +
			"left join admin a2 on a2.key =:key2 " +
			"where s.id = :matchId ";
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends BasicTeamVo> List<T> findAllTeamVoByMatchId(Long matchId, Class<T> t) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql_findAllTeamVoByMatchId);
		queryObj.setResultTransformer(Transformers.aliasToBean(t));
		queryObj.setParameter("matchId", matchId);
		queryObj.setParameter("key1", Const.ADMIN_KEY_ICON_DOMAIN);
		queryObj.setParameter("key2", Const.ADMIN_KEY_ICON_PATH_TEAM);
		addScalars(t, queryObj);
		return queryObj.list();
	}

	private final static String sql_findAllTeamVoByMatchIdAndUser = 
			"select t.id as ID, t.team_full_name as contestantName, " +
			"t.team_name as contestantAronym, t.country as contestantCountry, t.team_url as contestantURL, t.follower_number as contestantFollowerNumber, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Win') contestantWins, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Draw') contestantDraws, " +
			"(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Fail') contestantLosses, " +
			"case when s.team_a_id = t.id then 0 when s.team_b_id = t.id then 1 else null end as contestantNumber, " +
			"case when s.team_a_id = t.id then s.a_side_support_count when s.team_b_id = t.id then s.b_side_support_count else 0 end as contestantSupportCount, " +
			"{other_sql}" +
			"concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_LARGE + "', t.team_icon_large) as contestantLogoURLLarge, " +
			"concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_SMALL + "', t.team_icon_small) as contestantLogoURLThumbnail " +
			"from schedule s "+
			"left join team t on t.id in (s.team_a_id, s.team_b_id) " +
			"left join admin a1 on a1.key =:key1 " +
			"left join admin a2 on a2.key =:key2 " +
			"where s.id = :matchId ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.gettournamentdetails.ContestantsVo> findAllTeamVoByMatchIdOrUser(Long matchId, UserHa userHa) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = null;
		if(userHa != null) {
			String other_sql = "if((select count(id) from subscription_setting where subscription_key = t.id and subscription_type =:subscriptionType and user_id =:userId and user_type =:userType) > 0, 1, 0) as contestantSubscriptionStatus, ";
			queryObj = session.createSQLQuery(StringUtils.replace(sql_findAllTeamVoByMatchIdAndUser, "{other_sql}", other_sql));
			queryObj.setParameter("subscriptionType", SubscriptionTypeEnum.TEAM.name());
			queryObj.setParameter("userId", userHa.getUserId());
			queryObj.setParameter("userType", userHa.getUserType().name());
			addScalars(com.hkesports.matchticker.vo.gettournamentdetails.ContestantsVo.class, queryObj);
		} else {
			queryObj = session.createSQLQuery(StringUtils.replace(sql_findAllTeamVoByMatchIdAndUser, "{other_sql}", ""));
			addScalarsExclude(TournamentContestantsVo.class, queryObj, "contestantSubscriptionStatus");
		}
		queryObj.setParameter("matchId", matchId);
		queryObj.setParameter("key1", Const.ADMIN_KEY_ICON_DOMAIN);
		queryObj.setParameter("key2", Const.ADMIN_KEY_ICON_PATH_TEAM);
		queryObj.setResultTransformer(Transformers.aliasToBean(com.hkesports.matchticker.vo.gettournamentdetails.ContestantsVo.class));
		return queryObj.list();
	}

	private final static String sql_findAllRankingTeamVo = 
			"select s.*, " + 
			"	case when tgms.team_game_id is null or s.contestantglobalrank = tgms.rank then 0 when tgms.rank > s.contestantglobalrank then 1 else -1 end as contestantglobaltrend, " + 
			"	case when tcgms.team_continent_game_id is null or s.contestantcontinentrank = tcgms.rank then 0 when tcgms.rank > s.contestantcontinentrank then 1 else -1 end as contestantcontinenttrend " + 
			"from ( " + 
			"	select t.id as id, t.game_id as gameID, t.team_full_name as contestantName, " + 
			"		t.team_name as contestantAronym, t.country as contestantCountry, t.team_url as contestantURL, " + 
			"		concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_LARGE + "', t.team_icon_large) as contestantLogoURLLarge, " +
			"		concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_SMALL + "', t.team_icon_small) as contestantLogoURLThumbnail, " +
			"		(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'win') contestantWins, " +
			"		(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Draw') contestantDraws, " +
			"		(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'fail') contestantLosses, " + 
			"		find_in_set(tgs.score, (select group_concat(tgs1.score order by tgs1.score desc) from team_game_score tgs1 where tgs1.game_id = g.id)) as contestantGlobalRank, " + 
			"		find_in_set(tcgs.score, (select group_concat(tcgs1.score order by tcgs1.score desc) from team_continent_game_score tcgs1 where tcgs1.continent_game_id = cg.id)) as contestantContinentRank, " + 
			"		tgs.score as contestantScore, tgs.id as tgs_id, tcgs.id as tcgs_id, " + 
			"		c.en_continent_name as enContinentName, " + 
			"		c.tw_continent_name as twContinentName " + 
			"	from team t " + 
			"	inner join game g on g.id = t.game_id " + 
			"	left join team_game_score tgs on tgs.team_id = t.id and tgs.game_id = g.id " + 
			"	left join continent_game cg on cg.game_id = g.id " + 
			"	left join team_continent_game_score tcgs on tcgs.continent_game_id = cg.id and tcgs.team_id = t.id " + 
			"	left join continent c on c.id = cg.continent_id " + 
			"	left join admin a1 on a1.key =:key1 " +
			"	left join admin a2 on a2.key =:key2 " +
			" 	where t.game_id = :gameId {other_sql} " + 
			") s " + 
			"left join team_game_monthly_score tgms on tgms.team_game_id = s.tgs_id " + 
			"	and tgms.year = date_format(date_sub(now(), interval 1 month),'%y') " + 
			"   and tgms.month = date_format(date_sub(now(), interval 1 month),'%c') " + 
			"left join team_continent_game_monthly_score tcgms on tcgms.team_continent_game_id = s.tcgs_id " + 
			"	and tcgms.year = date_format(date_sub(now(), interval 1 month),'%y') " + 
			"	and tcgms.month = date_format(date_sub(now(), interval 1 month),'%c') ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.getranking.ContestantsVo> findAllRankingTeamVo(Long gameId, Long tournamentId) {
		Session session = entityManager.unwrap(Session.class);
		String other = StringUtils.EMPTY;
		if(tournamentId != null) {
			other = 
				"and exists ( " +
			    "	select tt.id from tournament_team tt where tt.team_id = t.id and tt.tournament_id = :tournamentId " +
			    ") ";
		}
		
		SQLQuery queryObj = session.createSQLQuery(StringUtils.replace(sql_findAllRankingTeamVo, "{other_sql}", other));
		ResultTransformer transformer = Transformers.aliasToBean(com.hkesports.matchticker.vo.getranking.ContestantsVo.class);
		addScalarsExclude(com.hkesports.matchticker.vo.getranking.ContestantsVo.class, queryObj, "contestantNumber");
		queryObj.setResultTransformer(transformer);
		queryObj.setParameter("gameId", gameId);
		queryObj.setParameter("key1", Const.ADMIN_KEY_ICON_DOMAIN);
		queryObj.setParameter("key2", Const.ADMIN_KEY_ICON_PATH_TEAM);
		if(tournamentId!=null) {
			queryObj.setParameter("tournamentId", tournamentId);
		}
		return queryObj.list();
	}
	
	private final static String sql_findAllLeaguetableTeamVoByTournamentId = 
			"select s.*, " + 
			"case when tgtms.tournament_game_team_id is null or s.position = tgtms.rank then 0 when tgtms.rank > s.position then 1 else -1 end as trend " + 
			"from ( " + 
			"	select t.id as id, t.team_full_name as contestantName, " + 
			"		t.team_name as contestantAronym, t.country as contestantCountry, t.team_url as contestantURL, " + 
			"		(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'win') contestantWins, " +
			"		(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Draw') contestantDraws, " +
			"		(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'fail') contestantLosses, " + 
			"		tgts.score as contestantScore, tgts.id as tgts_id, " + 
			"		find_in_set(tgts.score, (select group_concat(tgts1.score order by tgts1.score desc) from tournament_game_team_score tgts1 where tgts1.tournament_id = tgts.tournament_id)) as position, " +
			"		concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_LARGE + "', t.team_icon_large) as contestantLogoURLLarge, " +
			"		concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_SMALL + "', t.team_icon_small) as contestantLogoURLThumbnail " +
			"	from team t " + 
			"	inner join tournament_team tt on tt.team_id = t.id and tt.tournament_id = :tournamentId " + 
			"	left join tournament_game_team_score tgts on tgts.team_id = t.id and tgts.game_id = t.game_id and tgts.tournament_id = tt.tournament_id " + 
			"	left join admin a1 on a1.key =:key1 " +
			"	left join admin a2 on a2.key =:key2 " +
			") s " + 
			"left join tournament_game_team_monthly_score tgtms on tgtms.tournament_game_team_id = s.tgts_id " + 
			"	and tgtms.year = date_format(date_sub(now(), interval 1 month),'%y') " + 
			"	and tgtms.month = date_format(date_sub(now(), interval 1 month),'%c') ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.getleaguetable.ContestantsVo> findAllLeaguetableTeamVoByTournamentId(Long tournamentId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql_findAllLeaguetableTeamVoByTournamentId);
		ResultTransformer transformer = Transformers.aliasToBean(com.hkesports.matchticker.vo.getleaguetable.ContestantsVo.class);
		addScalarsExclude(com.hkesports.matchticker.vo.getleaguetable.ContestantsVo.class, queryObj, "contestantNumber");
		queryObj.setResultTransformer(transformer);
		queryObj.setParameter("tournamentId", tournamentId);
		queryObj.setParameter("key1", Const.ADMIN_KEY_ICON_DOMAIN);
		queryObj.setParameter("key2", Const.ADMIN_KEY_ICON_PATH_TEAM);
		return queryObj.list();
	}

	private final static String sql_findAllKnockoutrTournamentTeamVoByTournamentId = 
			"select t.id as id, t.team_full_name as contestantname, " + 
			"	t.team_name as contestantaronym, t.country as contestantcountry, t.team_url as contestanturl, " + 
			"	concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_LARGE + "', t.team_icon_large) as contestantLogoURLLarge, " +
			"	concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_SMALL + "', t.team_icon_small) as contestantLogoURLThumbnail, " +
			"	(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'win') contestantwins, " +
			"	(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'Draw') contestantDraws, " +
			"	(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'fail') contestantlosses, " + 
			"	tt.contestant_group as contestantgroup, tt.contestant_out as contestantout " + 
			"from team t " + 
			"inner join tournament_team tt on tt.team_id = t.id and tt.tournament_id = :tournamentId " +
			"left join admin a1 on a1.key =:key1 " +
			"left join admin a2 on a2.key =:key2 " +
			"order by tt.contestant_group desc, tt.contestant_out asc , t.team_name";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ContestantsVo> findAllKnockoutrTournamentTeamVoByTournamentId(Long tournamentId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql_findAllKnockoutrTournamentTeamVoByTournamentId);
		queryObj.setResultTransformer(Transformers.aliasToBean(ContestantsVo.class));
		addScalarsExclude(ContestantsVo.class, queryObj, "contestantNumber");
		queryObj.setParameter("tournamentId", tournamentId);
		queryObj.setParameter("key1", Const.ADMIN_KEY_ICON_DOMAIN);
		queryObj.setParameter("key2", Const.ADMIN_KEY_ICON_PATH_TEAM);
		return queryObj.list();
	}
	
	private final static String JPQL_findAllTeamVoByGameId = 
			"select new com.hkesports.matchticker.vo.getcontestantlist.ContestantsVo(" + 
			"t.id, t.teamFullName, t.teamName, t.country, t.teamUrl, t.teamIconSmall, t.teamIconLarge, t.followerNumber " +
			") from Team t where t.game.id = :gameId";
	
	@SuppressWarnings("unchecked")
	public List<com.hkesports.matchticker.vo.getcontestantlist.ContestantsVo> findAllTeamVoByGameId(Long gameId) {
		Query query = entityManager.createQuery(JPQL_findAllTeamVoByGameId);
		query.setParameter("gameId", gameId);
		return query.getResultList();
	}

	private final static String SQL_findAllTournamentDetailsTeamVoByTournamentId = 
			"select t.id as id, t.team_full_name as contestantName, " + 
			"	t.team_name as contestantAronym, " + 
			"	(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'win') contestantWins, " +
			"	(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'draw') contestantDraws, " +
			"	(select count(1) from schedule_game_detail sgd1 where sgd1.team_id = t.id and sgd1.win = 'fail') contestantLosses, " + 
			"	t.country as contestantCountry, t.team_url as contestantUrl, t.follower_number as contestantFollowerNumber, " + 
			"   {other_sql}" +
			"	concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_LARGE + "', t.team_icon_large) as contestantLogoURLLarge, " +
			"	concat(a1.value, a2.value, t.id, '" + Const.FILE_SIZE_NAME_SMALL + "', t.team_icon_small) as contestantLogoURLThumbnail " +
			"from team t " + 
			"inner join tournament_team tt on tt.team_id = t.id and tt.tournament_id = :tournamentId " +
			"left join admin a1 on a1.key =:key1 " +
			"left join admin a2 on a2.key =:key2 ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TournamentContestantsVo> findAllTournamentDetailsTeamVoByTournamentId(Long tournamentId, UserHa userHa) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = null;
		if(userHa != null) {
			String other_sql = "if((select count(id) from subscription_setting where subscription_key = t.id and subscription_type =:subscriptionType and user_id =:userId and user_type =:userType) > 0, 1, 0) as contestantSubscriptionStatus, ";
			queryObj = session.createSQLQuery(StringUtils.replace(SQL_findAllTournamentDetailsTeamVoByTournamentId, "{other_sql}", other_sql));
			queryObj.setParameter("subscriptionType", SubscriptionTypeEnum.TEAM.name());
			queryObj.setParameter("userId", userHa.getUserId());
			queryObj.setParameter("userType", userHa.getUserType().name());
			addScalarsExclude(TournamentContestantsVo.class, queryObj, "contestantNumber");
		} else {
			queryObj = session.createSQLQuery(StringUtils.replace(SQL_findAllTournamentDetailsTeamVoByTournamentId, "{other_sql}", ""));
			addScalarsExclude(TournamentContestantsVo.class, queryObj, "contestantNumber", "contestantSubscriptionStatus");
		}
		queryObj.setParameter("tournamentId", tournamentId);
		queryObj.setParameter("key1", Const.ADMIN_KEY_ICON_DOMAIN);
		queryObj.setParameter("key2", Const.ADMIN_KEY_ICON_PATH_TEAM);
		queryObj.setResultTransformer(Transformers.aliasToBean(TournamentContestantsVo.class));
		return queryObj.list();
	}
}
