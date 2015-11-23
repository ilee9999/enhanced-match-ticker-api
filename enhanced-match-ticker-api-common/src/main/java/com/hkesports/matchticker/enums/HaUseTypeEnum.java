package com.hkesports.matchticker.enums;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * HA使用類別
 */
public enum HaUseTypeEnum {
	
	/**
	 * 連續登入
	 */
	CONTINUOUS_LOGIN("連續登入時可獲得的HA", true),
	
	/**
	 * 連續參與競賽
	 */
	CONTINUOUS_PLAY_GAME("連續參與競賽時可獲得的HA", true),
	
	/**
	 * 看不同新聞
	 */
	WATCH_DIFFERENT_NEWS("看不同新聞", true),
	
	/**
	 * 連續看新聞
	 */
	CONTINUOUS_NEWS("連續看新聞時可獲得的HA", true),

	/**
	 * 註冊
	 */
	SIGNUP("註冊時可獲得的的HA"),
	
	/**
	 * 安裝手機
	 */
	INSTALL_MOBILE("首次安裝APP時可獲得的HA"),
	
	/**
	 * 連接Facebook
	 */
	CONNECT_FACEBOOK("連接Facebook時可獲得的HA"),
	
	/**
	 * 登入
	 */
	LOGIN("登入時可獲得的HA"),
	
	/**
	 * 連續上線, 目前用不到
	 */
	CONTINUOUS_ONLINE,
		
	/**
	 * 看新聞
	 */
	LOOK_NEWS("看新聞時可獲得的HA"),
	
	/**
	 * 根據看新聞的次數來決定送多少HA
	 */
	LOOK_NEW_COUNT("根據看新聞的次數來決定送多少HA"),
	
	/**
	 * 看直播
	 */
	LOOK_LIVE("看直播時可獲得的HA"),
	
	/**
	 * 參與競賽
	 */
	PLAY_GAME("參與競賽時可獲得的HA"),
	
	/**
	 * 根據參與競賽的次數來決定送多少HA
	 */
	PLAY_GAME_COUNT("根據參與競賽的次數來決定送多少HA"),
	
	/**
	 * 收朋友每日送HA
	 */
	RECEIVE_FRIEND_HA("收朋友每日送HA"),
	
	/**
	 * 送朋友每日獲得HA
	 */
	SEND_FRIEND_HA("送朋友每日獲得HA"),
	
	/**
	 * 每日最多少可送好友的次數
	 */
	SEND_FRIEND_COUNT("每日最多少可送好友的次數"),
	
	/**
	 * 要達到該使用者等級所需要賺取的HA
	 */
	EVERY_LEVEL_NEEDED_HA("要達到該使用者等級所需要賺取的HA"),
	
	/**
	 * 預設投放HA之數量
	 */
	DEFAULT_CONTEST_HA("預設投放HA之數量"),
	
	/**
	 * 最低可投放之HA數量
	 */
	LOWER_CONTEST_LIMIT_HA("最低可投放之HA數量"),
	
	/**
	 * 最高可投放之HA數量
	 */
	UPPER_CONTEST_LIMIT_HA("最高可投放之HA數量"),
	
	/**
	 * 每次兢猜可增加的HA
	 */
	EACH_INCREMENT_HA("每次兢猜可增加的HA"),
	
	/**
	 * 每次兢猜可減少的HA
	 */
	EACH_DECREMENT_HA("每次兢猜可減少的HA"),
	
	/**
	 * 下注
	 */
	GUESS_PLAY,
	
	/**
	 * 贏了競賽
	 */
	WIN_PLAY,
	
	/**
	 * 花費, 所有的減項皆使用它
	 */
	SPEND
	;
	
	private String description;
	private boolean isContinuous;
	
	private HaUseTypeEnum() {
		
	}
	
	private HaUseTypeEnum(String description) {
		this.description = description;
		this.isContinuous = false;
	}
	
	private HaUseTypeEnum(String description, boolean isContinuous) {
		this.description = description;
		this.isContinuous = isContinuous;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isContinuous() {
		return isContinuous;
	}

	public static List<String> convertEnumToList(HaUseTypeEnum... enums) {
		if(enums == null || enums.length == 0) {
			return new ArrayList<>(0);
		}
		List<String> names = new ArrayList<>(enums.length);
		for(HaUseTypeEnum obj : enums) {
			names.add(obj.name());
		}
		return names;
	}
	
	public static HaUseTypeEnum convertEnumFromName(String name) {
		for (HaUseTypeEnum obj : HaUseTypeEnum.values()) {
			if (StringUtils.equals(obj.name(), name)) {
				return obj;
			}
		}
		return null;
	}
	
	public static List<HaUseTypeEnum> getSendNotificationTypes(){
		List<HaUseTypeEnum> list = new ArrayList<HaUseTypeEnum>();
		list.add(HaUseTypeEnum.SIGNUP);
		list.add(HaUseTypeEnum.INSTALL_MOBILE);
		list.add(HaUseTypeEnum.CONNECT_FACEBOOK);
		list.add(HaUseTypeEnum.LOGIN);
		list.add(HaUseTypeEnum.LOOK_NEWS);
		list.add(HaUseTypeEnum.LOOK_LIVE);
		list.add(HaUseTypeEnum.CONTINUOUS_LOGIN);
		list.add(HaUseTypeEnum.CONTINUOUS_NEWS);
		list.add(HaUseTypeEnum.CONTINUOUS_PLAY_GAME);
		list.add(HaUseTypeEnum.WATCH_DIFFERENT_NEWS);
		return list;
	}
	
	public static List<HaUseTypeEnum> getContinuousTypes(){
		List<HaUseTypeEnum> list = new ArrayList<HaUseTypeEnum>();
		list.add(HaUseTypeEnum.CONTINUOUS_LOGIN);
		list.add(HaUseTypeEnum.CONTINUOUS_NEWS);
		list.add(HaUseTypeEnum.CONTINUOUS_PLAY_GAME);
		list.add(HaUseTypeEnum.WATCH_DIFFERENT_NEWS);
		return list;
	}
}
