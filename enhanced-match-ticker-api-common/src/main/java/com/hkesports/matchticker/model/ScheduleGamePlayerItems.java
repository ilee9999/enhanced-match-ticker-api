package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hkesports.matchticker.enums.GameItemTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "schedule_game_player_items")
public class ScheduleGamePlayerItems extends BasicModel {
	
	private static final long serialVersionUID = 1L;

	private ScheduleGame scheduleGame;
	private Player player;
	private GameItemTypeEnum itemType;
	private Long itemId;
	private Short sequence = 0;
	
	@ManyToOne
	@JoinColumn(name="schedule_game_id", columnDefinition="BIGINT(20)", nullable=true)
	public ScheduleGame getScheduleGame() {
		return scheduleGame;
	}
	
	public void setScheduleGame(ScheduleGame scheduleGame) {
		this.scheduleGame = scheduleGame;
	}
	
	@ManyToOne
	@JoinColumn(name="player_id", columnDefinition="BIGINT(20)", referencedColumnName="id")
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
		
	@Enumerated(EnumType.STRING)
	@Column(name = "item_type", length = 10)
	public GameItemTypeEnum getItemType() {
		return itemType;
	}
	
	public void setItemType(GameItemTypeEnum itemType) {
		this.itemType = itemType;
	}
	
	@Column(name="item_id", columnDefinition = "BIGINT(20)")
	public Long getItemId() {
		return itemId;
	}
	
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	@Column(name="sequence", columnDefinition="SMALLINT(6)")
	public Short getSequence() {
		return sequence;
	}
	
	public void setSequence(Short sequence) {
		this.sequence = sequence;
	}
}
