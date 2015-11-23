package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicAuditModel;

/**
 * @author manboyu
 *
 */
@Entity
@Table(name = "terms_of_service")
public class TermsOfService extends BasicAuditModel {

	private static final long serialVersionUID = 1L;

	private String enTermsOfService;
	private String twTermsOfService;

	@Column(name = "en_terms_of_service", columnDefinition = "TEXT", nullable = true)
	public String getEnTermsOfService() {
		return enTermsOfService;
	}

	public void setEnTermsOfService(String enTermsOfService) {
		this.enTermsOfService = enTermsOfService;
	}

	@Column(name = "tw_terms_of_service", columnDefinition = "TEXT", nullable = true)
	public String getTwTermsOfService() {
		return twTermsOfService;
	}

	public void setTwTermsOfService(String twTermsOfService) {
		this.twTermsOfService = twTermsOfService;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("enTermsOfService", getEnTermsOfService())
		.append("twTermsOfService", getTwTermsOfService())
		.build();
	}
}
