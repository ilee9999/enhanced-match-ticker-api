package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.getleaguetable.TournamentVo;
import com.hkesports.matchticker.vo.getresult.ResultVo;
import com.hkesports.matchticker.vo.getschedule.ResultScheduleVo;

public interface ScheduleDaoCustom {
	
	public List<ResultScheduleVo> getSchedule(RequestVo requestVo);
	
	public List<ResultVo> getResult(RequestVo requestVo);
	
	public List<TournamentVo> getLeaguetable(RequestVo requestVo);
	
	public int updateSupportCount(Long matchId);
}
