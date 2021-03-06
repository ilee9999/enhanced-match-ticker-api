package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.GameItemTypeEnum;
import com.hkesports.matchticker.vo.getmatchstatistics.GameTeamPlayerVo;

public class ScheduleGamePlayerDetailDaoImpl extends BasicDaoImpl implements ScheduleGamePlayerDetailDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	
	private final static String SQL_findGameTeamPlayerByGameDetail = 
			"select s1.player_id as playerID, p.player_name as playerName,  " +
			"	p.photo_url as playerPhotoURLThumbnail,  " +
			"	p.photo_url as playerPhotoURLLarge, " +
			"	p.photo_url as playerPhotoURLOriginal, " +
			"	s1.kills, s1.deaths, s1.assists, s1.end_Level as endLevel,  " +
			"	s1.minions_killed as minionsKilled, s1.total_gold as totalGold, " +
			"	s1.largest_Killing_Spree as largestKillingSpree, s1.largest_Multi_Kill as largestMultiKill, s1.killing_Sprees as killingSprees, " +
			"	s1.longest_Time_Spent_Living as longestTimeSpentLiving,  " +
			"	s1.double_Kills as doubleKills, s1.triple_Kills as tripleKills, s1.quadra_Kills as quadraKills,  " +
			"	s1.penta_Kills as pentaKills, s1.unreal_Kills as unrealKills,  " +
			"	s1.total_Damage_Dealt as totalDamageDealt, s1.magic_Damage_Dealt as magicDamageDealt,  " +
			"	s1.physical_Damage_Dealt as physicalDamageDealt, s1.true_Damage_Dealt as trueDamageDealt, " +
			"	s1.largest_Critical_Strike as largestCriticalStrike, s1.total_Damage_Dealt_To_Champions as totalDamageDealtToChampions, " +
			"	s1.magic_Damage_Dealt_To_Champions as magicDamageDealtToChampions, s1.physical_Damage_Dealt_To_Champions as physicalDamageDealtToChampions, " +
			"	s1.true_Damage_Dealt_To_Champions as trueDamageDealtToChampions, s1.total_Heal as totalHeal, s1.total_Units_Healed as totalUnitsHealed, " +
			"	s1.total_Damage_Taken as totalDamageTaken, s1.magical_Damage_Taken as magicalDamageTaken, s1.physical_Damage_Taken as physicalDamageTaken, " +
			"	s1.true_Damage_Taken as trueDamageTaken, s1.gold_Earned as goldEarned, s1.gold_Spent as goldSpent, " +
			"	s1.turret_Kills as turretKills, s1.inhibitor_Kills as inhibitorKills, " +
			"	s1.total_Minions_Killed as totalMinionsKilled, " +
			"	s1.neutral_Minions_Killed as neutralMinionsKilled, " +
			"	s1.neutral_Minions_Killed_Team_Jungle as neutralMinionsKilledTeamJungle, " +
			"	s1.neutral_Minions_Killed_Enemy_Jungle as neutralMinionsKilledEnemyJungle, " +
			"	s1.total_time_crowd_control_dealt as totalTimeCrowdControlDealt, s1.champ_Level as champLevel, " +
			"	s1.vision_Wards_Bought_In_Game as visionWardsBoughtInGame, s1.sight_Wards_Bought_In_Game as sightWardsBoughtInGame, " +
			"	s1.wards_Placed as wardsPlaced, s1.wards_Killed as wardsKilled, " +
			"	h.name as championName, hero.item_url as championURL, " +
			"	spell0.item_url as spell0, " +
			"	spell1.item_url as spell1, " +
			"	item0.item_url as items0, item1.item_url as items1, item2.item_url as items2, " +
			"	item3.item_url as items3, item4.item_url as items4, item5.item_url as items5, item6.item_url as items6, " +
			"	player_slot as playerSlot, gold_per_min as goldPerMin, xp_per_min as xpPerMin, " +
			"	hero_damage as heroDamage, tower_damage as towerDamage, hero_healing as heroHealing " +
			"from schedule_game_detail sgd " +
			"inner join schedule_game sg on sgd.schedule_game_id = sg.id " +
			"inner join schedule_game_player_detail s1 on sgd.id = s1.schedule_game_detail_id " +
			"left join player p on p.id = s1.player_id " +
			"left join schedule_game_player_items as hero on s1.player_id = hero.player_id  " +
			"	and hero.schedule_game_id = sg.id and hero.item_type = :HERO " +
			"left join hero as h on hero.item_id = h.api_id  " +
			"	and h.game_id = sg.game_id " +
			"left join schedule_game_player_items as spell0 on s1.player_id = spell0.player_id  " +
			"	and spell0.schedule_game_id = sg.id  " +
			"   and spell0.item_type = :SPELL and spell0.sequence = 0 " +
			"left join schedule_game_player_items as spell1 on s1.player_id = spell1.player_id  " +
			"	and spell1.schedule_game_id = sg.id  " +
			"   and spell1.item_type = :SPELL and spell1.sequence = 1 " +
			"left join schedule_game_player_items as item0 on s1.player_id = item0.player_id  " +
			"	and item0.schedule_game_id = sg.id  " +
			"   and item0.item_type = :EQUIP and item0.sequence = 0 " +
			"left join schedule_game_player_items as item1 on s1.player_id = item1.player_id  " +
			"	and item1.schedule_game_id = sg.id  " +
			"   and item1.item_type = :EQUIP and item1.sequence = 1 " +
			"left join schedule_game_player_items as item2 on s1.player_id = item2.player_id  " +
			"	and item2.schedule_game_id = sg.id  " +
			"   and item2.item_type = :EQUIP and item2.sequence = 2 " +
			"left join schedule_game_player_items as item3 on s1.player_id = item3.player_id  " +
			"	and item3.schedule_game_id = sg.id  " +
			"   and item3.item_type = :EQUIP and item3.sequence = 3 " +
			"left join schedule_game_player_items as item4 on s1.player_id = item4.player_id  " +
			"	and item4.schedule_game_id = sg.id  " +
			"   and item4.item_type = :EQUIP and item4.sequence = 4 " +
			"left join schedule_game_player_items as item5 on s1.player_id = item5.player_id  " +
			"	and item5.schedule_game_id = sg.id  " +
			"   and item5.item_type = :EQUIP and item5.sequence = 5 " +
			"left join schedule_game_player_items as item6 on s1.player_id = item6.player_id  " +
			"	and item6.schedule_game_id = sg.id  " +
			"   and item6.item_type = :EQUIP and item6.sequence = 6 " +
			"where sgd.id = :gameDetailId";
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameTeamPlayerVo> findGameTeamPlayerByGameDetail(Long scheduleGameDetailId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findGameTeamPlayerByGameDetail);
		ResultTransformer transformer = Transformers.aliasToBean(GameTeamPlayerVo.class);
		addScalars(GameTeamPlayerVo.class, queryObj);
		queryObj.setResultTransformer(transformer);
		queryObj.setParameter("gameDetailId", scheduleGameDetailId);
		queryObj.setParameter("EQUIP", GameItemTypeEnum.EQUIP.toString());
		queryObj.setParameter("SPELL", GameItemTypeEnum.SPELL.toString());
		queryObj.setParameter("HERO", GameItemTypeEnum.HERO.toString());
		return queryObj.list();
	}
}
