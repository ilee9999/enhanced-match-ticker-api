package com.hkesports.matchticker.service;

import com.hkesports.matchticker.vo.getcontestantlist.GetcontestantlistVo;
import com.hkesports.matchticker.vo.getgamelist.GetgamelistVo;

public interface GameService {
	
	/**
	 * API: /rest/emt/api/v1/getgamelist
	 * @return
	 */
	public GetgamelistVo getGameList();
	
	/**
	 * API: /rest/emt/api/v1/getcontestantlist
	 * @param gameID
	 * @return
	 */
	public GetcontestantlistVo getContestantList(Long gameID);
}
