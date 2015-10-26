package com.hkesports.matchticker.vo.getranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author manboyu
 *
 */
public class GameVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long matchID;
	private Long gameID;
	private String enGameName;
	private String twGameName;
	private String gameURL;
	private List<TeamVo> Teams = new ArrayList<>(2);
	
	public GameVo() {
		
	}
	
	public GameVo(Long matchID, Long gameID, String enGameName, String twGameName, String gameURL) {
		this.matchID = matchID;
		this.gameID = gameID;
		this.enGameName = enGameName;
		this.twGameName = twGameName;
		this.gameURL = gameURL;
	}

	@JsonIgnore
	public Long getMatchID() {
		return matchID;
	}

	public void setMatchID(Long matchID) {
		this.matchID = matchID;
	}

	public Long getGameID() {
		return gameID;
	}

	public void setGameID(Long gameID) {
		this.gameID = gameID;
	}

	public String getEnGameName() {
		return enGameName;
	}

	public void setEnGameName(String enGameName) {
		this.enGameName = enGameName;
	}

	public String getTwGameName() {
		return twGameName;
	}

	public void setTwGameName(String twGameName) {
		this.twGameName = twGameName;
	}

	public String getGameURL() {
		return gameURL;
	}

	public void setGameURL(String gameURL) {
		this.gameURL = gameURL;
	}
	
	public List<TeamVo> getTeams() {
		return Teams;
	}

	public void setTeams(List<TeamVo> teams) {
		Teams = teams;
	}
	
	public void addTeam(TeamVo vo) {
		Teams.add(vo);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("matchID", getMatchID())
		.append("gameID", getGameID())
		.append("enGameName", getEnGameName())
		.append("twGameName", getTwGameName())
		.append("gameURL", getGameURL())
		.build();
	}
}
