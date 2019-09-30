package com.dylan.dto;

import com.dylan.Result.AbstractRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 16:55
 */
public class AddressUpdateRequest extends AbstractRequest {

    @Min(value = 1 ,message = "地址编号最小为1")
    private Integer addressId;
    @Pattern(regexp = "^1(3|4|5|6|7|8|9)\\d{9}$",message = "手机号码无效")
    private String phone;
    @NotNull(message = "必须填写地址")
    private String addressDetail;
    private Integer isDefault;
    private String modifyTime;


}
