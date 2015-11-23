package com.hkesports.matchticker.repository;

import com.hkesports.matchticker.enums.GameWinTypeEnum;
import com.hkesports.matchticker.model.ScheduleGameDetail;
import com.hkesports.matchticker.model.Team;
import com.hkesports.matchticker.repository.custom.ScheduleGameDetailDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface ScheduleGameDetailDao extends GenericRepository<ScheduleGameDetail, Long>, ScheduleGameDetailDaoCustom {

	public Long countByTeamAndWin(Team team, GameWinTypeEnum win);
	
}
