package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hkesports.matchticker.model.basic.BasicIdModel;

@Entity
@Table(name = "notification_detail")
public class NotificationDetail extends BasicIdModel {

	private static final long serialVersionUID = 1L;

	private NotificationMaster notificationMaster;
	private String registrationId;
	private Integer retryCount = 0;
	private Date timeSent;
	private Date timeRetry;
	private Date timeRead;
	private String errorCode;
	private String errorMessage;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "notification_master_id")
	public NotificationMaster getNotificationMaster() {
		return notificationMaster;
	}

	public void setNotificationMaster(NotificationMaster notificationMaster) {
		this.notificationMaster = notificationMaster;
	}

	@Column(name = "registration_id", nullable = false)
	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	@Column(name = "retry_count", nullable = true)
	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	@Column(name = "time_sent", nullable = true)
	public Date getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(Date timeSent) {
		this.timeSent = timeSent;
	}

	@Column(name = "time_retry", nullable = true)
	public Date getTimeRetry() {
		return timeRetry;
	}

	public void setTimeRetry(Date timeRetry) {
		this.timeRetry = timeRetry;
	}

	@Column(name = "time_read", nullable = true)
	public Date getTimeRead() {
		return timeRead;
	}

	public void setTimeRead(Date timeRead) {
		this.timeRead = timeRead;
	}

	@Column(name = "error_code", nullable = true)
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Column(name = "error_message", nullable = true)
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
