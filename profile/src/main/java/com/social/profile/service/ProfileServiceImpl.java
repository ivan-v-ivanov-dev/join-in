package com.social.profile.service;

import com.social.profile.model.Profile;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.RETRIEVE_PROFILE_TEMPLATE;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findByIdentity(String identity) {
        Profile profile = profileRepository.findByIdentity(identity);
        log.info(String.format(RETRIEVE_PROFILE_TEMPLATE, profile.getIdentity()));
        return profile;
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

}
