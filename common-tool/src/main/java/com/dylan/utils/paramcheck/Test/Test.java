package com.dylan.utils.paramcheck.Test;

import com.dylan.utils.UtilsParamCheck;

import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/29 17:57
 */
public class Test {

	public static void main(String[] args) {
		TestEntity testEntity = new TestEntity(0,null,"");
		Map<String, Boolean> map = UtilsParamCheck.paramCheck(testEntity);
		map.entrySet().forEach(entity->{
			System.out.println(entity.getKey()+"   "+entity.getValue());
		});
	}
}
