package com.dylan.Exception;

import lombok.Data;

/**
 * code is far away from bug with the animal protecting
 *
 * 参数无效异常
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 17:18
 */
@Data
public class ValidException  extends BaseException{


    public ValidException() {
    }

    public ValidException(String message, String errCode) {
        super(message, errCode);
    }

    public ValidException(String message, Throwable cause, String errCode) {
        super(message, cause, errCode);
    }

    public ValidException(Throwable cause, String errCode) {
        super(cause, errCode);
    }

    public ValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errCode) {
        super(message, cause, enableSuppression, writableStackTrace, errCode);
    }

}
