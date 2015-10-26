package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.vo.getmatchstatistics.GameTeamPlayerVo;

public interface ScheduleGamePlayerDetailDaoCustom {

	public List<GameTeamPlayerVo> findGameTeamPlayerByGameDetail(Long scheduleGameDetailId);

}
