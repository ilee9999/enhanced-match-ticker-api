package com.hkesports.matchticker.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.HaUseTypeEnum;
import com.hkesports.matchticker.model.basic.BasicIdModel;

@Entity
@Table(name = "device_ha_record")
public class DeviceHaRecord extends BasicIdModel {
	private static final long serialVersionUID = 1L;

	private Device device;
	private HaUseTypeEnum useType;
	private String subUseType;
	private BigInteger ha;
	private Integer createDate;
	private Integer createTime;
	private Long foreignKey;
	private String desc;
	
	@ManyToOne
	@JoinColumn(name = "device_id")
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "use_type", nullable = false)
	public HaUseTypeEnum getUseType() {
		return useType;
	}

	public void setUseType(HaUseTypeEnum useType) {
		this.useType = useType;
	}

	@Column(name = "sub_use_type", nullable = true)
	public String getSubUseType() {
		return subUseType;
	}

	public void setSubUseType(String subUseType) {
		this.subUseType = subUseType;
	}

	@Column(name = "ha", columnDefinition = "bigint", nullable = false)
	public BigInteger getHa() {
		return ha;
	}

	public void setHa(BigInteger ha) {
		this.ha = ha;
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

	@Column(name = "foreign_key", columnDefinition = "bigint", nullable = true)
	public Long getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(Long foreignKey) {
		this.foreignKey = foreignKey;
	}

	@Column(name = "record_desc", nullable = true)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("device", getDevice())
		.append("useType", getUseType())
		.append("subUseType", getSubUseType())
		.append("ha", getHa())
		.append("createDate", getCreateDate())
		.append("createTime", getCreateTime())
		.append("foreignKey", getForeignKey())
		.append("desc", getDesc())
		.build();
	}
}
