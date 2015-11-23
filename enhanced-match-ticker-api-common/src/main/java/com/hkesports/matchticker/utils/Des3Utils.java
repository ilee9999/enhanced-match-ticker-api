package com.hkesports.matchticker.utils;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Des3加解密工具
 */
public class Des3Utils {
	private static String encryptKeyType = "DESede";
	private static String encryptType = "DESede/CBC/PKCS5Padding";
	private static String textEncode = "UTF-8";
	
	/**
	 * 取得金鑰的byte array
	 * @param key
	 * @return
	 */
	protected static byte[] getKeyByte(String key) throws UnsupportedEncodingException{
//		return Base64.decodeBase64(key.getBytes(textEncode));
		return key.getBytes(textEncode);
	}
	
	/**
	 * 取得私鑰的byte array, 從公鑰的byte array中抽8筆資料組成私鑰
	 * @param keyByte
	 * @return
	 */
	protected static byte[] getIpvBytes(byte[] keyByte){
		byte[] data = {keyByte[0], keyByte[4], keyByte[6], keyByte[10], keyByte[12], keyByte[14], keyByte[17], keyByte[19]};
		return data;
	}
	
	/**
	 * 加密結果再用Base64壓碼一次, 回傳字串型態
	 * @param key 金鑰
	 * @param data 要加密的資料
	 * @return
	 */
	public static String encryptForWeb(String key, String data) throws Exception{
		return new String(Base64.encodeBase64(encrypt(key, data)), textEncode);
	}

	/**
	 * 加密
	 * @param key 金鑰
	 * @param data 要加密的資料
	 * @return
	 */
	public static byte[] encrypt(String key, String data) throws Exception{
		return encrypt(key, data.getBytes(textEncode));
	}
	
	/**
	 * 加密
	 * @param key 金鑰
	 * @param data 要加密的資料byte陣列
	 * @return
	 */
	public static byte[] encrypt(String key, byte[] data) throws Exception{
		return process(key, data, Cipher.ENCRYPT_MODE);
	}
	
	/**
	 * 解密, 將傳入的資料先用Base64解密後, 才進行解密
	 * @param key 金鑰
	 * @param data 要解密的資料
	 * @return
	 */
	public static String decryptionForWeb(String key, String data) throws Exception{
		return decryption(key, Base64.decodeBase64(data.getBytes(textEncode)));
	}
	
	/**
	 * 解密
	 * @param key 金鑰
	 * @param data 要解密的資料
	 * @return
	 */
	public static String decryption(String key, String data) throws Exception{
		return decryption(key, data.getBytes(textEncode));
	}
	
	/**
	 * 解密
	 * @param key 金鑰
	 * @param data 要解密的資料byte陣列
	 * @return
	 */
	public static String decryption(String key, byte[] data) throws Exception{
		return new String(process(key, data, Cipher.DECRYPT_MODE), textEncode);
	}
	
	/**
	 * 處理加解密, mode傳入值是用來設定加密或解密的
	 * @param key 金鑰
	 * @param data 資料
	 * @param mode 加密或解密
	 * @return
	 */
	protected static byte[] process(String key, byte[] data, Integer mode) throws Exception {
		byte[] keyByte = getKeyByte(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(encryptKeyType);
		SecretKey securekey = keyFactory.generateSecret(new DESedeKeySpec(keyByte));
		byte[] ivpBytes = getIpvBytes(keyByte);
		IvParameterSpec iv = new IvParameterSpec(ivpBytes);
		Cipher cipher = Cipher.getInstance(encryptType);
		cipher.init(mode, securekey, iv);
		return cipher.doFinal(data);
	}

	//範例
//	public static void main(String[] args) throws Exception{
//		String key = "17f9c459-0a7e-45bb-ab3c-07396f6ddb93";
//		String data = "9505e74c3c7b80ef13442a48c70f1980";
//		System.out.println(data);
//		String returnStr = Des3Utils.encryptForWeb(key, data);
//		System.out.println(returnStr);
//		System.out.println(Des3Utils.decryptionForWeb(key, returnStr));
//	}
}
