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
@Table(name = "contest_rule")
public class ContestRule extends BasicAuditModel {

	private static final long serialVersionUID = 1L;

	private String enContestRule;
	private String twContestRule;

	@Column(name = "en_contest_rule", columnDefinition = "TEXT", nullable = true)
	public String getEnContestRule() {
		return enContestRule;
	}

	public void setEnContestRule(String enContestRule) {
		this.enContestRule = enContestRule;
	}

	@Column(name = "tw_contest_rule", columnDefinition = "TEXT", nullable = true)
	public String getTwContestRule() {
		return twContestRule;
	}

	public void setTwContestRule(String twContestRule) {
		this.twContestRule = twContestRule;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("enContestRule", getEnContestRule())
		.append("twContestRule", getTwContestRule())
		.build();
	}
}
