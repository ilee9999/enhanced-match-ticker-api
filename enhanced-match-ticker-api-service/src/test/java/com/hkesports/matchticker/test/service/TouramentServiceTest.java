package com.hkesports.matchticker.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.hkesports.matchticker.repository.GameDao;
import com.hkesports.matchticker.service.TouramentService;
import com.hkesports.matchticker.vo.gettournamentlist.GameVo;

public class TouramentServiceTest extends AbstractTest {
	
	@Resource(name = "touramentService")
	private TouramentService touramentService;
	
	@Resource(name = "gameDao")
	private GameDao gameDao;

	@Test
	public void testGettouramentlist(){
		//touramentService.gettouramentlist(true, GameTypeEnum.LOL);
		List<GameVo> result = gameDao.findGamesByTournamentID(5631L);
		logger.info("size : {} ", result.size());
	}
}
