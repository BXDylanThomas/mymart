package com.dylan.martprovider.dal.entity;

import com.dylan.sqlprovider.MyId;
import lombok.Data;

import java.math.BigDecimal;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/6 18:08
 */
@Data
public class Goods {

    @MyId
    private Integer id;

    private String title;

    private String sellPoint;

    private BigDecimal price;

    private Integer num;

    private Integer limitNum;

    private String image;

    private Integer status;

    private String  makeTime;

    private String modifyTime;
}
