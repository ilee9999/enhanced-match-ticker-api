package com.hkesports.matchticker.enums;

public enum StatusCodeEnum {

	STATUS_0(0, "Success", "成功"),
	STATUS_10(10, "Failed", "失敗"),
	STATUS_11(11, "Failed, Facebook ID you supplied is invalid", "失敗,你所提交之面書帳號不正確"),
	STATUS_12(12, "Thank you for your support, your past support for this team has already been logged.", "多謝支持,你對上一次對這一隊的支持已經被記錄在案"),
	STATUS_301(301, "Failed for unknown reason, likely caused by master exception listener of spring.", "失敗"),
	STATUS_302(302, "DB unavailable. Please try again later. Sorry for any inconvenient that might have caused. Thank you for your undeerstanding.", "數據庫失靈,萬分抱歉,請稍後再試,請見諒.")
	;
	
	private int value;
	private String meaning;
	private String description;
	
	private StatusCodeEnum(int value, String meaning, String description) {
		this.value = value;
		this.meaning = meaning;
		this.description = description;
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
