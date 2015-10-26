package com.hkesports.matchticker.vo.getmatchstatistics;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.utils.Const;
import com.hkesports.matchticker.vo.BasicVo;

public class GetmatchstatisticsVo extends BasicVo {
	private static final long serialVersionUID = 1L;

	private Long tournamentID; //Schedule.tourament.id
	private String tournamentName; //Schedule.tourament.tournamentName
//	private String tournamentRound; //
	private Date matchStartTime; //Schedule.startTime
	private Long winnerID; //Schedule.winner
	private Short maxGames; //Game.maxGames
	private Boolean isLive; //Game.isLive
	private Short isFinished; //Schedule.isFinished
	private String matchName; //Schedule.name

	private List<TeamVo> Teams;
	private List<GameVo> Games;

	public GetmatchstatisticsVo() {}
	public GetmatchstatisticsVo(Long tournamentID, String tournamentName, Date matchStartTime,
			Long winnerID, Short maxGames, Boolean isLive, Short isFinished, String matchName) {
		super();
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.matchStartTime = matchStartTime;
		this.winnerID = winnerID;
		this.maxGames = maxGames;
		this.isLive = isLive;
		this.isFinished = isFinished;
		this.matchName = matchName;
	}
	
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	public Date getMatchStartTime() {
		return matchStartTime;
	}

	public void setMatchStartTime(Date matchStartTime) {
		this.matchStartTime = matchStartTime;
	}

	public Long getWinnerID() {
		return winnerID;
	}

	public void setWinnerID(Long winnerID) {
		this.winnerID = winnerID;
	}

	public Short getMaxGames() {
		return maxGames;
	}

	public void setMaxGames(Short maxGames) {
		this.maxGames = maxGames;
	}

	public Boolean getIsLive() {
		return isLive;
	}

	public void setIsLive(Boolean isLive) {
		this.isLive = isLive;
	}

	public Short getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Short isFinished) {
		this.isFinished = isFinished;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	@JsonProperty("Teams")
	public List<TeamVo> getTeams() {
		return Teams;
	}

	public void setTeams(List<TeamVo> teams) {
		Teams = teams;
	}

	@JsonProperty("Games")
	public List<GameVo> getGames() {
		return Games;
	}

	public void setGames(List<GameVo> games) {
		Games = games;
	}
}
