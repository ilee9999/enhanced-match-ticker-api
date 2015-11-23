package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.hkesports.matchticker.model.basic.BasicIdModel;

@Entity
@Table(name = "notification_read_history")
@Deprecated
public class NotificationReadHistory extends BasicIdModel {

	private static final long serialVersionUID = 1L;

	private Date sendDate;
	private Date readDate;
	private Date joinDate;
	private Long userId;
	private String registrationId;
	private Long notificationId;
	
	@Column(name = "send_date", columnDefinition = "DATETIME", nullable = true)
	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	@Column(name = "read_date", columnDefinition = "DATETIME", nullable = true)
	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}

	@Column(name = "join_date", columnDefinition = "DATETIME", nullable = true)
	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Column(name = "user_id", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "registration_id", length = 64, nullable = true)
	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	@Column(name = "notification_id", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
