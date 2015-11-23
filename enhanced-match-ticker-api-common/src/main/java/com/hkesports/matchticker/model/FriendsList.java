package com.hkesports.matchticker.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicIdModel;

@Entity
@Table(name = "friends_list")
public class FriendsList extends BasicIdModel {
	private static final long serialVersionUID = 1L;

	private User userA;
	private User userB;

	@ManyToOne
	@JoinColumn(name = "user_a")
	public User getUserA() {
		return userA;
	}

	public void setUserA(User userA) {
		this.userA = userA;
	}

	@ManyToOne
	@JoinColumn(name = "user_b")
	public User getUserB() {
		return userB;
	}

	public void setUserB(User userB) {
		this.userB = userB;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("userA", getUserA())
		.append("userB", getUserB())
		.build();
	}
}
