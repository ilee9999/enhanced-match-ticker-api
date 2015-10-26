package com.hkesports.matchticker.repository;

import java.util.List;

import com.hkesports.matchticker.model.NotificationReadHistory;
import com.hkesports.matchticker.repository.factory.GenericRepository;

/**
 * @author manboyu
 *
 */
public interface NotificationReadHistoryDao extends GenericRepository<NotificationReadHistory, Long> {

	public List<NotificationReadHistory> findByUserIdAndNotificationId(Long userId, Long notificationID);
}
