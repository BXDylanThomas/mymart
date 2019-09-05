package com.dylan.userprovidersss.service;

import com.dylan.Exception.ValidException;
import com.dylan.UserRegisterService;
import com.dylan.constants.UserCodeConstants;
import com.dylan.dto.RegisterRequest;
import com.dylan.dto.RegisterResponse;
import com.dylan.userprovidersss.dal.dao.UserDao;
import com.dylan.userprovidersss.dal.model.User;
import com.dylan.userprovidersss.utils.ExceptionProcessUtil;
import com.dylan.utils.UtilsDate;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.ValidationException;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 21:51
 */
@Service
@Slf4j
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private UserDao userDao;
    private RegisterResponse registerResponse = null;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        log.info("UserRegisterServiceImpl.register request -> "+ registerRequest.toString());
        try {
            registerResponse = new RegisterResponse();
            //参数校验
            registerRequest.requestCheck();
            //检查用户是否存在
            checkUserNameExists(registerRequest);
            registerRequest.setMakeTime(UtilsDate.getCurrentTime());
            registerRequest.setModifyTime(UtilsDate.getCurrentTime());
            if (userDao.insert(registerRequest) >0){
                registerResponse.setCode(UserCodeConstants.SUCCESS.getCode());
                registerResponse.setMsg(UserCodeConstants.SUCCESS.getMessage());
            }else{
                registerResponse.setCode(UserCodeConstants.REGISTER_ERROR.getCode());
                registerResponse.setMsg(UserCodeConstants.REGISTER_ERROR.getMessage());
            }
        }catch (Exception e ){
            log.error("UserRegisterServiceImpl.register occur exception - > "+e);
            ExceptionProcessUtil.exceptionProcessHandle(registerResponse,e);
        }

        return registerResponse;
    }

    private void checkUserNameExists(RegisterRequest registerRequest) throws ValidationException {

        User result = userDao.isExistsUserName(registerRequest.getUserName());
        if (result !=null ) {
            throw new ValidException(UserCodeConstants.NAME_EXISTS.getCode(),UserCodeConstants.NAME_EXISTS.getMessage());
        }
    }
}
