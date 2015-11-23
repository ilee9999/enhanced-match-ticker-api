package com.hkesports.matchticker.vo.getpersonalrecord;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.vo.BasicVo;

public class GetpersonalrecordVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private BigInteger ha;
	
	private List<YearVo> year = new ArrayList<>();
	
	public GetpersonalrecordVo() {}
	
	public GetpersonalrecordVo(StatusCodeEnum statusCode) {
		super(statusCode);
	}
	
	public BigInteger getHa() {
		return ha;
	}

	public void setHa(BigInteger ha) {
		this.ha = ha;
	}

	@JsonProperty("Year")
	public List<YearVo> getYear() {
		return year;
	}

	public void setYear(List<YearVo> year) {
		this.year = year;
	}

	public void addYear(YearVo vo) {
		this.year.add(vo);
	}
}
