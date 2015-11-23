package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.UserActivityTypeEnum;
import com.hkesports.matchticker.model.DeviceActivityRecord;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface DeviceActivityRecordDao extends GenericRepository<DeviceActivityRecord, Long> {

	@Query("select count(id) from DeviceActivityRecord where device.id=:deviceId and activityType=:activityType and createDate=:createDate")
	public Long countByDeviceIdAndActivityTypeAndCreateDate(@Param("deviceId")Long deviceId, @Param("activityType")UserActivityTypeEnum activityType, @Param("createDate")Integer createDate);
	
	public final String SQL_insert = 
			"INSERT INTO match_ticker.device_activity_record (device_id, activity_type, create_date, create_time, record_desc, foreign_table, foreign_key) " +
			"values(:deviceId, :activityType, :createDate, :createTime, :recordDesc, :foreignTable, :foreignKey)";
	@Modifying
	@Query(value=SQL_insert, nativeQuery=true)
	public int insert(@Param("deviceId")Long deviceId, @Param("activityType")String activityType,  
			@Param("createDate")Integer createDate, @Param("createTime")Integer createTime, @Param("recordDesc")String recordDesc, 
			@Param("foreignTable")String foreignTable, @Param("foreignKey")Long foreignKey);

}
