package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.ScheduleGame;
import com.hkesports.matchticker.repository.custom.ScheduleGameDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface ScheduleGameDao extends GenericRepository<ScheduleGame, Long>, ScheduleGameDaoCustom {

	
	@Query("select id from ScheduleGame where schedule.id=:matchId and gameNumber=:gameNumber")
	public Long findIdByScheduleIdAndGameNumber(@Param("matchId")Long matchId, @Param("gameNumber")Short gameNumber);
	
}
