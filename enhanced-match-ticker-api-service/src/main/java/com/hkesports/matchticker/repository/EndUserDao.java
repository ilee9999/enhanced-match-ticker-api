package com.hkesports.matchticker.repository;

import com.hkesports.matchticker.model.EndUser;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface EndUserDao extends GenericRepository<EndUser, Long> {

	public EndUser findByAuthUserId(Long userId);
}
