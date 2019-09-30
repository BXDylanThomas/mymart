package com.dylan.constants;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/20 18:06
 */
public enum BaseConstant {

	SUCCESS("000000", "成功"),
	REQUEST_DATA_FAILUE("000360", "请求参数校验失败"),
	SYSTEM_ERROR("000361", "系统错误"),

	;

	private String code;
	private String message;

	BaseConstant(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static String getMessage(String code) {
		if (code == null) {
			return null;
		}
		for (BaseConstant value : BaseConstant.values()) {
			if (value.code.equals(code)) {
				return value.message;
			}
		}
		return null;
	}
}
