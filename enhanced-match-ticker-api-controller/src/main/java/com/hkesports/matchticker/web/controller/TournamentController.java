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
import com.hkesports.matchticker.service.TournamentService;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.ResponseVo;
import com.hkesports.matchticker.vo.getknockoutrtournamenttable.GetknockoutrtournamenttableVo;
import com.hkesports.matchticker.vo.getleagueseasonlist.GetleagueseasonlistVo;
import com.hkesports.matchticker.vo.gettournamentdetails.GettournamentdetailsVo;
import com.hkesports.matchticker.vo.gettournamentlist.GettournamentlistVo;

/**
 * @author manboyu
 *
 */
@RestController
@RequestMapping(value = "rest/emt/api/v1")
public class TournamentController extends BasicController {
	
	@Resource(name = "invokeGetTournamentList")
	private TournamentService invokeGetTournamentList;
	@Resource(name = "invokeKnockoutrTournamentTable")
	private TournamentService invokeKnockoutrTournamentTable;
	@Resource(name = "invokeGetLeagueSeasonList")
	private TournamentService invokeGetLeagueSeasonList;
	@Resource(name = "invokeGetTournamentDetails")
	private TournamentService invokeGetTournamentDetails;
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "/gettournamentlist", method = RequestMethod.GET)
	public ResponseVo<GettournamentlistVo> gettournamentlist(@RequestParam(value = "past") Boolean past, @ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeGetTournamentList.getTournamentList(past, requestVo));
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = TEN_MINUTE)
	@RequestMapping(value = "/getknockouttournamenttable", method = RequestMethod.GET)
	public ResponseVo<GetknockoutrtournamenttableVo> getknockoutrtournamenttable(@ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeKnockoutrTournamentTable.getKnockoutrTournamentTable(requestVo));
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "/getleagueseasonlist", method = RequestMethod.GET)
	public ResponseVo<GetleagueseasonlistVo> getleagueseasonlist(@RequestParam("gameID") Long gameID) {
		return new ResponseVo<>(invokeGetLeagueSeasonList.getLeagueSeasonList(gameID));
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "/gettournamentdetails", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseVo<GettournamentdetailsVo> gettournamentdetails(@ModelAttribute RequestVo requestVo, HttpServletResponse response) {
		if(StringUtils.isNotBlank(requestVo.getRegistrationID())) {
			response.setHeader(HEADER_CACHE_CONTROL, CachePolicy.NO_CACHE.policy());
			try {
				String secretKey = decode(requestVo.getRegistrationID(), requestVo.getSecretKey());
				requestVo.setSecretKey(secretKey);
			} catch (SecurityCodeException e) {
				logger.error("gettournamentdetails error!!", e);
				return new ResponseVo<>(new GettournamentdetailsVo(e.getStatusCode()));
			}
		}
		return new ResponseVo<>(invokeGetTournamentDetails.getTournamentDetails(requestVo));
	}
}
