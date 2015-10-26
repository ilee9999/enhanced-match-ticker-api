package com.hkesports.matchticker.vo.getmatchstatistics;

import java.io.Serializable;

public class GameTeamBanVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long championID;// GamePicksBans.hero.id
	private Integer pickTurn;// GamePicksBans.order
	
	
	public GameTeamBanVo() {}
	public GameTeamBanVo(Long championID, Integer pickTurn) {
		super();
		this.championID = championID;
		this.pickTurn = pickTurn;
	}
	
	public Long getChampionID() {
		return championID;
	}
	public void setChampionID(Long championID) {
		this.championID = championID;
	}
	public Integer getPickTurn() {
		return pickTurn;
	}
	public void setPickTurn(Integer pickTurn) {
		this.pickTurn = pickTurn;
	}

}
