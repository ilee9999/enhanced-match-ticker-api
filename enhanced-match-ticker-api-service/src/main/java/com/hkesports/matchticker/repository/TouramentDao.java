package com.hkesports.matchticker.repository;

import com.hkesports.matchticker.model.Tourament;
import com.hkesports.matchticker.repository.custom.TouramentDaoCustom;
import com.hkesports.matchticker.repository.factory.GenericRepository;

/**
 * @author manboyu
 *
 */
public interface TouramentDao extends GenericRepository<Tourament, Long>, TouramentDaoCustom {

}
