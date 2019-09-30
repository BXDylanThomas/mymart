package com.dylan.dto;

import lombok.Data;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/9 10:42
 */
@Data
public class GoodsQueryResponse extends MartAbstractResponse {

    private GoodsDto goodsDto;

    private long total;
}
