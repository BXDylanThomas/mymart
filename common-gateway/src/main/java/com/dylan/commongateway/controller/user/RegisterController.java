package com.dylan.commongateway.controller.user;

import com.dylan.UserRegisterService;
import com.dylan.dto.RegisterRequest;
import com.dylan.dto.RegisterResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/3 20:09
 */

@Controller
@RequestMapping("/user")
public class RegisterController {
    @Reference
    private UserRegisterService userRegisterService;

    @RequestMapping("/register")
    public String register(){
        return "user/register";
    }

    @PostMapping("/register")
    public String register(String username,String sex,String password){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName(username);
        registerRequest.setSex(sex);
        registerRequest.setPassword(password);
        RegisterResponse response = userRegisterService.register(registerRequest);
        System.out.println(response.toString());
        return "/user/login";
    }

}

