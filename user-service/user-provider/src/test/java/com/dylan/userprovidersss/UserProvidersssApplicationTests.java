package com.dylan.userprovidersss;

import com.dylan.UserLoginService;
import com.dylan.dto.LoginRequest;
import com.dylan.dto.LoginResponse;
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
        loginRequest.setPassword("1");
        LoginResponse login = userLoginService.login(loginRequest);
        System.out.println(login.toString());
    }

}
