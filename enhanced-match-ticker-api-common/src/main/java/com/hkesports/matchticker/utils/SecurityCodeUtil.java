package com.hkesports.matchticker.utils;

import java.util.Calendar;
import java.util.Date;

import com.hkesports.matchticker.exception.SecurityCodeException;

/**
 * 供/rest/auth/v1/getcode使用, 取code及解碼
 */
public class SecurityCodeUtil {
	//最大切片長度
	private static int MAX_SPLIT_SIZE = 4;
	//排序方式, 空字串: 不修改排序, H: 前後互換, I: 倒排序
	private static String[] SEQUENCE_KEYS = {"", "H", "I"};
	//最大亂碼長度
	private static int MAX_RANDOM_CODE_SIZE = 200;
	//最小亂碼長度
	private static int MIN_RANDOM_CODE_SIZE = 100;
	//亂碼庫
	private static String[] RANDOM_CODES = {
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
		"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
		"~", "@", "#", "%", "^", "*", "-", "_"
	};
	
	/**
	 * 取code
	 * @return
	 */
	public static String getCode(){
		//取得切片長度
		int splitSize = getRandomSize(MAX_SPLIT_SIZE) + 1;
		
		//取得排序方式 
		String sequenceKey = null;
		if(splitSize == MAX_SPLIT_SIZE)
			sequenceKey = SEQUENCE_KEYS[getRandomSize(SEQUENCE_KEYS.length - 1) + 1];
		else
			sequenceKey = SEQUENCE_KEYS[getRandomSize(SEQUENCE_KEYS.length)];
		
		//取得亂碼長度
		int randomCodeSize = getRandomCodeSize();
		
		//組成code
		return bindCode(randomCodeSize, splitSize, sequenceKey);
	}
	
	/**
	 * 取得Code的過期時間
	 * @return
	 */
	public static Date getExpiredDate(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 1);
		return c.getTime();
	}
	
	/**
	 * 編碼
	 * @param str	要編碼的資料
	 * @param code	加密KEY, 經由加密時的getCode取得
	 * @return
	 */
	public static String encoder(String str, String code) throws SecurityCodeException {
		str = performSorts(str, getSequenceKey(code));
		return insertRandomCode(str, code);
	}
	
	/**
	 * 解碼
	 * @param encoderString		要解碼的資料
	 * @param code				加密KEY, 經由加密時的getCode取得
	 * @return
	 */
	public static String decode(String encoderString, String code) throws SecurityCodeException {
		//去除亂碼
		encoderString = removeRandomCode(encoderString, code);
		//還原排序
		return performSorts(encoderString, getSequenceKey(code));
	}
	
	/**
	 * 取得隨機數字
	 * @param maxSize	亂碼的範圍, 0 ~ maxSize以下
	 * @return
	 */
	private static int getRandomSize(int maxSize) {
		return (int) (Math.random() * 100 % maxSize);
	}
	
	/**
	 * 取得亂碼長度
	 * @return
	 */
	private static int getRandomCodeSize(){
		int randomCodeSize = getRandomSize(MAX_RANDOM_CODE_SIZE) + 1;
		if(randomCodeSize < MIN_RANDOM_CODE_SIZE)
			randomCodeSize = randomCodeSize + MIN_RANDOM_CODE_SIZE;
		return randomCodeSize;
	}
	
	/**
	 * 取得指定長度的亂碼
	 * @param size
	 * @return
	 */
	public static String getRandomCode(int size){
		StringBuilder code = new StringBuilder();
		for(int i = 0; i < size; i++){
			code.append(RANDOM_CODES[getRandomSize(RANDOM_CODES.length)]);
		}
		
		return code.toString();
	}
	
	/**
	 * 組成code
	 * @param randomCodeSize	亂碼長度
	 * @param splitSize			資料切片長度
	 * @param sequenceKey		排序碼
	 * @return
	 */
	private static String bindCode(int randomCodeSize, int splitSize, String sequenceKey){
		StringBuilder code = new StringBuilder();
		for(int i = 0; i < randomCodeSize; i++){
			code.append(RANDOM_CODES[getRandomSize(RANDOM_CODES.length)]);
		}
		if(splitSize != 0)
			code.append(splitSize);
		code.append(sequenceKey);
		
		return code.toString();
	}
	
	/**
	 * 從code取得切片長度
	 * @param code
	 * @return
	 * @throws SecurityCodeException
	 */
	private static int getSplitSizeByCode(String code) {
		int splitSize = -1;
		String str = code.substring(code.length() - 1);
		for(String sequenceKey : SEQUENCE_KEYS){
			if(sequenceKey.equals(str)){
				str = code.substring(code.length() - 2, code.length() - 1);
				break;
			}
		}
		
		try{
			splitSize = Integer.valueOf(str);
		}catch(Exception e){}
		
		return splitSize;
	}
	
	/**
	 * 取得排序方式 
	 * @param code
	 * @return
	 */
	private static String getSequenceKey(String code) {
		String sequenceKey = code.substring(code.length() - 1);
		
		boolean isLegitimate = false;
		for(String sKey : SEQUENCE_KEYS){
			if(sKey.equals(sequenceKey)){
				isLegitimate = true;
				break;
			}
		}
		
		return isLegitimate ? sequenceKey : "";
	}
	
	/**
	 * 插入亂碼
	 * @param encoderString		要插入亂碼的字串
	 * @param code
	 * @return
	 */
	private static String insertRandomCode(String encoderString, String code){
		int splitSize = getSplitSizeByCode(code);
		//沒有加入亂碼
		if(splitSize == -1)
			return encoderString;
		
		StringBuilder decodeSb = new StringBuilder();
		int idx = 0;
		int codeIdx = 0;
		while (idx < encoderString.length()) {
			//先插入原文
			int endIdx = idx + splitSize;
			if(endIdx > encoderString.length())
				endIdx = encoderString.length();
			decodeSb.append(encoderString.substring(idx, endIdx));
			idx += splitSize;
			//放入亂碼
			if(idx < encoderString.length()){
				decodeSb.append(code.substring(codeIdx, codeIdx + 1));
				codeIdx++;
			}
		}
		return decodeSb.toString();
	}
	
	/**
	 * 去除亂碼
	 * @param encoderString		含有亂碼的字串
	 * @param code
	 * @return
	 */
	private static String removeRandomCode(String encoderString, String code) throws SecurityCodeException {
		int splitSize = getSplitSizeByCode(code);
		//沒有加入亂碼
		if(splitSize == -1)
			return encoderString;
		
		StringBuilder decodeSb = new StringBuilder();
		int idx = 0;
		int codeIdx = 0;
		while (idx < encoderString.length()) {
			int endIdx = idx + splitSize;
			if(endIdx > encoderString.length())
				endIdx = encoderString.length();
			decodeSb.append(encoderString.substring(idx, endIdx));
			idx += splitSize + 1;
			//檢核亂碼
			if(endIdx != encoderString.length()){
				String randomCode = code.substring(codeIdx, codeIdx + 1);
				String checkCode = encoderString.substring(endIdx, endIdx + 1);
				codeIdx++;
				if(!checkCode.equals(randomCode))
					throw new SecurityCodeException("還原資料失敗, 不合法的資料");
			}
		}
		return decodeSb.toString();
	}
	
	/**
	 * 執行排序
	 * @param encoderString		要排序的字串
	 * @param sequenceKey		排序方式 
	 * @return
	 */
	private static String performSorts(String encoderString, String sequenceKey) throws SecurityCodeException {
		//沒有改變排序
		if("".equals(sequenceKey))
			return encoderString;
		
		StringBuilder decodeSb = new StringBuilder();
		if("H".equals(sequenceKey)){
			//前後互換
			int encoderSize = encoderString.length();
			int centerIdx = encoderSize / 2;
			if(encoderSize % 2 == 0){
				decodeSb.append(encoderString.substring(centerIdx, encoderSize)).append(encoderString.substring(0, centerIdx));
			}else{
				decodeSb.append(encoderString.substring(centerIdx + 1, encoderSize));
				decodeSb.append(encoderString.substring(centerIdx, centerIdx + 1));
				decodeSb.append(encoderString.substring(0, centerIdx));
			}
		}else if("I".equals(sequenceKey)){
			//倒排
			for(int i = encoderString.length() - 1; i >= 0; i--){
				decodeSb.append(encoderString.substring(i, i + 1));
			}
		}else{
			 throw new SecurityCodeException("解析CODE失敗, 不合法的CODE");
		}
		
		return decodeSb.toString();
	}
	
	//test
//	public static void main(String[] args) throws SecurityCodeException {
//		for(int i = 0; i < 100; i++){
//			String data = bindCode(12, 0, "");
//			String code = getCode();
//			String encoder = encoder(data, code);
//			
//			System.out.println("DATA:    " + data);
//			System.out.println("CODE:    " + code);
//			System.out.println("encoder: " + encoder);
//			System.out.println("decode:  " + decode(encoder, code));
//			System.out.println("----------------");
//		}
//		
////		API文件裡的範例測試
//		System.out.println("encoder: " + encoder("asdfghjk", "q6c2"));
//		System.out.println("decode: " + decode("asqdf6ghcjk", "q6c2"));
//		System.out.println("encoder: " + encoder("asdfghjk", "qhgdfhH"));
//		System.out.println("decode: " + decode("ghjkasdf", "qhgdfhH"));
//		System.out.println("encoder: " + encoder("asdfghjkl", "asg3253aH"));
//		System.out.println("decode: " + decode("hjklgasdf", "asg3253aH"));
//		System.out.println("encoder: " + encoder("asdfghjk", "7t32H"));
//		System.out.println("decode: " + decode("gh7jktas3df", "7t32H"));
//		System.out.println("encoder: " + encoder("asdfghjkl", "qwer78941H"));
//		System.out.println("decode: " + decode("hqjwkelrg7a8s9d4f", "qwer78941H"));
//		System.out.println("encoder: " + encoder("asdfghjk", "asqrewtI"));
//		System.out.println("decode: " + decode("kjhgfdsa", "asqrewtI"));
//		System.out.println("encoder: " + encoder("asdfghjk", "1592I"));
//		System.out.println("decode: " + decode("kj1hg5fd9sa", "1592I"));
//		System.out.println("encoder: " + encoder("asdfghjk", "q6c8412"));
//		System.out.println("decode: " + decode("asqdf6ghcjk", "q6c8412"));
//		System.out.println("encoder: " + encoder("asdfghjkl", "q6c8412"));
//		System.out.println("decode: " + decode("asqdf6ghcjk8l", "q6c8412"));
//	}
}
