package com.hkesports.matchticker.vo.getmatchstatistics;

import java.io.Serializable;

public class GameTeamPlayerVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long playerID;
	private String playerName;
	private String playerPhotoURLThumbnail;
	private String playerPhotoURLLarge;
	private String playerPhotoURLOriginal;
	private Integer kills; 									// ScheduleGamePlayerDetail.kills
	private Integer deaths; 								// ScheduleGamePlayerDetail.deaths
	private Integer assists; 								// ScheduleGamePlayerDetail.assists
	private Integer endLevel; 								// ScheduleGamePlayerDetail.endLevel
	private Integer minionsKilled; 							// ScheduleGamePlayerDetail.(minionsKilled)
	private Integer totalGold; 								// ScheduleGamePlayerDetail.totalGold
	private String spell0; 									// ScheduleGamePlayerItems ->itemType=Spell
	private String spell1;
	private String items0; 									// ScheduleGamePlayerItems ->itemType=Equip
	private String items1;
	private String items2;
	private String items3;
	private String items4;
	private String items5;
	private String championName;
	private String championUrl;
	private Integer largestKillingSpree;
	private Integer largestMultiKill;
	private Integer killingSprees;
	private Integer longestTimeSpentLiving;
	private Integer doubleKills;
	private Integer tripleKills;
	private Integer quadraKills;
	private Integer pentaKills;
	private Integer unrealKills;
	private Integer totalDamageDealt;
	private Integer magicDamageDealt;
	private Integer physicalDamageDealt;
	private Integer trueDamageDealt;
	private Integer largestCriticalStrike;
	private Integer totalDamageDealtToChampions; 
	private Integer magicDamageDealtToChampions; 			// magicDamageDealtToChampions
	private Integer physicalDamageDealtToChampions; 		// physicalDamageDealtToChampions
	private Integer trueDamageDealtToChampions; 			// trueDamageDealtToChampions
	private Integer totalHeal;
	private Integer totalUnitsHealed;
	private Integer totalDamageTaken;
	private Integer magicalDamageTaken; 					// magicalDamageTaken
	private Integer physicalDamageTaken;
	private Integer trueDamageTaken;
	private Integer goldEarned;
	private Integer goldSpent;
	private Integer turretKills; 							// turretKills
	private Integer inhibitorKills;
	private Integer totalMinionsKilled;
	private Integer neutralMinionsKilled;
	private Integer neutralMinionsKilledTeamJungle;
	private Integer neutralMinionsKilledEnemyJungle;
	private Integer totalTimeCrowdControlDealt; 			// totalTimeControlDealt
	private Integer champLevel;
	private Integer visionWardsBoughtInGame; 				// visionWardsBoughtInGame
	private Integer sightWardsBoughtInGame; 				// sightWardsBoughtInGame
	private Integer wardsPlaced;
	private Integer wardsKilled;
	private Integer playerSlot;
	private Integer goldPerMin;
	private Integer xpPerMin;
	private Integer heroDamage;
	private Integer towerDamage;
	private Integer heroHealing;

	public Long getPlayerID() {
		return playerID;
	}

	public void setPlayerID(Long playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerPhotoURLThumbnail() {
		return playerPhotoURLThumbnail;
	}

	public void setPlayerPhotoURLThumbnail(String playerPhotoURLThumbnail) {
		this.playerPhotoURLThumbnail = playerPhotoURLThumbnail;
	}

	public String getPlayerPhotoURLLarge() {
		return playerPhotoURLLarge;
	}

	public void setPlayerPhotoURLLarge(String playerPhotoURLLarge) {
		this.playerPhotoURLLarge = playerPhotoURLLarge;
	}

	public String getPlayerPhotoURLOriginal() {
		return playerPhotoURLOriginal;
	}

	public void setPlayerPhotoURLOriginal(String playerPhotoURLOriginal) {
		this.playerPhotoURLOriginal = playerPhotoURLOriginal;
	}

	public Integer getKills() {
		return kills;
	}

	public void setKills(Integer kills) {
		this.kills = kills;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	public Integer getAssists() {
		return assists;
	}

	public void setAssists(Integer assists) {
		this.assists = assists;
	}

	public Integer getEndLevel() {
		return endLevel;
	}

	public void setEndLevel(Integer endLevel) {
		this.endLevel = endLevel;
	}

	public Integer getMinionsKilled() {
		return minionsKilled;
	}

	public void setMinionsKilled(Integer minionsKilled) {
		this.minionsKilled = minionsKilled;
	}

	public Integer getTotalGold() {
		return totalGold;
	}

	public void setTotalGold(Integer totalGold) {
		this.totalGold = totalGold;
	}

	public String getSpell0() {
		return spell0;
	}

	public void setSpell0(String spell0) {
		this.spell0 = spell0;
	}

	public String getSpell1() {
		return spell1;
	}

	public void setSpell1(String spell1) {
		this.spell1 = spell1;
	}

	public String getItems0() {
		return items0;
	}

	public void setItems0(String items0) {
		this.items0 = items0;
	}

	public String getItems1() {
		return items1;
	}

	public void setItems1(String items1) {
		this.items1 = items1;
	}

	public String getItems2() {
		return items2;
	}

	public void setItems2(String items2) {
		this.items2 = items2;
	}

	public String getItems3() {
		return items3;
	}

	public void setItems3(String items3) {
		this.items3 = items3;
	}

	public String getItems4() {
		return items4;
	}

	public void setItems4(String items4) {
		this.items4 = items4;
	}

	public String getItems5() {
		return items5;
	}

	public void setItems5(String items5) {
		this.items5 = items5;
	}

	public String getChampionName() {
		return championName;
	}

	public void setChampionName(String championName) {
		this.championName = championName;
	}

	public String getChampionUrl() {
		return championUrl;
	}

	public void setChampionUrl(String championUrl) {
		this.championUrl = championUrl;
	}

	public Integer getLargestKillingSpree() {
		return largestKillingSpree;
	}

	public void setLargestKillingSpree(Integer largestKillingSpree) {
		this.largestKillingSpree = largestKillingSpree;
	}

	public Integer getLargestMultiKill() {
		return largestMultiKill;
	}

	public void setLargestMultiKill(Integer largestMultiKill) {
		this.largestMultiKill = largestMultiKill;
	}

	public Integer getKillingSprees() {
		return killingSprees;
	}

	public void setKillingSprees(Integer killingSprees) {
		this.killingSprees = killingSprees;
	}

	public Integer getLongestTimeSpentLiving() {
		return longestTimeSpentLiving;
	}

	public void setLongestTimeSpentLiving(Integer longestTimeSpentLiving) {
		this.longestTimeSpentLiving = longestTimeSpentLiving;
	}

	public Integer getDoubleKills() {
		return doubleKills;
	}

	public void setDoubleKills(Integer doubleKills) {
		this.doubleKills = doubleKills;
	}

	public Integer getTripleKills() {
		return tripleKills;
	}

	public void setTripleKills(Integer tripleKills) {
		this.tripleKills = tripleKills;
	}

	public Integer getQuadraKills() {
		return quadraKills;
	}

	public void setQuadraKills(Integer quadraKills) {
		this.quadraKills = quadraKills;
	}

	public Integer getPentaKills() {
		return pentaKills;
	}

	public void setPentaKills(Integer pentaKills) {
		this.pentaKills = pentaKills;
	}

	public Integer getUnrealKills() {
		return unrealKills;
	}

	public void setUnrealKills(Integer unrealKills) {
		this.unrealKills = unrealKills;
	}

	public Integer getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(Integer totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public Integer getMagicDamageDealt() {
		return magicDamageDealt;
	}

	public void setMagicDamageDealt(Integer magicDamageDealt) {
		this.magicDamageDealt = magicDamageDealt;
	}

	public Integer getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	public void setPhysicalDamageDealt(Integer physicalDamageDealt) {
		this.physicalDamageDealt = physicalDamageDealt;
	}

	public Integer getTrueDamageDealt() {
		return trueDamageDealt;
	}

	public void setTrueDamageDealt(Integer trueDamageDealt) {
		this.trueDamageDealt = trueDamageDealt;
	}

	public Integer getLargestCriticalStrike() {
		return largestCriticalStrike;
	}

	public void setLargestCriticalStrike(Integer largestCriticalStrike) {
		this.largestCriticalStrike = largestCriticalStrike;
	}

	public Integer getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(
			Integer totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public Integer getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public void setMagicDamageDealtToChampions(
			Integer magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public Integer getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageDealtToChampions(
			Integer physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public Integer getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public void setTrueDamageDealtToChampions(Integer trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}

	public Integer getTotalHeal() {
		return totalHeal;
	}

	public void setTotalHeal(Integer totalHeal) {
		this.totalHeal = totalHeal;
	}

	public Integer getTotalUnitsHealed() {
		return totalUnitsHealed;
	}

	public void setTotalUnitsHealed(Integer totalUnitsHealed) {
		this.totalUnitsHealed = totalUnitsHealed;
	}

	public Integer getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(Integer totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public Integer getMagicalDamageTaken() {
		return magicalDamageTaken;
	}

	public void setMagicalDamageTaken(Integer magicalDamageTaken) {
		this.magicalDamageTaken = magicalDamageTaken;
	}

	public Integer getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	public void setPhysicalDamageTaken(Integer physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}

	public Integer getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public void setTrueDamageTaken(Integer trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}

	public Integer getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(Integer goldEarned) {
		this.goldEarned = goldEarned;
	}

	public Integer getGoldSpent() {
		return goldSpent;
	}

	public void setGoldSpent(Integer goldSpent) {
		this.goldSpent = goldSpent;
	}

	public Integer getTurretKills() {
		return turretKills;
	}

	public void setTurretKills(Integer turretKills) {
		this.turretKills = turretKills;
	}

	public Integer getInhibitorKills() {
		return inhibitorKills;
	}

	public void setInhibitorKills(Integer inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public Integer getTotalMinionsKilled() {
		return totalMinionsKilled;
	}

	public void setTotalMinionsKilled(Integer totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}

	public Integer getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(Integer neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public Integer getNeutralMinionsKilledTeamJungle() {
		return neutralMinionsKilledTeamJungle;
	}

	public void setNeutralMinionsKilledTeamJungle(
			Integer neutralMinionsKilledTeamJungle) {
		this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
	}

	public Integer getNeutralMinionsKilledEnemyJungle() {
		return neutralMinionsKilledEnemyJungle;
	}

	public void setNeutralMinionsKilledEnemyJungle(
			Integer neutralMinionsKilledEnemyJungle) {
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
	}

	public Integer getTotalTimeCrowdControlDealt() {
		return totalTimeCrowdControlDealt;
	}

	public void setTotalTimeCrowdControlDealt(Integer totalTimeControlDealt) {
		this.totalTimeCrowdControlDealt = totalTimeControlDealt;
	}

	public Integer getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(Integer champLevel) {
		this.champLevel = champLevel;
	}

	public Integer getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}

	public void setVisionWardsBoughtInGame(Integer visionWardsBoughtInGame) {
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
	}

	public Integer getSightWardsBoughtInGame() {
		return sightWardsBoughtInGame;
	}

	public void setSightWardsBoughtInGame(Integer sightWardsBoughtInGame) {
		this.sightWardsBoughtInGame = sightWardsBoughtInGame;
	}

	public Integer getWardsPlaced() {
		return wardsPlaced;
	}

	public void setWardsPlaced(Integer wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}

	public Integer getWardsKilled() {
		return wardsKilled;
	}

	public void setWardsKilled(Integer wardsKilled) {
		this.wardsKilled = wardsKilled;
	}

	public Integer getPlayerSlot() {
		return playerSlot;
	}

	public void setPlayerSlot(Integer playerSlot) {
		this.playerSlot = playerSlot;
	}

	public Integer getGoldPerMin() {
		return goldPerMin;
	}

	public void setGoldPerMin(Integer goldPerMin) {
		this.goldPerMin = goldPerMin;
	}

	public Integer getXpPerMin() {
		return xpPerMin;
	}

	public void setXpPerMin(Integer xpPerMin) {
		this.xpPerMin = xpPerMin;
	}

	public Integer getHeroDamage() {
		return heroDamage;
	}

	public void setHeroDamage(Integer heroDamage) {
		this.heroDamage = heroDamage;
	}

	public Integer getTowerDamage() {
		return towerDamage;
	}

	public void setTowerDamage(Integer towerDamage) {
		this.towerDamage = towerDamage;
	}

	public Integer getHeroHealing() {
		return heroHealing;
	}

	public void setHeroHealing(Integer heroHealing) {
		this.heroHealing = heroHealing;
	}
}
