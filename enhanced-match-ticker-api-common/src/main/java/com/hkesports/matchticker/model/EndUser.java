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

import com.hkesports.matchticker.enums.ClientTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

/**
 * @author manboyu
 *
 */
@Entity
@Table(name = "end_user")
public class EndUser extends BasicModel {

	private static final long serialVersionUID = 1L;

	private Long authUserId;
	private Long ucUserId;
	private ClientTypeEnum clientType;
	private Date visitDate;
	private Date pollingDate;

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

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "client_type", columnDefinition = "INT(11)", nullable = true)
	public ClientTypeEnum getClientType() {
		return clientType;
	}

	public void setClientType(ClientTypeEnum clientType) {
		this.clientType = clientType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "visit_date", nullable = true)
	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
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
