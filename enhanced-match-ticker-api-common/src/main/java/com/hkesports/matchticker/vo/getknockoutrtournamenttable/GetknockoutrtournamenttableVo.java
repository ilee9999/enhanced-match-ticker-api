package com.hkesports.matchticker.vo.getknockoutrtournamenttable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

public class GetknockoutrtournamenttableVo extends BasicVo {

	private static final long serialVersionUID = 1L;
	
	private List<TournamentVo> tournaments;

	@JsonProperty("Tournaments")
	public List<TournamentVo> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<TournamentVo> tournaments) {
		this.tournaments = tournaments;
	}
}
