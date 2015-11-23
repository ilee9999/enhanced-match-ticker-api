package com.hkesports.matchticker.repository.custom;

import java.util.Date;
import java.util.List;

import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.vo.getmatchstatistics.GameTeamVo;
import com.hkesports.matchticker.vo.getpersonalrecord.GameContestantVo;

public interface ScheduleGameDetailDaoCustom {
	
	public List<GameTeamVo> findGameTeamsByGameId(Long gameId);
	
	public int updateGuessCount(Long matchId, Integer gameNumber, Long contestantID, Date updateDate);
	
	/**
	 * 取得此user 對此比賽的下注狀況
	 * 會撈出此比賽所有隊伍 若ha為零 則代表此user沒對此隊伍下注
	 * @param userId
	 * @param userType
	 * @param createDate
	 * @param gameId (scheduleGame.id)
	 * @return
	 */
	public List<GameContestantVo> findAllGuessGameDetailRecord(Long userId, UserTypeEnum userType, Long gameId);
	
	public int insertForMakeGuess(Long scheduleGameId, Long contestantID, Date createDate);
}
