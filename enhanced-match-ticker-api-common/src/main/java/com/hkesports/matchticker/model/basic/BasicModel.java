package com.hkesports.matchticker.model.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hkesports.matchticker.utils.Const;

/**
 * Model superclass 
 * 
 * @author manboyu
 *
 */
@MappedSuperclass
public class BasicModel extends BasicIdModel {

	private static final long serialVersionUID = 1L;

	private Date createDate;
	private Date updateDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT_YYYYMMDDHHMMSS, timezone = "Asia/Taipei")
	@Column(name = "create_date", columnDefinition = "DATETIME", nullable = true)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT_YYYYMMDDHHMMSS, timezone = "Asia/Taipei")
	@Column(name = "update_date", columnDefinition = "DATETIME", nullable = true)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@PrePersist
    public void prePersist() {
        this.setCreateDate(new Date());
    }
	
	@PreUpdate
    public void preUpdate() {
		this.setCreateDate(this.getCreateDate());
		this.setUpdateDate(new Date());
    }
}
