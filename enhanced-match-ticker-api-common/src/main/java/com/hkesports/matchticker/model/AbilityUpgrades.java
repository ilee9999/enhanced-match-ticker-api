package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "ability_upgrades")
@BatchSize(size=100)
public class AbilityUpgrades extends BasicModel {
	private static final long serialVersionUID = 1L;

	private Player player;
	private ScheduleGame scheduleGame;
	private Integer time;
	private Integer level;
	private Integer apiId;

	@OneToOne
	@JoinColumn(name="player_id", columnDefinition="BIGINT(20)", referencedColumnName="id")
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@OneToOne
	@JoinColumn(name="schedule_game_id", columnDefinition="BIGINT(20)", referencedColumnName="id")
	public ScheduleGame getScheduleGame() {
		return scheduleGame;
	}

	public void setScheduleGame(ScheduleGame scheduleGame) {
		this.scheduleGame = scheduleGame;
	}

	@Column(name="time", columnDefinition="INT(11)", nullable=true)
	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	@Column(name="level", columnDefinition="INT(11)")
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name="api_id", columnDefinition="INT(11)", nullable=true)
	public Integer getApiId() {
		return apiId;
	}

	public void setApiId(Integer apiId) {
		this.apiId = apiId;
	}
}
