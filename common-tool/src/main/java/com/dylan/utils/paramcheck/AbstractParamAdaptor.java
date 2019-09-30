package com.dylan.utils.paramcheck;

import java.lang.reflect.Field;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/30 9:49
 */
public abstract class AbstractParamAdaptor implements ValidParamAdaptor{
	protected String message;
	protected boolean flag = false; // 默认为false，不符合校验


	protected abstract boolean valueCheck(Object value);

	/**
	 * 返回参数校验结果
	 * flag true 参数没有问题
	 * 		false 参数不符合
	 * @param field
	 * @param value
	 * @return
	 */
	protected  Object[] createParamCheckResult(Field field,Object value){
		message = this.getMessage(field, value);
		return new Object[]{message,this.flag};
	}

	private String getMessage(Field field,Object value){
		return flag ? "" : getErrMessage(field,value,message);
	}

	private String getErrMessage(Field field,Object value,String message){
		return "【属性："+field.getName()+",值："+value+"】,错误内容："+message;
	}


}
