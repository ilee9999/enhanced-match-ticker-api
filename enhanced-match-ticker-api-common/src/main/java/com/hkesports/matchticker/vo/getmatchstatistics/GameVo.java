package com.hkesports.matchticker.vo.getmatchstatistics;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer gameNumber; //ScheduleGame.gameNumber
	private Long gameID;
	private Long winnerID; //ScheduleGame.winnerID
	private Long gameCreation; //ScheduleGame.gameCreation
	private Integer gameLength; //ScheduleGame.gameLength
	private Long firstBloodPlayerID; //ScheduleGamePlayerDetail firstBlood=true
	private Long firstTowerPlayerID; //ScheduleGamePlayerDetail firstTower=true
	private Long firstInhibitorPlayerID; //ScheduleGamePlayerDetail firstInhibitor=true
	private Integer tournamentRound; //ScheduleGame.tournamentRound
	
	
	private List<GameVodVo> Vods;
	private List<GameTeamVo> Teams;

	public GameVo() {}
	
	public GameVo(Integer gameNumber, Long gameID, Long winnerID, Long gameCreation, Integer gameLength,
			Long firstBloodPlayerID, Long firstTowerPlayerID, Long firstInhibitorPlayerID, Integer tournamentRound) {
		super();
		this.gameNumber = gameNumber;
		this.gameID = gameID;
		this.winnerID = winnerID;
		this.gameCreation = gameCreation;
		this.gameLength = gameLength;
		this.firstBloodPlayerID = firstBloodPlayerID;
		this.firstTowerPlayerID = firstTowerPlayerID;
		this.firstInhibitorPlayerID = firstInhibitorPlayerID;
		this.tournamentRound = tournamentRound;
	}

	public Integer getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(Integer gameNumber) {
		this.gameNumber = gameNumber;
	}

	public Long getGameID() {
		return gameID;
	}

	public void setGameID(Long gameID) {
		this.gameID = gameID;
	}

	public Long getWinnerID() {
		return winnerID;
	}

	public void setWinnerID(Long winnerID) {
		this.winnerID = winnerID;
	}

	public Long getGameCreation() {
		return gameCreation;
	}

	public void setGameCreation(Long gameCreation) {
		this.gameCreation = gameCreation;
	}

	public Integer getGameLength() {
		return gameLength;
	}

	public void setGameLength(Integer gameLength) {
		this.gameLength = gameLength;
	}

	public Long getFirstBloodPlayerID() {
		return firstBloodPlayerID;
	}

	public void setFirstBloodPlayerID(Long firstBloodPlayerID) {
		this.firstBloodPlayerID = firstBloodPlayerID;
	}

	public Long getFirstTowerPlayerID() {
		return firstTowerPlayerID;
	}

	public void setFirstTowerPlayerID(Long firstTowerPlayerID) {
		this.firstTowerPlayerID = firstTowerPlayerID;
	}

	public Long getFirstInhibitorPlayerID() {
		return firstInhibitorPlayerID;
	}

	public void setFirstInhibitorPlayerID(Long firstInhibitorPlayerID) {
		this.firstInhibitorPlayerID = firstInhibitorPlayerID;
	}

	@JsonProperty("Vods")
	public List<GameVodVo> getVods() {
		return Vods;
	}

	public void setVods(List<GameVodVo> vods) {
		Vods = vods;
	}

	@JsonProperty("Teams")
	public List<GameTeamVo> getTeams() {
		return Teams;
	}

	public void setTeams(List<GameTeamVo> teams) {
		Teams = teams;
	}

	public Integer getTournamentRound() {
		return tournamentRound;
	}

	public void setTournamentRound(Integer tournamentRound) {
		this.tournamentRound = tournamentRound;
	}
}
