package com.hkesports.matchticker.vo.getsubscription;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.enums.SubscriptionTypeEnum;

public class ContestantSubscriptionVo extends BasicSubscriptionVo {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value="contestantID")
	@Override
	public Long getSubscriptionKey() {
		return super.getSubscriptionKey();
	}
	
	@JsonIgnore
	@Override
	public String getSubscriptionType() {
		return super.getSubscriptionType();
	}
	
	@JsonProperty(value="team")
	public Boolean getTeam() {
		if(getSubscriptionType()==null) {
			return null;
		}
		
		if(super.getSubscriptionType().equals(SubscriptionTypeEnum.PLAYER.name())) {
			return false;
		}
		if(super.getSubscriptionType().equals(SubscriptionTypeEnum.TEAM.name())) {
			return true;
		}
		return null;
	}
}
