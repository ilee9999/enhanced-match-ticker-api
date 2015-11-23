package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hkesports.matchticker.model.basic.BasicIdModel;

/**
 * @author manboyu
 *
 */
@Entity
@Table(name = "personal_ranking")
public class PersonalRanking extends BasicIdModel {

	private static final long serialVersionUID = 1L;

	private User user;
	private Long rank;
	private Long ha;
	private Integer rankDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "rank", columnDefinition = "BIGINT(20)", nullable = false)
	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	@Column(name = "ha", columnDefinition = "BIGINT(20)", nullable = false)
	public Long getHa() {
		return ha;
	}

	public void setHa(Long ha) {
		this.ha = ha;
	}

	@Column(name = "rank_date", columnDefinition = "INT(11)", nullable = false)
	public Integer getRankDate() {
		return rankDate;
	}

	public void setRankDate(Integer rankDate) {
		this.rankDate = rankDate;
	}
}
