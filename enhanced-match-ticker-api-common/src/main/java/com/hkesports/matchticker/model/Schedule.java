package com.hkesports.matchticker.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.ScheduleStatusEnum;
import com.hkesports.matchticker.model.basic.BasicAuditModel;

@Entity
@Table(name = "schedule")
public class Schedule extends BasicAuditModel {
	
	private static final long serialVersionUID = 1L;

	private Game game;
	private Tournament tournament;
	private String tournamentName;
	private Boolean highlight = Boolean.FALSE;
	private String teamAName;
	private Long teamAId;
	private String playerAName;
	private Long aSideSupportCount;
	private String teamBName;
	private Long teamBId;
	private String playerBName;
	private Long bSideSupportCount;
	private Date startTime;
	private Date endTime;
	private String matchLiveUrl;
	private String results;
	private String matchArchiveUrl;
	private Date dateTime;
	private Long winnerId;
	private Short maxGames;
	private Boolean isLive;
	private String isFinished;
	private ScheduleStatusEnum status;
	private List<ScheduleGame> scheduleGames = new ArrayList<>();
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "game_id", nullable = true, columnDefinition="BIGINT(20)", referencedColumnName = "id")
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "tournament_id", nullable = true, columnDefinition="BIGINT(20)", referencedColumnName = "id")
	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	@Column(name = "tournament_name", length = 255, nullable = true)
	public String getTournamentName() {
		return tournamentName;
	}
	
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	
	@Column(name = "highlight", columnDefinition = "TINYINT", nullable = false)
	public Boolean getHighlight() {
		return highlight;
	}
	
	public void setHighlight(Boolean highlight) {
		this.highlight = highlight;
	}
	
	@Column(name="team_a_name", length=50, nullable = true)
	public String getTeamAName() {
		return teamAName;
	}
	
	public void setTeamAName(String teamAName) {
		this.teamAName = teamAName;
	}
	
	@Column(name="team_a_id")
	public Long getTeamAId() {
		return teamAId;
	}

	public void setTeamAId(Long teamAId) {
		this.teamAId = teamAId;
	}

	@Column(name="player_a_name", length=64, nullable = true)
	public String getPlayerAName() {
		return playerAName;
	}
	
	public void setPlayerAName(String playerAName) {
		this.playerAName = playerAName;
	}
	
	@Column(name="a_side_support_count", columnDefinition="BIGINT(20)", nullable = true)
	public Long getaSideSupportCount() {
		return aSideSupportCount;
	}
	
	public void setaSideSupportCount(Long aSideSupportCount) {
		this.aSideSupportCount = aSideSupportCount;
	}
	
	@Column(name="team_b_name", length=50, nullable = true)
	public String getTeamBName() {
		return teamBName;
	}
	
	public void setTeamBName(String teamBName) {
		this.teamBName = teamBName;
	}
	
	@Column(name="team_b_id")
	public Long getTeamBId() {
		return teamBId;
	}

	public void setTeamBId(Long teamBId) {
		this.teamBId = teamBId;
	}
	
	@Column(name="player_b_name", length=64, nullable = true)
	public String getPlayerBName() {
		return playerBName;
	}
	
	public void setPlayerBName(String playerBName) {
		this.playerBName = playerBName;
	}
	
	@Column(name="b_side_support_count", columnDefinition="BIGINT(20)", nullable = true)
	public Long getbSideSupportCount() {
		return bSideSupportCount;
	}
	
	public void setbSideSupportCount(Long bSideSupportCount) {
		this.bSideSupportCount = bSideSupportCount;
	}
	
	@Column(name="start_time", columnDefinition = "DATETIME", nullable=false)
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Column(name = "end_time", columnDefinition = "DATETIME", nullable = true)
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="match_live_url", length=2048, nullable = true)
	public String getMatchLiveUrl() {
		return matchLiveUrl;
	}
	
	public void setMatchLiveUrl(String matchLiveUrl) {
		this.matchLiveUrl = matchLiveUrl;
	}
	
	@Column(name="results", length=32, nullable = true)
	public String getResults() {
		return results;
	}
	
	public void setResults(String results) {
		this.results = results;
	}
	
	@Column(name="match_archive_url", length=2048, nullable = true)
	public String getMatchArchiveUrl() {
		return matchArchiveUrl;
	}
	
	public void setMatchArchiveUrl(String matchArchiveUrl) {
		this.matchArchiveUrl = matchArchiveUrl;
	}
	
	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
	public List<ScheduleGame> getScheduleGames() {
		return scheduleGames;
	}

	public void setScheduleGames(List<ScheduleGame> scheduleGames) {
		this.scheduleGames = scheduleGames;
	}

	@Column(name =" date_time", columnDefinition = "DATETIME", nullable = true)
	public Date getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	@Column(name = "winner_id", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getWinnerId() {
		return winnerId;
	}
	
	public void setWinnerId(Long winnerId) {
		this.winnerId = winnerId;
	}
	
	@Column(name="max_games", columnDefinition="SMALLINT(6)", nullable=true)
	public Short getMaxGames() {
		return maxGames;
	}
	
	public void setMaxGames(Short maxGames) {
		this.maxGames = maxGames;
	}
	
	@Column(name = "is_live", columnDefinition = "TINYINT(4)", nullable = true)
	public Boolean getIsLive() {
		return isLive;
	}
	
	public void setIsLive(Boolean isLive) {
		this.isLive = isLive;
	}
	
	@Column(name = "is_finished", length = 10, nullable = true)
	public String getIsFinished() {
		return isFinished;
	}
	
	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
	}
	
	@Enumerated
	@Column(name = "status", columnDefinition = "TINYINT(4)", nullable = true)
	public ScheduleStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ScheduleStatusEnum status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("highlight", getHighlight())
		.append("teamAName", getTeamAName())
		.append("playerAName", getPlayerAName())
		.append("aSideSupportCount", getaSideSupportCount())
		.append("teamBName", getTeamBName())
		.append("playerBName", getPlayerBName())
		.append("bSideSupportCount", getbSideSupportCount())
		.append("startTime", getStartTime())
		.append("endTime", getEndTime())
		.append("tournamentName", getTournamentName())
		.append("game", getGame())
		.append("matchLiveUrl", getMatchLiveUrl())
		.append("results", getResults())
		.append("matchArchiveUrl", getMatchArchiveUrl())
		.append("dateTime", getDateTime())
		.append("maxGames", getMaxGames())
		.build();
	}
}
