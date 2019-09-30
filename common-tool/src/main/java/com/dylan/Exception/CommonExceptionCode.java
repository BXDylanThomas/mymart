package com.dylan.Exception;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/30 11:06
 */
public enum  CommonExceptionCode {
	SYSTEM_ERROR("000002", "系统错误");

	private String code;
	private String message;

	CommonExceptionCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}

	public static String getMessage(String code) {
		if (code == null) {
			return null;
		}
		for (CommonExceptionCode value : CommonExceptionCode.values()) {
			if (value.code.equals(code)) {
				return value.message;
			}
		}
		return null;
	}
}
