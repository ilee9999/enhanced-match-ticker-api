package com.hkesports.matchticker.vo.gettournamentdetails;

import com.hkesports.matchticker.vo.BasicTeamVo;

public class TournamentContestantsVo extends BasicTeamVo {

	private static final long serialVersionUID = 1L;

	private Boolean contestantSubscriptionStatus;
	private Long contestantFollowerNumber;

	public Boolean getContestantSubscriptionStatus() {
		return contestantSubscriptionStatus;
	}

	public void setContestantSubscriptionStatus(Boolean contestantSubscriptionStatus) {
		this.contestantSubscriptionStatus = contestantSubscriptionStatus;
	}
	
	public Long getContestantFollowerNumber() {
		return contestantFollowerNumber;
	}

	public void setContestantFollowerNumber(Long contestantFollowerNumber) {
		this.contestantFollowerNumber = contestantFollowerNumber;
	}
}
