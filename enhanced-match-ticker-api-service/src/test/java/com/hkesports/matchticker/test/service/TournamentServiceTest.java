package com.hkesports.matchticker.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import com.hkesports.matchticker.repository.GameDao;
import com.hkesports.matchticker.service.TournamentService;
import com.hkesports.matchticker.test.AbstractTest;
import com.hkesports.matchticker.vo.gettournamentlist.GameVo;

public class TournamentServiceTest extends AbstractTest {
	
	@Resource(name = "tournamentService")
	private TournamentService tournamentService;
	
	@Resource(name = "gameDao")
	private GameDao gameDao;

	@Test
	@Ignore
	public void testGettouramentlist(){
		//touramentService.gettouramentlist(true, GameTypeEnum.LOL);
		List<GameVo> result = gameDao.findGamesByTournamentID(5631L);
		logger.info("size : {} ", result.size());
	}
}
