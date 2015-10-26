package com.hkesports.matchticker.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.Data;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface DataDao extends GenericRepository<Data, Long> {

	@Cacheable(value = "findByCodeData", key = "{#root.methodName, #codeName, #dataName}")
	@Query("from Data d where d.code.codeName=:codeName and d.code.published=true and d.dataName=:dataName and d.published=true")
	public Data findByCodeData(@Param("codeName") String codeName, @Param("dataName") String dataName);
	
}
