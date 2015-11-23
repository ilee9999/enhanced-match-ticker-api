package com.hkesports.matchticker.vo.getpersonalrecord;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YearVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer year;
	
	private BigInteger yearlyTotalSpending;
	
	private List<MonthVo> month = new ArrayList<>();
	
	public YearVo() {}

	public YearVo(Integer year) {
		this.year = year;
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigInteger getYearlyTotalSpending() {
		return yearlyTotalSpending;
	}

	public void setYearlyTotalSpending(BigInteger yearlyTotalSpending) {
		this.yearlyTotalSpending = yearlyTotalSpending;
	}
	
	@JsonProperty("Month")
	public List<MonthVo> getMonth() {
		return month;
	}

	public void setMonth(List<MonthVo> month) {
		this.month = month;
	}
	
	public void addMonth(MonthVo vo) {
		this.month.add(vo);
	}
}
