package com.hkesports.matchticker.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.enums.HaUseTypeEnum;
import com.hkesports.matchticker.model.DeviceHaRecord;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface DeviceHaRecordDao extends GenericRepository<DeviceHaRecord, Long> {
	
	@Query(value="from DeviceHaRecord dhr where dhr.device.id=:deviceId and dhr.useType=:useType and dhr.foreignKey=:foreignKey")
	public DeviceHaRecord findByDeviceIdAndUserTypeAndForeignKey(@Param("deviceId")Long deviceId, @Param("useType")HaUseTypeEnum useType, @Param("foreignKey")Long foreignKey);
	
	@Modifying
	@Query(value="update device_ha_record set ha=if(ha is null, 0, ha)+:ha where device_id=:deviceId and use_type=:useType and foreign_key=:foreignKey", nativeQuery=true)
	public int updateForMakeGuess(@Param("deviceId")Long deviceId, @Param("useType")String useType, @Param("foreignKey")Long foreignKey, @Param("ha")BigInteger ha);
	
	@Query("select count(id) from DeviceHaRecord where device.id=:deviceId and useType=:useType and createDate=:createDate")
	public Long countByDeviceIdAndUseType(@Param("deviceId")Long deviceId, @Param("useType")HaUseTypeEnum useType, @Param("createDate")Integer createDate);
	
	
	public final String SQL_insert = 
			"INSERT INTO device_ha_record (device_id, use_type, sub_use_type, ha, create_date, create_time, foreign_key, record_desc) " +
			"values(:deviceid, :useType, :subUserType, :ha, :createDate, :createTime, :foreignKey, :recordDesc)";
	@Modifying
	@Query(value=SQL_insert, nativeQuery=true)
	public int insert(@Param("deviceid")Long deviceid, @Param("useType")String useType, @Param("subUserType")String subUserType, 
			@Param("ha")BigInteger ha, @Param("createDate")Integer createDate, @Param("createTime")Integer createTime, 
			@Param("foreignKey")Long foreignKey, @Param("recordDesc")String recordDesc);

}
