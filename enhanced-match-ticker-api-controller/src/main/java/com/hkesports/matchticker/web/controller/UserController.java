package com.hkesports.matchticker.web.controller;

import javax.annotation.Resource;

import net.rossillo.spring.web.mvc.CacheControl;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.enums.SubscriptionTypeEnum;
import com.hkesports.matchticker.exception.SecurityCodeException;
import com.hkesports.matchticker.service.UserService;
import com.hkesports.matchticker.vo.ResponseVo;
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

@RestController
@RequestMapping(value = "rest/emt/api/v1")
public class UserController extends BasicController {
	
	@Resource(name="invokeGetUserNotify")
	private UserService invokeGetUserNotify;
	@Resource(name="invokeUpdateNotificationTimeSent")
	private UserService invokeUpdateNotificationTimeSent;
	@Resource(name="invokeReadNotification")
	private UserService invokeReadNotification;
	@Resource(name="invokeGetHa")
	private UserService invokeGetHa;
	@Resource(name="invokeMakeGuess")
	private UserService invokeMakeGuess;
	@Resource(name="invokeGetContestLimit")
	private UserService invokeGetContestLimit;
	@Resource(name="invokeUpdateSubscription")
	private UserService invokeUpdateSubscription;
	@Resource(name="invokeGetPersonalRecord")
	private UserService invokeGetPersonalRecord;
	@Resource(name="invokeGetContestantSubscription")
	private UserService invokeGetContestantSubscription;
	@Resource(name="invokeGetMatchSubscription")
	private UserService invokeGetMatchSubscription;
	@Resource(name="invokeGetPersonalRanking")
	private UserService invokeGetPersonalRanking;
	@Resource(name="invokeSendToFriend")
	private UserService invokeSendToFriend;
	
	@CacheControl
	@RequestMapping(value = "/getnotification", method = RequestMethod.GET)
	public ResponseVo<GetnotificationVo> getnotification(@RequestParam(value = "registrationID") String registrationID) {
		ResponseVo<GetnotificationVo> vo = new ResponseVo<>(invokeGetUserNotify.getNotification(registrationID));
		invokeUpdateNotificationTimeSent.updateNotificationTimeSent(registrationID);
		return vo;
	}
		
	@CacheControl
	@RequestMapping(value = "/readnotification", method = RequestMethod.GET)
	public ResponseVo<ReadnotificationVo> readnotification(@RequestParam(value = "registrationID") String registrationID, 
			@RequestParam(value = "notificationID") Long notificationID) {
		return new ResponseVo<>(invokeReadNotification.readNotification(notificationID, registrationID));
	}
	
	@CacheControl
	@RequestMapping(value = "/getha", method = RequestMethod.POST)
	public ResponseVo<GethaVo> getha(@RequestParam(value = "registrationID") String registrationID, 
			@RequestParam(value = "secretKey", required=false) String secretKey) {
		try {
			return new ResponseVo<>(invokeGetHa.getHa(registrationID, decode(registrationID, secretKey)));
		} catch (SecurityCodeException e) {
			logger.error("getha error!!", e);
			return new ResponseVo<>(new GethaVo(e.getStatusCode()));
		}
	}

	@CacheControl
	@RequestMapping(value = "/makeguess", method = RequestMethod.POST)
	public ResponseVo<MakeguessVo> makeguess(@ModelAttribute MakeGuessRequestVo requestVo) {
		if(requestVo==null || StringUtils.isBlank(requestVo.getRegistrationID())) {
			return new ResponseVo<>(new MakeguessVo(StatusCodeEnum.STATUS_303));
		}
		if(requestVo.getMatchID()==null || requestVo.getContestantID()==null || 
				requestVo.getGameNumber()==null || (requestVo.getHa()==null || requestVo.getHa().longValue() == 0)) {
			//競猜資料不完整 暫用 303
			return new ResponseVo<>(new MakeguessVo(StatusCodeEnum.STATUS_303));
		}
		String registrationID = requestVo.getRegistrationID();
		String secretKey = requestVo.getSecretKey();
		try {
			requestVo.setSecretKey(decode(registrationID, secretKey));
			return new ResponseVo<>(invokeMakeGuess.makeGuess(requestVo));
		} catch (SecurityCodeException e) {
			logger.error("makeguess error!!", e);
			return new ResponseVo<>(new MakeguessVo(e.getStatusCode()));
		}
	}

	@CacheControl
	@RequestMapping(value = "/getcontestlimit", method = RequestMethod.POST)
	public ResponseVo<GetcontestlimitVo> getcontestlimit(@RequestParam("registrationID") String registrationID, @RequestParam(value = "secretKey", required = false) String secretKey) {
		try {
			return new ResponseVo<>(invokeGetContestLimit.getContestLimit(registrationID, decode(registrationID, secretKey)));
		} catch (SecurityCodeException e) {
			logger.error("getcontestlimit error!!", e);
			return new ResponseVo<>(new GetcontestlimitVo(e.getStatusCode()));
		}
	}
	
	@CacheControl
	@RequestMapping(value = "/updatecontestantsubscription", method = RequestMethod.POST)
	public ResponseVo<UpdatesubscriptionVo> updatecontestantsubscription(@RequestParam("registrationID") String registrationID, 
			@RequestParam(value = "secretKey", required = false) String secretKey,
			@RequestParam("team") Boolean team,
			@RequestParam(value = "contestantID") Long contestantID,
			@RequestParam(value = "subscribe", required = false) Boolean subscribe) {
		try {
			SubscriptionTypeEnum subscriptionType = BooleanUtils.isTrue(team) ? SubscriptionTypeEnum.TEAM : SubscriptionTypeEnum.PLAYER;
			return new ResponseVo<>(invokeUpdateSubscription.updateSubscription(registrationID, decode(registrationID, secretKey), subscriptionType, contestantID, subscribe));
		} catch (SecurityCodeException e) {
			logger.error("updatecontestantsubscription error!!", e);
			return new ResponseVo<>(new UpdatesubscriptionVo(e.getStatusCode()));
		}
	}
	
	@CacheControl
	@RequestMapping(value = "/updatematchsubscription", method = RequestMethod.POST)
	public ResponseVo<UpdatesubscriptionVo> updatematchsubscription(@RequestParam("registrationID") String registrationID, 
			@RequestParam(value = "secretKey", required = false) String secretKey,
			@RequestParam(value = "matchID") Long matchID,
			@RequestParam(value = "subscribe", required = false) Boolean subscribe) {
		try {
			return new ResponseVo<>(invokeUpdateSubscription.updateSubscription(registrationID, decode(registrationID, secretKey), SubscriptionTypeEnum.MATCH, matchID, subscribe));
		} catch (SecurityCodeException e) {
			logger.error("updatematchsubscription error!!", e);
			return new ResponseVo<>(new UpdatesubscriptionVo(e.getStatusCode()));
		}
	}
	
	@CacheControl
	@RequestMapping(value = "/getcontestantsubscription", method = RequestMethod.POST)
	public ResponseVo<GetcontestantsubscriptionVo> getcontestantsubscription(@RequestParam("registrationID") String registrationID, 
			@RequestParam(value = "secretKey", required = false) String secretKey, @RequestParam(value = "team", required = false) Boolean team) {
		try {
			return new ResponseVo<>(invokeGetContestantSubscription.getContestantSubscription(registrationID, decode(registrationID, secretKey), team));
		} catch (SecurityCodeException e) {
			logger.error("getcontestantsubscription error!!", e);
			return new ResponseVo<>(new GetcontestantsubscriptionVo(e.getStatusCode()));
		}
	}
	
	@CacheControl
	@RequestMapping(value = "/getmatchsubscription", method = RequestMethod.POST)
	public ResponseVo<GetmatchsubscriptionVo> getmatchsubscription(@RequestParam("registrationID") String registrationID, 
			@RequestParam(value = "secretKey", required = false) String secretKey) {
		try {
			return new ResponseVo<>(invokeGetMatchSubscription.getMatchSubscription(registrationID, decode(registrationID, secretKey)));
		} catch (SecurityCodeException e) {
			logger.error("getmatchsubscription error!!", e);
			return new ResponseVo<>(new GetmatchsubscriptionVo(e.getStatusCode()));
		}
	}
	
	@CacheControl
	@RequestMapping(value = "/getpersonalrecord", method = RequestMethod.POST)
	public ResponseVo<GetpersonalrecordVo> getpersonalrecord(@RequestParam("registrationID") String registrationID, 
			@RequestParam(value = "secretKey", required = false) String secretKey,
			@RequestParam(value = "Year", required = false) Integer year, @RequestParam(value = "Month", required = false) Integer month) {
		try {
			return new ResponseVo<>(invokeGetPersonalRecord.getPersonalRecord(registrationID, decode(registrationID, secretKey), year, month));
		} catch (SecurityCodeException e) {
			logger.error("getpersonalrecord error!!", e);
			return new ResponseVo<>(new GetpersonalrecordVo(e.getStatusCode()));
		}
	}
	
	@CacheControl
	@RequestMapping(value = "/getpersonalranking", method = RequestMethod.POST)
	public ResponseVo<GetpersonalrankingVo> getpersonalranking(@RequestParam("registrationID") String registrationID, @RequestParam(value = "secretKey", required = false) String secretKey) {
		try {
			return new ResponseVo<>(invokeGetPersonalRanking.getPersonalRanking(registrationID, decode(registrationID, secretKey)));
		} catch (SecurityCodeException e) {
			logger.error("getcontestlimit error!!", e);
			return new ResponseVo<>(new GetpersonalrankingVo(e.getStatusCode()));
		}
	}
	
	@CacheControl
	@RequestMapping(value = "/sendtofriend", method = RequestMethod.POST)
	public ResponseVo<SendtofriendVo> sendtofriend(@RequestParam("registrationID") String registrationID, @RequestParam("secretKey") String secretKey, @RequestParam("firendID") Long firendID) {
		return new ResponseVo<>(invokeSendToFriend.sendToFriend(registrationID, secretKey, firendID));
	}
}
