package com.hkesports.matchticker.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hkesports.matchticker.service.GameService;
import com.hkesports.matchticker.vo.ResponseVo;
import com.hkesports.matchticker.vo.getcontestantlist.GetcontestantlistVo;
import com.hkesports.matchticker.vo.getgamelist.GetgamelistVo;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

@RestController
@RequestMapping(value = "rest/emt/api/v1")
public class GameController extends BasicController {
	
	@Resource(name = "invokeGetGameList")
	private GameService invokeGetGameList;
	@Resource(name = "invokeGetContestantList")
	private GameService invokeGetContestantList;
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "/getgamelist", method = RequestMethod.GET)
	public ResponseVo<GetgamelistVo> getgamelist() {
		return new ResponseVo<GetgamelistVo>(invokeGetGameList.getGameList());
	}
	
	@CacheControl(policy = CachePolicy.PUBLIC, maxAge = ONE_HOUR)
	@RequestMapping(value = "/getcontestantlist", method = {RequestMethod.GET})
	public ResponseVo<GetcontestantlistVo> getcontestantlist(@RequestParam(value = "gameID", required=false) Long gameID) {
		return new ResponseVo<>(invokeGetContestantList.getContestantList(gameID));
	}
	
}
