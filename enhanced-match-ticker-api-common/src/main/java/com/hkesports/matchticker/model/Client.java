package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "client")
public class Client extends BasicModel {
	private static final long serialVersionUID = 1L;

	private User user;
	private String clientId;
	private String secret;
	private String siteName;
	private String clientIp;
	private String clientUrl;
	private String redirectionUrl;
	private Boolean isHkeServer = false;
	private String ssoLogoutUrl;
	private Boolean isActive = true;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "client_id", nullable = false)
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Column(name = "secret", nullable = false)
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Column(name = "site_name", nullable = false)
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Column(name = "client_ip", nullable = false)
	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	@Column(name = "client_url", nullable = false)
	public String getClientUrl() {
		return clientUrl;
	}

	public void setClientUrl(String clientUrl) {
		this.clientUrl = clientUrl;
	}

	@Column(name = "redirection_url", nullable = false)
	public String getRedirectionUrl() {
		return redirectionUrl;
	}

	public void setRedirectionUrl(String redirectionUrl) {
		this.redirectionUrl = redirectionUrl;
	}

	@Column(name = "is_hke_server", columnDefinition = "bit(1)", nullable = true)
	public Boolean getIsHkeServer() {
		return isHkeServer;
	}

	public void setIsHkeServer(Boolean isHkeServer) {
		this.isHkeServer = isHkeServer;
	}

	@Column(name = "sso_logout_url", nullable = true)
	public String getSsoLogoutUrl() {
		return ssoLogoutUrl;
	}

	public void setSsoLogoutUrl(String ssoLogoutUrl) {
		this.ssoLogoutUrl = ssoLogoutUrl;
	}

	@Column(name = "is_active", columnDefinition = "bit(1)", nullable = true)
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("user", getUser())
		.append("clientId", getClientId())
		.append("secret", getSecret())
		.append("siteName", getSiteName())
		.append("clientIp", getClientIp())
		.append("clientUrl", getClientUrl())
		.append("redirectionUrl", getRedirectionUrl())
		.append("isHkeServer", getIsHkeServer())
		.append("ssoLogoutUrl", getSsoLogoutUrl())
		.append("isActive", getIsActive())
		.build();
	}
}
