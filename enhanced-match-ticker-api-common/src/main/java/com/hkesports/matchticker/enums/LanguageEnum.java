package com.hkesports.matchticker.enums;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * 語系
 */
public enum LanguageEnum {
	EN("en", Locale.ENGLISH),
	TW("zh-tw", Locale.TAIWAN);
	
	private String description;
	private Locale locale;
	
	private LanguageEnum(String language, Locale locale){
		this.description = language;
		this.locale = locale;
	}
	
	public static LanguageEnum getLanguage(String name) {
		for (LanguageEnum obj : LanguageEnum.values()) {
			if (StringUtils.equals(obj.getDescription(), name)) {
				return obj;
			}
		}
		return LanguageEnum.EN;
	}

	public String getDescription() {
		return description;
	}

	public Locale getLocale() {
		return locale;
	}
}
