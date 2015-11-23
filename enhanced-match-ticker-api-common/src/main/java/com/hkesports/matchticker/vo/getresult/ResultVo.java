package com.hkesports.matchticker.vo.getresult;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.utils.Const;

public class ResultVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean team; 					//Game.team
	private Long gameID; 					// Game.id
	private String enGameName; 				// Game.enGameName
	private String twGameName; 				// Game.twGameName
	private String gameURL; 				// Game.gameUrl

	private Long matchID; 					// Schedule.id
	private Date matchStartTime; 			// Schedule.startTime
	private Date matchEndTime; 				// Schedule.endTime
	private Date matchDate; 				// (cut the date portion of the matchStartTime)

	private Long tournamentID; 				// tournament.id
	private String tournamentName; 			// tournament.tournamentName
	private String tournamentShortName; 	// tournament.tournamentShortName
	private String tournamentSiteURL; 		// tournament.tournamentSiteUrl
	private String matchResult; 			// (string consisting the match result e.g. 1:1, 2:2)

	private String matchArchiveURL; 		// Schedule.matchArchiveUrl

	private List<ContestantsVo> Contestants;
	
	public ResultVo(Long gameID, String enGameName, String twGameName, String gameURL, Boolean team, Long matchID,
			Date matchStartTime, Date matchEndTime, Date matchDate, Long tournamentID, String tournamentName,
			String tournamentShortName, String tournamentSiteURL, String matchResult, String matchArchiveURL) {
		super();
		this.gameID = gameID;
		this.enGameName = enGameName;
		this.twGameName = twGameName;
		this.gameURL = gameURL;
		this.team = team;
		this.matchID = matchID;
		this.matchStartTime = matchStartTime;
		this.matchEndTime = matchEndTime;
		this.matchDate = matchDate;
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.tournamentShortName = tournamentShortName;
		this.tournamentSiteURL = tournamentSiteURL;
		this.matchResult = matchResult;
		this.matchArchiveURL = matchArchiveURL;
	}

	public Boolean getTeam() {
		return team;
	}

	public void setTeam(Boolean team) {
		this.team = team;
	}

	public Long getGameID() {
		return gameID;
	}

	public void setGameID(Long gameID) {
		this.gameID = gameID;
	}

	public String getEnGameName() {
		return enGameName;
	}

	public void setEnGameName(String enGameName) {
		this.enGameName = enGameName;
	}

	public String getTwGameName() {
		return twGameName;
	}

	public void setTwGameName(String twGameName) {
		this.twGameName = twGameName;
	}

	public String getGameURL() {
		return gameURL;
	}

	public void setGameURL(String gameURL) {
		this.gameURL = gameURL;
	}

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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	public Date getMatchEndTime() {
		return matchEndTime;
	}

	public void setMatchEndTime(Date matchEndTime) {
		this.matchEndTime = matchEndTime;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT_YYYYMMDD)
	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
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

	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}

	public String getMatchArchiveURL() {
		return matchArchiveURL;
	}

	public void setMatchArchiveURL(String matchArchiveURL) {
		this.matchArchiveURL = matchArchiveURL;
	}

	@JsonProperty(value="Contestants")
	public List<ContestantsVo> getContestants() {
		return this.Contestants;
	}

	public void setContestants(List<ContestantsVo> Contestants) {
		this.Contestants = Contestants;
	}
}
