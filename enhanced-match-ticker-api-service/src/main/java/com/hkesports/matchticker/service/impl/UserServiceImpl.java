package com.hkesports.matchticker.service.impl;

import static com.hkesports.matchticker.enums.HaUseTypeEnum.DEFAULT_CONTEST_HA;
import static com.hkesports.matchticker.enums.HaUseTypeEnum.EACH_DECREMENT_HA;
import static com.hkesports.matchticker.enums.HaUseTypeEnum.EACH_INCREMENT_HA;
import static com.hkesports.matchticker.enums.HaUseTypeEnum.EVERY_LEVEL_NEEDED_HA;
import static com.hkesports.matchticker.enums.HaUseTypeEnum.LOWER_CONTEST_LIMIT_HA;
import static com.hkesports.matchticker.enums.HaUseTypeEnum.UPPER_CONTEST_LIMIT_HA;
import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_DEVICE_LIMIT;
import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_DEVICE_LIMIT_DEFAULT;
import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT;
import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT_DEFAULT;
import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT;
import static com.hkesports.matchticker.utils.Const.ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT_DEFAULT;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.enums.HaUseTypeEnum;
import com.hkesports.matchticker.enums.NotificationSendTypeEnum;
import com.hkesports.matchticker.enums.NotificationStatusEnum;
import com.hkesports.matchticker.enums.NotificationTypeEnum;
import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.enums.SubscriptionTypeEnum;
import com.hkesports.matchticker.enums.UserActivityTypeEnum;
import com.hkesports.matchticker.enums.UserDeviceTypeEnum;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.exception.SecurityCodeException;
import com.hkesports.matchticker.model.Admin;
import com.hkesports.matchticker.model.Code;
import com.hkesports.matchticker.model.Data;
import com.hkesports.matchticker.model.Device;
import com.hkesports.matchticker.model.GuessLog;
import com.hkesports.matchticker.model.NotificationDetail;
import com.hkesports.matchticker.model.NotificationMaster;
import com.hkesports.matchticker.model.NotificationSetting;
import com.hkesports.matchticker.model.Schedule;
import com.hkesports.matchticker.model.SubscriptionSetting;
import com.hkesports.matchticker.model.UserDevices;
import com.hkesports.matchticker.model.basic.UserHa;
import com.hkesports.matchticker.repository.AdminDao;
import com.hkesports.matchticker.repository.DataDao;
import com.hkesports.matchticker.repository.DeviceActivityRecordDao;
import com.hkesports.matchticker.repository.DeviceHaRecordDao;
import com.hkesports.matchticker.repository.FriendsListDao;
import com.hkesports.matchticker.repository.GuessLogDao;
import com.hkesports.matchticker.repository.HaRecordDao;
import com.hkesports.matchticker.repository.NotificationDetailDao;
import com.hkesports.matchticker.repository.NotificationMasterDao;
import com.hkesports.matchticker.repository.NotificationSettingDao;
import com.hkesports.matchticker.repository.PersonalRankingDao;
import com.hkesports.matchticker.repository.ScheduleDao;
import com.hkesports.matchticker.repository.ScheduleGameDao;
import com.hkesports.matchticker.repository.ScheduleGameDetailDao;
import com.hkesports.matchticker.repository.SubscriptionSettingDao;
import com.hkesports.matchticker.repository.TeamDao;
import com.hkesports.matchticker.repository.UserActivityRecordDao;
import com.hkesports.matchticker.repository.UserDevicesDao;
import com.hkesports.matchticker.service.SysConfigService;
import com.hkesports.matchticker.service.UserService;
import com.hkesports.matchticker.utils.Const;
import com.hkesports.matchticker.utils.DateUtil;
import com.hkesports.matchticker.vo.KeepaliveReqVo;
import com.hkesports.matchticker.vo.UserProfileVo;
import com.hkesports.matchticker.vo.getcontestlimit.GetcontestlimitVo;
import com.hkesports.matchticker.vo.getha.GethaVo;
import com.hkesports.matchticker.vo.getnotification.GetnotificationVo;
import com.hkesports.matchticker.vo.getpersonalranking.GetpersonalrankingVo;
import com.hkesports.matchticker.vo.getpersonalranking.RankVo;
import com.hkesports.matchticker.vo.getpersonalrecord.ContestantsVo;
import com.hkesports.matchticker.vo.getpersonalrecord.DayVo;
import com.hkesports.matchticker.vo.getpersonalrecord.GameVo;
import com.hkesports.matchticker.vo.getpersonalrecord.GetpersonalrecordVo;
import com.hkesports.matchticker.vo.getpersonalrecord.MonthVo;
import com.hkesports.matchticker.vo.getpersonalrecord.RecordVo;
import com.hkesports.matchticker.vo.getpersonalrecord.TournamentVo;
import com.hkesports.matchticker.vo.getpersonalrecord.YearVo;
import com.hkesports.matchticker.vo.getsubscription.ContestantSubscriptionVo;
import com.hkesports.matchticker.vo.getsubscription.GetcontestantsubscriptionVo;
import com.hkesports.matchticker.vo.getsubscription.GetmatchsubscriptionVo;
import com.hkesports.matchticker.vo.getsubscription.MatchSubscriptionVo;
import com.hkesports.matchticker.vo.makeguess.MakeGuessRequestVo;
import com.hkesports.matchticker.vo.makeguess.MakeguessVo;
import com.hkesports.matchticker.vo.readnotification.ReadnotificationVo;
import com.hkesports.matchticker.vo.sendtofriend.SendtofriendVo;
import com.hkesports.matchticker.vo.updatesubscription.UpdatesubscriptionVo;

@Transactional
@Service("userService")
public class UserServiceImpl extends BasicServiceImpl implements UserService {
	
	@Resource
	private SysConfigService sysConfigService;
	@Resource
	private NotificationMasterDao notificationMasterDao;
	@Resource
	private NotificationDetailDao notificationDetailDao;
	@Resource
	private NotificationSettingDao notificationSettingDao;
	@Resource
	private DeviceHaRecordDao deviceHaRecordDao;
	@Resource
	private HaRecordDao haRecordDao;
	@Resource
	private GuessLogDao guessLogDao;
	@Resource
	private DeviceActivityRecordDao deviceActivityRecordDao;
	@Resource
	private UserActivityRecordDao userActivityRecordDao;
	@Resource
	private DataDao dataDao;
	@Resource
	private SubscriptionSettingDao subscriptionSettingDao;
	@Resource
	private ScheduleDao scheduleDao;
	@Resource
	private ScheduleGameDao scheduleGameDao;
	@Resource
	private ScheduleGameDetailDao scheduleGameDetailDao;
	@Resource
	private TeamDao teamDao;
	@Resource
	private PersonalRankingDao personalRankingDao; 
	@Resource
	private FriendsListDao friendsListDao;
	@Resource
	private UserDevicesDao userDevicesDao;
	@Resource
	private AdminDao adminDao;
	
	@Override
	@Deprecated
	public void updateEndUserInfo(KeepaliveReqVo keepaliveReqVo, Date instant) {
		
	}

	@Override
	public GetnotificationVo getNotification(String registrationID) {
		GetnotificationVo vo = new GetnotificationVo();
		vo.setNotifications(notificationMasterDao.findAllNotificationByRegId(registrationID));
		return vo;
	}
	
	@Override
	public void updateNotificationTimeSent(String registrationID) {
		notificationMasterDao.updateNotificationTimeSent(registrationID);
	}
	
	@Override
	public ReadnotificationVo readNotification(Long notificationID, String registrationID) {
		int count = notificationDetailDao.updateNotificationTimeRead(notificationID, registrationID);
		if(count==0) {
			//if no data be update
		}
		return new ReadnotificationVo();
	}
	
	@Override
	public GethaVo getHa(String registrationID, String secretKey) {
		if(StringUtils.isBlank(registrationID)) {
			return new GethaVo(StatusCodeEnum.STATUS_101);
		}
		try {
			UserHa userHa = getUserHa(registrationID, secretKey);
			return new GethaVo(userHa.getHa());
		} catch (SecurityCodeException e) {
			return new GethaVo(e.getStatusCode());
		}
	}

	@Override
	public MakeguessVo makeGuess(MakeGuessRequestVo vo) {
		try {
			UserHa userHa = getUserHa(vo.getRegistrationID(), vo.getSecretKey());
			if(!checkHa(userHa.getHa(), vo.getHa())) {
				//競猜失敗，你戶口中的ha不足夠
				return new MakeguessVo(StatusCodeEnum.STATUS_501);
			}
			Date now = new Date();
			//TODO 確認 若重複下注, client傳過來的金額是下注總金額 亦或是當次增減的下注金額?
			//目前先做成 "當次增減的下注金額"
			Long logId = saveGuessLog(userHa.getUserId(), userHa.getUserType(), vo.getMatchID(), vo.getContestantID(), vo.getGameNumber(), vo.getHa(), now);
			switch (userHa.getUserType()) {
				case DEVICE:
					makeGuessByDevice(logId, (Device) userHa, vo.getHa(), now);
					break;
				case USER:
					makeGuessByUser(logId, (UserProfileVo) userHa, vo.getHa(), now);
					break;
				default:
					break;
			}
			//送獎勵
			sendHaByMakeGuess(userHa, vo.getMatchID(), now);
			return new MakeguessVo(StatusCodeEnum.STATUS_0);
		} catch (SecurityCodeException e) {
			return new MakeguessVo(e.getStatusCode());
		}
	}
	
	/**
	 * 檢查戶口中ha是否足夠 若足夠則回傳true
	 * @param dbHa
	 * @param guessHa
	 * @return
	 */
	private boolean checkHa(BigInteger dbHa, BigInteger guessHa) {
		return dbHa!=null && dbHa.longValue() >= guessHa.longValue();
	}
	
	private Long saveGuessLog(Long userId, UserTypeEnum userType, Long matchId, Long contestantId, Integer gameNumber, BigInteger newHa, Date now) throws SecurityCodeException {
		//原ha加上競猜的ha (可能是第一次下注或是加注)
		int count = guessLogDao.updateForMakeGuess(userId, userType.name(), matchId, gameNumber, contestantId, newHa, now);
		//等於零代表第一次下注 需累計scheduleGameDetail的guessCount 及新增新的GuessLog
		if(count==0) {
			int updateCount = scheduleGameDetailDao.updateGuessCount(matchId, gameNumber, contestantId, now);
			//若update結果等於零 則代表輸入資料是錯誤的 或是資料有遺漏
			//原 throw Exception 改成建立新的 scheduleGameDetail
			if(updateCount==0) {
				Long scheduleGameId = scheduleGameDao.findIdByScheduleIdAndGameNumber(matchId, gameNumber.shortValue());
				if(scheduleGameId!=null) {
					logger.warn("SaveGuessLog when updateGuessCount scheduleGameDetail not exists!! matchId:{}, gameNumber:{}, contestantId:{} ", matchId, gameNumber, contestantId);
					scheduleGameDetailDao.insertForMakeGuess(scheduleGameId, contestantId, now);
				} else {
					logger.warn("SaveGuessLog when updateGuessCount scheduleGame not exists!! matchId:{}, gameNumber:{}, contestantId:{} ", matchId, gameNumber, contestantId);
					throw new SecurityCodeException(StatusCodeEnum.STATUS_303);
				}
			}
			GuessLog log = new GuessLog();
			log.setMatchId(matchId);
			log.setContestantId(contestantId);
			log.setGameNumber(gameNumber);
			log.setHa(newHa);
			log.setUserType(userType);
			log.setUserId(userId);
			
			Calendar c = Calendar.getInstance();
			c.setTime(now);
			log.setCreateYear(c.get(Calendar.YEAR));
			log.setCreateMonth(c.get(Calendar.MONTH) + 1);
			log.setCreateDay(c.get(Calendar.DATE));
			log.setCreateDate(DateUtil.toDateInt(now));
			log.setCreateTime(DateUtil.toTimeInt(now));
			guessLogDao.saveAndFlush(log);
			return log.getId();
		} else {
			return guessLogDao.findIdByGame(userId, userType, matchId, contestantId, gameNumber);
		}
	}
	
	private void makeGuessByDevice(Long logId, Device device, BigInteger newHa, Date now) throws SecurityCodeException {
		//若有值 代表重複競猜 只更新ha其餘不動
		int count = deviceHaRecordDao.updateForMakeGuess(device.getId(), HaUseTypeEnum.GUESS_PLAY.name(), logId, newHa.negate());
		if(count==0) {
			int createDate = DateUtil.toDateInt(now);
			int createTime = DateUtil.toTimeInt(now);
			deviceHaRecordDao.insert(device.getId(), HaUseTypeEnum.GUESS_PLAY.name(), null, newHa.negate(), createDate, createTime, logId, null);
			
			//add DeviceActivityRecord 相同的競猜只需要一筆
			deviceActivityRecordDao.insert(device.getId(), UserActivityTypeEnum.PLAY_GAME.name(), createDate, createTime, null, "guess_log", logId);
		}
		
		//save device.ha use native sql
//		device.setHa(device.getHa().subtract(vo.getHa()));
		deviceDao.updateHaForMakeGuess(device.getId(), newHa, now);
	}
	
	private void makeGuessByUser(Long logId, UserProfileVo userProfile, BigInteger newHa, Date now) throws SecurityCodeException {
		Long userId = userProfile.getUserId();
		//若有值 代表重複競猜 只更新ha其餘不動
		int count = haRecordDao.updateForMakeGuess(userId, HaUseTypeEnum.GUESS_PLAY.name(), logId, newHa.negate());
		if(count==0) {
			int createDate = DateUtil.toDateInt(now);
			int createTime = DateUtil.toTimeInt(now);
			haRecordDao.insert(userId, HaUseTypeEnum.GUESS_PLAY.name(), null, newHa.negate(), createDate, createTime, logId, null);
			
			//add UserActivityRecord 相同的競猜只需要一筆
			userActivityRecordDao.insert(userId, UserActivityTypeEnum.PLAY_GAME.name(), UserDeviceTypeEnum.MOBILE.name(), createDate, createTime, null, "guess_log", logId);
		}
		
		//save userProfile.ha use native sql
//		userProfile.setHa(userProfile.getHa().subtract(vo.getHa()));
		userProfileDao.updateHaForMakeGuess(userProfile.getId(), newHa, now);
	}

	private void sendHaByMakeGuess(UserHa userHa, Long matchId, Date now) {
		Long userId = userHa.getUserId();
		UserTypeEnum userType = userHa.getUserType();
		
		Data playGame = dataDao.findAllDataByHaType(userType, userId, HaUseTypeEnum.PLAY_GAME);
		Data playGameCount = dataDao.findAllDataByHaType(userType, userId, HaUseTypeEnum.PLAY_GAME_COUNT);
		if(playGame==null || playGameCount==null) {
			// 代表沒有找到相關設定或設定不完全 故不做事
			return ;
		}
		
		BigInteger newHa = new BigInteger(playGame.getDataValue());
		int createDate = DateUtil.toDateInt(now);
		int createTime = DateUtil.toTimeInt(now);
		switch (userHa.getUserType()) {
			case DEVICE:
				//取得 今天賭了幾次 並與data 比較
				Long count1 = deviceActivityRecordDao.countByDeviceIdAndActivityTypeAndCreateDate(userId, UserActivityTypeEnum.PLAY_GAME, createDate);
				if(count1==null || count1.longValue() < Long.valueOf(playGameCount.getDataValue()).longValue()) {
					return;
				}
				//取得 今天是否已經發送獎勵了
				Long sendCount1 = deviceHaRecordDao.countByDeviceIdAndUseType(userId, HaUseTypeEnum.PLAY_GAME, createDate);
				if(sendCount1!=null && sendCount1.longValue() > 0) {
					return;
				}
				deviceHaRecordDao.insert(userId, HaUseTypeEnum.PLAY_GAME.name(), null, newHa, createDate, createTime, null, null);
				deviceDao.addHa(userHa.getId(), newHa, now);
				//add notification
				addNotifactionForMakeGuess(userHa, count1, newHa, matchId);
				return;
			case USER:
				//取得 今天賭了幾次 並與data 比較
				Long count2 = userActivityRecordDao.countByUserIdAndActivityTypeAndCreateDate(userId, UserActivityTypeEnum.PLAY_GAME, createDate);
				if(count2==null || count2.longValue() < Long.valueOf(playGameCount.getDataValue()).longValue()) {
					return;
				}
				//取得 今天是否已經發送獎勵了
				Long sendCount2 = haRecordDao.countByUserIdAndUseType(userId, HaUseTypeEnum.PLAY_GAME, createDate);
				if(sendCount2!=null && sendCount2.longValue() > 0) {
					return;
				}
				haRecordDao.insert(userId, HaUseTypeEnum.PLAY_GAME.name(), null, newHa, createDate, createTime, null, null);
				userProfileDao.addHa(userHa.getId(), newHa, now);
				//add notification
				addNotifactionForMakeGuess(userHa, count2, newHa, matchId);
				return;
			default:
				return;
		}
		
	}
	
	private void addNotifactionForMakeGuess(UserHa userHa, Long gameCount, BigInteger haCount, Long matchId) {
		Schedule schedule = scheduleDao.findOne(matchId);
		if(schedule==null) {
			return;
		}
		NotificationTypeEnum notificationType = NotificationTypeEnum.CONTEST;
		List<NotificationSetting> notificationSettingList = notificationSettingDao.findAll(notificationType, schedule.getGame().getGameCode(), userHa.getUserType(), userHa.getUserId());
		if(!CollectionUtils.isEmpty(notificationSettingList)) {
			//IsNotification is false 代表該使用者不想接收到此Notifaction故不新增Notifaction
			if(!notificationSettingList.get(0).getIsNotification()) {
				return ;
			}
		}
		
		NotificationMaster nm = new NotificationMaster();
		nm.setNotificationType(notificationType);
		nm.setType(NotificationSendTypeEnum.POPUP);
		//TODO 確認訊息format從何處來
		nm.setTitle("獲得獎賞!");
		StringBuffer content = new StringBuffer();
		content.append("恭喜!! 您參與競賽達到了 ").append(gameCount).append("次, 共獲得了 ").append(haCount).append("個HA!!");
		nm.setContent(content.toString());
		nm.setStatus(NotificationStatusEnum.Ready);
		notificationMasterDao.save(nm);
		
		NotificationDetail nd = new NotificationDetail();
		nd.setNotificationMaster(nm);
		nd.setRetryCount(0);
		nd.setRegistrationId(userHa.getDeviceKey());
		notificationDetailDao.save(nd);
	}
	
	@Override
	public GetcontestlimitVo getContestLimit(String registrationID, String secretKey) {
		if(StringUtils.isBlank(registrationID)) {
			return new GetcontestlimitVo(StatusCodeEnum.STATUS_101);
		}
		GetcontestlimitVo result = new GetcontestlimitVo();
		try {
			UserHa userHa = getUserHa(registrationID, secretKey);
			bindContestlimit(result, String.valueOf(userHa.getTotalHa()));
		} catch (SecurityCodeException e) {
			return new GetcontestlimitVo(e.getStatusCode());
		}
		return result;
	}
	
	private void bindContestlimit(GetcontestlimitVo result, String totalHa) {
		List<Data> levels = dataDao.findLevelValueByDataName(Const.USER_PROFILE_HA_LEVEL, EVERY_LEVEL_NEEDED_HA.name(), totalHa);
		if(!CollectionUtils.isEmpty(levels)) {
			Code reachlevel = levels.get(0).getCode();
			List<Data> datas = dataDao.findByCodeAndDataNameIn(reachlevel, HaUseTypeEnum.convertEnumToList(DEFAULT_CONTEST_HA, LOWER_CONTEST_LIMIT_HA, UPPER_CONTEST_LIMIT_HA, EACH_INCREMENT_HA, EACH_DECREMENT_HA));
			if(!CollectionUtils.isEmpty(datas)) {
				for(Data data : datas) {
					switch (HaUseTypeEnum.convertEnumFromName(data.getDataName())) {
					case DEFAULT_CONTEST_HA:
						result.setDefaultContestHa(data.getDataValue());
						break;
					case LOWER_CONTEST_LIMIT_HA:
						result.setLowerContestLimitHa(data.getDataValue());
						break;
					case UPPER_CONTEST_LIMIT_HA:
						result.setUpperContestLimitHa(data.getDataValue());
						break;
					case EACH_INCREMENT_HA:
						result.setEachIncrementHa(data.getDataValue());
						break;
					case EACH_DECREMENT_HA:
						result.setEachDecrementHa(data.getDataValue());
						break;
					default:
						break;
					}
				}
			}
		}
	}

	@Override
	public UpdatesubscriptionVo updateSubscription(String registrationID, String secretKey, 
			SubscriptionTypeEnum subscriptionType, Long contestantID, Boolean subscribe) {
		if(StringUtils.isBlank(registrationID)) {
			return new UpdatesubscriptionVo(StatusCodeEnum.STATUS_101);
		}
		SubscriptionSetting ss = new SubscriptionSetting();
		ss.setSubscriptionType(subscriptionType);
		ss.setSubscriptionKey(contestantID);
		try {
			UserHa userHa = getUserHa(registrationID, secretKey);
			ss.setUserType(userHa.getUserType());
			ss.setUserId(userHa.getUserId());
		} catch (SecurityCodeException e) {
			return new UpdatesubscriptionVo(e.getStatusCode());
		}
		if(BooleanUtils.isTrue(subscribe)) {
			Long count = subscriptionSettingDao.countByUserAndSubscription(ss);
			if(count.longValue()>0) {
				return new UpdatesubscriptionVo(StatusCodeEnum.STATUS_0);
			}
			ss.setCreateDate(new Date());
			subscriptionSettingDao.saveAndFlush(ss);
			switch (subscriptionType) {
				case MATCH:
					sysConfigService.cacheEvict("getSchedule", "getTournamentDetails");
					break;
				case TEAM:
					teamDao.updateFollowerNumber(contestantID, 1);
					//因TEAM與PLAYER皆需做cacheEvict 故不break
				case PLAYER:
					sysConfigService.cacheEvict("getTournamentDetails");
					break;
			default:
				break;
			}
		} else {
			int delCount = subscriptionSettingDao.deleteByUserAndSubscription(ss);
			switch (subscriptionType) {
				case MATCH:
					sysConfigService.cacheEvict("getSchedule");
					break;
				case TEAM:
					if(delCount>0) {
						teamDao.updateFollowerNumber(contestantID, delCount * -1);
					}
					//因TEAM與PLAYER皆需做cacheEvict 故不break
				case PLAYER:
					sysConfigService.cacheEvict("getTournamentDetails");
					break;
			default:
				break;
			}
		}
		return new UpdatesubscriptionVo(StatusCodeEnum.STATUS_0);
	}
	
	@Override
	public GetpersonalrecordVo getPersonalRecord(String registrationID, String secretKey, Integer year, Integer month) {
		GetpersonalrecordVo vo = new GetpersonalrecordVo();
		try {
			UserHa userHa = getUserHa(registrationID, secretKey);
			Long userId = userHa.getUserId();
			UserTypeEnum userType = userHa.getUserType();
			vo.setHa(userHa.getHa());
			Calendar c = Calendar.getInstance();
			if(year==null || year==0) {
				year = c.get(Calendar.YEAR);
			}
			if(month==null || month==0) {
				month = c.get(Calendar.MONTH) + 1;
			}
			List<RecordVo> recordList = scheduleDao.findAllScheduleByGuessRecord(userId, userType, year, month);
			if(CollectionUtils.isEmpty(recordList)) {
				return vo;
			}
			Map<Integer, YearVo> yearMap = new HashMap<>();
			Map<Integer, MonthVo> monthMap = new HashMap<>();
			Map<Integer, DayVo> dateMap = new HashMap<>();
			Map<Long, TournamentVo> tournamentMap = new HashMap<>();
			
			for(RecordVo recordVo:recordList) {
				//分年
				YearVo yearVo = yearMap.get(recordVo.getYear());
				if(yearVo==null) {
					yearMap.put(recordVo.getYear(), yearVo = new YearVo(recordVo.getYear()));
					yearVo.setYearlyTotalSpending(guessLogDao.findYearlyTotalSpending(userId, userType, recordVo.getYear()));
					vo.addYear(yearVo);
					monthMap.clear();
				}
				//分月
				MonthVo monthVo = monthMap.get(recordVo.getMonth());
				if(monthVo==null) {
					monthMap.put(recordVo.getMonth(), monthVo = new MonthVo(recordVo.getMonth()));
					monthVo.setMonthlyTotalSpending(guessLogDao.findMonthlyTotalSpending(userId, userType, recordVo.getYear(), recordVo.getMonth()));
					yearVo.addMonth(monthVo);
					dateMap.clear();
				}
				//分日
				DayVo dayVo = dateMap.get(recordVo.getDay());
				if(dayVo==null) {
					dateMap.put(recordVo.getDay(), dayVo = new DayVo(recordVo.getDay()));
					monthVo.addDay(dayVo);
					tournamentMap.clear();
				}
				
				//分Tournament
				TournamentVo tournamentVo = tournamentMap.get(recordVo.getTournamentID());
				if(tournamentVo==null) {
					tournamentVo = new TournamentVo();
					tournamentVo.setTournamentID(recordVo.getTournamentID());
					tournamentVo.setTournamentName(recordVo.getTournamentName());
					dayVo.addTournament(tournamentVo);
					tournamentMap.put(recordVo.getTournamentID(), tournamentVo);
				}
				tournamentVo.addRecord(recordVo);
				//取得Contestant資料
				recordVo.setContestants(teamDao.findAllTeamVoByMatchId(recordVo.getMatchID(), ContestantsVo.class));
				//取得ScheduleGame下注資料
				List<GameVo> gameList = scheduleGameDao.findAllGuessGameRecord(userHa.getUserId(), userHa.getUserType(), recordVo.getMatchID());
				if(CollectionUtils.isEmpty(gameList)) {
					continue;
				}
				recordVo.setGames(gameList);
				for(GameVo gameVo:gameList) {
					gameVo.setContestants(scheduleGameDetailDao.findAllGuessGameDetailRecord(userHa.getUserId(), userHa.getUserType(), gameVo.getGameID()));
				}
			}
		} catch (SecurityCodeException e) {
			return new GetpersonalrecordVo(e.getStatusCode());
		}
		return vo;
	}
	
	@Override
	public GetcontestantsubscriptionVo getContestantSubscription(String registrationID, String secretKey, Boolean team) {
		try {
			UserHa userHa = getUserHa(registrationID, secretKey);
			GetcontestantsubscriptionVo vo = new GetcontestantsubscriptionVo();
			if(team==null) {
				vo.setContestants(subscriptionSettingDao.findAllByUser(ContestantSubscriptionVo.class, userHa.getUserId(), userHa.getUserType(), SubscriptionTypeEnum.TEAM.name(), SubscriptionTypeEnum.PLAYER.name()));
			} else if(BooleanUtils.isTrue(team)) {
				vo.setContestants(subscriptionSettingDao.findAllByUser(ContestantSubscriptionVo.class, userHa.getUserId(), userHa.getUserType(), SubscriptionTypeEnum.TEAM.name()));
			} else {
				vo.setContestants(subscriptionSettingDao.findAllByUser(ContestantSubscriptionVo.class, userHa.getUserId(), userHa.getUserType(), SubscriptionTypeEnum.PLAYER.name()));
			}
			return vo;
		} catch (SecurityCodeException e) {
			return new GetcontestantsubscriptionVo(e.getStatusCode());
		}
	}

	@Override
	public GetmatchsubscriptionVo getMatchSubscription(String registrationID, String secretKey) {
		try {
			UserHa userHa = getUserHa(registrationID, secretKey);
			GetmatchsubscriptionVo vo = new GetmatchsubscriptionVo();
			vo.setSchedules(subscriptionSettingDao.findAllByUser(MatchSubscriptionVo.class, userHa.getUserId(), userHa.getUserType(), SubscriptionTypeEnum.MATCH.name()));
			return vo;
		} catch (SecurityCodeException e) {
			return new GetmatchsubscriptionVo(e.getStatusCode());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public GetpersonalrankingVo getPersonalRanking(String registrationID, String secretKey) {
		GetpersonalrankingVo result = new GetpersonalrankingVo();
		Integer today = DateUtil.toDateInt(new Date());
		Admin d = adminDao.findByKey(ADMIN_KEY_PERSONAL_RANKING_DEVICE_LIMIT);
		Admin u = adminDao.findByKey(ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT);
		Admin b = adminDao.findByKey(ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT);
		Integer devicePersonalLimit = d != null ? Integer.parseInt(d.getValue()) : ADMIN_KEY_PERSONAL_RANKING_DEVICE_LIMIT_DEFAULT;
		Integer userPersonalLimit = u != null ? Integer.parseInt(u.getValue()) : ADMIN_KEY_PERSONAL_RANKING_USER_LIMIT_DEFAULT;
		Integer userBetweenLimit = b != null ? Integer.parseInt(b.getValue()) : ADMIN_KEY_PERSONAL_RANKING_USER_BETWEEN_LIMIT_DEFAULT;
		try {
			UserHa userHa = getUserHa(registrationID, secretKey);
			UserTypeEnum userType = userHa.getUserType();
			if(userType.equals(UserTypeEnum.DEVICE)) {
				result.setRanks(personalRankingDao.findPersonalRankingsByLimit(devicePersonalLimit, today));
			} else {
				Integer userRank = personalRankingDao.findByUserId(userHa.getUserId(), today);
				// 最大筆數應該為userBetweenLimit * 2加上自己, 
				// 已5為例若該user名次不再整體排名的前五名也不再最後五名
				// 那就應該是5*2+1 取11筆資料
				// 但若是前五名, 則從0開始往後取max筆資料
				// 若是最後五名, 則從(userRank - userBetweenLimit)開始往前取max筆資料
				List<RankVo> firstRankings = personalRankingDao.findPersonalRankingsByLimit(userPersonalLimit, today);
				Set<RankVo> set = new LinkedHashSet<>();
				set.addAll(firstRankings);
				if(userRank != null) {
					Integer first = (userRank - userBetweenLimit) < 0 ? 0 : (userRank - userBetweenLimit);
					Integer max = userBetweenLimit * 2 + 1;
					set.addAll(personalRankingDao.findPersonalRankingsByLimit(first, max, today));
				}
				List<RankVo> resultRanks = new ArrayList<>(set);
				for(RankVo vo : resultRanks) {
					if(vo.getUserId().equals(userHa.getUserId())) {
						vo.setItself(true);
					}
				}
				result.setRanks(resultRanks);
				result.setFriendRanks(personalRankingDao.findByFriendUserId(userHa.getUserId()));
			}
		} catch (SecurityCodeException e) {
			return new GetpersonalrankingVo(e.getStatusCode());
		}
		return result;
	}

	@Override
	public SendtofriendVo sendToFriend(String registrationID, String secretKey, Long friendID) {
		try {
			UserHa sendUser = getUserHa(registrationID, secretKey);
			Date today = new Date();
			
			// 依據SendUserId去Data取得該使用者等級下一天可發送給好友的次數, 再到AtivityRecord檢查該user今天發送次數, 若已超過當日可發送次數則回傳StausCode 504
			Data sendFriendCountData = dataDao.findAllDataByHaType(sendUser.getUserType(), sendUser.getUserId(), HaUseTypeEnum.SEND_FRIEND_COUNT);
			if(sendFriendCountData != null) {
				Integer sendFriendCount = Integer.parseInt(sendFriendCountData.getDataValue());
				Integer activityRecordSendedNumber = userActivityRecordDao.countActivityRecordSendedNumber(sendUser.getUserId(), UserActivityTypeEnum.GIFT_FRIEND_HA, DateUtil.toDateInt(today));
				if(activityRecordSendedNumber >= sendFriendCount) {
					return new SendtofriendVo(StatusCodeEnum.STATUS_504);
				}
			}
			
			// 到AtivityRecord跟HaRecord檢查是否有送過給這位朋友, 若已發送過這位朋友則回傳StatusCode 502
			Integer activityRecordSendedCount = userActivityRecordDao.countActivityRecordSended(sendUser.getUserId(), UserActivityTypeEnum.GIFT_FRIEND_HA, DateUtil.toDateInt(today), friendID);
			Integer haRecordSendedCount = haRecordDao.countHaRecordSended(friendID, HaUseTypeEnum.RECEIVE_FRIEND_HA, DateUtil.toDateInt(today), sendUser.getUserId());
			if(activityRecordSendedCount > 0 || haRecordSendedCount > 0) {
				return new SendtofriendVo(StatusCodeEnum.STATUS_502);
			}
			
			// 發送心心的user寫一筆userActivityRecord
			userActivityRecordDao.insert(
						sendUser.getUserId(), UserActivityTypeEnum.GIFT_FRIEND_HA.name(), 
						UserDeviceTypeEnum.MOBILE.name(), DateUtil.toDateInt(today), 
						DateUtil.toTimeInt(today), null, "user", friendID);
			
			// 發送心心的user也獲得ha並寫入haRecord
			Data SendHaData = dataDao.findAllDataByHaType(sendUser.getUserType(), friendID, HaUseTypeEnum.SEND_FRIEND_HA);
			BigInteger sendHa = new BigInteger(SendHaData.getDataValue());
			haRecordDao.insert(
					sendUser.getUserId(), HaUseTypeEnum.SEND_FRIEND_HA.name(), null, 
					sendHa, DateUtil.toDateInt(today), 
					DateUtil.toTimeInt(today), friendID, null);
			userProfileDao.addHaByUserId(sendUser.getUserId(), sendHa, today);
			
			// 收到的心心的朋友獲得ha並寫入haRecord
			Data receiveHaData = dataDao.findAllDataByHaType(sendUser.getUserType(), friendID, HaUseTypeEnum.RECEIVE_FRIEND_HA);
			BigInteger receiveHa = new BigInteger(receiveHaData.getDataValue());
			haRecordDao.insert(
					friendID, HaUseTypeEnum.RECEIVE_FRIEND_HA.name(), null, 
					receiveHa, DateUtil.toDateInt(today), 
					DateUtil.toTimeInt(today), sendUser.getUserId(), null);
			userProfileDao.addHaByUserId(friendID, receiveHa, today);
			
			// 發送Notifaction給收到心心的朋友
			addNotifactionForSendToFriend(sendUser, receiveHa, friendID);
			return new SendtofriendVo(StatusCodeEnum.STATUS_0);
		} catch (SecurityCodeException e) {
			return new SendtofriendVo(e.getStatusCode());
		}
	}
	
	private void addNotifactionForSendToFriend(UserHa sendUser, BigInteger ha, Long friendID) {
		NotificationTypeEnum notificationType = NotificationTypeEnum.FRIEND;
		NotificationSetting notificationSetting = notificationSettingDao.findSendToFriendNotificationSetting(notificationType, sendUser.getUserType(), friendID);
		if(notificationSetting != null && !notificationSetting.getIsNotification()) {
			//IsNotification is false 代表該使用者不想接收到此Notifaction故不新增Notifaction
			return;
		}
		NotificationMaster nm = new NotificationMaster();
		nm.setTitle("朋友獎賞");
		nm.setContent("收到朋友 - " + sendUser.getName() + " 送來的心心, 共獲得了 " + ha + " 個HA!!");
		nm.setNotificationType(notificationType);
		nm.setType(NotificationSendTypeEnum.GCM);
		nm.setStatus(NotificationStatusEnum.Ready);
		notificationMasterDao.save(nm);
		
		List<UserDevices> userDevices = userDevicesDao.findByUserId(friendID);
		for(UserDevices userDevice : userDevices) {
			NotificationDetail nd = new NotificationDetail();
			nd.setNotificationMaster(nm);
			nd.setRetryCount(0);
			nd.setRegistrationId(userDevice.getDeviceKey());
			notificationDetailDao.save(nd);
		}
	}
	
}
