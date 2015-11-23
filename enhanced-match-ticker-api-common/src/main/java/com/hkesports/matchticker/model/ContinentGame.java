package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hkesports.matchticker.model.basic.BasicAuditModel;

@Entity
@Table(name = "continent_game")
public class ContinentGame extends BasicAuditModel {
	
	private static final long serialVersionUID = 1L;
	
	private Long gameId;
	private Long continentId;
	private String country;
	
	// transient
	private String twGameName;
	private String enGameName;
	private String twContinentName;
	private String enContinentName;
	private String twCountryName;
	private String enCountryName;
	
	@Column(name = "game_id")
	public Long getGameId() {
		return gameId;
	}
	
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	
	@Column(name = "continent_id")
	public Long getContinentId() {
		return continentId;
	}
	
	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}
	
	@Column(name = "country", length = 2, nullable = false)
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	@Transient
	public String getTwGameName() {
		return twGameName;
	}

	public void setTwGameName(String twGameName) {
		this.twGameName = twGameName;
	}

	@Transient
	public String getEnGameName() {
		return enGameName;
	}

	public void setEnGameName(String enGameName) {
		this.enGameName = enGameName;
	}
	
	@Transient
	public String getTwContinentName() {
		return twContinentName;
	}

	public void setTwContinentName(String twContinentName) {
		this.twContinentName = twContinentName;
	}

	@Transient
	public String getEnContinentName() {
		return enContinentName;
	}

	public void setEnContinentName(String enContinentName) {
		this.enContinentName = enContinentName;
	}

	@Transient
	public String getTwCountryName() {
		return twCountryName;
	}

	public void setTwCountryName(String twCountryName) {
		this.twCountryName = twCountryName;
	}

	@Transient
	public String getEnCountryName() {
		return enCountryName;
	}

	public void setEnCountryName(String enCountryName) {
		this.enCountryName = enCountryName;
	}

}
