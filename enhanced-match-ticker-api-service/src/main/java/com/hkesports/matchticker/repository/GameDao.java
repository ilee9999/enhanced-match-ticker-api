package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.model.Game;
import com.hkesports.matchticker.repository.custom.GameDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface GameDao extends GenericRepository<Game, Long>, GameDaoCustom {

	public final static String JPQL_findGamesByTournament = "select new com.hkesports.matchticker.vo.gettournamentlist.GameVo ( "
			  											  + "	g.id, g.enGameName, g.twGameName, g.gameUrl "
			  											  + ") "
			  											  + "from Schedule as s "
			  											  + "join s.game as g "
			  											  + "where s.tourament.id=:tournamentID ";
	
	public final static String JPQL_findGamesByGameType = "select new com.hkesports.matchticker.vo.getranking.GameVo ( "
														+ "	 s.id, g.id, g.enGameName, g.twGameName, g.gameUrl "
														+ ") "
														+ "from Schedule as s "
														+ "join s.game as g "
														+ "where s.gameType=:gameType "
														+ "and g.gameType=:gameType";

	@Query(JPQL_findGamesByTournament)
	public List<com.hkesports.matchticker.vo.gettournamentlist.GameVo> findGamesByTournamentID(@Param("tournamentID") Long tournamentID);
	
	@Query(JPQL_findGamesByGameType)
	public List<com.hkesports.matchticker.vo.getranking.GameVo> findGamesByGameType(@Param("gameType") GameTypeEnum gameType);
}
