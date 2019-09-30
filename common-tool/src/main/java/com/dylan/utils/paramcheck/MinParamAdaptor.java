package com.dylan.utils.paramcheck;

import javax.validation.constraints.Min;
import java.lang.reflect.Field;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/29 17:11
 */
public class MinParamAdaptor extends AbstractParamAdaptor implements ValidParamAdaptor {
	private long compareValue;

	@Override
	public boolean isSupport(Field field) {
		return field.isAnnotationPresent(Min.class);
	}

	@Override
	public Object[] paramCheck(Field field, Object value) {
		Min minAnn = field.getAnnotation(Min.class);
		compareValue = minAnn.value();
		message = minAnn.message();
		flag = !valueCheck(value);
		return super.createParamCheckResult(field,value);
	}

	@Override
	protected  boolean valueCheck(Object value) {
		return value == null ||compareValue > ((Number)value).doubleValue();
	}

}
