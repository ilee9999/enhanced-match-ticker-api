package com.hkesports.matchticker.test.dao;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import com.hkesports.matchticker.repository.TournamentDao;
import com.hkesports.matchticker.test.AbstractTest;

public class TournamentDaoTest extends AbstractTest {

	@Resource(name = "tournamentDao")
	private TournamentDao tournamentDao;
	
	@Test
	@Ignore
	public void testFindTournamentsByLeagueId() {
		tournamentDao.findTournamentsByLeagueId(10L);
	}
}
