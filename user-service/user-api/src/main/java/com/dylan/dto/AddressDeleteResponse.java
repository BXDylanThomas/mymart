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
public class AddressDeleteResponse extends AbstractResponse {


    @Override
    public String toString() {
        return "RegisterResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
