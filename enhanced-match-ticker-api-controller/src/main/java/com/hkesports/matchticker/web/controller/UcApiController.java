package com.hkesports.matchticker.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hkesports.matchticker.enums.UcActionTypeEnum;
import com.hkesports.matchticker.utils.UCenter.UCenterUtil;
import com.hkesports.matchticker.vo.ResponseVo;

@RestController
@RequestMapping(value = "api")
public class UcApiController extends BasicController {
	private String API_RETURN_SUCCEED = "1";
	private String API_RETURN_FAILED = "-1";
	private String API_RETURN_FORBIDDEN = "-2";

	@RequestMapping(value = "/uc.php", method = RequestMethod.GET)
	public ResponseVo<String> gettournamentlist(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		
		if(StringUtils.isEmpty(code)){
			return new ResponseVo<>(API_RETURN_FAILED);
		}
		
		Map<String, String> map = bindStringToMap(UCenterUtil.ucAuthcode(code, "DECODE"));
		if(map.size() == 0){
			return new ResponseVo<>("Invalid Request");
		}
		
		if((UCenterUtil.time() - stringToLong(map.get("time"))) > 3600){
			return new ResponseVo<>("Authracation has expiried");
		}
		
		if(StringUtils.isEmpty(map.get("action"))){
			return new ResponseVo<>(API_RETURN_FAILED);
		}
		
		String returnVale = null;
		switch(UcActionTypeEnum.valueOf(map.get("action"))){
			case test:
				returnVale = API_RETURN_SUCCEED;
				break;
			case synlogin:
				returnVale = synlogin(response, map);
				break;
			case synlogout:
				returnVale = synlogout(response);
				break;
			case renameuser:
			case gettag:
			case updateclient:
			case updatepw:
			case updatebadwords:
			case updatehosts:
			case updateapps:
			case updatecredit:
			case getcreditsettings:
			case updatecreditsettings:
				returnVale = API_RETURN_SUCCEED;
				break;
			case deleteuser:
			default:
				returnVale = API_RETURN_FORBIDDEN;
				break;
		}
		
		return new ResponseVo<>(returnVale);
	}
	
	/**
	 * 同步登入, 目前用不到, 等需要時在加
	 * @param response
	 * @param map
	 * @return
	 */
	private String synlogin(HttpServletResponse response, Map<String, String> map){
//		User user = User.findByUcIdAndSourceType(map.uid, UserSourceType.UCenter);
//		if(!user){
//			List data = UCenterApiUtil.getUser(map.uid, 1);
//			if(data?.size() >= 3){
//				user = new User();
//				user.userId = data[0];
//				user.ucId = data[0];
//				user.account = data[1];
//				user.name = data[1];
//				user.email = data[2];
//				user.sourceType = UserSourceType.UCenter;
//			}else
//				return API_RETURN_FAILED;
//		}
//		
//		user.lastLonginTime = DateTimeUtil.getNowDate();
//		user.save(flush:true);
//		UCenterUtil.setUcCookie(response, Des3Utils.encryptForWeb(user.lastLonginTime.getTime().toString() + " " + map.uid), Holders.config.remember.time);
		return API_RETURN_SUCCEED;
	}
	
	/**
	 * 同步登出
	 * @param response
	 * @return
	 */
	private String synlogout(HttpServletResponse response){
		UCenterUtil.setUcCookie(response, "", 0);
		return API_RETURN_SUCCEED;
	}
	
	/**
	 * 將url params字串轉成Map
	 * @param str
	 * @return
	 */
	private static Map<String, String> bindStringToMap(String str){
		Map<String, String> map = new HashMap<String, String>();
		
		String[] strArray = str.split("&");
		
		for(int i = 0; i < strArray.length; i++){
			String[] data = strArray[i].split("=");
			if(data.length == 2)
				map.put(data[0], data[1]);
			else if(data.length == 1)
				map.put(data[0], "");
		}
		
		return map;
	}
	
	/**
	 * 字串轉Long型別數字
	 * @param str
	 * @return
	 */
	private long stringToLong(String str){
		try{
			return Long.parseLong(StringUtils.trim(str));
		}catch(Exception e){
			return 0L;
		}
	}
}
