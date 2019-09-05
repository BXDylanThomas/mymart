package com.dylan.userprovidersss.service;

import com.dylan.UserLoginService;
import com.dylan.constants.UserCodeConstants;
import com.dylan.dto.LoginRequest;
import com.dylan.dto.LoginResponse;
import com.dylan.userprovidersss.converter.UserConverter;
import com.dylan.userprovidersss.dal.dao.UserDao;
import com.dylan.userprovidersss.dal.model.User;
import com.dylan.userprovidersss.utils.ExceptionProcessUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("userLoginServiceImpl.login request -> "+loginRequest.toString());
        try{
            loginRequest.requestCheck();
            loginResponse = new LoginResponse();
            User login = userDao.login(loginRequest);
            if (login == null ){
                loginResponse.setCode(UserCodeConstants.NAMEORPASSWORD_RRROR.getCode());
                loginResponse.setMsg(UserCodeConstants.NAMEORPASSWORD_RRROR.getMessage());
            }
            loginResponse = UserConverter.INSTANCE.userConverter(login);
            loginResponse.setCode(UserCodeConstants.SUCCESS.getCode());
            loginResponse.setMsg(UserCodeConstants.SUCCESS.getMessage());

        }catch (Exception e ){
            log.error("userLoginServiceImpl.login occur exception -> "+e);
            ExceptionProcessUtil.exceptionProcessHandle(loginResponse,e);
        }

        return loginResponse;
    }
}
