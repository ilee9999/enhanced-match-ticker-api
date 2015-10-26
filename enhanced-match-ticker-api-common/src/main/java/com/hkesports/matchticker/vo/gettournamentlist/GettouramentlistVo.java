package com.hkesports.matchticker.vo.gettournamentlist;

import java.util.List;

import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class GettouramentlistVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private List<TournamentVo> Tourament;

	public List<TournamentVo> getTourament() {
		return Tourament;
	}

	public void setTourament(List<TournamentVo> tourament) {
		Tourament = tourament;
	}
}
