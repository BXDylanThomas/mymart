package com.dylan.constants;

import com.alibaba.fastjson.JSONObject;
import com.dylan.utils.UtilsJson;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/28 12:47
 */
public class CodeConstants extends BaseCodeConstants {

	private String USER_CODE = "{" +
			" 'NAMEORPASSWORD_RRROR':[{'code':'100001','resultMsg':'用户名或密码错误'}]," +
			" 'NAME_EXISTS':[{'code':'100002','resultMsg':'用户名已经存在'}]," +
			" 'REGISTER_ERROR':[{'code':'100003','resultMsg':'注册失败，联系管理员'}],"+
			" 'USER_UPDATE_ERROR':[{'code':'100004','resultMsg':'用户修改失败'}],"+
			" 'USER_PASSWORD_ERROR':[{'code':'100005','resultMsg':'原始密码错误'}]"+
			"}";
	private String USERSYSTEMCODE = "";
	public JSONObject getUserCodeConstants(){
		return UtilsJson.getJsonStrJoinAnother(super.COMMON_SYSTEM_CODE(),USER_CODE);
	}

	public static JSONObject getUserSystemCode(){
		CodeConstants codeConstants = new CodeConstants();
		return codeConstants.getUserCodeConstants();
	}
	public String NAMEORPASSWORD_RRROR(){
		return "NAMEORPASSWORD_RRROR";
	}
	public String NAME_EXISTS(){
		return "NAME_EXISTS";
	}
	public String REGISTER_ERROR(){
		return "REGISTER_ERROR";
	}
	public String USER_UPDATE_ERROR(){
		return "USER_UPDATE_ERROR";
	}
	public String USER_PASSWORD_ERROR(){
		return "USER_PASSWORD_ERROR";
	}

	public enum Mode{
		SUCCESS,
		REQUEST_DATA_FAILUE,
		SYSTEM_ERROR,
		NAMEORPASSWORD_RRROR,
		NAME_EXISTS,
		REGISTER_ERROR,
		USER_UPDATE_ERROR,
		USER_PASSWORD_ERROR
	}
}
