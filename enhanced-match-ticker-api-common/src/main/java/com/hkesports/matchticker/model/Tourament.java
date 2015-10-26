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

/**
 * @author manboyu
 *
 */
@Entity
@Table(name = "tourament")
public class Tourament extends BasicApiInfo {

	private static final long serialVersionUID = 1L;

	private String touramentName;
	private String touramentShortName;
	private Blob touramentIconSmall;
	private Blob touramentIconLarge;
	private Blob touramentIconHuge;
	private Date touramentFromDate;
	private Date touramentToDate;
	private String touramentDescription;
	private String touramentChannelURL;
	private String touramentSiteUrl;
	private Short winScore = 3;
	private Short drawScore = 1;
	private Short loseScore = 0;
	private String color;
	private String leagueImage;
	private Long defaultScheduleId;
	private Short noVods;
	private Integer menuWeight;
	private Short published;

	@Column(name = "tourament_Name", length = 255, nullable = false)
	public String getTouramentName() {
		return touramentName;
	}

	public void setTouramentName(String touramentName) {
		this.touramentName = touramentName;
	}

	@Column(name = "tourament_short_name", length = 100, nullable = false)
	public String getTouramentShortName() {
		return touramentShortName;
	}

	public void setTouramentShortName(String touramentShortName) {
		this.touramentShortName = touramentShortName;
	}

	@Lob
	@Column(name = "tourament_icon_small", columnDefinition = "BLOB", nullable = true)
	public Blob getTouramentIconSmall() {
		return touramentIconSmall;
	}

	public void setTouramentIconSmall(Blob touramentIconSmall) {
		this.touramentIconSmall = touramentIconSmall;
	}

	@Lob
	@Column(name = "tourament_icon_large", columnDefinition = "BLOB", nullable = true)
	public Blob getTouramentIconLarge() {
		return touramentIconLarge;
	}

	public void setTouramentIconLarge(Blob touramentIconLarge) {
		this.touramentIconLarge = touramentIconLarge;
	}
	
	@Lob
	@Column(name = "tourament_icon_Huge", columnDefinition = "BLOB", nullable = true)
	public Blob getTouramentIconHuge() {
		return touramentIconHuge;
	}

	public void setTouramentIconHuge(Blob touramentIconHuge) {
		this.touramentIconHuge = touramentIconHuge;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tourament_from_date", nullable = true)
	public Date getTouramentFromDate() {
		return touramentFromDate;
	}

	public void setTouramentFromDate(Date touramentFromDate) {
		this.touramentFromDate = touramentFromDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tourament_to_date", nullable = true)
	public Date getTouramentToDate() {
		return touramentToDate;
	}

	public void setTouramentToDate(Date touramentToDate) {
		this.touramentToDate = touramentToDate;
	}

	@Column(name = "tourament_description", columnDefinition = "TEXT", nullable = true)
	public String getTouramentDescription() {
		return touramentDescription;
	}

	public void setTouramentDescription(String touramentDescription) {
		this.touramentDescription = touramentDescription;
	}

	@Column(name = "tourament_channel_url", length = 255, nullable = true)
	public String getTouramentChannelURL() {
		return touramentChannelURL;
	}

	public void setTouramentChannelURL(String touramentChannelURL) {
		this.touramentChannelURL = touramentChannelURL;
	}

	@Column(name = "tourament_site_url", length = 255, nullable = false)
	public String getTouramentSiteUrl() {
		return touramentSiteUrl;
	}

	public void setTouramentSiteUrl(String touramentSiteUrl) {
		this.touramentSiteUrl = touramentSiteUrl;
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

	@Column(name = "color", length = 7, nullable = true)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "league_image", length = 255, nullable = true)
	public String getLeagueImage() {
		return leagueImage;
	}

	public void setLeagueImage(String leagueImage) {
		this.leagueImage = leagueImage;
	}

	@Column(name = "default_schedule_id", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getDefaultScheduleId() {
		return defaultScheduleId;
	}

	public void setDefaultScheduleId(Long defaultScheduleId) {
		this.defaultScheduleId = defaultScheduleId;
	}

	@Column(name = "no_vods", columnDefinition = "SMALLINT(6)", nullable = true)
	public Short getNoVods() {
		return noVods;
	}

	public void setNoVods(Short noVods) {
		this.noVods = noVods;
	}

	@Column(name = "menu_weight", columnDefinition = "INT(11)", nullable = true)
	public Integer getMenuWeight() {
		return menuWeight;
	}

	public void setMenuWeight(Integer menuWeight) {
		this.menuWeight = menuWeight;
	}

	@Column(name = "published", columnDefinition = "SMALLINT(6)", nullable = true)
	public Short getPublished() {
		return published;
	}

	public void setPublished(Short published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("touramentName", getTouramentName())
		.append("touramentShortName", getTouramentShortName())
		.append("touramentIconSmall", getTouramentIconSmall())
		.append("touramentIconLarge", getTouramentIconLarge())
		.append("touramentIconHuge", getTouramentIconHuge())
		.append("touramentFromDate", getTouramentFromDate())
		.append("touramentToDate", getTouramentToDate())
		.append("touramentDescription", getTouramentDescription())
		.append("touramentChannelURL", getTouramentChannelURL())
		.append("touramentSiteUrl", getTouramentSiteUrl())
		.append("winScore", getWinScore())
		.append("drawScore", getDrawScore())
		.append("loseScore", getLoseScore())
		.append("gameType", getGameType())
		.append("apiId", getApiId())
		.append("color", getColor())
		.append("leagueImage", getLeagueImage())
		.append("noVods", getNoVods())
		.append("menuWeight", getMenuWeight())
		.append("published", getPublished())
		.build();
	}
}

