package com.hkesports.matchticker.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.HaUseTypeEnum;
import com.hkesports.matchticker.model.HaRecord;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface HaRecordDao extends GenericRepository<HaRecord, Long> {
	
	@Query(value="from HaRecord hr where hr.user.id=:userId and hr.useType=:useType and hr.foreignKey=:foreignKey")
	public HaRecord findByUserIdAndUserTypeAndForeignKey(@Param("userId")Long userId, @Param("useType")HaUseTypeEnum useType, @Param("foreignKey")Long foreignKey);
	
	@Modifying
	@Query(value="update ha_record set ha=ifnull(ha, 0)+:ha where user_id=:userId and use_type=:useType and foreign_key=:foreignKey", nativeQuery=true)
	public int updateForMakeGuess(@Param("userId")Long userId, @Param("useType")String useType, @Param("foreignKey")Long foreignKey, @Param("ha")BigInteger ha);
	
	@Query("select count(id) from HaRecord where user.id=:userId and useType=:useType and createDate=:createDate")
	public Long countByUserIdAndUseType(@Param("userId")Long userId, @Param("useType")HaUseTypeEnum useType, @Param("createDate")Integer createDate);
	
	public final String SQL_insert = 
			"INSERT INTO ha_record (user_id, use_type, sub_use_type, ha, create_date, create_time, foreign_key, record_desc) " +
			"values(:userId, :useType, :subUserType, :ha, :createDate, :createTime, :foreignKey, :recordDesc)";
	@Modifying
	@Query(value=SQL_insert, nativeQuery=true)
	public int insert(@Param("userId")Long userId, @Param("useType")String useType, @Param("subUserType")String subUserType, 
			@Param("ha")BigInteger ha, @Param("createDate")Integer createDate, @Param("createTime")Integer createTime, 
			@Param("foreignKey")Long foreignKey, @Param("recordDesc")String recordDesc);

	public static final String JPQL_countHaRecordSended = 
			"select count(id) " +
			"from HaRecord " +
			"where user.id=:receiveUserId " +
			"and useType=:useType " +
			"and createDate=:createDate " +
			"and foreignKey=:sendUserId ";
	
	@Query(JPQL_countHaRecordSended)
	public Integer countHaRecordSended(
			@Param("receiveUserId") Long receiveUserId, 
			@Param("useType") HaUseTypeEnum useType,
			@Param("createDate") Integer createDate,
			@Param("sendUserId") Long sendUserId);
}
