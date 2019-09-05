package com.dylan.Exception;

import com.dylan.Result.AbstractResponse;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 9:28
 */
public class ExceptionUtils  {

    public static AbstractResponse handleException(AbstractResponse response,Exception e) throws Exception {

        if (e == null) {
            return null;
        }

        if (e instanceof ValidException){
            response.setCode(((ValidException)e).getErrCode());
            response.setCode(((ValidException)e).getMessage());
        }if (e instanceof ProcessException){
            response.setCode(((ProcessException)e).getErrCode());
            response.setCode(((ProcessException)e).getMessage());
        }

        else {
            throw e;
        }

        return response;
    }
}
