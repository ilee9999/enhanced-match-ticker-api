package com.hkesports.matchticker.vo.getsubscription;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.vo.BasicVo;

public class GetmatchsubscriptionVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private List<MatchSubscriptionVo> schedules;

	public GetmatchsubscriptionVo() {}
	
	public GetmatchsubscriptionVo(StatusCodeEnum statusCode) {
		super(statusCode);
	}
	
	@JsonProperty(value="Schedules")
	public List<MatchSubscriptionVo> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<MatchSubscriptionVo> schedules) {
		this.schedules = schedules;
	}
}
