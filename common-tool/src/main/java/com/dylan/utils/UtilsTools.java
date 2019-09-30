package com.dylan.utils;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/29 15:00
 */
public class UtilsTools {

	/**
	 * 是否是基本类型的默认类型
	 *
	 * @param clazz
	 * @param value
	 * @return
	 */
	public static boolean isBaseDefaultValue(Class clazz,Object value){
		if (clazz == boolean.class || clazz == Boolean.class ){
			return Boolean.FALSE.equals(value);
		}
		if (clazz == char.class || clazz == Character.class ){
			return value !=null && 0 == (char)value;
		}
		if (clazz.isPrimitive() || isBaseNumberClass(clazz)){
			return value !=null && ((Number)value).doubleValue()== 0;
		}
		return false;
	}

	/**
	 * 校验是否是数值类型的包装类型
	 *
	 * @param clazz
	 * @return
	 */
	public static boolean isBaseNumberClass(Class clazz){
		return clazz == Byte.class || clazz == Integer.class  || clazz == Short.class || clazz ==Long.class || clazz == Double.class || clazz ==Float.class;
	}
}
