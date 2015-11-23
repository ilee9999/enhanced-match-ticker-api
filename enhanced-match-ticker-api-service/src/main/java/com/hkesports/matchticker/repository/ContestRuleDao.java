package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Query;

import com.hkesports.matchticker.model.ContestRule;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.getcontestrule.GetcontestruleVo;

/**
 * @author manboyu
 *
 */
public interface ContestRuleDao extends GenericRepository<ContestRule, Long> {

	@Query("select new com.hkesports.matchticker.vo.getcontestrule.GetcontestruleVo(c.enContestRule, c.twContestRule) from ContestRule c")
	public GetcontestruleVo findContestRule();
}
