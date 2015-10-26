package com.hkesports.matchticker.repository;

import com.hkesports.matchticker.model.Notification;
import com.hkesports.matchticker.repository.custom.NotificationDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

/**
 * @author manboyu
 *
 */
public interface NotificationDao extends GenericRepository<Notification, Long>, NotificationDaoCustom {

}
