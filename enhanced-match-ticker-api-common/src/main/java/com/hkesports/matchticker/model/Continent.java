package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hkesports.matchticker.model.basic.BasicAuditModel;

@Entity
@Table(name = "continent")
public class Continent extends BasicAuditModel {
	
	private static final long serialVersionUID = 1L;

	private String enContinentName;
	private String twContinentName;
	
	@Column(name = "en_continent_name", length = 64, nullable = false)
	public String getEnContinentName() {
		return enContinentName;
	}
	
	public void setEnContinentName(String enContinentName) {
		this.enContinentName = enContinentName;
	}
	
	@Column(name = "tw_continent_name", length = 64, nullable = false)
	public String getTwContinentName() {
		return twContinentName;
	}
	
	public void setTwContinentName(String twContinentName) {
		this.twContinentName = twContinentName;
	}
}
