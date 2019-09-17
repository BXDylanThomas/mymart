package com.dylan.dto;

import com.dylan.Result.AbstractResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/9 10:42
 */
@Data
public class GoodsQueryResponse extends AbstractResponse {

    private List<GoodsDto> goodsDtoList;

    private long total;
}
