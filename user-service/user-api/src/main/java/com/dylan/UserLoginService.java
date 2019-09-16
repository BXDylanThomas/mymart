package com.dylan;

import com.dylan.dto.LoginRequest;
import com.dylan.dto.LoginResponse;
import com.dylan.dto.UserUpdateRequest;
import com.dylan.dto.UserUpdateResponse;

public interface UserLoginService {

    LoginResponse login(LoginRequest loginRequest);

    UserUpdateResponse update(UserUpdateRequest userUpdateRequest);
}
