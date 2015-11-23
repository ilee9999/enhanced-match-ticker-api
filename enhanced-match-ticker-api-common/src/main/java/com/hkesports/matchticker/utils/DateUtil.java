package com.hkesports.matchticker.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 常用日期方法
 * 
 * @author manboyu
 *
 */
public class DateUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	private static final String DEFAULT_FORMAT = "yyyy/MM/dd";

	private static ThreadLocal<DateFormat> THREADLOCAL = new ThreadLocal<DateFormat>();

	public final static ThreadLocal<SimpleDateFormat> yyyyMMdd = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> HHmmss = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("HHmmss");
		}
	};

	/**
	 * 初始DateFormat
	 * 
	 * @param format
	 * @return
	 */
	public static DateFormat getDateFormat() {
		DateFormat df = THREADLOCAL.get();
		if (df == null) {
			df = new SimpleDateFormat();
			THREADLOCAL.set(df);
		}
		return df;
	}

	/**
	 * 比較src是否在target之前
	 * 
	 * @param src
	 * @param target(String)
	 * @return
	 */
	public static boolean before(String src, String target) {
		return before(src, target, DEFAULT_FORMAT);
	}

	/**
	 * 比較src是否在target之前
	 * 
	 * @param src
	 * @param target(String)
	 * @param format
	 * @return
	 */
	public static boolean before(String src, String target, String format) {
		try {
			return before(src, parserStringToDate(target, format), format);
		} catch (Exception e) {
			logger.error("DateUtils.before - " + src + " 日期parse失敗 : ", e);
		}
		return false;
	}

	/**
	 * 比較src是否在target之前
	 * 
	 * @param src
	 * @param target(Date)
	 * @return
	 * @throws ParseException
	 */
	public static boolean before(String src, Date target) throws ParseException {
		return before(src, target, DEFAULT_FORMAT);
	}

	/**
	 * 比較src是否在target之前
	 * 
	 * @param src
	 * @param target(Date)
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static boolean before(String src, Date target, String format) throws ParseException {
		Date srcDate = parserStringToDate(src, format);
		Calendar cal1 = Calendar.getInstance();
		clearTime(cal1, target);
		Calendar cal2 = Calendar.getInstance();
		clearTime(cal2, srcDate);
		return srcDate.getTime() < target.getTime();
	}

	/**
	 * 兩日期相減所得結果天數
	 * 
	 * @param src
	 * @param target
	 * @return
	 */
	public static int getTwoDateSubtract(Date src, Date target) {
		Calendar calendar = Calendar.getInstance();
		clearTime(calendar, target);
		long targetTime = calendar.getTimeInMillis();
		clearTime(calendar, src);
		long srcTime = calendar.getTimeInMillis();
		return (int) ((srcTime - targetTime) / (1000 * 60 * 60 * 24));
	}

	private static void clearTime(Calendar cal, Date date) {
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * 字串轉日期
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date parserStringToDate(String dateString) {
		return parserStringToDate(dateString, DEFAULT_FORMAT);
	}

	/**
	 * 字串轉日期
	 * 
	 * @param dateString
	 * @param format
	 * @return
	 */
	public static Date parserStringToDate(String dateString, String format) {
		if (StringUtils.isBlank(dateString)) {
			return null;
		}
		try {
			SimpleDateFormat sdf = (SimpleDateFormat) getDateFormat();
			sdf.applyPattern(format);
			return sdf.parse(dateString);
		} catch (Exception e) {
			logger.error("[DateUtil.parserStringToDate] => 發生錯誤!", e);
			return null;
		}
	}

	/**
	 * 日期轉字串
	 * 
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static String parserDateToString(Date date) {
		if (date != null) {
			return parserDateToString(date, DEFAULT_FORMAT);
		} else {
			return StringUtils.EMPTY;
		}
	}

	/**
	 * 日期轉字串
	 * 
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static String parserDateToString(Date date, String format) {
		if (date != null) {
			SimpleDateFormat sdf = (SimpleDateFormat) getDateFormat();
			sdf.applyPattern(format);
			return sdf.format(date);
		} else {
			return StringUtils.EMPTY;
		}
	}

	/**
	 * 調整時間
	 * 
	 * @param date
	 *            原始時間
	 * @param type
	 *            調整的時間部位
	 * @param variable
	 *            調整量
	 * @return
	 */
	public static Date addTime(Date date, int type, int variable) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(type, c.get(type) + variable);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Integer toDateInt(Date date) {
		return Integer.parseInt(yyyyMMdd.get().format(date));
	}

	public static Integer toTimeInt(Date date) {
		return Integer.parseInt(HHmmss.get().format(date));
	}
}
