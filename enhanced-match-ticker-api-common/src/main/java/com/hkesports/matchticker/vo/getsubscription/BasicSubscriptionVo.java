package com.hkesports.matchticker.vo.getsubscription;

import java.io.Serializable;

public class BasicSubscriptionVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String subscriptionType;
	private Long subscriptionKey;

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Long getSubscriptionKey() {
		return subscriptionKey;
	}

	public void setSubscriptionKey(Long subscriptionKey) {
		this.subscriptionKey = subscriptionKey;
	}
}
