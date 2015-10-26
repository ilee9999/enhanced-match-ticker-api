package com.hkesports.matchticker.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hkesports.matchticker.model.EndUser;
import com.hkesports.matchticker.repository.EndUserDao;
import com.hkesports.matchticker.service.EndUserService;
import com.hkesports.matchticker.vo.KeepaliveReqVo;

@Service("endUserService")
public class EndUserServiceImpl implements EndUserService {
	
	@Resource(name = "endUserDao")
	private EndUserDao endUserDao;

	@Override
	@Transactional
	public void updateEndUserInfo(KeepaliveReqVo keepaliveReqVo, Date instant) {
		EndUser user = endUserDao.findByAuthUserId(keepaliveReqVo.getUserID());
		if(user != null) {
			Date visitDate = user.getVisitDate();
			if(!DateUtils.isSameInstant(visitDate, keepaliveReqVo.getTimestampToDate())) {
				user.setVisitDate(keepaliveReqVo.getTimestampToDate());
			}
			user.setPollingDate(instant);
			user.setClientType(keepaliveReqVo.getClientType());
			endUserDao.save(user);
		}
	}
}
