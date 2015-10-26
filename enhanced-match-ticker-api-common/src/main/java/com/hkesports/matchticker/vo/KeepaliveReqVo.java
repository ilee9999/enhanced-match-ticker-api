package com.hkesports.matchticker.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.ClientTypeEnum;

public class KeepaliveReqVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClientTypeEnum clientType;
	private String timestamp;
	private Long userID;
	private Long matchID;

	public ClientTypeEnum getClientType() {
		return clientType;
	}

	public void setClientType(ClientTypeEnum clientType) {
		this.clientType = clientType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public Date getTimestampToDate() {
		if (StringUtils.isNotBlank(timestamp)) {
			return new Date(Long.parseLong(timestamp) * 1000);
		}
		return null;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getMatchID() {
		return matchID;
	}

	public void setMatchID(Long matchID) {
		this.matchID = matchID;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
