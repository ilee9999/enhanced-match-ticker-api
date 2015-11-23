package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.UserActivityTypeEnum;
import com.hkesports.matchticker.model.UserActivityRecord;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface UserActivityRecordDao extends GenericRepository<UserActivityRecord, Long> {

	@Query("select count(id) from UserActivityRecord where user.id=:userId and activityType=:activityType and createDate=:createDate")
	public Long countByUserIdAndActivityTypeAndCreateDate(@Param("userId")Long userId, @Param("activityType")UserActivityTypeEnum activityType, @Param("createDate")Integer createDate);
	
	public final String SQL_insert = 
			"INSERT INTO user_activity_record(user_id, activity_type, device_type, create_date, create_time, record_desc, foreign_table, foreign_key) " +
			"values(:userId, :activityType, :deviceType, :createDate, :createTime, :recordDesc, :foreignTable, :foreignKey)";
	@Modifying
	@Query(value=SQL_insert, nativeQuery=true)
	public int insert(@Param("userId")Long userId, @Param("activityType")String activityType, @Param("deviceType")String deviceType, 
			@Param("createDate")Integer createDate, @Param("createTime")Integer createTime, @Param("recordDesc")String recordDesc, 
			@Param("foreignTable")String foreignTable, @Param("foreignKey")Long foreignKey);

	public static final String JPQL_countActivityRecordSended = 
			"select count(id) " +
			"from UserActivityRecord " +
			"where user.id=:sendUserId " +
			"and activityType=:activityType " +
			"and createDate=:createDate " +
			"and foreignKey=:receiveUserId ";
	
	@Query(JPQL_countActivityRecordSended)
	public Integer countActivityRecordSended(
			@Param("sendUserId") Long sendUserId, 
			@Param("activityType") UserActivityTypeEnum activityType,
			@Param("createDate") Integer createDate,
			@Param("receiveUserId") Long receiveUserId);
	
	public static final String JPQL_countActivityRecordSendedNumber = 
			"select count(id) " +
			"from UserActivityRecord " +
			"where user.id=:sendUserId " +
			"and activityType=:activityType " +
			"and createDate=:createDate ";
	
	@Query(JPQL_countActivityRecordSendedNumber)
	public Integer countActivityRecordSendedNumber(
			@Param("sendUserId") Long sendUserId, 
			@Param("activityType") UserActivityTypeEnum activityType,
			@Param("createDate") Integer createDate);
}
