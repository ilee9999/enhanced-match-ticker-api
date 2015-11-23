package com.hkesports.matchticker.enums;


public enum StatusCodeEnum {

	//基本
	STATUS_0(0, "Success", "成功"),
	STATUS_10(10, "Failed", "失敗"),
	
	//request 相關
	STATUS_101(101, "registrationId is null", "缺少 registrationId"),
	STATUS_102(102, "secretKey is null", "缺少 secretKey"),
	STATUS_103(103, "deviceKey not legitimate", "該deviceKey不合法"),
	
	STATUS_111(111, "registrationId is not get device", "該registrationId找不到裝置"),
	STATUS_112(112, "is not get device", "找不到裝置"),
	STATUS_113(113, "is not get user", "找不到使用者"),
	STATUS_114(114, "Inconsistent date of birth", "生日與使用者不一致"),
	STATUS_115(115, "Login failed, account or password incorrect", "登入失敗, 帳號或密碼錯誤"),
	STATUS_116(116, "Login failed, Facebook account not exist", "登入失敗, Facebook帳號不存在系統中"),
	STATUS_117(117, "language failed", "語系錯誤"),
	
	//sucerityCode相關
	STATUS_201(201, "sucerityCode is null", "未設定安全碼"),
	STATUS_202(202, "sucerityCode is expired date", "安全碼已過期"),
	STATUS_203(203, "sucerityCode is not get device", "該安全碼找不到裝置"),
	STATUS_204(204, "Inconsistent registrationId sucerityCode and device", "該安全碼與裝置的registrationId不一致"),
	STATUS_205(205, "device is not active", "該安全碼的裝置已停用"),
	STATUS_206(206, "secretKey not legitimate", "secretKey不合法"),
	
	//通用
	STATUS_300(300, "Failed for link UCenter, Please try again later", "連線UCenter失敗"),
	STATUS_301(301, "Failed for unknown reason, likely caused by master exception listener of spring.", "失敗"),
	STATUS_302(302, "DB unavailable. Please try again later. Sorry for any inconvenient that might have caused. Thank you for your undeerstanding.", "數據庫失靈,萬分抱歉,請稍後再試,請見諒."),
	STATUS_303(303, "Failed, Request data not legitimate", "失敗, 資料不合法"),
	STATUS_304(304, "Restore Fails", "去鹽還原資料失敗"),
	STATUS_305(305, "Decryption failure", "解密失敗"),
	
	//待驗證使用者相關
	STATUS_401(401, "secretKey is not get wait verify user", "該secretKey找不到未驗證Mail的使用者"),
	STATUS_402(402, "Inconsistent registrationId sucerityCode and wait verify user", "該安全碼與未驗證Mail的使用者的registrationId不一致"),
	STATUS_403(403, "the wait verify user is not active", "該未驗證Mail的使用者已被註銷"),
	STATUS_404(404, "verify code is not get wait verify user", "該驗證碼找不到未驗證Mail的使用者"),
	STATUS_405(405, "verify code is expired date", "該驗證碼已過期"),
	STATUS_406(406, "verify code not legitimate", "該驗證碼不合法"),
	
	//使用者註冊相關
	STATUS_411(411, "failed, account not legitimate", "失敗，帳號不合法"),
	STATUS_412(412, "Registration Failed, username already exist", "註冊失敗，用戶名稱已經存在"),
	STATUS_413(413, "Registration Failed, username already exist on wait verify user", "註冊失敗，用戶名稱已經被待驗證使用者使用"),
	STATUS_414(414, "Registration Failed, username already exist on UCenter", "註冊失敗，用戶名稱已經存在UCenter"),
	STATUS_415(415, "failed, email not legitimate", "失敗，電郵不合法"),
	STATUS_416(416, "Registration Failed, email already exist", "註冊失敗，用戶電郵已經存在"),
	STATUS_417(417, "Registration Failed, email already exist on wait verify user", "註冊失敗，用戶電郵已經被待驗證使用者使用"),
	STATUS_418(418, "Registration Failed, email already exist on UCenter", "註冊失敗，用戶電郵已經存在UCenter"),
	STATUS_419(419, "Registration Failed, Facebook account already exist", "註冊失敗，Facebook帳號已經存在"),
	STATUS_420(420, "Failed, Facebook ID you supplied is invalid", "失敗,你所提交之Facebook帳號不正確"),
	STATUS_421(421, "Failed, Facebook account when you submit your registration is inconsistent with a Facebook account", "失敗,你所提交之Facebook帳號與您註冊時所用的Facebook帳號不一致"),
	STATUS_422(422, "Registration Failed, Failed on UCenter", "註冊失敗，註冊到UCenter失敗"),
	STATUS_423(423, "Connect Facebook Failed, email already exist", "串接Facebook失敗，用戶電郵已經存在"),
	
	//權限相關
	STATUS_501(501, "Ha not sufficient to make the guess", "競猜失敗，你戶口中的ha不足夠"),
	STATUS_502(502, "Failed, You cannot give anymore ha to this friend", "失敗，你不能再送ha給這位朋友"),
	STATUS_503(503, "Thank you for your support, your past support for this team has already been logged.", "多謝支持,你對上一次對這一隊的支持已經被記錄在案"),
	STATUS_504(504, "Failed, You have exceeded the number of times that each day can send to friend", "失敗，你已超過當日可發送禮物次數")
	;
	
	private int value;
	private String meaning;
	private String description;
	
	private StatusCodeEnum(int value, String meaning, String description) {
		this.value = value;
		this.meaning = meaning;
		this.description = description;
	}
	
	public static StatusCodeEnum convertEnumFromCode(int statusCode) {
		for (StatusCodeEnum obj : StatusCodeEnum.values()) {
			if(obj.getValue() == statusCode) {
				return obj;
			}
		}
		return null;
	}

	public int getValue() {
		return value;
	}

	public String getMeaning() {
		return meaning;
	}

	public String getDescription() {
		return description;
	}
	
}
