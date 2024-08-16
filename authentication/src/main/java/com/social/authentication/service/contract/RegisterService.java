package com.social.authentication.service.contract;


public interface RegisterService {

    void register(String identity, String email, String password);
}
