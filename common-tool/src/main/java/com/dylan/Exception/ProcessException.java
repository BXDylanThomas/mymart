package com.dylan.Exception;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 9:37
 */
public class ProcessException extends BaseException {

    public ProcessException() {
    }

    public ProcessException(String message, String errCode) {
        super(message, errCode);
    }

    public ProcessException(String message, Throwable cause, String errCode) {
        super(message, cause, errCode);
    }

    public ProcessException(Throwable cause, String errCode) {
        super(cause, errCode);
    }

    public ProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errCode) {
        super(message, cause, enableSuppression, writableStackTrace, errCode);
    }
}
