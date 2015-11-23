package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.hkesports.matchticker.enums.NotificationSendTypeEnum;
import com.hkesports.matchticker.enums.NotificationStatusEnum;
import com.hkesports.matchticker.enums.NotificationTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "notification_master")
public class NotificationMaster extends BasicModel {

	private static final long serialVersionUID = 1L;
	private NotificationSendTypeEnum type;
	private NotificationTypeEnum notificationType;
	private String title;
	private String content;
	private Long gameId;
	private Date timeToLive;
	private NotificationStatusEnum status;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	public NotificationSendTypeEnum getType() {
		return type;
	}

	public void setType(NotificationSendTypeEnum type) {
		this.type = type;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "notification_type", nullable = false)
	public NotificationTypeEnum getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "content", columnDefinition = "TEXT", nullable = true)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "game_id", nullable = false)
	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	
	@Column(name = "time_to_live", nullable = true)
	public Date getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(Date timeToLive) {
		this.timeToLive = timeToLive;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	public NotificationStatusEnum getStatus() {
		return status;
	}

	public void setStatus(NotificationStatusEnum status) {
		this.status = status;
	}

}
