package com.dylan.userprovidersss.service;

import com.dylan.UserLoginService;
import com.dylan.constants.UserCodeConstants;
import com.dylan.dto.*;
import com.dylan.aop.ParamCheck;
import com.dylan.userprovidersss.converter.UserConverter;
import com.dylan.userprovidersss.dal.dao.UserDao;
import com.dylan.userprovidersss.dal.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 21:46
 */
@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserDao userDao;
    private LoginResponse loginResponse = null;;
    private UserUpdateResponse userUpdateResponse = null;


    @ParamCheck
    @Override
    public UserAbstractResponse login(LoginRequest loginRequest) {

        loginResponse = new LoginResponse();
        User login = userDao.select(loginRequest);
        if (login == null ){
            loginResponse.setCode(UserCodeConstants.NAMEORPASSWORD_RRROR.getCode());
            loginResponse.setMsg(UserCodeConstants.NAMEORPASSWORD_RRROR.getMessage());
        }
        loginResponse = UserConverter.INSTANCE.userConverter(login);
        loginResponse.setCode(UserCodeConstants.SUCCESS.getCode());
        loginResponse.setMsg(UserCodeConstants.SUCCESS.getMessage());
        return loginResponse;
    }

    @ParamCheck
    @Override
    public UserAbstractResponse update(UserUpdateRequest userUpdateRequest) {
        Integer result = userDao.update(userUpdateRequest);
        userUpdateResponse = new UserUpdateResponse();
        if (result !=null && result>0){
            userUpdateResponse.setCode(UserCodeConstants.SUCCESS.getCode());
            userUpdateResponse.setMsg(UserCodeConstants.SUCCESS.getMessage());
        }else{
            userUpdateResponse.setCode(UserCodeConstants.USER_UPDATE_ERROR.getCode());
            userUpdateResponse.setMsg(UserCodeConstants.USER_UPDATE_ERROR.getMessage());
        }

        return userUpdateResponse;
    }
}
