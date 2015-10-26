package com.hkesports.matchticker.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author manboyu
 *
 */
public class BasicTeamVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ID;
	private Integer teamNumber;
	private String teamName;
	private String teamAronym;
	private Long teamWins;
	private Long teamLosses;
	private String teamCountry;
	private String teamURL;
	private String teamLogoURLThumbnail;
	private String teamLogoURLLarge;
	private String teamLogoURLOriginal;

	public BasicTeamVo() {
	}
	
	public BasicTeamVo(Long iD, Integer teamNumber, String teamName, String teamAronym, String teamCountry, String teamURL, String logoURL) {
		super();
		this.ID = iD;
		this.teamNumber = teamNumber;
		this.teamName = teamName;
		this.teamAronym = teamAronym;
		this.teamCountry = teamCountry;
		this.teamURL = teamURL;
		this.teamLogoURLThumbnail = logoURL;
		this.teamLogoURLLarge = logoURL;
		this.teamLogoURLOriginal = logoURL;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Integer getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(Integer teamNumber) {
		this.teamNumber = teamNumber;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamAronym() {
		return teamAronym;
	}

	public void setTeamAronym(String teamAronym) {
		this.teamAronym = teamAronym;
	}

	public Long getTeamWins() {
		return teamWins;
	}

	public void setTeamWins(Long teamWins) {
		this.teamWins = teamWins;
	}

	public Long getTeamLosses() {
		return teamLosses;
	}

	public void setTeamLosses(Long teamLosses) {
		this.teamLosses = teamLosses;
	}

	public String getTeamCountry() {
		return teamCountry;
	}

	public void setTeamCountry(String teamCountry) {
		this.teamCountry = teamCountry;
	}

	public String getTeamURL() {
		return teamURL;
	}

	public void setTeamURL(String teamURL) {
		this.teamURL = teamURL;
	}

	public String getTeamLogoURLThumbnail() {
		return teamLogoURLThumbnail;
	}

	public void setTeamLogoURLThumbnail(String teamLogoURLThumbnail) {
		this.teamLogoURLThumbnail = teamLogoURLThumbnail;
	}

	public String getTeamLogoURLLarge() {
		return teamLogoURLLarge;
	}

	public void setTeamLogoURLLarge(String teamLogoURLLarge) {
		this.teamLogoURLLarge = teamLogoURLLarge;
	}

	public String getTeamLogoURLOriginal() {
		return teamLogoURLOriginal;
	}

	public void setTeamLogoURLOriginal(String teamLogoURLOriginal) {
		this.teamLogoURLOriginal = teamLogoURLOriginal;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
