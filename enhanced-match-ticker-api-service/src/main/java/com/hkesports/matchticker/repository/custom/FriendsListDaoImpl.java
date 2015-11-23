package com.hkesports.matchticker.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FriendsListDaoImpl extends BasicDaoImpl implements FriendsListDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
}
