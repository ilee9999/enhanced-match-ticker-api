package com.hkesports.matchticker.vo.getcontestantlist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hkesports.matchticker.vo.BasicTeamVo;

public class ContestantsVo extends BasicTeamVo {

	private static final long serialVersionUID = 1L;

	private Long contestantFollowerNumber;
	
	public ContestantsVo(Long ID, String contestantName, String contestantAronym, String contestantCountry, 
			String contestantURL, String contestantLogoURLThumbnail, String contestantLogoURLLarge,
			Long contestantFollowerNumber) {
		super(ID, contestantName, contestantAronym, contestantCountry, 
				contestantURL, contestantLogoURLThumbnail, contestantLogoURLLarge);
		this.contestantFollowerNumber = contestantFollowerNumber;
	}

	public Long getContestantFollowerNumber() {
		return contestantFollowerNumber;
	}

	public void setContestantFollowerNumber(Long contestantFollowerNumber) {
		this.contestantFollowerNumber = contestantFollowerNumber;
	}

	@JsonIgnore
	public Integer getContestantNumber() {
		return contestantNumber;
	}
	
	@JsonIgnore
	public Long getContestantWins() {
		return contestantWins;
	}

	@JsonIgnore
	public Long getContestantLosses() {
		return contestantLosses;
	}
}
