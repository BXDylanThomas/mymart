package com.dylan.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/28 12:31
 */
public class UtilsJson {

	/**
	 * String -> JSONobject
	 * @param str
	 * @return
	 */
	public static JSONObject getJsonObject(String str){
		return JSONArray.parseObject(str);
	}

	/**
	 * jsonobject  ->jsonarray
	 * @param jsonObject
	 * @param str
	 */
	public static JSONArray getJsonArrayFromJsonObject(JSONObject jsonObject,String str){
		return jsonObject.getJSONArray(str);
	}

	/**
	 * jsonarray -> jsonobject
	 * @param jsonArray
	 * @param index
	 * @return
	 */
	public static JSONObject getJsonObjectFromJsonArray(JSONArray jsonArray,int index){
		return jsonArray.getJSONObject(index);
	}

	/**
	 * 拼接2个 json 字符串
	 * @param first
	 * @param second
	 * @return
	 */
	public static JSONObject getJsonStrJoinAnother(String first,String second){
		JSONObject firstJson = getJsonObject(first);
		JSONObject secondJson = getJsonObject(second);
		secondJson.keySet().forEach(key->{
			firstJson.put(key,secondJson.get(key));
		});
		return firstJson;
	}

	private static Object getJsonContent(JSONObject jsonObject,String str){
		return jsonObject.get(str);
	}


}
