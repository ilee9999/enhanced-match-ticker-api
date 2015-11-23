package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.hkesports.matchticker.enums.NotifyTypeEnum;
import com.hkesports.matchticker.model.basic.BasicAuditModel;

/**
 * @author manboyu
 *
 */
@Entity
@Table(name = "notification")
@Deprecated
public class Notification extends BasicAuditModel {

	private static final long serialVersionUID = 1L;

	private NotifyTypeEnum notifyType;
	private String message;
	private Date startDate;
	private Date endDate;
	private Long userId;
	private Long jumpToMatchId;
	private Long showToMatchId;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "notify_type", columnDefinition = "INT(11)", nullable = true)
	public NotifyTypeEnum getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(NotifyTypeEnum notifyType) {
		this.notifyType = notifyType;
	}

	@Column(name = "message", columnDefinition = "TEXT", nullable = true)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "start_date", columnDefinition = "DATETIME", nullable = true)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date", columnDefinition = "DATETIME", nullable = true)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "user_id", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "jump_to_match_id", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getJumpToMatchId() {
		return jumpToMatchId;
	}

	public void setJumpToMatchId(Long jumpToMatchId) {
		this.jumpToMatchId = jumpToMatchId;
	}

	@Column(name = "show_to_match_id", columnDefinition = "BIGINT(20)", nullable = true)
	public Long getShowToMatchId() {
		return showToMatchId;
	}

	public void setShowToMatchId(Long showToMatchId) {
		this.showToMatchId = showToMatchId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
