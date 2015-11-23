package com.hkesports.matchticker.vo.getcontestantperformance;

import java.io.Serializable;

public class LastEncounterVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer encounterNumber;
	private Integer score;
	
	public Integer getEncounterNumber() {
		return encounterNumber;
	}
	public void setEncounterNumber(Integer encounterNumber) {
		this.encounterNumber = encounterNumber;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
