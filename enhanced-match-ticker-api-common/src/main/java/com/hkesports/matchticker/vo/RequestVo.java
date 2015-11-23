package com.hkesports.matchticker.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RequestVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String registrationID;
	private String secretKey;
	private Long gameID;
	private String gameName;
	private Long tournamentID;
	private String tournamentShortName;
	private Boolean highlight;
	private Integer pageNumber;
	private Integer pageSize;

	public String getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(String registrationID) {
		this.registrationID = registrationID;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Long getGameID() {
		return gameID;
	}

	public void setGameID(Long gameID) {
		this.gameID = gameID;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Long getTournamentID() {
		return tournamentID;
	}

	public void setTournamentID(Long tournamentID) {
		this.tournamentID = tournamentID;
	}

	public String getTournamentShortName() {
		return tournamentShortName;
	}

	public void setTournamentShortName(String tournamentShortName) {
		this.tournamentShortName = tournamentShortName;
	}

	public Boolean getHighlight() {
		return highlight;
	}

	public void setHighlight(Boolean highlight) {
		this.highlight = highlight;
	}

	public Integer getPageNumber() {
		if(pageNumber == null || pageNumber < 0)
			return 0; // default 0
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		/*
		 * client端 pageNumber 是從1開始, 
		 * 而hibernate firstResult index是由0開始
		 * 故實際index是由client傳進來的值-1 
		 */
		if(pageNumber != null && pageNumber > 0) {
			pageNumber--;
		}
		this.pageNumber = pageNumber;
	}

	public Integer getStartIndex() {
		return getPageNumber() * getPageSize();
	} 
	
	public Integer getPageSize() {
		if(this.pageSize == null)
			return 10; // default 10
		return this.pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
