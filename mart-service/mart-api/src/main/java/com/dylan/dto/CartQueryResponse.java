package com.dylan.dto;

import com.dylan.Result.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 17:00
 */
@Data
public class CartQueryResponse extends AbstractResponse {

	private List<CartDto> cartDtoList;

	private Integer total;
}
