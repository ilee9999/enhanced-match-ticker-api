package com.hkesports.matchticker.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.basic.UserHa;

/**
 * @author manboyu
 *
 */
public class UserProfileVo implements UserHa, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long userId;
	private String deviceKey;
	private Date dateOfBirth;
	private BigInteger totalHa;
	private BigInteger ha;
	private BigInteger onlineTimes;
	private String profilePictureUrl;
	private String language;
	private String timeZone;
	private String gender;
	private String link;
	private String firstName;
	private String lastName;
	private String account;
	private String name;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public BigInteger getTotalHa() {
		return totalHa;
	}

	public void setTotalHa(BigInteger totalHa) {
		this.totalHa = totalHa;
	}

	@Override
	public BigInteger getHa() {
		return ha;
	}

	public void setHa(BigInteger ha) {
		this.ha = ha;
	}

	public BigInteger getOnlineTimes() {
		return onlineTimes;
	}

	public void setOnlineTimes(BigInteger onlineTimes) {
		this.onlineTimes = onlineTimes;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public UserTypeEnum getUserType() {
		return UserTypeEnum.USER;
	}
}
