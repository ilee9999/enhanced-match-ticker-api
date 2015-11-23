package com.hkesports.matchticker.test.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.hkesports.matchticker.repository.ContestRuleDao;
import com.hkesports.matchticker.test.AbstractTest;

public class ContestRuleDaoTest extends AbstractTest {

	@Resource(name = "contestRuleDao")
	private ContestRuleDao contestRuleDao;
	
	@Test
	public void testFindContestRule() {
		Assert.assertNotNull(contestRuleDao.findContestRule());
	}
}
