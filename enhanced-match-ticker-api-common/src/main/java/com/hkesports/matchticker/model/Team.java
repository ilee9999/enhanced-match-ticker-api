package com.hkesports.matchticker.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicApiInfo;

@Entity
@Table(name = "team")
public class Team extends BasicApiInfo {
	private static final long serialVersionUID = 1L;

	private String teamName;
	private String teamFullName;
	private String country;
	private Blob teamIconSmall;
	private Blob teamIconLarge;
	private String teamUrl;
	private String bio;
	private String teamPhotoUrl;
	private String logoUrl;
	private Short noPlayers;
	private String rating;
	
	@Column(name="team_name", length=128)
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	@Column(name = "team_full_name", length = 128)
	public String getTeamFullName() {
		return teamFullName;
	}
	
	public void setTeamFullName(String teamFullName) {
		this.teamFullName = teamFullName;
	}
	
	@Column(name = "country", length = 2, nullable = true)
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Lob
	@Column(name = "team_icon_small", columnDefinition = "BLOB", nullable = true)
	public Blob getTeamIconSmall() {
		return teamIconSmall;
	}
	
	public void setTeamIconSmall(Blob teamIconSmall) {
		this.teamIconSmall = teamIconSmall;
	}
	
	@Lob
	@Column(name = "team_icon_large", columnDefinition = "BLOB", nullable = true)
	public Blob getTeamIconLarge() {
		return teamIconLarge;
	}
	
	public void setTeamIconLarge(Blob teamIconLarge) {
		this.teamIconLarge = teamIconLarge;
	}
	
	@Column(name = "team_url", length = 255, nullable = true)
	public String getTeamUrl() {
		return teamUrl;
	}
	
	public void setTeamUrl(String teamUrl) {
		this.teamUrl = teamUrl;
	}
	
	@Column(name = "bio", columnDefinition = "TEXT", nullable = true)
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Column(name = "team_photo_url", length = 255, nullable = true)
	public String getTeamPhotoUrl() {
		return teamPhotoUrl;
	}
	public void setTeamPhotoUrl(String teamPhotoUrl) {
		this.teamPhotoUrl = teamPhotoUrl;
	}
	
	@Column(name = "logo_url", length = 255, nullable = true)
	public String getLogoUrl() {
		return logoUrl;
	}
	
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	@Column(name = "no_players", columnDefinition = "SMALLINT(6)", nullable = true)
	public Short getNoPlayers() {
		return noPlayers;
	}
	
	public void setNoPlayers(Short noPlayers) {
		this.noPlayers = noPlayers;
	}
	
	@Column(name = "rating", length = 255, nullable = true)
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("apiId", getApiId())
		.append("gameType", getGameType())
		.append("teamName", getTeamName())
		.append("teamFullName", getTeamFullName())
		.append("country", getCountry())
		.append("teamIconSmall", getTeamIconSmall())
		.append("teamIconLarge", getTeamIconLarge())
		.append("teamUrl", getTeamUrl())
		.append("bio", getBio())
		.append("teamPhotoUrl", getTeamPhotoUrl())
		.append("logoUrl", getLogoUrl())
		.append("noPlayers", getNoPlayers())
		.append("rating", getRating())
		.build();
	}
}
