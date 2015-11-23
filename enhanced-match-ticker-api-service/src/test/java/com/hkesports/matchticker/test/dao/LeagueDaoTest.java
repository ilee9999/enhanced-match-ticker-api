package com.hkesports.matchticker.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.hkesports.matchticker.repository.LeagueDao;
import com.hkesports.matchticker.test.AbstractTest;
import com.hkesports.matchticker.vo.getleagueseasonlist.LeagueSeasonVo;

public class LeagueDaoTest extends AbstractTest {

	@Resource(name = "leagueDao")
	private LeagueDao leagueDao;
	
	@Test
	public void testFindLeaguesByGameId() {
		List<LeagueSeasonVo> leagues = leagueDao.findLeaguesByGameId(1L);
		Assert.assertNotNull(leagues);
	}
}
