package com.hkesports.matchticker.vo.getmatchstatistics;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameTeamVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ID; 							// ScheduleGameDetail.team id ?
	private Long scheduleGameDetailId; 			// ScheduleGameDetail.id
	private Integer towerKills; 				// ScheduleGameDetail.towerKills
	private Integer inhibitorKills; 			// ScheduleGameDetail.inhibitorKills
	private Integer baronKills; 				// ScheduleGameDetail.baronKills
	private Integer dragonKills; 				// ScheduleGameDetail.dragonKills
	private Integer vilemawKills; 				// ScheduleGameDetail.vilemawKills
	private Integer dominionVictoryScore; 		// ScheduleGameDetail.dominionVictoryScore
	private Boolean firstBaron; 				// ScheduleGameDetail.firstBaron
	private Boolean firstDragon; 				// ScheduleGameDetail.firstDragon
	private Integer teamGuessingRate; 			// ScheduleGameDetail.guessingRate / same scheduleGame sum(scheduleGameDetail.guessingRate)
	private Integer towerStatus;				// ScheduleGameDetail.towerStatus
	private Integer barracksStatus;				// ScheduleGameDetail.barracksStatus
	
	private List<GameTeamBanVo> Bans;
	private List<GameTeamPlayerVo> Players;
	
	public GameTeamVo() {
	}

	public GameTeamVo(Long iD, Integer towerKills, Integer inhibitorKills,
			Integer baronKills, Integer dragonKills, Integer vilemawKills,
			Integer dominionVictoryScore, Boolean firstBaron,
			Boolean firstDragon, Integer teamGuessingRate) {
		super();
		this.ID = iD;
		this.towerKills = towerKills;
		this.inhibitorKills = inhibitorKills;
		this.baronKills = baronKills;
		this.dragonKills = dragonKills;
		this.vilemawKills = vilemawKills;
		this.dominionVictoryScore = dominionVictoryScore;
		this.firstBaron = firstBaron;
		this.firstDragon = firstDragon;
		this.teamGuessingRate = teamGuessingRate;
	}

	public GameTeamVo(Long iD, Long scheduleGameDetailId, Integer towerKills,
			Integer inhibitorKills, Integer baronKills, Integer dragonKills,
			Integer vilemawKills, Integer dominionVictoryScore,
			Boolean firstBaron, Boolean firstDragon) {
		super();
		this.ID = iD;
		this.scheduleGameDetailId = scheduleGameDetailId;
		this.towerKills = towerKills;
		this.inhibitorKills = inhibitorKills;
		this.baronKills = baronKills;
		this.dragonKills = dragonKills;
		this.vilemawKills = vilemawKills;
		this.dominionVictoryScore = dominionVictoryScore;
		this.firstBaron = firstBaron;
		this.firstDragon = firstDragon;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Integer getTowerKills() {
		return towerKills;
	}

	public void setTowerKills(Integer towerKills) {
		this.towerKills = towerKills;
	}

	public Integer getInhibitorKills() {
		return inhibitorKills;
	}

	public void setInhibitorKills(Integer inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public Integer getBaronKills() {
		return baronKills;
	}

	public void setBaronKills(Integer baronKills) {
		this.baronKills = baronKills;
	}

	public Integer getDragonKills() {
		return dragonKills;
	}

	public void setDragonKills(Integer dragonKills) {
		this.dragonKills = dragonKills;
	}

	public Integer getVilemawKills() {
		return vilemawKills;
	}

	public void setVilemawKills(Integer vilemawKills) {
		this.vilemawKills = vilemawKills;
	}

	public Integer getDominionVictoryScore() {
		return dominionVictoryScore;
	}

	public void setDominionVictoryScore(Integer dominionVictoryScore) {
		this.dominionVictoryScore = dominionVictoryScore;
	}

	public Boolean getFirstBaron() {
		return firstBaron;
	}

	public void setFirstBaron(Boolean firstBaron) {
		this.firstBaron = firstBaron;
	}

	public Boolean getFirstDragon() {
		return firstDragon;
	}

	public void setFirstDragon(Boolean firstDragon) {
		this.firstDragon = firstDragon;
	}

	@JsonIgnore
	public Long getScheduleGameDetailId() {
		return scheduleGameDetailId;
	}

	public void setScheduleGameDetailId(Long scheduleGameDetailId) {
		this.scheduleGameDetailId = scheduleGameDetailId;
	}

	public Integer getTeamGuessingRate() {
		return teamGuessingRate;
	}

	public void setTeamGuessingRate(Integer teamGuessingRate) {
		this.teamGuessingRate = teamGuessingRate;
	}

	public Integer getTowerStatus() {
		return towerStatus;
	}

	public void setTowerStatus(Integer towerStatus) {
		this.towerStatus = towerStatus;
	}

	public Integer getBarracksStatus() {
		return barracksStatus;
	}

	public void setBarracksStatus(Integer barracksStatus) {
		this.barracksStatus = barracksStatus;
	}

	@JsonProperty("Bans")
	public List<GameTeamBanVo> getBans() {
		return Bans;
	}

	public void setBans(List<GameTeamBanVo> bans) {
		Bans = bans;
	}

	@JsonProperty("Players")
	public List<GameTeamPlayerVo> getPlayers() {
		return Players;
	}

	public void setPlayers(List<GameTeamPlayerVo> players) {
		Players = players;
	}
}
