package com.dylan.Exception;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 17:19
 */

public class BaseException  extends RuntimeException{

    protected String errCode;//错误代码
    protected String errMessage;//错误信息


    public BaseException(){
    }

    public BaseException(String message, String errCode) {
        super(message);
        this.errCode = errCode;
    }

    public BaseException(String message, Throwable cause, String errCode) {
        super(message, cause);
        this.errCode = errCode;
    }

    public BaseException(Throwable cause, String errCode) {
        super(cause);
        this.errCode = errCode;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public BaseException setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public BaseException setErrMessage(String errMessage) {
        this.errMessage = errMessage;
        return this;
    }
}
