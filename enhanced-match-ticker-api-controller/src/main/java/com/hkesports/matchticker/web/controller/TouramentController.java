package com.hkesports.matchticker.web.controller;

import javax.annotation.Resource;

import net.rossillo.spring.web.mvc.CacheControl;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hkesports.matchticker.service.TouramentService;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.ResponseVo;
import com.hkesports.matchticker.vo.gettournamentlist.GettouramentlistVo;

/**
 * @author manboyu
 *
 */
@RestController
@RequestMapping(value = "rest/emt/api/v1")
public class TouramentController extends BasicController {
	
	@Resource(name = "invokeGetTouramentList")
	private TouramentService invokeGetTouramentList;

	@CacheControl(maxAge = ONE_HOUR)
	@RequestMapping(value = "/gettournamentlist", method = RequestMethod.GET)
	public ResponseVo<GettouramentlistVo> gettournamentlist(@RequestParam(value = "past") Boolean past, @ModelAttribute RequestVo requestVo) {
		return new ResponseVo<>(invokeGetTouramentList.getTouramentList(past, requestVo));
	}
}
