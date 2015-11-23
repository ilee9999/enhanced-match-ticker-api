package com.hkesports.matchticker.vo.getleagueseasonlist;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author manboyu
 *
 */
public class TournamentVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tournamentID;
	private String tournamentName;
	private String tournamentShortName;
	private String tournamentCompetitionSystem;
	
	public TournamentVo() {
		
	}

	public TournamentVo(Long tournamentID, String tournamentName,
			String tournamentShortName, String tournamentCompetitionSystem) {
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.tournamentShortName = tournamentShortName;
		this.tournamentCompetitionSystem = tournamentCompetitionSystem;
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

	public String getTournamentShortName() {
		return tournamentShortName;
	}

	public void setTournamentShortName(String tournamentShortName) {
		this.tournamentShortName = tournamentShortName;
	}

	public String getTournamentCompetitionSystem() {
		return tournamentCompetitionSystem;
	}

	public void setTournamentCompetitionSystem(
			String tournamentCompetitionSystem) {
		this.tournamentCompetitionSystem = tournamentCompetitionSystem;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("tournamentID", getTournamentID())
		.append("tournamentName", getTournamentName())
		.append("tournamentShortName", getTournamentShortName())
		.append("tournamentCompetitionSystem", getTournamentCompetitionSystem())
		.build();
	}
}
