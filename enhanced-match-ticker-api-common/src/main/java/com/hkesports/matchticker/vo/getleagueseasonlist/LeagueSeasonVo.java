package com.hkesports.matchticker.vo.getleagueseasonlist;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.utils.Const;

/**
 * @author manboyu
 *
 */
public class LeagueSeasonVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String leagueSeasonName;
	private String leagueSeasonDetails;
	private Date leagueSeasonStartDate;
	private Date leagueSeasonEndDate;
	private String leagueIconSmallURL;
	private List<TournamentVo> tournaments;

	public LeagueSeasonVo() {
		
	}

	public LeagueSeasonVo(Long id, String leagueSeasonName,
			String leagueSeasonDetails, Date leagueSeasonStartDate,
			Date leagueSeasonEndDate) {
		this.id = id;
		this.leagueSeasonName = leagueSeasonName;
		this.leagueSeasonDetails = leagueSeasonDetails;
		this.leagueSeasonStartDate = leagueSeasonStartDate;
		this.leagueSeasonEndDate = leagueSeasonEndDate;
	}
	
	public LeagueSeasonVo(Long id, String leagueSeasonName,
			String leagueSeasonDetails, Date leagueSeasonStartDate,
			Date leagueSeasonEndDate, String leagueIconSmallURL) {
		this.id = id;
		this.leagueSeasonName = leagueSeasonName;
		this.leagueSeasonDetails = leagueSeasonDetails;
		this.leagueSeasonStartDate = leagueSeasonStartDate;
		this.leagueSeasonEndDate = leagueSeasonEndDate;
		this.leagueIconSmallURL = leagueIconSmallURL;
	}

	@JsonProperty("ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLeagueSeasonName() {
		return leagueSeasonName;
	}

	public void setLeagueSeasonName(String leagueSeasonName) {
		this.leagueSeasonName = leagueSeasonName;
	}

	public String getLeagueSeasonDetails() {
		return leagueSeasonDetails;
	}

	public void setLeagueSeasonDetails(String leagueSeasonDetails) {
		this.leagueSeasonDetails = leagueSeasonDetails;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	public Date getLeagueSeasonStartDate() {
		return leagueSeasonStartDate;
	}

	public void setLeagueSeasonStartDate(Date leagueSeasonStartDate) {
		this.leagueSeasonStartDate = leagueSeasonStartDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	public Date getLeagueSeasonEndDate() {
		return leagueSeasonEndDate;
	}

	public void setLeagueSeasonEndDate(Date leagueSeasonEndDate) {
		this.leagueSeasonEndDate = leagueSeasonEndDate;
	}

	public String getLeagueIconSmallURL() {
		return leagueIconSmallURL;
	}

	public void setLeagueIconSmallURL(String leagueIconSmallURL) {
		this.leagueIconSmallURL = leagueIconSmallURL;
	}

	@JsonProperty("LeagueSeasonListTournaments")
	public List<TournamentVo> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<TournamentVo> tournaments) {
		this.tournaments = tournaments;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("leagueSeasonName", getLeagueSeasonName())
		.append("leagueSeasonDetails", getLeagueSeasonDetails())
		.append("leagueSeasonStartDate", getLeagueSeasonStartDate())
		.append("leagueSeasonEndDate", getLeagueSeasonEndDate())
		.build();
	}
}
