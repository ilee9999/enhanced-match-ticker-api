package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicAuditModel;

@Entity
@Table(name = "player")
public class Player extends BasicAuditModel {
	
	private static final long serialVersionUID = 1L;

	private Game game;
	private String playerName;
	private String playerFullName;
	private String country;
	private String playerIconSmall;
	private String playerIconLarge;
	private String playerUrl;
	private String photoUrl;
	private String facebookUrl;
	private String twitterUrl;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "game_id", nullable = true, columnDefinition="BIGINT(20)", referencedColumnName = "id")
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
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
	
	@Column(name="player_icon_small", length = 10, nullable = true)
	public String getPlayerIconSmall() {
		return playerIconSmall;
	}
	
	public void setPlayerIconSmall(String playerIconSmall) {
		this.playerIconSmall = playerIconSmall;
	}
	
	@Column(name="player_icon_large", length = 10, nullable = true)
	public String getPlayerIconLarge() {
		return playerIconLarge;
	}
	
	public void setPlayerIconLarge(String playerIconLarge) {
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("playerName", getPlayerName())
		.append("playerFullName", getPlayerFullName())
		.append("country", getCountry())
		.append("playerIconSmall", getPlayerIconSmall())
		.append("playerIconLarge", getPlayerIconLarge())
		.append("playerUrl", getPlayerUrl())
		.append("photoUrl", getPhotoUrl())
		.append("facebookUrl", getFacebookUrl())
		.append("twitterUrl", getTwitterUrl())
		.build();
	}
}
