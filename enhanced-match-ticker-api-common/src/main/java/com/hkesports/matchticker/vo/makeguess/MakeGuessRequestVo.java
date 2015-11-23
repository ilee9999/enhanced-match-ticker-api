package com.hkesports.matchticker.vo.makeguess;

import java.io.Serializable;
import java.math.BigInteger;

public class MakeGuessRequestVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String registrationID;
	private String secretKey; // (secretKey + code)
	private Long matchID;
	private Long contestantID;
	private BigInteger ha;
	private Integer gameNumber;// (1,2,3,4,5,6)

	public String getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(String registrationID) {
		this.registrationID = registrationID;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Long getMatchID() {
		return matchID;
	}

	public void setMatchID(Long matchID) {
		this.matchID = matchID;
	}

	public Long getContestantID() {
		return contestantID;
	}

	public void setContestantID(Long contestantID) {
		this.contestantID = contestantID;
	}

	public BigInteger getHa() {
		if(ha==null) {
			return BigInteger.ZERO;
		}
		return ha;
	}

	public void setHa(BigInteger ha) {
		this.ha = ha;
	}

	public Integer getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(Integer gameNumber) {
		this.gameNumber = gameNumber;
	}

}
