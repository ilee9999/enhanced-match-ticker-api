package com.hkesports.matchticker.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.hkesports.matchticker.enums.GameWinTypeEnum;
import com.hkesports.matchticker.model.Code;
import com.hkesports.matchticker.model.Data;
import com.hkesports.matchticker.model.Team;
import com.hkesports.matchticker.repository.DataDao;
import com.hkesports.matchticker.repository.ScheduleGameDetailDao;
import com.hkesports.matchticker.repository.TeamDao;
import com.hkesports.matchticker.service.MatchService;
import com.hkesports.matchticker.utils.Const;

public class MatchServiceTest extends AbstractTest {

	@Resource(name = "matchService")
	private MatchService matchService;
	
	@Resource(name = "dataDao")
	private DataDao dataDao;
	@Resource(name = "teamDao")
	private TeamDao teamDao;
	@Resource(name = "scheduleGameDetailDao")
	private ScheduleGameDetailDao scheduleGameDetailDao;
	
	private Long matchId;
	private Team team;
	
	@Before
	public void setUp() {
		matchId = 86563L;
		team = teamDao.findOne(23487L);
	}
	
	@Test
	@Ignore
	public void testMatchsupport() {
		matchService.matchSupport(matchId);
		// matchService.getRanking(GameTypeEnum.LOL);
	}
	
	@Test
	@Ignore
	public void testFindData(){
		dataDao.findByCodeData(Const.CODE_NAME_TEAM_POSITION, "RADIANT");
	}
	
	@Test
	@Ignore
	public void testCountByTeamAndWin(){
		Long winCount = scheduleGameDetailDao.countByTeamAndWin(team, GameWinTypeEnum.Win);
		Long losseCount = scheduleGameDetailDao.countByTeamAndWin(team, GameWinTypeEnum.Fail);
		logger.info("teamWins : {}, teamLosses : {} ", winCount, losseCount);
	}
	
	@Test
	@Ignore
	public void testGetmatchstatistics() {
		matchService.getMatchStatistics(48830L);
	}
	
	@Test
	@Ignore
	public void testSaveCodeData(){
		Code code = new Code();
		code.setCodeName("team_position");
		code.setCodeDesc("用來取得dota2, LOL的team_position.");
		
		List<Data> datas = new ArrayList<>();
		
		Data data = new Data();
		data.setCode(code);
		data.setDataName("RADIANT");
		data.setDataValue("0");
		datas.add(data);
		
		data = new Data();
		data.setCode(code);
		data.setDataName("DIRE");
		data.setDataValue("1");
		datas.add(data);
		
		data = new Data();
		data.setCode(code);
		data.setDataName("red");
		data.setDataValue("0");
		datas.add(data);
		
		data = new Data();
		data.setCode(code);
		data.setDataName("blue");
		data.setDataValue("1");
		datas.add(data);
		
		dataDao.save(datas);
	}
}
