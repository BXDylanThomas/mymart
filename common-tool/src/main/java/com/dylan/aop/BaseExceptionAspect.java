package com.dylan.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/30 14:15
 */
public abstract class BaseExceptionAspect {

	/**
	 * 切点
	 */
	public abstract void exceptionPointCut();

	/**
	 * 统一异常的处理方法
	 * @param joinPoint
	 * @return
	 */
	public abstract Object handleException(ProceedingJoinPoint joinPoint) throws Throwable;
}
