package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.RegisterRq;

public interface IdentityService {
    boolean isEmailUnique(String email);

    void register(RegisterRq registerRq);
}
