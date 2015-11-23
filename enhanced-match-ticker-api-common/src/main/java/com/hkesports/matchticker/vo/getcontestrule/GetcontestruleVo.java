package com.hkesports.matchticker.vo.getcontestrule;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class GetcontestruleVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private String enContestRule;
	private String twContestRule;
	
	public GetcontestruleVo() {
		
	}

	public GetcontestruleVo(String enContestRule, String twContestRule) {
		this.enContestRule = enContestRule;
		this.twContestRule = twContestRule;
	}

	public String getEnContestRule() {
		return enContestRule;
	}

	public void setEnContestRule(String enContestRule) {
		this.enContestRule = enContestRule;
	}

	public String getTwContestRule() {
		return twContestRule;
	}

	public void setTwContestRule(String twContestRule) {
		this.twContestRule = twContestRule;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("enContestRule", getEnContestRule())
		.append("twContestRule", getTwContestRule())
		.build();
	}
}
