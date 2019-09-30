package com.dylan.dto;

import lombok.Data;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/9 10:42
 */
@Data
public class GoodsAllQueryResponse extends MartAbstractResponse {

    private List<GoodsDto> goodsDtoList;

    private long total;
}
