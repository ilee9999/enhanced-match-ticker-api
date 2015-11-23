package com.hkesports.matchticker.repository;

import com.hkesports.matchticker.model.NotificationDetail;
import com.hkesports.matchticker.repository.custom.NotificationDetailDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

public interface NotificationDetailDao extends GenericRepository<NotificationDetail, Long>, NotificationDetailDaoCustom  {

}
