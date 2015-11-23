package com.hkesports.matchticker.vo.getgamelist;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class GameVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long gameID;
	private String enGameName;
	private String twGameName;
	private String gameIconLarge;
	private String gameIconSmall;
	
	private String wordpressCateory;
	private String wordpressImportantCategory;
	
	public GameVo(Long gameID, String enGameName, String twGameName, String gameIconLarge, String gameIconSmall, String wordpressCateory, String wordpressImportantCategory) {
		this.gameID = gameID;
		this.enGameName = enGameName;
		this.twGameName = twGameName;
		this.gameIconLarge = gameIconLarge;
		this.gameIconSmall = gameIconSmall;
		this.wordpressCateory = wordpressCateory;
		this.wordpressImportantCategory = wordpressImportantCategory;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("gameID", getGameID())
		.append("enGameName", getEnGameName())
		.append("twGameName", getTwGameName())
		.append("gameIconLarge", getGameIconLarge())
		.append("gameIconSmall", getGameIconSmall())
		.append("wordpressCateory", getWordpressCateory())
		.append("wordpressImportantCategory", getWordpressImportantCategory())
		.build();
	}

	public String getGameIconLarge() {
		return gameIconLarge;
	}

	public void setGameIconLarge(String gameIconLarge) {
		this.gameIconLarge = gameIconLarge;
	}

	public String getGameIconSmall() {
		return gameIconSmall;
	}

	public void setGameIconSmall(String gameIconSmall) {
		this.gameIconSmall = gameIconSmall;
	}

	public String getWordpressCateory() {
		return wordpressCateory;
	}

	public void setWordpressCateory(String wordpressCateory) {
		this.wordpressCateory = wordpressCateory;
	}

	public String getWordpressImportantCategory() {
		return wordpressImportantCategory;
	}

	public void setWordpressImportantCategory(String wordpressImportantCategory) {
		this.wordpressImportantCategory = wordpressImportantCategory;
	}

}
