package com.dylan.userprovidersss.dal.model;

import com.dylan.sqlprovider.MyId;
import lombok.Data;

import java.io.Serializable;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 20:55
 */
@Data
public class User implements Serializable {

    @MyId
    private Integer userId;
    private String userName;
    private String password;
    private String sex;
    private String headImage;
    private String makeTime;
    private String modifyTime;
}
