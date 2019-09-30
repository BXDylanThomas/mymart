package com.dylan.dto;

import com.dylan.Result.AbstractRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 15:00
 */
@Data
public class UserUpdateRequest extends AbstractRequest {

    private Integer userId;
    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "性别不能为空")
    private String sex;
    private String modifyTime;

}
