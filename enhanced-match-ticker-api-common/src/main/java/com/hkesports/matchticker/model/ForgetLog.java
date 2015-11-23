package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.hkesports.matchticker.enums.ForgetTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "forget_log")
public class ForgetLog extends BasicModel {
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String deviceKey;
	private ForgetTypeEnum forgetType;
	private boolean isOver;
	private String code;
	private String verifyCode;

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "device_key", nullable = true)
	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "forget_type", nullable = false)
	public ForgetTypeEnum getForgetType() {
		return forgetType;
	}

	public void setForgetType(ForgetTypeEnum forgetType) {
		this.forgetType = forgetType;
	}

	@Column(name = "is_over", columnDefinition = "BIT(1)", nullable = false)
	public boolean isOver() {
		return isOver;
	}

	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}

	@Column(name = "code", nullable = true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "verify_code", nullable = true)
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

}
