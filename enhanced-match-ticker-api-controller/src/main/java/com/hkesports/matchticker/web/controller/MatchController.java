package com.hkesports.matchticker.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hkesports.matchticker.exception.SecurityCodeException;
import com.hkesports.matchticker.service.MatchService;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.ResponseVo;
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
@RestController
@RequestMapping(value = "rest/emt/api/v1")
public class MatchController extends BasicController {

	@Resource(name = "invokeMatchSupport")
	private MatchService invokeMatchSupport;
	@Resource(name = "invokeGetMatchStatistics")
	private MatchService invokeGetMatchStatistics;
	@Resource(name = "invokeGetSchedule")
	private MatchService invokeGetSchedule;
	@Resource(name = "invokeGetRanking")
	private MatchService invokeGetRanking;
	@Resource(name = "invokeGetResult")
	private MatchService invokeGetResult;
	@Resource(name = "invokeGetLeaguetable")
	private MatchService invokeGetLeaguetable;
	@Resource(name = "invokeSaveSupportTeam")
	private MatchService invokeSaveSupportTeam;
	@Resource(name = "invokeGetContestantPerformance")
	private MatchService invokeGetContestantPerformance;
	@Resource(name = "invokeGetMatchConteststatus")
	private MatchService invokeGetMatchConteststatus;
	
	@CacheControl(policy = {CachePolicy.PUBLIC}, maxAge = ONE_MINUTE)
	@RequestMapping(value = "/matchsupport", method = RequestMethod.GET)
	public ResponseVo<MatchsupportVo> matchsupport(@RequestParam(value = "matchID") Long matchId) {
		return new ResponseVo<>(invokeMatchSupport.matchSupport(matchId));
	}
	
	@CacheControl(policy = {CachePolicy.PUBLIC}, maxAge = ONE_HOUR)
	@RequestMapping(value = "/lol/getmatchstatistics", method = RequestMethod.GET)
	public ResponseVo<GetmatchstatisticsVo> getlolmatchstatistics(@RequestParam(value = "matchID") Long matchId) {
		return new ResponseVo<>(invokeGetMatchStatistics.getlolMatchStatistics(matchId));
	}
	
	@CacheControl(policy = {CachePolicy.PUBLIC}, maxAge = ONE_HOUR)
	@RequestMapping(value = "/dota2/getmatchstatistics", method = RequestMethod.GET)
	public ResponseVo<GetmatchstatisticsVo> getdota2matchstatistics(@RequestParam(value = "matchID") Long matchId) {
		return new ResponseVo<>(invokeGetMatchStatistics.getdota2MatchStatistics(matchId));
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "/getschedule", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseVo<GetscheduleVo> getschedule(@ModelAttribute RequestVo requestVo, HttpServletResponse response) {
		if(StringUtils.isNotBlank(requestVo.getRegistrationID())) {
			response.setHeader(HEADER_CACHE_CONTROL, CachePolicy.NO_CACHE.policy());
			try {
				String secretKey = decode(requestVo.getRegistrationID(), requestVo.getSecretKey());
				requestVo.setSecretKey(secretKey);
			} catch (SecurityCodeException e) {
				logger.error("getschedule error!!", e);
				return new ResponseVo<>(new GetscheduleVo(e.getStatusCode()));
			}
		}
		return new ResponseVo<>(invokeGetSchedule.getSchedule(requestVo));
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = TEN_MINUTE)
	@RequestMapping(value = "/getresult", method = RequestMethod.GET)
	public ResponseVo<GetresultVo> getresult(@ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeGetResult.getResult(requestVo));
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = TEN_MINUTE)
	@RequestMapping(value = "/getranking", method = RequestMethod.GET)
	public ResponseVo<GetrankingVo> getranking(@ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeGetRanking.getRanking(requestVo));
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = TEN_MINUTE)
	@RequestMapping(value = "/getcirculartournamenttable", method = RequestMethod.GET)
	public ResponseVo<GetleaguetableVo> getcirculartournamenttable(@ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeGetLeaguetable.getCircularTournamentTable(requestVo));
	}
	
	@CacheControl
	@RequestMapping(value = "/supportcontestant", method = RequestMethod.POST)
	public ResponseVo<SupportteamVo> supportcontestant(@RequestParam(value = "matchID") Long matchId, 
			@RequestParam(value = "contestantID") Long contestantID,
			@RequestParam(value = "facebookID") String facebookID) {
		return new ResponseVo<>(invokeSaveSupportTeam.saveSupportTeam(matchId, contestantID, facebookID));
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "/getcontestantperformance", method = {RequestMethod.GET})
	public ResponseVo<GetcontestantperformanceVo> getcontestantperformance(@RequestParam(value = "matchID") Long matchId) {
		return new ResponseVo<>(invokeGetContestantPerformance.getContestantPerformance(matchId));
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_MINUTE)
	@RequestMapping(value = "/getmatchconteststatus", method = {RequestMethod.GET})
	public ResponseVo<GetmatchconteststatusVo> getmatchconteststatus(@RequestParam(value = "matchID") Long matchId, 
			@RequestParam(value = "gameNumber") Short gameNumber) {
		return new ResponseVo<>(invokeGetMatchConteststatus.getMatchConteststatus(matchId, gameNumber));
	}
}