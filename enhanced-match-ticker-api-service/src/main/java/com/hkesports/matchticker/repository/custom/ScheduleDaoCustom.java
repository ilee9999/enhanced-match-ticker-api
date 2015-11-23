package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.basic.UserHa;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.getleaguetable.TournamentVo;
import com.hkesports.matchticker.vo.getmatchconteststatus.ContestantsVo;
import com.hkesports.matchticker.vo.getpersonalrecord.RecordVo;
import com.hkesports.matchticker.vo.getresult.ResultVo;
import com.hkesports.matchticker.vo.getschedule.ResultScheduleVo;
import com.hkesports.matchticker.vo.gettournamentdetails.ScheduleVo;

public interface ScheduleDaoCustom {
	
	public List<ResultScheduleVo> findAllSchedule(RequestVo requestVo, UserHa userHa);
	
	public List<ResultVo> findAllResult(RequestVo requestVo);
	
	public List<TournamentVo> findAllLeaguetable(RequestVo requestVo);
	
	public int updateSupportCount(Long matchId, int aTeamCount, int bTeamCount);
	
	public <T> List<T> findAllLastEncounter(Class<T> clazz, Long matchId, Long teamId);
	
	public <T> List<T> findAllRecentPerformance(Class<T> clazz, Long matchId, Long teamId);
	
	public List<com.hkesports.matchticker.vo.getmatchstatistics.GameVo> findAllLOLGamesByMatchId(Long matchId);
	
	public List<com.hkesports.matchticker.vo.getmatchstatistics.GameVo> findAllDota2GamesByMatchId(Long matchId);
	
	public List<ContestantsVo> findAllMatchConteststatus(Long matchId, Short gameNumber);
	
	/**
	 * 取得用戶過往競猜記錄，
	 * 如果手機App有提供Year就把當年的競猜記錄交到手機App，
	 * 否則就只把今年的記錄給到手機App
	 * @param userId
	 * @param userType
	 * @param year
	 * @return
	 */
	public List<RecordVo> findAllScheduleByGuessRecord(Long userId, UserTypeEnum userType, Integer year, Integer month);
	
	public List<ScheduleVo> findAllScheduleVoByTournamentId(Long tournamentId, UserHa userHa);
	
}
