package com.hkesports.matchticker.vo.getschedule;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ResultScheduleVo> Schedules;

	@JsonProperty("Schedules")
	public List<ResultScheduleVo> getSchedules() {
		return Schedules;
	}

	public void setSchedules(List<ResultScheduleVo> schedules) {
		Schedules = schedules;
	}
	
}
