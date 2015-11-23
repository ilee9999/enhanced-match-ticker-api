package com.hkesports.matchticker.vo.getnotification;

import java.util.List;

import com.hkesports.matchticker.vo.BasicVo;

public class GetnotificationVo extends BasicVo {

	private static final long serialVersionUID = 1L;
	
	private List<NotificationVo> notifications;

	public List<NotificationVo> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NotificationVo> notifications) {
		this.notifications = notifications;
	}
}
