package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.Code;
import com.hkesports.matchticker.model.Data;
import com.hkesports.matchticker.repository.custom.DataDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface DataDao extends GenericRepository<Data, Long>, DataDaoCustom {

	@Query("from Data d where d.code.codeName=:codeName and d.code.published=true and d.dataName=:dataName and d.published=true")
	public Data findByCodeData(@Param("codeName") String codeName, @Param("dataName") String dataName);
	
	@Query("from Data d where d.code.codeName=:codeName and d.code.published=true and d.published=true order by d.displayOrder asc ")
	public List<Data> findByCodeName(@Param("codeName") String codeName);
	
	@Query("select d from Data d where d.code.parentCode.codeName=:parentCodeName and d.dataName=:dataName and d.dataValue <= :totalHA and d.published=true order by d.dataValue desc")
	public List<Data> findLevelValueByDataName(@Param("parentCodeName") String parentCodeName, @Param("dataName") String everyLevelNeeded, @Param("totalHA") String totalHA);
	
	public List<Data> findByCodeAndDataNameIn(Code code, List<String> dataNames);
	
}
