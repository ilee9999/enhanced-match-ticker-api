package com.hkesports.matchticker.repository;

import org.springframework.data.jpa.repository.Query;

import com.hkesports.matchticker.model.PrivacyPolicy;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.getprivacypolicy.GetprivacypolicyVo;

public interface PrivacyPolicyDao extends GenericRepository<PrivacyPolicy, Long> {

	@Query("select new com.hkesports.matchticker.vo.getprivacypolicy.GetprivacypolicyVo(p.enPrivacyPolicy, p.twPrivacyPolicy) from PrivacyPolicy p")
	public GetprivacypolicyVo findPrivacypolicy();
}
