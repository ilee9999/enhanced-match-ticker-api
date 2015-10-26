package com.hkesports.matchticker.service;

import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.gettournamentlist.GettouramentlistVo;

/**
 * @author manboyu
 *
 */
public interface TouramentService {

	public GettouramentlistVo getTouramentList(boolean past, RequestVo requestVo);
}
