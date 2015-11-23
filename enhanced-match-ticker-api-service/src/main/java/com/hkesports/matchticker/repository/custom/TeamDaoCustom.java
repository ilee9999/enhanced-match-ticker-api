package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.model.basic.UserHa;
import com.hkesports.matchticker.vo.BasicTeamVo;
import com.hkesports.matchticker.vo.getknockoutrtournamenttable.ContestantsVo;

public interface TeamDaoCustom {
	
	public <T extends BasicTeamVo> List<T> findAllTeamVoByMatchId(Long matchId, Class<T> t);
	
	public List<com.hkesports.matchticker.vo.gettournamentdetails.ContestantsVo> findAllTeamVoByMatchIdOrUser(Long matchId, UserHa userHa);
	
	public List<com.hkesports.matchticker.vo.getcontestantlist.ContestantsVo> findAllTeamVoByGameId(Long gameId);
	
	public List<com.hkesports.matchticker.vo.getranking.ContestantsVo> findAllRankingTeamVo(Long gameId, Long tournamentId);
	
	public List<com.hkesports.matchticker.vo.getleaguetable.ContestantsVo> findAllLeaguetableTeamVoByTournamentId(Long tournamentId);
	
	public List<ContestantsVo> findAllKnockoutrTournamentTeamVoByTournamentId(Long tournamentId);
	
	public List<com.hkesports.matchticker.vo.gettournamentdetails.TournamentContestantsVo> findAllTournamentDetailsTeamVoByTournamentId(Long tournamentId, UserHa userHa);
}
