package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.vo.RequestVo;

public interface GameDaoCustom {

	public List<com.hkesports.matchticker.vo.getranking.GameVo> findRankingGameVo(RequestVo requestVo);
	
}
