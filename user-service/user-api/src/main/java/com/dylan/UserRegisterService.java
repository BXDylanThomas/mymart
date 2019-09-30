package com.dylan;

import com.dylan.dto.RegisterRequest;
import com.dylan.dto.RegisterResponse;

public interface UserRegisterService {

    RegisterResponse register(RegisterRequest registerRequest) throws Exception;
}
