package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.vo.getpersonalrecord.GameVo;

public interface ScheduleGameDaoCustom {

	/**
	 * 取得此user 對此match的下注狀況
	 * 將會取得此match下所有此user有下過注的game (scheduleGame)
	 * @param userId
	 * @param userType
	 * @param matchId (schedule.id)
	 * @return
	 */
	public List<GameVo> findAllGuessGameRecord(Long userId, UserTypeEnum userType, Long matchId);
	
}
