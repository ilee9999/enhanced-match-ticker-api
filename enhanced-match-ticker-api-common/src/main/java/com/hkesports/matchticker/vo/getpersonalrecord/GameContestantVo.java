package com.hkesports.matchticker.vo.getpersonalrecord;

import java.io.Serializable;

public class GameContestantVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer contestantNumber; // (0/1)
	private Long ha; // (用多少ha)
	private Integer contestantGuessingRate; // (in %)

	public Integer getContestantNumber() {
		return contestantNumber;
	}

	public void setContestantNumber(Integer contestantNumber) {
		this.contestantNumber = contestantNumber;
	}

	public Long getHa() {
		return ha;
	}

	public void setHa(Long ha) {
		this.ha = ha;
	}

	public Integer getContestantGuessingRate() {
		return contestantGuessingRate;
	}

	public void setContestantGuessingRate(Integer contestantGuessingRate) {
		this.contestantGuessingRate = contestantGuessingRate;
	}

}
