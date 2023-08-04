package com.social.profile.service;

import com.social.profile.service.contracts.LoginService;
import com.social.profile.service.feign.LoginClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import static com.social.profile.service.constants.ExceptionConstants.AUTHENTICATION_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.profile.service.constants.LoggerConstants.USER_LOGGED_TEMPLATE;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final LoginClient loginClient;

    public LoginServiceImpl(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    @Override
    public String login(String email, String password) {
        try {
            String userIdentity = loginClient.authenticate(email, password);
            log.info(String.format(USER_LOGGED_TEMPLATE, userIdentity));
            return userIdentity;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(AUTHENTICATION_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }
}
