package com.hkesports.matchticker.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicApiInfo;

@Entity
@Table(name = "schedule")
public class Schedule extends BasicApiInfo {
	
	private static final long serialVersionUID = 1L;

	private Boolean highlight = false;
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
	private Tourament tourament;
	private String touramentName;
	private Game game;
	private String matchLiveUrl;
	private String results;
	private String matchArchiveUrl;
	private Boolean display;
	private String name;
	private String namePublic;
	private Short isFinished;
	private Short noVods;
	private String season;
	private Short published;
	private Long winner;
	private List<ScheduleGame> scheduleGames = new ArrayList<>();
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time", nullable=false)
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time", nullable = true)
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Column(name = "tourament_name", length = 255, nullable = true)
	public String getTouramentName() {
		return touramentName;
	}
	
	public void setTouramentName(String touramentName) {
		this.touramentName = touramentName;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "game_id", nullable = true, columnDefinition="BIGINT(20)", referencedColumnName = "id")
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
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
	
	@Column(name="display", columnDefinition="TINYINT", nullable = true)
	public Boolean getDisplay() {
		return display;
	}
	
	public void setDisplay(Boolean display) {
		this.display = display;
	}
	
	@Column(name="name", length=255, nullable = true)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="name_public", length=255, nullable = true)
	public String getNamePublic() {
		return namePublic;
	}
	
	public void setNamePublic(String namePublic) {
		this.namePublic = namePublic;
	}
	
	@Column(name="is_finished", columnDefinition="SMALLINT(6)", nullable = true)
	public Short getIsFinished() {
		return isFinished;
	}
	
	public void setIsFinished(Short isFinished) {
		this.isFinished = isFinished;
	}
	
	@Column(name="no_vods", columnDefinition="SMALLINT(6)", nullable = true)
	public Short getNoVods() {
		return noVods;
	}
	
	public void setNoVods(Short noVods) {
		this.noVods = noVods;
	}
	
	@Column(name="season", length=50, nullable = true)
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	@Column(name="published", columnDefinition="SMALLINT(6)", nullable = true)
	public Short getPublished() {
		return published;
	}
	
	public void setPublished(Short published) {
		this.published = published;
	}
	
	@Column(name="winner", columnDefinition="BIGINT(20)", nullable = true)
	public Long getWinner() {
		return winner;
	}
	
	public void setWinner(Long winner) {
		this.winner = winner;
	}
	
	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
	public List<ScheduleGame> getScheduleGames() {
		return scheduleGames;
	}

	public void setScheduleGames(List<ScheduleGame> scheduleGames) {
		this.scheduleGames = scheduleGames;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "tourament_id", nullable = true, columnDefinition="BIGINT(20)", referencedColumnName = "id")
	public Tourament getTourament() {
		return tourament;
	}

	public void setTourament(Tourament tourament) {
		this.tourament = tourament;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("apiId", getApiId())
		.append("gameType", getGameType())
		.append("highlight", getHighlight())
		.append("teamAName", getTeamAName())
		.append("playerAName", getPlayerAName())
		.append("aSideSupportCount", getaSideSupportCount())
		.append("teamBName", getTeamBName())
		.append("playerBName", getPlayerBName())
		.append("bSideSupportCount", getbSideSupportCount())
		.append("startTime", getStartTime())
		.append("endTime", getEndTime())
		.append("touramentName", getTouramentName())
		.append("game", getGame())
		.append("matchLiveUrl", getMatchLiveUrl())
		.append("results", getResults())
		.append("matchArchiveUrl", getMatchArchiveUrl())
		.append("display", getDisplay())
		.append("name", getName())
		.append("namePublic", getNamePublic())
		.append("isFinished", getIsFinished())
		.append("noVods", getNoVods())
		.append("season", getSeason())
		.append("published", getPublished())
		.append("season", getSeason())
		.append("published", getPublished())
		.append("winner", getWinner())
		.build();
	}
}
