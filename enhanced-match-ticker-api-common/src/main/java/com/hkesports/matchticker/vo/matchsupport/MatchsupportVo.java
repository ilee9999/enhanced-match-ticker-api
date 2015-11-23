package com.hkesports.matchticker.vo.matchsupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.utils.Const;
import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class MatchsupportVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private Long matchID;
	private Date matchDate;
	private Date matchStartTime;
	private Date matchEndTime;
	private Boolean team;
	private List<ContestantsVo> Contestants = new ArrayList<>();
	private Long tournamentID;
	private String tournamentName;
	private String tournamentShortName;
	private String tournamentSiteURL;
	private String matchLiveURL;
	private String matchResult;
	private String matchArchiveURL;
	
	public MatchsupportVo() {
		
	}
	
	public MatchsupportVo(Date matchDate, Date matchStartTime,
			Date matchEndTime, Long tournamentID, String tournamentName,
			String tournamentShortName, String tournamentSiteURL,
			String matchLiveURL, String matchArchiveURL, Long matchID, Boolean team) {
		this.matchDate = matchDate;
		this.matchStartTime = matchStartTime;
		this.matchEndTime = matchEndTime;
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.tournamentShortName = tournamentShortName;
		this.tournamentSiteURL = tournamentSiteURL;
		this.matchLiveURL = matchLiveURL;
		this.matchArchiveURL = matchArchiveURL;
		this.matchID = matchID;
		this.team = team;
	}

	public Long getMatchID() {
		return matchID;
	}

	public void setMatchID(Long matchID) {
		this.matchID = matchID;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT_YYYYMMDD)
	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
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

	public Boolean getTeam() {
		return team;
	}

	public void setTeam(Boolean team) {
		this.team = team;
	}

	@JsonProperty("Contestants")
	public List<ContestantsVo> getContestants() {
		return Contestants;
	}

	public void setContestants(List<ContestantsVo> Contestants) {
		this.Contestants = Contestants;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("matchDate", getMatchDate())
		.append("matchStartTime", getMatchStartTime())
		.append("matchEndTime", getMatchEndTime())
		.append("team", getTeam())
		.append("tournamentID", getTournamentID())
		.append("tournamentName", getTournamentName())
		.append("tournamentShortName", getTournamentShortName())
		.append("tournamentSiteURL", getTournamentSiteURL())
		.append("matchLiveURL", getMatchLiveURL())
		.append("matchResult", getMatchResult())
		.append("matchArchiveURL", getMatchArchiveURL())
		.build();
	}
}
