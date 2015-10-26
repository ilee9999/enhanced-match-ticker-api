package com.hkesports.matchticker.vo.getranking;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

public class GetrankingVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private List<GameVo> Rankings;

	@JsonProperty("Rankings")
	public List<GameVo> getRankings() {
		return Rankings;
	}

	public void setRankings(List<GameVo> rankings) {
		Rankings = rankings;
	}
}
