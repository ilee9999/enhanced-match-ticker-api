package com.hkesports.matchticker.vo.getleaguetable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.utils.Const;

/**
 * @author manboyu
 *
 */
public class TournamentVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tournamentID; 				// tournament.id
	private String tournamentName; 			// tournament.tournamentName
	private String tournamentShortName; 	// tournament.tournamentShortName
	private String tournamentSiteURL; 		// tournament.tournamentSiteUrl
	private Long gameID; 					// Game.id
	private Date tournamentFromDate;
	private Date tournamentToDate;
	private Boolean team; 					//Game.team
	private String enGameName; 				// Game.enGameName
	private String twGameName; 				// Game.twGameName
	private String gameURL; 				// Game.gameUrl
	// private Long matchID; 					// Schedule.id
	private List<ContestantsVo> Contestants;

	public TournamentVo(Long tournamentID, String tournamentName,
			String tournamentShortName, String tournamentSiteURL, Long gameID,
			Date tournamentFromDate, Date tournamentToDate, String enGameName, 
			String twGameName, String gameURL, Boolean team) {
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.tournamentShortName = tournamentShortName;
		this.tournamentSiteURL = tournamentSiteURL;
		this.gameID = gameID;
		this.team = team;
		this.tournamentFromDate = tournamentFromDate;
		this.tournamentToDate = tournamentToDate;
		this.enGameName = enGameName;
		this.twGameName = twGameName;
		this.gameURL = gameURL;
//		this.matchID = matchID;
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

	public Long getGameID() {
		return gameID;
	}

	public void setGameID(Long gameID) {
		this.gameID = gameID;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT_YYYYMMDD)
	public Date getTournamentFromDate() {
		return tournamentFromDate;
	}

	public void setTournamentFromDate(Date tournamentFromDate) {
		this.tournamentFromDate = tournamentFromDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT_YYYYMMDD)
	public Date getTournamentToDate() {
		return tournamentToDate;
	}

	public void setTournamentToDate(Date tournamentToDate) {
		this.tournamentToDate = tournamentToDate;
	}

	public Boolean getTeam() {
		return team;
	}

	public void setTeam(Boolean team) {
		this.team = team;
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

//	@JsonIgnore
//	public Long getMatchID() {
//		return matchID;
//	}
//
//	public void setMatchID(Long matchID) {
//		this.matchID = matchID;
//	}

	@JsonProperty("Contestants")
	public List<ContestantsVo> getContestants() {
		return Contestants;
	}

	public void setContestants(List<ContestantsVo> Contestants) {
		this.Contestants = Contestants;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
