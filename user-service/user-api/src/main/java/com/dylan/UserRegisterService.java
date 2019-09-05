package com.dylan;

import com.dylan.dto.LoginRequest;
import com.dylan.dto.LoginResponse;
import com.dylan.dto.RegisterRequest;
import com.dylan.dto.RegisterResponse;

public interface UserRegisterService {

    RegisterResponse register(RegisterRequest registerRequest);
}
