package com.hkesports.matchticker.vo.getleaguetable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class GetleaguetableVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private List<TournamentVo> tournaments;

	@JsonProperty("tournaments")
	public List<TournamentVo> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<TournamentVo> tournaments) {
		this.tournaments = tournaments;
	}
}
