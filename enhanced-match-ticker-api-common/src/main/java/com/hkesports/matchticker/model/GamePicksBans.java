package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "game_picks_bans")
public class GamePicksBans extends BasicModel {
	
	private static final long serialVersionUID = 1L;

	private GameTypeEnum gameType;
	private ScheduleGame scheduleGame;
	private Long teamId;
	private Hero hero;
	private Boolean isPick;
	private Integer order;

	@Enumerated(EnumType.STRING)
	@Column(name = "game_type", length = 10)
	public GameTypeEnum getGameType() {
		return gameType;
	}

	public void setGameType(GameTypeEnum gameType) {
		this.gameType = gameType;
	}

	@ManyToOne
	@JoinColumn(name="schedule_game_id", columnDefinition="BIGINT(20)", referencedColumnName="id", nullable=true)
	public ScheduleGame getScheduleGame() {
		return scheduleGame;
	}

	public void setScheduleGame(ScheduleGame scheduleGame) {
		this.scheduleGame = scheduleGame;
	}
	
	@Column(name="team_id", columnDefinition="BIGINT(20)", nullable=true)
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@OneToOne
	@JoinColumn(name="hero_id", columnDefinition="BIGINT(20)", referencedColumnName="id")
	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	@Column(name="is_pick", columnDefinition="TINYINT")
	public Boolean getIsPick() {
		return isPick;
	}

	public void setIsPick(Boolean isPick) {
		this.isPick = isPick;
	}

	@Column(name="item_order", columnDefinition="INT(11)", nullable=true)
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
}
