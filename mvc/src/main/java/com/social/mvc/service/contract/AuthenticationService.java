package com.social.mvc.service.contract;

import com.social.mvc.model.Register;

public interface AuthenticationService {
    String login(String email, String password);

    void logout(String userIdentity);

    void register(Register register);
}
