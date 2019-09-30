package com.dylan.dto;

import lombok.Data;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 17:00
 */
@Data
public class CartQueryResponse extends MartAbstractResponse {

	private List<CartDto> cartDtoList;

	private Integer total;
}
