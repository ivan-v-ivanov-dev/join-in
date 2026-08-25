package com.joinin.gateway.service;

import com.join_in.common_models.EditProfileGatewayRq;
import com.join_in.common_models.ProfileRpGatewayService;
import com.join_in.common_models.ProfileRpProfileService;
import com.joinin.gateway.mapper.ProfileMapper;
import com.joinin.gateway.service.contract.ProfileService;
import com.joinin.gateway.service.feign.ProfileServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileServiceClient profileServiceClient;
    private final ProfileMapper profileMapper;

    @Override
    public ProfileRpGatewayService retrieveProfileByIdentity(String identity) {
        ProfileRpProfileService profileRpProfileService = profileServiceClient.retrieveProfileByIdentity(identity);
        log.info("Retrieve Profile by identity from Profile Service. Profile identity: " + profileRpProfileService.identity());
        return profileMapper.fromProfileRpProfileServicetoProfileRpGatewayService(profileRpProfileService);
    }

    @Override
    public String retrieveProfileNames(String identity) {
        String names = profileServiceClient.retrieveProfileNames(identity);
        log.info("Retrieve profile names: " + names);
        return names;
    }

    @Override
    public void editProfile(String identity, EditProfileGatewayRq editProfileGatewayRq, MultipartFile profileImage, MultipartFile backgroundImage) {
        //TODO Implement
        log.info(editProfileGatewayRq.toString());
        if (!profileImage.isEmpty()) {
            log.info("Profile Image intact");
        }
        if (backgroundImage.isEmpty()) {
            log.info("Background Image is NULL");
        }
    }
}
