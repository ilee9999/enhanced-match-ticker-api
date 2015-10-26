package com.hkesports.matchticker.vo.keepalive;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hkesports.matchticker.utils.Const;

/**
 * @author manboyu
 *
 */
public class SystemNotificationVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long notificationID;
	private String htmlNotification;
	private Long jumpToMatchID;
	private Long showToMatchID;
	private Date fromTimestamp;
	private Date toTimestamp;
	
	public SystemNotificationVo() {
		
	}
	
	public SystemNotificationVo(Long notificationID, String htmlNotification,
			Long jumpToMatchID, Long showToMatchID, Date fromTimestamp,
			Date toTimestamp) {
		this.notificationID = notificationID;
		this.htmlNotification = htmlNotification;
		this.jumpToMatchID = jumpToMatchID;
		this.showToMatchID = showToMatchID;
		this.fromTimestamp = fromTimestamp;
		this.toTimestamp = toTimestamp;
	}

	public Long getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(Long notificationID) {
		this.notificationID = notificationID;
	}

	public String getHtmlNotification() {
		return htmlNotification;
	}

	public void setHtmlNotification(String htmlNotification) {
		this.htmlNotification = htmlNotification;
	}

	public Long getJumpToMatchID() {
		return jumpToMatchID;
	}

	public void setJumpToMatchID(Long jumpToMatchID) {
		this.jumpToMatchID = jumpToMatchID;
	}

	public Long getShowToMatchID() {
		return showToMatchID;
	}

	public void setShowToMatchID(Long showToMatchID) {
		this.showToMatchID = showToMatchID;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	public Date getFromTimestamp() {
		return fromTimestamp;
	}

	public void setFromTimestamp(Date fromTimestamp) {
		this.fromTimestamp = fromTimestamp;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	public Date getToTimestamp() {
		return toTimestamp;
	}

	public void setToTimestamp(Date toTimestamp) {
		this.toTimestamp = toTimestamp;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
