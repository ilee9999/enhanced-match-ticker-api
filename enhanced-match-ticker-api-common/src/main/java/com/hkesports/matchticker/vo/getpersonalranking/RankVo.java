package com.hkesports.matchticker.vo.getpersonalranking;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author manboyu
 *
 */
public class RankVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long rank;
	private String playerName;
	private Long ha;
	private Boolean itself = false;

	public RankVo() {
		
	}
	
	public RankVo(Long rank, String playerName, Long ha) {
		this.rank = rank;
		this.playerName = playerName;
		this.ha = ha;
	}
	
	public RankVo(Long userId, Long rank, String playerName, Long ha) {
		this.userId = userId;
		this.rank = rank;
		this.playerName = playerName;
		this.ha = ha;
	}

	@JsonIgnore
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

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Long getHa() {
		return ha;
	}

	public void setHa(Long ha) {
		this.ha = ha;
	}
	
	public Boolean getItself() {
		return itself;
	}

	public void setItself(Boolean itself) {
		this.itself = itself;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof RankVo) {
			RankVo other = (RankVo)obj;
			return new EqualsBuilder()
				.append(getUserId(), other.getUserId())
				.isEquals();
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		if(getUserId() != null) {
			return new HashCodeBuilder()
				.append(getUserId())
				.toHashCode();
		}
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("rank", getRank())
		.append("playerName", getPlayerName())
		.append("ha", getHa())
		.build();
	}
}
