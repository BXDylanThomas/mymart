package com.dylan.userprovidersss.utils;

import com.dylan.Exception.ExceptionUtils;
import com.dylan.Result.AbstractResponse;
import com.dylan.constants.UserCodeConstants;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 10:16
 */
public class ExceptionProcessUtil  {

    public static void exceptionProcessHandle(AbstractResponse response,Exception expection){
        try {
            ExceptionUtils.handleException(response,expection);
        }catch (Exception e){
            response.setCode(UserCodeConstants.SYSTEM_ERROR.getCode());
            response.setMsg(UserCodeConstants.SYSTEM_ERROR.getMessage());
        }
    }
}
