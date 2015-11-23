package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.hkesports.matchticker.enums.MessageTypeEnum;
import com.hkesports.matchticker.model.basic.BasicAuditModel;

@Entity
@Table(name = "notification_template")
public class NotificationTemplate extends BasicAuditModel {
	private static final long serialVersionUID = 1L;

	private MessageTypeEnum messageType;
	private String language;
	private String title;
	private String content;

	@Enumerated(EnumType.STRING)
	@Column(name = "message_type", nullable = false)
	public MessageTypeEnum getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageTypeEnum messageType) {
		this.messageType = messageType;
	}

	@Column(name = "language", nullable = false)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
