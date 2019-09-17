package com.dylan.dto;

import com.dylan.Exception.ValidException;
import com.dylan.Result.AbstractRequest;
import com.dylan.constants.GoodsCodeConstants;
import lombok.Data;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 18:04
 */
@Data
public class CartUpdateRequest extends AbstractRequest {
	private Integer userId;
	private Integer goodsId;
	private Integer goodsNum;

	@Override
	public void requestCheck() {
		if (userId <=0  || goodsId<=0 || goodsNum<=0){
			throw  new ValidException(GoodsCodeConstants.REQUEST_DATA_FAILUE.getCode(),GoodsCodeConstants.REQUEST_DATA_FAILUE.getMessage());
		}
	}
}
