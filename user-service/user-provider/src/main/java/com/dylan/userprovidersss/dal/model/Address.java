package com.dylan.userprovidersss.dal.model;

import com.dylan.sqlprovider.MyId;
import lombok.Data;

import java.io.Serializable;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 21:04
 */
@Data
public class Address implements Serializable {

    @MyId
    private Integer addressId;
    private Integer userId;
    private String userName;
    private String phone;
    private String addressDetail;
    private Integer isDefault;
    private String makeTime;
    private String modifyTime;
}
