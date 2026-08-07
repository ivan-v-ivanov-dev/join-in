package com.joinin.mvc.service;

import com.join_in.common_models.ProfileRpGatewayService;
import com.joinin.mvc.mappers.ProfileMapper;
import com.joinin.mvc.model.Profile;
import com.joinin.mvc.service.contract.ProfileService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final GatewayClient gatewayClient;
    private final ProfileMapper profileMapper;

    @Override
    public Profile retrieveProfileByIdentity(String identity) {
        ProfileRpGatewayService profileRpGatewayService = gatewayClient.retrieveProfileByIdentity(identity);
        log.info("Retrieve profile by identity from API gateway: " + profileRpGatewayService.identity());
        return profileMapper.fromProfileRpGatewayServicetoProfile(profileRpGatewayService);
    }

    @Override
    public String retrieveProfileNames(String identity) {
        String names = gatewayClient.retrieveProfileNames(identity);
        log.info("Retrieve profile names: " + names);
        return names;
    }
}
