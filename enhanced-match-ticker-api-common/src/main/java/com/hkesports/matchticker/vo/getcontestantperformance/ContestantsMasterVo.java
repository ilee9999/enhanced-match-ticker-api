package com.hkesports.matchticker.vo.getcontestantperformance;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContestantsMasterVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long ID;
	private Integer contestantNumber;
	private List<LastEncounterVo> lastEncounter;
	private List<RecentPerformanceVo> recentPerformance;
	
	@JsonProperty(value="ID")
	public Long getID() {
		return ID;
	}
	
	public void setID(Long iD) {
		ID = iD;
	}
	
	@JsonProperty(value="ContestantNumber")
	public Integer getContestantNumber() {
		return contestantNumber;
	}
	
	public void setContestantNumber(Integer contestantNumber) {
		this.contestantNumber = contestantNumber;
	}
	
	@JsonProperty(value="LastEncounter")
	public List<LastEncounterVo> getLastEncounter() {
		return lastEncounter;
	}
	
	public void setLastEncounter(List<LastEncounterVo> lastEncounter) {
		this.lastEncounter = lastEncounter;
	}
	
	@JsonProperty(value="RecentPerformance")
	public List<RecentPerformanceVo> getRecentPerformance() {
		return recentPerformance;
	}
	
	public void setRecentPerformance(List<RecentPerformanceVo> recentPerformance) {
		this.recentPerformance = recentPerformance;
	}
}
