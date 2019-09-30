package com.dylan.dto;

import com.dylan.Result.AbstractRequest;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 17:03
 */
@Data
public class CartAddRequest extends AbstractRequest {

	@Min(value = 1 ,message = "用户id最小为1")
	private Integer userId;
	@Min(value = 1,message = "商品id最小为1")
	private Integer goodsId;
	@Min(value = 1,message = "商品数量最小为1")
	private Integer goodsNum;

}
