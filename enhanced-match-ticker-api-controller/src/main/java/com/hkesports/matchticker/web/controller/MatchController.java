package com.hkesports.matchticker.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hkesports.matchticker.service.MatchService;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.ResponseVo;
import com.hkesports.matchticker.vo.getleaguetable.GetleaguetableVo;
import com.hkesports.matchticker.vo.getmatchstatistics.GetmatchstatisticsVo;
import com.hkesports.matchticker.vo.getranking.GetrankingVo;
import com.hkesports.matchticker.vo.getresult.GetresultVo;
import com.hkesports.matchticker.vo.getschedule.GetscheduleVo;
import com.hkesports.matchticker.vo.matchsupport.MatchsupportVo;
import com.hkesports.matchticker.vo.supportteam.SupportteamVo;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

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
	@Resource(name = "invokeUpdateSupportCount")
	private MatchService invokeUpdateSupportCount;
	
	@CacheControl(policy = {CachePolicy.PUBLIC}, maxAge = ONE_MINUTE)
	@RequestMapping(value = "/matchsupport", method = RequestMethod.GET)
	public ResponseVo<MatchsupportVo> matchsupport(@RequestParam(value = "matchID") Long matchId) {
		return new ResponseVo<>(invokeMatchSupport.matchSupport(matchId));
	}
	
	@CacheControl(policy = {CachePolicy.PUBLIC}, maxAge = ONE_HOUR)
	@RequestMapping(value = "/getmatchstatistics", method = RequestMethod.GET)
	public ResponseVo<GetmatchstatisticsVo> getmatchstatistics(HttpServletResponse response , @RequestParam(value = "matchID") Long matchId) {
//		response.setHeader("Last-Modified", DateFormatUtils.format(new Date(), "EEE, dd MMM yyyy HH:mm:ss zzz", TimeZone.getTimeZone("GMT"), Locale.US));
		return new ResponseVo<>(invokeGetMatchStatistics.getMatchStatistics(matchId));
	}
	
	@CacheControl(policy = {CachePolicy.PUBLIC}, maxAge = ONE_HOUR)
	@RequestMapping(value = "/getschedule", method = RequestMethod.GET)
	public ResponseVo<GetscheduleVo> getschedule(@ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeGetSchedule.getSchedule(requestVo));
	}
	
	@CacheControl(policy = {CachePolicy.PUBLIC}, maxAge = TEN_MINUTE)
	@RequestMapping(value = "/getresult", method = RequestMethod.GET)
	public ResponseVo<GetresultVo> getresult(@ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeGetResult.getResult(requestVo));
	}
	
	@CacheControl(policy = {CachePolicy.PUBLIC}, maxAge = TEN_MINUTE)
	@RequestMapping(value = "/getranking", method = RequestMethod.GET)
	public ResponseVo<GetrankingVo> getranking(@ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeGetRanking.getRanking(requestVo));
	}
	
	@CacheControl(policy = {CachePolicy.PUBLIC}, maxAge = TEN_MINUTE)
	@RequestMapping(value = "/getleaguetable", method = RequestMethod.GET)
	public ResponseVo<GetleaguetableVo> getleaguetable(@ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeGetLeaguetable.getLeaguetable(requestVo));
	}
	
	@RequestMapping(value = "/supportteam", method = RequestMethod.POST)
	public ResponseVo<SupportteamVo> supportteam(@RequestParam(value = "matchID") Long matchId, 
			@RequestParam(value = "teamID") Long teamID,
			@RequestParam(value = "facebookID") String facebookID) {
		SupportteamVo vo = invokeSaveSupportTeam.saveSupportTeam(matchId, teamID, facebookID);
		if(vo!=null && vo.getStatusCode()==0) {
			vo = invokeUpdateSupportCount.updateSupportCount(matchId);
		}
		return new ResponseVo<>(vo);
	}
}