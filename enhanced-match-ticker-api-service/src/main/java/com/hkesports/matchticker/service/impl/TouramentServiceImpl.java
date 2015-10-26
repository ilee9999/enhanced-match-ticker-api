package com.hkesports.matchticker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.repository.GameDao;
import com.hkesports.matchticker.repository.TouramentDao;
import com.hkesports.matchticker.service.TouramentService;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.gettournamentlist.GettouramentlistVo;
import com.hkesports.matchticker.vo.gettournamentlist.TournamentVo;

/**
 * @author manboyu
 *
 */
@Service("touramentService")
public class TouramentServiceImpl implements TouramentService {

	@Resource(name = "touramentDao")
	private TouramentDao touramentDao;
	@Resource(name = "gameDao")
	private GameDao gameDao;
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "getTouramentList", key = "{#root.methodName, #past + '-' + #requestVo.gameID + '-' + #requestVo.pageNumber + '-' + #requestVo.pageSize}")
	public GettouramentlistVo getTouramentList(boolean past, RequestVo requestVo) {
		GettouramentlistVo result = new GettouramentlistVo();
		List<TournamentVo> tournaments = touramentDao.getTournamentlistByPast(past, requestVo);
		if(!CollectionUtils.isEmpty(tournaments)) {
			for(TournamentVo vo : tournaments){
				if(vo.getTournamentID() != null) {
					vo.setGames(gameDao.findGamesByTournamentID(vo.getTournamentID()));
				}
			}
		}
		result.setTourament(tournaments);
		return result;
	}
}
