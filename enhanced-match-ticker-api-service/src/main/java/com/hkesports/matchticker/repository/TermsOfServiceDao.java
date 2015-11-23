package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Query;

import com.hkesports.matchticker.model.TermsOfService;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.gettermsofservice.GettermsofserviceVo;

/**
 * @author manboyu
 *
 */
public interface TermsOfServiceDao extends GenericRepository<TermsOfService, Long> {

	@Query("select new com.hkesports.matchticker.vo.gettermsofservice.GettermsofserviceVo(t.enTermsOfService, t.twTermsOfService) from TermsOfService t")
	public GettermsofserviceVo findGettermsofservice();
}
