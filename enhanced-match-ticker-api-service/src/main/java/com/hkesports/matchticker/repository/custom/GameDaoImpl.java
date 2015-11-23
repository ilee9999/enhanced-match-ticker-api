package com.hkesports.matchticker.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hkesports.matchticker.vo.RequestVo;

public class GameDaoImpl extends BasicDaoImpl implements GameDaoCustom {
	
	@PersistenceContext
	EntityManager entityManager;
	
	private static final String Jpql_findRankingGameVo = "select new com.hkesports.matchticker.vo.getranking.GameVo ( "
			+ "	 g.id, g.enGameName, g.twGameName, g.gameUrl, g.team "
			+ ") "
			+ "from Game as g ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.hkesports.matchticker.vo.getranking.GameVo> findRankingGameVo(RequestVo requestVo) {
		StringBuilder _jpql = new StringBuilder(Jpql_findRankingGameVo);
		if(requestVo.getTournamentID() != null) {
			_jpql.append("where exists ( ");
			_jpql.append("	select t.id from Tournament t where t.id=:tournamentID ");
			_jpql.append("	and t.game.id = g.id ");
			_jpql.append(") ");
		}
		if(requestVo.getGameID() != null) {
			_jpql.append("and g.id=:gameID ");
		}
		String jpql = _jpql.toString();
		if(!jpql.contains("where") && jpql.contains("and")) {
			jpql = jpql.replaceFirst("and", "where");
		}
		Query queryObj = entityManager.createQuery(jpql);
		if(requestVo.getGameID() != null) {
			queryObj.setParameter("gameID", requestVo.getGameID());
		}
		if(requestVo.getTournamentID() != null) {
			queryObj.setParameter("tournamentID", requestVo.getTournamentID());
		}
		
		if(requestVo.getStartIndex()!=null) {
			queryObj.setFirstResult(requestVo.getStartIndex());
		}
		if(requestVo.getPageSize()!=null && requestVo.getPageSize() > 0) {
			queryObj.setMaxResults(requestVo.getPageSize());
		}
		return queryObj.getResultList();
	}
}
