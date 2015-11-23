package com.hkesports.matchticker.vo.getpersonalrecord;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MonthVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer year;
	
	private Integer month;
	
	private BigInteger monthlyTotalSpending;

	private List<DayVo> day = new ArrayList<>();

	public MonthVo() {}
	
	public MonthVo(Integer month) {
		this.month = month;
	}
	
	@JsonIgnore
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public BigInteger getMonthlyTotalSpending() {
		return monthlyTotalSpending;
	}

	public void setMonthlyTotalSpending(BigInteger monthlyTotalSpending) {
		this.monthlyTotalSpending = monthlyTotalSpending;
	}

	@JsonProperty("Day")
	public List<DayVo> getDay() {
		return day;
	}

	public void setDay(List<DayVo> day) {
		this.day = day;
	}

	public void addDay(DayVo vo) {
		day.add(vo);
	}
}
