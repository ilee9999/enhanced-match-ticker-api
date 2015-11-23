package com.hkesports.matchticker.vo.getmatchstatistics;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicTeamVo;

public class TeamVo extends BasicTeamVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long contestantSupportCount;
	private List<LastEncounterVo> lastEncounter;
	private List<RecentPerformanceVo> recentPerformance;
	
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

	@JsonProperty(value="teamSupportCount")
	public Long getContestantSupportCount() {
		return contestantSupportCount;
	}
	
	public void setContestantSupportCount(Long contestantSupportCount) {
		this.contestantSupportCount = contestantSupportCount;
	}
	
	@JsonProperty(value="teamNumber")
	@Override
	public Integer getContestantNumber() {
		return super.getContestantNumber();
	}
	
	@JsonProperty(value="teamName")
	@Override
	public String getContestantName() {
		return super.getContestantName();
	}
	
	@JsonProperty(value="teamAronym")
	@Override
	public String getContestantAronym() {
		return super.getContestantAronym();
	}
	
	@JsonProperty(value="teamWins")
	@Override
	public Long getContestantWins() {
		return super.getContestantWins();
	}
	
	@JsonProperty(value="teamDraws")
	@Override
	public Long getContestantDraws() {
		return super.getContestantDraws();
	}
	
	@JsonProperty(value="teamLosses")
	@Override
	public Long getContestantLosses() {
		return super.getContestantLosses();
	}
	
	@JsonProperty(value="teamCountry")
	@Override
	public String getContestantCountry() {
		return super.getContestantCountry();
	}
	
	@JsonProperty(value="teamURL")
	@Override
	public String getContestantURL() {
		return super.getContestantURL();
	}

	@JsonProperty(value="teamLogoURLThumbnail")
	@Override
	public String getContestantLogoURLThumbnail() {
		return super.getContestantLogoURLThumbnail();
	}
	
	@JsonProperty(value="teamLogoURLLarge")
	@Override
	public String getContestantLogoURLLarge() {
		return super.getContestantLogoURLLarge();
	}

}
