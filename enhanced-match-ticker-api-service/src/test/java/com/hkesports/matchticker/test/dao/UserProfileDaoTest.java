package com.hkesports.matchticker.test.dao;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.hkesports.matchticker.enums.UserSourceTypeEnum;
import com.hkesports.matchticker.model.User;
import com.hkesports.matchticker.model.UserProfile;
import com.hkesports.matchticker.repository.UserDao;
import com.hkesports.matchticker.repository.UserProfileDao;
import com.hkesports.matchticker.test.AbstractTest;

public class UserProfileDaoTest extends AbstractTest {

	@Resource(name = "userDao")
	private UserDao userDao;
	@Resource(name = "userProfileDao")
	private UserProfileDao userProfileDao;
	
	@Test
	@Transactional
	@Rollback(false)
	@Ignore
	public void testSaveUserProfile() {
		User user = null;
		UserProfile userProfile = null;
		int count = 1000;
		int totalha = 10000;
		for(int i = 0; i < count; i++) {
			user = new User();
			user.setAccount("jordan_" + i);
			user.setPassword(encrypt("password_" + i));
			user.setName("MJ_" + i);
			user.setEmail("MJMAIL_" + i + "@yahoo.com.tw");
			user.setSourceType(UserSourceTypeEnum.UCenter);
			user.setIsValidate(true);
			userDao.save(user);
			
			userProfile = new UserProfile();
			userProfile.setFirstName("Michael_" + i);
			userProfile.setLastName("jordan_" + i);
			userProfile.setHa(new BigInteger("10000"));
			userProfile.setTotalHa(new BigInteger(String.valueOf(totalha)));
			userProfile.setUser(user);
			
			userProfileDao.save(userProfile);
			totalha += 10000;
		}
	}
	
	public static String encrypt(String str) {
		return encrypt(str, "MD5");
	}
 
	public static String encrypt(String str, String encType) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance(encType);
			md.update(str.getBytes());
			result = toHexString(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
 
	private static String toHexString(byte[] in) {
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < in.length; i++){
			String hex = Integer.toHexString(0xFF & in[i]);
			if (hex.length() == 1){
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
