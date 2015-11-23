package com.hkesports.matchticker.repository;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.UserTypeEnum;
import com.hkesports.matchticker.model.GuessLog;
import com.hkesports.matchticker.repository.custom.GuessLogDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface GuessLogDao extends GenericRepository<GuessLog, Long>, GuessLogDaoCustom {

	public final static String JPQL_findByGame = "select gl.id from GuessLog gl " + 
			"where gl.userId = :userId and gl.userType=:userType " + 
			"and gl.matchId=:matchId and gl.contestantId=:contestantId and gl.gameNumber=:gameNumber ";
	
	@Query(value=JPQL_findByGame)
	public Long findIdByGame(@Param("userId")Long userId, @Param("userType")UserTypeEnum userType, 
			@Param("matchId")Long matchId, @Param("contestantId")Long contestantId, @Param("gameNumber")Integer gameNumber);
	
	@Modifying
	@Query(value="update guess_log set ha=if(ha is null, 0, ha)+:ha, update_date=:updateDate where id=:id", nativeQuery=true)
	public int updateForMakeGuess(@Param("id")Long id, @Param("ha")BigInteger ha, @Param("updateDate") Date updateDate);
	
	@Modifying
	@Query(value="update guess_log set ha=if(ha is null, 0, ha)+:ha, update_date=:updateDate where user_id=:userId and user_type=:userType " + 
			"and match_id=:matchId and game_number=:gameNumber and contestant_id=:contestantId ", nativeQuery=true)
	public int updateForMakeGuess(@Param("userId")Long userId, @Param("userType")String userType, 
			@Param("matchId")Long matchId, @Param("gameNumber")Integer gameNumber, @Param("contestantId")Long contestantId, @Param("ha")BigInteger ha, @Param("updateDate") Date updateDate);
	
}
