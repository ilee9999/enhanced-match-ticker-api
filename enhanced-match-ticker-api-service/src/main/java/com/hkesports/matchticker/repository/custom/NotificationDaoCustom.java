package com.hkesports.matchticker.repository.custom;

import java.util.List;

import com.hkesports.matchticker.vo.keepalive.SystemNotificationVo;

/**
 * @author manboyu
 *
 */
@Deprecated
public interface NotificationDaoCustom {

	public List<SystemNotificationVo> getSystemNotifications(Long userId, Long matchId);
}
