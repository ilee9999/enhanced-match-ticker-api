package com.hkesports.matchticker.config.routes;

/**
 * Router's Constant
 * 
 * @author manboyu
 *
 */
public class RouterConstant {
	
	public final static String CAMEL_FROM_URI_COMMON_PARAMETER = "?transferException=true&testConnectionOnStartup=true&jmsMessageType=Object&concurrentConsumers=20";
	
	public final static String CAMEL_TO_URI_COMMON_PARAMETER = "?transferException=true&transferExchange=true&exchangePattern=InOut&testConnectionOnStartup=true&replyToDeliveryPersistent=false&deliveryPersistent=false&requestTimeout=60000";
	
	public final static String emt_matchSupport = "activemq:queue:emt.matchSupport" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getRanking = "activemq:queue:emt.getRanking" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getTournamentList = "activemq:queue:emt.getTournamentList" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getMatchStatistics = "activemq:queue:emt.getMatchStatistics" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getSchedule = "activemq:queue:emt.getSchedule" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getResult = "activemq:queue:emt.getResult" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getLeaguetable = "activemq:queue:emt.getCircularTournamentTable" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_saveSupportTeam = "activemq:queue:emt.saveSupportTeam" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	// public final static String emt_updateSupportCount = "activemq:queue:emt.updateSupportCount" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	// public final static String emt_keepAlive = "activemq:queue:emt.keepAlive" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_sysConfigService = "activemq:queue:emt.sysConfigService" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_updateEndUserInfo = "activemq:queue:emt.updateEndUserInfo";
	
	public final static String emt_addNotificationHist = "activemq:queue:emt.addNotificationHist";
	
	public final static String emt_getKnockoutrTournamentTable = "activemq:queue:emt.getKnockoutrTournamentTable" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getGameList = "activemq:queue:emt.getGameList" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getContestantPerformance = "activemq:queue:emt.getContestantPerformance" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getLeagueSeasonList = "activemq:queue:emt.getLeagueSeasonList" + CAMEL_FROM_URI_COMMON_PARAMETER;

	public final static String emt_getMatchConteststatus = "activemq:queue:emt.getMatchConteststatus" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getContestantList = "activemq:queue:emt.getContestantList" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getTournamentDetails = "activemq:queue:emt.getTournamentDetails" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getNotification = "activemq:queue:emt.getNotification" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_updateNotificationTimeSent = "activemq:queue:emt.updateNotificationTimeSent" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_readNotification = "activemq:queue:emt.readNotification" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getHa = "activemq:queue:emt.getHa" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getContestLimit = "activemq:queue:emt.getContestLimit" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_makeGuess = "activemq:queue:emt.makeGuess" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_updateSubscription = "activemq:queue:emt.updateSubscription" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getContestantSubscription = "activemq:queue:emt.getContestantSubscription" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getMatchSubscription = "activemq:queue:emt.getMatchSubscription" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getPersonalRecord = "activemq:queue:emt.getPersonalRecord" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getPersonalRanking = "activemq:queue:emt.getPersonalRanking" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_sendToFriend = "activemq:queue:emt.sendToFriend" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	// for decode secretKey
	public final static String auth_securityCode = "activemq:queue:auth.securityCode";
}
