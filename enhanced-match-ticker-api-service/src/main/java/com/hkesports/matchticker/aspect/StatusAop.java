package com.hkesports.matchticker.aspect;

import java.sql.SQLException;

import javax.persistence.PersistenceException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.hkesports.matchticker.enums.StatusCodeEnum;
import com.hkesports.matchticker.vo.BasicVo;

/**
 * @author manboyu
 *
 */
@Component
@Aspect
public class StatusAop {

	private static final Logger logger = LoggerFactory.getLogger(StatusAop.class);
	
	@Pointcut("execution(com.hkesports.matchticker.vo.BasicVo+ com.hkesports.matchticker.service.impl.*.*(..))")
	public void statusPointcut() { }
	
	@Around("statusPointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		try {
			return pjp.proceed();
		} catch (DataAccessException | PersistenceException | HibernateException | SQLException e) {
			logger.error("exception occur : ", e);
			return getBasicVo(pjp, StatusCodeEnum.STATUS_302.getValue());
		} catch (Exception e) {
			logger.error("exception occur : ", e);
			return getBasicVo(pjp, StatusCodeEnum.STATUS_301.getValue());
		}
	}
	
	private BasicVo getBasicVo(ProceedingJoinPoint pjp, int statusCode) throws InstantiationException, IllegalAccessException {
		Signature sig = pjp.getSignature();
		if(sig instanceof MethodSignature) {
			Object obj = ((MethodSignature) sig).getReturnType().newInstance();
			if(obj instanceof BasicVo) {
				((BasicVo) obj).setStatusCode(statusCode);
				return (BasicVo) obj;
			}
		}
		return null;
	}
}
