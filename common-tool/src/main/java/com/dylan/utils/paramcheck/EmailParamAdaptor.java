package com.dylan.utils.paramcheck;

import javax.validation.constraints.Email;
import java.lang.reflect.Field;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/29 17:11
 */
public class EmailParamAdaptor extends AbstractParamAdaptor  {
	private String regex;

	@Override
	public boolean isSupport(Field field) {
		return field.isAnnotationPresent(Email.class);
	}

	@Override
	public Object[] paramCheck(Field field, Object value) {
		Email emailAnn = field.getAnnotation(Email.class);
		regex = emailAnn.regexp();
		message = emailAnn.message();
		flag = !valueCheck(value);
		return super.createParamCheckResult(field,value);
	}

	@Override
	protected  boolean valueCheck(Object value) {
		return value == null || !ParamUtils.matchRegex((String)value,regex);
	}
}
