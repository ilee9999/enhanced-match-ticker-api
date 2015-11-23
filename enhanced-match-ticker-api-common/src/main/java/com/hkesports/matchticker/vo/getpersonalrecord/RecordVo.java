package com.hkesports.matchticker.vo.getpersonalrecord;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.utils.Const;

public class RecordVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long matchID;
	private Date matchStartTime;
	private Long tournamentID;
	private String tournamentName;
	private String tournamentShortName;
	private String tournamentSiteURL; // (Link to the tournament site)
	private Boolean team;

	private List<ContestantsVo> contestants;
	private List<GameVo> games;

	private Integer year;
	private Integer month;
	private Integer day;
	
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

	public Long getTournamentID() {
		return tournamentID;
	}

	public void setTournamentID(Long tournamentID) {
		this.tournamentID = tournamentID;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public String getTournamentShortName() {
		return tournamentShortName;
	}

	public void setTournamentShortName(String tournamentShortName) {
		this.tournamentShortName = tournamentShortName;
	}

	public String getTournamentSiteURL() {
		return tournamentSiteURL;
	}

	public void setTournamentSiteURL(String tournamentSiteURL) {
		this.tournamentSiteURL = tournamentSiteURL;
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

	@JsonProperty(value="Games")
	public List<GameVo> getGames() {
		return games;
	}

	public void setGames(List<GameVo> games) {
		this.games = games;
	}

	@JsonIgnore
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@JsonIgnore
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@JsonIgnore
	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}
}
