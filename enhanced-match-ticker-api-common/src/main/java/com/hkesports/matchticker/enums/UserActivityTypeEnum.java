package com.hkesports.matchticker.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用者的活動紀錄
 */
public enum UserActivityTypeEnum {

	/**
	 * 註冊
	 */
	SIGNUP,
	
	/**
	 * 安裝手機
	 */
	INSTALL_MOBILE,
	
	/**
	 * 連接Facebook
	 */
	CONNECT_FACEBOOK,
	
	/**
	 * 登入
	 */
	LOGIN,
	
	/**
	 * 在線, 手機版用不到
	 */
	ONLINE,
	
	/**
	 * 進新聞首頁
	 */
	IN_NEWS_INDEX,
	
	/**
	 * 看新聞
	 */
	LOOK_NEWS,
	
	/**
	 * 看直播
	 */
	LOOK_LIVE,
	
	/**
	 * 參與競賽
	 */
	PLAY_GAME,
	
	/**
	 * 每日送朋友HA
	 */
	GIFT_FRIEND_HA
	;
	
	public static List<UserActivityTypeEnum> getOnlyOneTypes(){
		List<UserActivityTypeEnum> list = new ArrayList<UserActivityTypeEnum>();
		list.add(UserActivityTypeEnum.SIGNUP);
		list.add(UserActivityTypeEnum.INSTALL_MOBILE);
		list.add(UserActivityTypeEnum.CONNECT_FACEBOOK);
		return list;
	}
}
