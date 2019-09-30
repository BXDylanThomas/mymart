package com.dylan.utils.paramcheck;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.lang.reflect.Field;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/29 17:11
 */
public class PatternParamAdaptor extends AbstractParamAdaptor implements ValidParamAdaptor {
	private String regex;

	@Override
	public boolean isSupport(Field field) {
		return field.isAnnotationPresent(Pattern.class);
	}

	@Override
	public Object[] paramCheck(Field field, Object value) {
		Pattern patAnn = field.getAnnotation(Pattern.class);
		regex = patAnn.regexp();
		message = patAnn.message();
		flag = !valueCheck(value);
		return super.createParamCheckResult(field,value);
	}

	@Override
	protected  boolean valueCheck(Object value) {
		return value == null || !ParamUtils.matchRegex((String)value,regex);
	}
}
