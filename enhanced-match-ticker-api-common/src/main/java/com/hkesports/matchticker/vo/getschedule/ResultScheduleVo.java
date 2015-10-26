package com.hkesports.matchticker.vo.getschedule;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.utils.Const;

public class ResultScheduleVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer team = 1;
	private Long gameID; //Game.id
	private String enGameName; //Game.enGameName
	private String twGameName; //Game.twGameName
	private String gameURL; //Game.gameUrl
	private Long matchID; //Schedule.id
	private Date matchStartTime; //Schedule.startTime
	private transient Date matchEndTime; //Schedule.endTime
	private String matchStatus;
	private Long tournamentID; //tourament.id
	private String tournamentName; //tourament.touramentName
	private String tournamentShortName; //tourament.touramentShortName
	private String tournamentSiteURL; //tournament.touramentSiteUrl
	private String matchLiveURL; //Schedule.matchLiveURL
	private Short maxGames; //Game.maxGames
	
	private List<TeamVo> Teams;
	private transient GameTypeEnum gameType; 
	
	
	public ResultScheduleVo() {}
	public ResultScheduleVo(Long gameID, String enGameName, String twGameName, String gameURL, String matchLiveURL, Short maxGames, 
			Long matchID, Date matchStartTime, Date matchEndTime, String matchStatus, Long tournamentID, String tournamentName,
			String tournamentShortName, String tournamentSiteURL, GameTypeEnum gameType) {
		super();
		this.gameID = gameID;
		this.enGameName = enGameName;
		this.twGameName = twGameName;
		this.gameURL = gameURL;
		this.matchID = matchID;
		this.matchStartTime = matchStartTime;
		this.matchEndTime = matchEndTime;
		this.matchStatus = matchStatus;
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.tournamentShortName = tournamentShortName;
		this.tournamentSiteURL = tournamentSiteURL;
		this.matchLiveURL = matchLiveURL;
		this.maxGames = maxGames;
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

	@JsonIgnore
	public Date getMatchEndTime() {
		return matchEndTime;
	}

	public void setMatchEndTime(Date matchEndTime) {
		this.matchEndTime = matchEndTime;
	}

	public String getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
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

	public String getMatchLiveURL() {
		return matchLiveURL;
	}

	public void setMatchLiveURL(String matchLiveURL) {
		this.matchLiveURL = matchLiveURL;
	}

	public Short getMaxGames() {
		return maxGames;
	}

	public void setMaxGames(Short maxGames) {
		this.maxGames = maxGames;
	}

	public List<TeamVo> getTeams() {
		return Teams;
	}

	public void setTeams(List<TeamVo> teams) {
		Teams = teams;
	}
	
	@JsonIgnore
	public GameTypeEnum getGameType() {
		return gameType;
	}
	
	public void setGameType(GameTypeEnum gameType) {
		this.gameType = gameType;
	}
	
	public Integer getTeam() {
		return team;
	}
	
	public void setTeam(Integer team) {
		this.team = team;
	}
}
