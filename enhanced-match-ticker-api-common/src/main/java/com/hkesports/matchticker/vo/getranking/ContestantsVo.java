package com.hkesports.matchticker.vo.getranking;

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

	private Integer contestantScore;
	private String contestantGlobalRank;
	private String contestantContinentRank;
	private String enContinentName;
	private String twContinentName;
    private Integer contestantGlobalTrend; //(rank increased = 1, standing/equal = 0, decreased = -1)
    private Integer contestantContinentTrend; //(rank increased = 1, standing/euql = 0, decreased = -1)
	
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

	public Integer getContestantScore() {
		return contestantScore;
	}

	public void setContestantScore(Integer contestantScore) {
		this.contestantScore = contestantScore;
	}

	public String getContestantGlobalRank() {
		return contestantGlobalRank;
	}

	public void setContestantGlobalRank(String contestantGlobalRank) {
		this.contestantGlobalRank = contestantGlobalRank;
	}

	public String getContestantContinentRank() {
		return contestantContinentRank;
	}

	public void setContestantContinentRank(String contestantContinentRank) {
		this.contestantContinentRank = contestantContinentRank;
	}

	public Integer getContestantGlobalTrend() {
		return contestantGlobalTrend;
	}

	public void setContestantGlobalTrend(Integer contestantGlobalTrend) {
		this.contestantGlobalTrend = contestantGlobalTrend;
	}

	public Integer getContestantContinentTrend() {
		return contestantContinentTrend;
	}

	public void setContestantContinentTrend(Integer contestantContinentTrend) {
		this.contestantContinentTrend = contestantContinentTrend;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
