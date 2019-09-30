package com.dylan.aop;

import com.dylan.utils.UtilsDate;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/30 14:20
 */
@Slf4j
public abstract class BaseLogAspect {
	protected String methodName;//方法名
	protected String clazzName;//类名

	/**
	 * 切点
	 */
	public abstract void logPointCut();

	/**
	 * 方法处理之前 记录 ：时间，请求参数等
	 * @param joinPoint
	 */
	public abstract void beforeHandle(JoinPoint joinPoint);

	/**
	 * 方法处理之后记录
	 * @param object
	 */
	public abstract void afterHandle(Object object);


	protected void recordLogBefore(JoinPoint joinPoint){
		Signature signature = joinPoint.getSignature();
		methodName = signature.getName();//方法名
		clazzName = joinPoint.getTarget().getClass().getName();//类名
		log.info("当前时间："+ UtilsDate.getCurrentTime()+"  "+ clazzName+"#"+methodName+" 开始执行");
		log.info("参数:{"+joinPoint.getArgs()[0]+"}");
	}

	protected void recordLogAfter(Object object){
		log.info("当前时间："+UtilsDate.getCurrentTime()+"  "+ clazzName+"#"+methodName+" 执行结束");
		log.info("返回："+object);
	}


}
