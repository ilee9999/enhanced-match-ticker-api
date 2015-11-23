package com.hkesports.matchticker.vo.getmatchconteststatus;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContestantsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ID;
	private Integer contestantNumber;
	private Integer contestantGuessingRate;

	@JsonProperty(value="ID")
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Integer getContestantNumber() {
		return contestantNumber;
	}

	public void setContestantNumber(Integer contestantNumber) {
		this.contestantNumber = contestantNumber;
	}

	public Integer getContestantGuessingRate() {
		return contestantGuessingRate;
	}

	public void setContestantGuessingRate(Integer contestantGuessingRate) {
		this.contestantGuessingRate = contestantGuessingRate;
	}
}
