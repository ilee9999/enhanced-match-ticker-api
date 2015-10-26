package com.hkesports.matchticker.repository.factory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.hkesports.matchticker.enums.GameTypeEnum;

/**
 * @author manboyu
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

	T getEntity(ID id);

	long getCount(String entityClass, Map<String, Object> properties);
	
	List<T> findDataFromTmpApiId(GameTypeEnum gameType, String dataType);
	
	<Q> List<Q> findByGameType(GameTypeEnum gameType);
	
	<Q> Q findByApiId(Long apiId);
	
	<Q> Q findByApiIdAndGameType(Long apiId, GameTypeEnum gameType);
}
