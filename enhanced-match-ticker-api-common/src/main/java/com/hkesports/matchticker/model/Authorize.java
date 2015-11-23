package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.AuthorizeTypeEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "authorize")
public class Authorize extends BasicModel {
	private static final long serialVersionUID = 1L;

	private AuthorizeTypeEnum authorizeType;
	private String name;
	private String authDesc;
	
	@Column(name = "authorize_type", nullable = false)
	public AuthorizeTypeEnum getAuthorizeType() {
		return authorizeType;
	}
	
	public void setAuthorizeType(AuthorizeTypeEnum authorizeType) {
		this.authorizeType = authorizeType;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "auth_desc", nullable = true)
	public String getAuthDesc() {
		return authDesc;
	}
	
	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("authorizeType", getAuthorizeType())
		.append("name", getName())
		.append("authDesc", getAuthDesc())
		.build();
	}
}
