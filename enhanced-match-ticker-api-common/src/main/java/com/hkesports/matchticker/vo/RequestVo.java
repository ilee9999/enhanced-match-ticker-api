package com.hkesports.matchticker.vo;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.GameTypeEnum;

public class RequestVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private GameTypeEnum gameID;
	private Long tournamentID;
	private Integer pageNumber;
	private Integer pageSize;
	private Map<String, Object> option;

	public GameTypeEnum getGameID() {
		return gameID;
	}

	public void setGameID(GameTypeEnum gameID) {
		this.gameID = gameID;
	}

	public Long getTournamentID() {
		return tournamentID;
	}

	public void setTournamentID(Long tournamentID) {
		this.tournamentID = tournamentID;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getOption() {
		return option;
	}

	public void setOption(Map<String, Object> option) {
		this.option = option;
	}

	public OptionVo getScheduleFilterVo() {
		if (option == null) {
			return null;
		}
		return new OptionVo((String) option.get("gameName"),
				(String) option.get("tournamentShortName"),
				Boolean.valueOf((String) option.get("highlight")), 
				(String)option.get("sortingField"), 
				(String)option.get("sortingOrder"));
	}

	public class OptionVo implements Serializable {

		private static final long serialVersionUID = 1L;

		private String gameName;
		private String tournamentShortName;
		private Boolean highlight;
		private String sortingField;
		private String sortingOrder;
		
		public OptionVo(String gameName, String tournamentShortName, Boolean highlight, String sortingField,
				String sortingOrder) {
			this.gameName = gameName;
			this.tournamentShortName = tournamentShortName;
			this.highlight = highlight;
			this.sortingField = sortingField;
			this.sortingOrder = sortingOrder;
		}

		public OptionVo(String gameName, String tournamentShortName, Boolean highlight) {
			this.gameName = gameName;
			this.tournamentShortName = tournamentShortName;
			this.highlight = highlight;
		}

		public String getGameName() {
			return gameName;
		}

		public String getTournamentShortName() {
			return tournamentShortName;
		}

		public Boolean getHighlight() {
			return highlight;
		}

		public String getSortingField() {
			return sortingField;
		}

		public void setSortingField(String sortingField) {
			this.sortingField = sortingField;
		}

		public String getSortingOrder() {
			return sortingOrder;
		}

		public void setSortingOrder(String sortingOrder) {
			this.sortingOrder = sortingOrder;
		}
	}

	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
