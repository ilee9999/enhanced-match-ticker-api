package com.hkesports.matchticker.vo.matchsupport;

import java.io.Serializable;

import com.hkesports.matchticker.vo.BasicTeamVo;

public class ContestantsVo extends BasicTeamVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long contestantSupportCount;

	public Long getContestantSupportCount() {
		return contestantSupportCount;
	}

	public void setContestantSupportCount(Long contestantSupportCount) {
		this.contestantSupportCount = contestantSupportCount;
	}
}
