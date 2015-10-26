package com.hkesports.matchticker.service;

import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.getleaguetable.GetleaguetableVo;
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

	public MatchsupportVo matchSupport(Long matchId);
	
	public GetmatchstatisticsVo getMatchStatistics(Long matchId);
	
	public GetscheduleVo getSchedule(RequestVo requestVo);

	public GetrankingVo getRanking(RequestVo requestVo);

	public GetresultVo getResult(RequestVo requestVo);
	
	public GetleaguetableVo getLeaguetable(RequestVo requestVo);
	
	public SupportteamVo saveSupportTeam(Long matchId, Long teamID, String facebookID);
	
	public SupportteamVo updateSupportCount(Long matchId);
}
