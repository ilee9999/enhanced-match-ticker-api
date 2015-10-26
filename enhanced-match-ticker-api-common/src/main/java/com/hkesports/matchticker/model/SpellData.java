package com.hkesports.matchticker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.model.basic.BasicApiInfo;

/**
 * @author manboyu
 *
 */
@Entity
@Table(name = "spell_data")
public class SpellData extends BasicApiInfo {

	private static final long serialVersionUID = 1L;

	private Hero hero;
	private String description;
	private String name;
	private String enName;
	private Integer summonerLevel;
	private String imageFullName;
	private Integer imageW;
	private Integer imageH;
	private String version;
	private Date expireDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hero_id", columnDefinition="BIGINT(20)", nullable=true)
	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	@Column(name = "description", columnDefinition = "TEXT", nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "name", length = 255, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "en_name", length = 255, nullable = false)
	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Column(name = "summoner_level", columnDefinition = "INT(11)", nullable = true)
	public Integer getSummonerLevel() {
		return summonerLevel;
	}

	public void setSummonerLevel(Integer summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	@Column(name = "image_full_name", length = 100, nullable = true)
	public String getImageFullName() {
		return imageFullName;
	}

	public void setImageFullName(String imageFullName) {
		this.imageFullName = imageFullName;
	}

	@Column(name = "image_w", columnDefinition = "INT(11)", nullable = true)
	public Integer getImageW() {
		return imageW;
	}

	public void setImageW(Integer imageW) {
		this.imageW = imageW;
	}

	@Column(name = "image_h", columnDefinition = "INT(11)", nullable = true)
	public Integer getImageH() {
		return imageH;
	}

	public void setImageH(Integer imageH) {
		this.imageH = imageH;
	}

	@Column(name = "version", length = 20, nullable = true)
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Column(name = "expire_date", columnDefinition = "datetime", nullable = true)
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("apiId", getApiId())
		.append("gameType", getGameType())
		.append("description", getDescription())
		.append("name", getName())
		.append("enName", getEnName())
		.append("imageFullName", getImageFullName())
		.append("imageW", getImageW())
		.append("imageH", getImageH())
		.append("version", getVersion())
		.build();
	}
}