package com.dylan.userprovidersss.aop;

import com.dylan.aop.BaseLogAspect;
import com.dylan.utils.UtilsDate;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/30 13:58
 */
@Slf4j
@Aspect
public class UserLogAspect extends BaseLogAspect {

	@Pointcut("execution(* com.dylan.userprovidersss.service.*.*(..))")
	public void logPointCut(){}

	@Before("logPointCut()")
	public void beforeHandle(JoinPoint joinPoint){
		super.recordLogBefore(joinPoint);
	}

	@AfterReturning(returning ="object", pointcut = "logPointCut()")
	public void afterHandle(Object object){
		super.recordLogAfter(object);
	}
}
