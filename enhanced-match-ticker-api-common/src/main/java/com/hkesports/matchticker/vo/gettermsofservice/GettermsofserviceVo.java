package com.hkesports.matchticker.vo.gettermsofservice;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class GettermsofserviceVo extends BasicVo {
	
	private static final long serialVersionUID = 1L;

	private String enTermsOfService;
	private String twTermsOfService;
	
	public GettermsofserviceVo() {
		
	}

	public GettermsofserviceVo(String enTermsOfService, String twTermsOfService) {
		this.enTermsOfService = enTermsOfService;
		this.twTermsOfService = twTermsOfService;
	}

	public String getEnTermsOfService() {
		return enTermsOfService;
	}

	public void setEnTermsOfService(String enTermsOfService) {
		this.enTermsOfService = enTermsOfService;
	}

	public String getTwTermsOfService() {
		return twTermsOfService;
	}

	public void setTwTermsOfService(String twTermsOfService) {
		this.twTermsOfService = twTermsOfService;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("enTermsOfService", getEnTermsOfService())
		.append("twTermsOfService", getTwTermsOfService())
		.build();
	}
}
