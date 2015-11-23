package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.LanguageEnum;
import com.hkesports.matchticker.enums.UserDeviceTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "user_devices")
public class UserDevices extends BasicModel {
	private static final long serialVersionUID = 1L;

	private User user;
	private UserDeviceTypeEnum deviceType;
	private String deviceKey;
	private String deviceVersion;
	private String secretKey;
	private String language = LanguageEnum.EN.getDescription();
	private Boolean isActive = false;
	private Date lastLoginTime;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	@Column(name ="device_type", nullable = true)
	public UserDeviceTypeEnum getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(UserDeviceTypeEnum deviceType) {
		this.deviceType = deviceType;
	}

	@Column(name ="device_key", nullable = false)
	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}
	
	@Column(name ="device_version", nullable = true)
	public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}

	@Column(name ="secret_key", nullable = false)
	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	@Column(name ="language", nullable = false)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name ="is_active", columnDefinition = "bit(1)", nullable = false)
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name ="last_login_time", columnDefinition = "datetime", nullable = true)
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("user", getUser())
		.append("deviceType", getDeviceType())
		.append("deviceKey", getDeviceKey())
		.append("secretKey", getSecretKey())
		.append("isActive", getIsActive())
		.append("createDate", getCreateDate())
		.append("lastLoginTime", getLastLoginTime())
		.build();
	}
}
