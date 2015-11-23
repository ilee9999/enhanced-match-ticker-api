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
@Table(name = "privacy_policy")
public class PrivacyPolicy extends BasicAuditModel {

	private static final long serialVersionUID = 1L;

	private String enPrivacyPolicy;
	private String twPrivacyPolicy;

	@Column(name = "en_privacy_policy", columnDefinition = "TEXT", nullable = true)
	public String getEnPrivacyPolicy() {
		return enPrivacyPolicy;
	}

	public void setEnPrivacyPolicy(String enPrivacyPolicy) {
		this.enPrivacyPolicy = enPrivacyPolicy;
	}

	@Column(name = "tw_privacy_policy", columnDefinition = "TEXT", nullable = true)
	public String getTwPrivacyPolicy() {
		return twPrivacyPolicy;
	}

	public void setTwPrivacyPolicy(String twPrivacyPolicy) {
		this.twPrivacyPolicy = twPrivacyPolicy;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("enPrivacyPolicy", getEnPrivacyPolicy())
		.append("twPrivacyPolicy", getTwPrivacyPolicy())
		.build();
	}
}
