package com.dylan.utils.paramcheck;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/30 9:33
 */
public class ParamUtils {

	public static boolean matchRegex(String value,String regex){
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(value);
		return matcher.matches();
	}

}
