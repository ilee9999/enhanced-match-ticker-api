package com.hkesports.matchticker.repository;

import java.util.List;

import com.hkesports.matchticker.model.User;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface UserDao extends GenericRepository<User, Long> {

	public List<User> findByIdIn(List<Long> ids);
}
