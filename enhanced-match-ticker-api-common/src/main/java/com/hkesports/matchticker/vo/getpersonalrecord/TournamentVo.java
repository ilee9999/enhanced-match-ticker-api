package com.hkesports.matchticker.vo.getpersonalrecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TournamentVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long tournamentID;
	
	private String tournamentName;

	private List<RecordVo> records = new ArrayList<>();

	public Long getTournamentID() {
		return tournamentID;
	}

	public void setTournamentID(Long tournamentID) {
		this.tournamentID = tournamentID;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	@JsonProperty(value = "Records")
	public List<RecordVo> getRecords() {
		return records;
	}

	public void setRecords(List<RecordVo> records) {
		this.records = records;
	}
	
	public void addRecord(RecordVo record) {
		records.add(record);
	}
}
