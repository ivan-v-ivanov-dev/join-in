package com.social.profile.service.contracts;

public interface AuthenticationService {
    String login(String email, String password);

    void logout(String userIdentity);
}
