package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.hkesports.matchticker.enums.UserSourceTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "user")
public class User extends BasicModel {

	private static final long serialVersionUID = 1L;

	private String account;
	private String password;
	private String name;
	private String email;
	private UserSourceTypeEnum sourceType;
	private Long authUserId;
	private Long ucUserId;
	private Boolean isValidate = false;
	private Date pollingDate;

	@Column(name = "account", nullable = false)
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "password", nullable = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "source_type", columnDefinition = "VARCHAR(20)", nullable = false)
	public UserSourceTypeEnum getSourceType() {
		return sourceType;
	}

	public void setSourceType(UserSourceTypeEnum sourceType) {
		this.sourceType = sourceType;
	}

	@Column(name = "auth_user_id", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getAuthUserId() {
		return authUserId;
	}

	public void setAuthUserId(Long authUserId) {
		this.authUserId = authUserId;
	}

	@Column(name = "uc_user_id", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getUcUserId() {
		return ucUserId;
	}

	public void setUcUserId(Long ucUserId) {
		this.ucUserId = ucUserId;
	}
	
	@Column(name = "is_validate", columnDefinition = "BIT(1)", nullable = false)
	public Boolean getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(Boolean isValidate) {
		if(isValidate != null)
			this.isValidate = isValidate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "polling_date", nullable = true)
	public Date getPollingDate() {
		return pollingDate;
	}

	public void setPollingDate(Date pollingDate) {
		this.pollingDate = pollingDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
