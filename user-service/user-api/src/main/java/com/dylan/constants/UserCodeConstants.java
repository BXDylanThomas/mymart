package com.dylan.constants;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 11:11
 */
public enum UserCodeConstants {

    SUCCESS("000000", "成功"),
    REQUEST_DATA_FAILUE("000001", "请求参数校验失败"),
    SYSTEM_ERROR("000002", "系统错误"),

    NAMEORPASSWORD_RRROR("000301", "用户名或密码错误"),
    NAME_EXISTS("000302", "用户名已经存在"),
    REGISTER_ERROR("000303", "注册失败，联系管理员"),
    USER_UPDATE_ERROR("000601","用户修改失败"),
    USER_PASSWORD_ERROR("000602","原始密码错误"),
    ;

    private String code;
    private String message;

    UserCodeConstants(String code, String message) {
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
        for (UserCodeConstants value : UserCodeConstants.values()) {
            if (value.code.equals(code)) {
                return value.message;
            }
        }
        return null;
    }

}
