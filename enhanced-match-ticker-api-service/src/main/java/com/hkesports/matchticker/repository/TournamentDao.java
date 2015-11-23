package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.Tournament;
import com.hkesports.matchticker.repository.custom.TournamentDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.gettournamentdetails.GettournamentdetailsVo;

/**
 * @author manboyu
 *
 */
public interface TournamentDao extends GenericRepository<Tournament, Long>, TournamentDaoCustom {

	public final static String JPQL_findTournamentsByLeagueId = 
			"select new com.hkesports.matchticker.vo.getleagueseasonlist.TournamentVo (" +
			"	t.id, t.tournamentName, t.tournamentShortName, t.tournamentCompetitionSystem" +
			")" +
			"from Tournament t " +
			"where t.league.id =:leagueId " +
			"order by t.tournamentFromDate desc ";
	
	@Query(JPQL_findTournamentsByLeagueId)
	public List<com.hkesports.matchticker.vo.getleagueseasonlist.TournamentVo> findTournamentsByLeagueId(@Param("leagueId") Long leagueId);
	
	public final static String JPQL_findTournamentDetailsVoById = 
			"select new com.hkesports.matchticker.vo.gettournamentdetails.GettournamentdetailsVo (" +
			"	t.id, t.tournamentName, t.tournamentShortName, t.tournamentSiteUrl, " +
			"	t.tournamentFromDate, t.tournamentToDate, t.tournamentDescription, t.tournamentChannelUrl, " +
			"	t.tournamentCompetitionSystem, t.tournamentPrizePool, t.tournamentDetails, " + 
			"	t.tournamentIconSmall, t.tournamentIconLarge, t.tournamentIconHuge, t.game.team" +
			")" +
			"from Tournament t " +
			"where t.id =:tournamentID ";
	
	@Query(JPQL_findTournamentDetailsVoById)
	public GettournamentdetailsVo findTournamentDetailsVoById(@Param("tournamentID") Long tournamentID);
}
