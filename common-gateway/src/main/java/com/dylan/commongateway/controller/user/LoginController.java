package com.dylan.commongateway.controller.user;

import com.dylan.UserLoginService;
import com.dylan.dto.LoginRequest;
import com.dylan.dto.LoginResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 14:45
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Reference
    private UserLoginService userLoginService;

    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

    @PostMapping("/login")
    public String login(String userName,String password){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName(userName);
        loginRequest.setPassword(password);
        LoginResponse reponse = userLoginService.login(loginRequest);
        return "user/login";
    }
}
