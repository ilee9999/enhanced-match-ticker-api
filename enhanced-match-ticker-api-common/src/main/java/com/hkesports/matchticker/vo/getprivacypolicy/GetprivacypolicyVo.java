package com.hkesports.matchticker.vo.getprivacypolicy;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class GetprivacypolicyVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private String enPrivacyPolicy;
	private String twPrivacyPolicy;
	
	public GetprivacypolicyVo() {
		
	}
	
	public GetprivacypolicyVo(String enPrivacyPolicy, String twPrivacyPolicy) {
		this.enPrivacyPolicy = enPrivacyPolicy;
		this.twPrivacyPolicy = twPrivacyPolicy;
	}
	
	public String getEnPrivacyPolicy() {
		return enPrivacyPolicy;
	}

	public void setEnPrivacyPolicy(String enPrivacyPolicy) {
		this.enPrivacyPolicy = enPrivacyPolicy;
	}

	public String getTwPrivacyPolicy() {
		return twPrivacyPolicy;
	}

	public void setTwPrivacyPolicy(String twPrivacyPolicy) {
		this.twPrivacyPolicy = twPrivacyPolicy;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("enPrivacyPolicy", getEnPrivacyPolicy())
		.append("twPrivacyPolicy", getTwPrivacyPolicy())
		.build();
	}
}
