package com.hkesports.matchticker.vo.getpersonalrecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer day;
	
	private List<TournamentVo> tournament = new ArrayList<>();

	public DayVo() {}
	
	public DayVo(Integer day) {
		this.day = day;
	}
	
	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@JsonProperty("Tournament")
	public List<TournamentVo> getTournament() {
		return tournament;
	}

	public void setTournament(List<TournamentVo> tournament) {
		this.tournament = tournament;
	}

	public void addTournament(TournamentVo vo) {
		tournament.add(vo);
	}
}
