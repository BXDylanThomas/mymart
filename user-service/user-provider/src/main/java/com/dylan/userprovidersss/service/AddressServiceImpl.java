package com.dylan.userprovidersss.service;

import com.dylan.AddressService;
import com.dylan.aop.ParamCheck;
import com.dylan.constants.UserCodeConstants;
import com.dylan.dto.*;
import com.dylan.userprovidersss.converter.AddressConverter;
import com.dylan.userprovidersss.dal.dao.AddressDao;
import com.dylan.userprovidersss.dal.model.Address;
import com.dylan.userprovidersss.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 17:27
 */
@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @ParamCheck
    @Override
    public UserAbstractResponse addressQuery(AddressQueryRequest addressQueryRequest) {

        AddressQueryResponse addressQueryResponse = new AddressQueryResponse();
        List<Address> result = addressDao.addressQuery(addressQueryRequest);
        addressQueryResponse = (AddressQueryResponse) ResponseUtils.getResponse(result, addressQueryResponse, UserCodeConstants.SUCCESS, UserCodeConstants.SYSTEM_ERROR);
        List<AddressDto> addressDtos = AddressConverter.INSTANCE.addressList(result);
        addressQueryResponse.setAddressDtoList(addressDtos);
       return addressQueryResponse;
    }

    @ParamCheck
    @Override
    public UserAbstractResponse addressAdd(AddressAddRequest addressAddRequest) {
        AddressAddResponse addressAddResponse = new AddressAddResponse();
        Integer result = addressDao.addressAdd(addressAddRequest);
        addressAddResponse = (AddressAddResponse) ResponseUtils.getResponse(result, addressAddResponse,UserCodeConstants.SUCCESS,UserCodeConstants.SYSTEM_ERROR);
        return addressAddResponse;
    }

    @ParamCheck
    @Override
    public UserAbstractResponse addressDeleteByUserId(AddressDeleteRequest addressDeleteRequest) {
        AddressDeleteResponse addressDeleteResponse = new AddressDeleteResponse();
        Integer result = addressDao.addressDelete(addressDeleteRequest);
        addressDeleteResponse  = (AddressDeleteResponse) ResponseUtils.getResponse(result, addressDeleteResponse, UserCodeConstants.SUCCESS, UserCodeConstants.SYSTEM_ERROR);
        return addressDeleteResponse;
    }

    @ParamCheck
    @Override
    public UserAbstractResponse addressUpdate(AddressUpdateRequest addressUpdateRequest) {
        AddressUpdateResponse addressUpdateResponse = new AddressUpdateResponse();
        Integer result = addressDao.addressUpdate(addressUpdateRequest);
        addressUpdateResponse  = (AddressUpdateResponse) ResponseUtils.getResponse(result, addressUpdateResponse, UserCodeConstants.SUCCESS, UserCodeConstants.SYSTEM_ERROR);
        return addressUpdateResponse;
    }
}
