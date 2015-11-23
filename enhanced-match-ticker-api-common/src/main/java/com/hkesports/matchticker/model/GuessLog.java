package com.hkesports.matchticker.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.basic.BasicIdModel;
import com.hkesports.matchticker.utils.Const;

@Entity
@Table(name = "guess_log")
public class GuessLog extends BasicIdModel {

	private static final long serialVersionUID = 1L;

	private UserTypeEnum userType;
	private Long userId;
	private Long matchId;
	private Long contestantId;
	private Integer gameNumber;
	private BigInteger ha;
	private Integer createYear;
	private Integer createMonth;
	private Integer createDay;
	private Integer createDate;
	private Integer createTime;
	private Date updateDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_type", nullable = false)
	public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "match_id", nullable = false)
	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	@Column(name = "contestant_id", nullable = false)
	public Long getContestantId() {
		return contestantId;
	}

	public void setContestantId(Long contestantId) {
		this.contestantId = contestantId;
	}

	@Column(name = "game_number", nullable = false)
	public Integer getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(Integer gameNumber) {
		this.gameNumber = gameNumber;
	}

	@Column(name = "ha", nullable = false)
	public BigInteger getHa() {
		return ha;
	}

	public void setHa(BigInteger ha) {
		this.ha = ha;
	}
	
	@Column(name = "create_year", nullable = false)
	public Integer getCreateYear() {
		return createYear;
	}

	public void setCreateYear(Integer createYear) {
		this.createYear = createYear;
	}

	@Column(name = "create_month", nullable = false)
	public Integer getCreateMonth() {
		return createMonth;
	}

	public void setCreateMonth(Integer createMonth) {
		this.createMonth = createMonth;
	}

	@Column(name = "create_day", nullable = false)
	public Integer getCreateDay() {
		return createDay;
	}

	public void setCreateDay(Integer createDay) {
		this.createDay = createDay;
	}
	
	@Column(name = "create_date", nullable = false)
	public Integer getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Integer createDay) {
		this.createDate = createDay;
	}
	
	@Column(name = "create_time", nullable = false)
	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Const.JSON_DATE_FORMAT_YYYYMMDDHHMMSS, timezone = "Asia/Taipei")
	@Column(name = "update_date", columnDefinition = "DATETIME", nullable = true)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	@PreUpdate
    public void preUpdate() {
		this.setUpdateDate(new Date());
    }
	
}
