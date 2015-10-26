package com.hkesports.matchticker.service;

import org.apache.camel.InOnly;

import com.hkesports.matchticker.vo.KeepaliveReqVo;
import com.hkesports.matchticker.vo.keepalive.KeepaliveVo;

/**
 * @author manboyu
 *
 */
public interface KeepAliveService {

	/**
	 * KeepAlive Api.
	 * 
	 * 根據前台是否有傳userid跟matchid以及當下時間去取得notify的資料
	 * 有傳matchid則表示位於該match之中, 所以必須找出與showToMatchId相符的資料
	 * 有傳userid則去找尋notfify是否有該筆userid, 
	 * 若有則表示為私人訊息, 若無則去尋找notifyhistory有無資料, 若有則表示為已讀
	 * 
	 * 取出notify資料後還會更新endUser的資料, 
	 * timestamp與visitDate做比較, 若不相同則更新visitDate,
	 * pollingDate則為當下時間
	 * 
	 * 目前取出資料直接寫進一筆history資料當做已讀, 前提是必須有userid傳入
	 * 
	 * @param vo
	 * @return
	 */
	public KeepaliveVo keepalive(KeepaliveReqVo vo);
	
	/**
	 * 目前KeepAlive取出資料後, 直接新增一筆history資料當做已讀
	 * 
	 * @param userId
	 * @param notificationID
	 */
	@InOnly
	public void addNotificationHist(Long userId, Long notificationID);
}
