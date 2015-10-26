package com.hkesports.matchticker.vo.getranking;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.vo.BasicTeamVo;

/**
 * @author manboyu
 *
 */
public class TeamVo extends BasicTeamVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer teamScore;
	private String teamGlobalRank;
	private String teamContinentRank;
	private String enContinentName;
	private String twContinentName;
	private Integer teamGlobalTrend;
	private Integer teamContinentTrend;

	public Integer getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(Integer teamScore) {
		this.teamScore = teamScore;
	}

	public String getTeamGlobalRank() {
		return teamGlobalRank;
	}

	public void setTeamGlobalRank(String teamGlobalRank) {
		this.teamGlobalRank = teamGlobalRank;
	}

	public String getTeamContinentRank() {
		return teamContinentRank;
	}

	public void setTeamContinentRank(String teamContinentRank) {
		this.teamContinentRank = teamContinentRank;
	}

	public String getEnContinentName() {
		return enContinentName;
	}

	public void setEnContinentName(String enContinentName) {
		this.enContinentName = enContinentName;
	}

	public String getTwContinentName() {
		return twContinentName;
	}

	public void setTwContinentName(String twContinentName) {
		this.twContinentName = twContinentName;
	}

	public Integer getTeamGlobalTrend() {
		return teamGlobalTrend;
	}

	public void setTeamGlobalTrend(Integer teamGlobalTrend) {
		this.teamGlobalTrend = teamGlobalTrend;
	}

	public Integer getTeamContinentTrend() {
		return teamContinentTrend;
	}

	public void setTeamContinentTrend(Integer teamContinentTrend) {
		this.teamContinentTrend = teamContinentTrend;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
