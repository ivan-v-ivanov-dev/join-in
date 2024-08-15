package com.social.mvc.service;

import com.social.mvc.service.contract.AuthenticationService;
import com.social.mvc.service.feign.GatewayClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import static com.social.mvc.service.constants.LoggerConstants.USER_LOGGED_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final GatewayClient gatewayClient;

    @Override
    public String login(String email, String password) {
        try {
            String userIdentity = gatewayClient.login(email, password);
            log.info(format(USER_LOGGED_TEMPLATE, userIdentity));
            return userIdentity;
        } catch (IllegalArgumentException | ResourceAccessException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }
}
