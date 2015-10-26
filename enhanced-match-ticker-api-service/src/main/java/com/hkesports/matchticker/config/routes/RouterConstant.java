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
	
	public final static String emt_getTouramentList = "activemq:queue:emt.getTouramentList" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getMatchStatistics = "activemq:queue:emt.getMatchStatistics" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getSchedule = "activemq:queue:emt.getSchedule" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getResult = "activemq:queue:emt.getResult" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_getLeaguetable = "activemq:queue:emt.getLeaguetable" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_saveSupportTeam = "activemq:queue:emt.saveSupportTeam" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_updateSupportCount = "activemq:queue:emt.updateSupportCount" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_keepAlive = "activemq:queue:emt.keepAlive" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_sysConfigService = "activemq:queue:emt.sysConfigService" + CAMEL_FROM_URI_COMMON_PARAMETER;
	
	public final static String emt_updateEndUserInfo = "activemq:queue:emt.updateEndUserInfo";
	
	public final static String emt_addNotificationHist = "activemq:queue:emt.addNotificationHist";
}
