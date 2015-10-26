package com.hkesports.matchticker.repository;

import com.hkesports.matchticker.model.Team;
import com.hkesports.matchticker.repository.custom.TeamDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface TeamDao extends GenericRepository<Team, Long>, TeamDaoCustom {
	
}
