package com.social.gateway.service.contract;

import com.social.model.dto.RegisterUserRq;

public interface AuthenticationService {
    String login(String email, String password);

    void logout(String userIdentity);

    void register(RegisterUserRq registerUserRq);
}
