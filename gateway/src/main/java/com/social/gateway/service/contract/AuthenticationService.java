package com.social.gateway.service.contract;

public interface AuthenticationService {
    String login(String email, String password);

    void register(String email, String password);
}
