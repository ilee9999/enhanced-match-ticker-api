package com.hkesports.matchticker.vo.getsubscription;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchSubscriptionVo extends BasicSubscriptionVo {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value="matchID")
	@Override
	public Long getSubscriptionKey() {
		return super.getSubscriptionKey();
	}
	
	@JsonIgnore
	@Override
	public String getSubscriptionType() {
		return super.getSubscriptionType();
	}
}
