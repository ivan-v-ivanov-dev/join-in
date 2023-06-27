package com.social.authentication.service.contract;

import java.net.ConnectException;

public interface LoginService {
    void login(String email, String password) throws ConnectException;
}
