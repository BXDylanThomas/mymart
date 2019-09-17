package com.dylan.dto;

import com.dylan.Exception.ValidException;
import com.dylan.Result.AbstractRequest;
import com.dylan.constants.GoodsCodeConstants;
import lombok.Data;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/9 10:40
 */
@Data
public class GoodsQueryRequest extends AbstractRequest {

	private Integer id;
    private Integer page;
    private Integer pageSize;


    @Override
    public void requestCheck() {
        if (page<=0 || pageSize<=0){
            throw  new ValidException(GoodsCodeConstants.REQUEST_DATA_FAILUE.getCode(),GoodsCodeConstants.REQUEST_DATA_FAILUE.getMessage());
        }
    }
}
