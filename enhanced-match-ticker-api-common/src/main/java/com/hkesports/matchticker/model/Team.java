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
@Table(name = "team")
public class Team extends BasicAuditModel {
	
	private static final long serialVersionUID = 1L;

	private Game game;
	private String teamName;
	private String teamFullName;
	private String country;
	private String teamIconSmall;
	private String teamIconLarge;
	private String teamUrl;
	private Long followerNumber;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "game_id", nullable = true, columnDefinition="BIGINT(20)", referencedColumnName = "id")
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
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
	
	@Column(name = "team_icon_small", length = 10, nullable = true)
	public String getTeamIconSmall() {
		return teamIconSmall;
	}
	
	public void setTeamIconSmall(String teamIconSmall) {
		this.teamIconSmall = teamIconSmall;
	}
	
	@Column(name = "team_icon_large", length = 10, nullable = true)
	public String getTeamIconLarge() {
		return teamIconLarge;
	}
	
	public void setTeamIconLarge(String teamIconLarge) {
		this.teamIconLarge = teamIconLarge;
	}
	
	@Column(name = "team_url", length = 255, nullable = true)
	public String getTeamUrl() {
		return teamUrl;
	}
	
	public void setTeamUrl(String teamUrl) {
		this.teamUrl = teamUrl;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("teamName", getTeamName())
		.append("teamFullName", getTeamFullName())
		.append("country", getCountry())
		.append("teamIconSmall", getTeamIconSmall())
		.append("teamIconLarge", getTeamIconLarge())
		.append("teamUrl", getTeamUrl())
		.build();
	}

	@Column(name = "follower_number", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getFollowerNumber() {
		return followerNumber;
	}

	public void setFollowerNumber(Long followerNumber) {
		this.followerNumber = followerNumber;
	}
}
