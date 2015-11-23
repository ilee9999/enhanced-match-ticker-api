package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.gettournamentlist.TournamentVo;

/**
 * @author manboyu
 *
 */
public interface TournamentDaoCustom {

	public List<TournamentVo> getTournamentlistByPast(boolean past, RequestVo requestVo);
	
	public List<com.hkesports.matchticker.vo.getknockoutrtournamenttable.TournamentVo> getTournamentlist(RequestVo requestVo);
}
