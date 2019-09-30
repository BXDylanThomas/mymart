package com.dylan.dto;

import com.dylan.Result.AbstractRequest;

import javax.validation.constraints.Min;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 16:55
 */
public class AddressDeleteRequest extends AbstractRequest {

    @Min(value = 1 ,message = "地址编号最小为1")
    private String addressId;
}
