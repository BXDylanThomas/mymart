package com.dylan.dto;

import com.dylan.Result.AbstractRequest;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 16:58
 */
@Data
public class CartQueryRequest extends AbstractRequest {

	@Min(value = 1 ,message = "用户id最小为1")
	private Integer userId;

}
