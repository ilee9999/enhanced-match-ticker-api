package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.UserActivityTypeEnum;
import com.hkesports.matchticker.enums.UserDeviceTypeEnum;
import com.hkesports.matchticker.model.basic.BasicIdModel;

@Entity
@Table(name = "user_activity_record")
public class UserActivityRecord extends BasicIdModel {
	private static final long serialVersionUID = 1L;

	private User user;
	private UserActivityTypeEnum activityType;
	private UserDeviceTypeEnum deviceType;
	private Integer createDate;
	private Integer createTime;
	private String desc;
	private String foreignTable;
	private Long foreignKey;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "activity_type", nullable = false)
	public UserActivityTypeEnum getActivityType() {
		return activityType;
	}

	public void setActivityType(UserActivityTypeEnum activityType) {
		this.activityType = activityType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "device_type", nullable = false)
	public UserDeviceTypeEnum getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(UserDeviceTypeEnum deviceType) {
		this.deviceType = deviceType;
	}

	@Column(name = "create_date", columnDefinition = "int", nullable = false)
	public Integer getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Integer createDate) {
		this.createDate = createDate;
	}

	@Column(name = "create_time", columnDefinition = "int", nullable = false)
	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	@Column(name = "record_desc", nullable = true)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "foreign_table", nullable = true)
	public String getForeignTable() {
		return foreignTable;
	}

	public void setForeignTable(String foreignTable) {
		this.foreignTable = foreignTable;
	}

	@Column(name = "foreign_key", nullable = true)
	public Long getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(Long foreignKey) {
		this.foreignKey = foreignKey;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("user", getUser())
		.append("activityType", getActivityType())
		.append("deviceType", getDeviceType())
		.append("createDate", getCreateDate())
		.append("createTime", getCreateTime())
		.append("desc", getDesc())
		.append("foreignTable", getForeignTable())
		.append("foreignKey", getForeignKey())
		.build();
	}
}
