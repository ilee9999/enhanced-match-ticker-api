package com.hkesports.matchticker.vo.getnotification;

import java.io.Serializable;

public class NotificationVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long notificationID;
	
	private String notificationType;
	
	private String notificationTitle;
	
	private String notificationBody;

	public Long getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(Long notificationID) {
		this.notificationID = notificationID;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getNotificationTitle() {
		return notificationTitle;
	}

	public void setNotificationTitle(String notificationTitle) {
		this.notificationTitle = notificationTitle;
	}

	public String getNotificationBody() {
		return notificationBody;
	}

	public void setNotificationBody(String notificationBody) {
		this.notificationBody = notificationBody;
	}

}
