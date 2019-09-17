package com.dylan.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/9 10:42
 */
@Data
public class GoodsDto implements Serializable {

    private Integer id;

    private String title;

    private String sellPoint;

    private BigDecimal price;

    private Integer num;

    private Integer limitNum;

    private String image;

}
