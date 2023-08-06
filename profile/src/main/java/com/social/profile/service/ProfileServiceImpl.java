package com.social.profile.service;

import com.social.profile.model.Profile;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.RETRIEVE_PROFILE_NAMES;
import static com.social.profile.service.constants.LoggerConstants.RETRIEVE_PROFILE_TEMPLATE;
import static com.social.profile.service.constants.ServiceConstants.AUTHOR_NAME_TEMPLATE;

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
    public String findProfileNames(String userIdentity) {
        String names = String.format(AUTHOR_NAME_TEMPLATE,
                profileRepository.findProfileFirstName(userIdentity),
                profileRepository.findProfileLastName(userIdentity));
        log.info(String.format(RETRIEVE_PROFILE_NAMES, userIdentity));
        return names;
    }
}
