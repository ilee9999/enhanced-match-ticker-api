package com.hkesports.matchticker.vo.gettournamentlist;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author manboyu
 *
 */
public class GameVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long gameID;
	private String enGameName;
	private String twGameName;
	private String gameURL;
	
	public GameVo(Long gameID, String enGameName, String twGameName, String gameURL) {
		this.gameID = gameID;
		this.enGameName = enGameName;
		this.twGameName = twGameName;
		this.gameURL = gameURL;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("gameID", getGameID())
		.append("enGameName", getEnGameName())
		.append("twGameName", getTwGameName())
		.append("gameURL", getGameURL())
		.build();
	}
}
