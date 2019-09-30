package com.dylan.dto;

import com.dylan.Result.AbstractRequest;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/9 10:40
 */
@Data
public class GoodsAllQueryRequest extends AbstractRequest {

    @Min(value = 1 ,message = "当前页数最小为1")
    private Integer page;
    @Min(value = 1 ,message = "当前页最小展示数量最小为1")
    private Integer pageSize;

}
