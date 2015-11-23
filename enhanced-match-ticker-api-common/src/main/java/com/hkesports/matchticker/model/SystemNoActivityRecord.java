package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.UserActivityTypeEnum;
import com.hkesports.matchticker.model.basic.BasicIdModel;

@Entity
@Table(name = "system_no_activity_record")
public class SystemNoActivityRecord extends BasicIdModel {
	private static final long serialVersionUID = 1L;

	private UserActivityTypeEnum activityType;
	private Integer createDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "activity_type", nullable = false)
	public UserActivityTypeEnum getActivityType() {
		return activityType;
	}

	public void setActivityType(UserActivityTypeEnum activityType) {
		this.activityType = activityType;
	}

	@Column(name = "create_date", nullable = false)
	public Integer getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Integer createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("activityType", getActivityType())
		.append("createDate", getCreateDate())
		.build();
	}
}
