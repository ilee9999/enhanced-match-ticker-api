package com.hkesports.matchticker.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.hkesports.matchticker.model.FriendsList;
import com.hkesports.matchticker.model.User;
import com.hkesports.matchticker.repository.FriendsListDao;
import com.hkesports.matchticker.repository.UserDao;
import com.hkesports.matchticker.test.AbstractTest;

public class FriendsListDaoTest extends AbstractTest {

	@Resource(name = "friendsListDao")
	private FriendsListDao friendsListDao;
	@Resource(name = "userDao")
	private UserDao userDao;
	
	@Test
	@Transactional
	@Rollback(false)
	@Ignore
	public void testSaveFriendList() {
		List<Long> userAIds = new ArrayList<>();
		for(int i = 80; i < 201; i++) {
			userAIds.add(new Long(i));
		}
		
		List<Long> userBIds = new ArrayList<>();
		for(int i = 800; i < 996; i++) {
			userBIds.add(new Long(i));
		}
		
		List<Long> userCIds = new ArrayList<>();
		for(int i = 300; i < 401; i++) {
			userCIds.add(new Long(i));
		}
		
		List<User> userAList = userDao.findByIdIn(userAIds);
		List<User> userBList = userDao.findByIdIn(userBIds);
		List<User> userCList = userDao.findByIdIn(userCIds);
		
		System.out.println("userA size : " + userAList.size());
		System.out.println("userB size : " + userBList.size());
		System.out.println("userC size : " + userCList.size());
		
		for(User userC : userCList) {
			for(User userB : userBList) {
				FriendsList friends = new FriendsList();
				friends.setUserA(userB);
				friends.setUserB(userC);
				friendsListDao.save(friends);
			}
		}
	}
	
	@Test
	public void testFindFriendsByUserId() {
		List<FriendsList> friends = friendsListDao.findFriendsByUserId(970L);
		Assert.assertTrue("friends is empty ! ", friends.size() > 0);
	}
}
