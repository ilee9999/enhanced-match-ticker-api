package com.hkesports.matchticker.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicApiInfo;

@Entity
@Table(name = "game")
public class Game extends BasicApiInfo {
	
	private static final long serialVersionUID = 1L;

	private String enGameName;
	private String twGameName;
	private Blob gameIconSmall;
	private Blob gameIconLarge;
	private String gameUrl;
	private Boolean team = true;
	private Blob teamADefaultIconSmall;
	private Blob teamBDefaultIconSmall;
	private Blob teamADefaultIconLarge;
	private Blob teamBDefaultIconLarge;
	private Short winScore = 3;
	private Short drawScore = 1;
	private Short loseScore = 0;
	private Date dateTime;
	private Long winnerId;
	private Short maxGames;
	private Boolean isLive;
	private String isFinished;
	private String polldaddyId;
	
	@Column(name = "en_game_name", length = 100, nullable = false)
	public String getEnGameName() {
		return enGameName;
	}
	
	public void setEnGameName(String enGameName) {
		this.enGameName = enGameName;
	}
	
	@Column(name = "tw_game_name", length = 100, nullable = false)
	public String getTwGameName() {
		return twGameName;
	}
	
	public void setTwGameName(String twGameName) {
		this.twGameName = twGameName;
	}
	
	@Lob
	@Column(name = "game_icon_small", columnDefinition = "BLOB", nullable = true)
	public Blob getGameIconSmall() {
		return gameIconSmall;
	}
	
	public void setGameIconSmall(Blob gameIconSmall) {
		this.gameIconSmall = gameIconSmall;
	}
	
	@Lob
	@Column(name = "game_icon_large", columnDefinition = "BLOB", nullable = true)
	public Blob getGameIconLarge() {
		return gameIconLarge;
	}
	
	public void setGameIconLarge(Blob gameIconLarge) {
		this.gameIconLarge = gameIconLarge;
	}
	
	@Column(name = "game_url", length = 255, nullable = true)
	public String getGameUrl() {
		return gameUrl;
	}
	
	public void setGameUrl(String gameUrl) {
		this.gameUrl = gameUrl;
	}
	
	@Column(name = "team", columnDefinition = "TINYINT(4)", nullable=false)
	public Boolean getTeam() {
		return team;
	}
	
	public void setTeam(Boolean team) {
		this.team = team;
	}
	
	@Lob
	@Column(name = "team_a_default_icon_small", columnDefinition = "BLOB", nullable = true)
	public Blob getTeamADefaultIconSmall() {
		return teamADefaultIconSmall;
	}
	
	public void setTeamADefaultIconSmall(Blob teamADefaultIconSmall) {
		this.teamADefaultIconSmall = teamADefaultIconSmall;
	}
	
	@Lob
	@Column(name = "team_b_default_icon_small", columnDefinition = "BLOB", nullable = true)
	public Blob getTeamBDefaultIconSmall() {
		return teamBDefaultIconSmall;
	}
	
	public void setTeamBDefaultIconSmall(Blob teamBDefaultIconSmall) {
		this.teamBDefaultIconSmall = teamBDefaultIconSmall;
	}
	
	@Lob
	@Column(name = "team_a_default_icon_large", columnDefinition = "BLOB", nullable = true)
	public Blob getTeamADefaultIconLarge() {
		return teamADefaultIconLarge;
	}
	
	public void setTeamADefaultIconLarge(Blob teamADefaultIconLarge) {
		this.teamADefaultIconLarge = teamADefaultIconLarge;
	}
	
	@Lob
	@Column(name = "team_b_default_icon_large", columnDefinition = "BLOB", nullable = true)
	public Blob getTeamBDefaultIconLarge() {
		return teamBDefaultIconLarge;
	}
	
	public void setTeamBDefaultIconLarge(Blob teamBDefaultIconLarge) {
		this.teamBDefaultIconLarge = teamBDefaultIconLarge;
	}
	
	@Column(name = "win_score", columnDefinition = "SMALLINT(6)", nullable = false)
	public Short getWinScore() {
		return winScore;
	}
	
	public void setWinScore(Short winScore) {
		this.winScore = winScore;
	}
	
	@Column(name = "draw_score", columnDefinition = "SMALLINT(6)", nullable=false)
	public Short getDrawScore() {
		return drawScore;
	}
	
	public void setDrawScore(Short drawScore) {
		this.drawScore = drawScore;
	}
	
	@Column(name = "lose_score", columnDefinition = "SMALLINT(6)", nullable = false)
	public Short getLoseScore() {
		return loseScore;
	}
	
	public void setLoseScore(Short loseScore) {
		this.loseScore = loseScore;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name =" date_time", nullable = true)
	public Date getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	@Column(name = "winner_id", columnDefinition = "SMALLINT(6)", nullable = true)
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
	
	@Column(name = "polldaddy_id", length = 255, nullable = true)
	public String getPolldaddyId() {
		return polldaddyId;
	}
	
	public void setPolldaddyId(String polldaddyId) {
		this.polldaddyId = polldaddyId;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("apiId", getApiId())
		.append("gameType", getGameType())
		.append("enGameName", getEnGameName())
		.append("twGameName", getTwGameName())
		.append("gameIconSmall", getGameIconSmall())
		.append("gameIconLarge", getGameIconLarge())
		.append("gameUrl", getGameUrl())
		.append("team", getTeam())
		.append("teamADefaultIconSmall", getTeamADefaultIconSmall())
		.append("teamBDefaultIconSmall", getTeamBDefaultIconSmall())
		.append("teamADefaultIconLarge", getTeamADefaultIconLarge())
		.append("teamBDefaultIconLarge", getTeamBDefaultIconLarge())
		.append("winScore", getWinScore())
		.append("drawScore", getDrawScore())
		.append("loseScore", getLoseScore())
		.append("dateTime", getDateTime())
		.append("winnerId", getWinnerId())
		.append("maxGames", getMaxGames())
		.append("isLive", getIsLive())
		.append("isFinished", getIsFinished())
		.append("polldaddyId", getPolldaddyId())
		.build();
	}
}
