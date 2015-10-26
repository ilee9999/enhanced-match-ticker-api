package com.hkesports.matchticker.vo.keepalive;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class KeepaliveVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private List<SystemNotificationVo> SystemNotification;

	@JsonProperty("SystemNotification")
	public List<SystemNotificationVo> getSystemNotification() {
		return SystemNotification;
	}

	public void setSystemNotification(List<SystemNotificationVo> systemNotification) {
		SystemNotification = systemNotification;
	}
}
