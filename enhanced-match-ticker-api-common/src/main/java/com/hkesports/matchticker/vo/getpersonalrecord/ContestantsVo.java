package com.hkesports.matchticker.vo.getpersonalrecord;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.vo.BasicTeamVo;

/**
 * @author manboyu
 *
 */
public class ContestantsVo extends BasicTeamVo implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
