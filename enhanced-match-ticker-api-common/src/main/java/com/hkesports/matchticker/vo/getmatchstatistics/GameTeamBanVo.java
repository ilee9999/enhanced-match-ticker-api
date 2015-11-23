package com.hkesports.matchticker.vo.getmatchstatistics;

import java.io.Serializable;

public class GameTeamBanVo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String championName;
	private String championUrl;
	private String heroURL;
	private Integer pickTurn;// GamePicksBans.order

	public GameTeamBanVo() {
		
	}

	public GameTeamBanVo(String championName, String championUrl, String heroURL, Integer pickTurn) {
		this.championName = championName;
		this.championUrl = championUrl;
		this.heroURL = heroURL;
		this.pickTurn = pickTurn;
	}

	public String getChampionName() {
		return championName;
	}

	public void setChampionName(String championName) {
		this.championName = championName;
	}

	public String getChampionUrl() {
		return championUrl;
	}

	public void setChampionUrl(String championUrl) {
		this.championUrl = championUrl;
	}

	public Integer getPickTurn() {
		return pickTurn;
	}

	public void setPickTurn(Integer pickTurn) {
		this.pickTurn = pickTurn;
	}

	public String getHeroURL() {
		return heroURL;
	}

	public void setHeroURL(String heroURL) {
		this.heroURL = heroURL;
	}
}
