package com.hkesports.matchticker.model.basic;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BasicAuditModel extends BasicModel {

	private static final long serialVersionUID = 1L;

	private String createBy;
	private String updateBy;

	@Column(name = "create_by", length = 255, nullable = true)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "update_by", length = 255, nullable = true)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}
