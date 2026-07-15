package com.joinin.mvc.service;

import com.join_in.common_models.RegisterUserMVCRq;
import com.joinin.mvc.mappers.RegisterUserMapper;
import com.joinin.mvc.model.RegisterRq;
import com.joinin.mvc.service.contract.IdentityService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class IdentityServiceImpl implements IdentityService {

    private final GatewayClient gatewayClient;
    private final RegisterUserMapper registerUserMapper;

    @Override
    public boolean isEmailUnique(String email) {
        boolean isEmailUnique = gatewayClient.isEmailUnique(email);
        log.info("Check whether email is unique: " + email);
        return isEmailUnique;
    }

    @Override
    public void register(RegisterRq registerRq) {
        RegisterUserMVCRq registerUserMVCRq = registerUserMapper.fromRegisterRqtoRegisterUserMVCRq(registerRq);
        gatewayClient.registerUser(registerUserMVCRq);
        log.info("Send new registered user to API Gateway : " + registerUserMVCRq.getFirstName());
    }
}
