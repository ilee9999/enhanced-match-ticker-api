package com.hkesports.matchticker.service;

import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.getknockoutrtournamenttable.GetknockoutrtournamenttableVo;
import com.hkesports.matchticker.vo.getleagueseasonlist.GetleagueseasonlistVo;
import com.hkesports.matchticker.vo.gettournamentdetails.GettournamentdetailsVo;
import com.hkesports.matchticker.vo.gettournamentlist.GettournamentlistVo;

/**
 * @author manboyu
 *
 */
public interface TournamentService {

	public GettournamentlistVo getTournamentList(boolean past, RequestVo requestVo);
	
	/**
	 * API: /rest/emt/api/v1/getknockoutrtournamenttable
	 * @param requestVo
	 * @return
	 */
	public GetknockoutrtournamenttableVo getKnockoutrTournamentTable(RequestVo requestVo);
	
	/**
	 * API: /rest/emt/api/v1/getleagueseasonlist
	 * @param gameID
	 * @return
	 */
	public GetleagueseasonlistVo getLeagueSeasonList(Long gameID);

	/**
	 * API: /rest/emt/api/v1/gettournamentdetails
	 * @param tournamentId
	 * @return
	 */
	public GettournamentdetailsVo getTournamentDetails(RequestVo requestVo);
}
