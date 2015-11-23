package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.League;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.getleagueseasonlist.LeagueSeasonVo;

/**
 * @author manboyu
 *
 */
public interface LeagueDao extends GenericRepository<League, Long> {
	
	public final static String JPQL_findLeaguesByGameId = 
			"select new com.hkesports.matchticker.vo.getleagueseasonlist.LeagueSeasonVo (" +
			"	lg.id, lg.seasonName, lg.seasonDetails, lg.seasonStartDate, lg.seasonEndDate, lg.leagueImage" +
			")" +
			"from League as lg " +
			"where lg.game.id =:gameID ";

	@Query(JPQL_findLeaguesByGameId)
	public List<LeagueSeasonVo> findLeaguesByGameId(@Param("gameID") Long gameID);
}
