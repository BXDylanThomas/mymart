package com.dylan.Result;

import lombok.Data;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/20 17:45
 */
@Data
public class PageRequest extends AbstractRequest {

	private int currentPage;
	private int size;


}
