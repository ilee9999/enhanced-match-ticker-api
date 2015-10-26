package com.hkesports.matchticker.vo.supportteam;

import java.io.Serializable;

import com.hkesports.matchticker.vo.BasicVo;

public class SupportteamVo extends BasicVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long teamASupportCount;
	
	private Long teamBSupportCount;

	public SupportteamVo() {}
	
	public SupportteamVo(int statusCode) {
		super(statusCode);
	}
	
	public SupportteamVo(int statusCode, Long teamASupportCount, Long teamBSupportCount) {
		super(statusCode);
		this.teamASupportCount = teamASupportCount;
		this.teamBSupportCount = teamBSupportCount;
	}
	
	public Long getTeamASupportCount() {
		return teamASupportCount;
	}

	public void setTeamASupportCount(Long teamASupportCount) {
		this.teamASupportCount = teamASupportCount;
	}

	public Long getTeamBSupportCount() {
		return teamBSupportCount;
	}

	public void setTeamBSupportCount(Long teamBSupportCount) {
		this.teamBSupportCount = teamBSupportCount;
	}
}
