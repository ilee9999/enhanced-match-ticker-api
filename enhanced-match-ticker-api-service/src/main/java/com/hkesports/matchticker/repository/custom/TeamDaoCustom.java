package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.enums.GameTypeEnum;

public interface TeamDaoCustom {
	
	public <T>List<T> getAllTeamVoByMatchId(Long matchId, Class<T> t);
	
	public List<com.hkesports.matchticker.vo.getranking.TeamVo> getRankingTeamVo(GameTypeEnum gameType, Long matchId);
	
	public List<com.hkesports.matchticker.vo.getleaguetable.TeamVo> getLeaguetableTeamVo(GameTypeEnum gameType, Long matchId);
}
