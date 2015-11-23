package com.hkesports.matchticker.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hkesports.matchticker.model.basic.BasicAuditModel;
import com.hkesports.matchticker.utils.Const;

@Entity
@Table(name = "league")
public class League extends BasicAuditModel {

	private static final long serialVersionUID = 1L;

	private Game game;
	private String seasonName;
	private String seasonDetails;
	private Date seasonStartDate;
	private Date seasonEndDate;
	private String leagueImage;
	private Boolean published = true;
	private String url;
	private List<LiveStreams> liveStreams = new ArrayList<>();
	
	public League() {
		
	}
	
	public League(Long id, String gameName, String seasonName, String seasonDetails,
			Date seasonStartDate, Date seasonEndDate, Boolean published) {
		this.setId(id);
		this.game = new Game();
		this.game.setEnGameName(gameName);
		this.seasonName = seasonName;
		this.seasonDetails = seasonDetails;
		this.seasonStartDate = seasonStartDate;
		this.seasonEndDate = seasonEndDate;
		this.published = published;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "game_id", nullable = true, columnDefinition="BIGINT(20)", referencedColumnName = "id")
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	@Column(name = "season_name", length = 255, nullable = true)
	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}
	
	@Column(name = "season_details", length = 255, nullable = true)
	public String getSeasonDetails() {
		return seasonDetails;
	}

	public void setSeasonDetails(String seasonDetails) {
		this.seasonDetails = seasonDetails;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	@Column(name = "season_start_date", columnDefinition = "DATETIME", nullable = true)
	public Date getSeasonStartDate() {
		return seasonStartDate;
	}

	public void setSeasonStartDate(Date seasonStartDate) {
		this.seasonStartDate = seasonStartDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	@Column(name = "season_end_date", columnDefinition = "DATETIME", nullable = true)
	public Date getSeasonEndDate() {
		return seasonEndDate;
	}

	public void setSeasonEndDate(Date seasonEndDate) {
		this.seasonEndDate = seasonEndDate;
	}

	@Column(name = "league_image", length = 255, nullable = true)
	public String getLeagueImage() {
		return leagueImage;
	}

	public void setLeagueImage(String leagueImage) {
		this.leagueImage = leagueImage;
	}
	
	@Column(name = "published", columnDefinition = "SMALLINT(6)", nullable = true)
	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	@OneToMany(mappedBy = "league", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<LiveStreams> getLiveStreams() {
		return liveStreams;
	}

	public void setLiveStreams(List<LiveStreams> liveStreams) {
		this.liveStreams = liveStreams;
	}

	@Column(name = "url", length = 255, nullable = true)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
