package com.dylan.martprovider.aop;

import com.dylan.aop.BaseExceptionAspect;
import com.dylan.dto.MartAbstractResponse;
import com.dylan.utils.UtilsExceptionProcess;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/28 16:38
 */
@Aspect
@Component
@Slf4j
public class MartExceptionAspect extends BaseExceptionAspect {

	@Pointcut("execution(* com.dylan.userprovidersss.service.*.*(..))")
	public void exceptionPointCut(){}

	/**
	 *  统一异常处理
	 *
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("exceptionPointCut()")
	public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable{
		Object reObject = null;
		try{
			reObject = joinPoint.proceed(joinPoint.getArgs());
		}catch (Exception e){
			e.printStackTrace();
			MartAbstractResponse martAbstractResponse = new MartAbstractResponse();
			UtilsExceptionProcess.exceptionProcessHandle(martAbstractResponse,e);
			return martAbstractResponse;
		}
		return reObject;
	}

}
