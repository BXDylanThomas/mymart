package com.dylan;

import com.dylan.dto.*;

public interface UserLoginService {

    UserAbstractResponse login(LoginRequest loginRequest);

    UserAbstractResponse update(UserUpdateRequest userUpdateRequest);
}
