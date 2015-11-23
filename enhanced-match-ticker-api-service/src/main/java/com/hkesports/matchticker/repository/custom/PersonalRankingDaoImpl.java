package com.hkesports.matchticker.repository.custom;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import com.hkesports.matchticker.enums.UserActivityTypeEnum;
import com.hkesports.matchticker.utils.DateUtil;
import com.hkesports.matchticker.vo.getpersonalranking.FriendRankVo;
import com.hkesports.matchticker.vo.getpersonalranking.RankVo;

public class PersonalRankingDaoImpl extends BasicDaoImpl implements PersonalRankingDaoCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	private static final String sql_findByFriendUserIds = 
			"select result.user_id as userId, result.rank, result.name as friendName, result.ha, result.isGift, result.profilePictureUrl, if(result.user_id =:uId, true, false) as itself " + 
			"from ( " +
			"	select b.*,  @prev\\:=@curr, @curr\\:=b.ha,  @rank\\:=(if(@prev=@curr, @rank, @rank + @rcount)) as rank, @rcount\\:=(if(@prev=@curr, @rcount + 1, 1)) " +		
			"	from ( " +
			"		select p.id, p.user_id, u.name, p.ha, if(uar.id is not null, 1, 0) as isGift, up.profile_picture_url as profilePictureUrl " +
			"		from personal_ranking p " +
			"		left join ( " +
			"			select user_a as user_id from friends_list where user_b =:uId " +
			"			union " + 
			"   		select user_b as user_id from friends_list where user_a =:uId " +
			"		) f on p.user_id = f.user_id " +
			"		inner join user u on p.user_id = u.id " +
			"		inner join user_profile up on u.id = up.user_id " +
			"		left join user_activity_record uar on f.user_id = uar.foreign_key and activity_type =:userActivityType and uar.user_id =:uId and uar.create_date =:today " +
			"		where p.rank_date =:today " +
			"		and (f.user_id is not null or p.user_id =:uId) " +
			"		order by ha desc " +
			"	) as b, (select @curr\\:=null, @prev\\:=null, @rank\\:= 0, @rcount\\:=1) init " +
			") result ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FriendRankVo> findByFriendUserId(Long userId) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery queryObj = session.createSQLQuery(sql_findByFriendUserIds);
		ResultTransformer transformer = Transformers.aliasToBean(FriendRankVo.class);
		addScalars(FriendRankVo.class, queryObj);
		queryObj.setResultTransformer(transformer);
		queryObj.setParameter("userActivityType", UserActivityTypeEnum.GIFT_FRIEND_HA.name());
		queryObj.setParameter("uId", userId);
		queryObj.setParameter("today", DateUtil.toDateInt(new Date()));
		return queryObj.list();
	}

	private static final String jpql_findPersonalRankingsByLimit = 
			"select new com.hkesports.matchticker.vo.getpersonalranking.RankVo(p.user.id, p.rank, p.user.account, p.ha) " +
			"from PersonalRanking p where p.rankDate=:today " +
			"order by p.rank ";
	
	@Override
	public List<RankVo> findPersonalRankingsByLimit(Integer max, Integer today) {
		return findPersonalRankingsByLimit(0, max, today);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RankVo> findPersonalRankingsByLimit(Integer first, Integer max, Integer today) {
		Query queryObj = entityManager.createQuery(jpql_findPersonalRankingsByLimit);
		queryObj.setParameter("today", today);
		queryObj.setFirstResult(first);
		queryObj.setMaxResults(max);
		return queryObj.getResultList();
	}
}
