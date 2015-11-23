package com.hkesports.matchticker.vo.getpersonalranking;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class GetpersonalrankingVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private List<RankVo> ranks;
	private List<FriendRankVo> friendRanks;
	
	public GetpersonalrankingVo() {
		
	}
	
	public GetpersonalrankingVo(StatusCodeEnum statusCode) {
		super(statusCode);
	}

	@JsonProperty(value="Ranks")
	public List<RankVo> getRanks() {
		return ranks;
	}

	public void setRanks(List<RankVo> ranks) {
		this.ranks = ranks;
	}

	@JsonProperty(value="FriendRanks")
	public List<FriendRankVo> getFriendRanks() {
		return friendRanks;
	}

	public void setFriendRanks(List<FriendRankVo> friendRanks) {
		this.friendRanks = friendRanks;
	}
}
