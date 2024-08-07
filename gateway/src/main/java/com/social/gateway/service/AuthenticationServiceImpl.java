package com.social.gateway.service;

import com.social.gateway.service.contract.AuthenticationService;
import com.social.gateway.service.feign.AuthenticationClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import static com.social.gateway.service.constants.ExceptionConstants.AUTHENTICATION_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.gateway.service.constants.LoggerConstants.USER_LOGGED_TEMPLATE;
import static com.social.gateway.service.constants.LoggerConstants.USER_REGISTERED_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationClient authenticationClient;

    @Override
    public String login(String email, String password) {
        try {
            String login = authenticationClient.login(email, password);
            log.info(format(USER_LOGGED_TEMPLATE, login));
            return login;
        } catch (IllegalArgumentException illegalArgumentException) {
            log.warn(illegalArgumentException.getMessage());
            throw illegalArgumentException;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(AUTHENTICATION_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public void register(String email, String password) {
        try {
            authenticationClient.register(email, password);
            log.info(format(USER_REGISTERED_TEMPLATE, email));
        }catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(AUTHENTICATION_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }
}
