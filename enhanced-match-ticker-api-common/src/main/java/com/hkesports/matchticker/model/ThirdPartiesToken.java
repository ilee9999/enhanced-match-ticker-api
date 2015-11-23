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

import com.hkesports.matchticker.enums.UserSourceTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "third_parties_token")
public class ThirdPartiesToken extends BasicModel {
	private static final long serialVersionUID = 1L;

	private User user;
	private UserSourceTypeEnum sourceType;
	private Long authUserId;
	private String email;
	private String token;
	private String refreshToken;
	private Date expiredDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "source_type", nullable = false)
	public UserSourceTypeEnum getSourceType() {
		return sourceType;
	}

	public void setSourceType(UserSourceTypeEnum sourceType) {
		this.sourceType = sourceType;
	}

	@Column(name = "auth_user_id", columnDefinition = "bigint", nullable = false)
	public Long getAuthUserId() {
		return authUserId;
	}

	public void setAuthUserId(Long authUserId) {
		this.authUserId = authUserId;
	}

	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "token", nullable = false)
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "refresh_token", nullable = true)
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Column(name = "expired_date", nullable = true)
	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("user", getUser())
		.append("sourceType", getSourceType())
		.append("authUserId", getAuthUserId())
		.append("eamil", getEmail())
		.append("token", getToken())
		.append("refreshToken", getRefreshToken())
		.append("expiredDate", getExpiredDate())
		.build();
	}
}
