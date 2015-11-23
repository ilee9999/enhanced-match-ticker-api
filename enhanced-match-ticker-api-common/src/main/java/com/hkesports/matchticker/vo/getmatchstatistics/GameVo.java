package com.hkesports.matchticker.vo.getmatchstatistics;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameVo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Short gameNumber; 				// ScheduleGame.gameNumber
	private Long gameID;					// ScheduleGame.id
	private Long winnerID; 					// ScheduleGame.winnerID
	private Long gameCreation; 				// ScheduleGame.gameCreation
	private Integer gameLength; 			// ScheduleGame.gameLength
	private Long firstBloodPlayerID; 		// ScheduleGamePlayerDetail firstBlood=true
	private Long firstTowerPlayerID; 		// ScheduleGamePlayerDetail firstTower=true
	private Long firstInhibitorPlayerID; 	// ScheduleGamePlayerDetail firstInhibitor=true
	private Integer tournamentRound; 		// ScheduleGame.tournamentRound
	private Short lobbyType; 				// ScheduleGame.lobbyType
	private Integer humanPlayers; 			// ScheduleGame.humanPlayers
	private Integer positiveVotes;			// ScheduleGame.positiveVotes
	private Integer negativeVote;			// ScheduleGame.negativeVote
	private Short gameMode;					// ScheduleGame.gameMode
	private Integer firstBloodTime;			// ScheduleGame.firstBloodTime
	
	private List<GameVodVo> Vods;
	private List<GameTeamVo> Teams;

	public GameVo() {}
	
	public GameVo(Short gameNumber, Long gameID, Long winnerID, Long gameCreation, Integer gameLength,
			Long firstBloodPlayerID, Long firstTowerPlayerID, Long firstInhibitorPlayerID, Integer tournamentRound) {
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

	public GameVo(Short gameNumber, Long gameID, Integer gameLength,
			Short lobbyType, Integer humanPlayers, Integer positiveVotes,
			Integer negativeVote, Short gameMode, Integer firstBloodTime) {
		this.gameNumber = gameNumber;
		this.gameID = gameID;
		this.gameLength = gameLength;
		this.lobbyType = lobbyType;
		this.humanPlayers = humanPlayers;
		this.positiveVotes = positiveVotes;
		this.negativeVote = negativeVote;
		this.gameMode = gameMode;
		this.firstBloodTime = firstBloodTime;
	}

	public Short getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(Short gameNumber) {
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

	public Short getLobbyType() {
		return lobbyType;
	}

	public void setLobbyType(Short lobbyType) {
		this.lobbyType = lobbyType;
	}

	public Integer getHumanPlayers() {
		return humanPlayers;
	}

	public void setHumanPlayers(Integer humanPlayers) {
		this.humanPlayers = humanPlayers;
	}

	public Integer getPositiveVotes() {
		return positiveVotes;
	}

	public void setPositiveVotes(Integer positiveVotes) {
		this.positiveVotes = positiveVotes;
	}

	public Integer getNegativeVote() {
		return negativeVote;
	}

	public void setNegativeVote(Integer negativeVote) {
		this.negativeVote = negativeVote;
	}

	public Short getGameMode() {
		return gameMode;
	}

	public void setGameMode(Short gameMode) {
		this.gameMode = gameMode;
	}

	public Integer getFirstBloodTime() {
		return firstBloodTime;
	}

	public void setFirstBloodTime(Integer firstBloodTime) {
		this.firstBloodTime = firstBloodTime;
	}
}
