package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.enums.NotificationTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "notification_setting")
public class NotificationSetting extends BasicModel {

	private static final long serialVersionUID = 1L;

	private UserTypeEnum userType;
	private Long userId;
	private GameTypeEnum gameType;
	private NotificationTypeEnum notificationType;
	private Boolean isNotification;
	

	@Enumerated(EnumType.STRING)
	@Column(name = "user_type")
	public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "game_type", nullable = true)
	public GameTypeEnum getGameType() {
		return gameType;
	}

	public void setGameType(GameTypeEnum gameType) {
		this.gameType = gameType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "notification_type", nullable = false)
	public NotificationTypeEnum getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
	}

	@Column(name = "is_notification", nullable = false)
	public Boolean getIsNotification() {
		return isNotification;
	}

	public void setIsNotification(Boolean isNotification) {
		this.isNotification = isNotification;
	}


}
