package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.vo.RequestVo;

public interface GameDaoCustom {

	public List<com.hkesports.matchticker.vo.getmatchstatistics.GameVo> findGamesByMatchId(GameTypeEnum gameType, Long matchId);
	
	public List<com.hkesports.matchticker.vo.getranking.GameVo> getRankingGameVo(RequestVo requestVo);
}
