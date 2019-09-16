package com.dylan.userprovidersss.service;

import com.dylan.AddressService;
import com.dylan.constants.UserCodeConstants;
import com.dylan.dto.*;
import com.dylan.userprovidersss.converter.AddressConverter;
import com.dylan.userprovidersss.dal.dao.AddressDao;
import com.dylan.userprovidersss.dal.model.Address;
import com.dylan.userprovidersss.utils.ExceptionProcessUtil;
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

    @Override
    public AddressQueryResponse addressQuery(AddressQueryRequest addressQueryRequest) {
        AddressQueryResponse addressQueryResponse = new AddressQueryResponse();
        try{
            List<Address> result = addressDao.addressQuery(addressQueryRequest);
            addressQueryResponse = (AddressQueryResponse) ResponseUtils.getResponse(result, addressQueryResponse, UserCodeConstants.SUCCESS, UserCodeConstants.SYSTEM_ERROR);
            List<AddressDto> addressDtos = AddressConverter.INSTANCE.addressList(result);
            addressQueryResponse.setAddressDtoList(addressDtos);
        }catch (Exception  e){
            log.error("userLoginServiceImpl.select occur exception -> "+e);
            ExceptionProcessUtil.exceptionProcessHandle(addressQueryResponse,e);
        }
       return addressQueryResponse;
    }

    @Override
    public AddressAddResponse addressAdd(AddressAddRequest addressAddRequest) {
        AddressAddResponse addressAddResponse = new AddressAddResponse();
        try{
            addressAddRequest.requestCheck();
            Integer result = addressDao.addressAdd(addressAddRequest);
            addressAddResponse = (AddressAddResponse) ResponseUtils.getResponse(result, addressAddResponse,UserCodeConstants.SUCCESS,UserCodeConstants.SYSTEM_ERROR);
        }catch (Exception e){
            log.error("userLoginServiceImpl.select occur exception -> "+e);
            ExceptionProcessUtil.exceptionProcessHandle(addressAddResponse,e);
        }
        return addressAddResponse;
    }

    @Override
    public AddressDeleteResponse addressDeleteByUserId(AddressDeleteRequest addressDeleteRequest) {
        AddressDeleteResponse addressDeleteResponse = new AddressDeleteResponse();
        try {
            Integer result = addressDao.addressDelete(addressDeleteRequest);
            addressDeleteResponse  = (AddressDeleteResponse) ResponseUtils.getResponse(result, addressDeleteResponse, UserCodeConstants.SUCCESS, UserCodeConstants.SYSTEM_ERROR);
        }catch (Exception e){
            log.error("userLoginServiceImpl.select occur exception -> "+e);
            ExceptionProcessUtil.exceptionProcessHandle(addressDeleteResponse,e);
        }
        return addressDeleteResponse;
    }

    @Override
    public AddressUpdateResponse addressUpdate(AddressUpdateRequest addressUpdateRequest) {
        AddressUpdateResponse addressUpdateResponse = new AddressUpdateResponse();
        try {
            Integer result = addressDao.addressUpdate(addressUpdateRequest);
            addressUpdateResponse  = (AddressUpdateResponse) ResponseUtils.getResponse(result, addressUpdateResponse, UserCodeConstants.SUCCESS, UserCodeConstants.SYSTEM_ERROR);
        }catch (Exception e ){
            log.error("userLoginServiceImpl.select occur exception -> "+e);
            ExceptionProcessUtil.exceptionProcessHandle(addressUpdateResponse,e);
        }
        return addressUpdateResponse;
    }
}
