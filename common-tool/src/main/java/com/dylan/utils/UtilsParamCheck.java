package com.dylan.utils;

import com.dylan.utils.paramcheck.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/29 16:59
 */
@Slf4j
public class UtilsParamCheck {

	public static Map<String,Boolean> paramCheck(Object object){
		Map<String,Boolean> result = new HashMap<>();
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object value = field.get(object);
				log.info("开始校验,类名："+clazz.getName()+" 【参数："+field.getName()+"，值："+value+"】");
				if (field.getAnnotations().length == 0){ continue; }
				Object[] obj = startCheck(field, value);
				result.put((String)obj[0],(boolean)obj[1]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private static Object[] startCheck(Field field,Object value) throws Exception {
		Object[] result = new Object[2];
		Class clazz = getValidParamType(field);
		if (clazz == null) return new Object[]{false,"无当前注解,请IT后续开发"};
		ValidParamAdaptor pam = (ValidParamAdaptor) clazz.newInstance();
		if (pam.isSupport(field)){
			result = pam.paramCheck(field, value);
		}
		return result;
	}

	private static Class<? extends ValidParamAdaptor> getValidParamType(Field field){
		if (field.isAnnotationPresent(Min.class)){
			return MinParamAdaptor.class;
		}
		if (field.isAnnotationPresent(NotNull.class)){
			return NotNullParamAdaptor.class;
		}
		if (field.isAnnotationPresent(Email.class)){
			return EmailParamAdaptor.class;
		}
		if (field.isAnnotationPresent(Pattern.class)){
			return PatternParamAdaptor.class;
		}
		return null;
	}



}
