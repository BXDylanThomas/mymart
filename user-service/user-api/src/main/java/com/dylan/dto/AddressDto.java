package com.dylan.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 17:19
 */
@Data
public class AddressDto  implements Serializable {

    private Integer addressId;
    private Integer userId;
    private String userName;
    private String phone;
    private String addressDetail;
    private Integer isDefault;
    private String makeTime;
    private String modifyTime;

}
