package com.joinin.profile.service;

import com.join_in.common_models.ProfileRpProfileService;
import com.joinin.profile.mapper.ProfileMapper;
import com.joinin.profile.models.Profile;
import com.joinin.profile.repository.ProfileRepository;
import com.joinin.profile.service.contract.ProfileService;
import com.joinin.profile.service.feign.IdentityServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private
    final IdentityServiceClient identityServiceClient;

    @Override
    public void save(Profile profile) {
        Profile savedProfile = profileRepository.save(profile);
        log.info("Profile saved in database. Profile identity: " + savedProfile.getIdentity());
    }

    @Override
    public ProfileRpProfileService retrieveProfileByIdentity(String identity) {
        Profile profile = profileRepository.retrieveProfileByIdentity(identity);
        log.info("Retrieve profile by identity: " + profile.getIdentity());
        String email = identityServiceClient.retrieveEmailByIdentity(identity);
        log.info("Retrieve email from Identity Service by profile identity: " + email);
        return profileMapper.fromProfiletoProfileRpProfileService(profile, email);
    }
}
