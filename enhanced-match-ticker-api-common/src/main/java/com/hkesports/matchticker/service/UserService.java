package com.hkesports.matchticker.service;

import java.util.Date;

import org.apache.camel.InOnly;

import com.hkesports.matchticker.enums.SubscriptionTypeEnum;
import com.hkesports.matchticker.vo.KeepaliveReqVo;
import com.hkesports.matchticker.vo.getcontestlimit.GetcontestlimitVo;
import com.hkesports.matchticker.vo.getha.GethaVo;
import com.hkesports.matchticker.vo.getnotification.GetnotificationVo;
import com.hkesports.matchticker.vo.getpersonalranking.GetpersonalrankingVo;
import com.hkesports.matchticker.vo.getpersonalrecord.GetpersonalrecordVo;
import com.hkesports.matchticker.vo.getsubscription.GetcontestantsubscriptionVo;
import com.hkesports.matchticker.vo.getsubscription.GetmatchsubscriptionVo;
import com.hkesports.matchticker.vo.makeguess.MakeGuessRequestVo;
import com.hkesports.matchticker.vo.makeguess.MakeguessVo;
import com.hkesports.matchticker.vo.readnotification.ReadnotificationVo;
import com.hkesports.matchticker.vo.sendtofriend.SendtofriendVo;
import com.hkesports.matchticker.vo.updatesubscription.UpdatesubscriptionVo;

/**
 * @author manboyu
 *
 */
public interface UserService {

	/**
	 * 取出notify資料後還會更新endUser的資料, 
	 * timestamp與visitDate做比較, 若不相同則更新visitDate,
	 * pollingDate則為當下時間
	 * 
	 * @param keepaliveReqVo
	 * @param instant
	 */
	@Deprecated
	@InOnly
	public void updateEndUserInfo(KeepaliveReqVo keepaliveReqVo, Date instant);
	
	/**
	 * API: /rest/emt/api/v1/getnotification
	 * @param registrationId
	 * @return
	 */
	public GetnotificationVo getNotification(String registrationId);
	
	/**
	 * 當呼叫API:/rest/emt/api/v1/getnotification 並往前端傳送後
	 * 以registrationId更新 NotificationDetail的 TimeSent
	 * @param registrationId
	 */
	@InOnly
	public void updateNotificationTimeSent(String registrationId);
	
	/**
	 * API: /rest/emt/api/v1/readnotification
	 * @param notificationID
	 * @param registrationId
	 * @return
	 */
	public ReadnotificationVo readNotification(Long notificationID, String registrationId);
	
	/**
	 * API: /rest/emt/api/v1/getha
	 * @param registrationId
	 * @param secretKey
	 * @return
	 */
	public GethaVo getHa(String registrationId, String secretKey);
	
	/**
	 * API: /rest/emt/api/v1/makeguess
	 * @param registrationId
	 * @param secretKey
	 * @return
	 */
	public MakeguessVo makeGuess(MakeGuessRequestVo vo);
	
	/**
	 * API: /rest/emt/api/v1/getcontestlimit
	 * @param registrationId
	 * @param secretKey
	 * @return
	 */
	public GetcontestlimitVo getContestLimit(String registrationId, String secretKey);
	
	/**
	 * API: /rest/emt/api/v1/updatecontestantsubscription
	 * and
	 * API: /rest/emt/api/v1/updatematchsubscription
	 * @param registrationId
	 * @param secretKey
	 * @param contestantID
	 * @param subscribe
	 * @return
	 */
	public UpdatesubscriptionVo updateSubscription(String registrationId, String secretKey, SubscriptionTypeEnum subscriptionType, Long contestantID, Boolean subscribe);
	
	/**
	 * API: /rest/emt/api/v1/getpersonalrecord
	 * @param registrationId
	 * @param secretKey
	 * @param year
	 * @param month
	 * @return
	 */
	public GetpersonalrecordVo getPersonalRecord(String registrationId, String secretKey, Integer year, Integer month);
	
	/**
	 * /rest/emt/api/v1/getcontestantsubscription
	 * @param registrationId
	 * @param secretKey
	 * @param team
	 * @return
	 */
	public GetcontestantsubscriptionVo getContestantSubscription(String registrationId, String secretKey, Boolean team);
	
	/**
	 * /rest/emt/api/v1/getmatchsubscription
	 * @param registrationId
	 * @param secretKey
	 * @return
	 */
	public GetmatchsubscriptionVo getMatchSubscription(String registrationId, String secretKey);
	
	/**
	 * API: /rest/emt/api/v1/getpersonalranking
	 * @param registrationId
	 * @param secretKey
	 * @return
	 */
	public GetpersonalrankingVo getPersonalRanking(String registrationId, String secretKey);
	
	/**
	 * API: /rest/emt/api/v1/sendtofriend
	 * 1. 首先依據SendUserId去Data取得該使用者等級下一天可發送給好友的次數,
	 * 	  再到AtivityRecord檢查該user今天發送次數,
	 *    若已超過當日可發送次數則回傳StausCode 504
	 * 2. 到AtivityRecord跟HaRecord檢查是否有送過給這位朋友,
	 *    若已發送過這位朋友則回傳StatusCode 502
	 * 3. 上述條件都通過就insert AtivityRecord及HaRecord,
	 *    並update userPofile的ha及totalha,
	 *    且寫到notification中
	 * 
	 * @param registrationId
	 * @param secretKey
	 * @param firendID
	 * @return
	 */
	public SendtofriendVo sendToFriend(String registrationId, String secretKey, Long firendID);
}
