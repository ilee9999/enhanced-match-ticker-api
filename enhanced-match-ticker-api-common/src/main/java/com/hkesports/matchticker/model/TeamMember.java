package com.hkesports.matchticker.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "team_member")
public class TeamMember extends BasicModel {
	private static final long serialVersionUID = 1L;

	private Team team;
	private String memberName;
	private String memberFullName;
	private String memberCountry;
	private Blob memberIconSmall;
	private Blob memberIconLarge;
	private String teamURL;
	private String role;
	private Short isStarter;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="team_id", columnDefinition="BIGINT(20)", referencedColumnName="id")
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
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
	
	@Lob
	@Column(name="member_icon_small", columnDefinition = "BLOB", nullable = true)
	public Blob getMemberIconSmall() {
		return memberIconSmall;
	}
	
	public void setMemberIconSmall(Blob memberIconSmall) {
		this.memberIconSmall = memberIconSmall;
	}
	
	@Lob
	@Column(name="member_icon_large", columnDefinition = "BLOB", nullable = true)
	public Blob getMemberIconLarge() {
		return memberIconLarge;
	}
	
	public void setMemberIconLarge(Blob memberIconLarge) {
		this.memberIconLarge = memberIconLarge;
	}
	
	@Column(name="team_url", length=255, nullable = true)
	public String getTeamURL() {
		return teamURL;
	}
	
	public void setTeamURL(String teamURL) {
		this.teamURL = teamURL;
	}
	
	@Column(name="role", length=255, nullable = true)
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name="is_starter", columnDefinition="SMALLINT(6)", nullable = true)
	public Short getIsStarter() {
		return isStarter;
	}
	
	public void setIsStarter(Short isStarter) {
		this.isStarter = isStarter;
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
