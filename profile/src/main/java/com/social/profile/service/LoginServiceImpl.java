package com.social.profile.service;

import com.social.profile.service.contracts.LoginService;
import com.social.profile.service.feign.LoginClient;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginClient loginClient;

    public LoginServiceImpl(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    @Override
    public String login(String email, String password) {
        return loginClient.authenticate(email, password);
    }
}
