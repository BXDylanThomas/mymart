package com.dylan.dto;

import com.dylan.Exception.ValidException;
import com.dylan.Result.AbstractRequest;
import com.dylan.constants.UserCodeConstants;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 15:00
 */
@Data
public class AddressQueryRequest extends AbstractRequest {

    private Integer userId;

    @Override
    public void requestCheck() {
        //校验参数不能为空
        if (userId ==null || userId == 0 ) {
            throw new ValidException(UserCodeConstants.REQUEST_DATA_FAILUE.getCode(), UserCodeConstants.REQUEST_DATA_FAILUE.getMessage());
        }
    }
}
