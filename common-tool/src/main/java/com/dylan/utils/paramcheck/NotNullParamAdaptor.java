package com.dylan.utils.paramcheck;

import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/29 17:27
 */
public class NotNullParamAdaptor extends AbstractParamAdaptor implements ValidParamAdaptor {

	@Override
	public boolean isSupport(Field field) {
		return field.isAnnotationPresent(NotNull.class);
	}

	@Override
	public Object[] paramCheck(Field field, Object value) {
		NotNull notNullAnn = field.getAnnotation(NotNull.class);
		message = notNullAnn.message();
		flag = !valueCheck(value);//是否满足校验
		return super.createParamCheckResult(field,value);
	}

	protected boolean valueCheck(Object value) {
		return value == null || StringUtils.isBlank((String)value);
	}

}
