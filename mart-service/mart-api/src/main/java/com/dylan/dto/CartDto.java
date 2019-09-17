package com.dylan.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 17:00
 */
@Data
public class CartDto implements Serializable {

	private Integer userId;
	private Integer goodsId;
	private Integer goodsNum;

}
