package com.hkesports.matchticker.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author manboyu
 *
 */
public class BasicTeamVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ID;
	protected Integer contestantNumber;
	protected String contestantName;
	protected String contestantAronym;
	protected Long contestantWins;
	protected Long contestantDraws;
	protected Long contestantLosses;
	protected String contestantCountry;// (To be input by admin)
	protected String contestantURL;
	protected String contestantLogoURLThumbnail;
	protected String contestantLogoURLLarge;
	
	public BasicTeamVo() {
	}

	public BasicTeamVo(Long ID, String contestantName, String contestantAronym, String contestantCountry, 
			String contestantURL, String contestantLogoURLThumbnail, String contestantLogoURLLarge) {
		this.ID = ID;
		this.contestantName = contestantName;
		this.contestantAronym = contestantAronym;
		this.contestantCountry = contestantCountry;// (To be input by admin)
		this.contestantURL = contestantURL;
		this.contestantLogoURLThumbnail = contestantLogoURLThumbnail;
		this.contestantLogoURLLarge = contestantLogoURLLarge;
	}
	
	@JsonProperty("ID")
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Integer getContestantNumber() {
		return contestantNumber;
	}

	public void setContestantNumber(Integer contestantNumber) {
		this.contestantNumber = contestantNumber;
	}

	public String getContestantName() {
		return contestantName;
	}

	public void setContestantName(String contestantName) {
		this.contestantName = contestantName;
	}

	public String getContestantAronym() {
		return contestantAronym;
	}

	public void setContestantAronym(String contestantAronym) {
		this.contestantAronym = contestantAronym;
	}

	public Long getContestantWins() {
		return contestantWins;
	}

	public void setContestantWins(Long contestantWins) {
		this.contestantWins = contestantWins;
	}

	public Long getContestantDraws() {
		return contestantDraws;
	}

	public void setContestantDraws(Long contestantDraws) {
		this.contestantDraws = contestantDraws;
	}
	
	public Long getContestantLosses() {
		return contestantLosses;
	}

	public void setContestantLosses(Long contestantLosses) {
		this.contestantLosses = contestantLosses;
	}

	public String getContestantCountry() {
		return contestantCountry;
	}

	public void setContestantCountry(String contestantCountry) {
		this.contestantCountry = contestantCountry;
	}

	public String getContestantURL() {
		return contestantURL;
	}

	public void setContestantURL(String contestantURL) {
		this.contestantURL = contestantURL;
	}

	public String getContestantLogoURLThumbnail() {
		return contestantLogoURLThumbnail;
	}

	public void setContestantLogoURLThumbnail(String contestantLogoURLThumbnail) {
		this.contestantLogoURLThumbnail = contestantLogoURLThumbnail;
	}

	public String getContestantLogoURLLarge() {
		return contestantLogoURLLarge;
	}

	public void setContestantLogoURLLarge(String contestantLogoURLLarge) {
		this.contestantLogoURLLarge = contestantLogoURLLarge;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
