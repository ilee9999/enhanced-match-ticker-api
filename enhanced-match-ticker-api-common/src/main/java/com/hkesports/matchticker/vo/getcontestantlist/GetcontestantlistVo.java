package com.hkesports.matchticker.vo.getcontestantlist;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

public class GetcontestantlistVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private Boolean team;
	
	private List<ContestantsVo> contestants;

	public Boolean getTeam() {
		return team;
	}

	public void setTeam(Boolean team) {
		this.team = team;
	}

	@JsonProperty(value="Contestants")
	public List<ContestantsVo> getContestants() {
		return contestants;
	}

	public void setContestants(List<ContestantsVo> contestants) {
		this.contestants = contestants;
	}
}
