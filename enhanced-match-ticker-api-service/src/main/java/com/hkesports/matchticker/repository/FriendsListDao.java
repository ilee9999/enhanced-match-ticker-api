package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.FriendsList;
import com.hkesports.matchticker.repository.custom.FriendsListDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface FriendsListDao extends GenericRepository<FriendsList, Long>, FriendsListDaoCustom {

	public static final String sql_findFriendsByUserId = 
			"select id, user_a, user_b from friends_list where user_b =:userId " +
			"union " +
			"select id, user_a, user_b from friends_list where user_a =:userId ";
	
	@Query(value = sql_findFriendsByUserId, nativeQuery = true)
	public List<FriendsList> findFriendsByUserId(@Param("userId") Long userId);
}
