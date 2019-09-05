package com.dylan.dto;

import com.dylan.Result.AbstractResponse;
import lombok.Data;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 15:00
 */
@Data
public class LoginResponse extends AbstractResponse {
    private Integer userId;
    private String userName;
    private String password;
    private String sex;
    private String headImage;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "code="+super.getCode()+
                ", msg="+super.getMsg()+
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", headImage='" + headImage + '\'' +
                '}';
    }
}
