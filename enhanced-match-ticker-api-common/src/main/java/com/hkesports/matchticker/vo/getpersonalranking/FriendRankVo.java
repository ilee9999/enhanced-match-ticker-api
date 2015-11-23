package com.hkesports.matchticker.vo.getpersonalranking;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author manboyu
 *
 */
public class FriendRankVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long rank;
	private String friendName;
	private Long ha;
	private String profilePictureUrl;
	private Boolean isGift = false;
	private Boolean itself = false;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public Long getHa() {
		return ha;
	}

	public void setHa(Long ha) {
		this.ha = ha;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public Boolean getIsGift() {
		return isGift;
	}

	public void setIsGift(Boolean isGift) {
		this.isGift = isGift;
	}
	
	public Boolean getItself() {
		return itself;
	}

	public void setItself(Boolean itself) {
		this.itself = itself;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("userId", getUserId())
		.append("rank", getRank())
		.append("friendName", getFriendName())
		.append("ha", getHa())
		.append("isGift", getIsGift())
		.build();
	}
}
