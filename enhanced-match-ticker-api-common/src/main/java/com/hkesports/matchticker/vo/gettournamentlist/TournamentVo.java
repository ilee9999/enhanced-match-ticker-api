package com.hkesports.matchticker.vo.gettournamentlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hkesports.matchticker.utils.Const;

/**
 * @author manboyu
 *
 */
public class TournamentVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tournamentID;
	private String tournamentName;
	private String tournamentShortName;
	private String tournamentSiteURL;
	private Date tournamentStartDate;
	private Date tournamentEndDate;
	private String tournamentDescription;
	private String tournamentChannelURL;
	private String tournamentCompetitionSystem;
	private List<GameVo> Games = new ArrayList<>();

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

	public String getTournamentShortName() {
		return tournamentShortName;
	}

	public void setTournamentShortName(String tournamentShortName) {
		this.tournamentShortName = tournamentShortName;
	}

	public String getTournamentSiteURL() {
		return tournamentSiteURL;
	}

	public void setTournamentSiteURL(String tournamentSiteURL) {
		this.tournamentSiteURL = tournamentSiteURL;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT_YYYYMMDD)
	public Date getTournamentStartDate() {
		return tournamentStartDate;
	}

	public void setTournamentStartDate(Date tournamentStartDate) {
		this.tournamentStartDate = tournamentStartDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT_YYYYMMDD)
	public Date getTournamentEndDate() {
		return tournamentEndDate;
	}

	public void setTournamentEndDate(Date tournamentEndDate) {
		this.tournamentEndDate = tournamentEndDate;
	}

	public String getTournamentDescription() {
		return tournamentDescription;
	}

	public void setTournamentDescription(String tournamentDescription) {
		this.tournamentDescription = tournamentDescription;
	}

	public String getTournamentChannelURL() {
		return tournamentChannelURL;
	}

	public void setTournamentChannelURL(String tournamentChannelURL) {
		this.tournamentChannelURL = tournamentChannelURL;
	}

	public List<GameVo> getGames() {
		return Games;
	}

	public void setGames(List<GameVo> games) {
		Games = games;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("tournamentID", getTournamentID())
		.append("tournamentName", getTournamentName())
		.append("tournamentShortName", getTournamentShortName())
		.append("tournamentSiteURL", getTournamentSiteURL())
		.append("tournamentStartDate", getTournamentStartDate())
		.append("tournamentEndDate", getTournamentEndDate())
		.append("tournamentDescription", getTournamentDescription())
		.append("tournamentChannelURL", getTournamentChannelURL())
		.append("tournamentCompetitionSystem", getTournamentCompetitionSystem())
		.build();
	}

	public String getTournamentCompetitionSystem() {
		return tournamentCompetitionSystem;
	}

	public void setTournamentCompetitionSystem(String tournamentCompetitionSystem) {
		this.tournamentCompetitionSystem = tournamentCompetitionSystem;
	}
}
