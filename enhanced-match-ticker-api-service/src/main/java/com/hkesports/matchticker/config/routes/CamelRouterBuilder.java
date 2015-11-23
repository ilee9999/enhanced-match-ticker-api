package com.hkesports.matchticker.config.routes;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author manboyu
 *
 */
@Component("camelRouterBuilder")
public class CamelRouterBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from(RouterConstant.emt_matchSupport)
			.routeId("matchSupport")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "matchSupport");
		
		from(RouterConstant.emt_getRanking)
			.routeId("getRanking")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getRanking");
		
		from(RouterConstant.emt_getTournamentList)
			.routeId("getTournamentList")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("tournamentService", "getTournamentList");
		
		from(RouterConstant.emt_getMatchStatistics)
			.routeId("getlolMatchStatistics")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService");
		
		from(RouterConstant.emt_getSchedule)
			.routeId("getSchedule")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getSchedule");
		
		from(RouterConstant.emt_getResult)
			.routeId("getResult")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getResult");
		
		from(RouterConstant.emt_getLeaguetable)
			.routeId("getCircularTournamentTable")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getCircularTournamentTable");
		
		from(RouterConstant.emt_saveSupportTeam)
			.routeId("saveSupportTeam")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "saveSupportTeam");
		
		/*
		from(RouterConstant.emt_updateSupportCount)
			.routeId("updateSupportCount")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "updateSupportCount");
		
		from(RouterConstant.emt_keepAlive)
			.routeId("keepAlive")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("keepAliveService", "keepalive");
		
		
		from(RouterConstant.emt_updateEndUserInfo + RouterConstant.CAMEL_FROM_URI_COMMON_PARAMETER)
			.routeId("updateEndUserInfo")
			.setExchangePattern(ExchangePattern.InOnly)
			.beanRef("userService", "updateEndUserInfo");
		*/
		from(RouterConstant.emt_addNotificationHist + RouterConstant.CAMEL_FROM_URI_COMMON_PARAMETER)
			.routeId("addNotificationHist")
			.setExchangePattern(ExchangePattern.InOnly)
			.beanRef("keepAliveService", "addNotificationHist");
		
		from(RouterConstant.emt_sysConfigService)
			.routeId("sysConfigService")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("sysConfigService");
		
		from(RouterConstant.emt_getKnockoutrTournamentTable)
			.routeId("getKnockoutrTournamentTable")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("tournamentService", "getKnockoutrTournamentTable");
		
		from(RouterConstant.emt_getGameList)
			.routeId("getGameList")
			.setExchangePattern(ExchangePattern.OutOnly)
			.beanRef("gameService", "getGameList");
		
		from(RouterConstant.emt_getContestantPerformance)
			.routeId("getContestantPerformance")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getContestantPerformance");
		
		from(RouterConstant.emt_getLeagueSeasonList)
			.routeId("getLeagueSeasonList")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("tournamentService", "getLeagueSeasonList");

		from(RouterConstant.emt_getMatchConteststatus)
			.routeId("getMatchConteststatus")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getMatchConteststatus");
		
		from(RouterConstant.emt_getContestantList)
			.routeId("getContestantList")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("gameService", "getContestantList");
		
		from(RouterConstant.emt_getTournamentDetails)
			.routeId("getTournamentDetails")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("tournamentService", "getTournamentDetails");
		
		from(RouterConstant.emt_getNotification)
			.routeId("getNotification")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "getNotification");
		
		from(RouterConstant.emt_updateNotificationTimeSent)
			.routeId("updateNotificationTimeSent")
			.setExchangePattern(ExchangePattern.InOnly)
			.beanRef("userService", "updateNotificationTimeSent");
		
		from(RouterConstant.emt_readNotification)
			.routeId("readNotification")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "readNotification");
		
		from(RouterConstant.emt_getHa)
			.routeId("getHa")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "getHa");
		
		from(RouterConstant.emt_makeGuess)
			.routeId("makeGuess")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "makeGuess");
		
		from(RouterConstant.emt_getContestLimit)
			.routeId("getContestLimit")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "getContestLimit");
		
		from(RouterConstant.emt_updateSubscription)
			.routeId("updateSubscription")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "updateSubscription");
		
		from(RouterConstant.emt_getContestantSubscription)
			.routeId("getContestantSubscription")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "getContestantSubscription");
		
		from(RouterConstant.emt_getMatchSubscription)
			.routeId("getMatchSubscription")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "getMatchSubscription");
		
		from(RouterConstant.emt_getPersonalRecord)
			.routeId("getPersonalRecord")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "getPersonalRecord");
		
		from(RouterConstant.emt_getPersonalRanking)
			.routeId("getPersonalRanking")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "getPersonalRanking");
		
		from(RouterConstant.emt_sendToFriend)
			.routeId("sendToFriend")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("userService", "sendToFriend");
	}
}
