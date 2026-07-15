package com.joinin.gateway.service.contract;

import com.join_in.common_models.RegisterUserMVCRq;

public interface IdentityService {
    void registerUser(RegisterUserMVCRq registerUserMVCRq);

    boolean isEmailUnique(String email);
}
