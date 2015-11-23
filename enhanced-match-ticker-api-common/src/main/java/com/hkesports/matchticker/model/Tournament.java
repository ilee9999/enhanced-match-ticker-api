package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicAuditModel;

/**
 * @author manboyu
 *
 */
@Entity
@Table(name = "tournament")
public class Tournament extends BasicAuditModel {

	private static final long serialVersionUID = 1L;

	private Game game;
	private League league;
	private String tournamentName;
	private String tournamentShortName;
	private String tournamentIconSmall;
	private String tournamentIconLarge;
	private String tournamentIconHuge;
	private Date tournamentFromDate;
	private Date tournamentToDate;
	private String tournamentDescription;
	private String tournamentChannelUrl;
	private String tournamentSiteUrl;
	private String tournamentCompetitionSystem;
	private String tournamentPrizePool;
	private String tournamentDetails;
	private Short winScore = 3;
	private Short drawScore = 1;
	private Short loseScore = 0;
	private Boolean published;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "game_id", nullable = true, columnDefinition="BIGINT(20)", referencedColumnName = "id")
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "league_id", nullable = true, columnDefinition="BIGINT(20)", referencedColumnName = "id")
	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
	
	@Column(name = "tournament_Name", length = 255, nullable = false)
	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	@Column(name = "tournament_short_name", length = 100, nullable = false)
	public String getTournamentShortName() {
		return tournamentShortName;
	}

	public void setTournamentShortName(String tournamentShortName) {
		this.tournamentShortName = tournamentShortName;
	}

	@Column(name = "tournament_icon_small", length = 10, nullable = true)
	public String getTournamentIconSmall() {
		return tournamentIconSmall;
	}

	public void setTournamentIconSmall(String tournamentIconSmall) {
		this.tournamentIconSmall = tournamentIconSmall;
	}

	@Column(name = "tournament_icon_large", length = 10, nullable = true)
	public String getTournamentIconLarge() {
		return tournamentIconLarge;
	}

	public void setTournamentIconLarge(String tournamentIconLarge) {
		this.tournamentIconLarge = tournamentIconLarge;
	}
	
	@Column(name = "tournament_icon_Huge", length = 10, nullable = true)
	public String getTournamentIconHuge() {
		return tournamentIconHuge;
	}

	public void setTournamentIconHuge(String tournamentIconHuge) {
		this.tournamentIconHuge = tournamentIconHuge;
	}

	@Column(name = "tournament_from_date", columnDefinition = "DATETIME", nullable = true)
	public Date getTournamentFromDate() {
		return tournamentFromDate;
	}

	public void setTournamentFromDate(Date tournamentFromDate) {
		this.tournamentFromDate = tournamentFromDate;
	}

	@Column(name = "tournament_to_date", columnDefinition = "DATETIME", nullable = true)
	public Date getTournamentToDate() {
		return tournamentToDate;
	}

	public void setTournamentToDate(Date tournamentToDate) {
		this.tournamentToDate = tournamentToDate;
	}

	@Column(name = "tournament_description", columnDefinition = "TEXT", nullable = true)
	public String getTournamentDescription() {
		return tournamentDescription;
	}

	public void setTournamentDescription(String tournamentDescription) {
		this.tournamentDescription = tournamentDescription;
	}

	@Column(name = "tournament_channel_url", length = 255, nullable = true)
	public String getTournamentChannelUrl() {
		return tournamentChannelUrl;
	}

	public void setTournamentChannelUrl(String tournamentChannelUrl) {
		this.tournamentChannelUrl = tournamentChannelUrl;
	}

	@Column(name = "tournament_site_url", length = 255, nullable = true)
	public String getTournamentSiteUrl() {
		return tournamentSiteUrl;
	}

	public void setTournamentSiteUrl(String tournamentSiteUrl) {
		this.tournamentSiteUrl = tournamentSiteUrl;
	}

	@Column(name = "tournament_competition_system", length = 10, nullable = true)
	public String getTournamentCompetitionSystem() {
		return tournamentCompetitionSystem;
	}

	public void setTournamentCompetitionSystem(String tournamentCompetitionSystem) {
		this.tournamentCompetitionSystem = tournamentCompetitionSystem;
	}

	@Column(name = "tournament_prize_pool", columnDefinition = "TEXT", nullable = true)
	public String getTournamentPrizePool() {
		return tournamentPrizePool;
	}

	public void setTournamentPrizePool(String tournamentPrizePool) {
		this.tournamentPrizePool = tournamentPrizePool;
	}

	@Column(name = "tournament_details", columnDefinition = "TEXT", nullable = true)
	public String getTournamentDetails() {
		return tournamentDetails;
	}

	public void setTournamentDetails(String tournamentDetails) {
		this.tournamentDetails = tournamentDetails;
	}

	@Column(name = "win_score", columnDefinition = "SMALLINT(6)", nullable = false)
	public Short getWinScore() {
		return winScore;
	}

	public void setWinScore(Short winScore) {
		this.winScore = winScore;
	}

	@Column(name = "draw_score", columnDefinition = "SMALLINT(6)", nullable = false)
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
	
	@Column(name = "published", columnDefinition = "SMALLINT(6)", nullable = true)
	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("tournamentName", getTournamentName())
		.append("tournamentShortName", getTournamentShortName())
		.append("tournamentIconSmall", getTournamentIconSmall())
		.append("tournamentIconLarge", getTournamentIconLarge())
		.append("tournamentIconHuge", getTournamentIconHuge())
		.append("tournamentFromDate", getTournamentFromDate())
		.append("tournamentToDate", getTournamentToDate())
		.append("tournamentDescription", getTournamentDescription())
		.append("tournamentChannelUrl", getTournamentChannelUrl())
		.append("tournamentSiteUrl", getTournamentSiteUrl())
		.append("winScore", getWinScore())
		.append("drawScore", getDrawScore())
		.append("loseScore", getLoseScore())
		.append("tournamentCompetitionSystem", getTournamentCompetitionSystem())
		.build();
	}
}

