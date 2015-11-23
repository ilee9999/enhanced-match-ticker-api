package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.hkesports.matchticker.enums.SubscriptionTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.basic.BasicIdModel;

@Entity
@Table(name = "subscription_setting")
public class SubscriptionSetting extends BasicIdModel {

	private static final long serialVersionUID = 1L;

	private UserTypeEnum userType;
	private Long userId;
	private SubscriptionTypeEnum subscriptionType;
	private Long subscriptionKey;
	private Date createDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_type", nullable = false)
	public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "subscription_type", nullable = false)
	public SubscriptionTypeEnum getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionTypeEnum subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@Column(name = "subscription_key", nullable = false)
	public Long getSubscriptionKey() {
		return subscriptionKey;
	}

	public void setSubscriptionKey(Long subscriptionKey) {
		this.subscriptionKey = subscriptionKey;
	}

	@Column(name = "create_date", columnDefinition = "DATETIME", nullable = true)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
