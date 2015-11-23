package com.hkesports.matchticker.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "user_profile")
public class UserProfile extends BasicModel {
	
	private static final long serialVersionUID = 1L;

	private User user;
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
	private Date lastLoginTime;
	private Long continuousLoginCount;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "date_of_birth", columnDefinition = "datetime", nullable = true)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "total_ha", columnDefinition = "bigint", nullable = false)
	public BigInteger getTotalHa() {
		if(totalHa == null)
			totalHa = new BigInteger("0");
		return totalHa;
	}

	public void setTotalHa(BigInteger totalHa) {
		this.totalHa = totalHa;
	}

	@Column(name = "ha", columnDefinition = "bigint", nullable = false)
	public BigInteger getHa() {
		if(ha == null)
			ha = new BigInteger("0");
		return ha;
	}

	public void setHa(BigInteger ha) {
		this.ha = ha;
	}

	@Column(name = "online_times", columnDefinition = "bigint", nullable = false)
	public BigInteger getOnlineTimes() {
		if(onlineTimes == null)
			onlineTimes = new BigInteger("0");
		return onlineTimes;
	}

	public void setOnlineTimes(BigInteger onlineTimes) {
		this.onlineTimes = onlineTimes;
	}
	
	@Column(name = "profile_picture_url", nullable = true)
	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}
	
	@Column(name = "language", nullable = true)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "time_zone", nullable = true)
	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Column(name = "gender", nullable = true)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "link", nullable = true)
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "first_name", nullable = true)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "last_login_time", nullable = true)
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "continuous_login_count", nullable = true)
	public Long getContinuousLoginCount() {
		return continuousLoginCount;
	}

	public void setContinuousLoginCount(Long continuousLoginCount) {
		this.continuousLoginCount = continuousLoginCount;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("user", getUser())
		.append("dateOfBirth", getDateOfBirth())
		.append("totalHa", getTotalHa())
		.append("ha", getHa())
		.append("onlineTimes", getOnlineTimes())
		.append("profilePictureUrl", getProfilePictureUrl())
		.build();
	}

}
