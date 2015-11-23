package com.hkesports.matchticker.vo.getmatchconteststatus;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

public class GetmatchconteststatusVo extends BasicVo {
	
	private static final long serialVersionUID = 1L;
	
	private List<ContestantsVo> contestants;

	@JsonProperty(value="Contestants")
	public List<ContestantsVo> getContestants() {
		return contestants;
	}

	public void setContestants(List<ContestantsVo> contestants) {
		this.contestants = contestants;
	}
}
