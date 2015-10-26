package com.hkesports.matchticker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hkesports.matchticker.model.LiveStreams;
import com.hkesports.matchticker.repository.factory.GenericRepository;
import com.hkesports.matchticker.vo.getmatchstatistics.GameVodVo;

public interface LiveStreamsDao extends GenericRepository<LiveStreams, Long> {

	public final static String JPQL_findVodsByGameId = "select new com.hkesports.matchticker.vo.getmatchstatistics.GameVodVo ( "
			  + "	s.type, s.url, s.embedCode "
			  + ") "
			  + "from LiveStreams as s "
			  + "where s.scheduleGame.id=:gameId ";

	@Query(JPQL_findVodsByGameId)
	public List<GameVodVo> findVodsByGameId(@Param("gameId") Long gameId);
}
