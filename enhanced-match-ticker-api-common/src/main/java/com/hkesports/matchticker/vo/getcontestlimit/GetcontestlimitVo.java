package com.hkesports.matchticker.vo.getcontestlimit;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
public class GetcontestlimitVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private String defaultContestHa;
	private String lowerContestLimitHa;
	private String upperContestLimitHa;
	private String eachIncrementHa;
	private String eachDecrementHa;
	
	public GetcontestlimitVo() {
		
	}
	
	public GetcontestlimitVo(StatusCodeEnum statusCode) {
		super(statusCode);
	}

	public String getDefaultContestHa() {
		return defaultContestHa;
	}

	public void setDefaultContestHa(String defaultContestHa) {
		this.defaultContestHa = defaultContestHa;
	}

	public String getLowerContestLimitHa() {
		return lowerContestLimitHa;
	}

	public void setLowerContestLimitHa(String lowerContestLimitHa) {
		this.lowerContestLimitHa = lowerContestLimitHa;
	}

	public String getUpperContestLimitHa() {
		return upperContestLimitHa;
	}

	public void setUpperContestLimitHa(String upperContestLimitHa) {
		this.upperContestLimitHa = upperContestLimitHa;
	}

	public String getEachIncrementHa() {
		return eachIncrementHa;
	}

	public void setEachIncrementHa(String eachIncrementHa) {
		this.eachIncrementHa = eachIncrementHa;
	}

	public String getEachDecrementHa() {
		return eachDecrementHa;
	}

	public void setEachDecrementHa(String eachDecrementHa) {
		this.eachDecrementHa = eachDecrementHa;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("defaultContestHa", getDefaultContestHa())
		.append("lowerContestLimitHa", getLowerContestLimitHa())
		.append("upperContestLimitHa", getUpperContestLimitHa())
		.append("eachIncrementHa", getEachIncrementHa())
		.append("eachDecrementHa", getEachDecrementHa())
		.build();
	}
}
