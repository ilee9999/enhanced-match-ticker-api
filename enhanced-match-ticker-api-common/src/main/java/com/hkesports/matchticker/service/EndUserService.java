package com.hkesports.matchticker.service;

import java.util.Date;

import org.apache.camel.InOnly;

import com.hkesports.matchticker.vo.KeepaliveReqVo;

/**
 * @author manboyu
 *
 */
public interface EndUserService {

	/**
	 * 取出notify資料後還會更新endUser的資料, 
	 * timestamp與visitDate做比較, 若不相同則更新visitDate,
	 * pollingDate則為當下時間
	 * 
	 * @param keepaliveReqVo
	 * @param instant
	 */
	@InOnly
	public void updateEndUserInfo(KeepaliveReqVo keepaliveReqVo, Date instant);
}
