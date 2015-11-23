package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.vo.getpersonalranking.FriendRankVo;
import com.hkesports.matchticker.vo.getpersonalranking.RankVo;

/**
 * @author manboyu
 *
 */
public interface PersonalRankingDaoCustom {

	public List<FriendRankVo> findByFriendUserId(Long userId);
	
	public List<RankVo> findPersonalRankingsByLimit(Integer max, Integer today);
	
	public List<RankVo> findPersonalRankingsByLimit(Integer first, Integer max, Integer today);
}
