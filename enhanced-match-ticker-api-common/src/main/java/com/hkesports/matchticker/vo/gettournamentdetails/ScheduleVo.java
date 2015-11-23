package com.hkesports.matchticker.vo.gettournamentdetails;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.enums.ScheduleStatusEnum;
import com.hkesports.matchticker.utils.Const;

public class ScheduleVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long gameID;
    private String enGameName;
    private String twGameName;
    private String gameURL; //(Link to the game site)
    private Long matchID;
    private Date matchStartTime;
    private String matchStatus; //("Future" Not yet start, "Live" Live, "Ended" Match Edned)
    private Long tournamentID;
    private String tournamentName;
    private String tournamentShortName;
    private String tournamentSiteURL; //(Link to the tournament site)
    private String matchLiveURL; //(Link to the match live video site)
    private Short maxGames;
    private ScheduleStatusEnum status; //(cancel＝比賽取消／contestended＝競猜完結，公眾不能再參加競猜／ready＝一切正常)
    private Boolean team; //(如果是true, Contestants裡面的就是team的資料,如果是false, Contestants裡面的就是player的資料)
    private Boolean matchSubscriptionStatus;
    private List<ContestantsVo> contestants;
    
    public ScheduleVo() {
    	
    }
    
	public ScheduleVo(Long gameID, String enGameName, String twGameName, String gameURL, Long matchID,
			Date matchStartTime, String matchStatus, Long tournamentID, String tournamentName,
			String tournamentShortName, String tournamentSiteURL, String matchLiveURL, Short maxGames,
			ScheduleStatusEnum status, Boolean team) {
		this.gameID = gameID;
		this.enGameName = enGameName;
		this.twGameName = twGameName;
		this.gameURL = gameURL;
		this.matchID = matchID;
		this.matchStartTime = matchStartTime;
		this.matchStatus = matchStatus;
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.tournamentShortName = tournamentShortName;
		this.tournamentSiteURL = tournamentSiteURL;
		this.matchLiveURL = matchLiveURL;
		this.maxGames = maxGames;
		this.status = status;
		this.team = team;
	}
	
	public ScheduleVo(Long gameID, String enGameName, String twGameName, String gameURL, Long matchID,
			Date matchStartTime, String matchStatus, Long tournamentID, String tournamentName,
			String tournamentShortName, String tournamentSiteURL, String matchLiveURL, Short maxGames,
			ScheduleStatusEnum status, Boolean team, Boolean matchSubscriptionStatus) {
		this.gameID = gameID;
		this.enGameName = enGameName;
		this.twGameName = twGameName;
		this.gameURL = gameURL;
		this.matchID = matchID;
		this.matchStartTime = matchStartTime;
		this.matchStatus = matchStatus;
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.tournamentShortName = tournamentShortName;
		this.tournamentSiteURL = tournamentSiteURL;
		this.matchLiveURL = matchLiveURL;
		this.maxGames = maxGames;
		this.status = status;
		this.team = team;
		this.matchSubscriptionStatus = matchSubscriptionStatus;
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

	public ScheduleStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ScheduleStatusEnum status) {
		this.status = status;
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
	
	public Boolean getMatchSubscriptionStatus() {
		return matchSubscriptionStatus;
	}
	public void setMatchSubscriptionStatus(Boolean matchSubscriptionStatus) {
		this.matchSubscriptionStatus = matchSubscriptionStatus;
	}
}
