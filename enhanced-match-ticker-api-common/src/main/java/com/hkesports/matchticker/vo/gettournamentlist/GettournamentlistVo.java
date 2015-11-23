package com.hkesports.matchticker.vo.gettournamentlist;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class GettournamentlistVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private List<TournamentVo> Tournament;

	@JsonProperty(value="Tournament")
	public List<TournamentVo> getTournament() {
		return Tournament;
	}

	public void setTournament(List<TournamentVo> tournament) {
		Tournament = tournament;
	}
}
