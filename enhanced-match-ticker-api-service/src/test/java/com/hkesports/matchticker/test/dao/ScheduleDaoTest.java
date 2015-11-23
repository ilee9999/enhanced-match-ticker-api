package com.hkesports.matchticker.test.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.hkesports.matchticker.repository.ScheduleDao;
import com.hkesports.matchticker.test.AbstractTest;

public class ScheduleDaoTest extends AbstractTest {

	@Resource(name = "scheduleDao")
	private ScheduleDao scheduleDao;
	
	@Test
	public void testFindDota2GamesByMatchId() {
		scheduleDao.findAllDota2GamesByMatchId(1L);
	}
}
