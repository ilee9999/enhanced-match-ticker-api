package com.hkesports.matchticker.service;

import com.hkesports.matchticker.exception.ApiException;
import com.hkesports.matchticker.exception.SecurityCodeException;
import com.hkesports.matchticker.model.SecurityCode;
import com.hkesports.matchticker.model.UserDevices;
import com.hkesports.matchticker.vo.securityCode.SecurityCodeDecodeVo;
import com.hkesports.matchticker.vo.securityCode.SecurityCodeVo;

public interface SecurityCodeService {
	
	public SecurityCodeVo getCode(String registrationId);
	
	public String getKey(String registrationId);

	/**
	 * 取得安全碼資訊
	 * @param registrationId
	 * @return
	 * @throws SecurityCodeException
	 */
	public SecurityCode getSecurityCode(String registrationId) throws SecurityCodeException;
	
	/**
	 * 對secretKey解密並去除鹽, 還原成原始資料, 並取得該secretKey的UserDevices, 並驗證其UserDevices是否有使用該secretKey的權限
	 * @param registrationId
	 * @param encoderString
	 * @return
	 * @throws ApiException
	 */
	public UserDevices decodeSecretKeyGetDevice(String registrationId, String secretKey) throws ApiException;
	
	/**
	 * 對secretKey解密並去除鹽, 還原成原始資料, 並取得該secretKey的UserDevices, 並驗證其UserDevices是否有使用該secretKey的權限
	 * @param sucerityCode
	 * @param encoderString
	 * @return
	 * @throws ApiException
	 */
	public UserDevices decodeSecretKeyGetDevice(SecurityCode sucerityCode, String secretKey) throws ApiException;
	
	/**
	 * 並驗證其UserDevices是否有使用該secretKey的權限
	 * @param userDevices
	 * @param registrationId
	 * @param secretKey
	 * @return
	 * @throws ApiException
	 */
	public boolean checkSecretKeyIsTheDevice(UserDevices userDevices, String registrationId, String secretKey) throws ApiException;
	
	/**
	 * 解密並去除鹽, 還原成原始資料, 給MQ使用
	 * @param registrationId	registrationId
	 * @param encoderString		要解碼的字串
	 * @return					解碼後的字串
	 */
	public SecurityCodeDecodeVo decodeForMQ(String registrationId, String encoderString);
	
	/**
	 * 解密並去除鹽, 還原成原始資料
	 * @param registrationId	registrationId
	 * @param encoderString		要解碼的字串
	 * @return					解碼後的字串
	 * @throws SecurityCodeException
	 */
	public String decode(String registrationId, String encoderString) throws SecurityCodeException;
	
	/**
	 * 解密並去除鹽, 還原成原始資料
	 * @param encoderKey		加密金鑰
	 * @param registrationId	registrationId
	 * @param encoderString		要解碼的字串
	 * @return					解碼後的字串
	 * @throws SecurityCodeException
	 */
	public String decode(String encoderKey, String registrationId, String encoderString) throws SecurityCodeException;
	
	/**
	 * 解密並去除鹽, 還原成原始資料
	 * @param sucerityCode		安全碼資訊
	 * @param encoderString		要解碼的字串
	 * @return					解碼後的字串
	 * @throws SecurityCodeException
	 */
	public String decode(SecurityCode sucerityCode, String encoderString) throws SecurityCodeException;
}
