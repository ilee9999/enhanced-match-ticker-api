package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.vo.getpersonalrecord.GameVo;

public class ScheduleGameDaoImpl extends BasicDaoImpl implements ScheduleGameDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String SQL_findAllGuessGameRecord = 
			"select sg.id as gameid, sg.game_number as gamenumber, " + 
			" 	sg.winner_id as winnerid, sg.game_creation as gamecreation, " + 
			"	sg.game_length as gamelength " + 
			"from schedule_game sg " + 
			"where sg.schedule_id = :matchId " + 
			"and exists ( " + 
			"	select gl.id from guess_log gl " + 
			"	where gl.user_type = :userType and gl.user_id = :userId " + 
			"	and sg.schedule_id = gl.match_id " + 
			"	and sg.game_number = gl.game_number " + 
			") ";
	
	@Override
	@SuppressWarnings("unchecked")
	public List<GameVo> findAllGuessGameRecord(Long userId, UserTypeEnum userType, Long matchId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(SQL_findAllGuessGameRecord);
		queryObj.setResultTransformer(Transformers.aliasToBean(GameVo.class));
		queryObj.setParameter("matchId", matchId);
		queryObj.setParameter("userId", userId);
		queryObj.setParameter("userType", userType.name());
		addScalars(GameVo.class, queryObj);
		return queryObj.list();
	}
}
