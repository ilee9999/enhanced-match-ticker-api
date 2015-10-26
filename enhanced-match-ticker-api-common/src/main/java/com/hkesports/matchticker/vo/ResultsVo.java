package com.hkesports.matchticker.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manboyu
 *
 */
public class ResultsVo<T> extends BasicVo {

	private static final long serialVersionUID = 1L;
	
	private List<T> Results = new ArrayList<>();
	
	public List<T> getResults() {
		return Results;
	}

	public void setResults(List<T> results) {
		Results = results;
	}
}
