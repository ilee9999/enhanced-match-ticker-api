package com.hkesports.matchticker.vo.supportteam;

import java.io.Serializable;

import com.hkesports.matchticker.vo.BasicVo;

public class SupportteamVo extends BasicVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long contestantASupportCount;
	
	private Long contestantBSupportCount;

	public SupportteamVo() {}
	
	public SupportteamVo(int statusCode) {
		super(statusCode);
	}
	
	public SupportteamVo(int statusCode, Long contestantASupportCount, Long contestantBSupportCount) {
		super(statusCode);
		this.contestantASupportCount = contestantASupportCount;
		this.contestantBSupportCount = contestantBSupportCount;
	}
	
	public Long getContestantASupportCount() {
		return contestantASupportCount;
	}

	public void setContestantASupportCount(Long contestantASupportCount) {
		this.contestantASupportCount = contestantASupportCount;
	}

	public Long getContestantBSupportCount() {
		return contestantBSupportCount;
	}

	public void setContestantBSupportCount(Long contestantBSupportCount) {
		this.contestantBSupportCount = contestantBSupportCount;
	}
}
