package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "team_member")
public class TeamMember extends BasicModel {
	private static final long serialVersionUID = 1L;

	private Tournament tournament;
	private Team team;
	private Player player;
	private String memberName;
	private String memberFullName;
	private String memberCountry;
	private String memberIconSmall;
	private String memberIconLarge;
	private String teamURL;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tournament_id", columnDefinition="BIGINT(20)", referencedColumnName="id")
	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="team_id", columnDefinition="BIGINT(20)", referencedColumnName="id")
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="player_id", columnDefinition="BIGINT(20)", referencedColumnName="id")
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Column(name="member_name", length=128)
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Column(name="member_full_Name", length=128)
	public String getMemberFullName() {
		return memberFullName;
	}
	
	public void setMemberFullName(String memberFullName) {
		this.memberFullName = memberFullName;
	}
	
	@Column(name="member_country", length=2, nullable = true)
	public String getMemberCountry() {
		return memberCountry;
	}
	
	public void setMemberCountry(String memberCountry) {
		this.memberCountry = memberCountry;
	}
	
	@Column(name="member_icon_small", length = 10, nullable = true)
	public String getMemberIconSmall() {
		return memberIconSmall;
	}
	
	public void setMemberIconSmall(String memberIconSmall) {
		this.memberIconSmall = memberIconSmall;
	}
	
	@Column(name="member_icon_large", length = 10, nullable = true)
	public String getMemberIconLarge() {
		return memberIconLarge;
	}
	
	public void setMemberIconLarge(String memberIconLarge) {
		this.memberIconLarge = memberIconLarge;
	}
	
	@Column(name="team_url", length=255, nullable = true)
	public String getTeamURL() {
		return teamURL;
	}
	
	public void setTeamURL(String teamURL) {
		this.teamURL = teamURL;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Player){
			Player player = (Player) obj;
			EqualsBuilder eb = new EqualsBuilder();
			eb.append(this.getMemberName(), player.getPlayerName());
			eb.append(this.getMemberFullName(), player.getPlayerFullName());
			eb.append(this.getMemberCountry(), player.getCountry());
			return eb.isEquals();
		}else
			return super.equals(obj);
	}
}
