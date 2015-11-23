package com.hkesports.matchticker.utils.UCenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UCenterApiUtil extends UCenterUtil {
	/**
	 * 使用者註冊
	 * @param username
	 * @param password
	 * @param email
	 * @return User ID, 值小於0時註冊失敗, -1: 用戶名不合法, -2: 包含不允許注冊的詞語, -3: 用戶名已存在, -4: email格式有誤, -5: email不允許注冊, -6: 該mail已被註冊
	 */
	public static List<String> userRegister(String username, String password, String email){
		return userRegister(username, password, email, "", "");
	}
	
	/**
	 * 使用者註冊
	 * @param username
	 * @param password
	 * @param email
	 * @param questionid 安全提問
	 * @param answer 安全提問答案
	 * @return User ID, 值小於0時註冊失敗, -1: 用戶名不合法, -2: 包含不允許注冊的詞語, -3: 用戶名已存在, -4: email格式有誤, -5: email不允許注冊, -6: 該mail已被註冊
	 */
	public static List<String> userRegister(String username, String password, String email, String questionid, String answer) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("username", username);
		args.put("password", password);
		args.put("email", email);
		args.put("questionid", questionid);
		args.put("answer", answer);
		
		return ucApiPost("user", "register", args);
	}
	
	/**
	 * 使用者登入
	 * @param username 帳號或id
	 * @param password 密碼
	 * @return array(uid/status, username, password, email, 是否重名) uid/status的判斷方式為 >0:uid, -1:用戶不存在, -2:密碼錯誤, -3:安全問答錯誤
	 */
	public static List<String> userLogin(String username, String password){
		return userLogin(username, password, 0, 0);
	}
	
	/**
	 * 
	 * @param username		帳號或id
	 * @param password		密碼
	 * @param isuid			是否為uid
	 * @param checkques		是否使用安全問答
	 * @return array(uid/status, username, password, email, 是否重名) uid/status的判斷方式為 >0:uid, -1:用戶不存在, -2:密碼錯誤, -3:安全問答錯誤
	 */
	public static List<String> userLogin(String username, String password, int isuid , int checkques ){
		return userLogin(username, password, isuid, checkques, "","");
	}
	
	/**
	 * 使用者登入
	 * @param username		帳號或id
	 * @param password		密碼
	 * @param isuid			是否為uid
	 * @param checkques		是否使用安全問答
	 * @param questionid	安全問答題目
	 * @param answer		安全問答答案
	 * @return array(uid/status, username, password, email, 是否重名) uid/status的判斷方式為 >0:uid, -1:用戶不存在, -2:密碼錯誤, -3:安全問答錯誤
	 */
	public static List<String> userLogin(String username, String password, int isuid , int checkques , String questionid, String answer) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("username", username);
		args.put("password", password);
		args.put("isuid", isuid);
		args.put("checkques", checkques);
		args.put("questionid", questionid);
		args.put("answer", answer);
		
		return ucApiPost("user", "login", args);
	}
	
	/**
	 * 同步登入
	 * @param uid
	 * @return HTML page
	 */
	public static void userSynlogin(String uid) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("uid", uid);
		synClients(ucApiPost("user", "synlogin", args).get(0));
	}
	
	/**
	 * 同步登出
	 * @return HTML page
	 */
	public static void ucUserSynlogout() {
		synClients(ucApiPost("user", "synlogout", null).get(0));
	}
	
	/**
	 * 取得user資料
	 * @param username	帳號
	 * @param isuid		是否為uid, 1: user id, 0: user name
	 * @return array	(uid, username, email)
	 */
	public static List<String> getUser(String username, int isuid) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("username", username);
		args.put("isuid", isuid);
		return ucApiPost("user", "get_user", args);
	}
	
	/**
	 * 修改使用者資料
	 * @param username		帳號
	 * @param oldpw			舊密碼
	 * @param newpw			新密碼
	 * @param email			E-mail
	 * @param ignoreoldpw	是否忽略舊密碼檢查
	 * @param questionid	安全問答題目
	 * @param answer		安全問答答案
	 * @return int			1: 修改成功, 0:沒有任何修改, -1:舊密碼不正確, -4:email格式有誤, -5:email不準許註冊, -6:email已被註冊, -7:沒有作任何修改, -8:受保護的用戶不能修改
	 */
	public static List<String> userEdit(String username, String oldpw, String newpw, String email, int ignoreoldpw, String questionid, String answer) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("username", username);
		args.put("oldpw", oldpw);
		args.put("newpw", newpw);
		args.put("email", email);
		args.put("ignoreoldpw", ignoreoldpw);
		args.put("questionid", questionid);
		args.put("answer", answer);
		
		return ucApiPost("user", "edit", args);
	}
	
	/**
	 * 刪除使用者
	 * @param uid	帳號
	 * @return int	>0:成功, 0:失敗
	 */
	public static List<String> userDelete(String uid) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("uid", uid);
		return ucApiPost("user", "delete", args);
	}
	
	/**
	 * 刪除使用者大頭照
	 * @param uid	帳號
	 * @return 未知
	 */
	public static List<String> userDeleteAvatar(String uid) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("uid", uid);
		return ucApiPost("user", "deleteavatar", args);
	}
	
	/**
	 * 檢查用戶名是否可使用
	 * @param name
	 * @return 1:成功, -1:用戶名不合法, -2:包含要允許註冊的詞語, -3:用戶名已經存在
	 */
	public static List<String> userCheckName(String name){
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("username", name);
		return ucApiPost("user", "check_username", args);
	}
	
	/**
	 * 檢查Email是否可使用
	 * @param email
	 * @return 1:成功, -4:Email 格式有誤, -5:Email 不允許註冊, -6:該 Email 已經被註冊
	 */
	public static List<String> userCheckEmail(String email){
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("email", email);
		return ucApiPost("user", "check_email", args);
	}
}
