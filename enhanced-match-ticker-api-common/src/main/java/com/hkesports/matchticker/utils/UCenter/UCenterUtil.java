package com.hkesports.matchticker.utils.UCenter;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UCenterUtil {
	public static String COOKIE_KEY_NAME = "uc_syn";
//	private static boolean IN_UC = true;
//	private static String UC_IP = "";
	private static String UC_API = "http://guide-uat.hkesports.com/forum/uc_server/";
	private static String UC_KEY = "123456";
	private static String UC_APPID = "12";
//	private static String UC_CLIENT_VERSION = "1.0";
	private static String UC_CLIENT_RELEASE = "20090212";
//	private static String UC_ROOT = "";
//	private static String UC_DATADIR = UC_ROOT+"./data/";
	
	/**
	 * 設定UCenter的Header
	 * @param response
	 */
	public static void setUcHeader(HttpServletResponse response){
		response.addHeader("P3P","CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
	}
	
	/**
	 * 設定UCenter的Cookie
	 * @param response  HttpServletResponse
	 * @param value		用來辨示登入的加密字串
	 * @param expiry	cookie的有效時間
	 */
	public static void setUcCookie(HttpServletResponse response, String value, int expiry){
		setUcHeader(response);
		Cookie cookie = new Cookie(COOKIE_KEY_NAME, value);
		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
	}
	
	/**
	 * 同步UCenter Client
	 * @param html
	 */
	public static void synClients(String html){
		try{
			Document doc = Jsoup.parse(html);
			Elements jsTags = doc.select("script");
			List<String> urlList = new ArrayList<String>();
			for(Element node : jsTags){
				urlList.add(node.attr("src"));
			}
			synClients(urlList);
		}catch(Exception e) {}
	}
	
	/**
	 * 非同步介接其它Client, 只介接不處理回傳結果
	 * @param urlList
	 */
	public static void synClients(final List<String> urlList){
		Thread thread = new Thread(){
			public void run(){
				for(String url : urlList){
					connectionClinet(url);
				}
			}
		};
		thread.start();
	}
	
	/**
	 * 連線Client
	 * @param url
	 */
	public static synchronized void connectionClinet(String url){
		try{
			HttpClient client = new HttpClient();
			GetMethod get = new GetMethod(url);
			client.executeMethod(get);
		}catch(Exception e){}
	}
	
	/**
	 * 連線UCenter
	 * @param module 類別
	 * @param action 動作
	 * @param map 參數
	 * @return 回傳UCenter的回應內容
	 */
	public static List<String> ucApiPost(String module, String action, Map<String, Object> map) {
		String result = "";
		Map<String, String> paramsMap = ucApiRequestData(module, action, bindMapToParamsString(map), "");
		
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(UC_API + "index.php");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		post.addRequestHeader("Cache-Control", "no-cache");
		
		for(String key : paramsMap.keySet()){
			post.addParameter(key, paramsMap.get(key));
		}
		
		try{
			client.executeMethod(post);
			result = post.getResponseBodyAsString();
		}catch(Exception e){
			result = e.getMessage();
		}
		
		return ucUnserialize(result);
	}
	
	/**
	 * 解析UCenter的回傳資料
	 * @param text
	 * @return
	 */
	private static List<String> ucUnserialize(String text){
		List<String> list = new ArrayList<String>();
		try{
			Document doc = Jsoup.parse(text);
			Elements elements = doc.select("body").get(0).children().get(0).children();
			for(Element node : elements){
				list.add(node.text());
			}
		}catch(Exception e){
			list.add(text);
		}
		return list;
	}
	
	/**
	 * 將Map轉成GET參數字串
	 * @param map 
	 * @return 回傳成GET的參數字串
	 */
	@SuppressWarnings("unchecked")
	private static String bindMapToParamsString(Map<String, Object> map){
		if(map == null)
			return "";
		
		List<String> params = new ArrayList<String>();
		for(String key : map.keySet()){
			Object value = map.get(key);
			if(value instanceof Map){
				Map<String, Object> subMap = (Map<String, Object>) value;
				for(String subKey : subMap.keySet()){
					params.add(urlEncode(key) + "[" + urlEncode(subKey) + "]=" + urlEncode(subMap.get(subKey)));
				}
			}else
				params.add(urlEncode(key) + "=" + urlEncode(value));
		}

		return joinListVale(params, "&");
	}
	
	/**
	 * URL encode
	 */
	@SuppressWarnings("deprecation")
	protected static String urlEncode(Object value){
		return URLEncoder.encode(String.valueOf(value));
	}
	
	/**
	 * 將List用joinVale串接成字串
	 * @param list		要串接成字串的陣列
	 * @param joinValue	連接List Value的文字
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static String joinListVale(List list, String joinValue){
		StringBuilder value = new StringBuilder("");
		for(Object obj : list){
			if(value.length() > 0)
				value.append(joinValue);
			value.append(obj);
		}
		return value.toString();
	}
	
	/**
	 * 取得UCenter API端的傳入參數
	 */
	protected static Map<String, String> ucApiRequestData(String module, String action, String paramsString, String extra) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("m", module);
		map.put("a", action);
		map.put("inajax", "2");
		map.put("release", UC_CLIENT_RELEASE);
		map.put("input", ucApiInput(paramsString));
		map.put("appid", UC_APPID + extra);
		map.put("__times__", "1");

		return map;
	}
	
	/**
	 * 取得送交API的完整資料並加密
	 */
	public static String ucApiInput(String data) {
		String tmp = ucAuthcode(data + "&agent=" + md5("") + "&time=" + time(), "ENCODE", UC_KEY);
		return tmp;
	}
	
	/**
	 * 字串加密以及解密
	 *
	 * @param string str		原文或者密文
	 * @param string operation	操作(ENCODE | DECODE), 默認為 DECODE
	 * @return string		處理後的原文或者 經過base64編碼後的密文
	 */
	public static String ucAuthcode(String str, String operation) {
		return ucAuthcode(str, operation, null, 0);
	}
	
	/**
	 * 字串加密以及解密
	 *
	 * @param string str		原文或者密文
	 * @param string operation	操作(ENCODE | DECODE), 默認為 DECODE
	 * @param string key		密鑰
	 * @return string		處理後的原文或者 經過base64編碼後的密文
	 */
	public static String ucAuthcode(String str, String operation, String key) {
		return ucAuthcode(str, operation, key, 0);
	}
	
	/**
	 * 字串加密以及解密
	 *
	 * @param string str		原文或者密文
	 * @param string operation	操作(ENCODE | DECODE), 默認為 DECODE
	 * @param string key		密鑰
	 * @param int expiry		密文有效期, 加密時候有效, 單位秒, 0為永久有效
	 * @return string		處理後的原文或者 經過base64編碼後的密文
	 */
	public static String ucAuthcode(String str, String operation, String key, int expiry) {
		key = md5(key != null ? key : UC_KEY);
		String keya = md5(key.substring(0, 16));
		String keyb = md5(key.substring(16, 32));
		String keyc = operation.equals("DECODE") ? str.substring(0, 4) : substr(md5(System.currentTimeMillis()), -4);
		String cryptkey = keya + md5(keya + keyc);

		str = operation.equals("DECODE") ? base64Decode(str.substring(4)) : sprintf(expiry > 0 ? expiry + time() : 0) + md5(str+keyb).substring(0, 16) + str;

		StringBuffer codes = new StringBuffer();
		int keyLength = cryptkey.length();
		
		int[] box = new int[256];
		for(int i = 0; i < box.length; i++){
			box[i] = i;
		}
		
		int j = 0;
		for(int i = 0; i < box.length; i++){
			j = (j + box[i] + (int) cryptkey.charAt(i % keyLength)) % 256;
			int tmp = box[i];
			box[i] = box[j];
			box[j] = tmp;
		}
		
		j = 0;
		int a = 0;
		for(int i = 0; i < str.length(); i++){
			a = ++a % 256;
			j = (j + box[a]) % 256;
			int tmp = box[a];
			box[a] = box[j];
			box[j] = tmp;
			
			codes.append((char) (((int) str.charAt(i)) ^ box[(box[a] + box[j]) % 256]));
		}
		
		String result = codes.toString();
		if(operation.equals("DECODE")) {
			if((Integer.parseInt(result.substring(0, 10)) == 0 || Long.parseLong(result.substring(0, 10)) - time() > 0) 
					&& result.substring(10, 26).equals(md5(result.substring(26) + keyb).substring(0, 16)))
				return result.substring(26);
			else
				return "";
		} else {
			return keyc + base64Encode(result).replaceAll("=", "");
		}
	}
	
	/**
	 * 取得現在總秒數
	 */
	public static long time(){
		return System.currentTimeMillis() / 1000;
	}
	
	/**
	 * 切字串
	 * @param input 原始字串
	 * @param begin	整數字取它之後的字串, 負數時取總長度減它為起始點, 拿起始點之後的字串
	 * @return 切好的字串
	 */
	protected static String substr(String input, int begin){
		if(begin > 0)
			return input.substring(begin);
		else
			return input.substring(input.length() + begin);
	}
	
	/**
	 * 解碼Base64字串, 無法使用spring的Base64解碼, 大資料量時會發現規則不同
	 * @param input 要解碼的字串
	 * @return	解碼結果
	 * @throws UnsupportedEncodingException 
	 */
	private static String base64Decode(String input) {
		try {
			return new String(Base64.decode(input.toCharArray()), "iso-8859-1");
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**
	 * Base64編碼, 無法使用spring的Base64編碼, 大資料量時會發現規則不同
	 * @param input 要編碼的字串
	 * @return	編碼結果
	 */
	private static String base64Encode(String input){
		try {
			return new String(Base64.encode(input.getBytes("iso-8859-1")));
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**
	 * 取最後十碼數字, 不足的位數在前面補零
	 * @param input 數字
	 * @return 十碼數字的字串
	 */
	private static String sprintf(long input){
		String temp = "0000000000"+input;
		return temp.substring(temp.length() - 10);
	}
	
	/**
	 * MD5加密, 無法使用spring的MD5加密, 大資料量時會發現規則不同
	 * @param input 要加密的字串
	 * @return	加密結果
	 */
	private static String md5(String input){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		return byte2hex(md.digest(input.getBytes()));
	}
	
	/**
	 * MD5加密, 無法使用spring的MD5加密, 大資料量時會發現規則不同
	 * @param input 要加密的數字
	 * @return 加密結果
	 */
	private static String md5(long input){
		return md5(String.valueOf(input));
	}
	
	private static String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
		}
		return hs.toString();
	}
}
