package com.hkesports.matchticker.enums;

public enum CompetitionSystemEnum {
	/**
	 * Circular 循環
	 */
	C("C", "循環賽"),
	/**
	 * Group Knockout 勝敗組淘汰
	 */
	GK("GK", "勝敗組淘汰賽"),
	
	/**
	 * Regular Knockout 一般淘汰
	 */
	RK("RK", "一般淘汰賽"),
	
	/**
	 * Double Eliminiation 雙敗淘汰賽
	 */
	DE("DE", "雙敗淘汰賽")
	;
	
	private String value;
	private String desc;
	
	private CompetitionSystemEnum(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
}
