package com.hkesports.matchticker.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicApiInfo;

@Entity
@Table(name = "player")
public class Player extends BasicApiInfo {
	
	private static final long serialVersionUID = 1L;

	private String playerName;
	private String playerFullName;
	private String country;
	private Blob playerIconSmall;
	private Blob playerIconLarge;
	private String playerUrl;
	private String photoUrl;
	private String bio;
	private String hometown;
	private String facebookUrl;
	private String twitterUrl;
	private Short isStarter;
	private String residency;
	private Date contractExpiration;
	
	@Column(name="player_name", length=128)
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	@Column(name="player_full_name", length=128)
	public String getPlayerFullName() {
		return playerFullName;
	}
	
	public void setPlayerFullName(String playerFullName) {
		this.playerFullName = playerFullName;
	}
	
	@Column(name="country", length=2, nullable=true)
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name="player_icon_small", columnDefinition="BLOB", nullable=true)
	public Blob getPlayerIconSmall() {
		return playerIconSmall;
	}
	
	public void setPlayerIconSmall(Blob playerIconSmall) {
		this.playerIconSmall = playerIconSmall;
	}
	
	@Column(name="player_icon_large", columnDefinition="BLOB", nullable=true)
	public Blob getPlayerIconLarge() {
		return playerIconLarge;
	}
	
	public void setPlayerIconLarge(Blob playerIconLarge) {
		this.playerIconLarge = playerIconLarge;
	}
	
	@Column(name="player_url", length=255, nullable=true)
	public String getPlayerUrl() {
		return playerUrl;
	}
	
	public void setPlayerUrl(String playerUrl) {
		this.playerUrl = playerUrl;
	}
	
	@Column(name="photo_url", length=255, nullable=true)
	public String getPhotoUrl() {
		return photoUrl;
	}
	
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	@Column(name="bio", columnDefinition="TEXT", nullable=true)
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Column(name="hometown", length=100, nullable=true)
	public String getHometown() {
		return hometown;
	}
	
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	
	@Column(name="facebook_url", length=255, nullable=true)
	public String getFacebookUrl() {
		return facebookUrl;
	}
	
	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}
	
	@Column(name="twitter_url", length=255, nullable=true)
	public String getTwitterUrl() {
		return twitterUrl;
	}
	
	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}
	
	@Column(name="is_starter", columnDefinition="SMALLINT(6)", nullable=true)
	public Short getIsStarter() {
		return isStarter;
	}
	
	public void setIsStarter(Short isStarter) {
		this.isStarter = isStarter;
	}
	
	@Column(name="residency", length=255, nullable=true)
	public String getResidency() {
		return residency;
	}
	
	public void setResidency(String residency) {
		this.residency = residency;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="contract_expiration", nullable=true)
	public Date getContractExpiration() {
		return contractExpiration;
	}
	
	public void setContractExpiration(Date contractExpiration) {
		this.contractExpiration = contractExpiration;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("apiId", getApiId())
		.append("gameType", getGameType())
		.append("playerName", getPlayerName())
		.append("playerFullName", getPlayerFullName())
		.append("country", getCountry())
		.append("playerIconSmall", getPlayerIconSmall())
		.append("playerIconLarge", getPlayerIconLarge())
		.append("playerUrl", getPlayerUrl())
		.append("photoUrl", getPhotoUrl())
		.append("bio", getBio())
		.append("hometown", getHometown())
		.append("facebookUrl", getFacebookUrl())
		.append("twitterUrl", getTwitterUrl())
		.append("isStarter", getIsStarter())
		.append("residency", getResidency())
		.append("contractExpiration", getContractExpiration())
		.build();
	}
}
