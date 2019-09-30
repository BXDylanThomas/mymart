package com.dylan.utils;

import com.dylan.Exception.CommonExceptionCode;
import com.dylan.Exception.ExceptionUtils;
import com.dylan.Result.AbstractResponse;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 10:16
 */
public class UtilsExceptionProcess {

    public static void exceptionProcessHandle(AbstractResponse response,Exception expection){
        try {
            ExceptionUtils.handleException(response,expection);
        }catch (Exception e){
            response.setCode(CommonExceptionCode.SYSTEM_ERROR.getCode());
            response.setMsg(CommonExceptionCode.SYSTEM_ERROR.getMessage());
        }
    }
}
