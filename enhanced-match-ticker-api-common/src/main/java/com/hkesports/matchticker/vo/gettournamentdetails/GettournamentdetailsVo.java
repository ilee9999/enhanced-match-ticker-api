package com.hkesports.matchticker.vo.gettournamentdetails;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.utils.Const;
import com.hkesports.matchticker.vo.BasicVo;

public class GettournamentdetailsVo extends BasicVo {

	private static final long serialVersionUID = 1L;

	private Long tournamentID; // tournament.id
	private String tournamentName; // tournament.tournamentName
	private String tournamentShortName; // tournament.tournamentShortName
	private String tournamentSiteURL; // tournament.tournamentSiteUrl
	private Date tournamentStartDate; // tournament.tournamentFromDate
	private Date tournamentEndDate; // tournament.tournamentToDate

	private String tournamentDescription;
	private String tournamentChannelURL;
	private String tournamentCompetitionSystem;
	private String tournamentPrizePool;
	private String tournamentDetails;
//	private String tournamentImage;
	private String tournamentIconSmall;
	private String tournamentIconLarge;
	private String tournamentIconHuge;
	private Boolean team;

	private List<TournamentContestantsVo> contestants;
	private List<ScheduleVo> schedules;
	
	public GettournamentdetailsVo() {
		
	}
	
	public GettournamentdetailsVo(StatusCodeEnum statusCode) {
		super(statusCode);
	}
	
	public GettournamentdetailsVo(Long tournamentID, String tournamentName, String tournamentShortName,
			String tournamentSiteURL, Date tournamentStartDate, Date tournamentEndDate, String tournamentDescription,
			String tournamentChannelURL, String tournamentCompetitionSystem, String tournamentPrizePool,
			String tournamentDetails, String tournamentIconSmall, String tournamentIconLarge, String tournamentIconHuge, Boolean team) {
		super();
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.tournamentShortName = tournamentShortName;
		this.tournamentSiteURL = tournamentSiteURL;
		this.tournamentStartDate = tournamentStartDate;
		this.tournamentEndDate = tournamentEndDate;
		this.tournamentDescription = tournamentDescription;
		this.tournamentChannelURL = tournamentChannelURL;
		this.tournamentCompetitionSystem = tournamentCompetitionSystem;
		this.tournamentPrizePool = tournamentPrizePool;
		this.tournamentDetails = tournamentDetails;
//		this.tournamentImage = tournamentImage;
		this.tournamentIconSmall = tournamentIconSmall;
		this.tournamentIconLarge = tournamentIconLarge;
		this.tournamentIconHuge = tournamentIconHuge;
		this.team = team;
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

	public String getTournamentSiteURL() {
		return tournamentSiteURL;
	}

	public void setTournamentSiteURL(String tournamentSiteURL) {
		this.tournamentSiteURL = tournamentSiteURL;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
	public Date getTournamentStartDate() {
		return tournamentStartDate;
	}

	public void setTournamentStartDate(Date tournamentStartDate) {
		this.tournamentStartDate = tournamentStartDate;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT)
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

	public void setTournamentChannelURL(String tournamentChannelUrl) {
		this.tournamentChannelURL = tournamentChannelUrl;
	}

	public String getTournamentCompetitionSystem() {
		return tournamentCompetitionSystem;
	}

	public void setTournamentCompetitionSystem(String tournamentCompetitionSystem) {
		this.tournamentCompetitionSystem = tournamentCompetitionSystem;
	}

	public String getTournamentPrizePool() {
		return tournamentPrizePool;
	}

	public void setTournamentPrizePool(String tournamentPrizePool) {
		this.tournamentPrizePool = tournamentPrizePool;
	}

	public String getTournamentDetails() {
		return tournamentDetails;
	}

	public void setTournamentDetails(String tournamentDetails) {
		this.tournamentDetails = tournamentDetails;
	}

	public Boolean getTeam() {
		return team;
	}

	public void setTeam(Boolean team) {
		this.team = team;
	}

	@JsonProperty(value="Contestants")
	public List<TournamentContestantsVo> getContestants() {
		return contestants;
	}

	public void setContestants(List<TournamentContestantsVo> contestants) {
		this.contestants = contestants;
	}

	@JsonProperty(value="Schedules")
	public List<ScheduleVo> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<ScheduleVo> schedule) {
		this.schedules = schedule;
	}
	public String getTournamentIconSmall() {
		return tournamentIconSmall;
	}
	public void setTournamentIconSmall(String tournamentIconSmall) {
		this.tournamentIconSmall = tournamentIconSmall;
	}
	public String getTournamentIconLarge() {
		return tournamentIconLarge;
	}
	public void setTournamentIconLarge(String tournamentIconLarge) {
		this.tournamentIconLarge = tournamentIconLarge;
	}
	public String getTournamentIconHuge() {
		return tournamentIconHuge;
	}
	public void setTournamentIconHuge(String tournamentIconHuge) {
		this.tournamentIconHuge = tournamentIconHuge;
	}
}
