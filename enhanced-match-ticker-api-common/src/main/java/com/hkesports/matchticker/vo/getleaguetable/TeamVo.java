package com.hkesports.matchticker.vo.getleaguetable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.vo.BasicTeamVo;

/**
 * @author manboyu
 *
 */
public class TeamVo extends BasicTeamVo {

	private static final long serialVersionUID = 1L;

	private Integer teamScore;
	private String position;
	private Integer trend;

	public Integer getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(Integer teamScore) {
		this.teamScore = teamScore;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getTrend() {
		return trend;
	}

	public void setTrend(Integer trend) {
		this.trend = trend;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
