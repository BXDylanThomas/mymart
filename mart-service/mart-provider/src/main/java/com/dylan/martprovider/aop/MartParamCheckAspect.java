package com.dylan.martprovider.aop;

import com.dylan.Exception.ValidException;
import com.dylan.aop.BaseParamCheckAspect;
import com.dylan.aop.ParamCheck;
import com.dylan.constants.MartCodeConstants;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/30 13:54
 */
@Slf4j
@Aspect
public class MartParamCheckAspect extends BaseParamCheckAspect {

	@Pointcut("@annotation(com.dylan.aop.ParamCheck)")
	public void paramCheck(){}

	/**
	 * 检查加了注解的 paramcheck 的方法，进行参数检查
	 *
	 * @param joinPoint
	 */
	@Before("paramCheck()")
	public void handleParamCheck(JoinPoint joinPoint){
		if (!super.methodIsHasParamCheckAnnotation(joinPoint))return;
		super.param = joinPoint.getArgs()[0];
		if (super.paramIsVoid()){
			throw new ValidException(MartCodeConstants.REQUEST_DATA_FAILUE.getCode()
					,MartCodeConstants.REQUEST_DATA_FAILUE.getMessage()+"详情：【"+super.resultMsg +"】");
		}
	}

}
