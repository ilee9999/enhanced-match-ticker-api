package com.hkesports.matchticker.vo.getleagueseasonlist;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class GetleagueseasonlistVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private List<LeagueSeasonVo> leagueSeasons;

	@JsonProperty("LeagueSeasons")
	public List<LeagueSeasonVo> getLeagueSeasons() {
		return leagueSeasons;
	}

	public void setLeagueSeasons(List<LeagueSeasonVo> leagueSeasons) {
		this.leagueSeasons = leagueSeasons;
	}
}
