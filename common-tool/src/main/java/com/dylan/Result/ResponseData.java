package com.dylan.Result;

import lombok.Data;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 9:34
 */
@Data
public class ResponseData<T> {

    private Boolean success;
    private String message;
    private Integer code;
    private T result;//返回数据
}
