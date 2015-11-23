package com.hkesports.matchticker.service;

import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.getcontestantperformance.GetcontestantperformanceVo;
import com.hkesports.matchticker.vo.getleaguetable.GetleaguetableVo;
import com.hkesports.matchticker.vo.getmatchconteststatus.GetmatchconteststatusVo;
import com.hkesports.matchticker.vo.getmatchstatistics.GetmatchstatisticsVo;
import com.hkesports.matchticker.vo.getranking.GetrankingVo;
import com.hkesports.matchticker.vo.getresult.GetresultVo;
import com.hkesports.matchticker.vo.getschedule.GetscheduleVo;
import com.hkesports.matchticker.vo.matchsupport.MatchsupportVo;
import com.hkesports.matchticker.vo.supportteam.SupportteamVo;

/**
 * @author manboyu
 *
 */
public interface MatchService {

	/**
	 * API: /rest/emt/api/v1/matchSupport
	 * @param matchId
	 * @return
	 */
	public MatchsupportVo matchSupport(Long matchId);
	
	/**
	 * API: /rest/emt/api/v1/lol/getmatchstatistics
	 * @param matchId
	 * @return
	 */
	public GetmatchstatisticsVo getlolMatchStatistics(Long matchId);
	
	/**
	 * API: /rest/emt/api/v1/dota2/getmatchstatistics
	 * @param matchId
	 * @return
	 */
	public GetmatchstatisticsVo getdota2MatchStatistics(Long matchId);
	
	/**
	 * API: /rest/emt/api/v1/getschedule
	 * @param requestVo
	 * @return
	 */
	public GetscheduleVo getSchedule(RequestVo requestVo);

	/**
	 * API: /rest/emt/api/v1/getranking
	 * @param requestVo
	 * @return
	 */
	public GetrankingVo getRanking(RequestVo requestVo);

	/**
	 * API: /rest/emt/api/v1/getresult
	 * @param requestVo
	 * @return
	 */
	public GetresultVo getResult(RequestVo requestVo);
	
	/**
	 * API: /rest/emt/api/v1/getcirculartournamenttable
	 * @param requestVo
	 * @return
	 */
	public GetleaguetableVo getCircularTournamentTable(RequestVo requestVo);
	
	public SupportteamVo saveSupportTeam(Long matchId, Long contestantID, String facebookID);
	
	/**
	 * API: /rest/emt/api/v1/getcontestantperformance
	 * @param matchId
	 * @return
	 */
	public GetcontestantperformanceVo getContestantPerformance(Long matchId);
	
	/**
	 * API: /rest/emt/api/v1/getmatchconteststatus
	 * @param matchId
	 * @param gameNumber
	 * @return
	 */
	public GetmatchconteststatusVo getMatchConteststatus(Long matchId, Short gameNumber);
}
