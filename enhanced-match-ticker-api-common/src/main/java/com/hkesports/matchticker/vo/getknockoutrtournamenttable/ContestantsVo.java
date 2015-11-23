package com.hkesports.matchticker.vo.getknockoutrtournamenttable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.vo.BasicTeamVo;

public class ContestantsVo extends BasicTeamVo {

	private static final long serialVersionUID = 1L;

	private String contestantGroup;
	
	private Boolean contestantOut;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String getContestantGroup() {
		return contestantGroup;
	}

	public void setContestantGroup(String contestantGroup) {
		this.contestantGroup = contestantGroup;
	}

	public Boolean getContestantOut() {
		return contestantOut;
	}

	public void setContestantOut(Boolean contestantOut) {
		this.contestantOut = contestantOut;
	}
}
