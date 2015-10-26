package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.gettournamentlist.TournamentVo;

/**
 * @author manboyu
 *
 */
public interface TouramentDaoCustom {

	public List<TournamentVo> getTournamentlistByPast(boolean past, RequestVo requestVo);
}
