package com.dylan.dto;

import com.dylan.Exception.ValidException;
import com.dylan.Result.AbstractRequest;
import com.dylan.constants.UserCodeConstants;
import org.apache.commons.lang3.StringUtils;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 16:55
 */
public class AddressUpdateRequest extends AbstractRequest {

    private Integer addressId;
    private String phone;
    private String addressDetail;
    private Integer isDefault;
    private String modifyTime;

    @Override
    public void requestCheck() {
        //校验参数不能为空
        if ( addressId == null ||addressId == 0 ) {
            throw new ValidException(UserCodeConstants.REQUEST_DATA_FAILUE.getCode(), UserCodeConstants.REQUEST_DATA_FAILUE.getMessage());
        }
    }
}
