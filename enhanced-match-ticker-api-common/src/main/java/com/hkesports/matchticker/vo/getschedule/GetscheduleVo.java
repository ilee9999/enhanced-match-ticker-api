package com.hkesports.matchticker.vo.getschedule;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.vo.BasicVo;

public class GetscheduleVo extends BasicVo {
	private static final long serialVersionUID = 1L;

	private List<ResultVo> Results;

	@JsonProperty("Results")
	public List<ResultVo> getResults() {
		return Results;
	}

	public void setResults(List<ResultVo> results) {
		Results = results;
	}
}
