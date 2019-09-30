package com.dylan.userprovidersss;

import com.alibaba.fastjson.JSONObject;
import com.dylan.UserLoginService;
import com.dylan.dto.LoginRequest;
import com.dylan.dto.LoginResponse;
import com.dylan.dto.UserAbstractResponse;
import com.dylan.userprovidersss.bootstrap.UserProvidersssApplication;
import com.dylan.userprovidersss.dal.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserProvidersssApplication.class)
public class UserProvidersssApplicationTests {

    @Autowired
    private UserLoginService userLoginService;
    @Test
    public void contextLoads() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("1");
//        loginRequest.setPassword("1");
        UserAbstractResponse login = userLoginService.login(loginRequest);
        String s = JSONObject.toJSONString(login);
        System.out.println(s);
        System.out.println("结果"+login.toString());
    }

    @Test
    public void test2(){

    }
}
