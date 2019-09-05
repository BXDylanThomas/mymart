package com.dylan.userprovidersss.service;

import com.dylan.AddressService;
import com.dylan.dto.*;
import com.dylan.userprovidersss.dal.dao.AddressDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

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
    public AddressQueryResponse addressQueryByUserid(AddressQueryResponse addressQueryResponse) {

        return null;
    }

    @Override
    public AddressAddResponse addressAdd(AddressAddRequest addressAddRequest) {
        return null;
    }

    @Override
    public AddressDeleteResponse addressDeleteByUserId(AddressDeleteRequest addressDeleteRequest) {
        return null;
    }

    @Override
    public AddressUpdateResponse addressUpdate(AddressUpdateRequest addressUpdateRequest) {
        return null;
    }
}
