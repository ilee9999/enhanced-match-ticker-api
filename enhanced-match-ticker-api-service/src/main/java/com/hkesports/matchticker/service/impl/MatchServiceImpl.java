package com.hkesports.matchticker.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.enums.GameTypeEnum;
import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.model.Schedule;
import com.hkesports.matchticker.model.SupportTeam;
import com.hkesports.matchticker.repository.DataDao;
import com.hkesports.matchticker.repository.GameDao;
import com.hkesports.matchticker.repository.GamePicksBansDao;
import com.hkesports.matchticker.repository.LiveStreamsDao;
import com.hkesports.matchticker.repository.ScheduleDao;
import com.hkesports.matchticker.repository.ScheduleGameDetailDao;
import com.hkesports.matchticker.repository.ScheduleGamePlayerDetailDao;
import com.hkesports.matchticker.repository.SupportTeamDao;
import com.hkesports.matchticker.repository.TeamDao;
import com.hkesports.matchticker.service.MatchService;
import com.hkesports.matchticker.vo.BasicTeamVo;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.getleaguetable.GetleaguetableVo;
import com.hkesports.matchticker.vo.getmatchstatistics.GameTeamVo;
import com.hkesports.matchticker.vo.getmatchstatistics.GameVo;
import com.hkesports.matchticker.vo.getmatchstatistics.GetmatchstatisticsVo;
import com.hkesports.matchticker.vo.getmatchstatistics.TeamVo;
import com.hkesports.matchticker.vo.getranking.GetrankingVo;
import com.hkesports.matchticker.vo.getresult.GetresultVo;
import com.hkesports.matchticker.vo.getschedule.GetscheduleVo;
import com.hkesports.matchticker.vo.getschedule.ResultScheduleVo;
import com.hkesports.matchticker.vo.getschedule.ResultVo;
import com.hkesports.matchticker.vo.matchsupport.MatchsupportVo;
import com.hkesports.matchticker.vo.supportteam.SupportteamVo;


@Transactional(readOnly = true)
@Service("matchService")
public class MatchServiceImpl implements MatchService {
	
	@Resource(name = "scheduleDao")
	private ScheduleDao scheduleDao;
	@Resource(name = "scheduleGameDetailDao")
	private ScheduleGameDetailDao scheduleGameDetailDao;
	@Resource(name = "dataDao")
	private DataDao dataDao;
	@Resource(name = "teamDao")
	private TeamDao teamDao;
	@Resource(name = "gameDao")
	private GameDao gameDao;
	@Resource(name = "liveStreamsDao")
	private LiveStreamsDao liveStreamsDao;
	@Resource(name = "gamePicksBansDao")
	private GamePicksBansDao gamePicksBansDao;
	@Resource
	private ScheduleGamePlayerDetailDao scheduleGamePlayerDetailDao;
	@Resource
	private SupportTeamDao supportTeamDao;
	
	@Override
	@Cacheable(value = "matchSupport", key = "{#root.methodName, #matchId}")
	public MatchsupportVo matchSupport(Long matchId) {
		MatchsupportVo result = scheduleDao.matchSupport(matchId);
		List<BasicTeamVo> teams = teamDao.getAllTeamVoByMatchId(matchId, BasicTeamVo.class);
		result.setTeams(teams);
		return result;
	}
	
	@Override
	@Cacheable(value = "matchStatistics", key = "{#root.methodName, #matchId}")
	public GetmatchstatisticsVo getMatchStatistics(Long matchId) {
		GetmatchstatisticsVo matche = scheduleDao.getMatchStatistics(GameTypeEnum.LOL, matchId);
		matche.setGames(getGameListByMatchId(GameTypeEnum.LOL, matchId));
		matche.setTeams(teamDao.getAllTeamVoByMatchId(matchId, TeamVo.class));
		return matche;
	}
	
	public List<GameVo> getGameListByMatchId(GameTypeEnum gameType, Long matchId) {
		List<GameVo> games = gameDao.findGamesByMatchId(gameType, matchId);
		if(!CollectionUtils.isEmpty(games)) {
			for(GameVo game:games) {
				game.setVods(liveStreamsDao.findVodsByGameId(game.getGameID()));
				game.setTeams(getGameTeamsByGameId(gameType, game.getGameID()));
			}
		}
		return games;
	}
	
	public List<GameTeamVo> getGameTeamsByGameId(GameTypeEnum gameType, Long gameId) {
		List<GameTeamVo> teams = scheduleGameDetailDao.findGameTeamsByGameId(gameId);
		if(!CollectionUtils.isEmpty(teams)) {
			for(GameTeamVo team:teams) {
				team.setBans(gamePicksBansDao.findGameTeamBanByGameAndTeam(gameType, gameId, team.getID()));
				team.setPlayers(scheduleGamePlayerDetailDao.findGameTeamPlayerByGameDetail(team.getScheduleGameDetailId()));
			}
		}
		return teams;
	}
	
	@Override
	@Cacheable(value = "getSchedule", key = "{#root.methodName, #requestVo.option + '-' + #requestVo.pageNumber + '-' + #requestVo.pageSize}")
	public GetscheduleVo getSchedule(RequestVo requestVo) {
		GetscheduleVo scheduleVo = new GetscheduleVo();
		scheduleVo.setResults(new ArrayList<ResultVo>(1));
		List<ResultScheduleVo> schedules = scheduleDao.getSchedule(requestVo);
		if(!CollectionUtils.isEmpty(schedules)) {
			for(ResultScheduleVo vo:schedules) {
				vo.setTeams(teamDao.getAllTeamVoByMatchId(vo.getMatchID(), com.hkesports.matchticker.vo.getschedule.TeamVo.class));
			}
		}
		ResultVo resultVo = new ResultVo();
		resultVo.setSchedules(schedules);
		scheduleVo.getResults().add(resultVo);
		return scheduleVo;
	}

	@Override
	@Cacheable(value = "getRanking", key = "{#root.methodName, #requestVo.gameID + '-' + #requestVo.tournamentID + '-' + #requestVo.pageNumber + '-' + #requestVo.pageSize}")
	public GetrankingVo getRanking(RequestVo requestVo) {
		GetrankingVo result = new GetrankingVo();
		List<com.hkesports.matchticker.vo.getranking.GameVo> games = gameDao.getRankingGameVo(requestVo);
		if(!CollectionUtils.isEmpty(games)) {
			for(com.hkesports.matchticker.vo.getranking.GameVo vo : games) {
				if(vo.getMatchID() != null) {
					vo.setTeams(teamDao.getRankingTeamVo(requestVo.getGameID(), vo.getMatchID()));
				}
			}
		}
		result.setRankings(games);
		return result;
	}
	
	@Override
	@Cacheable(value = "getResult", key = "{#root.methodName, #requestVo.option + '-' + #requestVo.pageNumber + '-' + #requestVo.pageSize}")
	public GetresultVo getResult(RequestVo requestVo) {
		GetresultVo resultVo = new GetresultVo();
		List<com.hkesports.matchticker.vo.getresult.ResultVo> results = scheduleDao.getResult(requestVo);
		if(!CollectionUtils.isEmpty(results)) {
			for(com.hkesports.matchticker.vo.getresult.ResultVo vo : results) {
				vo.setTeams(teamDao.getAllTeamVoByMatchId(vo.getMatchID(), com.hkesports.matchticker.vo.getresult.TeamVo.class));
			}
		}
		resultVo.setResults(results);
		return resultVo;
	}

	@Override
	@Cacheable(value = "getLeaguetable", key = "{#root.methodName, #requestVo.gameID + '-' + #requestVo.tournamentID + '-' + #requestVo.pageNumber + '-' + #requestVo.pageSize + '-' + #requestVo.pageSort}")
	public GetleaguetableVo getLeaguetable(RequestVo requestVo) {
		GetleaguetableVo resultVo = new GetleaguetableVo();
		List<com.hkesports.matchticker.vo.getleaguetable.TournamentVo> tournaments = scheduleDao.getLeaguetable(requestVo);
		if(!CollectionUtils.isEmpty(tournaments)) {
			for(com.hkesports.matchticker.vo.getleaguetable.TournamentVo vo : tournaments) {
				vo.setTeams(teamDao.getLeaguetableTeamVo(requestVo.getGameID(), vo.getMatchID()));
			}
		}
		resultVo.setTournaments(tournaments);
		return resultVo;
	}
	
	@Override
	@Transactional
	public SupportteamVo saveSupportTeam(Long matchId, Long teamId, String facebookId) {
		if(matchId==null || teamId==null || StringUtils.isBlank(facebookId)) {
			return new SupportteamVo(StatusCodeEnum.STATUS_11.getValue());
		}
		SupportTeam supportTeam = supportTeamDao.findByUserIdAndMatchId(facebookId, matchId);
		if(supportTeam == null) {
			supportTeam = new SupportTeam();
			supportTeam.setMatchId(matchId);
			supportTeam.setUserId(facebookId);
		}
		if(supportTeam.getTeamId()==null || !supportTeam.getTeamId().equals(teamId)) {
			supportTeam.setTeamId(teamId);
			supportTeamDao.save(supportTeam);
		} else {
			Schedule schedule = scheduleDao.findOne(matchId);
			if(schedule==null || (!teamId.equals(schedule.getTeamAId()) && !teamId.equals(schedule.getTeamBId()))) {
				return new SupportteamVo(StatusCodeEnum.STATUS_10.getValue());
			}
			return new SupportteamVo(StatusCodeEnum.STATUS_12.getValue(), schedule.getaSideSupportCount(), schedule.getbSideSupportCount());
		}
		return new SupportteamVo(StatusCodeEnum.STATUS_0.getValue());
	}
	
	@Override
	@Transactional
	public SupportteamVo updateSupportCount(Long matchId) {
		if(matchId==null) {
			return new SupportteamVo(StatusCodeEnum.STATUS_11.getValue());
		}
		int result = scheduleDao.updateSupportCount(matchId);
		if(result < 1) {
			return new SupportteamVo(StatusCodeEnum.STATUS_10.getValue());
		}
		Schedule schedule = scheduleDao.findOne(matchId);
		if(schedule==null) {
			return new SupportteamVo(StatusCodeEnum.STATUS_10.getValue());
		}
		return new SupportteamVo(StatusCodeEnum.STATUS_0.getValue(), schedule.getaSideSupportCount(), schedule.getbSideSupportCount());
	}
}
