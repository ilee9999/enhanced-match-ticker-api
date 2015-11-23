package com.hkesports.matchticker.test.dao;

import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT;
import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT_DEFAULT;
import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT;
import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT_DEFAULT;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.model.Admin;
import com.hkesports.matchticker.repository.AdminDao;
import com.hkesports.matchticker.repository.PersonalRankingDao;
import com.hkesports.matchticker.test.AbstractTest;
import com.hkesports.matchticker.utils.DateUtil;
import com.hkesports.matchticker.vo.getpersonalranking.FriendRankVo;
import com.hkesports.matchticker.vo.getpersonalranking.RankVo;

public class PersonalRankingDaoTest extends AbstractTest {

	@Resource(name = "personalRankingDao")
	private PersonalRankingDao personalRankingDao;
	@Resource(name = "adminDao")
	private AdminDao adminDao;
	
	@Test
	@Transactional(readOnly = true)
	public void testFindByFriendUserId() {
		List<FriendRankVo> friendRanks = personalRankingDao.findByFriendUserId(970L);
		Assert.assertTrue("friendRanks is empty ! ", friendRanks.size() > 0);
	}
	
	@Test
	@Ignore
	public void testFindPersonalRankingsByLimit() {
		Integer today = DateUtil.toDateInt(new Date());
		List<RankVo> ranks = personalRankingDao.findPersonalRankingsByLimit(215, 11, today);
		Assert.assertTrue("ranks is empty ! ", !CollectionUtils.isEmpty(ranks));
		Integer userRank = personalRankingDao.findByUserId(1020L, today);
		logger.info("rank : {}", userRank);
		Admin u = adminDao.findByKey(ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT);
		Admin b = adminDao.findByKey(ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT);
		Integer userPersonalLimit = u != null ? Integer.parseInt(u.getValue()) : ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT_DEFAULT;
		Integer userBetweenLimit = b != null ? Integer.parseInt(b.getValue()) : ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT_DEFAULT;
		Integer first = (userRank - userBetweenLimit) < 0 ? 0 : (userRank - userBetweenLimit);
		Integer max = userBetweenLimit * 2 + 1;
		List<RankVo> firstRankings = personalRankingDao.findPersonalRankingsByLimit(userPersonalLimit, today);
		List<RankVo> betweenRankings = personalRankingDao.findPersonalRankingsByLimit(first, max, today);
//		firstRankings.addAll(betweenRankings);
//		List<RankVo> r = removeDuplicteUsers(firstRankings);
//		logger.info("ranks : {}", r);
//		List<RankVo> resultRanks = new ArrayList<>();
//		resultRanks.addAll(firstRankings);
//		resultRanks.addAll(firstRankings);
		Set<RankVo> set = new LinkedHashSet<>();
		set.addAll(firstRankings);
		set.addAll(betweenRankings);
		List<RankVo> resultRanks = new ArrayList<>(set);
		logger.info("ranks : {}", resultRanks);
	}
}
