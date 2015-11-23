package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hkesports.matchticker.model.basic.BasicAuditModel;

@Entity
@Table(name = "country")
public class Country extends BasicAuditModel {

	private static final long serialVersionUID = 1L;

	private String countryCode;
	private String twCountryName;
	private String enCountryName;

	@Column(name = "country_code")
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Column(name = "tw_country_name")
	public String getTwCountryName() {
		return twCountryName;
	}

	public void setTwCountryName(String twCountryName) {
		this.twCountryName = twCountryName;
	}

	@Column(name = "en_country_name")
	public String getEnCountryName() {
		return enCountryName;
	}

	public void setEnCountryName(String enCountryName) {
		this.enCountryName = enCountryName;
	}
}
