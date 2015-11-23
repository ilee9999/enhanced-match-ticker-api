package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hkesports.matchticker.model.basic.BasicIdModel;

@Entity
@Table(name = "security_code")
public class SecurityCode extends BasicIdModel {
	private static final long serialVersionUID = 1L;

	private String deviceKey;
	private String code;
	private String publicKey;
	private Date expiredDate;

	@Column(name = "device_key", nullable = false)
	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}

	@Column(name = "code", nullable = true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "pulbic_key", nullable = true)
	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String key) {
		this.publicKey = key;
	}

	@Column(name = "expired_date", nullable = false)
	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

}
