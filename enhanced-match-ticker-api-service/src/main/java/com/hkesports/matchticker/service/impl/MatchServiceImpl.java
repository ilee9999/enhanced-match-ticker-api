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
import com.hkesports.matchticker.exception.SecurityCodeException;
import com.hkesports.matchticker.model.Schedule;
import com.hkesports.matchticker.model.SupportTeam;
import com.hkesports.matchticker.model.basic.UserHa;
import com.hkesports.matchticker.repository.DataDao;
import com.hkesports.matchticker.repository.GameDao;
import com.hkesports.matchticker.repository.GamePicksBansDao;
import com.hkesports.matchticker.repository.LiveStreamsDao;
import com.hkesports.matchticker.repository.ScheduleDao;
import com.hkesports.matchticker.repository.ScheduleGameDetailDao;
import com.hkesports.matchticker.repository.ScheduleGamePlayerDetailDao;
import com.hkesports.matchticker.repository.SubscriptionSettingDao;
import com.hkesports.matchticker.repository.SupportTeamDao;
import com.hkesports.matchticker.repository.TeamDao;
import com.hkesports.matchticker.service.MatchService;
import com.hkesports.matchticker.vo.RequestVo;
import com.hkesports.matchticker.vo.getcontestantperformance.ContestantsMasterVo;
import com.hkesports.matchticker.vo.getcontestantperformance.GetcontestantperformanceVo;
import com.hkesports.matchticker.vo.getleaguetable.GetleaguetableVo;
import com.hkesports.matchticker.vo.getmatchconteststatus.GetmatchconteststatusVo;
import com.hkesports.matchticker.vo.getmatchstatistics.GameTeamVo;
import com.hkesports.matchticker.vo.getmatchstatistics.GameVo;
import com.hkesports.matchticker.vo.getmatchstatistics.GetmatchstatisticsVo;
import com.hkesports.matchticker.vo.getmatchstatistics.RecentPerformanceVo;
import com.hkesports.matchticker.vo.getmatchstatistics.TeamVo;
import com.hkesports.matchticker.vo.getranking.GetrankingVo;
import com.hkesports.matchticker.vo.getresult.GetresultVo;
import com.hkesports.matchticker.vo.getschedule.GetscheduleVo;
import com.hkesports.matchticker.vo.getschedule.ResultScheduleVo;
import com.hkesports.matchticker.vo.getschedule.ResultVo;
import com.hkesports.matchticker.vo.matchsupport.ContestantsVo;
import com.hkesports.matchticker.vo.matchsupport.MatchsupportVo;
import com.hkesports.matchticker.vo.supportteam.SupportteamVo;


@Transactional(readOnly = true)
@Service("matchService")
public class MatchServiceImpl extends BasicServiceImpl implements MatchService {
	
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
	@Resource
	private SubscriptionSettingDao subscriptionSettingDao;
	
	@Override
	@Cacheable(value = "matchSupport", key = "{#root.methodName, #matchId}")
	public MatchsupportVo matchSupport(Long matchId) {
		MatchsupportVo result = scheduleDao.matchSupport(matchId);
		if(result == null) {
			return new MatchsupportVo();
		}
		if(result.getTeam()) {
			result.setContestants(teamDao.findAllTeamVoByMatchId(matchId, ContestantsVo.class));
		}
		return result;
	}
	
	@Override
	@Cacheable(value = "lolmatchStatistics", key = "{#root.methodName, #matchId}")
	public GetmatchstatisticsVo getlolMatchStatistics(Long matchId) {
		GetmatchstatisticsVo match = scheduleDao.findMatchStatistics(GameTypeEnum.LOL, matchId);
		if(match == null) {
			return new GetmatchstatisticsVo();
		}
		match.setGames(getLOLGameListByMatchId(matchId));
		List<TeamVo> teamList = teamDao.findAllTeamVoByMatchId(matchId, TeamVo.class);
		match.setTeams(teamList);
		if(CollectionUtils.isEmpty(teamList)) {
			return match;
		}
		for(TeamVo team:teamList) {
			team.setLastEncounter(scheduleDao.findAllLastEncounter(com.hkesports.matchticker.vo.getmatchstatistics.LastEncounterVo.class, matchId, team.getID()));
			List<RecentPerformanceVo> recentPerformances = scheduleDao.findAllRecentPerformance(RecentPerformanceVo.class, matchId, team.getID());
			if(CollectionUtils.isEmpty(recentPerformances)) {
				continue;
			}
			for(RecentPerformanceVo rpVo:recentPerformances) {
				rpVo.setTeams(teamDao.findAllTeamVoByMatchId(rpVo.getMatchID(), TeamVo.class));
			}
			team.setRecentPerformance(recentPerformances);
		}
		return match;
	}
	
	@Override
	@Cacheable(value = "dota2matchStatistics", key = "{#root.methodName, #matchId}")
	public GetmatchstatisticsVo getdota2MatchStatistics(Long matchId) {
		GetmatchstatisticsVo match = scheduleDao.findMatchStatistics(GameTypeEnum.DOTA2, matchId);
		if(match == null) {
			return new GetmatchstatisticsVo();
		}
		match.setGames(getDota2GameListByMatchId(matchId));
		List<TeamVo> teamList = teamDao.findAllTeamVoByMatchId(matchId, TeamVo.class);
		match.setTeams(teamList);
		if(CollectionUtils.isEmpty(teamList)) {
			return match;
		}
		for(TeamVo team:teamList) {
			team.setLastEncounter(scheduleDao.findAllLastEncounter(com.hkesports.matchticker.vo.getmatchstatistics.LastEncounterVo.class, matchId, team.getID()));
			List<RecentPerformanceVo> recentPerformances = scheduleDao.findAllRecentPerformance(RecentPerformanceVo.class, matchId, team.getID());
			if(CollectionUtils.isEmpty(recentPerformances)) {
				continue;
			}
			for(RecentPerformanceVo rpVo:recentPerformances) {
				rpVo.setTeams(teamDao.findAllTeamVoByMatchId(rpVo.getMatchID(), TeamVo.class));
			}
			team.setRecentPerformance(recentPerformances);
		}
		return match;
	}
	
	public List<GameVo> getDota2GameListByMatchId(Long matchId) {
		List<GameVo> games = scheduleDao.findAllDota2GamesByMatchId(matchId);
		if(CollectionUtils.isEmpty(games)) {
			return games;
		}
		for(GameVo game:games) {
			game.setVods(liveStreamsDao.findVodsByGameId(game.getGameID()));
			game.setTeams(getGameTeamsByGameId(game.getGameID()));
		}
		return games;
	}

	public List<GameVo> getLOLGameListByMatchId(Long matchId) {
		List<GameVo> games = scheduleDao.findAllLOLGamesByMatchId(matchId);
		if(CollectionUtils.isEmpty(games)) {
			return games;
		}
		for(GameVo game:games) {
			game.setVods(liveStreamsDao.findVodsByGameId(game.getGameID()));
			game.setTeams(getGameTeamsByGameId(game.getGameID()));
		}
		return games;
	}
	
	public List<GameTeamVo> getGameTeamsByGameId(Long gameId) {
		List<GameTeamVo> teams = scheduleGameDetailDao.findGameTeamsByGameId(gameId);
		if(CollectionUtils.isEmpty(teams)) {
			return teams;
		}
		for(GameTeamVo team:teams) {
			team.setBans(gamePicksBansDao.findGameTeamBanByGameAndTeam(gameId, team.getID()));
			team.setPlayers(scheduleGamePlayerDetailDao.findGameTeamPlayerByGameDetail(team.getScheduleGameDetailId()));
		}
		return teams;
	}
	
	@Override
	@Cacheable(value = "getSchedule", keyGenerator = "keyGenerator")
	public GetscheduleVo getSchedule(RequestVo requestVo) {
		UserHa userHa = null;
		if(StringUtils.isNotBlank(requestVo.getRegistrationID())) {
			try {
				userHa = getUserHa(requestVo.getRegistrationID(), requestVo.getSecretKey());
			} catch (SecurityCodeException e) {
				return new GetscheduleVo(e.getStatusCode());
			}
		}
		GetscheduleVo scheduleVo = new GetscheduleVo();
		scheduleVo.setResults(new ArrayList<ResultVo>(1));
		List<ResultScheduleVo> schedules = scheduleDao.findAllSchedule(requestVo, userHa);
		ResultVo resultVo = new ResultVo();
		resultVo.setSchedules(schedules);
		scheduleVo.getResults().add(resultVo);
		if(CollectionUtils.isEmpty(schedules)) {
			return scheduleVo;
		}
		for(ResultScheduleVo vo : schedules) {
			if(vo.getTeam()) {
				vo.setContestants(teamDao.findAllTeamVoByMatchId(vo.getMatchID(), com.hkesports.matchticker.vo.getschedule.ContestantsVo.class));
			} else {
				//TODO
			}
		}
		return scheduleVo;
	}

	@Override
	@Cacheable(value = "getResult", keyGenerator = "keyGenerator")
	public GetresultVo getResult(RequestVo requestVo) {
		GetresultVo resultVo = new GetresultVo();
		List<com.hkesports.matchticker.vo.getresult.ResultVo> results = scheduleDao.findAllResult(requestVo);
		resultVo.setResults(results);
		if(CollectionUtils.isEmpty(results)) {
			return resultVo;
		}
		for(com.hkesports.matchticker.vo.getresult.ResultVo vo : results) {
			if(vo.getTeam()) {
				vo.setContestants(teamDao.findAllTeamVoByMatchId(vo.getMatchID(), com.hkesports.matchticker.vo.getresult.ContestantsVo.class));
			} else {
				//TODO
			}
		}
		return resultVo;
	}
	
	@Override
	@Cacheable(value = "getLeaguetable", keyGenerator = "keyGenerator")
	public GetleaguetableVo getCircularTournamentTable(RequestVo requestVo) {
		GetleaguetableVo resultVo = new GetleaguetableVo();
		List<com.hkesports.matchticker.vo.getleaguetable.TournamentVo> tournaments = scheduleDao.findAllLeaguetable(requestVo);
		resultVo.setTournaments(tournaments);
		if(CollectionUtils.isEmpty(tournaments)) {
			return resultVo;
		}
		for(com.hkesports.matchticker.vo.getleaguetable.TournamentVo vo : tournaments) {
			if(vo.getTeam()) {
				vo.setContestants(teamDao.findAllLeaguetableTeamVoByTournamentId(vo.getTournamentID()));
			} else {
				//TODO
			}
		}
		return resultVo;
	}
	
	@Override
	@Cacheable(value = "getRanking", keyGenerator = "keyGenerator")
	public GetrankingVo getRanking(RequestVo requestVo) {
		GetrankingVo result = new GetrankingVo();
		List<com.hkesports.matchticker.vo.getranking.GameVo> games = gameDao.findRankingGameVo(requestVo);
		result.setRankings(games);
		if(CollectionUtils.isEmpty(games)) {
			return result;
		}
		for(com.hkesports.matchticker.vo.getranking.GameVo vo : games) {
			if(vo.getTeam()) {
				vo.setContestants(teamDao.findAllRankingTeamVo(vo.getGameID(), requestVo.getTournamentID()));
			} else {
				//TODO
			}
		}
		return result;
	}
	
	@Override
	@Transactional
	public SupportteamVo saveSupportTeam(Long matchId, Long contestantID, String facebookId) {
		try {
			if(matchId==null || contestantID==null || StringUtils.isBlank(facebookId)) {
				return new SupportteamVo(StatusCodeEnum.STATUS_420.getValue());
			}
			Schedule schedule = scheduleDao.findOne(matchId);
			if(schedule==null || (!contestantID.equals(schedule.getTeamAId()) && !contestantID.equals(schedule.getTeamBId()))) {
				return new SupportteamVo(StatusCodeEnum.STATUS_10.getValue());
			}
			int aTeamCount = 0;
			int bTeamCount = 0;
			int count = supportTeamDao.updateByUserIdAndMatchId(facebookId, matchId, contestantID);
			if(count < 1) {
				SupportTeam supportTeam = supportTeamDao.findByUserIdAndMatchId(facebookId, matchId);
				if(supportTeam != null) {
					return new SupportteamVo(StatusCodeEnum.STATUS_503.getValue(), schedule.getaSideSupportCount(), schedule.getbSideSupportCount());
				}
				supportTeam = new SupportTeam();
				supportTeam.setMatchId(matchId);
				supportTeam.setUserId(facebookId);
				supportTeam.setTeamId(contestantID);
				supportTeamDao.save(supportTeam);
				if(contestantID.equals(schedule.getTeamAId())) {
					aTeamCount++;
				} else if(contestantID.equals(schedule.getTeamBId())) {
					bTeamCount++;
				}
			} else {
				if(contestantID.equals(schedule.getTeamAId())) {
					aTeamCount++;
					bTeamCount--;
				} else if(contestantID.equals(schedule.getTeamBId())) {
					aTeamCount--;
					bTeamCount++;
				}
			}
			if(aTeamCount!=0 || bTeamCount!=0) {
				scheduleDao.updateSupportCount(matchId, aTeamCount, bTeamCount);
			}
			return new SupportteamVo(StatusCodeEnum.STATUS_0.getValue(), schedule.getaSideSupportCount() + aTeamCount, schedule.getbSideSupportCount() + bTeamCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SupportteamVo(StatusCodeEnum.STATUS_10.getValue());
	}
	
	@Override
	@Cacheable(value = "getContestantPerformance", key = "{#root.methodName, #matchId}")
	public GetcontestantperformanceVo getContestantPerformance(Long matchId) {
		Schedule schedule = scheduleDao.findOne(matchId);
		GetcontestantperformanceVo vo = new GetcontestantperformanceVo();
		vo.setMaxGames(schedule.getMaxGames());
		
		List<ContestantsMasterVo> list = new ArrayList<>();
		if(schedule.getGame().getTeam()) {
			if(schedule.getTeamAId()!=null) {
				ContestantsMasterVo masterVo = getContestantsMasterVo(matchId, schedule.getTeamAId());
				masterVo.setContestantNumber(0);
				list.add(masterVo);
			} 
			if(schedule.getTeamBId()!=null) {
				ContestantsMasterVo masterVo = getContestantsMasterVo(matchId, schedule.getTeamBId());
				masterVo.setContestantNumber(1);
				list.add(masterVo);
			}
		} else {
			//TODO
		}
		vo.setContestants(list);
		return vo;
	}
	
	private ContestantsMasterVo getContestantsMasterVo(Long matchId, Long teamId) {
		ContestantsMasterVo masterVo = new ContestantsMasterVo();
		masterVo.setID(teamId);
		masterVo.setLastEncounter(scheduleDao.findAllLastEncounter(com.hkesports.matchticker.vo.getcontestantperformance.LastEncounterVo.class, matchId, teamId));
		List<com.hkesports.matchticker.vo.getcontestantperformance.RecentPerformanceVo> recentPerformances = scheduleDao.findAllRecentPerformance(com.hkesports.matchticker.vo.getcontestantperformance.RecentPerformanceVo.class, matchId, teamId);
		if(CollectionUtils.isEmpty(recentPerformances)) {
			return masterVo;
		}
		for(com.hkesports.matchticker.vo.getcontestantperformance.RecentPerformanceVo rpVo:recentPerformances) {
			rpVo.setContestants(teamDao.findAllTeamVoByMatchId(rpVo.getMatchID(), com.hkesports.matchticker.vo.getcontestantperformance.ContestantsVo.class));
		}
		masterVo.setRecentPerformance(recentPerformances);
		return masterVo;
	}

	@Override
	@Cacheable(value = "getMatchConteststatus", key = "{#root.methodName, #matchId + '-' + #gameNumber}")
	public GetmatchconteststatusVo getMatchConteststatus(Long matchId, Short gameNumber) {
		GetmatchconteststatusVo vo = new GetmatchconteststatusVo();
		vo.setContestants(scheduleDao.findAllMatchConteststatus(matchId, gameNumber));
		return vo;
	}
}
