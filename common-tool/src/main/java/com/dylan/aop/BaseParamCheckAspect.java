package com.dylan.aop;

import com.dylan.utils.UtilsParamCheck;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/30 14:06
 */
public abstract class BaseParamCheckAspect {
	protected final  boolean[] flag = {true};
	protected Object param = null;
	protected String resultMsg;

	/**
	 * 切点
	 * 只检查添加了paramcheck注解的方法
	 */
	public abstract void paramCheck();

	/**
	 * 参数检查
	 * @param joinPoint
	 */
	public abstract void handleParamCheck(JoinPoint joinPoint);

	/**
	 * 方法上是否添加了 ParamCheck注解
	 * @param joinPoint
	 * @return
	 */
	protected boolean methodIsHasParamCheckAnnotation(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		return method.isAnnotationPresent(ParamCheck.class);
	}

	/**
	 * 获取参数校验结果
	 * @return
	 */
	private Map<String, Boolean> getCheckMapResult(){
		return UtilsParamCheck.paramCheck(param);
	}

	/**
	 * 处理参数校验结果
	 *
	 * @return
	 */
	protected boolean paramIsVoid(){
		Map<String, Boolean> checkMapResult = getCheckMapResult();
		StringBuilder stringBuilder = new StringBuilder();
		checkMapResult.entrySet().forEach(entry->{
			if (!entry.getValue()){
				flag[0] = false;
				stringBuilder.append(entry.getKey());
			}
		});
		resultMsg = stringBuilder.toString();
		return flag[0];
	}
}
