package com.hkesports.matchticker.vo.getgamelist;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

public class GetgamelistVo extends BasicVo {
	
	private static final long serialVersionUID = 1L;
	
	public GetgamelistVo() {}
	
	public GetgamelistVo(List<GameVo> games) {
		super();
		this.games = games;
	}
	
	private List<GameVo> games;

	@JsonProperty("Games")
	public List<GameVo> getGames() {
		return games;
	}

	public void setGames(List<GameVo> games) {
		this.games = games;
	}
	
	
}
