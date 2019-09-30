package com.dylan.userprovidersss.aop;

import com.dylan.Exception.ValidException;
import com.dylan.aop.BaseExceptionAspect;
import com.dylan.aop.ParamCheck;
import com.dylan.constants.UserCodeConstants;
import com.dylan.dto.UserAbstractResponse;
import com.dylan.utils.UtilsDate;
import com.dylan.utils.UtilsExceptionProcess;
import com.dylan.utils.UtilsParamCheck;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/28 16:38
 */
@Aspect
@Component
@Slf4j
public class UserExceptionAspect extends BaseExceptionAspect {

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
			UserAbstractResponse userAbstractResponse = new UserAbstractResponse();
			UtilsExceptionProcess.exceptionProcessHandle(userAbstractResponse,e);
			return userAbstractResponse;
		}
		return reObject;
	}

}
