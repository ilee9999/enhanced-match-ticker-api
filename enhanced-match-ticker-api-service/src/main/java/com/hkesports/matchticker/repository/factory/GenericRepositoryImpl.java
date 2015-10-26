package com.hkesports.matchticker.repository.factory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.hkesports.matchticker.enums.GameTypeEnum;

/**
 * @author manboyu
 *
 * @param <T>
 * @param <ID>
 */
public class GenericRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements GenericRepository<T, ID> {

	private EntityManager entityManager;
	
	public GenericRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public T getEntity(ID id) {
		Class<T> entityClass = getDomainClass();
		Assert.notNull(id, "無法取得 Entity [ " + entityClass.getName() + " ], id不得為空");
		return entityManager.getReference(entityClass, id);
	}

	@Override
	public long getCount(String entityClass, Map<String, Object> properties) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select count(c.id) from "+ entityClass + " c ");
		if(CollectionUtils.isEmpty(properties)){
			return (Long)entityManager.createQuery(jpql.toString()).getSingleResult();
		}
		for(String key : properties.keySet()) {
			jpql.append("and c." + key + "=:" + key + " ");
		}
		Query queryObj = entityManager.createQuery(jpql.toString().replaceFirst("and", "where"));
		for(Map.Entry<String, Object> entry : properties.entrySet()) {
			queryObj.setParameter(entry.getKey(), entry.getValue());
		}
		return (long)queryObj.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findDataFromTmpApiId(GameTypeEnum gameType, String dataType) {
		Class<T> entityClass = getDomainClass();
		String jpql = "select t from " + entityClass.getName() + " t, ApiIdTmp a where t.apiId = a.apiId and t.gameType = a.gameType and a.gameType=:gameType and a.dataType=:dataType";
		Query queryObj = entityManager.createQuery(jpql, entityClass);
		queryObj.setParameter("gameType", gameType);
		queryObj.setParameter("dataType", dataType);
		return queryObj.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <Q> List<Q> findByGameType(GameTypeEnum gameType) {
		Class<T> entityClass = getDomainClass();
		String jpql = "select t from " + entityClass.getName() + " t where gameType =:gameType";
		Query queryObj = entityManager.createQuery(jpql, entityClass);
		queryObj.setParameter("gameType", gameType);
		
		return queryObj.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public<Q> Q findByApiId(Long apiId) {
		Class<T> entityClass = getDomainClass();
		String jpql = "select t from " + entityClass.getName() + " t where apiId =:apiId";
		Query queryObj = entityManager.createQuery(jpql, entityClass);
		queryObj.setParameter("apiId", apiId);
		List<Q> results = queryObj.getResultList();
		return !CollectionUtils.isEmpty(results) ? results.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <Q> Q findByApiIdAndGameType(Long apiId, GameTypeEnum gameType) {
		Class<T> entityClass = getDomainClass();
		String jpql = "select t from " + entityClass.getName() + " t where apiId =:apiId and gameType=:gameType";
		Query queryObj = entityManager.createQuery(jpql, entityClass);
		queryObj.setParameter("apiId", apiId);
		queryObj.setParameter("gameType", gameType);
		List<Q> results = queryObj.getResultList();
		return !CollectionUtils.isEmpty(results) ? results.get(0) : null;
	}
}
