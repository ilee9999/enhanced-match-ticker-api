package com.hkesports.matchticker.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.LanguageEnum;
import com.hkesports.matchticker.enums.UserDeviceTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;
import com.hkesports.matchticker.model.basic.UserHa;

@Entity
@Table(name = "device")
public class Device extends BasicModel implements UserHa {
	private static final long serialVersionUID = 1L;

	private String deviceKey;
	private UserDeviceTypeEnum deviceType;
	private String deviceVersion;
	private String token;
	private BigInteger totalHa = BigInteger.ZERO;
	private BigInteger ha = BigInteger.ZERO;
	private BigInteger onlineTimes = BigInteger.ZERO;
	private String language = LanguageEnum.EN.getDescription();
	private Date lastLoginTime;
	private Long continuousLoginCount;

	@Column(name = "device_key", nullable = false)
	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "device_type", nullable = true)
	public UserDeviceTypeEnum getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(UserDeviceTypeEnum deviceType) {
		this.deviceType = deviceType;
	}
	
	@Column(name = "device_version", nullable = true)
	public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}

	@Column(name = "token", nullable = true)
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "total_ha", columnDefinition = "bigint", nullable = false)
	public BigInteger getTotalHa() {
		if(totalHa == null)
			totalHa = BigInteger.ZERO;
		return totalHa;
	}

	public void setTotalHa(BigInteger totalHa) {
		this.totalHa = totalHa;
	}

	@Column(name = "ha", columnDefinition = "bigint", nullable = false)
	public BigInteger getHa() {
		if(ha == null)
			ha = BigInteger.ZERO;
		return ha;
	}

	public void setHa(BigInteger ha) {
		this.ha = ha;
	}

	@Column(name = "online_times", columnDefinition = "bigint", nullable = false)
	public BigInteger getOnlineTimes() {
		if(onlineTimes == null)
			onlineTimes = BigInteger.ZERO;
		return onlineTimes;
	}

	public void setOnlineTimes(BigInteger onlineTimes) {
		this.onlineTimes = onlineTimes;
	}
	
	@Column(name = "language", nullable = true)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Column(name = "last_login_time", nullable = true)
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "continuous_login_count", nullable = true)
	public Long getContinuousLoginCount() {
		return continuousLoginCount;
	}

	public void setContinuousLoginCount(Long continuousLoginCount) {
		this.continuousLoginCount = continuousLoginCount;
	}
	
	@Transient
	@Override
	public Long getUserId() {
		return getId();
	}

	@Transient
	@Override
	public UserTypeEnum getUserType() {
		return UserTypeEnum.DEVICE;
	}

	@Transient
	@Override
	public String getAccount() {
		return getDeviceKey();
	}

	@Transient
	@Override
	public String getName() {
		return getDeviceKey();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("deviceKey", getDeviceKey())
		.append("deviceType", getDeviceType())
		.append("deviceVersion", getDeviceVersion())
		.append("totalHa", getTotalHa())
		.append("ha", getHa())
		.append("onlineTimes", getOnlineTimes())
		.append("language", getLanguage())
		.build();
	}
}
