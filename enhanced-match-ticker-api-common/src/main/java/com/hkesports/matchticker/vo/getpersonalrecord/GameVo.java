package com.hkesports.matchticker.vo.getpersonalrecord;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.utils.Const;

public class GameVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Short gameNumber;
	private Long gameID;
	private Long winnerID; //（勝出隊伍或playID）
	private Long gameCreation; //(start time?)
    private Integer gameLength;

	private List<GameContestantVo> contestants;

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

	@JsonProperty(value="gameCreation")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	public Date getGameCreationDate() {
		return gameCreation==null?null:new Date(gameCreation);
	}
	
	@JsonIgnore
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

	@JsonProperty(value="Contestants")
	public List<GameContestantVo> getContestants() {
		return contestants;
	}

	public void setContestants(List<GameContestantVo> contestants) {
		this.contestants = contestants;
	}
}
