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
		
		from(RouterConstant.emt_getTouramentList)
			.routeId("getTouramentList")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("touramentService", "getTouramentList");
		
		from(RouterConstant.emt_getMatchStatistics)
			.routeId("getMatchStatistics")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getMatchStatistics");
		
		from(RouterConstant.emt_getSchedule)
			.routeId("getSchedule")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getSchedule");
		
		from(RouterConstant.emt_getResult)
			.routeId("getResult")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getResult");
		
		from(RouterConstant.emt_getLeaguetable)
			.routeId("getLeaguetable")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "getLeaguetable");
		
		from(RouterConstant.emt_saveSupportTeam)
			.routeId("saveSupportTeam")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("matchService", "saveSupportTeam");
		
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
			.beanRef("endUserService", "updateEndUserInfo");
		
		from(RouterConstant.emt_addNotificationHist + RouterConstant.CAMEL_FROM_URI_COMMON_PARAMETER)
			.routeId("addNotificationHist")
			.setExchangePattern(ExchangePattern.InOnly)
			.beanRef("keepAliveService", "addNotificationHist");
		
		from(RouterConstant.emt_sysConfigService)
			.routeId("sysConfigService")
			.setExchangePattern(ExchangePattern.InOut)
			.beanRef("sysConfigService");
	}
}
