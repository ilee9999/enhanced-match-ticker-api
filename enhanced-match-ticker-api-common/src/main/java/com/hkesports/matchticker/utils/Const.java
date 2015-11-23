package com.hkesports.matchticker.utils;

import java.io.File;

public class Const {
	
	public static final String FILE_SEPARATOR = File.separator;
	public static final String FILE_DOT = ".";
	
	/**
	 * JSON 時間格式
	 */
	public static final String JSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SZ";
	public static final String JSON_DATE_FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String JSON_DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
	
	/**
	 * API getVersion data name
	 */
	public static final String VERSION_KEY_IOS = "iOSVersion";
	public static final String VERSION_KEY_ANDROID = "AndroidVersion";
	
	/**
	 * user ha code name
	 */
	public static final String USER_PROFILE_HA_LEVEL = "HA幣的使用者等級";
	
	/**
	 * admin key
	 */
	public static final String ADMIN_KEY_ICON_DOMAIN = "ICON_DOMAIN";
	public static final String ADMIN_KEY_ICON_PATH_LEAGUE = "ICON_PATH_LEAGUE";
	public static final String ADMIN_KEY_ICON_PATH_TOURNAMENT = "ICON_PATH_TOURNAMENT";
	public static final String ADMIN_KEY_ICON_PATH_GAME = "ICON_PATH_GAME";
	public static final String ADMIN_KEY_ICON_PATH_TEAM = "ICON_PATH_TEAM";
	public static final String ADMIN_KEY_ICON_PATH_PLAYER = "ICON_PATH_PLAYER";
	
	public static final String ADMIN_KEY_PERSONAL_RANKING_DEVICE_LIMIT = "PERSONAL_RANKING_DEVICE_LIMIT";
	public static final String ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT = "PERSONAL_RANKING_USER_LIMIT";
	public static final String ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT = "RANKING_USER_BETWEEN_LIMIT";
	public static final Integer ADMIN_KEY_PERSONAL_RANKING_DEVICE_LIMIT_DEFAULT = 20;
	public static final Integer ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT_DEFAULT = 5;
	public static final Integer ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT_DEFAULT = 5;
	
	/**
	 * logo file name size
	 */
	public static final String FILE_SIZE_NAME_HUGE = "_huge" + FILE_DOT;
	public static final String FILE_SIZE_NAME_LARGE = "_large" + FILE_DOT;
	public static final String FILE_SIZE_NAME_SMALL = "_small" + FILE_DOT;
	public static final String FILE_SIZE_NAME_THUMBNAIL = "_thumbnail" + FILE_DOT;
	public static final String FILE_SIZE_NAME_ORIGINAL = "_original" + FILE_DOT;
	public static final String FILE_SIZE_NAME_TEAMA_LARGE = "_teamAlarge" + FILE_DOT;
	public static final String FILE_SIZE_NAME_TEAMA_SMALL = "_teamAsmall" + FILE_DOT;
	public static final String FILE_SIZE_NAME_TEAMB_LARGE = "_teamBlarge" + FILE_DOT;
	public static final String FILE_SIZE_NAME_TEAMB_SMALL = "_teamBsmall" + FILE_DOT;
}
