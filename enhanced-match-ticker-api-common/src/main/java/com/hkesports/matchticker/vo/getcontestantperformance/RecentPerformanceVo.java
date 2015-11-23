package com.hkesports.matchticker.vo.getcontestantperformance;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.utils.Const;

public class RecentPerformanceVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long matchID; // Schedule.id
	private Date matchStartTime; // Schedule.startTime
	private String matchResult; // Schedule.result
	private Boolean team; //Game.team
	private List<ContestantsVo> contestants;

	public Long getMatchID() {
		return matchID;
	}

	public void setMatchID(Long matchID) {
		this.matchID = matchID;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	public Date getMatchStartTime() {
		return matchStartTime;
	}

	public void setMatchStartTime(Date matchStartTime) {
		this.matchStartTime = matchStartTime;
	}

	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}

	public Boolean getTeam() {
		return team;
	}

	public void setTeam(Boolean team) {
		this.team = team;
	}

	@JsonProperty(value="Contestants")
	public List<ContestantsVo> getContestants() {
		return contestants;
	}

	public void setContestants(List<ContestantsVo> contestants) {
		this.contestants = contestants;
	}
	
}
