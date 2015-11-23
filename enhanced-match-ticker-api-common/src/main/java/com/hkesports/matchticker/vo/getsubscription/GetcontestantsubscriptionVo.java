package com.hkesports.matchticker.vo.getsubscription;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.vo.BasicVo;

public class GetcontestantsubscriptionVo extends BasicVo {

	private static final long serialVersionUID = 1L;
	
	private List<ContestantSubscriptionVo> contestants;

	public GetcontestantsubscriptionVo() {}
	
	public GetcontestantsubscriptionVo(StatusCodeEnum statusCode) {
		super(statusCode);
	}
	
	@JsonProperty(value="Contestants")
	public List<ContestantSubscriptionVo> getContestants() {
		return contestants;
	}

	public void setContestants(List<ContestantSubscriptionVo> contestants) {
		this.contestants = contestants;
	}

}
