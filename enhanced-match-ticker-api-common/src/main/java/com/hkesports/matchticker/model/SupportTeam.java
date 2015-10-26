package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "support_team")
public class SupportTeam extends BasicModel {
	private static final long serialVersionUID = 1L;

	private String userId;
	private Long matchId;
	private Long teamId;

	@Column(name = "user_id", columnDefinition = "VARCHAR(255)", length = 255, nullable = false)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "match_id", columnDefinition = "BIGINT(20)", nullable = false)
	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	@Column(name = "team_id", columnDefinition = "BIGINT(20)", nullable = false)
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

}
