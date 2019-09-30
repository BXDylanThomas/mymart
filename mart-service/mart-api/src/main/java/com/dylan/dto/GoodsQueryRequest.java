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
public class GoodsQueryRequest extends AbstractRequest {

	@Min(value = 1 ,message = "商品id最小为1")
	private Integer id;
}
