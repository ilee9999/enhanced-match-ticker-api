package com.hkesports.matchticker.vo.getschedule;

import java.io.Serializable;

import com.hkesports.matchticker.vo.BasicTeamVo;

public class TeamVo extends BasicTeamVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long teamSupportCount;
	
	public Long getTeamSupportCount() {
		return teamSupportCount;
	}

	public void setTeamSupportCount(Long teamSupportCount) {
		this.teamSupportCount = teamSupportCount;
	}
}
