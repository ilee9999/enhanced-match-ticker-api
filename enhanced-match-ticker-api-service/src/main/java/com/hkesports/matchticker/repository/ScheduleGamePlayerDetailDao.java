package com.hkesports.matchticker.repository;

import com.hkesports.matchticker.model.ScheduleGamePlayerDetail;
import com.hkesports.matchticker.repository.custom.ScheduleGamePlayerDetailDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface ScheduleGamePlayerDetailDao extends GenericRepository<ScheduleGamePlayerDetail, Long>, ScheduleGamePlayerDetailDaoCustom {

}
