package com.dylan.constants;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/25 16:39
 */

public class BaseCodeConstants {

	private String COMMON_SYSTEM_CODE = "{" +
			" 'SUCCESS':[{'code':'000000','resultMsg':'处理成功'}]," +
			" 'REQUEST_DATA_FAILUE':[{'code':'000001','resultMsg':'请求参数校验失败'}]," +
			" 'SYSTEM_ERROR':[{'code':'000002','resultMsg':'系统错误'}]"+
			"}";
	private final String CODE = "code";
	private final String MESSAGE = "resultMsg";
	private Select select;

	public String COMMON_SYSTEM_CODE(){
		return COMMON_SYSTEM_CODE;
	}

	public static Select select(String key){
		BaseCodeConstants baseCodeConstants = new BaseCodeConstants();
		baseCodeConstants.initFrom(key);
		return baseCodeConstants.select;
	}

	public  void initFrom(String key){
		this.select = new Select(key);
	}

	public class Select {
		private String key;
		public Select(String key){
			this.key = key;
		}
		public From from(JSONObject jsonObject){
			return new From(jsonObject,key);
		}
	}

	public class From{
		private JSONObject jsonObject;
		private String key;
		private String[] result;
		public From(JSONObject jsonObject, String key) {
			this.jsonObject = jsonObject;
			this.key = key;
		}
		public String[] exe(){
			JSONArray jsonArray = jsonObject.getJSONArray(key);
			JSONObject jsonObject = jsonArray.getJSONObject(0);
			result[0] = (String) jsonObject.get(CODE);
			result[1] = (String) jsonObject.get(MESSAGE);
			return result;
		}
	}
}
