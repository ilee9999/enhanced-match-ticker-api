package com.hkesports.matchticker.vo.getcontestantperformance;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

public class GetcontestantperformanceVo extends BasicVo {
	
	private static final long serialVersionUID = 1L;
	
	private Short maxGames;
	private List<ContestantsMasterVo> contestants;

	public Short getMaxGames() {
		return maxGames;
	}

	public void setMaxGames(Short maxGames) {
		this.maxGames = maxGames;
	}
	
	@JsonProperty(value="Contestants")
	public List<ContestantsMasterVo> getContestants() {
		return contestants;
	}

	public void setContestants(List<ContestantsMasterVo> contestants) {
		this.contestants = contestants;
	}
}
