package com.hkesports.matchticker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.exception.SecurityCodeException;
import com.hkesports.matchticker.model.Admin;
import com.hkesports.matchticker.model.basic.UserHa;
import com.hkesports.matchticker.repository.AdminDao;
import com.hkesports.matchticker.repository.GameDao;
import com.hkesports.matchticker.repository.LeagueDao;
import com.hkesports.matchticker.repository.ScheduleDao;
import com.hkesports.matchticker.repository.TeamDao;
import com.hkesports.matchticker.repository.TournamentDao;
import com.hkesports.matchticker.service.TournamentService;
import com.hkesports.matchticker.utils.Const;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.getknockoutrtournamenttable.GetknockoutrtournamenttableVo;
import com.hkesports.matchticker.vo.getleagueseasonlist.GetleagueseasonlistVo;
import com.hkesports.matchticker.vo.getleagueseasonlist.LeagueSeasonVo;
import com.hkesports.matchticker.vo.gettournamentdetails.GettournamentdetailsVo;
import com.hkesports.matchticker.vo.gettournamentdetails.ScheduleVo;
import com.hkesports.matchticker.vo.gettournamentlist.GettournamentlistVo;
import com.hkesports.matchticker.vo.gettournamentlist.TournamentVo;

/**
 * @author manboyu
 *
 */
@Service("tournamentService")
public class TournamentServiceImpl extends BasicServiceImpl implements TournamentService {

	@Resource(name = "tournamentDao")
	private TournamentDao tournamentDao;
	@Resource(name = "gameDao")
	private GameDao gameDao;
	@Resource(name = "teamDao")
	private TeamDao teamDao;
	@Resource(name = "leagueDao")
	private LeagueDao leagueDao;
	@Resource
	private ScheduleDao scheduleDao;
	@Resource(name = "adminDao")
	private AdminDao adminDao;
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "getTournamentList", key = "{#root.methodName, #past + '-' + #requestVo.gameID + '-' + #requestVo.pageNumber + '-' + #requestVo.pageSize}")
	public GettournamentlistVo getTournamentList(boolean past, RequestVo requestVo) {
		GettournamentlistVo result = new GettournamentlistVo();
		List<TournamentVo> tournaments = tournamentDao.getTournamentlistByPast(past, requestVo);
		result.setTournament(tournaments);
		if(CollectionUtils.isEmpty(tournaments)) {
			return result;
		}
		for(TournamentVo vo : tournaments) {
			if(vo.getTournamentID() != null) {
				vo.setGames(gameDao.findGamesByTournamentID(vo.getTournamentID()));
			}
		}
		return result;
	}
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "getKnockoutrTournamentTable", key = "{#root.methodName, #requestVo.gameID + '-' + #requestVo.tournamentID + '-' + #requestVo.pageNumber + '-' + #requestVo.pageSize}")
	public GetknockoutrtournamenttableVo getKnockoutrTournamentTable(RequestVo requestVo) {
		GetknockoutrtournamenttableVo result = new GetknockoutrtournamenttableVo();
		List<com.hkesports.matchticker.vo.getknockoutrtournamenttable.TournamentVo> tournaments = tournamentDao.getTournamentlist(requestVo);
		result.setTournaments(tournaments);
		if(CollectionUtils.isEmpty(tournaments)) {
			return result;
		}
		for(com.hkesports.matchticker.vo.getknockoutrtournamenttable.TournamentVo vo : tournaments) {
			if(vo.getTournamentID() == null) {
				continue;
			}
			if(vo.getTeam()) {
				vo.setContestants(teamDao.findAllKnockoutrTournamentTeamVoByTournamentId(vo.getTournamentID()));
			} else {
				//TODO
			}
		}
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "getLeagueSeasonList", key = "{#root.methodName, #gameID}")
	public GetleagueseasonlistVo getLeagueSeasonList(Long gameID) {
		GetleagueseasonlistVo result = new GetleagueseasonlistVo();
		List<LeagueSeasonVo> leagues = leagueDao.findLeaguesByGameId(gameID);
		if(CollectionUtils.isEmpty(leagues)) {
			return new GetleagueseasonlistVo();
		}
		String iconRootPath = getRootIconPath(Const.ADMIN_KEY_ICON_PATH_TOURNAMENT);
		result.setLeagueSeasons(leagues);
		for(LeagueSeasonVo vo : leagues) {
			if(vo.getId() != null) {
				if(StringUtils.isNotBlank(iconRootPath)) {
					vo.setLeagueIconSmallURL(StringUtils.isNotBlank(vo.getLeagueIconSmallURL()) ? iconRootPath + vo.getId() + Const.FILE_SIZE_NAME_SMALL + vo.getLeagueIconSmallURL() : null);
				}
				vo.setTournaments(tournamentDao.findTournamentsByLeagueId(vo.getId()));
			}
		}
		return result;
	}
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "getTournamentDetails", keyGenerator = "keyGenerator")
	public GettournamentdetailsVo getTournamentDetails(RequestVo requestVo) {
		UserHa userHa = null;
		if(StringUtils.isNotBlank(requestVo.getRegistrationID())) {
			try {
				userHa = getUserHa(requestVo.getRegistrationID(), requestVo.getSecretKey());
			} catch (SecurityCodeException e) {
				return new GettournamentdetailsVo(e.getStatusCode());
			}
		}
		GettournamentdetailsVo vo = tournamentDao.findTournamentDetailsVoById(requestVo.getTournamentID());
		if(vo == null) {
			return new GettournamentdetailsVo();
		}
		String iconRootPath = getRootIconPath(Const.ADMIN_KEY_ICON_PATH_TOURNAMENT);
		if(StringUtils.isNotBlank(iconRootPath)) {
			vo.setTournamentIconSmall(StringUtils.isNotBlank(vo.getTournamentIconSmall()) ? iconRootPath + vo.getTournamentID() + Const.FILE_SIZE_NAME_SMALL + vo.getTournamentIconSmall() : null);
			vo.setTournamentIconLarge(StringUtils.isNotBlank(vo.getTournamentIconLarge()) ? iconRootPath + vo.getTournamentID() + Const.FILE_SIZE_NAME_LARGE + vo.getTournamentIconLarge() : null);
			vo.setTournamentIconHuge(StringUtils.isNotBlank(vo.getTournamentIconHuge()) ? iconRootPath + vo.getTournamentID() + Const.FILE_SIZE_NAME_HUGE + vo.getTournamentIconHuge() : null);
		}
		vo.setContestants(teamDao.findAllTournamentDetailsTeamVoByTournamentId(requestVo.getTournamentID(), userHa));
		List<ScheduleVo> scheduleList = scheduleDao.findAllScheduleVoByTournamentId(requestVo.getTournamentID(), userHa);
		if(CollectionUtils.isEmpty(scheduleList)) {
			return vo;
		}
		for(ScheduleVo scheduleVo : scheduleList) {
			if(scheduleVo.getTeam()) {
				scheduleVo.setContestants(teamDao.findAllTeamVoByMatchIdOrUser(scheduleVo.getMatchID(), userHa));
			} else {
				// TODO
			}
		}
		vo.setSchedules(scheduleList);
		return vo;
	}
	
	private String getRootIconPath(String type) {
		Admin iconDomain = adminDao.findByKey(Const.ADMIN_KEY_ICON_DOMAIN);
		Admin iconPath = adminDao.findByKey(type);
		if(iconDomain != null && iconPath != null) {
			return iconDomain.getValue() + iconPath.getValue();
		}
		return StringUtils.EMPTY;
	}
}
