package com.hkesports.matchticker.test.dao;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.hkesports.matchticker.repository.TeamDao;
import com.hkesports.matchticker.test.AbstractTest;
import com.hkesports.matchticker.vo.getmatchstatistics.TeamVo;

public class TeamDaoTest extends AbstractTest {

	@Resource(name = "teamDao")
	private TeamDao teamDao;
	
	@Test
	@Transactional
	@Ignore
	public void testGetAllTeamVoByMatchId() {
		teamDao.findAllTeamVoByMatchId(1L, TeamVo.class);
	}
}
