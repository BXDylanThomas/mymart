package com.dylan;

import com.dylan.dto.LoginRequest;
import com.dylan.dto.LoginResponse;

public interface UserLoginService {

    LoginResponse login(LoginRequest loginRequest);
}
